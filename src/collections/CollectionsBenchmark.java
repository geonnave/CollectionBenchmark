package collections;

import java.io.IOException;
import util.OpenFile;
import util.Time;

/**
 *
 * @author geovane
 */
public abstract class CollectionsBenchmark<E,T> {

    private Time insertTime[] = new Time[3];
    private Time searchTime[] = new Time[3];
    private Time removeTime[] = new Time[3];
    private String values[];
    
    public CollectionsBenchmark() throws IOException {
        for (int i = 0; i < 3; i++) {
            insertTime[i] = new Time();
            searchTime[i] = new Time();
            removeTime[i] = new Time();
        }
        values = new OpenFile().getNumbers();
    }

    public abstract void insert();
    public abstract void search();
    public abstract void remove();

    public Time getTime(int i, String type) {
        if (i >= 0 && i < 3) {
            if (type.equals("insert"))
                return insertTime[i];
            else if (type.equals("search"))
                return searchTime[i];
            else if (type.equals("remove"))
                return removeTime[i];
        }
        return null;
    }

    public Time getInsertTime(int i) {
        if (i >= 0 && i < 3)
            return insertTime[i];
        return null;
    }

    public void setInsertTime(Time[] insertTime) {
        this.insertTime = insertTime;
    }

    public Time getRemoveTime(int i) {
        if (i >= 0 && i < 3)
            return removeTime[i];
        return null;
    }

    public void setRemoveTime(Time[] removeTime) {
        this.removeTime = removeTime;
    }

    public Time getSearchTime(int i) {
        if (i >= 0 && i < 3)
            return searchTime[i];
        return null;
    }

    public void setSearchTime(Time[] searchTime) {
        this.searchTime = searchTime;
    }

    public String[] getValues() {
        return this.values;
    }
}
