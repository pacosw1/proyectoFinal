class Manager extends Employee {
private int numberEmployees;
private Employee[] toby;//Object Array for Employees
//Construct
public Manager(double salary, double hours, String name, int numberEmployees, Employee[] toby){
        super(salary, hours, name);
        setNumberEmployees(numberEmployees);
        setToby(toby);
}
//Set
public void setSalary(double salary){
        this.salary = salary;
}
public void setHours(double hours){
        this.hours = hours;
}
public void setName(String name){
        this.name = name;
}
public void setNumberEmployees(String numberEmployees){
        this.numberEmployees = numberEmployees;
}
public void setToby(Employee[] toby){
        this.toby = toby;
}
//Get
public double getSalary(){
        return salary;
}
public double getHours(){
        return hours;
}
public String getName(){
        return name;
}
public String getNumberEmployees(){
        return numberEmployees;
}
public Employee[] getToby(){
        return toby;
}
//Methods
public double payment(){
  return hours * salary;
}
public double employeeMonth(){//Object Array Employee
  double highest = 0;
  byte skip = 0;//Determines if the first if has been executed
  double x = toby[0].getHours();//Obtains the first's Employee hours
  for(int i = 1; i < numberEmployees; i++){
    if(toby[i].getHours() < x && skip = 0){
      highest = toby[i].getHours();
      skip = 1;
    }
    else if(highest < toby[i].getHours())
      highest = toby[i].getHours();
  }
  return highest;
}
//Method: Access Reports!
//Display
public String toString(){
  return "";
}
}
