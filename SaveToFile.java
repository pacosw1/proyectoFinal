import java.io.*;
class SaveToFile implements Serialable {

  public static void main(String[] args) {
    Ingredient i = null;
    FileOutputStream f1 = null;
    ObjectOutputStream f2=null;
    try {
      f1 = new FileOutputStream(path);
      f2 = new ObjectOutputStream(f1);
      int mat = Lectura.readInt("Ingresar matricula");
      int sem = Lectura.readInt("Ingresar Semestre");
      i = new Ingredient(mat,sem);
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


  }
}
