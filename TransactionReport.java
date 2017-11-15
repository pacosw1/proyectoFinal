class TransactionReport extends Report {

private double totalCost;
private double totalPrice;
private double highestTransaction = 0.0;
private double profit;
private double losses;
private double profitMargin;
public TransactionReport(CurrentDate date, String title, SaveToFile save, String fileName) {
        super(date, title, fileName,save);
}


public String[] names() {
        Field[] f = TransactionReport.class.getDeclaredFields();
        String[] name = new String[f.length];
        for (int i = 0; i < f.length; i++) {
                name[i] = (String)f[i].getName();
        }
} //abstract class
public ArrayList<String> values() {
        ArrayList<String> n = new ArrayString<String>();
        n.add(String.valueOf(totalCost));
        n.add(String.valueOf(totalPrice));
        n.add(String.valueOf(highestTransaction));
        n.add(String.valueOf(profit));
        n.add(String.valueOf(losses));
        n.add(String.valueOf(profitMargin));
        return n;
}

public double bestProduct() {
        double best = 0.0; String name = ""; double profit = 0.0; //var declaration
        for (int i = 0; i < data().size(); i++) { //transaction array
                ArrayList<Product> curr = data.get(i).getProduct(); //product array
                for (int j = 0; k < curr.size(); j++) {
                        Drink product = (Drink)curr.get(j);
                        profit = product.total() - product.cost();
                        if (profit > best) { //checks for highest profit of all products (saves name and profit)
                                best = profit;
                                name = product.getName();
                        }
                }
        }
}
public void data() {
        data = data.readTransactions("C:\\Users\\paco\\Desktop\\transactions.dat"); //returns data from .dat file as arraylist
}
public double losses() {
        for (int i = 0; i < data().size(); i++) {
                ArrayList<Product> curr = data.get(i).getProduct();
                for (int j = 0; k < curr.size(); j++) {
                        Drink product = (Drink)curr.get(j);
                        if (product.total() - product.cost() < 0) //checks if there are any losses in products.
                                losses+= Math.abs(product.total() - product.cost());
                }
        }
}
public void totals() {
        double cost = 0.0; double price = 0.0;
        for (int i = 0; i < data.size(); i++) {
                totalCost += data.get(i).cost(); //totals per transactions. Declared in transaction class
                totalPrice += data.get(i).total();
        }
}
public void profits() {
        profit = (totalPrice - totalCost);
        profitMargin =  (totalPrice - totalCost) / totalCost;
}

}
