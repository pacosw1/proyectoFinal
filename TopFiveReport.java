import java.io.*;
import java.util.*;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
class TopFiveReport extends Report{
  private ArrayList<String> tranString  = new ArrayList<String>();
    //Construct
    public TopFiveReport(CurrentDate date, String title, String path){
          super(date, title, path);
    }
    public void saveReport() {
            Json save = new Json();
            save.saveReport(names(),values(),tranString,path);
    }

    public ArrayList<String> names() {
      ArrayList<String> name = new ArrayList<String>();
      Field[] f = SalesReport.class.getDeclaredFields();
      name.add("title");
      name.add("date");
      return name;
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
public void topFive() {
    DecimalFormat two = new DecimalFormat( "#.##" );
  ArrayList<Double> transactions = sortArray();
  if (transactions.size() < 6) {
    for (int i =0; i < transactions.size();i++) {
        tranString.add(String.valueOf(transactions.get(i)));
    }

  } else
  for (int i =0; i < 5;i++) {
      tranString.add(String.valueOf(two.format(transactions.get(i))));
  }
}
public ArrayList<Double> sortArray()
{
        ArrayList<Transaction> transactions = data();
        int len = transactions.size();
        ArrayList<Double> arr = new ArrayList<Double>();
        double curr = 0.0;
        int highIndex = 0;
        double high = transactions.get(0).getTotal();
        for (int i = 0; i <  len; i++)
        {
                high = 0;
                for (int j = 0; j < transactions.size(); j++) {
                        curr = transactions.get(j).getTotal();
                        if (curr >= high) {
                                high = curr;
                                highIndex = j;
                        }
                }
                transactions.remove(highIndex);
                arr.add(high);
        }
        return arr;
}


	@Override
	public String toString() {
    sortArray();
    topFive();
    saveReport();
		return "Reporte Top 5\n Top 5 Ventas: " + tranString;
	}
}
