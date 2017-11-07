class Drink extends Product{//Abstract or Inteface?
  protected String size;
  protected Recipe recipe;

  //Construct
	public Drink(String size, Recipe recipe, CurrentDate timestamp) {
		super(timestamp);
		setSize(size);
	}
  //Set
	public String getSize() {
		return size;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}


	@Override
	public String toString() {
		return "Drink [size=" + size + ", recipe=" + recipe + "]";
	}
}
