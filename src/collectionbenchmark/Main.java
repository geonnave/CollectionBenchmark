package collectionbenchmark;

import benchmark.Benchmark;
import collections.CollectionsBenchmark;
import collections.MapBenchmark;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import util.OpenFile;
import util.Recorder;

/**
 *
 * @author geovane
 */
public class Main {

    public static void main(String[] args) throws IOException {
//        new Recorder().populateFiles();
        OpenFile op = new OpenFile();
        String values[] = op.getNumbers();
        String searchValues[] = op.getSearchNumbers();

        CollectionsBenchmark arrayList = new CollectionsBenchmark(new ArrayList(), values, searchValues);
        CollectionsBenchmark vectorList = new CollectionsBenchmark(new Vector(), values, searchValues);
        CollectionsBenchmark linkedList = new CollectionsBenchmark(new ArrayList(), values, searchValues);
        CollectionsBenchmark hashSet = new CollectionsBenchmark(new HashSet(), values, searchValues);
        CollectionsBenchmark linkedHashSet = new CollectionsBenchmark(new LinkedHashSet(), values, searchValues);
        CollectionsBenchmark treeSet = new CollectionsBenchmark(new TreeSet(), values, searchValues);
        MapBenchmark hashMap = new MapBenchmark(new HashMap(), values, searchValues);
        MapBenchmark linkedHashMap = new MapBenchmark(new LinkedHashMap(), values, searchValues);
        MapBenchmark treeMap = new MapBenchmark(new TreeMap(), values, searchValues);

        arrayList.runInsert();
        vectorList.runInsert();
        linkedList.runInsert();
        hashSet.runInsert();
        linkedHashSet.runInsert();
        treeSet.runInsert();
        hashMap.runInsert();
        linkedHashMap.runInsert();
        treeMap.runInsert();
        
        arrayList.runSearch();
        vectorList.runSearch();
        linkedList.runSearch();
        hashSet.runSearch();
        linkedHashSet.runSearch();
        treeSet.runSearch();
        hashMap.runSearch();
        linkedHashMap.runSearch();
        treeMap.runSearch();
        
        arrayList.runRemove();
        vectorList.runRemove();
        linkedList.runRemove();
        hashSet.runRemove();
        linkedHashSet.runRemove();
        treeSet.runRemove();
        hashMap.runRemove();
        linkedHashMap.runRemove();
        treeMap.runRemove();

    }

}
