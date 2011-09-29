package util;

/**
 *
 * @author geovane
 */
public class Time implements Cloneable{

    private Long init;
    private Long end;
    private Long diff;

    public Time() {
        init = new Long(0);
        end = new Long(0);
        diff = new Long(0);
    }

    public void init() {
        init = System.currentTimeMillis();
    }

    public void end() {
        end = System.currentTimeMillis();
    }

    public Long getInit() {
        return init;
    }

    public Long getEnd() {
        return end;
    }

    public Long getDiff() {
        diff = end - init;
        return diff;
    }

    public void setDiff(Long diff) {
        this.diff = diff;
    }

    @Override
    public String toString() {
        return "init: "+getInit()+"\tend: " +getEnd()+"\tdiff: "+getDiff();
    }

    @Override
    public Time clone(){
        Time clone = new Time();
        clone.init = this.init;
        clone.end  = this.end;
        clone.diff = this.diff;
        return clone;
    }
}
