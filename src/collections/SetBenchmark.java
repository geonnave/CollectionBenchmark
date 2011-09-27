package collections;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import util.OpenFile;

/**
 *
 * @author geovane
 */
public class SetBenchmark<E> extends collections.Collections {

    private Set<E> hashSet;
    private Set<E> linkedHashSet;
    private Set<E> treeSet;

    private String values[];

    public SetBenchmark() throws IOException {
        hashSet = new HashSet();
        linkedHashSet = new LinkedHashSet();
        treeSet = new TreeSet();
        values = new OpenFile().getNumbers();
    }

    public void insert() {

    }

    public void insertColl(Set<E> list) {
        for (String value : values) {
            list.add((E) value);
        }
    }

    @Override
    public void search() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void searchColl(Set<E> list, String[] values) {
        for (String string : values) {
            list.contains((E) string);
        }
    }

    @Override
    public void remove() {
        
    }

    @SuppressWarnings("element-type-mismatch")
    public void removeColl(Set<E> list) {
        for (String value : values) {
            list.remove(value);
        }
    }
}
