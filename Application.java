import java.io.*;

class Application {
  public static void main(String args[]) {
    System.out.println("Login:");
    //Login toby = new Login();
    Json test = new Json();
    test.addProduct("Drink","Tea","Green Tea","small","80.23","10.28.2017");
     System.out.print(test.getData());
    System.out.println(test);
    //System.out.println(toby);
  }
}
