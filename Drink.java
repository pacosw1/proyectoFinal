class Drink extends Product  {//Abstract or Inteface?
  protected String size;
  protected Recipe recipe;
  protected String name;



  //Construct
	public Drink(double price,String code, String name,String size, Recipe recipe, int quantity) {
    super(price,code,quantity);
		setSize(size);
    setRecipe(recipe);
    setName(name);
    setCode(code);
	}
  //Set

 public double cost() {
   return recipe.cost();
 }
  public String toString() {
    return "Drink [size=" + size + ", recipe=" + recipe + ", name=" + name + ", code=" + code + "]";
  }

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
}
