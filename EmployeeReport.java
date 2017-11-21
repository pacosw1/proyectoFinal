import java.io.*;
import java.util.*;
import java.lang.reflect.Field;
class EmployeeReport extends Report{
  //Construct
private double hoursEmployee;
  public EmployeeReport(CurrentDate date, String title, String path){
      super(date, title , path);
  }
  public void saveReport() {
     Json save = new Json();
    save.saveReport(names(),values(),path);
  }

  public ArrayList<String> names(){//Not sure if this is right xD
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

  public ArrayList<Transaction> data() {
            Inventory f = new Inventory();
            return f.readTransactions("C:\\Users\\Mario\\Documents\\GitHub\\proyectoFinal\\data\\transactions.dat"); //returns data from .dat file as arraylist
  }
  public ArrayList<Employee> dataEmployee() {
  Employee f = new Employee();
        return f.readEmployee(path + "C:\\Users\\Mario\\Desktop\\employee.dat"); //returns data from .dat file as arraylist
  }
  
  //Methods
  public void totalPayment(){
  ArrayList<Transaction> transaction = data();
  ArrayList<Employee> employee = dataEmployee();
 
  Employee current = employee.get(0);
  
  String day = " ";
  int totalEmployees = 0;
  double salary = 7.25;
  double totalPayment = 0.00;
  double[] payment = new double[7];
  
    for(int i = 0; i < employee.size();i++){
     totalEmployees += 1;
    }
       for(int i = 0; i < totalEmployees; i++){
         Employee currE = employee.get(i);//Gets employee i from array list
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
           
           hoursEmployee = currE.getHours();

           payment[x] += (hoursEmployee * salary);
           totalPayment += payment[x];
           System.out.print("\nPayment on " + day + ": " + payment[x]);
        }
        System.out.println("The total payment for employee " + currE.getName() + " is: " + totalPayment);
      }
    }
    
    public void suggestions(){
    int clients = 0;
    
      ArrayList<Employee> employee = dataEmployee();
      
      int totalEmployees = 0;
      Employee current = employee.get(0);
      
       for(int i = 0; i < employee.size();i++){
            totalEmployees += 1;
       }
       
       for(int i = 0; i < totalEmployees;i++){
        clients += 1;
       }

      String[] suggestions = new String[clients];

      for(int y = 0; y < clients; y++){
        suggestions[y] = current.getClientsSuggestions();
      }

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

