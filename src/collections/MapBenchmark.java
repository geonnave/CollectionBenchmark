package collections;

import java.util.Map;
import util.Time;

/**
 *
 * @author geovane
 */
public class MapBenchmark<E, T> extends benchmark.Benchmark{

    private Map<E, T> map;
    private String[] values;
    private String[] searchValues;
    private int select;
    
    public MapBenchmark(Map<E, T> map,  String[] values,  String[] searchValues) {
        this.map = map;
        this.values = values;
        this.searchValues = searchValues;
        this.select = 0;
    }

    public void setSelect(int select) {
        this.select = select;
    }

    public Time runInsert(){
        select = 1;
        start();
        return getTime();
    }

    public Time runSearch(){
        select = 2;
        start();
        return getTime();
    }

    public Time runRemove(){
        select = 3;
        start();
        return getTime();
    }

    private void insert() {
        for (String value : values) {
            map.put((E) value, (T) value);
        }
    }
    
    private void search() {
        for (String value : searchValues) {
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

    public void setSearchValues(String[] searchValues) {
        this.searchValues = searchValues;
    }

    public void setValues(String[] values) {
        this.values = values;
    }

    
}
