import java.lang.reflect.Field;
import java.io.*;
import java.util.*;
class ManagerReport extends Report{
  private int totalEmployees;
  private byte skip;//Determines if the first 'if' has been executed
  private Json save;
  private SaveToFile f;
  //Construct
  public ManagerReport(CurrentDate date, String title, String path) {
          super(date, title, path);
          setSave(save);
          setF(f);
  }
  //Set
  public void setSave(Json save){
          this.save = save;
  }
  public void setF(SaveToFile f){
          this.f = f;
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
  Employee f = new Employee();
        return f.readEmployee(path + "C:\\Users\\Mario\\Desktop\\employee.dat"); //returns data from .dat file as arraylist
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
          return n;
  }
  public void employeeMonth(){//Object Array Employee
    ArrayList<Employee> employee = data();
    Employee current = employee.get(0);
    
    for(int i = 0; i < employee.size();i++){
       current = employee.get(i);//Gets Employee i from arraylist, current may need to be array
       totalEmployees += 1;
    }
    
    double initial = current.getHours();//Obtains the first's Employee hours...Employee hours doesn't exist in .dat
    double highestHours = 0;
    
    for(int j = 1; j < totalEmployees; j++) {
      if(current.getHours() < initial && skip == 0) {
          highestHours = current.getHours();
          skip = 1;
    }
    else if(highestHours < current.getHours())
      highestHours = current.getHours();
    }

  }

}
