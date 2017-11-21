import java.io.*;
import java.util.*;
class Suggestion implements Serializable{
private CurrentDate date;
private String complaint;
private String type;


//Construct
public Suggestion(String complaint, String type, CurrentDate date){
        setComplaint(complaint);
        setDate(date);
        setType(type);
}
//Get

	public CurrentDate getDate() {
		return date;
	}

	public String getComplaint() {
		return complaint;
	}

	public String getType() {
		return type;
	}

	public void setDate(CurrentDate date) {
		this.date = date;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public void setType(String type) {
		this.type = type;
	}


}
// if (type.contains("negativo"))
//else if (tpye.contains("psotivo"))
