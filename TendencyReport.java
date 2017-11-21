import java.io.*;
import java.util.*;
import java.lang.reflect.Field;
private int totalHot;
private int totalCold;
private int totalSmall;
private int totalMedium;
private int totalVenti;
<<<<<<< HEAD
private double totalCost;
private double totalPrice;
private String bestProduct;
private String highestTemperature;
private String highestSize;

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
            n.add(String.valueOf(bestProduct));
            n.add(String.valueOf(highestSize));
            n.add(String.valueOf(highestTemperature));
            return n;
    }
    @Override
    public String toString(){
    bestProduct();
    highestSize();
    highestTemperature();
      return "TendencyReport: [BestProductSold: " + bestProduct + ", BestDrinkSizeSold: " + highestSize + ", BestDrinkTemperatureSold: " + highestTemperature + "]";
    }
    public ArrayList<Transaction> data() {
            Inventory f = new Inventory();
            return f.readTransactions("C:\\Users\\Mario\\Documents\\GitHub\\proyectoFinal\\data\\transactions.dat"); //returns data from .dat file as arraylist
    }
    
    public ArrayList<Drink> drinks() {
        Inventory f = new Inventory();
        return f.readDrinks("C:\\Users\\Mario\\Documents\\GitHub\\proyectoFinal\\data\\drinks.dat"); //returns data from .dat file as arraylist
    }
    
    public ArrayList<Drink> highestTemperature(){
    ArrayList<Transaction> data = data(); //list of transactions
    ArrayList<Drink> drinks = drinks();
    
    Drink currD = drinks.get(0);
     
    double cost = 0.0; double price = 0.0;
      
      for (int i = 0; i < data.size(); i++){
              totalCost += data.get(i).cost(); //totals per transactions. Declared in transaction class
              totalPrice += data.get(i).total();
      }
      
      
      for(int x = 0; x < totalPrice; x++){//Determines the most selled "temperature" drink
          currD = drinks.get(x);
          
            if(currD.getName().equals("Other")){
                totalCold += 1;
            }
            else
                totalHot +=1;
      }
    }
    
    public ArrayList<Drink> highestSize(){
    ArrayList<Transaction> data = data(); //list of transactions
    ArrayList<Drink> drinks = drinks();
    
    Drink currD = drinks.get(0);
    
    double cost = 0.0; double price = 0.0;
      
      for (int i = 0; i < data.size(); i++){
              totalCost += data.get(i).cost(); //totals per transactions. Declared in transaction class
              totalPrice += data.get(i).total();
      }
      
      for(int y = 0; y < totalPrice; y++){//Determines the most selled size
            currD = drinks.get(y);
            
            if(currD.getSize().equals("small")){
                totalSmall += 1;
            }
            else
            if(currD.getSize().equals("medium")){
                totalMedium += 1;
            }
            else
                totalVenti += 1;
      }
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
               bestProfit = profit;
               bestProfitProduct = product.getName();
            }
            
         }
      }
   }
    
=======
private int totalCoffee;
private int totalChocolate;
private int totalTea;
private int totalOther;
class TendencyReport extends Report {
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
public ArrayList<String> values() {     //aqui van los atributos
        ArrayList<String> n = new ArrayList<String>();
        /*n.add(String.valueOf(productsSales));
           n.add(String.valueOf(products));*/
        return n;
}
public ArrayList<Transaction> data() {
        Inventory f = new Inventory();
        return f.readTransactions("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\transactions.dat");     //returns data from .dat file as arraylist
}

public void displayReport(){
        ArrayList<Transaction> transactions = data();

        for (int i = 0; i < transactions.size(); i++) {
                Ingredient current = transactions.get(i); // esto es un transaction no un ingredient
        }

        for(int x = 0; x < current.getSales(); x++) {//Determines the most selled "temperature" drink
                if(current.getTemperature().equals("Hot")) {
                        totalHot += 1;
                }
                else
                        totalCold +=1;
        }

        for(int x = 0; x < current.getSales(); x++) {//Determines the most selled size
                if(current.getDrinkSize().equals("small")) {
                        totalSmall += 1;
                }
                else
                if(current.getDrinkSize().equals("medium")) {
                        totalMedium += 1;
                }
                else
                        totalVenti += 1;
        }
>>>>>>> a39eacfec5fd091394da76dd62bc3d128e14a646

        for(int y = 0; y < current.getSales(); y++) {
                if(current.getProduct().equals("Coffee")) {
                        totalCoffee += 1;
                }
                else
                if(current.getProduct().equals("Chocolate")) {
                        totalChocolate += 1;
                }
                else
                if(current.getTea().equals("Tea")) {
                        totalTea += 1;
                }
                else
                        totalOther += 1;
        }
}
}
