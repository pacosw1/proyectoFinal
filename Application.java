import java.io.*;
import java.util.*;
class Application implements Serializable {
public static void main(String[] args) {
        //System.out.println("Login:");
        CLogin toby = new CLogin();
        toby.setUsername(Lectura.readString("Ingresar Usuario"));
        toby.setTypedPassword(Lectura.readString("Ingresar Password"));
        if (toby.loginAttempts()) {
                if (toby.status == 0) {
                        //admin actions (access reports etc...)
                        managerOptions();

                } else {
                        //employee actions
                        //createIngredient();

                        //makeSale();
                        //System.out.println("Pass");
                }


//double price,String code, String name,String size, Recipe recipe, int quantity

                /*
                   public static ArrayList<Drink> saveDrinks() {
                   SaveToFile f = new SaveToFile();
                   ArrayList<Drink> drinks = f.saveDrink("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\drinks.dat");
                   return drinks;
                   }
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
public static ArrayList<Transaction> readTransactions() {
        SaveToFile f = new SaveToFile();
        return f.readTransactions("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\transactions.dat");
}
public static void saveTransactions(ArrayList<Transaction> transactions) {
        SaveToFile f = new SaveToFile();
        f.saveTransaction(transactions,"C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\transactions.dat");
}

public static ArrayList<Drink> readDrinks() {
        SaveToFile f = new SaveToFile();
        ArrayList<Drink> drinks = f.readDrinks("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\drinks.dat");
        return drinks;
}
public static void saveDrink(ArrayList<Drink> drinks) {
        SaveToFile f = new SaveToFile();
        f.saveDrink(drinks,"C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\drinks.dat");
}
public static void sellDrink() {
        ArrayList<Transaction> transactions = readTransactions();
        ArrayList<Drink> drinks = readDrinks();
        System.out.println("Agrega una bebida");
        ArrayList<Drink> added = new ArrayList<Drink>();
        int[] options = new int[drinks.size()];
        boolean end = true;
        do {
                for (int i = 0; i < drinks.size(); i++) {
                        System.out.println((i+1) + ". "+drinks.get(i));
                        options[i] = i;
                }

                int choice = choice(options.length,"Escoge una bebida");
                Drink selected = drinks.get(choice-1);
                int quantity = Lectura.readInt("Ingresar cantidad");
                selected.setQuantity(quantity);
                String[] sizes = {"small","medium","venti"};
                int[] sizeOptions = new int[sizes.length];
                for (int i = 0; i < sizes.length; i++) {
                        System.out.print((i+1) + ". " + sizes[i]);
                        sizeOptions[i] = i;
                }
                choice = choice(options.length,"Escoge una tamano");
                selected.setSize(sizes[choice-1]);
                added.add(selected);
                transactions.add(new Transaction("cash", added, new CurrentDate()));

                if (choose("Desea agregar otro ingrediente?"))
                        end = true;
                else
                        end = false;

        } while(end == true);
        saveTransactions(transactions);
}

public static void managerOptions() {
        boolean end = true;
        do {
                String[] actions = {"Realizar Venta","Agregar Nueva Bebida","Agregar Nuevo Ingrediente","Ver Inventario","Ver Reportes"};
                int[] options = new int[actions.length];
                for (int i = 0; i < actions.length; i++) {
                        System.out.println((i+1)+". " + actions[i]);
                }
                System.out.println((options.length +1)+ ". Cerrar Session");
                int choice = choice(options.length,"Escoge una opcion de la lista");
                switch (choice) {
                case 1:
                        sellDrink();
                        break;
                case 2:
                        createDrink();
                        break;
                case 3:
                        createIngredient();
                        break;
                case 4:
                        break;
                case 5:
                        break;
                case 6:
                        end = false;
                        break;
                        //reports
                }
        } while (end == true);


}
public static int choice(int len, String message) {
        int choice = Lectura.readInt(message);
        if (choice < len && choice >= -1)
                return choice;
        else
                return choice(len, message);
}
public static void employeeOptions() {
        String[] actions = {"Realizar Venta"};
        for (int i = 0; i < actions.length; i++) {
                System.out.println(i+". " + actions[i]);
        }
}

public static boolean choose(String message) {
        String n = Lectura.readString(message+"?  (si || no)");
        if (n.equals("si")) {
                return true;
        }else if (n.equals("no"))
                return false;
        else
                return choose(message);
}
public static Recipe createRecipe() {
        ArrayList<Ingredient> ingredients = readIngredients();
        System.out.println("Agrega un Ingrediente");
        ArrayList<Ingredient> added = new ArrayList<Ingredient>();
        int[] options = new int[ingredients.size()];
        boolean end = true;
        do {
                for (int i = 0; i < ingredients.size(); i++) {
                        System.out.println((i+1) + ". "+ingredients.get(i));
                        options[i] = i;
                }
                int choice = choice(options.length,"Escoge una opcion de la lista");
                Ingredient selected = ingredients.get(choice-1);
                int quantity = Lectura.readInt("Ingresar cantidad en " + selected.getMeasure());
                selected.setQuantity(quantity);
                added.add(selected);

                if (choose("Desea agregar otro ingrediente?"))
                        end = true;
                else
                        end = false;

        } while(end == true);
        return (new Recipe(added));
}
public static void saveIngredient(ArrayList<Ingredient> ingredients) {
        SaveToFile f = new SaveToFile();
        f.saveIngredient(ingredients, "C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\ingredients.dat");
}
public static ArrayList<Ingredient> readIngredients() {
        SaveToFile f = new SaveToFile();
        return f.readIngredients("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\ingredients.dat");

}
public static void createIngredient() {
        boolean end = true;
        ArrayList<Ingredient> ingredients = readIngredients();
        while (end == true) {
                System.out.println("Crear Ingrediente: ");
                String name = Lectura.readString("Name: "); int quantity=0;
                double unitaryPrice = Lectura.readDouble("Price");
                String measure = Lectura.readString("Measure Unit: ");
                ingredients.add(new Ingredient(name,quantity,unitaryPrice,measure));
                saveIngredient(ingredients);

                if (choose("Desea crear otro Ingrediente?"))
                        end = true;
                else
                        end = false;
        }
}
public static void createDrink() {
        boolean end = true;
        ArrayList<Drink> drinks = readDrinks();
        do {
                System.out.println("Crear Bebida: ");
                String name = Lectura.readString("Name");
                double price = Lectura.readDouble("Price:");
                System.out.println("Crear receta");
                Recipe recipe = createRecipe();
                String size = "";
                String code = Lectura.readString("Codigo de barras");
                int quantity = 0;
                drinks.add(new Drink(price,code,name,size,recipe,quantity));

                if (choose("Desea crear otra bebida?"))
                        end = true;
                else
                        end = false;
        } while(end == true);
        saveDrink(drinks);

}





}
