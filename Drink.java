class Drink extends Product {
protected String size;
protected Recipe recipe;
protected String name;
protected String temp;
//Construct
//Name?
public Drink(double price,String code, String name,String size, Recipe recipe, int quantity, String temp) {
        super(price,code,quantity);
        setSize(size);
        setRecipe(recipe);
        setName(name);
        setTemp(temp);
}
//Set

//Methods
//Obtains the cost for each recipe
public double cost() {
        return recipe.cost() * quantity;
}
public double total() {
        return price * quantity;
}
//Displays
public String toString() {
        return name + "   "+"$"+price;
}
public void setTemp(String temp){
        this.temp = temp;
}
//Get
public String getSize() {
        return size;
}

public Recipe getRecipe() {
        return recipe;
}

public String getName() {
        return name;
}


public void setSize(String size) {
        this.size = size;
}
public String getTemp(){
        return temp;
}
//Methods
//Obtains the cost for each recipe
public double cost() {
        return recipe.cost() * quantity;
}

public void setName(String name) {
        this.name = name;
}

public void setTemp(String temp) {
        this.temp = temp;
}
}
