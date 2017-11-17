import java.io.*;
/*
  main
  double[][] currentSales = new double[][];
  double[][] predefinedSales = new double[][];
  byte more = 0;
  do{
  System.out.println("Past Coffee Sales:");//PredefinedSales
  double predefinedCoffeeSales = Lectura.readDouble();
  System.out.println("Past Coffee Sales:");
  double predefinedChocolateSales = Lectura.readDouble();
  System.out.println("Past Coffee Sales:");
  double predefinedTeaSales = Lectura.readDouble();
  System.out.println("Past Coffee Sales:");
  double predefinedOthersSales = Lectura.readDouble();
  //Current Sales
  Cafe.sales();
  Chocolate.sales();
  Tea.sales();
  Others.sales();
  int coffeBuyers;
  int chocolateBuyers;
  int teaBuyers;
  int otherBuyers;
  System.out.println("Want to register more? 1 yes, 0 no");
  more = Lectura.readByte();
}while(more == 1);
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
