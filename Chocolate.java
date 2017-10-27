import java.io.*;
class Chocolate extends Drink {
  //Construct
  public Chocolate(String size){
    super(size);
  }
  //Set
    public void setSize(String size){
      this.size = size;
    }
  //Get
    public String getSize(){
      return size;
    }
}
