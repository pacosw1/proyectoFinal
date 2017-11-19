class Tea extends Drink{
  private String type;
  public Tea(double price,String code, String name,String size, Recipe recipe, int quantity, String temp,String type){     //blanco o negro (chocolate)
          super(price,code,name,size,recipe, quantity, temp);
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
  public void setTemp(String temp){
          this.temp = temp;
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
  public String getTemp(){
          return temp;
  }
  //Method
  public double total(){
    return price * quantity;
  }
}
