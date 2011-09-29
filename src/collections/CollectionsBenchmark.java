package collections;

import java.util.Collection;

/**
 *
 * @author geovane
 */
public class CollectionsBenchmark<E> extends benchmark.Benchmark{

    private Collection<E> collection;
    private String[] values;
    private String[] searchValues;
    private int select = 0;

    public CollectionsBenchmark(Collection<E> collection,  String[] values,  String[] searchValues) {
        this.collection = collection;
        this.values = values;
        this.searchValues = searchValues;
    }

    public void setSelect(int select) {
        this.select = select;
    }

    public void runInsert(){
        select = 1;
        start();
    }

    public void runSearch(){
        select = 2;
        start();
    }

    public void runRemove(){
        select = 3;
        start();
    }

    private void insert() {
        for (String value : values) {
            collection.add((E) value);
        }
    }

    private void search() {
        for (String value : searchValues) {
            collection.contains((E) value);
        }
    }

    private void remove() {
        for (String value : values) {
            collection.remove((E) value);
        }
    }

    @Override
    public void exec() {
        if (select == 1)
            insert();
        else if (select == 2)
            search();
        else if (select == 3)
            remove();
    }

    @Override
    public String toString() {
        String s = "";
        for (Object object : collection) {
            s += object + "\n";
        }
        return s;
    }
}
