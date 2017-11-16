import java.io.*;
import java.util.*;

class SaveToFile implements Serializable {

public SaveToFile() {
}

public ArrayList<Ingredient> readIngredients(String path) {
        FileInputStream fis = null;
        ArrayList<Ingredient> objectsList = new ArrayList<Ingredient>(); //Ingredient specified as type
        boolean cont = true;
        try{
                fis = new FileInputStream(path);
                ObjectInputStream input = new ObjectInputStream(fis);
                while(cont) {
                        Ingredient obj = (Ingredient)input.readObject(); //reads objects from file and adds them to an arraylist which is then returned
                        if(obj != null)
                                objectsList.add(obj);
                        else
                                cont = false;
                }
        }catch(Exception e) {
                //System.out.println(e.printStackTrace());
        }
        return objectsList;
}
public ArrayList<Drink> readDrinks(String path) {
        FileInputStream fis = null;
        ArrayList<Drink> objectsList = new ArrayList<Drink>(); //Ingredient specified as type
        boolean cont = true;
        try{
                fis = new FileInputStream(path);
                ObjectInputStream input = new ObjectInputStream(fis);
                while(cont) {
                        Drink obj = (Drink)input.readObject(); //reads objects from file and adds them to an arraylist which is then returned
                        if(obj != null)
                                objectsList.add(obj);
                        else
                                cont = false;
                }
        }catch(Exception e) {
                //System.out.println(e.printStackTrace());
        }
        return objectsList;
}
public ArrayList<Transaction> readTransactions(String path) {
        FileInputStream fis = null;
        ArrayList<Transaction> objectsList = new ArrayList<Transaction>(); //Ingredient specified as type
        boolean cont = true;
        try{
                fis = new FileInputStream(path);
                ObjectInputStream input = new ObjectInputStream(fis);
                while(cont) {
                        Transaction obj = (Transaction)input.readObject(); //reads objects from file and adds them to an arraylist which is then returned
                        if(obj != null)
                                objectsList.add(obj);
                        else
                                cont = false;
                }
        }catch(Exception e) {
                //System.out.println(e.printStackTrace());
        }
        return objectsList;
}
public void saveIngredient(ArrayList<Ingredient>ingredients, String path) {     //saves ingredient object to .dat file.

        ArrayList<Ingredient> current = readIngredients(path); //uses the read method tu get all saved objects from the file.
        for (int j = 0; j< ingredients.size(); j++) //adds the ingredient array to arraylist.
        {
                current.add(ingredients.get(j));
        }
        FileOutputStream f1 = null;
        ObjectOutputStream f2=null;
        try {
                f1 = new FileOutputStream(path);
                f2 = new ObjectOutputStream(f1);
                for (int j = 0; j< current.size(); j++) //writes all old and new Objects to file from the arrayList;
                {
                        f2.writeObject(current.get(j));
                }

        }
        catch(IOException e) {System.out.println("No se almaceno");}
        finally {
                try {
                        f2.close();
                        f1.close();
                }
                catch(IOException e) {System.out.println("Error al cerrar el archivo");}
        }
}
public void saveDrink(ArrayList<Drink> drinks, String path) {     //saves ingredient object to .dat file.

        ArrayList<Drink> current = readDrinks(path); //uses the read method tu get all saved objects from the file.
        for (int j = 0; j< drinks.size(); j++) //adds the ingredient array to arraylist.
        {
                current.add(drinks.get(j));
        }
        FileOutputStream f1 = null;
        ObjectOutputStream f2=null;
        try {
                f1 = new FileOutputStream(path);
                f2 = new ObjectOutputStream(f1);
                for (int j = 0; j< current.size(); j++) //writes all old and new Objects to file from the arrayList;
                {
                        f2.writeObject(current.get(j));
                }

        }
        catch(IOException e) {System.out.println("No se almaceno");}
        finally {
                try {
                        f2.close();
                        f1.close();
                }
                catch(IOException e) {System.out.println("Error al cerrar el archivo");}
        }
}
public void saveTransaction(ArrayList<Transaction> obj, String path) {     //saves object to an object .dat file for transactions;
        ArrayList<Transaction> current = readTransactions(path); //uses the read method tu get all saved objects from the file.
        for (int j = 0; j< obj.size(); j++) //adds the ingredient array to arraylist.
        {
                current.add(obj.get(j));
        }
        FileOutputStream f1 = null;
        ObjectOutputStream f2=null;
        try {
                f1 = new FileOutputStream(path);
                f2 = new ObjectOutputStream(f1);
                for (int j = 0; j< current.size(); j++) //writes all old and new Objects to file from the arrayList;
                {
                        f2.writeObject(current.get(j));
                }
        }
        catch(IOException e) {System.out.println("No se almaceno");}
        finally {
                try {
                        f2.close();
                        f1.close();
                }
                catch(IOException e) {System.out.println("Error al cerrar el archivo");}
        }
}
}
