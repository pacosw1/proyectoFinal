class Chocolate extends Drink  {
//Construct
private String type;
public Chocolate(double price,String code, String name,String size, Recipe recipe,String type, int quantity){     //blanco o negro (chocolate)
        super(price,code,name,size,recipe, quantity);
        setType(type);
}
//Set
public void setPrice(double price){
        this.price = price;
}
public void setCode(String code){
        this.code = code;
}
public void setName(String name){
        this.name = name;
}
public void setSize(String size){
        this.size = size;
}
public void setRecipe(Recipe recipe){
        this.recipe = recipe;
}
public void setType(String type){
        this.type = type;
}
public void setQuantity(int quantity){
        this.quantity = quantity;
}
//Get
public double getPrice(){
        return price;
}
public String getCode(){
        return code;
}
public String getName(){
        return name;
}
public String getSize(){
        return size;
}
public Recipe getRecipe(){
        return recipe;
}
public String getType(){
        return type;
}
public int getQuantity(){
        return quantity;
}
public double total(){
  return price * quaintity;
}
}
