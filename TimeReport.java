import java.lang.reflect.Field;
import java.io.*;
import java.util.*;
class TimeReport extends Report {

private String bestRange;
private String popularHour = "";
public TimeReport(CurrentDate date, String title, String path) {
        super(date, title, path);
}
public ArrayList<Transaction> data() {
        Inventory f = new Inventory();
        return f.readTransactions("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\transactions.dat"); //returns data from .dat file as arraylist
}

public String toString() {
        bestRange();
        bestOverallHour();
        return bestRange + "" + popularHour;
}
public ArrayList<String> names() {
        ArrayList<String> name = new ArrayList<String>();
        Field[] f = TransactionReport.class.getDeclaredFields();
        for (int i = 0; i < f.length; i++) {
                name.add((String)f[i].getName());
        }
        return name;
}
public ArrayList<String> values() {
        ArrayList<String> n = new ArrayList<String>();
        n.add(String.valueOf(bestRange));
        n.add(String.valueOf(popularHour));
        return n;
}

public void bestRange() {
        int[] range = new int[3];
        String[] m = {"8:00 - 11:59 AM","12:00-3:59 PM","4:00 - 10:00 PM"}; //checks for most transaction for each range
        ArrayList<Transaction> data = data();
        for (int i = 0; i < data.size(); i++) { //transaction array\
                                              int transactionTime = data.get(i).getDatetime().getHour();
                if (transactionTime >= 8 && transactionTime <= 11)
                        range[0] +=1;
                else if (transactionTime >= 12 && transactionTime <= 15)
                        range[1] +=1;
                else if (transactionTime >= 16  && transactionTime <= 22)
                        range[2] +=1;
        }
        int biggest = range[0];
        int biggestIndex = 0;
        for (int i = 0; i < range.length; i++) {
                if (range[i] > biggest) {
                        biggestIndex = i;
                }
        }
        bestRange =  m[biggestIndex];

}
public void bestOverallHour() {
        int[] hours = hourList(); //all transaction hours
        int[] count = new int[hours.length]; //check repetition
        for (int i = 0; i < hours.length; i++) {
                for (int j = 0; j < hours.length; j++) {
                        if (hours[i] == hours[j])
                                count[i]++;
                }
        }
        int h = 0;
        ArrayList<Integer> popular = new ArrayList<Integer>(); //finds highest number;
        for (int i = 0; i < count.length; i++) {
                if (count[i] > h) {
                        h = count[i];
                }
        }
        for (int i = 0; i < count.length; i++) { //checks to see if multiple popular values;
                if (count[i] == h)
                        popular.add(i);
        }
        if (popular.size() > 1) {
                for (int i = 0; i < popular.size(); i++) {
                        popularHour += hours[popular.get(i)] + " "; //uses index from popular to get the actual hour.
                }

        }
        else {
                popularHour = String.valueOf(hours[popular.get(0)]);
        }

}

public int[] hourList() {
        ArrayList<Transaction> data = data();
        int[] hours = new int[data.size()];
        for (int i = 0; i < data.size(); i++) { //transaction array\
           hours[i] = data.get(i).getDatetime().getHour();
        }
        return hours;
}



}
