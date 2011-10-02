package collectionbenchmark;

import collections.CollectionsBenchmark;
import collections.MapBenchmark;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import util.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
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

    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public static void main(String[] args) throws IOException {
//        System.out.println("Digite o numero de vezes");
//        Scanner sc = new Scanner(System.in);
//        final Integer REPEAT = sc.nextInt();
        final Integer REPEAT = 10;
        new Recorder().populateFiles();
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

        new FileOutputStream("src/outfiles/list_clock.dat");
        new FileOutputStream("src/outfiles/set_clock.dat");
        new FileOutputStream("src/outfiles/map_clock.dat");

        PrintStream listClockPs = new PrintStream("src/outfiles/list_clock.dat");
        PrintStream setClockPs = new PrintStream("src/outfiles/set_clock.dat");
        PrintStream mapClockPs = new PrintStream("src/outfiles/map_clock.dat");

        listClockPs.print("Insert\t"+arrayListInsertTime.getClockDiff()+"\t"+vectorListInsertTime.getClockDiff()+"\t"+linkedListInsertTime.getClockDiff()+"\n");
        listClockPs.print("Search\t"+arrayListSearchTime.getClockDiff()+"\t"+vectorListSearchTime.getClockDiff()+"\t"+linkedListSearchTime.getClockDiff()+"\n");
        listClockPs.print("Remove\t"+arrayListRemoveTime.getClockDiff()+"\t"+vectorListRemoveTime.getClockDiff()+"\t"+linkedListRemoveTime.getClockDiff()+"\n");

        setClockPs.print("Insert\t"+hashSetInsertTime.getClockDiff()+"\t"+linkedHashSetInsertTime.getClockDiff()+"\t"+treeSetInsertTime.getClockDiff()+"\n");
        setClockPs.print("Search\t"+hashSetSearchTime.getClockDiff()+"\t"+linkedHashSetSearchTime.getClockDiff()+"\t"+treeSetSearchTime.getClockDiff()+"\n");
        setClockPs.print("Remove\t"+hashSetRemoveTime.getClockDiff()+"\t"+linkedHashSetRemoveTime.getClockDiff()+"\t"+treeSetRemoveTime.getClockDiff()+"\n");

        mapClockPs.print("Insert\t"+hashMapInsertTime.getClockDiff()+"\t"+linkedHashMapInsertTime.getClockDiff()+"\t"+treeMapInsertTime.getClockDiff()+"\n");
        mapClockPs.print("Search\t"+hashMapSearchTime.getClockDiff()+"\t"+linkedHashMapSearchTime.getClockDiff()+"\t"+treeMapSearchTime.getClockDiff()+"\n");
        mapClockPs.print("Remove\t"+hashMapRemoveTime.getClockDiff()+"\t"+linkedHashMapRemoveTime.getClockDiff()+"\t"+treeMapRemoveTime.getClockDiff()+"\n");


        new FileOutputStream("src/outfiles/list_cpu.dat");
        new FileOutputStream("src/outfiles/set_cpu.dat");
        new FileOutputStream("src/outfiles/map_cpu.dat");

        PrintStream listCpuPs = new PrintStream("src/outfiles/list_cpu.dat");
        PrintStream setCpuPs = new PrintStream("src/outfiles/set_cpu.dat");
        PrintStream mapCpuPs = new PrintStream("src/outfiles/map_cpu.dat");

        listCpuPs.print("Insert\t"+arrayListInsertTime.getCpuDiff()+"\t"+vectorListInsertTime.getCpuDiff()+"\t"+linkedListInsertTime.getCpuDiff()+"\n");
        listCpuPs.print("Search\t"+arrayListSearchTime.getCpuDiff()+"\t"+vectorListSearchTime.getCpuDiff()+"\t"+linkedListSearchTime.getCpuDiff()+"\n");
        listCpuPs.print("Remove\t"+arrayListRemoveTime.getCpuDiff()+"\t"+vectorListRemoveTime.getCpuDiff()+"\t"+linkedListRemoveTime.getCpuDiff()+"\n");

        setCpuPs.print("Insert\t"+hashSetInsertTime.getCpuDiff()+"\t"+linkedHashSetInsertTime.getCpuDiff()+"\t"+treeSetInsertTime.getCpuDiff()+"\n");
        setCpuPs.print("Search\t"+hashSetSearchTime.getCpuDiff()+"\t"+linkedHashSetSearchTime.getCpuDiff()+"\t"+treeSetSearchTime.getCpuDiff()+"\n");
        setCpuPs.print("Remove\t"+hashSetRemoveTime.getCpuDiff()+"\t"+linkedHashSetRemoveTime.getCpuDiff()+"\t"+treeSetRemoveTime.getCpuDiff()+"\n");

        mapCpuPs.print("Insert\t"+hashMapInsertTime.getCpuDiff()+"\t"+linkedHashMapInsertTime.getCpuDiff()+"\t"+treeMapInsertTime.getCpuDiff()+"\n");
        mapCpuPs.print("Search\t"+hashMapSearchTime.getCpuDiff()+"\t"+linkedHashMapSearchTime.getCpuDiff()+"\t"+treeMapSearchTime.getCpuDiff()+"\n");
        mapCpuPs.print("Remove\t"+hashMapRemoveTime.getCpuDiff()+"\t"+linkedHashMapRemoveTime.getCpuDiff()+"\t"+treeMapRemoveTime.getCpuDiff()+"\n");

        System.out.println("---LIST INSERT TIME----");
        System.out.println("arraylist \t" +arrayListInsertTime);
        System.out.println("vector    \t" +vectorListInsertTime);
        System.out.println("linkedlist\t" +linkedListInsertTime);

        System.out.println("---LIST SEARCH TIME----");
        System.out.println("arraylist \t" +arrayListSearchTime);
        System.out.println("vector    \t" +vectorListSearchTime);
        System.out.println("linkedlist\t" +linkedListSearchTime);

        System.out.println("---LIST REMOVE TIME----");
        System.out.println("arraylist \t" +arrayListRemoveTime);
        System.out.println("vector    \t" +vectorListRemoveTime);
        System.out.println("linkedlist\t" +linkedListRemoveTime);
    }

    public static Time average(Time[] time) {
        Time average = new Time();
        Long cInit = new Long(0), cEnd = new Long(0), cpuInit = new Long(0), cpuEnd = new Long(0);
        for (int i = 0; i < time.length; i++) {
            cInit += time[i].getClockInit();
            cEnd += time[i].getClockEnd();
            cpuInit += time[i].getCpuInit();
            cpuEnd += time[i].getCpuEnd();
        }
        average.setClockEnd(cEnd /= time.length);
        average.setClockInit(cInit /= time.length);
        average.setCpuEnd(cpuEnd /= time.length);
        average.setCpuInit(cpuInit /= time.length);
        return average;
    }

}
