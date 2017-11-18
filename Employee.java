import java.io.*;
class Employee implements Serializable{
public Employee(){
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
