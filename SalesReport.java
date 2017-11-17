import java.lang.reflect.Field;
import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
class SalesReport extends Report {

private
private String[][] sales = new String;

public SalesReport(CurrentDate date, String title, String path) {
        super(date, title, path);
}

public void saveReport() {
        Json save = new Json();
        save.saveReport(names(),values(),path);
}

public ArrayList<String> names() {

        ArrayList<String> name = new ArrayList<String>();
        Field[] f = SalesReport.class.getDeclaredFields();
        name.add("title");
        name.add("date");
        for (int i = 0; i < f.length; i++) {
                name.add((String)f[i].getName());
        }
        return name;
}

public toString() {
        sales = getPercent();

}

public void getList() {
        ArrayList<Drink> drinks = getPercent();

}

public int getTotalSales() {
        int sum = 0;
        ArrayList<Transaction> transactions = data();
        for (int i = 0; i < transactions.size(); ++) {
                ArrayList<Drink> drink = transactions.get(i).getProducts(); //gets products list
                for (int j = 0; j < drink.size(); j++) { //add quantity of drink oer transaction;
                        Drink curr = drink.get(j);
                        sum+= curr.getQuantity();
                }
        }
        return sum;

}
public void fill() {

}
public ArrayList<Drink> getPercent() {
        ArrayList<Transaction> transactions = data();
        ArrayList<Drink> drinks = drinks();

        for (int i = 0; i < drinks.size(); i++) { //goes over drinks one by one
                Drink currD = drinks.get(i);
                for (int j = 0; j < drinks.size(); j++) {
                        ArrayList<Drink> currP = transactions.get(j).getProducts(); //current drink
                        for (int m = 0; m < currP.size(); m++) {
                                if (currD.getName().equals(currP.getName())) //if transaction drink equals list Drink , add quantity to drink in list
                                        currD.setQuantity(currD.getQuantity() + currP.getQuantity());
                        }
                }
        }
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
        n.add(String.valueOf(sales));
        return n;
}

public ArrayList<Transaction> data() {
        Inventory f = new Inventory();
        return f.readTransactions("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\transactions.dat"); //returns data from .dat file as arraylist
}
public ArrayList<Drink> drinks() {
        Inventory f = new Inventory();
        return f.readDrinks("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\drinks.dat"); //returns data from .dat file as arraylist
}

}
