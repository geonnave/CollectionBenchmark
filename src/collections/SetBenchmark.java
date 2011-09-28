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
public class SetBenchmark<E> extends collections.Collections {

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
        insertColl(hashSet);
        getInsertTime(0).setEnd(System.currentTimeMillis());
        getInsertTime(1).setInit(System.currentTimeMillis());
        insertColl(linkedHashSet);
        getInsertTime(1).setEnd(System.currentTimeMillis());
        getInsertTime(2).setInit(System.currentTimeMillis());
        insertColl(treeSet);
        getInsertTime(2).setEnd(System.currentTimeMillis());
    }

    public void insertColl(Set<E> list) {
        for (String value : getValues()) {
            list.add((E) value);
        }
    }

    @Override
    public void search() {
        getSearchTime(0).setInit(System.currentTimeMillis());
        searchColl(hashSet, getValues());
        getSearchTime(0).setEnd(System.currentTimeMillis());
        getSearchTime(1).setInit(System.currentTimeMillis());
        searchColl(linkedHashSet, getValues());
        getSearchTime(1).setEnd(System.currentTimeMillis());
        getSearchTime(2).setInit(System.currentTimeMillis());
        searchColl(treeSet, getValues());
        getSearchTime(2).setEnd(System.currentTimeMillis());
    }

    public void searchColl(Set<E> list, String[] values) {
        for (String string : values) {
            list.contains((E) string);
        }
    }

    @Override
    public void remove() {
        getSearchTime(0).setInit(System.currentTimeMillis());
        removeColl(hashSet);
        getSearchTime(0).setEnd(System.currentTimeMillis());
        getSearchTime(1).setInit(System.currentTimeMillis());
        removeColl(linkedHashSet);
        getSearchTime(1).setEnd(System.currentTimeMillis());
        getSearchTime(2).setInit(System.currentTimeMillis());
        removeColl(treeSet);
        getSearchTime(2).setEnd(System.currentTimeMillis());
    }

    @SuppressWarnings("element-type-mismatch")
    public void removeColl(Set<E> list) {
        for (String value : getValues()) {
            list.remove(value);
        }
    }
}
