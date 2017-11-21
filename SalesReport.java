import java.lang.reflect.Field;
import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
class SalesReport extends Report {


private ArrayList<String> drinkName = new ArrayList<String>();
private ArrayList<String> drinkPercent = new ArrayList<String>();

public SalesReport(CurrentDate date, String title, String path) {
        super(date, title, path);
}

public void saveReport() {
        Json save = new Json();
        save.saveReport(names(),values(),drinkName,drinkPercent,path);
}

public ArrayList<String> names(){

        ArrayList<String> name = new ArrayList<String>();
        Field[] f = SalesReport.class.getDeclaredFields();
        name.add("title");
        name.add("date");
        return name;
}

public String toString() {
        sales();
        saveReport();
        return "Bebidas: "+ drinkName + "% de Venta" + drinkPercent;

}


public void getList(){//Gets the percent method
        ArrayList<Drink> drinks = getPercent();

}
public void sales() {
      DecimalFormat two = new DecimalFormat( "#.##" );
        double totalSales = getTotalSales();
        ArrayList<Drink> drinks = getPercent();
        int len = drinks.size();
        for (int i = 0; i < len; i++) {
                Drink curr = drinks.get(i);
                drinkName.add(curr.getName());
                drinkPercent.add(String.valueOf(two.format((curr.getQuantity() / totalSales) * 100)));
        }
}
public int getTotalSales() {
        int sum = 0;
        ArrayList<Transaction> transactions = data();
        for (int i = 0; i < transactions.size(); i++) {
                ArrayList<Drink> drink = transactions.get(i).getProducts(); //gets products list

                for (int j = 0; j < drink.size(); j++) { //add quantity of drink per transaction;
                        Drink curr = drink.get(j);
                        sum+= curr.getQuantity();
                }
        }

        return sum;
}


public ArrayList<Drink> getPercent() {
        ArrayList<Transaction> transactions = data();
        ArrayList<Drink> drinks = drinks();

        for (int i = 0; i < drinks.size(); i++) { //goes over drinks one by one
                Drink currD = drinks.get(i);
                for (int j = 0; j < transactions.size(); j++) {
                        ArrayList<Drink> currP = transactions.get(j).getProducts(); //current drink
                        for (int m = 0; m < currP.size(); m++) {
                                if (currD.getName().equals(currP.get(m).getName())) //if transaction drink equals list Drink , add quantity to drink in list
                                        currD.setQuantity(currD.getQuantity() + currP.get(m).getQuantity());
                        }
                }
        }
        return drinks;
}

public ArrayList<String> values() {
        ArrayList<String> n = new ArrayList<String>();
        n.add(title);
        n.add(date.toString());
        return n;
}

public ArrayList<Transaction> data() {
        Inventory f = new Inventory();
        return f.readTransactions("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\transactions.dat"); //returns data from .dat file as arraylist
}

public ArrayList<Drink> drinks() {//Check where's the product name here, if not, find another way
        Inventory f = new Inventory();
        return f.readDrinks("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\drinks.dat"); //returns data from .dat file as arraylist
}

}
