package collections;

import java.util.Collection;
import util.Time;

/**
 *
 * @author geovane
 */
public abstract class Collections<E,T> {

    private Collection<E>[] collection = new Collection[3];
    private Time insertTime;
    private Time searchTime;
    private Time removeTime;
    private String values[];
    
    public Collections(Collection<E>[] collection) {
        insertTime = new Time();
        searchTime = new Time();
        removeTime = new Time();
        this.collection = collection;
    }

    public abstract void insert();
    public abstract void search();
    public abstract void remove();
    
    public Time getInsertTime() {
        return insertTime;
    }

    public Time getSearchTime() {
        return searchTime;
    }

    public Time getRemoveTime() {
        return removeTime;
    }

    public void setInsertTime(Time insertTime) {
        this.insertTime = insertTime;
    }

    public void setRemoveTime(Time removeTime) {
        this.removeTime = removeTime;
    }

    public void setSearchTime(Time searchTime) {
        this.searchTime = searchTime;
    }

}
