package benchmark;

import collections.Collections;
import java.io.IOException;

/**
 *
 * @author geovane
 */
public class Benchmark {
    private Long initDiff[] = new Long[9];
    private Long searchDiff[] = new Long[9];
    private Long removeDiff[] = new Long[9];
    private Collections cBenchmark;

    public Benchmark() throws IOException {
        cBenchmark = new Collections();
    }

    public Long[] insertBenchmark() {
        cBenchmark.insert();
        for (int i = 0; i < 9; i++) {
            initDiff[i] = cBenchmark.getInsertEndt()[i] - cBenchmark.getInsertInit()[i];
        }
        return initDiff;
    }

    public Long[] searchBenchmark() {
        cBenchmark.insert();
        for (int i = 0; i < 9; i++) {
            searchDiff[i] = cBenchmark.getInsertEndt()[i] - cBenchmark.getInsertInit()[i];
        }
        return searchDiff;
    }

    public Long[] removeBenchmark() {
        cBenchmark.insert();
        for (int i = 0; i < 9; i++) {
            removeDiff[i] = cBenchmark.getInsertEndt()[i] - cBenchmark.getInsertInit()[i];
        }
        return removeDiff;
    }

}
