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
    try {
         array = (JSONArray)parser.parse(new FileReader("C:\\Users\\"+names+"\\Documents\\GitHub\\proyectoFinal\\data\\data.json")); // reads from exisiting file
         //System.out.print(array.get(1).get("city"));
      }
      catch (FileNotFoundException e) {e.printStackTrace();} //error catching
     catch (IOException e) {System.out.println("File was Empty, new Entry created Successfuly");}
    catch (ParseException e) {System.out.print(""); }
    return array;
  }
  //
  public void addProduct(String name, String size, double price, int quantity, String temp, String timestamp, String payT) { //adds object to array and saves it to file
    JSONArray data = getData();
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
    try (FileWriter file = new FileWriter("C:\\Users\\"+names+"\\Documents\\GitHub\\proyectoFinal\\data\\data.json")) { //write updated array to file
  			file.write(data.toJSONString());
  		}
      catch (FileNotFoundException e) {e.printStackTrace();}
     catch (IOException e) {e.printStackTrace();}
  }

}
