class Suggestions {
private CurrentDate date;
private String complaint;
private String type;


//Construct
public Suggestions(String complaint,CurrentDate date){
        setComplaint(complaint);
        setDate(date);
}
//Get

	public CurrentDate getDate() {
		return date;
	}

	public String getComplaint() {
		return complaint;
	}
//Set

	public void setDate(CurrentDate date) {
		this.date = date;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

}
// if (type.contains("negativo"))
//else if (tpye.contains("psotivo"))
