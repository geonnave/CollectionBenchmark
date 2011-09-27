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
        new Recorder().populateFiles();
//        Benchmark bm = new Benchmark();
//        Long[] iBm = bm.insertBenchmark();
//        for (int i = 0; i < 9; i++)
//            System.out.println("\n" + iBm[i]);
    }

}
