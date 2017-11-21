import java.io.*;
import java.util.*;
class Employee implements Serializable{
private double hours;
private double workingEmployees;
private String name;
private int clients;
private String clientsSuggestions;
private String employeeSuggestion;
public Employee(){
}



	public double getHours() {
		return hours;
	}

	public double getWorkingEmployees() {
		return workingEmployees;
	}

	public String getName() {
		return name;
	}

	public int getClients() {
		return clients;
	}

	public String getClientsSuggestions() {
		return clientsSuggestions;
	}

	public String getEmployeeSuggestion() {
		return employeeSuggestion;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public void setWorkingEmployees(double workingEmployees) {
		this.workingEmployees = workingEmployees;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setClients(int clients) {
		this.clients = clients;
	}

	public void setClientsSuggestions(String clientsSuggestions) {
		this.clientsSuggestions = clientsSuggestions;
	}

	public void setEmployeeSuggestion(String employeeSuggestion) {
		this.employeeSuggestion = employeeSuggestion;
	}


}
