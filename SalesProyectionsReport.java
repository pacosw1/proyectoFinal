import java.io.*;
import java.util.*;
import java.lang.reflect.Field;
private long expectedTime;//Time to sell x product
private double economyGrowthRate;//Changes the cost of dollars
//private Inventory inventoryProducts; <--- How it should be done.
private int inventoryProducts;
private double[] currentSales;//Total Sales per product
private double[] predefinedSales;
private double totalClientSales;
private double changeOfSales;
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
            n.add(String.valueOf(totalClientSales));
            n.add(String.valueOf(changeOfSales));
            return n;
    }
    public ArrayList<Transaction> data() {
            Inventory f = new Inventory();
            return f.readTransactions("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\transactions.dat"); //returns data from .dat file as arraylist
    }
    public void predefinedSales(){
        for(int i = 0; i < 4; i++){
          switch(i){
             case 0: System.out.println("How many clients had bought coffees?");
                     buyer = Lectura.readInt();
                     double[][] coffeSalesArray = new double [4][buyer];
                     for(int x = 0; x < buyer; x++){
                        System.out.println("Total Past Coffee Sales:");
                        double predefinedCoffeeSales = Lectura.readDouble();
                        predefinedCoffeeSales *= 24;//Cafe.total();
                        coffeSalesArray[i][x] = predefinedCoffeeSales;
                        predefinedSales[i] += coffeSalesArray[i][x];
                        totalSales += predefinedSales[i];
                     }
                     break;
             case 1: System.out.println("How many clients had bought chocolate drinks?");
                     buyer = Lectura.readInt();
                     double[][] chocolateSalesArray = new double [4][buyer];
                     for(int x = 0; x < buyer; x++){
                        System.out.println("Total Past Chocolate Drink Sales:");
                        double predefinedChocolateSales = Lectura.readDouble();
                        predefinedChocolateSales *= 24;//Chocolate.total();
                        chocolateSalesArray[i][x] = predefinedChocolateSales;
                        predefinedSales[i] += chocolateSalesArray[i][x];
                        totalSales += predefinedSales[i];
                     }
                     break;
             case 2: System.out.println("How many clients had bought teas?");
                     buyer = Lectura.readInt();
                     double[][] teaSalesArray = new double [4][buyer];
                     for(int x = 0; x < buyer; x++){
                        System.out.println("Total Past Tea Sales:");
                        double predefinedTeaSales = Lectura.readDouble();
                        predefinedTeaSales *= 24;//Tea.total();
                        teaSalesArray[i][x] = predefinedTeaSales;
                        predefinedSales[i] += teaSalesArray[i][x];
                        totalSales += predefinedSales[i];
                     }
                     break;
             case 3: System.out.println("How many clients had bought Other drinks?");
                     buyer = Lectura.readInt();
                     double[][] otherSalesArray = new double [4][buyer];
                     for(int x = 0; x < buyer; x++){
                        System.out.println("Total Past Other Drinks Sales:");
                        double predefinedOthersSales = Lectura.readDouble();
                        predefinedOthersSales *= 24;//Others.total();
                        otherSalesArray[i][x] = predefinedOthersSales;
                        predefinedSales[i] += otherSalesArray[i][x];
                        totalSales += predefinedSales[i];
                     }
                     break;
             }
      }
    }
    public void currentSales(){
      for(int i = 0; i < 4; i++){
        switch(i){
           case 0: System.out.println("How many clients bought coffees?");
                   buyer = Lectura.readInt();
                   double[][] newCoffeSalesArray = new double [4][buyer];
                   for(int x = 0; x < buyer; x++){
                      System.out.println("How many coffees did client " + (buyer + 1) + " buy?");
                      double coffeeSale = Lectura.readDouble();
                      coffeeSale *= 12;//Cafe.total();
                      newCoffeSalesArray[i][x] = coffeeSale;
                      currentSales[i] += newCoffeSalesArray[i][x];
                      totalSales += currentSales[i];
                   }
                   break;
           case 1: System.out.println("How many clients bought chocolate drinks?");
                   buyer = Lectura.readInt();
                   double[][] newChocolateSalesArray = new double [4][buyer];
                   for(int x = 0; x < buyer; x++){
                      System.out.println("How many chocolate drinks did client " + (buyer + 1) + " buy?");
                      double chocolateSale = Lectura.readDouble();
                      chocolateSale *= 12;//Chocolate.total();
                      newChocolateSalesArray[i][x] = chocolateSale;
                      currentSales[i] += newChocolateSalesArray[i][x];
                      totalSales += currentSales[i];
                   }
                   break;
           case 2: System.out.println("How many clients bought teas?");
                   buyer = Lectura.readInt();
                   double[][] newTeaSalesArray = new double [4][buyer];
                   for(int x = 0; x < buyer; x++){
                      System.out.println("How many teas did client " + (buyer + 1) + " buy?");
                      double teaSale = Lectura.readDouble();
                      teaSale *= 12;//Tea.total();
                      newTeaSalesArray[i][x] = teaSale;
                      currentSales[i] += newTeaSalesArray[i][x];
                      totalSales += currentSales[i];
                   }
                   break;
           case 3: System.out.println("How many clients bought other drinks?");
                   buyer = Lectura.readInt();
                   double[][] newOtherSalesArray = new double [4][buyer];
                   for(int x = 0; x < buyer; x++){
                      System.out.println("Other products that client " + (buyer + 1) + " bought:");
                      double otherSale = Lectura.readDouble();
                      otherSale *= 12;//Others.total();
                      newOtherSalesArray[i][x] = otherSale;
                      currentSales[i] += newOtherSalesArray[i][x];
                      totalSales += currentSales[i];
                      }
                   break;
         }
       }
    }
    public void totalClientSales(){
      for(int i = 0; i < 4; i++){
       switch(i){
          case 0: System.out.println("Total Coffee Sales: " + currentSales[i]);
                  break;
          case 1: System.out.println("Total Chocolate Drink Sales: " + currentSales[i]);
                  break;
          case 2: System.out.println("Total Tea Sales: " + currentSales[i]);
                  break;
          case 3: System.out.println("Total Other Drinks Sales: " + currentSales[i]);
                  break;
          }
      }

   }
    public void changeOfSales(){
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
        System.out.println("What's the expected time to sell all products?");
        long expectedTime = Lectura.readLong();
    }
    public void economyGrowth(){
        System.out.println("What's the percentage rate of the change of the value of the dollar?");
        double economyGrowth = Lectura.readDouble();
    }
}
