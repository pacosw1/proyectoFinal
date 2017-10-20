import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
class jsonReader {
    public static void main(String args[]) {
      JSONParser parser = new JSONParser();
      try {
           Object obj = parser.parse(new FileReader("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\data.json"));
           
        //  System.out.print(obj[1][1]);
      /*  for (int i = 0;i<obj.length();i++) {
            Object[][] o = obj[i][1];
            System.out.print(o[i]);
          }

*/
           }
        catch (FileNotFoundException e) {
           e.printStackTrace();
       }
       catch (IOException e) {
          e.printStackTrace();
      }
      catch (ParseException e) {
           e.printStackTrace();
       }
    }
  }
