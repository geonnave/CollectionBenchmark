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
        return time;
    }

}
