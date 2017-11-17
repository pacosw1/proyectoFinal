import java.io.*;
import java.io.*;
import java.util.*;
class Application implements Serializable {
public static void main(String[] args) {
  final JFrame frame = new JFrame("Start Session");
  final JButton btnLogin = new JButton("Click here to start session");

  btnLogin.addActionListener(
      new ActionListener(){//Starts Event
        public void actionPerformed(ActionEvent e) {
          Login loginDlg = new Login(frame);
          loginDlg.setVisible(true);
          // if login is successfull
          for(int i = 0; i < 2; i++){
            if(loginDlg.isSucceeded() == true){
              btnLogin.setText("Welcome: " + loginDlg.getStatus() + " " + loginDlg.getUsername());
            }
            else if(loginDlg.isSucceeded() == false){
              btnLogin.setText("You ran out of attempts!");
            }
          }
        }
      });

  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(300, 100);
  frame.setLayout(new FlowLayout());
  frame.getContentPane().add(btnLogin);
  frame.setVisible(true);

  if(loginDlg.getStatus() == 0) {
          //admin actions (access reports etc...)
          managerOptions();
          TransactionReport report = new TransactionReport(new CurrentDate(),"test","C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\");
          System.out.println(report);
  } else {

  }

        }
}
public static ArrayList<Transaction> readTransactions() {
        Inventory f = new Inventory();
        return f.readTransactions("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\transactions.dat");
}
public static void saveTransactions(ArrayList<Transaction> transactions) {
        Inventory f = new Inventory();
        f.saveTransaction(transactions,"C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\transactions.dat");
}

public static ArrayList<Drink> readDrinks() {
        Inventory f = new Inventory();
        ArrayList<Drink> drinks = f.readDrinks("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\drinks.dat");
        return drinks;
}
public static void saveDrink(ArrayList<Drink> drinks) {
        Inventory f = new Inventory();
        f.saveDrink(drinks,"C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\drinks.dat");
}

public static boolean changeStock(Recipe recipe,int q) {
  boolean end = true;
  ArrayList<Ingredient> selected = recipe.getIngredients();
  ArrayList<Ingredient> ingredients = readIngredients();
  for (int j = 0;j < selected.size();j++) {
    for (int i = 0; i < ingredients.size();i++) {
      if (selected.get(j).getName().equals(ingredients.get(i).getName())) {
          Ingredient curr = ingredients.get(i);
          if (curr.getQuantity() - (selected.get(j).getQuantity() * q) < 0) {
            end = false;
            break;
          }
          else {
              curr.setQuantity(curr.getQuantity() - (selected.get(j).getQuantity() * q));
              end = true;
          }

      }

    }
  }
  Inventory f = new Inventory();
  f.updateInventory(ingredients,"C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\ingredients.dat");
  return end;

}
public static void sellDrink() {

        ArrayList<Transaction> transactions = readTransactions();
        ArrayList<Drink> drinks = readDrinks();
        System.out.println("Agrega una bebida");
        ArrayList<Drink> added = new ArrayList<Drink>();
        boolean end = true;
        do {
                for (int i = 0; i < drinks.size(); i++) {
                        System.out.println((i+1) + ". "+drinks.get(i));

                }
                int choice = choice(drinks.size(),"Escoge una bebida");
                Drink selected = drinks.get(choice-1);

                int quantity = Lectura.getInt("Ingresar cantidad");
                selected.setQuantity(quantity);
                if (changeStock(selected.getRecipe(), selected.getQuantity())) {

                  String[] sizes = {"small","medium","venti"};
                  for (int i = 0; i < sizes.length; i++) {
                          System.out.println((i+1) + ". " + sizes[i]);
                  }
                  choice = choice(sizes.length,"Escoge una tamano");
                  selected.setSize(sizes[choice-1]);
                  added.add(selected);
                  transactions.add(new Transaction("cash", added, new CurrentDate()));
                } else {
                  System.out.println("Uno o mas Ingredientes se han agotado, Escoga otro producto");
                }



                if (choose("Desea hacer otra transaccion?"))
                        end = true;
                else
                        end = false;

        } while(end == true);
        saveTransactions(transactions);
}

public static void managerOptions() {
        boolean end = true;
        do {
                String[] actions = {"Realizar Venta","Agregar Nueva Bebida","Agregar Nuevo Ingrediente","Ver Inventario","Ver Reportes","Cerrar Session"};
                int[] options = new int[actions.length];
                for (int i = 0; i < actions.length; i++) {
                        System.out.println((i+1)+". " + actions[i]);
                }
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
                    showInventory();
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
        if (choice <= len && choice >= 1)
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
        Inventory f = new Inventory();
        f.saveIngredient(ingredients, "C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\ingredients.dat");
}
public static ArrayList<Ingredient> readIngredients() {
        Inventory f = new Inventory();
        return f.readIngredients("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\ingredients.dat");

}
public static void createIngredient() {
        boolean end = true;
        ArrayList<Ingredient> added = new  ArrayList<Ingredient>();
        while (end == true) {
                System.out.println("Crear Ingrediente: ");
                String name = Lectura.readString("Name: ");
                int quantity = Lectura.getInt("Ingresar Cantidad");
                double unitaryPrice = Lectura.readDouble("Price");
                String measure = Lectura.readString("Measure Unit: ");
                added.add(new Ingredient(name,quantity,unitaryPrice,measure));


                if (choose("Desea crear otro Ingrediente?"))
                        end = true;
                else
                        end = false;
        }
        saveIngredient(added);
}
public static void createDrink() {
        boolean end = true;
        String items[] = {"Cafe, te y otros","Chocolate"};
        ArrayList<Drink> added = new ArrayList<Drink>();
        do {
                for (int i = 0; i < items.length; i++) {
                        System.out.println((i+1) + ". "+items[i]);
                }
                int choice = choice(items.length,"Escoge una opcion de la lista");
                switch (choice-1) {
                case 1:
                        added.add(createAll());
                        break;
                case 2:
                        added.add(createChocolate());
                }

                if (choose("Desea crear otra bebida?"))
                        end = true;
                else
                        end = false;
        } while(end == true);
        saveDrink(added);
}
public static Chocolate createChocolate() {
        System.out.println("Crear Bebida: ");
        String name = Lectura.readString("Name");
        double price = Lectura.readDouble("Price:");
        System.out.println("Crear receta");
        Recipe recipe = createRecipe();
        String size = "";
        String code = Lectura.readString("Codigo de barras");
        int quantity = 0;
        String temp = "";
        String items[] = {"Chocolate","Vanilla"};
        for (int i = 0; i < items.length; i++) {
                System.out.println((i+1) + ". "+items[i]);
        }
        int choice = choice(items.length,"Escoge una opcion de la lista");
        String type = items[choice-1];
        return new Chocolate(price,code,name,size,recipe,quantity,temp,type);

}
public static Drink createAll() {
        System.out.println("Crear Bebida: ");
        String name = Lectura.readString("Name");
        double price = Lectura.readDouble("Price:");
        System.out.println("Crear receta");
        Recipe recipe = createRecipe();
        String size = "";
        String code = Lectura.readString("Codigo de barras");
        int quantity = 0;
        String temp = "";
        return new Drink(price,code,name,size,recipe,quantity,temp);

}
public static void showInventory() {
  ArrayList<Ingredient> list = readIngredients();
  for (int i = 0;i < list.size();i++) {
    System.out.println(list.get(i));
  }

}
}
