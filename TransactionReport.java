import java.lang.reflect.Field;
import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
class TransactionReport extends Report {

private double totalCost;
private double totalPrice;
private String bestProduct;
private double profit;
private double losses;
private double profitMargin;
public TransactionReport(CurrentDate date, String title, String path) {
        super(date, title, path);
}

public void saveReport() {
        Json save = new Json();
        save.saveReport(names(),values(),path);
}

public ArrayList<String> names() {

        ArrayList<String> name = new ArrayList<String>();
        Field[] f = TransactionReport.class.getDeclaredFields();
        name.add("title");
        name.add("date");
        for (int i = 0; i < f.length; i++) {
                name.add((String)f[i].getName());
        }
        return name;
}
@Override
public String toString() {
        losses(); bestProduct(); totals(); profits();
        saveReport();

        return "TransactionReport [totalCost=" + totalCost + ", totalPrice=" + totalPrice  + ", profit=" + profit + ", bestProduct=" + bestProduct + ", losses=" + losses + ", profitMargin=" + profitMargin + "]";
}



public ArrayList<String> values() {
        DecimalFormat two = new DecimalFormat( "#.##" );
        ArrayList<String> n = new ArrayList<String>();
        n.add(title);
        n.add(date.toString());
        n.add(String.valueOf(two.format(totalCost)));
        n.add(String.valueOf(two.format(totalPrice)));
        n.add(String.valueOf(bestProduct));
        n.add(String.valueOf(two.format(profit)));
        n.add(String.valueOf(two.format(losses)));
        n.add(String.valueOf(two.format(profitMargin)));

        return n;
}

public void bestProduct() {
        ArrayList<Transaction> data = data();
        double best = 0.0; double profit = 0.0; //var declaration
        for (int i = 0; i < data.size(); i++) { //transaction array
                ArrayList<Drink> curr = data.get(i).getProducts(); //product array
                for (int j = 0; j < curr.size(); j++) {
                        Drink product = (Drink)curr.get(j);
                        profit = product.total() - product.cost();
                        if (profit > best) { //checks for highest profit of all products (saves name and profit)
                                bestProduct = product.getName();
                        }
                }
        }
}
public ArrayList<Transaction> data() {
        Inventory f = new Inventory();
        return f.readTransactions("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\transactions.dat"); //returns data from .dat file as arraylist
}
public void losses() {
        ArrayList<Transaction> data = data();
        for (int i = 0; i < data.size(); i++) {
                ArrayList<Drink> curr = data.get(i).getProducts();
                for (int j = 0; j < curr.size(); j++) {
                        Drink product = (Drink)curr.get(j);
                        if (product.total() - product.cost() < 0) //checks if there are any losses in products.
                                losses+= Math.abs(product.total() - product.cost());
                }
        }
}
public void totals() {
        ArrayList<Transaction> data = data(); //list of transactions
        double cost = 0.0; double price = 0.0;
        for (int i = 0; i < data.size(); i++) {
                totalCost += data.get(i).cost(); //totals per transactions. Declared in transaction class
                totalPrice += data.get(i).total();
        }
}
public void profits() {
        profit = (totalPrice - totalCost);
        profitMargin =  ((totalPrice - totalCost) / totalCost) *100;
}



}
