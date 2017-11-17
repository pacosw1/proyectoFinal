import java.io.*;
import java.util.*;
import java.lang.reflect.Field;
private double[][] productsSales;//1.- Size 2.- Sales
private double[] products;//if Cafe == Caliente, etc.
class TendencyReport extends Report{
    public TendencyReport(CurrentDate date, String title, String path){
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
            n.add(String.valueOf(productsSales));
            n.add(String.valueOf(products));
            return n;
    }
    public void productsSales(){

    }
    public void products(){

    }
}
