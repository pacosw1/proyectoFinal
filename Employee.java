import java.io.*;
class Employee{
protected double salary;
  //Construct
  public Employee(double salary){
    setSalary(salary);
  }
  //Set
  public void setSalary(double salary){
    this.salary = salary;
  }
  //Get
  public double getSalary(){
    return salary;
  }
}
