import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.lang.reflect.Field;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.*;
class Json {
private String path;
public Json(String path) {
        this.path = path;
}
String names = "paco";
public JSONArray getData() {
        JSONParser parser = new JSONParser(); //used to turn JSON to string
        JSONArray array = new JSONArray();
        FileReader file = null;
        try {
                file = new FileReader(path);

                array = (JSONArray)parser.parse(file); // reads from exisiting file
                file.close();
                //System.out.print(array.get(1).get("city"));
        }
        catch (FileNotFoundException e) {e.printStackTrace();}           //error catching
        catch (IOException e) {e.printStackTrace();}
        catch (ParseException e) {e.printStackTrace(); }
        finally{}
        return array;
}
//
public void saveReport(String[] names, String[] values, Report report) {
        JSONArray data = getData();
        FileWriter file = null;
        for (int i = 0; i < names.length; i++) {
                JSONObject tran = new JSONObject(); //new object to add
                tran.put(names[i],"");


        }

        try { //write updated array to file
                file = new FileWriter(path);
                file.write(data.toJSONString());
                file.close();
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        //finally{}
}


public void addTransaction(ArrayList<Transaction> transaction) {   //adds object to array and saves it to file
        JSONArray data = getData();
        FileWriter file = null;
        for (int i = 0; i < transaction.size(); i++) {
                JSONObject tran = new JSONObject(); //new object to add
                tran.put("Payment", transaction.get(i).getPayment());
                tran.put("Products", transaction.get(i).getProduct());
                tran.put("date",transaction.get(i).getDatetime());
                data.add(tran);
        }

        /*
           product.put("size",size);
           product.put("price",price);
           product.put("total",Double.valueOf(price)*Double.valueOf(quantity));
           product.put("timestamp", timestamp);
           product.put("payment-type","cash");
         */
        //add object to array
        try { //write updated array to file
                file = new FileWriter(path);
                file.write(data.toJSONString());
                file.close();
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        //finally{}
}

}
