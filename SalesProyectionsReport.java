import java.io.*;
import java.util.*;
import java.lang.reflect.Field;
class SalesProyectionsReport extends Report{
private long expectedTime;//Time to sell x product
private double economyGrowthRate;//Changes the cost of dollars
private Inventory inventoryProducts;
private double[] currentSales;//Total Sales per product
private double[] predefinedSales;
private double totalClientSales;
private double changeOfSales;
private int buyer;
    //Construct
    public SalesProyectionsReport(CurrentDate date, String title, String path){
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
    
    public ArrayList<Drink> drinks() {
        Inventory f = new Inventory();
        return f.readDrinks("C:\\Users\\Mario\\Documents\\GitHub\\proyectoFinal\\data\\drinks.dat"); //returns data from .dat file as arraylist
    }
    
    public ArrayList<String> values() {
            ArrayList<String> n = new ArrayList<String>();
            n.add(String.valueOf(expectedTime));
            n.add(String.valueOf(economyGrowthRate));
            n.add(String.valueOf(inventoryProducts));
            n.add(String.valueOf(currentSales));
            n.add(String.valueOf(predefinedSales));
            n.add(String.valueOf(totalClientSales));
            n.add(String.valueOf(changeOfSales));
            return n;
    }
    public ArrayList<Transaction> data() {
            Inventory f = new Inventory();
            return f.readTransactions("C:\\Users\\Mario\\Documents\\GitHub\\proyectoFinal\\data\\transactions.dat"); //returns data from .dat file as arraylist
    }
    public void predefinedSales(){//Gets from existing .dat
    ArrayList<Transaction> current = data();
      /*for(int x = 0; x < current.getCoffeeSales(); x++){

      }
      for(int y = 0; y < current.getChocolateSales(); y++){

      }
      for(int z = 0; z < current.getTeaSales(); z++){

      }
      for(int a = 0; a < current.getOtherSales(); a++){

      }*/

    }
    public void currentSales(){//Gets new sales
    ArrayList<Transaction> data = data();
    /*
      for(int x = 0; c < current.getCoffeeSales(); c++){

      }
      for(int y = 0; c < current.getChocolateSales(); c++){

      }
      for(int z = 0; c < current.getTeaSales(); c++){

      }
      for(int a = 0; c < current.getOtherSales(); c++){

      }*/
    }
    public ArrayList<Drink> totalClientSales(){
      ArrayList<Transaction> transactions = data();
      ArrayList<Drink> drinks = new ArrayList<Drink>();//Which class get names
      int coffeeSales = 0;
      int chocolateSales = 0;
      int teaSales = 0;
      int otherSales = 0;
      
      for(int x = 0; x < transactions.size(); x++){//Needs to getName for each sale
         if(drinks.getName().equals("Coffee")){
            coffeeSales += 1;
         }
         else
         if(drinks.getName().equals("Chocolate")){
            chocolateSales += 1;
         }
         else
         if(drinks.getName().equals("Tea")){
            teaSales += 1;
         }
         else
            otherSales += 1;
      }
      for(int i = 0; i < 4; i++){//Create methods for x product for sales
       switch(i){
          case 0: System.out.println("Total Coffee Sales: " + transactions.getCoffeeSales());
                  break;
          case 1: System.out.println("Total Chocolate Drink Sales: " + transactions.getChocolateSales());
                  break;
          case 2: System.out.println("Total Tea Sales: " + transactions.getTeaSales());
                  break;
          case 3: System.out.println("Total Other Drinks Sales: " + transactions.getOtherSales());
                  break;
          }
      }

   }
    public void changeOfSales(){//Compares Predefined Sales with Current Sales
      double change = 0;
          for(int i = 0; i < 4; i++){
           switch(i){
              case 0: change = predefinedSales[i] - currentSales[i];
                      if(change < 0){
                         System.out.println("There has been an increase on Coffee sales by $" + (Math.abs(change)));
                      }
                      else{
                         System.out.println("There has been a decrease on Coffee sales by $" + (change * -1));
                      }
                      break;
              case 1: change = predefinedSales[i] - currentSales[i];
                      if(change < 0){
                         System.out.println("There has been an increase on Chocolate drink sales by $" + (Math.abs(change)));
                      }
                      else{
                         System.out.println("There has been a decrease on Chocolate drink sales by $" + (change * -1));
                      }
                      break;
              case 2: change = predefinedSales[i] - currentSales[i];
                      if(change < 0){
                         System.out.println("There has been an increase on Tea sales by $" + (Math.abs(change)));
                      }
                      else{
                         System.out.println("There has been a decrease on Tea sales by $" + (change * -1));
                      }
                      break;
              case 3: change = predefinedSales[i] - currentSales[i];
                      if(change < 0){
                         System.out.println("There has been an increase on Other drinks sales by $" + (Math.abs(change)));
                      }
                      else{
                         System.out.println("There has been a decrease on Other drinks sales by $" + (change * -1));
                      }
                      break;
              }
          }
    }
    public void expectedTime(){
      ArrayList<Inventory> inventory = data();
      Inventory current = inventory.getExpectedSaleTime();
    }
    public void economyGrowth(){
      ArrayList<Transaction> transaction = data();
      Inventory current = transaction.getEconomyGrowth();
    }
    public void salesTendencies(){
      //How much has a product sold, how much is left on the inventory, what to do.
      ArrayList<Transaction> transaction = data();
      Transaction coffeeSales = transaction.getCoffeeSales();
      Transaction chocolateSales = transaction.getChocolateSales();
      Transaction teaSales = transaction.getTeaSales();
      Transaction otherSales = transaction.getOtherSales();
    }
}
