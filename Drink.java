import java.io.*;
class Drink extends Product{
  protected String size;

  //Construct
	public Drink(String size, CurrentDate timestamp) {
		super(timestamp);
		setSize(size);
	}
  //Set
  public void setTimestamp(CurrentDate timestamp){
    this.timestamp = timestamp;
  }
  public void setSize(String size) {
    this.size = size;
  }
  //Get
  public CurrentDate getTimestamp(){
    return timestamp;
  }
  public String getSize() {
    return size;
  }

}
