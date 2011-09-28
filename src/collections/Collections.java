package collections;

import java.io.IOException;
import java.util.Collection;
import util.OpenFile;
import util.Time;

/**
 *
 * @author geovane
 */
public abstract class Collections<E,T> {

    private Collection<E> collection[] = new Collection[3];
    private Time insertTime[] = new Time[3];
    private Time searchTime[] = new Time[3];
    private Time removeTime[] = new Time[3];
    private String values[];
    
    public Collections() throws IOException {
        for (int i = 0; i < 3; i++) {
            insertTime[i] = new Time();
            searchTime[i] = new Time();
            removeTime[i] = new Time();
        }
//        values = new OpenFile().getNumbers();
    }

    public abstract void insert();
    public abstract void search();
    public abstract void remove();

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
