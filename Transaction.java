import java.io.*;
import java.util.*;
class Transaction implements Serializable {
private double total;
private String payment;
private ArrayList<Drink> product;
private CurrentDate datetime;
//private Database data;

public Transaction(String payment, ArrayList<Drink> product, CurrentDate datetime) {

        this.payment = payment;
        this.product = product;
        this.datetime = datetime;
        this.total = total();
        //this.data = data;
}

public double total() {//Price * How many?
        double sum = 0;
        for(int i = 0; i < product.size(); i++)
        {
                sum += product.get(i).getPrice() * product.get(i).getQuantity();
        }
        return sum;
}
public double cost() {
        double sum = 0;
        for(int i = 0; i < product.size(); i++)
        {
                sum += product.get(i).cost();
        }
        return sum;
}

@Override
public String toString() {
        return "Transaction [total=" + total + ", payment=" + payment + ", datetime=" + datetime + "]";
}

public double getTotal() {
        return total;
}

public String getPayment() {
        return payment;
}

public ArrayList<Drink> getProducts() {
        return product;
}

public CurrentDate getDatetime() {
        return datetime;
}

public void setTotal(double total) {
        this.total = total;
}

public void setPayment(String payment) {
        this.payment = payment;
}

public void setProduct(ArrayList<Drink> product) {
        this.product = product;
}

public void setDatetime(CurrentDate datetime) {
        this.datetime = datetime;
}
}
