import java.lang.reflect.Field;
import java.io.*;
import java.util.*;
class ManagerReport extends Report{
  private int totalEmployees;
  private double highestHours;
  private byte skip;//Determines if the first 'if' has been executed
  public ManagerReport(CurrentDate date, String title, Json save, SaveToFile f, String path) {
          super(date, title, save, f, path);
  }
  public void saveReport() {
          Json save = new Json();
          save.saveReport(names(),values(),path);
  }
  @Override
  public String toString() {
          employeeMonth();
          saveReport();
          return "Employee of the Month: ";
  }

  public ArrayList<Employee> data() {
        return f.readEmployees("C:\\Users\\Mario\\Desktop\\employee.dat"); //returns data from .dat file as arraylist
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
          n.add(title);
          n.add(date.toString());
          n.add(totalEmployees);
          n.add(highestHours);
          return n;
  }
  public void employeeMonth(){//Object Array Employee
    ArrayList<Employee> employee= data();

    for(int i = 0; i < employee.size();i++){
       Manager current = employee.get(i);//Gets Employee i from arraylist, current may need to be array
       totalEmployees += current;
    }

    double initial = current.getTotalHours();//Obtains the first's Employee hours

    for(int i = 1; i < totalEmployees; i++) {
      if(toby[i].getTotalHours() < x && skip = 0) {
          highestHours = current.getTotalHours();
          skip = 1;
    }
    else if(highest < current.getTotalHours())
      highestHours = current.getTotalHours();
    }
  }

}
