package collectionbenchmark;

import benchmark.Benchmark;
import java.io.IOException;
import util.Recorder;

/**
 *
 * @author geovane
 */
public class Main {

    public static void main(String[] args) throws IOException {
//        new Recorder().populateFiles();
        Benchmark bm = new Benchmark();
        bm.make();

        bm.calculateInsertTimes();
        System.out.println(bm);
    }

}
