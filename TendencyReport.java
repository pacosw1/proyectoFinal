import java.io.*;
import java.util.*;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
class TendencyReport extends Report{
  private String bestProductA;
  private double bestProfitA;
    //Construct
    public TendencyReport(CurrentDate date, String title, String path){
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
            Field[] f = TendencyReport.class.getDeclaredFields();
            for (int i = 0; i < f.length; i++) {
                    name.add((String)f[i].getName());
            }
            return name;
    }

    public ArrayList<String> values() {
      DecimalFormat two = new DecimalFormat( "#.##" );
            ArrayList<String> n = new ArrayList<String>();
            n.add(title);
            n.add(date.toString());
            n.add(bestProductA);
            n.add(String.valueOf(two.format(bestProfitA)));
            return n;
    }

    public ArrayList<Transaction> data() {
            Inventory f = new Inventory();
            return f.readTransactions("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\transactions.dat"); //returns data from .dat file as arraylist
    }


       public void bestProduct(){
       ArrayList<Transaction> data = data();
       double bestProfit = 0.0; double profit = 0.0; String bestProfitProduct = "";//var declaration
       for (int i = 0; i < data.size(); i++) { //transaction array

          ArrayList<Drink> curr = data.get(i).getProducts(); //product array

          for (int j = 0; j < curr.size(); j++) {
             Drink product = (Drink)curr.get(j);
             profit = product.total() - product.cost();

             if (profit > bestProfit) { //checks for highest profit of all products (saves name and profit)
                bestProfitA = profit;
               bestProductA = product.getName();
             }

          }
      }
    }


	@Override
	public String toString() {
    DecimalFormat two = new DecimalFormat( "#.##" );
    bestProduct();
    saveReport();
		return "Tendencias\n" + "Mejor producto: " + bestProductA + "\nGanancia Promedio: " + two.format(bestProfitA) + "\n";
	}
}
