import java.io.*;
import java.util.*;
import java.lang.reflect.Field;
private int totalHot;
private int totalCold;
private int totalSmall;
private int totalMedium;
private int totalVenti;
private int totalCoffee;
private int totalChocolate;
private int totalTea;
private int totalOther;
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
            /*n.add(String.valueOf(productsSales));
            n.add(String.valueOf(products));*/
            return n;
    }
    public ArrayList<Transaction> data() {
            Inventory f = new Inventory();
            return f.readTransactions("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\transactions.dat"); //returns data from .dat file as arraylist
    }

    public void displayReport(){
      ArrayList<Transaction> transactions = data();

      for (int i = 0; i < transactions.size(); i++) {
              Ingredient current = transactions.get(i);
      }

      for(int x = 0; x < current.getSales(); x++){//Determines the most selled "temperature" drink
            if(current.getTemperature().equals("Hot")){
                totalHot += 1;
            }
            else
                totalCold +=1;
      }

      for(int x = 0; x < current.getSales(); x++){//Determines the most selled size
            if(current.getDrinkSize().equals("small")){
                totalSmall += 1;
            }
            else
            if(current.getDrinkSize().equals("medium")){
                totalMedium += 1;
            }
            else
                totalVenti += 1;
      }

      for(int y = 0; y < current.getSales(); y++){
           if(current.getProduct().equals("Coffee")){
                totalCoffee += 1;
           }
           else
           if(current.getProduct().equals("Chocolate")){
                totalChocolate += 1;
           }
           else
           if(current.getTea().equals("Tea")){
                totalTea += 1;
           }
           else
                totalOther += 1;
      }
  }
}
