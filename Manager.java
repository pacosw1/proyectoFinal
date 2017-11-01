import java.io.*;
class Manager extends Employee{
    //Construct
      public Manager(double salary){
        super(salary);
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
