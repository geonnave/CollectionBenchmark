package collections;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author geovane
 */
public class SetBenchmark<E> extends collections.CollectionsBenchmark {

    private Set<E> hashSet;
    private Set<E> linkedHashSet;
    private Set<E> treeSet;

    public SetBenchmark() throws IOException {
        hashSet = new HashSet();
        linkedHashSet = new LinkedHashSet();
        treeSet = new TreeSet();
    }

    public void insert() {
        getInsertTime(0).setInit(System.currentTimeMillis());
        insertSet(hashSet);
        getInsertTime(0).setEnd(System.currentTimeMillis());
        getInsertTime(1).setInit(System.currentTimeMillis());
        insertSet(linkedHashSet);
        getInsertTime(1).setEnd(System.currentTimeMillis());
        getInsertTime(2).setInit(System.currentTimeMillis());
        insertSet(treeSet);
        getInsertTime(2).setEnd(System.currentTimeMillis());
    }

    private void insertSet(Set<E> list) {
        for (String value : getValues()) {
            list.add((E) value);
        }
    }

    @Override
    public void search() {
        getSearchTime(0).setInit(System.currentTimeMillis());
        searchSet(hashSet, getValues());
        getSearchTime(0).setEnd(System.currentTimeMillis());
        getSearchTime(1).setInit(System.currentTimeMillis());
        searchSet(linkedHashSet, getValues());
        getSearchTime(1).setEnd(System.currentTimeMillis());
        getSearchTime(2).setInit(System.currentTimeMillis());
        searchSet(treeSet, getValues());
        getSearchTime(2).setEnd(System.currentTimeMillis());
    }

    private void searchSet(Set<E> list, String[] values) {
        for (String string : values) {
            list.contains((E) string);
        }
    }

    @Override
    public void remove() {
        getRemoveTime(0).setInit(System.currentTimeMillis());
        removeSet(hashSet);
        getRemoveTime(0).setEnd(System.currentTimeMillis());
        getRemoveTime(1).setInit(System.currentTimeMillis());
        removeSet(linkedHashSet);
        getRemoveTime(1).setEnd(System.currentTimeMillis());
        getRemoveTime(2).setInit(System.currentTimeMillis());
        removeSet(treeSet);
        getRemoveTime(2).setEnd(System.currentTimeMillis());
    }

    @SuppressWarnings("element-type-mismatch")
    private void removeSet(Set<E> list) {
        for (String value : getValues()) {
            list.remove(value);
        }
    }
}
