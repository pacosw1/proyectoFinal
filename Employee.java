import java.io.*;
import java.util.*;
class Employee implements Serializable{
public Employee(){
}
public ArrayList<Employee> readEmployee(String path) {
        FileInputStream fis = null;
        ArrayList<Employee> objectsList = new ArrayList<Employee>();
        boolean cont = true;
        try{
                fis = new FileInputStream(path);
                ObjectInputStream input = new ObjectInputStream(fis);
                while(cont) {
                        Employee obj = (Employee)input.readObject();
                        if(obj != null)
                              objectsList.add(obj);
                        else
                              cont = false;
                }
        }catch(Exception e){
                //System.out.println(e.printStackTrace());
        }
        return objectsList;
}
public void saveEmployee(ArrayList<Employee> obj, String path) {     //saves object to an object .dat file for Employees
        ArrayList<Employee> current = readEmployee(path); //uses the read method to get all saved objects from the file.
        
        for (int j = 0; j< obj.size(); j++){ //adds the ingredient array to arraylist.
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
//Display
public String toString(){
   return " ";
}
}
