package collections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import util.OpenFile;

/**
 *
 * @author geovane
 */
public class ListBenchmark<E> extends collections.Collections{

    private List<E> arrayList;
    private List<E> vectorList;
    private List<E> linkedList;

    private String values[];

    public ListBenchmark() throws IOException {
        arrayList = new ArrayList();
        vectorList = new Vector();
        linkedList = new LinkedList();
        values = new OpenFile().getNumbers();
    }

    public void insert() {

    }

    public void insertColl(List<E> list) {
        for (String value : values) {
            list.add((E) value);
        }
        //
    }

    @Override
    public void search() {

    }

    public void searchColl(List<E> list, String[] values) {
        for (String string : values) {
            list.contains((E) string);
        }
    }

    @Override
    public void remove() {

    }

    @SuppressWarnings("element-type-mismatch")
    public void removeColl(List<E> list) {
        for (String value : values) {
            list.remove(value);
        }
    }
}
