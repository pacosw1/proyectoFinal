import java.io.*;
import java.util.*;
class Transaction implements Serializable {
private double total;
private String payment;
private ArrayList<Product> product;
private CurrentDate datetime;
//private Database data;

public Transaction(String payment, ArrayList<Product> product, CurrentDate datetime) {

        this.payment = payment;
        this.product = product;
        this.datetime = datetime;
        this.total = total();
        //this.data = data;
}

public double total() {
        double sum = 0;
        for(int i = 0; i < product.size(); i++)
        {
                sum += product.get(i).getPrice() * product.get(i).getQuantity();
        }
        return sum;
}
/*
   public void saveTransaction() {
   data.addTransaction
   }



 */
//sets and gets





@Override
public String toString() {
        return "Transaction [total=" + total + ", payment=" + payment + ", datetime=" + datetime + "]";
}
}
