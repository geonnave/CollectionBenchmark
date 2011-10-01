package util;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 *
 * @author geovane
 */
public class Time implements Cloneable{

    private Long clockInit;
    private Long clockEnd;
    private Long cpuInit;
    private Long cpuEnd;

    public Time() {
        clockInit = new Long(0);
        clockEnd = new Long(0);
        cpuInit = new Long(0);
        cpuEnd = new Long(0);
    }

    public void init() {
        clockInit = System.currentTimeMillis();
        cpuInit = getCpuTime();
    }

    public void end() {
        clockEnd = System.currentTimeMillis();
        cpuEnd = getCpuTime();
    }

    public Long getCpuTime() {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        return bean.isCurrentThreadCpuTimeSupported() ? bean.getCurrentThreadCpuTime()/1000000 : 0L;
    }

    public Long getClockDiff() {
        return clockEnd - clockInit;
    }

    public Long getCpuDiff() {
        return cpuEnd - cpuInit;
    }
    
    @Override
    public String toString() {
        return "clockTime: "+getClockDiff()+" cpuTime:"+getCpuDiff();
    }

    @Override
    public Time clone(){
        Time clone = new Time();
        clone.clockInit = this.clockInit;
        clone.clockEnd  = this.clockEnd;
        clone.cpuInit = this.cpuInit;
        clone.cpuEnd  = this.cpuEnd;
        return clone;
    }
    
    public Long getClockInit() {
        return clockInit;
    }

    public Long getClockEnd() {
        return clockEnd;
    }

    public void setClockEnd(Long end) {
        this.clockEnd = end;
    }

    public void setClockInit(Long init) {
        this.clockInit = init;
    }

    public Long getCpuEnd() {
        return cpuEnd;
    }

    public void setCpuEnd(Long cpuEnd) {
        this.cpuEnd = cpuEnd;
    }

    public Long getCpuInit() {
        return cpuInit;
    }

    public void setCpuInit(Long cpuInit) {
        this.cpuInit = cpuInit;
    }

}
