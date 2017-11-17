import java.io.*;
/*
public static void main(String[] args){
     double[] currentSales = new double[4];
     double[] predefinedSales = new double[4];
     byte more = 0;
     double totalSales = 0;
     int buyer = 0;
     //PredefinedSales
     for(int i = 0; i < 4; i++){
       switch(i){
          case 0: System.out.println("How many clients had bought coffees?");
                  buyer = Lectura.readInt();
                  double[][] coffeSalesArray = new double [4][buyer];
                  for(int x = 0; x < buyer; x++){
                     System.out.println("Total Past Coffee Sales:");
                     double predefinedCoffeeSales = Lectura.readDouble();
                     predefinedCoffeeSales *= 24;//Cafe.total();
                     coffeSalesArray[i][x] = predefinedCoffeeSales;
                     predefinedSales[i] += coffeSalesArray[i][x];
                     totalSales += predefinedSales[i];
                  }
                  break;
          case 1: System.out.println("How many clients had bought chocolate drinks?");
                  buyer = Lectura.readInt();
                  double[][] chocolateSalesArray = new double [4][buyer];
                  for(int x = 0; x < buyer; x++){
                     System.out.println("Total Past Chocolate Drink Sales:");
                     double predefinedChocolateSales = Lectura.readDouble();
                     predefinedChocolateSales *= 24;//Chocolate.total();
                     chocolateSalesArray[i][x] = predefinedChocolateSales;
                     predefinedSales[i] += chocolateSalesArray[i][x];
                     totalSales += predefinedSales[i];
                  }
                  break;
          case 2: System.out.println("How many clients had bought teas?");
                  buyer = Lectura.readInt();
                  double[][] teaSalesArray = new double [4][buyer];
                  for(int x = 0; x < buyer; x++){
                     System.out.println("Total Past Tea Sales:");
                     double predefinedTeaSales = Lectura.readDouble();
                     predefinedTeaSales *= 24;//Tea.total();
                     teaSalesArray[i][x] = predefinedTeaSales;
                     predefinedSales[i] += teaSalesArray[i][x];
                     totalSales += predefinedSales[i];
                  }
                  break;
          case 3: System.out.println("How many clients had bought Other drinks?");
                  buyer = Lectura.readInt();
                  double[][] otherSalesArray = new double [4][buyer];
                  for(int x = 0; x < buyer; x++){
                     System.out.println("Total Past Other Drinks Sales:");
                     double predefinedOthersSales = Lectura.readDouble();
                     predefinedOthersSales *= 24;//Others.total();
                     otherSalesArray[i][x] = predefinedOthersSales;
                     predefinedSales[i] += otherSalesArray[i][x];
                     totalSales += predefinedSales[i];
                  }
                  break;
          }
   }
     //Current Sales
     for(int i = 0; i < 4; i++){
       switch(i){
          case 0: System.out.println("How many clients bought coffees?");
                  buyer = Lectura.readInt();
                  double[][] newCoffeSalesArray = new double [4][buyer];
                  for(int x = 0; x < buyer; x++){
                     System.out.println("How many coffees did client " + (buyer + 1) + " buy?");
                     double coffeeSale = Lectura.readDouble();
                     coffeeSale *= 12;//Cafe.total();
                     newCoffeSalesArray[i][x] = coffeeSale;
                     currentSales[i] += newCoffeSalesArray[i][x];
                     totalSales += currentSales[i];
                  }
                  break;
          case 1: System.out.println("How many clients bought chocolate drinks?");
                  buyer = Lectura.readInt();
                  double[][] newChocolateSalesArray = new double [4][buyer];
                  for(int x = 0; x < buyer; x++){
                     System.out.println("How many chocolate drinks did client " + (buyer + 1) + " buy?");
                     double chocolateSale = Lectura.readDouble();
                     chocolateSale *= 12;//Chocolate.total();
                     newChocolateSalesArray[i][x] = chocolateSale;
                     currentSales[i] += newChocolateSalesArray[i][x];
                     totalSales += currentSales[i];
                  }
                  break;
          case 2: System.out.println("How many clients bought teas?");
                  buyer = Lectura.readInt();
                  double[][] newTeaSalesArray = new double [4][buyer];
                  for(int x = 0; x < buyer; x++){
                     System.out.println("How many teas did client " + (buyer + 1) + " buy?");
                     double teaSale = Lectura.readDouble();
                     teaSale *= 12;//Tea.total();
                     newTeaSalesArray[i][x] = teaSale;
                     currentSales[i] += newTeaSalesArray[i][x];
                     totalSales += currentSales[i];
                  }
                  break;
          case 3: System.out.println("How many clients bought other drinks?");
                  buyer = Lectura.readInt();
                  double[][] newOtherSalesArray = new double [4][buyer];
                  for(int x = 0; x < buyer; x++){
                     System.out.println("Other products that client " + (buyer + 1) + " bought:");
                     double otherSale = Lectura.readDouble();
                     otherSale *= 12;//Others.total();
                     newOtherSalesArray[i][x] = otherSale;
                     currentSales[i] += newOtherSalesArray[i][x];
                     totalSales += currentSales[i];
                     }
                  break;
        }
      }

      System.out.println("Time expected to sell all the products:");
      long timeExpected = Lectura.readLong();
      System.out.println("Insert the percentage in change of value of dollars:");
      double economyGrowth = Lectura.readDouble();
      System.out.println("Remaining in
      ventory for products");
      int inventoryProducts = Lectura.readInt();
      SalesProyections tibia = new SalesProyections(timeExpected, economyGrowth, inventoryProducts, currentSales, predefinedSales, totalSales);
      System.out.println(tibia);
   }
*/
class SalesProyections{
  private long expectedTime;//Time to sell x product
  private double economyGrowthRate;//Changes the cost of dollars
  //private Inventory inventoryProducts; <--- How it should be done.
  private int inventoryProducts;
  private double[] currentSales;//Total Sales per product
  private double[] predefinedSales;
  private double totalSales;
  //Construct
  public SalesProyections(long expectedTime, double economyGrowthRate, int inventoryProducts,//Inventory inventoryProducts,
  double[] currentSales, double[] predefinedSales, double totalSales){
    setExpectedTime(expectedTime);
    setEconomyGrowthRate(economyGrowthRate);
    setInventoryProducts(inventoryProducts);
    setCurrentSales(currentSales);
    setPredefinedSales(predefinedSales);
    setTotalSales(totalSales);
  }
  //Set
    public void setExpectedTime(long expectedTime){
        this.expectedTime = expectedTime;
    }
    public void setEconomyGrowthRate(double economyGrowthRate){
        this.economyGrowthRate = economyGrowthRate;
    }
    /*public void setInventoryProducts(Inventory inventoryProducts){
        this.inventoryProducts = inventoryProducts;
    }*/
    public void setInventoryProducts(int inventoryProducts){
        this.inventoryProducts = inventoryProducts;
    }
    public void setCurrentSales(double[] currentSales){
        this.currentSales = currentSales;
    }
    public void setPredefinedSales(double[] predefinedSales){
        this.predefinedSales = predefinedSales;
    }
    public void setTotalSales(double totalSales){
        this.totalSales = totalSales;
    }
  //Get
  public long getExpectedTime(){
        return expectedTime;
  }
  public double getEconomyGrowthRate(){
        return economyGrowthRate;
  }
  /*public Inventory getInventoryProducts(){
        return inventoryProducts;
  }*/
  public int getInventoryProducts(){
        return inventoryProducts;
  }
  public double[] getCurrentSales(){
        return currentSales;
  }
  public double[] getPredefinedSales(){
        return predefinedSales;
  }
  public double getTotalSales(){//Display this
        return totalSales;
  }
  //Methods
  public void totalClientSales(){//Self Explanitory, new ones
      for(int i = 0; i < 4; i++){
       switch(i){
          case 0: System.out.println("Total Coffee Sales: " + currentSales[i]);
                  break;
          case 1: System.out.println("Total Chocolate Drink Sales: " + currentSales[i]);
                  break;
          case 2: System.out.println("Total Tea Sales: " + currentSales[i]);
                  break;
          case 3: System.out.println("Total Other Drinks Sales: " + currentSales[i]);
                  break;
          }
      }

  }
  public void changeOfSales(){//Subtract past and present to know the overall change
  double change = 0;
      for(int i = 0; i < 4; i++){
       switch(i){
          case 0: change = predefinedSales[i] - currentSales[i];
                  if(change < 0){
                     System.out.println("There has been an increase on Coffee sales by $" + (Math.abs(change)));
                  }
                  else{
                     System.out.println("There has been a decrease on Coffee sales by $" + (change * -1));
                  }
                  break;
          case 1: change = predefinedSales[i] - currentSales[i];
                  if(change < 0){
                     System.out.println("There has been an increase on Chocolate drink sales by $" + (Math.abs(change)));
                  }
                  else{
                     System.out.println("There has been a decrease on Chocolate drink sales by $" + (change * -1));
                  }
                  break;
          case 2: change = predefinedSales[i] - currentSales[i];
                  if(change < 0){
                     System.out.println("There has been an increase on Tea sales by $" + (Math.abs(change)));
                  }
                  else{
                     System.out.println("There has been a decrease on Tea sales by $" + (change * -1));
                  }
                  break;
          case 3: change = predefinedSales[i] - currentSales[i];
                  if(change < 0){
                     System.out.println("There has been an increase on Other drinks sales by $" + (Math.abs(change)));
                  }
                  else{
                     System.out.println("There has been a decrease on Other drinks sales by $" + (change * -1));
                  }
                  break;
          }
      }
  }
  /*public String salesTendencies(){//How much has a product sold, how much is left on the inventory, what to do.
    return "Hello";
  }*/
  //Display
  public String toString(){
    totalClientSales();
    changeOfSales();

   return "Sales Proyections Report: \nTotal Client Sales: \nChange of Sales: ";
  }
}
