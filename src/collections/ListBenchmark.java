package collections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author geovane
 */
public class ListBenchmark<E> extends collections.Collections{

    private List<E> arrayList;
    private List<E> vectorList;
    private List<E> linkedList;

    public ListBenchmark() throws IOException {
        arrayList = new ArrayList();
        vectorList = new Vector();
        linkedList = new LinkedList();
    }

    public void insert() {
        getInsertTime(0).setInit(System.currentTimeMillis());
        insertColl(arrayList);
        getInsertTime(0).setEnd(System.currentTimeMillis());
        getInsertTime(1).setInit(System.currentTimeMillis());
        insertColl(vectorList);
        getInsertTime(1).setEnd(System.currentTimeMillis());
        getInsertTime(2).setInit(System.currentTimeMillis());
        insertColl(linkedList);
        getInsertTime(2).setEnd(System.currentTimeMillis());
    }

    public void insertColl(List<E> list) {
        for (String value : getValues()) {
            list.add((E) value);
        }
    }

    @Override
    public void search() {
        getSearchTime(0).setInit(System.currentTimeMillis());
        searchColl(arrayList, getValues());
        getSearchTime(0).setEnd(System.currentTimeMillis());
        getSearchTime(1).setInit(System.currentTimeMillis());
        searchColl(vectorList, getValues());
        getSearchTime(1).setEnd(System.currentTimeMillis());
        getSearchTime(2).setInit(System.currentTimeMillis());
        searchColl(linkedList, getValues());
        getSearchTime(2).setEnd(System.currentTimeMillis());
    }

    public void searchColl(List<E> list, String[] values) {
        for (String string : values) {
            list.contains((E) string);
        }
    }

    @Override
    public void remove() {
        getSearchTime(0).setInit(System.currentTimeMillis());
        removeColl(arrayList);
        getSearchTime(0).setEnd(System.currentTimeMillis());
        getSearchTime(1).setInit(System.currentTimeMillis());
        removeColl(vectorList);
        getSearchTime(1).setEnd(System.currentTimeMillis());
        getSearchTime(2).setInit(System.currentTimeMillis());
        removeColl(linkedList);
        getSearchTime(2).setEnd(System.currentTimeMillis());
    }

    @SuppressWarnings("element-type-mismatch")
    public void removeColl(List<E> list) {
        for (String value : getValues()) {
            list.remove(value);
        }
    }
}
