import java.io.*;
import java.util.*;
class Application implements Serializable {
public static void main(String[] args) {
        //System.out.println("Login:");
        CLogin toby = new CLogin();
        toby.setUsername(Lectura.readString("Ingresar Usuario"));
        toby.setTypedPassword(Lectura.readString("Ingresar Password"));
        if (toby.loginAttempts()) {
          //run code
          System.out.println("Pass");
        }
        /*
        CurrentDate curr = new CurrentDate();
        Json save = new Json();
        String jPath = "C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\data.json";
        String path = "C:\\Users\\paco\\Desktop\\ingredients.dat";
        String path2 = "C:\\Users\\paco\\Desktop\\transactions.dat";
        //path3
        SaveToFile f = new SaveToFile();
        Ingredient i = new Ingredient("cofee-beans",2,0.23,"kg");
        Ingredient i2 = new Ingredient("milk",1,8.23,"Gallon");
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(i);
        ingredients.add(i2);

        Recipe recipe = new Recipe(ingredients);
        Chocolate ch = new Chocolate(23.23,"232","Hot-Chocolate","venti",recipe,"white",2);
        Chocolate nj = new Chocolate(50.23,"232","Hot-Chocolate","venti",recipe,"white",1);

        ArrayList<Product> pro = new ArrayList<Product>();
        pro.add(ch);
        pro.add(nj);
        Transaction tran = new Transaction("cash",pro,curr);
        ArrayList<Transaction> trans =  new ArrayList<Transaction>();
        trans.add(tran);
        save.addTransaction(trans,jPath);
        f.saveTransaction(trans,path2);
        //Ingredient gg = new Ingredient("vodka",99,50.52,"1L");
        f.saveIngredient(ingredients,path);
        ArrayList<Ingredient> m = f.readIngredients(path);
        //System.out.println(m);
        /*for (int j = 0; j < m.size();j++)
           {

           System.out.println(m.get(j).price());
           }

        double margin = (ch.getPrice() - ch.cost()) / (ch.cost()) * 100;
        System.out.println("Name " + ch.getName() + " Recipe cost: "+ ch.cost() + " Price: "+ ch.getPrice() + "profit Margin: "+margin+"%");
        System.out.println(tran);
         TransactionReport report = new TransactionReport(curr,"test",save,f,"C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\");
        System.out.println(report);
        */
}
}
