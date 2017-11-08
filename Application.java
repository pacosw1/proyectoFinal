import java.io.*;
class Application {
  public static void main(String[] args) {
    //System.out.println("Login:");
    //Login toby = new Login();
    String path = "C:\\Users\\paco\\Desktop";
    SaveToFile f = new SaveToFile();
    Ingedient i = new Ingredient("cofee-beans",2,0.23,"kg");
    f.saveIngredient(i,path);


    
    //System.out.println(toby);
  }
}
