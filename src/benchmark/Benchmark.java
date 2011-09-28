package benchmark;

import collections.Collections;
import collections.ListBenchmark;
import collections.MapBenchmark;
import collections.SetBenchmark;
import java.io.IOException;

/**
 *
 * @author geovane
 */
public class Benchmark {
    private Collections colls[] = new Collections[3];
    private Collections lists;
    private Collections sets;
    private Collections maps;
    private Long insertTimes[] = new Long[9];
    private Long searchTimes[] = new Long[9];
    private Long removeTimes[] = new Long[9];

    public Benchmark() throws IOException {
        lists = new ListBenchmark();
        sets = new SetBenchmark();
        maps = new MapBenchmark();
    }

    public void make() {
        lists.insert();
        sets.insert();
        maps.insert();
        lists.search();
        sets.search();
        maps.search();
//        lists.remove();
//        sets.remove();
//        maps.remove();
    }
    
    public void calculateTimes() {
        insertTimes = calculateTimes(insertTimes, "insert");
        searchTimes = calculateTimes(searchTimes, "search");
//        removeTimes = calculateTimes(removeTimes, "remove");
    }
    
    public Long[] calculateTimes(Long[] times, String type) {
        for (int i = 0; i < 9; i++) {
            if (i < 3)
                times[i] = lists.getTime(i%3, type).getDiff();
            else if(i < 6)
                times[i] = sets.getTime(i%3, type).getDiff();
            else
                times[i] = maps.getTime(i%3, type).getDiff();
        }
        return times;
    }

    @Override
    public String toString() {
        String collectionsInsertBench = stringTimes(insertTimes, "insert");
        String collectionsSearchBench = stringTimes(searchTimes, "search");
//        String collectionsRemoveBench = stringTimes(insertTimes, "remove");
        return collectionsInsertBench + collectionsSearchBench;// + collectionsRemoveBench;
    }

    private String stringTimes(Long[] time, String type) {
        String collectionsInsertBench = "";
        collectionsInsertBench += "+--------------------------------------+\n";
        collectionsInsertBench += "| Collection     |   "+type+" time       |\n";
        collectionsInsertBench += "+----------------+---------------------+\n";
        collectionsInsertBench += "  ArrayList      |   " + time[0] + "\n";
        collectionsInsertBench += "  VectorList     |   " + time[1] + "\n";
        collectionsInsertBench += "  LinkedList     |   " + time[2] + "\n";
        collectionsInsertBench += "  HashSet        |   " + time[3] + "\n";
        collectionsInsertBench += "  LinkedHashSet  |   " + time[4] + "\n";
        collectionsInsertBench += "  TreeSet        |   " + time[5] + "\n";
        collectionsInsertBench += "  HahsMap        |   " + time[6] + "\n";
        collectionsInsertBench += "  LinkedHahsMap  |   " + time[7] + "\n";
        collectionsInsertBench += "  TreeMap        |   " + time[8] + "\n";
        collectionsInsertBench += "\n\n";
        return collectionsInsertBench;
    }

    public Collections getLists() {
        return lists;
    }

    public Collections getMaps() {
        return maps;
    }

    public Collections getSets() {
        return sets;
    }


}
