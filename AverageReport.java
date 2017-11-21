import java.io.*;
import java.util.*;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
class AverageReport extends Report{
  private double avgSale;
  private int totalSales;
    //Construct
    public AverageReport(CurrentDate date, String title, String path){
          super(date, title, path);
    }
    public void saveReport() {
            Json save = new Json();
            save.saveReport(names(),values(),path);
    }

    public ArrayList<String> names() {
            ArrayList<String> name = new ArrayList<String>();
            name.add("title");
            name.add("date");
            Field[] f = AverageReport.class.getDeclaredFields();
            for (int i = 0; i < f.length; i++) {
                    name.add((String)f[i].getName());
            }
            return name;
    }

    public ArrayList<String> values() {
      DecimalFormat two = new DecimalFormat( "#.##");
            ArrayList<String> n = new ArrayList<String>();
            n.add(title);
            n.add(date.toString());
            n.add(String.valueOf(two.format(avgSale)));
            n.add(String.valueOf(totalSales));
            return n;
    }

    public ArrayList<Transaction> data() {
            Inventory f = new Inventory();
            return f.readTransactions("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\transactions.dat"); //returns data from .dat file as arraylist
    }


       public void avg(){
       ArrayList<Transaction> data = data();
       totalSales = data.size();
       double sum = 0;
       for (int i = 0; i < data.size(); i++) { //transaction array

          Transaction curr = data.get(i); //product array
          sum+= curr.getTotal();



      }
      avgSale = sum / totalSales;
    }

	@Override
	public String toString() {
    avg();
    saveReport();
    DecimalFormat two = new DecimalFormat( "#.##" );
		return "Reporte de Venta Promedio\n" + "Venta Promedio: " + avgSale + "\nVentas Totales: " + totalSales + "\n";
	}
}
