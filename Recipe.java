import java.io.*;
import java.util.*;
class Recipe implements Serializable {

private ArrayList<Ingredient> ingredients;

public Recipe(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
}

public ArrayList<Ingredient> ingredients() {
        return ingredients;
}

public double cost(){//sums all the prices of each ingredient with their quanity to get the actual cost of the recipe array;
        double sum = 0;
        for (int i = 0; i < ingredients.size(); i++) {
                sum+= ingredients.get(i).price() * ingredients.get(i).getQuantity();
        }
        return sum;
}


public ArrayList<Ingredient> getIngredients() {
        return ingredients;
}
@Override
public String toString() {
        return ingredients + "";
}
}
