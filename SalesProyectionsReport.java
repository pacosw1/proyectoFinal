import java.io.*;
import java.util.*;
import java.lang.reflect.Field;
private long expectedTime;//Time to sell x product
private double economyGrowthRate;//Changes the cost of dollars
//private Inventory inventoryProducts; <--- How it should be done.
private int inventoryProducts;
private double[] currentSales;//Total Sales per product
private double[] predefinedSales;
private double totalSales;
class SalesProyectionsReport extends Report{
    public SalesProyectionsReport(CurrentDate date, String title, String path){
          public(date, title, path);
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
            n.add(String.valueOf(expectedTime));
            n.add(String.valueOf(economyGrowthRate));
            n.add(String.valueOf(inventoryProducts));
            n.add(String.valueOf(currentSales));
            n.add(String.valueOf(predefinedSales));
            n.add(String.valueOf(totalSales));
            return n;
    }
}
