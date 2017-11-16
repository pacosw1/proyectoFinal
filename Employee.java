class Employee {//On main ask Hours worked per employee
/*
   main
   import java.io.*;
   class PrincipalEmployee{
   public static void main(String[] args){
      double totalHours = 0;
      double payment = 0;
      double totalPayment = 0;
      String day = " ";
      System.out.println("What's the salary?");
      double salary = Lectura.readDouble();

      System.out.println("How many employees are there?");
      int numberEmployees = Lectura.readInt();

      for(int i = 0; i < numberEmployees; i++){
      System.out.println("Whats the name of employee " + (i + 1) + "?");
      String name = Lectura.readString();
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
       System.out.print("How many hours did employee " + name + " work on " + day + ":");
       double hours = Lectura.readDouble();

       payment = hours * salary;

       System.out.println("Payment on " + day + ": " + payment);

       totalPayment += payment;
       totalHours += hours;
      }
       System.out.println("How many client suggestions did you get?");
       int clients = Lectura.readInt();

       String[] suggestionsClients = new String[clients];

       for(int y = 0; y < clients; y++){
         System.out.println("What was the suggestion of client:");
         String secretSuggestion = Lectura.readString();
         suggestionsClients[y] = secretSuggestion;
       }
       System.out.println("Is there a suggestion you would like to make?");
       String suggestionEmployee = Lectura.readString();
       Employee tuba = new Employee(totalPayment, totalHours, name, numberEmployees, suggestionEmployee, suggestionsClients, clients);
       System.out.println(tuba);
      }
   }
}
 */
protected double totalPayment;
protected double totalHours;
protected String name;
protected String suggestionEmployee;
protected int numberEmployees;
protected String[] suggestionClients;
protected int clients;
//Construct
public Employee(double totalPayment, double totalHours, String name, int numberEmployees, String suggestionEmployee, String[] suggestionClients, int clients){
        setTotalPayment(totalPayment);
        setName(name);
        setTotalHours(totalHours);
        setNumberEmployees(numberEmployees);
        setSuggestionEmployee(suggestionEmployee);
        setSuggestionClients(suggestionClients);
        setClients(clients);
}
//Set
public void setTotalPayment(double totalPayment){
        this.totalPayment = totalPayment;
}
public void setTotalHours(double totalHours){
        this.totalHours = totalHours;
}
public void setName(String name){
        this.name = name;
}
public void setNumberEmployees(int numberEmployees){
        this.numberEmployees = numberEmployees;
}
public void setSuggestionEmployee(String suggestionEmployee){
        this.suggestionEmployee = suggestionEmployee;
}
public void setSuggestionClients(String[] suggestionClients){
        this.suggestionClients = suggestionClients;
}
public void setClients(int clients){
        this.clients = clients;
}
//Get
public double getTotalPayment(){
        return totalPayment;
}
public double getTotalHours(){
        return totalHours;
}
public String getName(){
        return name;
}
public int getNumberEmployees(){
        return numberEmployees;
}
public String getSuggestionEmployee(){
        return suggestionEmployee;
}
public String[] getSuggestionsClients(){
        return suggestionClients;
}
public int getClients(){
        return clients;
}
//Methods
public String employeeReport(){
        return "\nEmployee: " + name + "\nTotal Payment : " + totalPayment + "\nTotal hours worked: " + totalHours + "\nEmployee suggestion: " + suggestionEmployee;
}
//Display
public String toString(){
        System.out.println("Employee Report: " + employeeReport());
        System.out.println("Client's Suggestions Report: ");
        for(int i = 0; i < clients; i++) {
                System.out.println("Suggestion of Client " + (i + 1) + ": " + suggestionClients[i]);
        }
        return "End of Report";
}
}
