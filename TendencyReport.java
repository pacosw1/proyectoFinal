import java.io.*;
import java.util.*;
import java.lang.reflect.Field;
class TendencyReport extends Report{
private int totalHot;
private int totalCold;
private int totalSmall;
private int totalMedium;
private int totalVenti;
private double totalCost;
private double totalPrice;
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
    @Override
    public String toString(){
      return " ";
    }
    public ArrayList<Transaction> data() {
            Inventory f = new Inventory();
            return f.readTransactions("C:\\Users\\Mario\\Documents\\GitHub\\proyectoFinal\\data\\transactions.dat"); //returns data from .dat file as arraylist
    }

    public void displayReport(){
    ArrayList<Transaction> data = data(); //list of transactions
    ArrayList<Drink> product; //Needs to get name from x product sold, where to get product name?
    
      double cost = 0.0; double price = 0.0;
      
      for (int i = 0; i < data.size(); i++){
              totalCost += data.get(i).cost(); //totals per transactions. Declared in transaction class
              totalPrice += data.get(i).total();
      }

      
      for(int x = 0; x < totalPrice; x++){//Determines the most selled "temperature" drink
            if(product.getName().equals("Other")){
                totalCold += 1;
            }
            else
                totalHot +=1;
      }

      for(int y = 0; y < totalPrice; y++){//Determines the most selled size
            if(data.getSize().equals("small")){
                totalSmall += 1;
            }
            else
            if(current.getSize().equals("medium")){
                totalMedium += 1;
            }
            else
                totalVenti += 1;
      }
}

   public void bestProduct(){
      ArrayList<Transaction> data = data();
      double best = 0.0; double profit = 0.0; //var declaration
      for (int i = 0; i < data.size(); i++) { //transaction array
      
         ArrayList<Drink> curr = data.get(i).getProducts(); //product array
         
         for (int j = 0; j < curr.size(); j++) {
            Drink product = (Drink)curr.get(j);
            profit = product.total() - product.cost();
            
            if (profit > best) { //checks for highest profit of all products (saves name and profit)
               bestProduct = product.getName();
            }
            
         }
      }
   }
    

}
