import java.io.*;
import java.util.*;
import java.lang.reflect.Field;
private double[] sales;
private int[] temperature;
private int[] size;
private int drinkSize;
private String displayReport;
private String reportInput;
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
    public ArrayList<Transaction> data() {
            Inventory f = new Inventory();
            return f.readTransactions("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\transactions.dat"); //returns data from .dat file as arraylist
    }
    public void reportInput(){
     double[] sales = new double[4];
     int[] temperature = new int[2];
     int[] size = new int[3];
     int drinkSize = 0;
       for(int x = 0; x < 4; x++){
           switch(x){

             case 0: System.out.println("How many sales were there for Coffee?");
                     double coffeeSales = Lectura.readDouble();
                     sales[x] += coffeeSales;
                     for(int i = 0; i < coffeeSales; i++){
                        System.out.println("Enter the price of the size chosen (small = 10, medium = 20, = venti = 30) for sale " + (i + 1));
                        drinkSize = Lectura.readInt();

                        if(drinkSize == 10){
                         size[0] += 1;
                        }
                        else if(drinkSize == 20){
                         size[1] += 1;
                        }
                        else{
                          size[2] += 1;
                        }
                     }
                     temperature[0] += 1;
                     break;
             case 1: System.out.println("How many sales were there for Chocolate?");
                     double chocolateSales = Lectura.readDouble();
                     sales[x] += chocolateSales;
                     for(int i = 0; i < chocolateSales; i++){
                        System.out.println("Enter the price of the size chosen (small = 10, medium = 20, = venti = 30) for sale " + (i + 1));
                        drinkSize = Lectura.readInt();

                        if(drinkSize == 10){
                         size[0] += 1;
                        }
                        else if(drinkSize == 20){
                         size[1] += 1;
                        }
                        else{
                          size[2] += 1;
                        }
                     }
                     temperature[0] += 1;
                     break;
             case 2: System.out.println("How many sales were there for Tea?");
                     double teaSales = Lectura.readDouble();
                     sales[x] += teaSales;
                     for(int i = 0; i < teaSales; i++){
                        System.out.println("Enter the price of the size chosen (small = 10, medium = 20, = venti = 30) for sale " + (i + 1));
                        drinkSize = Lectura.readInt();

                        if(drinkSize == 10){
                         size[0] += 1;
                        }
                        else if(drinkSize == 20){
                         size[1] += 1;
                        }
                        else{
                          size[2] += 1;
                        }
                     }
                     temperature[0] += 1;
                     break;
             case 3: System.out.println("How many sales were there for Other drinks?");
                     double otherSales = Lectura.readDouble();
                     sales[x] += otherSales;
                     for(int i = 0; i < otherSales; i++){
                        System.out.println("Enter the price of the size chosen (small = 10, medium = 20, = venti = 30) for sale " + (i + 1));
                        drinkSize = Lectura.readInt();

                        if(drinkSize == 10){
                         size[0] += 1;
                        }
                        else if(drinkSize == 20){
                         size[1] += 1;
                        }
                        else{
                          size[2] += 1;
                        }
                     }
                     temperature[0] += 1;
                     break;
          }
        }
    }
    public void displayReport(){
      if(temperature[0] > temperature[1])
         System.out.println("Popular temperature bought: Hot!");
      else
         System.out.println("Popular temperature bought: Cold!");

      if(size[0] > size[1] && size[0] > size[2]){
         System.out.println("Popular size bought: Small!");
      }
      else if(size[1] > size[0] && size[1] > size[2]){
         System.out.println("Popular size bought: Medium!");
      }
      else if(size[2] > size[0] && size[2] > size[1]){
         System.out.println("Popular size bought: Venti!");
      }

      if(sales[0] > sales[1] && sales[0] > sales[2] && sales[0] > sales[3]){
         System.out.println("Highest Product: Coffee!");
      }
      else
      if(sales[1] > sales[0] && sales[1] > sales[2] && sales[1] > sales[3]){
         System.out.println("Highest Product: Chocolate Drink!");
      }
      else
      if(sales[2] > sales[0] && sales[2] > sales[1] && sales[2] > sales[3]){
         System.out.println("Highest Product: Tea!");
      }
      else
      if(sales[3] > sales[0] && sales[3] > sales[1] && sales[3] > sales[2]){
         System.out.println("Highest Product: Others!");
      }
    }
}
