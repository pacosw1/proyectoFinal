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
public Json() {
}

public JSONArray getData(String path) {
        JSONParser parser = new JSONParser(); //used to turn JSON to string
        JSONArray array = new JSONArray();
        FileReader file = null;
        try {
                file = new FileReader(path);

                array = (JSONArray)parser.parse(file); // reads from exisiting file
                file.close();
                //System.out.print(array.get(1).get("city"));
        }
        catch (FileNotFoundException e) {e.printStackTrace();}//error catching
        catch (IOException e) {e.printStackTrace();}
        catch (ParseException e) {e.printStackTrace(); }
        finally{}
        return array;
}
//Puedes ver UserLogin?

public void saveReport(ArrayList<String> names, ArrayList<String> values, String path) {
        JSONArray data = getData(path);
        FileWriter file = null;
        JSONObject tran = new JSONObject();
        for (int i = 0; i < names.size(); i++) {
                //new object to add
                tran.put(names.get(i),values.get(i));
        }
        data.add(tran);

        try { //write updated array to file
                file = new FileWriter(path);
                file.write(data.toJSONString());
                file.close();
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        //finally{}
}

public void saveReport(ArrayList<String> names, ArrayList<String> values,ArrayList<String> n1,ArrayList<String> n2, String path) {
        JSONArray data = getData(path);
        FileWriter file = null;
        JSONObject tran = new JSONObject();
        for (int i = 0; i < names.size(); i++) {
                //new object to add
                tran.put(names.get(i),values.get(i));
        }
        JSONArray percent = new JSONArray();
        for (int i =0; i < n1.size(); i++) {
                JSONObject curr = new JSONObject();
                curr.put("name",n1.get(i));
                curr.put("data",n2.get(i));
                percent.add(curr);
        }
        tran.put("array",percent);
        data.add(tran);


        try { //write updated array to file
                file = new FileWriter(path);
                file.write(data.toJSONString());
                file.close();
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        //finally{}
}
public void saveReport(ArrayList<String> names, ArrayList<String> values,ArrayList<String> n1, String path) {
        JSONArray data = getData(path);
        FileWriter file = null;
        JSONObject tran = new JSONObject();
        for (int i = 0; i < names.size(); i++) {
                //new object to add
                tran.put(names.get(i),values.get(i));
        }
        JSONArray percent = new JSONArray();
        for (int i =0; i < n1.size(); i++) {
                JSONObject curr = new JSONObject();
                curr.put("name",n1.get(i));
                percent.add(curr);
        }
        tran.put("array",percent);
        data.add(tran);


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
