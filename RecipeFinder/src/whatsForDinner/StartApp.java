package whatsForDinner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class StartApp {
	public static void main(String[] args) {

		File fileObj = new File();
		Pantry pantry = new Pantry();
		UserInput uI = new UserInput();
		List<String> list = fileObj.read("c:/java/recipes.txt");
		List<String[]> listStr = fileObj.createListStringArr(list);		

	    HashMap<String, Recipe> recipeMap = pantry.createRecipeMap(listStr);
	    HashMap<String, Ingredient> ingredientMap = pantry.createIngredientMap(listStr);
	    
	    for (Ingredient ingred : pantry.ingredientMap.values()) {
	    	System.out.print("| " + ingred.name + " ");
	    }
	    
    	System.out.println("|");
    	System.out.println();

		Ingredient ingredient = new Ingredient();
	    ingredient.createListRecipe(listStr, recipeMap, ingredientMap);
	    
		System.out.println("Enter in the ingredients that are missing from the pantry");
	    HashSet<String> input = uI.userInput();

		ingredient.changeAvailable(input, ingredientMap);
		List<Recipe> availableRecipes = pantry.availableRecipes(recipeMap);
		
    	System.out.println();
		System.out.println("The available recipes are: ");
		for (Recipe recipe : availableRecipes) {
			System.out.println(recipe.name);
		}
	}


}
