package collections;

import java.util.Map;

/**
 *
 * @author geovane
 */
public class MapBenchmark<E, T> extends benchmark.Benchmark{

    private Map<E, T> map;
    private String[] values;
    private String[] searchValues;
    private int select = 0;
    
    public MapBenchmark(Map<E, T> map,  String[] values,  String[] searchValues) {
        this.map = map;
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
            if (value != null)
                map.put((E) value, (T) value);
        }
    }
    
    private void search() {
        for (String value : searchValues) {
            if (value != null)
                map.containsValue((T) value);
        }
    }

    private void remove() {
        for (String value : values) {
            map.remove((E) value);
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
        for (Object object : map.values()) {
            s += object + "\n";
        }
        return s;
    }
}
