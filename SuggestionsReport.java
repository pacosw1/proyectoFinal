import java.io.*;
 import java.util.*;
 import java.lang.reflect.Field;//getHours, employee of the month
 import java.text.DecimalFormat;
 class SuggestionsReport extends Report {


 private double positive;
 private double negative;

 public SuggestionsReport(CurrentDate date, String title, String path){
         super(date, title, path);
 }


   public void saveReport() {
           Json save = new Json();
           save.saveReport(names(),values(),path);
   }

   public ArrayList<String> names() {
           ArrayList<String> name = new ArrayList<String>();
           name.add("title");
           name.add("date");
           Field[] f = SuggestionsReport.class.getDeclaredFields();
           for (int i = 0; i < f.length; i++) {
                   name.add((String)f[i].getName());
           }
           return name;
   }

   public ArrayList<String> values() {
       DecimalFormat two = new DecimalFormat( "#.##");
           ArrayList<String> n = new ArrayList<String>();
           n.add(title);
           n.add(date.toString());
           n.add(String.valueOf(two.format(positive)));
           n.add(String.valueOf(two.format(negative)));
           return n;
  }

   public ArrayList<Suggestion> data() {
           Inventory f = new Inventory();
           return f.readSuggestions("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\suggestions.dat"); //returns data from .dat file as arraylist
   }

   public void clientSuggestions(){
     ArrayList<Suggestion> suggestions = data();

     for(int i = 0; i < suggestions.size(); i++){
       Suggestion current = suggestions.get(i);
       if(current.getType().contains("Negativo")){
         negative += 1;
       }
       else if(current.getType().contains("Positivo")){
         positive += 1;
       }
     }
     positive = (positive / suggestions.size() * 100);
     negative = (negative / suggestions.size() * 100);
   }

   @Override
   public String toString(){
     DecimalFormat two = new DecimalFormat( "#.##");
     clientSuggestions();
     saveReport();
   return "Sugerencias: \nPositive Suggestions: " + two.format(positive) + "%\nNegative Suggestions: " + two.format(negative) + "%\n";
  }
 }
