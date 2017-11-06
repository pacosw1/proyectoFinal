class Ingredients{
private String nameIngredient;
private String weight;
private int quantity;
private double unitaryPrice;
  //Construct
  public Ingredients(String nameIngredient, String weight, int quantity, double unitaryPrice){
    setNameIngredient(nameIngredient);
    setWeight(weight);
    setQuantity(quantity);
    setUnitaryPrice(unitaryPrice);
  }
  //Set
  public void setNameIngredient(String nameIngredient){
    this.nameIngredient = nameIngredient;
  }
  public void setWeight(String weight){
    this.weight = weight;
  }
  public void setQuantity(int quantity){
    this.quantity = quantity;
  }
  public void setUnitaryPrice(double unitaryPrice){
    this.unitaryPrice = unitaryPrice;
  }
  //Get
  public String getNameIngredient(){
    return nameIngredient;
  }
  public String getWeight(){
    return weight;
  }
  public int getQuantity(){
    return quantity;
  }
  public double getUnitaryPrice(){
    return unitaryPrice;
  }
}
