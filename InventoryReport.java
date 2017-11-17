import java.io.*;
import java.util.*;
import java.lang.reflect.Field;
class InventoryReport extends Report{
    private String reorderIngredients;
    private String mostUsedIngredients;
    public InventoryReport(CurrentDate date, String title, String path){
          super(date, title, path);
    }
    public void saveReport() {
            Json save = new Json();
            save.saveReport(names(),values(),path);
    }

    public ArrayList<String> names() {
            ArrayList<String> name = new ArrayList<String>();
            Field[] f = TransactionReport.class.getDeclaredFields();
            for (int i = 0; i < f.length; i++) {
                    name.add((String)f[i].getName());
            }
            return name;
    }
    public ArrayList<String> values() {
            ArrayList<String> n = new ArrayList<String>();
            n.add(String.valueOf(reorderIngredients));
            n.add(String.valueOf(mostUsedIngredients));
            return n;
    }
}
