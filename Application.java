import java.io.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
class Application implements Serializable {
public static void main(String[] args) {

        CLogin user = new CLogin();
        JFrame frame = new JFrame("Cafe Inc Login");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);
        JLabel attempts = new JLabel("Attempts: " +user.getAttempts());
        attempts.setBounds(10, 100, 100, 25);
        panel.add(attempts);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 10, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 40, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 40, 160, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        frame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {

                                user.setUsername(userText.getText());
                                user.setTypedPassword( passwordText.getText());
                                if (user.checkAccount()) {
                                        frame.dispose();
                                        if (user.getStatus() == 0) {



                                                //manage or employee
                                                //admin actions (access reports etc...)
                                                managerOptions();          //interface

                                        }

                                        else if (user.getStatus() == 1) {
                                                employeeOptions();
                                        }
                                        else {
                                                System.out.println("Error");
                                        }

                                }

                                else if (user.getAttempts() < 1) {
                                        attempts.setText("Try Again Later");
                                } else {
                                        userText.setText("");
                                        passwordText.setText("");
                                        attempts.setText("Attempts: " + user.getAttempts());
                                }


                        };
                });





}



//methods
public static void managerOptions() {         //uses all other methods to provide interface
        boolean end = true;
        do {
                String[] actions = {"Realizar Venta","Agregar Nueva Bebida","Agregar Nuevo Ingrediente","Inventario","Generar Reportes","Nuevo Empleado","Ajustar Horas","Ingesar Sugerencia","Cerrar Session"};
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
                        generateReports();
                        break;
                case 6:
                        createEmployee();
                        break;
                case 7:
                        updateEmployee();
                        break;
                case 8:
                      createSuggestion();
                      break;
                case 9:

                  end = false;
                  break;
                    //reports

                }
        } while (end == true);


}
//read and save Methods
public static void generateReports() {
        String name = "paco";
        String path = "C:\\Users\\"+name+"\\Documents\\GitHub\\proyectoFinal\\data\\Reports.json";
        System.out.println("Open Index.html to view formatted reports\n");
        TimeReport rep = new TimeReport(new CurrentDate(), "time", path);
        System.out.println(rep);
        TransactionReport report = new TransactionReport(new CurrentDate(),"transactions",path);
        System.out.println(report);
        InventoryReport rr = new InventoryReport(new CurrentDate(),"inventory",path);
        System.out.println(rr);

        SalesProyectionsReport rf = new SalesProyectionsReport(new CurrentDate(),"salesp",path);
        System.out.println(rf);
        EmployeeReport er = new EmployeeReport(new CurrentDate(),"employee",path);
        System.out.println(er);
        SuggestionsReport sg = new SuggestionsReport(new CurrentDate(),"suggestions",path);
        System.out.println(sg);
        TendencyReport tr = new TendencyReport(new CurrentDate(),"tendency",path);
        System.out.println(tr);
        SalesReport salesR = new SalesReport(new CurrentDate(),"sales",path);
        System.out.println(salesR);
        AverageReport av = new AverageReport(new CurrentDate(),"average",path);
        System.out.println(av);
        TopFiveReport top = new TopFiveReport(new CurrentDate(),"topFive",path);
        System.out.println(top);


}
public static void saveIngredient(ArrayList<Ingredient> ingredients) {
        Inventory f = new Inventory();
        f.saveIngredient(ingredients, "C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\ingredients.dat");
}
public static ArrayList<Ingredient> readIngredients() {
        Inventory f = new Inventory();
        return f.readIngredients("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\ingredients.dat");

}
public static ArrayList<Employee> readEmployee(){
        Inventory f = new Inventory();
        return f.readEmployee("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\employee.dat");
   }
   public static void updateEmployee(ArrayList<Employee> e){
           Inventory f = new Inventory();
           f.updateEmployees(e,"C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\employee.dat");
      }
   public static void saveEmployee(ArrayList<Employee> employee){
        Inventory f = new Inventory();
        f.saveEmployee(employee,"C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\employee.dat");
   }
   public static void saveSuggestion(ArrayList<Suggestion> suggestions){
        Inventory f = new Inventory();
        f.saveSuggestion(suggestions,"C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\suggestions.dat");
   }
   public static ArrayList<Suggestion> readSuggestion() {         //return list of all transactions from .dat file
           Inventory f = new Inventory();
           return f.readSuggestions("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\suggestions.dat");
   }

