import java.io.*;
import java.util.*;
private double[][] productsSales;//1.- Size 2.- Sales
private double[] products;//if Cafe == Caliente, etc.
class Tendency{
    //Construct
    public Tendency(double[][] productsSales, double[] products){
        setProductsSales(productsSales);
        setProducts(products);
    }
    //Set
    public void setProductsSales(double [][] productsSales){
          this.productsSales = productsSales;
    }
    public void setProducts(double[] products){
          this.products = products;
    }
    //Get
    public double[][] getProductsSales(){
          return productsSales;
    }
    public double[] getProducts(){
          return products;
    }
    //Display
    public String toString(){
          return " ";
    }
}
