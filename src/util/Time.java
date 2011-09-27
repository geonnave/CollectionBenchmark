package util;

/**
 *
 * @author geovane
 */
public class Time {

    private Long init;
    private Long end;

    public Time() {

    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public Long getInit() {
        return init;
    }

    public void setInit(Long init) {
        this.init = init;
    }

    public Long getDiff() {
        return end - init;
    }

}
