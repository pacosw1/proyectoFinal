class Manager extends Employee {
  private String numberEmployees;
//Construct
public Manager(double salary, double hours, String name, String numberEmployees){
        super(salary, hours, name);
        setNumberEmployees(numberEmployees);
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
//Methods
public double payment(){
  return hours * salary;
}
public String employeeMonth(){
/*  int x = Integer.parseOf(numberEmployees);
  String[] employeeArray = new double[x];
  Employee employee = new Employee()
  for(int i = 0; i < x; i++){
  Manager should be Father class
  }*/
  return "Employee of Month:"
}
public String accessReports(){
  return "Reports";
}
}
