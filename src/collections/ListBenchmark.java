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
public class ListBenchmark<E> extends collections.CollectionsBenchmark{

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
        insertList(arrayList);
        getInsertTime(0).setEnd(System.currentTimeMillis());
        getInsertTime(1).setInit(System.currentTimeMillis());
        insertList(vectorList);
        getInsertTime(1).setEnd(System.currentTimeMillis());
        getInsertTime(2).setInit(System.currentTimeMillis());
        insertList(linkedList);
        getInsertTime(2).setEnd(System.currentTimeMillis());
    }

    private void insertList(List<E> list) {
        for (String value : getValues()) {
            list.add((E) value);
        }
    }

    @Override
    public void search() {
        getSearchTime(0).setInit(System.currentTimeMillis());
        searchList(arrayList, getValues());
        getSearchTime(0).setEnd(System.currentTimeMillis());
        getSearchTime(1).setInit(System.currentTimeMillis());
        searchList(vectorList, getValues());
        getSearchTime(1).setEnd(System.currentTimeMillis());
        getSearchTime(2).setInit(System.currentTimeMillis());
        searchList(linkedList, getValues());
        getSearchTime(2).setEnd(System.currentTimeMillis());
    }

    private void searchList(List<E> list, String[] values) {
        for (String string : values) {
            list.contains((E) string);
        }
    }

    @Override
    public void remove() {
        getRemoveTime(0).setInit(System.currentTimeMillis());
        removeList(arrayList);
        getRemoveTime(0).setEnd(System.currentTimeMillis());
        getRemoveTime(1).setInit(System.currentTimeMillis());
        removeList(vectorList);
        getRemoveTime(1).setEnd(System.currentTimeMillis());
        getRemoveTime(2).setInit(System.currentTimeMillis());
        removeList(linkedList);
        getRemoveTime(2).setEnd(System.currentTimeMillis());
    }

    @SuppressWarnings("element-type-mismatch")
    private void removeList(List<E> list) {
        for (String value : getValues()) {
            list.remove(value);
        }
    }
}
