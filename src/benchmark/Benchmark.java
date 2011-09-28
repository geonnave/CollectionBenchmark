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
        lists.remove();
        sets.remove();
        maps.remove();
    }

    public void calculateInsertTimes() {
        for (int i = 0; i < 9; i++) {
            if (i < 3)
                insertTimes[i] = lists.getInsertTime(i%3).getDiff();
            else if(i < 6)
                insertTimes[i] = sets.getInsertTime(i%3).getDiff();
            else
                insertTimes[i] = maps.getInsertTime(i%3).getDiff();
        }
    }

    @Override
    public String toString() {
        String collectionsInsertBench = stringTimes(insertTimes, "insert");
        return collectionsInsertBench;
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
