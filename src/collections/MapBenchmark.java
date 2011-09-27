package collections;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import util.OpenFile;

/**
 *
 * @author geovane
 */
public class MapBenchmark<E,T> extends collections.Collections {

    private Map<E,T> hashMap;
    private Map<E,T> linkedHashMap;
    private Map<E,T> treeMap;

    private String values[];

    public MapBenchmark() throws IOException {
        hashMap = new HashMap();
        linkedHashMap = new LinkedHashMap();
        treeMap = new TreeMap();
        values = new OpenFile().getNumbers();
    }

    public void insert() {

    }

    public void insertColl(Map<E,T> list) {
        for (String value : values) {
            list.put((E) value,(T) value);
        }
    }

    @Override
    public void search() {

    }

    public void searchColl(Map<E,T> list, String[] values) {
        for (String string : values) {
            list.containsValue((T) string);
        }
    }

    @Override
    public void remove() {

    }

    @SuppressWarnings("element-type-mismatch")
    public void removeColl(Map<E,T> list) {
        for (String value : values) {
            list.remove(value);
        }
    }
}
