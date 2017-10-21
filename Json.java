import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
class Json {
  /*  public static void main(String args[]) {
      //SONParser parser = new JSONParser();

    }
  }
  */
  public Json() {
    
  }
  public JSONArray getData() {
    JSONParser parser = new JSONParser();
    JSONArray array = null;
    try {
         //Object obj = parser.parse(new FileReader("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\data.json"));
         //JSONArray jArray = obj.getJSONArray();
         array = (JSONArray)parser.parse(new FileReader("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\data.json"));
         //creating a new JSON object with input data

         //JSONArray jsonArray = new JSONArray();
         //System.out.print(array.get(1).get("city"));
         for (int i = 0; i < 3;i++) {
            System.out.println((array.get(i)));
          }
         }
      catch (FileNotFoundException e) {e.printStackTrace();}
     catch (IOException e) {e.printStackTrace();}
    catch (ParseException e) {e.printStackTrace();}
    return array;
  }
  public JSONObject addProduct() {
    JSONObject product = new JSONObject();
  //  product.put
    product.put("city","New York");
    product.put("job","teacher");
    return product;
  }

  public String toString() {
    JSONArray data = getData();
    return data.get(1) + "";

  }
}
