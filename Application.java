import java.io.*;
import java.util.*;
class Application {
  public static void main(String[] args) {
    //System.out.println("Login:");
    //Login toby = new Login();
    String path = "C:\\Users\\paco\\Desktop\\ingredients.dat";
    SaveToFile f = new SaveToFile();
    Ingredient i = new Ingredient("cofee-beans",2,0.23,"kg");
    //Ingredient gg = new Ingredient("vodka",99,50.52,"1L");
    Ingredient[] ingredients = {i};
    f.saveIngredient(ingredients,path);
    ArrayList<Ingredient> m = f.readIngredients(path);
    System.out.println(m);
    for (int j = 0; j < m.size();j++)
    {
      
      System.out.println(m.get(j).getClass());
    }



    //System.out.println(toby);
  }
}
