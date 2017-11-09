import java.io.*;
import java.util.*;
class Product implements Serializable{
  protected String code;
  protected double price;
  protected int quantity;

	public Product(double price,String code,int quantity) {
		this.code = code;
		this.price = price;
    this.quantity = quantity;
	}



	public String getCode() {
		return code;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
