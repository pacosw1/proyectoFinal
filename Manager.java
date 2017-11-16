class Manager extends Employee {
private Employee[] toby;//Object Array for Employees
//Construct
public Manager(double payment, double totalHours, String name, int numberEmployees, String suggestionEmployee, String[] suggestionClients, int clients,Employee[] toby){
        super(payment, totalHours, name, numberEmployees, suggestionEmployee, suggestionClients, clients);
        setToby(toby);
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
public void setNumberEmployees(String numberEmployees){
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
public void setToby(Employee[] toby){
        this.toby = toby;
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
public String getNumberEmployees(){
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
public Employee[] getToby(){
        return toby;
}
//Methods
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
}
//Method: Access Reports!!!
//Display
public String toString(){
        return "";
}
}
