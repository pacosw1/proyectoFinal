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
  public JSONArray getData() {
    JSONParser parser = new JSONParser(); //used to turn JSON to string
    JSONArray array = new JSONArray();
    try {
         array = (JSONArray)parser.parse(new FileReader("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\data.json")); // reads from exisiting file
    }
      catch (FileNotFoundException e) {e.printStackTrace();} //error catching
     catch (IOException e) {e.printStackTrace();}
    catch (ParseException e) {e.printStackTrace(); }
    return array;
  }
  //
  public void addProduct(String type, String subType, String name, String size, String price, String timestamp) { //adds object to array and saves it to file
    JSONArray data = getData();
    JSONObject product = new JSONObject(); //new object to add
    product.put("type",type); //object fields (attributes)
    product.put("subType",subType);
    product.put("name",name);
    product.put("size",size);
    product.put("price",price);
    product.put("timestamp", timestamp);
    data.add(product); //add object to array
    try (FileWriter file = new FileWriter("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\data.json")) { //write updated array to file
  			file.write(data.toJSONString());
  		}
      catch (FileNotFoundException e) {e.printStackTrace();}
     catch (IOException e) {e.printStackTrace();}
  }
   
}
