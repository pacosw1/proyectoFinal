import java.io.*;
class Tea extends Drink{
  //Construct
  public Tea(String size){
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
