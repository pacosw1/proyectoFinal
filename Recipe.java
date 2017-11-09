import java.io.*;
class Recipe implements Serializable{

  private Ingredient[] ingredients;

	public Recipe(Ingredient[] ingredients) {

		this.ingredients = ingredients;
	}


	public Ingredient[] ingredients() {
		return ingredients;
	}

  public double cost() { //sums all the prices of each ingredient with their quanity to get the actual cost of the recipe array;
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
		return ingredients + "";
	}
}
