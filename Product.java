import java.io.*;
import java.util.*;
class Product implements Serializable{//Archive
  protected String code;
  protected double price;
  protected int quantity;
  //Construct
  	public Product(double price,String code,int quantity) {
  		setCode(code);
  		setPrice(price);
      setQuantity(quantity);
  	}
  //Set
  	public void setCode(String code) {
  		this.code = code;
  	}

  	public void setPrice(double price) {
  		this.price = price;
  	}

  	public void setQuantity(int quantity) {
  		this.quantity = quantity;
  	}
  //Get
  	public String getCode() {
  		return code;
  	}

  	public double getPrice() {
  		return price;
  	}

  	public int getQuantity() {
  		return quantity;
  	}
}
