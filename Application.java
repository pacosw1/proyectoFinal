import java.io.*;

class Application {
  public static void main(String args[]) {
    System.out.println("Login:");
    //Login toby = new Login();
    Json test = new Json();
    test.addProduct("Latte","Venti",100.23,2,"cold","10.18.2017","cash");
     System.out.print(test.getData());
    System.out.println(test);
    //System.out.println(toby);
  }
}
