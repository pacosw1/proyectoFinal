import java.io.*;
import java.util.*;
import java.lang.reflect.Field;
class EmployeeReport extends Report{
  //Construct
private double hours;
private Name name;
  public EmployeeReport(CurrentDate date, String title, String path){
      super(date, title , path);
  }
  public void saveReport() {
     Json save = new Json();
    save.saveReport(names(),values(),path);
  }

  public ArrayList<String> names(){//Not sure if this is right xD
          ArrayList<String> name = new ArrayList<String>();
          name.add("title");
          name.add("date");
          Field[] f = EmployeeReport.class.getDeclaredFields();
          for (int i = 0; i < f.length; i++) {
                  name.add((String)f[i].getName());
          }
          return name;
  }
  public ArrayList<String> values() {
          ArrayList<String> n = new ArrayList<String>();
          n.add(title);
          n.add(date.toString());
          n.add(String.valueOf(hours));
          n.add(name.toString());
          return n;
  }
  @Override
  public String toString() {
    getBest();
    saveReport();
    return "Mejor Empleado\nNombre: "+name + "\nHoras De Trabajo: " + hours + "\n";
  }

  public ArrayList<Employee> data() {
            Inventory f = new Inventory();
            return f.readEmployee("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\employee.dat"); //returns data from .dat file as arraylist
  }

  public Employee getBest() {  //employee with most hours
    ArrayList<Employee> employees = data();
    int top = employees.get(0).getHours();
    int bestIndex = 0;
    for (int i = 10; i < employees.size();i++) {
        Employee curr = employees.get(i);
        if (curr.getHours() > top)
          top = curr.getHours();bestIndex = i;
    }
    Employee winner = employees.get(bestIndex);
    name = winner.getName();
    hours = top;
    return winner;
  }

  //Methods



}
