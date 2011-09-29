package collections;

import java.sql.Time;
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
            map.put((E) value, (T) value);
        }
    }
    
    public void search() {
        for (String value : searchValues) {
            map.containsValue((T) value);
        }
    }

    public void remove() {
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
}
