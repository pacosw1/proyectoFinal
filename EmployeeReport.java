import java.io.*;
import java.util.*;
import java.lang.reflect.Field;
class EmployeeReport extends Report{
  private double hoursWorkedDaily;
  //Construct
  public EmployeeReport(CurrentDate date, String title, String path){
      super(date, title , path);
  }
  //Set
  //Get
  //Methods
  public void saveReport() {
     Json save = new Json();
    save.saveReport(names(),values(),path);
  }

  public ArrayList<String> names(){
          ArrayList<String> name = new ArrayList<String>();
          Field[] f = TransactionReport.class.getDeclaredFields();
          for (int i = 0; i < f.length; i++) {
                  name.add((String)f[i].getName());
          }
          return name;
  }
  @Override
  public String toString() {
    //Values
    path += "EmployeeReport" +reportCount +".json";
    saveReport();
    reportCount++;

    return "EmployeeReport ";
  }

  public ArrayList<String> values() {
          ArrayList<String> n = new ArrayList<String>();
          n.add(String.valueOf(totalCost));
          n.add(String.valueOf(totalPrice));
          n.add(String.valueOf(bestProduct));
          n.add(String.valueOf(profit));
          n.add(String.valueOf(losses));
          n.add(String.valueOf(profitMargin));
          return n;
  }

  public ArrayList<Transaction> data() {
    Inventory f = new Inventory();
        return f.readTransactions(path + "employee.dat"); //returns data from .dat file as arraylist
  }
  //Methods
  public void dailyPayment(){

     System.out.print("How many hours did employee " + name + " work on " + day + ":");
     double hours = Lectura.readDouble();

     payment[x] += (hours * salary);

     for(int x = 0; x < 7; x++){
        switch(x){
          case 0: day = "Monday";
                  System.out.print("How many hours did employee " + name + " work on " + day + ":");
                  double hours = Lectura.readDouble();

                  payment[x] += (hours * salary);
                  break;
          case 1: day = "Tuesday";
                  break;
          case 2: day = "Wednesday";
                  break;
          case 3: day = "Thursday";
                  break;
          case 4: day = "Friday";
                  break;
          case 5: day = "Saturday";
                  break;
          case 6: day = "Sunday";
                  break;
         }
         System.out.print("\nPayment on " + day + ": " + payment[x]);
      }
    }
  }
}
