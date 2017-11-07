class Recipe{
<<<<<<< HEAD
  private Ingredient[] ingredients;

	public Recipe(Ingredient[] ingredients) {
		super();
		this.ingredients = ingredients;
	}


	public Ingredient[] ingredients() {
		return ingredients;
	}

  public double price() { //sums all the prices of each ingredient with their quanity to get the actual cost of the recipe array;
    double sum = 0;
    for (int i = 0;i < ingredients.length;i++) {
      sum+= ingredients[i].price();
    }
    return sum;
  }

	public void setT(Ingredient[] Ingredient) {
		this.ingredients = ingredients;
	}


	@Override
	public String toString() {
		return ingredients;
	}
=======
private quantity;
private Ingredients[][] foodIngredient;//2-Diemnsional array Ingredients
private double[][] price;//2-Diemnsional array price
  //Construct
    public Recipe(Ingredients[][] foodIngredient, double[][] price){
      setFoodIngredient(foodIngredient);
      setPrice(price);
    }
  //Set
    public void setFoodIngredient(Ingredients[][] foodIngredient){
      this.foodIngredient = foodIngredient;
    }
    public void setPrice(double[][] price){
      this.price = price;
    }
  //Get
    public Ingredients[][] getFoodIngredient(){
      return foodIngredient;
    }
    public double[][] getPrice(){
      return price;
    }
>>>>>>> f9ab885f52351afb595159d34d874785df0e13b1
}
