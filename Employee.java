import java.io.*;
import java.util.*;
class Employee implements Serializable{
private int hours;
private Name name;
private double salary;



	@Override
	public String toString() {
		return "Employee [hours=" + hours + ", name=" + name + ", salary=" + salary + "]";
	}

	public int getHours() {
		return hours;
	}

	public Name getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee() {
		super();
	}

	public Employee(int hours, Name name, double salary) {
		this.hours = hours;
		this.name = name;
		this.salary = salary;
	}
}
