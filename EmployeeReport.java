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
  ArrayList<Employee> data = data();
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
           /*System.out.print("How many hours did employee " + current.getName() + " work on " + day + ":");
           double hours = Lectura.readDouble();*/
           hoursEmployee = current.getHours();

           payment[x] += (hoursEmployee * salary);
           totalPayment += payment[x];
           System.out.print("\nPayment on " + day + ": " + payment[x]);
        }
        System.out.println("The total payment for " + name + " is: " + totalPayment);
      }
    }
    public void suggestions(){
      System.out.println("How many client suggestions did you get?");
      int clients = Lectura.readInt();

      String[] suggestions = new String[clients];

      for(int y = 0; y < clients; y++){
        System.out.println("What was the suggestion of client:");
        String secretSuggestion = Lectura.readString();
        suggestions[y] = secretSuggestion;
      }
      System.out.println("Is there a suggestion you would like to make?");
      String suggestionEmployee = Lectura.readString();

      if(clients > 0){
         System.out.println("Client's Suggestions Report: ");
         for(int i = 0; i < clients; i++) {
                 System.out.println("Suggestion of Client " + (i + 1) + ": " + suggestions[i]);
         }
         System.out.println("The employee's suggestion is: " + suggestionEmployee);
      }
      else
        System.out.println("The employee's suggestion is: " + suggestionEmployee);
    }
  }
}