public static ArrayList<Transaction> readTransactions() {         //return list of all transactions from .dat file
        Inventory f = new Inventory();
        return f.readTransactions("C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\transactions.dat");
}
public static void saveTransactions(ArrayList<Transaction> transactions) {         //saves given transaction arrayList
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

public static void createEmployee() {
  ArrayList<Employee> added = new  ArrayList<Employee>();
  String first = Lectura.readString("Nombre");String mid = Lectura.readString("Apellido Paterno");String last = Lectura.readString("Apellido Materno");
  Name name = new Name(first,mid,last);
  added.add(new Employee(0,name,7.23));
  saveEmployee(added);
}

public static void createSuggestion() {
  ArrayList<Suggestion> added = new ArrayList<Suggestion>();
  String complaint = Lectura.readString("Comentario o Sugerencia");
  String[] op = {"Positivo", "Negativo"};
  for (int i = 0; i < op.length; i++) {
          System.out.println((i+1) + ". "+op[i]);

  }
  int choice = choice(op.length,"Escoge tipo");
  String selected = op[(choice-1)];
  added.add(new Suggestion(complaint,selected, new CurrentDate()));
  saveSuggestion(added);


}
public static void updateEmployee() {
  ArrayList<Employee> employees = readEmployee();
  boolean end = false;
  do {

          for (int i = 0; i < employees.size(); i++) {
                  System.out.println((i+1) + ". "+employees.get(i));

          }
          int choice = choice(employees.size(),"Escoge Empleado a ajustar horas");
          Employee selected = employees.get(choice-1);
          int amount = Lectura.getInt("Horas a agregar");
          selected.setHours(selected.getHours() + amount);


          if (choose("Desea ajustar otro empleado?"))
                  end = true;
          else
                  end = false;

  } while(end == true);
    updateEmployee(employees);

}

public static boolean changeStock(Recipe recipe,int q) {         //during sale, substracts recipe quantities from inventory
        boolean end = true;
        ArrayList<Ingredient> selected = recipe.getIngredients();
        ArrayList<Ingredient> ingredients = readIngredients();
        for (int j = 0; j < selected.size(); j++) {
                for (int i = 0; i < ingredients.size(); i++) {
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
public static double sizePrice(int choice) {
        if (choice == 0) {
                return 0.23;
        }
        else if (choice == 1) {
                return 0.89;
        } else {
                return 1.23;
        }

}
public static void sellDrink() {         //Drink sale

        ArrayList<Transaction> transactions = readTransactions();
        DecimalFormat two = new DecimalFormat( "#.##" );
        ArrayList<Drink> drinks = readDrinks();
        System.out.println("Agrega una bebida");
        ArrayList<Drink> added = new ArrayList<Drink>();
        boolean end = true;
        do {
                for (int i = 0; i < drinks.size(); i++) {             //displays options from drink list
                        System.out.println((i+1) + ". "+drinks.get(i));

                }
                int choice = choice(drinks.size(),"Escoge una bebida");
                Drink selected = drinks.get(choice-1);

                int quantity = Lectura.getInt("Ingresar cantidad");
                selected.setQuantity(quantity);
                if (changeStock(selected.getRecipe(), selected.getQuantity())) {         //checks to see if quantity is > 0 to make drink
                        for (int m = 0; m < quantity; m++) {
                                System.out.println("Drink#:"+ (m+1)+"\n");
                                String[] sizes = {"small","medium","venti"};
                                for (int i = 0; i < sizes.length; i++) {
                                        System.out.println((i+1) + ". " + sizes[i]);
                                }
                                choice = choice(sizes.length,"Escoge una tamano");
                                selected.setPrice(selected.getPrice() + sizePrice(choice-1));

                                selected.setSize(sizes[choice-1]);
                                String[] temp = {"Caliente","Frio"};
                                for (int i = 0; i < temp.length; i++) {
                                        System.out.println((i+1) + ". " + temp[i]);
                                }
                                choice = choice(temp.length,"Escoge una temperatura");
                                selected.setTemp(temp[choice-1]);

                        }

                        added.add(selected);
                        Transaction curr = new Transaction("cash", added, new CurrentDate());
                        transactions.add(curr);
                        System.out.println("Total: "+ two.format(curr.getTotal()));
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

public static int choice(int len, String message) {         //makes list choice is valid.
        int choice = Lectura.getInt(message);
        if (choice <= len && choice >= 1)
                return choice;
        else
                return choice(len, message);
}
public static void employeeOptions() {
        boolean end = true;
        do {
                String[] actions = {"Realizar Venta","Cerrar Session"};
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
                        end = false;
                        break;
                        //reports
                }
        } while (end == true);

}

public static boolean choose(String message) {         // si o no
        String n = Lectura.readString(message+"?  (si || no)");
        if (n.equals("si")) {
                return true;
        }else if (n.equals("no"))
                return false;
        else
                return choose(message);
}
public static Recipe createRecipe() {         //creates recipe
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
                int quantity = Lectura.getInt("Ingresar cantidad en " + selected.getMeasure());
                selected.setQuantity(quantity);
                added.add(selected);

                if (choose("Desea agregar otro ingrediente?"))
                        end = true;
                else
                        end = false;

        } while(end == true);
        return (new Recipe(added));
}

public static void createIngredient() {         //add new ingredient to inventory
        boolean end = true;
        ArrayList<Ingredient> added = new  ArrayList<Ingredient>();
        while (end == true) {
                System.out.println("Crear Ingrediente: ");
                String name = Lectura.readString("Name: ");
                int quantity = Lectura.getInt("Ingresar Cantidad");
                double unitaryPrice = Lectura.getFloat("Price");
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
                switch (choice) {
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
public static Chocolate createChocolate() {         //creates subclass Drink
        System.out.println("Crear Bebida: ");
        String name = Lectura.readString("Name");
        double price = Lectura.getFloat("Price:");
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
public static Drink createAll() {         //creates Drink type
        System.out.println("Crear Bebida: ");
        String name = Lectura.readString("Name");
        double price = Lectura.getFloat("Price:");
        System.out.println("Crear receta");
        Recipe recipe = createRecipe();
        String size = "";
        String code = Lectura.readString("Codigo de barras");
        int quantity = 0;
        String temp = "";
        return new Drink(price,code,name,size,recipe,quantity,temp);

}
public static void showInventory() {         //muestra inventario
        //displays updated inventory list
        ArrayList<Ingredient> list = readIngredients();
        boolean end = true;
        do {
                for (int i = 0; i < list.size(); i++) {
                        System.out.println((i+1)+". " + list.get(i));
                }
                int choice = choice(list.size(),"Escoge que ingrediente repostar");
                Ingredient curr = list.get(choice-1);
                int q = Lectura.getInt("Cantidad a repostar, en "+ curr.getMeasure());
                curr.setQuantity(curr.getQuantity() + q);
                Inventory f = new Inventory();

                if (choose("Desea repostar otro ingrediente?"))
                        end = true;
                else
                        end = false;

        } while(end == true);
        Inventory f = new Inventory();
        f.updateInventory(list,"C:\\Users\\paco\\Documents\\GitHub\\proyectoFinal\\data\\ingredients.dat");         //.setQuantity(
}

}
