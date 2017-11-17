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
//Method: Access Reports!!!
//Display
public String toString(){
        return "";
}
}
