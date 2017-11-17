import java.io.*;
class Ingredient implements Serializable {
private String name;
private double unitaryPrice;
private int quantity;
private String measure;
// This class creates an ingredient by creating an object with name unitary price, quanity and unitary measure (kg, mg, etc..)
public Ingredient(String name,int quantity, double unitaryPrice, String measure) {
        this.name = name;
        this.unitaryPrice = unitaryPrice;
        this.measure = measure;
        this.quantity = quantity;
}
public double price() {  // gets total price of ingredient
        return quantity*unitaryPrice;
}
public String getName() {
        return name;
}

public double getUnitaryPrice() {
        return unitaryPrice;
}

public int getQuantity() {
        return quantity;
}

public String getMeasure() {
        return measure;
}

public void setName(String name) {
        this.name = name;
}

public void setUnitaryPrice(double unitaryPrice) {
        this.unitaryPrice = unitaryPrice;
}

public void setQuantity(int quantity) {
        this.quantity = quantity;
}

public void setMeasure(String measure) {
        this.measure = measure;
}

@Override
public String toString() {
        return name + ""+"      ||Qnty: " + quantity + "      ||Unidad: "+measure;
}
}
