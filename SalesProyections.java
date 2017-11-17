import java.io.*;
/*
  main
  double[][] currentSales = new double[4][];
  double[][] predefinedSales = new double[4][];
  byte more = 0;
  int buyer = 0;
  //PredefinedSales
  for(int i = 0; i < 4; i++){
    case(i){
    case 0: System.out.println("How many clients had bought coffees?");
            buyer = Lectura.readInt();
            for(int x = 0; x < buyer; x++){
            System.out.println("Total Past Coffee Sales:");
            double predefinedCoffeeSales = Lectura.readDouble();
            predefinedCoffeeSales *= Cafe.total();
            predefinedSales[i][x] = predefinedCoffeeSales;
            }
            break;
    case 1: System.out.println("How many clients had bought chocolate drinks?");
            buyer = Lectura.readInt();
            for(int x = 0; x < buyer; x++){
            System.out.println("Total Past Chocolate Drink Sales:");
            double predefinedChocolateSales = Lectura.readDouble();
            predefinedChocolateSales *= Chocolate.total();
            predefinedSales[i][x] = predefinedChocolateSales;
            }
            break;
    case 2: System.out.println("How many clients had bought teas?");
            buyer = Lectura.readInt();
            for(int x = 0; x < buyer; x++){
            System.out.println("Total Past Tea Sales:");
            double predefinedTeaSales = Lectura.readDouble();
            predefinedTeaSales *= Tea.total();
            predefinedSales[i][x] = predefinedTeaSales;
            }
            break;
    case 3: System.out.println("How many clients had bought Other drinks?");
            buyer = Lectura.readInt();
            for(int x = 0; x < buyer; x++){
            System.out.println("Total Past Other Drinks Sales:");
            double predefinedOthersSales = Lectura.readDouble();
            predefinedOthersSales *= Others.total();
            predefinedSales[i][x] = predefinedOthersSales;
            }
            break;
    }
}
  //Current Sales
  for(int i = 0; i < 4; i++){
    case(i){
    case 0: System.out.println("How many clients bought coffees?");
            buyer = Lectura.readInt();
            for(int x = 0; x < buyer; x++){
            System.out.println("How many coffees did client " + (buyer + 1) + " buy?");
            double coffeeSale = Lectura.readDouble();
            coffeeSale *= Cafe.total();
            currentSale[i][x] = coffeeSale;
            }
            break;
    case 1: System.out.println("How many clients bought chocolate drinks?");
            buyer = Lectura.readInt();
            for(int x = 0; x < buyer; x++){
            System.out.println("How many chocolate drinks did client " + (buyer + 1) + " buy?");
            double chocolateSale = Lectura.readDouble();
            chocolateSale *= Chocolate.total();
            currentSale[i][x] = chocolateSale;
            }
            break;
    case 2: System.out.println("How many clients bought teas?");
            buyer = Lectura.readInt();
            for(int x = 0; x < buyer; x++){
            System.out.println("How many teas did client " + (buyer + 1) + " buy?");
            double teaSale = Lectura.readDouble();
            teaSale *= Tea.total();
            currentSale[i][x] = teaSale;
            }
            break;
    case 3: System.out.println("How many clients bought other drinks?");
            buyer = Lectura.readInt();
            for(int x = 0; x < buyer; x++){
            System.out.println("Other products that client " + (buyer + 1) + " bought:");
            double otherSale = Lectura.readDouble();
            otherSale *= Others.total();
            currentSale[i][x] = otherSale;
            }
            break;
  }
}
*/
class SalesProyections{
  private long expectedTime;//Time to sell x product
  private double economyGrowthRate;//Changes the cost of dollars
  private Inventory inventoryProducts;
  private double[][] currentSales;//Sales per product, Products per Buyer
  private double[][] predefinedSales;
  //Construct
  public SalesProyections(long expectedTime, double economyGrowthRate, Inventory inventoryProducts,
  double[][] currentSales, double[][] predefinedSales){
    setExpectedTime(expectedTime);
    setEconomyGrowthRate(economyGrowthRate);
    setInventoryProducts(inventoryProducts);
    setCurrentSales(currentSales);
    setPredefinedSales(predefinedSales);
  }
  //Set
    public void setExpectedTime(long expectedTime){
        this.expectedTime = expectedTime;
    }
    public void setEconomyGrowthRate(double economyGrowthRate){
        this.economyGrowthRate = economyGrowthRate;
    }
    public void setInventoryProducts(Inventory inventoryProducts){
        this.inventoryProducts = inventoryProducts;
    }
    public void setCurrentSales(double[][] currentSales){
        this.currentSales = currentSales;
    }
    public void setPredefinedSales(double[][] predefinedSales){
        this.predefinedSales = predefinedSales;
    }
  //Get
  public long getExpectedTime(){
        return expectedTime;
  }
  public double getEconomyGrowthRate(){
        return economyGrowthRate;
  }
  public Inventory getInventoryProducts(){
        return inventoryProducts;
  }
  public double[][] getCurrentSales(){
        return currentSales;
  }
  public double[][] getPredefinedSales(){
        return predefinedSales;
  }
  //Methods
  public double salesPerClient(){
    return 2.3;
  }
  public double totalSalesCompany(){
    return 2.2;
  }
  public double totalSalesProduct(){
    return 5;
  }
  public double changeOfSales(){
    return 5.8;
  }
  public String salesTendencies(){//How much has a product sold, how much is left on the inventory, what to do.
    return 3.3;
  }
}
