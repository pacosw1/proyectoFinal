class Recipe{
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
}
