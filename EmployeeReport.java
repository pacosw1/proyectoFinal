import java.io.*;
import java.util.*;
import java.lang.reflect.Field;
class EmployeeReport extends Report{
  private double hoursWorkedDaily;
  private double dailyPayment;
  private double totalPayment;
  private int totalEmployees;
  private String[] suggestions;
  private double hoursEmployee;
  //Construct
  public EmployeeReport(CurrentDate date, String title, String path){
      super(date, title , path);
  }
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
  public ArrayList<String> values() {
          ArrayList<String> n = new ArrayList<String>();
          n.add(String.valueOf(hoursWorkedDaily));
          n.add(String.valueOf(totalPayment));
          n.add(String.valueOf(totalPayment));
          n.add(String.valueOf(suggestions));
          return n;
  }
  @Override
  public String toString() {
    //Values
    path += "EmployeeReport" +reportCount +".json";
    totalPayment();
    suggestions();
    saveReport();
    reportCount++;

    return "EmployeeReport: ";
  }

  public ArrayList<Employee> data() {
    Employee f = new Employee();
        return f.readTransactions(path + "employee.dat"); //returns data from .dat file as arraylist
  }
  //Methods
  public void totalPayment(){
  ArrayList<Employee> employee= data();
  String day = " ";

    for(int i = 0; i < employee.size();i++){
     Employee current = employee.get(i);//Gets Employee i from arraylist, current may need to be array
     totalEmployees += current;
    }
       for(int i = 0; i < totalEmployees; i++){
         for(int x = 0; x < 7; x++){
            switch(x){
              case 0: day = "Monday";
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

           hoursEmployee = current.getHours();

           payment[x] += (hoursEmployee * salary);
           totalPayment += payment[x];
           System.out.print("\nPayment on " + day + ": " + payment[x]);
        }
        System.out.println("The total payment for " + name + " is: " + totalPayment);
      }
    }
    public void suggestions(){
      ArrayList<Employee> employee= data();

      for(int i = 0; i < employee.size();i++){
       Employee current = employee.get(i);//Gets Employee i from arraylist, current may need to be array
       totalEmployees += current;
      }

      for(int x = 0; x < totalEmployees; x++){//Clients Served
         clients += current.getClients();
      }

      String[] suggestions = new String[clients];

      for(int y = 0; y < clients; y++){
        suggestions[y] = current.getClientsSuggestions();
      }
      /*System.out.println("Is there a suggestion you would like to make?");
      String suggestionEmployee = Lectura.readString();*/

      if(clients > 0){
         System.out.println("Client's Suggestions Report: ");
         for(int i = 0; i < clients; i++) {
                 System.out.println("Suggestion of Client " + (i + 1) + ": " + suggestions[i]);
         }
         System.out.println("The employee's suggestion is: " + current.getEmployeeSuggestion());
      }
      else
        System.out.println("The employee's suggestion is: " + current.getEmployeeSuggestion());
    }
  }
}
