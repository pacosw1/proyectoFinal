class Employee {
protected double salary;
protected double hours;
protected String name;
//Construct
public Employee(double salary, double hours, String name){
        setSalary(salary);
        setName(name);
        setHours(hours);
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
//Methods
public double payment(){
  return hours * salary;
}
//Display
public String toString(){
  return "Salary:" + hours;
}
}
