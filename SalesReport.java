import java.lang.reflect.Field;
import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
class SalesReport extends Report {

private ;
private double totalPrice;

public SalesReport(CurrentDate date, String title, String path) {
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

public void


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

public ArrayList<Transaction> data() {
        Inventory f = new Inventory();
        return f.readTransactions("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\transactions.dat"); //returns data from .dat file as arraylist
}

}
