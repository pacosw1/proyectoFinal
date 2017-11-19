import java.io.*;
class SalesProyections implements Serializable{
  public SalesProyections(){
  }

  public void salesTendencies(){
    //How much has a product sold, how much is left on the inventory, what to do.
  }
  //Display
  public String toString(){
    totalClientSales();
    changeOfSales();
    salesTendencies();

   return "Sales Proyections Report: \nTotal Client Sales: \nChange of Sales: ";
  }
}
