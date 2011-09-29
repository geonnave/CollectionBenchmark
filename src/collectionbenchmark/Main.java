package collectionbenchmark;

import benchmark.Benchmark;
import collections.CollectionsBenchmark;
import collections.MapBenchmark;
import java.io.IOException;
import util.Time;
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
        final Integer REPEAT = 10;
//        new Recorder().populateFiles();
        OpenFile op = new OpenFile();
        String values[] = op.getNumbers();
        String searchValues[] = op.getSearchNumbers();

        CollectionsBenchmark arrayList      =
                new CollectionsBenchmark(new ArrayList(), values, searchValues);
        CollectionsBenchmark vectorList     =
                new CollectionsBenchmark(new Vector(), values, searchValues);
        CollectionsBenchmark linkedList     =
                new CollectionsBenchmark(new ArrayList(), values, searchValues);
        CollectionsBenchmark hashSet        =
                new CollectionsBenchmark(new HashSet(), values, searchValues);
        CollectionsBenchmark linkedHashSet  =
                new CollectionsBenchmark(new LinkedHashSet(), values, searchValues);
        CollectionsBenchmark treeSet        =
                new CollectionsBenchmark(new TreeSet(), values, searchValues);
        MapBenchmark hashMap                =
                new MapBenchmark(new HashMap(), values, searchValues);
        MapBenchmark linkedHashMap          =
                new MapBenchmark(new LinkedHashMap(), values, searchValues);
        MapBenchmark treeMap                =
                new MapBenchmark(new TreeMap(), values, searchValues);

        Time arrayListInsertT[]     = new Time[REPEAT], arrayListInsertTime;
        Time vectorListInsertT[]    = new Time[REPEAT], vectorListInsertTime;
        Time linkedListInsertT[]    = new Time[REPEAT], linkedListInsertTime;
        Time hashSetInsertT[]       = new Time[REPEAT], hashSetInsertTime;
        Time linkedHashSetInsertT[] = new Time[REPEAT], linkedHashSetInsertTime;
        Time treeSetInsertT[]       = new Time[REPEAT], treeSetInsertTime;
        Time hashMapInsertT[]       = new Time[REPEAT], hashMapInsertTime;
        Time linkedHashMapInsertT[] = new Time[REPEAT], linkedHashMapInsertTime;
        Time treeMapInsertT[]       = new Time[REPEAT], treeMapInsertTime;
        
        Time arrayListSearchT[]     = new Time[REPEAT], arrayListSearchTime;
        Time vectorListSearchT[]    = new Time[REPEAT], vectorListSearchTime;
        Time linkedListSearchT[]    = new Time[REPEAT], linkedListSearchTime;
        Time hashSetSearchT[]       = new Time[REPEAT], hashSetSearchTime;
        Time linkedHashSetSearchT[] = new Time[REPEAT], linkedHashSetSearchTime;
        Time treeSetSearchT[]       = new Time[REPEAT], treeSetSearchTime;
        Time hashMapSearchT[]       = new Time[REPEAT], hashMapSearchTime;
        Time linkedHashMapSearchT[] = new Time[REPEAT], linkedHashMapSearchTime;
        Time treeMapSearchT[]       = new Time[REPEAT], treeMapSearchTime;
        
        Time arrayListRemoveT[]     = new Time[REPEAT], arrayListRemoveTime;
        Time vectorListRemoveT[]    = new Time[REPEAT], vectorListRemoveTime;
        Time linkedListRemoveT[]    = new Time[REPEAT], linkedListRemoveTime;
        Time hashSetRemoveT[]       = new Time[REPEAT], hashSetRemoveTime;
        Time linkedHashSetRemoveT[] = new Time[REPEAT], linkedHashSetRemoveTime;
        Time treeSetRemoveT[]       = new Time[REPEAT], treeSetRemoveTime;
        Time hashMapRemoveT[]       = new Time[REPEAT], hashMapRemoveTime;
        Time linkedHashMapRemoveT[] = new Time[REPEAT], linkedHashMapRemoveTime;
        Time treeMapRemoveT[]       = new Time[REPEAT], treeMapRemoveTime;

        
        for (int i = 0; i < REPEAT; i++) {

            arrayListInsertT[i]     = arrayList.runInsert().clone();
            vectorListInsertT[i]    = vectorList.runInsert().clone();
            linkedListInsertT[i]    = linkedList.runInsert().clone();
            hashSetInsertT[i]       = hashSet.runInsert().clone();
            linkedHashSetInsertT[i] = linkedHashSet.runInsert().clone();
            treeSetInsertT[i]       = treeSet.runInsert().clone();
            hashMapInsertT[i]       = hashMap.runInsert().clone();
            linkedHashMapInsertT[i] = linkedHashMap.runInsert().clone();
            treeMapInsertT[i]       = treeMap.runInsert().clone();

            arrayListSearchT[i]     = arrayList.runSearch().clone();
            vectorListSearchT[i]    = vectorList.runSearch().clone();
            linkedListSearchT[i]    = linkedList.runSearch().clone();
            hashSetSearchT[i]       = hashSet.runSearch().clone();
            linkedHashSetSearchT[i] = linkedHashSet.runSearch().clone();
            treeSetSearchT[i]       = treeSet.runSearch().clone();
            hashMapSearchT[i]       = hashMap.runSearch().clone();
            linkedHashMapSearchT[i] = linkedHashMap.runSearch().clone();
            treeMapSearchT[i]       = treeMap.runSearch().clone();

            arrayListRemoveT[i]     = arrayList.runRemove().clone();
            vectorListRemoveT[i]    = vectorList.runRemove().clone();
            linkedListRemoveT[i]    = linkedList.runRemove().clone();
            hashSetRemoveT[i]       = hashSet.runRemove().clone();
            linkedHashSetRemoveT[i] = linkedHashSet.runRemove().clone();
            treeSetRemoveT[i]       = treeSet.runRemove().clone();
            hashMapRemoveT[i]       = hashMap.runRemove().clone();
            linkedHashMapRemoveT[i] = linkedHashMap.runRemove().clone();
            treeMapRemoveT[i]       = treeMap.runRemove().clone();
            
        }


        arrayListInsertTime     = average(arrayListInsertT);
        vectorListInsertTime    = average(vectorListInsertT);
        linkedListInsertTime    = average(linkedListInsertT);
        hashSetInsertTime       = average(hashSetInsertT);
        linkedHashSetInsertTime = average(linkedHashSetInsertT);
        treeSetInsertTime       = average(treeSetInsertT);
        hashMapInsertTime       = average(hashMapInsertT);
        linkedHashMapInsertTime = average(linkedHashMapInsertT);
        treeMapInsertTime       = average(treeMapInsertT);

        arrayListSearchTime     = average(arrayListSearchT);
        vectorListSearchTime    = average(vectorListSearchT);
        linkedListSearchTime    = average(linkedListSearchT);
        hashSetSearchTime       = average(hashSetSearchT);
        linkedHashSetSearchTime = average(linkedHashSetSearchT);
        treeSetSearchTime       = average(treeSetSearchT);
        hashMapSearchTime       = average(hashMapSearchT);
        linkedHashMapSearchTime = average(linkedHashMapSearchT);
        treeMapSearchTime       = average(treeMapSearchT);

        arrayListRemoveTime     = average(arrayListRemoveT);
        vectorListRemoveTime    = average(vectorListRemoveT);
        linkedListRemoveTime    = average(linkedListRemoveT);
        hashSetRemoveTime       = average(hashSetRemoveT);
        linkedHashSetRemoveTime = average(linkedHashSetRemoveT);
        treeSetRemoveTime       = average(treeSetRemoveT);
        hashMapRemoveTime       = average(hashMapRemoveT);
        linkedHashMapRemoveTime = average(linkedHashMapRemoveT);
        treeMapRemoveTime       = average(treeMapRemoveT);

        

        System.out.println("------INSERT TIME--------");
        System.out.println("arrayList       "+arrayListInsertTime.getDiff());
        System.out.println("vectorList      "+vectorListInsertTime.getDiff());
        System.out.println("linkedList      "+linkedListInsertTime.getDiff());
        System.out.println("hashSet         "+hashSetInsertTime.getDiff());
        System.out.println("linkedHashSet   "+linkedHashSetInsertTime.getDiff());
        System.out.println("treeSet         "+treeSetInsertTime.getDiff());
        System.out.println("hashMap         "+hashMapInsertTime.getDiff());
        System.out.println("linkedHashMap   "+linkedHashMapInsertTime.getDiff());
        System.out.println("treeMap         "+treeMapInsertTime.getDiff());

        System.out.println("------SEARCH TIME--------");
        System.out.println("arrayList       "+arrayListSearchTime.getDiff());
        System.out.println("vectorList      "+vectorListSearchTime.getDiff());
        System.out.println("linkedList      "+linkedListSearchTime.getDiff());
        System.out.println("hashSet         "+hashSetSearchTime.getDiff());
        System.out.println("linkedHashSet   "+linkedHashSetSearchTime.getDiff());
        System.out.println("treeSet         "+treeSetSearchTime.getDiff());
        System.out.println("hashMap         "+hashMapSearchTime.getDiff());
        System.out.println("linkedHashMap   "+linkedHashMapSearchTime.getDiff());
        System.out.println("treeMap         "+treeMapSearchTime.getDiff());

        System.out.println("------REMOVE TIME--------");
        System.out.println("arrayList       "+arrayListRemoveTime.getDiff());
        System.out.println("vectorList      "+vectorListRemoveTime.getDiff());
        System.out.println("linkedList      "+linkedListRemoveTime.getDiff());
        System.out.println("hashSet         "+hashSetRemoveTime.getDiff());
        System.out.println("linkedHashSet   "+linkedHashSetRemoveTime.getDiff());
        System.out.println("treeSet         "+treeSetRemoveTime.getDiff());
        System.out.println("hashMap         "+hashMapRemoveTime.getDiff());
        System.out.println("linkedHashMap   "+linkedHashMapRemoveTime.getDiff());
        System.out.println("treeMap         "+treeMapRemoveTime.getDiff());

    }

    public static Time average(Time[] time) {
        Time average = new Time();
        Long init = new Long(0), end = new Long(0);
        for (int i = 0; i < time.length; i++) {
            init += time[i].getInit();
            end += time[i].getEnd();
        }
        average.setEnd(end /= time.length);
        average.setInit(init /= time.length);
        return average;
    }

}
