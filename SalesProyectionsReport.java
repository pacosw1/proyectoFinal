import java.io.*;
import java.util.*;
import java.lang.reflect.Field;
class SalesProyectionsReport extends Report{
  private int coffeeSales = 0;
  private int chocolateSales = 0;
  private int teaSales = 0;
  private int otherSales = 0;
    //Construct
    public SalesProyectionsReport(CurrentDate date, String title, String path){
          super(date, title, path);
    }
    public void saveReport() {
            Json save = new Json();
            save.saveReport(names(),values(),path);
    }

    public ArrayList<String> names() {
            ArrayList<String> name = new ArrayList<String>();
            name.add("title");
            name.add("date");
            Field[] f = TransactionReport.class.getDeclaredFields();
            for (int i = 0; i < f.length; i++) {
                    name.add((String)f[i].getName());
            }
            return name;
    }

    public ArrayList<String> values() {
            ArrayList<String> n = new ArrayList<String>();
            n.add(title);
            n.add(date.toString());
            n.add(String.valueOf(coffeeSales));
            n.add(String.valueOf(chocolateSales));
            n.add(String.valueOf(teaSales));
            n.add(String.valueOf(otherSales));
            return n;
    }

    public ArrayList<Transaction> data() {
            Inventory f = new Inventory();
            return f.readTransactions("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\transactions.dat"); //returns data from .dat file as arraylist
    }


    public void totalClientSales(){
      ArrayList<Transaction> transactions = data();

      for(int x = 0; x < transactions.size(); x++){

         ArrayList<Drink> drinkList = transactions.get(x).getProducts(); //te la lista de productos por transaccion.
         for (int i =0;i < drinkList.size();i++) {
            Drink currD = drinkList.get(i);
           if(currD.getName().contains("Cafe")){
              coffeeSales += 1;
           }
           else if(currD.getName().contains("Chocolate")){
              chocolateSales += 1;
           }
           else if(currD.getName().contains("Te")){
              teaSales += 1;
           }
           else
              otherSales += 1;
        }

         }
   }

	@Override
	public String toString() {
    totalClientSales();
		return "SalesProyectionsReport [coffeeSales=" + coffeeSales + ", chocolateSales=" + chocolateSales + ", teaSales=" + teaSales + ", otherSales=" + otherSales +"]";
	}
}
