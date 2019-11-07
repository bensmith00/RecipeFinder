package whatsForDinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Ingredient extends UserInput {

	public String name;
	public Boolean available = true;
	public List<Recipe> listRecipe = new ArrayList<Recipe>();
	
	public void createListRecipe (List<String[]> listStr, HashMap<String, Recipe> recipeMap, HashMap<String, Ingredient> ingredientMap) {
		for (String[] temp1 : listStr) {
			for (int i = 1; i < temp1.length; i++) {
				Ingredient ingredient = ingredientMap.get(temp1[i]);
				ingredient.listRecipe.add(recipeMap.get(temp1[0]));
			}
		}
	}
	
	public void changeAvailable(HashSet<String> unavailableIngredients, HashMap<String, Ingredient> ingredientMap) {

		for (String ingredient : unavailableIngredients) {
			ingredientMap.get(ingredient).available = false;
			for(Recipe recipe : ingredientMap.get(ingredient).listRecipe) {
				recipe.available = false;
			}
		}
	}
}
