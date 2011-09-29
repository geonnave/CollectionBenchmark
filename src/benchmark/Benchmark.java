package benchmark;

import util.Time;

/**
 *
 * @author geovane
 */
public abstract class Benchmark {

    private Time time;

    public Benchmark() {
        time = new Time();
    }

    public abstract void exec();

    public void start() {
        time.init();
        exec();
        time.end();
    }

    public Time getTime() {
        return this.time;
    }











//
//
//    private CollectionsBenchmark lists;
//    private CollectionsBenchmark sets;
//    private CollectionsBenchmark maps;
//    private Long insertTimes[] = new Long[9];
//    private Long searchTimes[] = new Long[9];
//    private Long removeTimes[] = new Long[9];
//
//    public Benchmark() throws IOException {
//        lists = new ListBenchmark();
//        sets = new SetBenchmark();
//        maps = new MapBenchmark();
//    }
//
//    public void make() {
//        lists.insert();
//        sets.insert();
//        maps.insert();
//        lists.search();
//        sets.search();
//        maps.search();
//        lists.remove();
//        sets.remove();
//        maps.remove();
//    }
//
//    public void calculateTimes() {
//        insertTimes = calculateTimes(insertTimes, "insert");
//        searchTimes = calculateTimes(searchTimes, "search");
//        removeTimes = calculateTimes(removeTimes, "remove");
//    }
//
//    public Long[] calculateTimes(Long[] times, String type) {
//        for (int i = 0; i < 9; i++) {
//            if (i < 3)
//                times[i] = lists.getTime(i%3, type).getDiff();
//            else if(i < 6)
//                times[i] = sets.getTime(i%3, type).getDiff();
//            else
//                times[i] = maps.getTime(i%3, type).getDiff();
//        }
//        return times;
//    }
//
//    @Override
//    public String toString() {
//        String collectionsInsertBench = stringTimes(insertTimes, "insert");
//        String collectionsSearchBench = stringTimes(searchTimes, "search");
//        String collectionsRemoveBench = stringTimes(removeTimes, "remove");
//        return collectionsInsertBench + collectionsSearchBench + collectionsRemoveBench;
//    }
//
//    private String stringTimes(Long[] time, String type) {
//        String collectionsBench = "";
//        collectionsBench += "+--------------------------------------+\n";
//        collectionsBench += "| Collection     |   "+type+" time       |\n";
//        collectionsBench += "+----------------+---------------------+\n";
//        collectionsBench += "  ArrayList      |   " + time[0] + "\n";
//        collectionsBench += "  VectorList     |   " + time[1] + "\n";
//        collectionsBench += "  LinkedList     |   " + time[2] + "\n";
//        collectionsBench += "  HashSet        |   " + time[3] + "\n";
//        collectionsBench += "  LinkedHashSet  |   " + time[4] + "\n";
//        collectionsBench += "  TreeSet        |   " + time[5] + "\n";
//        collectionsBench += "  HahsMap        |   " + time[6] + "\n";
//        collectionsBench += "  LinkedHahsMap  |   " + time[7] + "\n";
//        collectionsBench += "  TreeMap        |   " + time[8] + "\n";
//        collectionsBench += "\n";
//        return collectionsBench;
//    }
//
//    public CollectionsBenchmark getLists() {
//        return lists;
//    }
//
//    public CollectionsBenchmark getMaps() {
//        return maps;
//    }
//
//    public CollectionsBenchmark getSets() {
//        return sets;
//    }
//
//    public Long[] getInsertTimes() {
//        return insertTimes;
//    }
//
//    public Long[] getRemoveTimes() {
//        return removeTimes;
//    }
//
//    public Long[] getSearchTimes() {
//        return searchTimes;
//    }

}
