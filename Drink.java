class Drink extends Product {
  protected String size;
  protected Recipe recipe;
  protected String name;
  //Construct
  	public Drink(double price,String code, String name,String size, Recipe recipe, int quantity) {
      super(price,code,quantity);
  		setSize(size);
      setRecipe(recipe);
      setName(name);
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
      return recipe.cost();
    }
  //Displays
    public String toString() {/
      return "Drink [size=" + size + ", recipe=" + recipe + ", name=" + name + ", code=" + code + "]";
    }
}
