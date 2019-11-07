package whatsForDinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pantry {
	
	public HashMap<String, Recipe> recipeMap = new HashMap<String, Recipe>();
	public HashMap<String, Ingredient> ingredientMap = new HashMap<String, Ingredient>();
	
	public HashMap<String, Recipe> createRecipeMap(List<String[]> listStr) {
		for (String[] temp1 : listStr) {
			Recipe recipe = new Recipe();
			recipe.name = temp1[0];
			recipeMap.putIfAbsent(temp1[0], recipe);	
		}
		return recipeMap;
	}
	
	public HashMap<String, Ingredient> createIngredientMap(List<String[]> listStr) {
		for (String[] temp1 : listStr) {
			for (int i = 1; i < temp1.length; i++) {
				Ingredient ingredient = new Ingredient();
				ingredient.name = temp1[i];
				ingredientMap.putIfAbsent(temp1[i], ingredient);	
			}

		}
		return ingredientMap;
	}
	
	public List<Recipe> availableRecipes(HashMap<String, Recipe> recipeMap) {
		List<Recipe> recipeList = new ArrayList<Recipe>();
		for ( Recipe recipe : recipeMap.values()) {
			if (recipe.available == true) {
				recipeList.add(recipe);
			}
		}
		return recipeList;
	}
	
}
