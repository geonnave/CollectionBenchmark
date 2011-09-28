package collections;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author geovane
 */
public class MapBenchmark<E,T> extends collections.Collections {

    private Map<E,T> hashMap;
    private Map<E,T> linkedHashMap;
    private Map<E,T> treeMap;

    public MapBenchmark() throws IOException {
        hashMap = new HashMap();
        linkedHashMap = new LinkedHashMap();
        treeMap = new TreeMap();
    }

    public void insert() {
        getInsertTime(0).setInit(System.currentTimeMillis());
        insertMap(hashMap);
        getInsertTime(0).setEnd(System.currentTimeMillis());
        getInsertTime(1).setInit(System.currentTimeMillis());
        insertMap(linkedHashMap);
        getInsertTime(1).setEnd(System.currentTimeMillis());
        getInsertTime(2).setInit(System.currentTimeMillis());
        insertMap(treeMap);
        getInsertTime(2).setEnd(System.currentTimeMillis());
    }

    private void insertMap(Map<E,T> list) {
        for (String value : getValues()) {
            list.put((E) value,(T) value);
        }
    }

    @Override
    public void search() {
        getSearchTime(0).setInit(System.currentTimeMillis());
        searchMap(hashMap, getValues());
        getSearchTime(0).setEnd(System.currentTimeMillis());
        getSearchTime(1).setInit(System.currentTimeMillis());
        searchMap(linkedHashMap, getValues());
        getSearchTime(1).setEnd(System.currentTimeMillis());
        getSearchTime(2).setInit(System.currentTimeMillis());
        searchMap(treeMap, getValues());
        getSearchTime(2).setEnd(System.currentTimeMillis());
    }

    private void searchMap(Map<E,T> list, String[] values) {
        for (String string : values) {
            list.containsValue((T) string);
        }
    }

    @Override
    public void remove() {
        getRemoveTime(0).setInit(System.currentTimeMillis());
        removeMap(hashMap);
        getRemoveTime(0).setEnd(System.currentTimeMillis());
        getRemoveTime(1).setInit(System.currentTimeMillis());
        removeMap(linkedHashMap);
        getRemoveTime(1).setEnd(System.currentTimeMillis());
        getRemoveTime(2).setInit(System.currentTimeMillis());
        removeMap(treeMap);
        getRemoveTime(2).setEnd(System.currentTimeMillis());
    }

    @SuppressWarnings("element-type-mismatch")
    private void removeMap(Map<E,T> list) {
        for (String value : getValues()) {
            list.remove(value);
        }
    }
}
