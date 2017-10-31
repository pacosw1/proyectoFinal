import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
class Json {
  public Json() {
  }
  String names = "paco";
  public JSONArray getData() {
    JSONParser parser = new JSONParser(); //used to turn JSON to string
    JSONArray array = new JSONArray();
    FileReader file = null;
    try {
         file = new FileReader("C:\\Users\\"+names+"\\Documents\\GitHub\\proyectoFinal\\data\\data.json");

         array = (JSONArray)parser.parse(file); // reads from exisiting file
         file.close();
         //System.out.print(array.get(1).get("city"));
      }
      catch (FileNotFoundException e) {e.printStackTrace();} //error catching
<<<<<<< HEAD
     catch (IOException e) {System.out.println("File was Empty, new Entry created Successfuly");}
    catch (ParseException e) {System.out.print(""); }
=======
     catch (IOException e) {e.printStackTrace();}
    catch (ParseException e) {e.printStackTrace(); }
    finally{}
>>>>>>> 67f458d3efac1e96177bd2013fc97d3235c344fe
    return array;
  }
  //
  public void addProduct(String name, String size, double price, int quantity, String temp, String timestamp, String payT) { //adds object to array and saves it to file
    JSONArray data = getData();
    FileWriter file = null;
    JSONObject product = new JSONObject(); //new object to add
    product.put("Temp", temp);
    product.put("Quantity", quantity);
    product.put("name",name);
    product.put("size",size);
    product.put("price",price);
    product.put("total",Double.valueOf(price)*Double.valueOf(quantity));
    product.put("timestamp", timestamp);
    product.put("payment-type",payT);
    data.add(product); //add object to array
    try { //write updated array to file
        file = new FileWriter("C:\\Users\\"+names+"\\Documents\\GitHub\\proyectoFinal\\data\\data.json");
  			file.write(data.toJSONString());
        file.close();
  		}
      catch (FileNotFoundException e) {e.printStackTrace();}
     catch (IOException e) {e.printStackTrace();}
     //finally{}
  }

}
