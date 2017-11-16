class Drink extends Product {
protected String size;
protected Recipe recipe;
protected String name;
protected String temp;
//Construct
public Drink(double price,String code, String name,String size, Recipe recipe, int quantity, String temp) {
        super(price,code,quantity);
        setSize(size);
        setRecipe(recipe);
        setName(name);
        this.temp = temp;
}
//Set
public void setSize(String size) {
        this.size = size;
}
public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
}
public void setName(String name) {
        this.name = name;
}
public void setCode(String code) {
        this.code = code;
}
public void setPrice(double price){
        this.price = price;
}
public void setQuantity(int quantity){
        this.quantity = quantity;
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
public String getCode() {
        return code;
}
public double getPrice(){
        return price;
}
public int getQuantity(){
        return quantity;
}
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
}
