import java.io.*;
class SaveToFile implements Serializable {

    public SaveToFile() {}
    public void saveIngredient(Ingredient i) { //saves ingredient object to .dat file.
      i = null;
      FileOutputStream f1 = null;
      ObjectOutputStream f2=null;
      try {
        f2.writeObject(i);
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
    public void saveTransaction(Transaction obj) { //saves object to an object .dat file for transactions;
      obj = null;
      FileOutputStream f1 = null;
      ObjectOutputStream f2=null;
      try {
        f1 = new FileOutputStream(path);
        f2 = new ObjectOutputStream(f1);
        f2.writeObject(obj);
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
