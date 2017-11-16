import java.lang.reflect.Field;
import java.io.*;
import java.util.*;
class ManagerReport extends Report{
  private Employee[] toby;
  public ManagerReport(CurrentDate date, String title, Json save, SaveToFile f, String path) {
          super(date, title, save, f, path);
  }
  /*public ArrayList<Transaction> data() {
        return f.readTransactions("C:\\Users\\paco\\Desktop\\transactions.dat"); //returns data from .dat file as arraylist
  }
  public double employeeMonth(){//Object Array Employee
          double highest = 0;
          byte skip = 0;//Determines if the first if has been executed
          double x = toby[0].getTotalHours();//Obtains the first's Employee hours
          for(int i = 1; i < numberEmployees; i++) {
                  if(toby[i].getTotalHours() < x && skip = 0) {
                          highest = toby[i].getTotalHours();
                          skip = 1;
                  }
                  else if(highest < toby[i].getTotalHours())
                          highest = toby[i].getTotalHours();
          }
          return highest;
  }*/
  public String toString(){
    return " ";
  }
}
