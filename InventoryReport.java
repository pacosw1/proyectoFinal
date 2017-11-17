import java.io.*;
import java.util.*;
import java.lang.reflect.Field;
class InventoryReport extends Report {
private String reorder ="";

public InventoryReport(CurrentDate date, String title, String path){
        super(date, title, path);
}
public void saveReport() {
        Json save = new Json();
        save.saveReport(names(),values(),path); //YA jalo
}
@Override
public String toString() {
        findIngredients();
        saveReport();
        return "InventoryReport [reorder=" + reorder + "]";
}

public void findIngredients() {   //find all ingredients that are lower than 20 in stock // returns string
        ArrayList<Ingredient> ingredients = data(); //returns object list.
        String t = "";
        for (int i = 0; i < ingredients.size(); i++) {
                Ingredient current = ingredients.get(i);//Gets Ingredient i from arraylist
                if (current.getQuantity() <= 20)
                        t+= current.getName() + ", ";


        }
        if (t.equals(""))
                t+="None, all stocks sufficent for service";
        reorder += t;
}

public ArrayList<Ingredient> data() {//Brings all the data from transactions
        Inventory f = new Inventory();
        return f.readIngredients("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\ingredients.dat"); //returns data from .dat file as arraylist
}



public ArrayList<String> names() {     //adds attr to json

        ArrayList<String> name = new ArrayList<String>();
        Field[] f = InventoryReport.class.getDeclaredFields();
        name.add("title");
        name.add("date");
        for (int i = 0; i < f.length; i++) {
                name.add((String)f[i].getName());
        }
        return name;
}


public ArrayList<String> values() { //and its values
        //DecimalFormat two = new DecimalFormat( "#.##" );
        ArrayList<String> n = new ArrayList<String>();
        n.add(title);
        n.add(date.toString());
        n.add(reorder);


        return n;
}


}
