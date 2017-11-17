import java.io.*;
class Employee {//On main ask Hours worked per employee
private double hoursWorkedDaily;
//Construct
public Employee(double totalPayment, double totalHours, String name, int numberEmployees, String suggestionEmployee, String[] suggestionClients, int clients, double[] payment){
        setTotalPayment(totalPayment);
        setName(name);
        setTotalHours(totalHours);
        setNumberEmployees(numberEmployees);
        setSuggestionEmployee(suggestionEmployee);
        setSuggestionClients(suggestionClients);
        setClients(clients);
        setPayment(payment);
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
public void setPayment(double[] payment){
        this.payment = payment;
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
public double[] getPayment(){
        return payment;
}
//Methods
public String employeeReport(){
        return "\nTotal Payment : " + totalPayment + "\nTotal hours worked: " + totalHours + "\nEmployee suggestion: " + suggestionEmployee;
}
//Display
public String toString(){
String day = " ";
        System.out.println("\nEmployee: " + name);
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
           System.out.print("\nPayment on " + day + ": " + payment[x]);
        }
        System.out.println("Report: " + employeeReport());
        if(clients > 0){
           System.out.println("Client's Suggestions Report: ");
           for(int i = 0; i < clients; i++) {
                   System.out.println("Suggestion of Client " + (i + 1) + ": " + suggestionClients[i]);
           }
        }
        return "End of Report";
  }
}
