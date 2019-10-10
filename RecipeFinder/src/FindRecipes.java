import java.io.IOException;
import java.util.List;

public class FindRecipes {
	
	// Searches recipes for matching ingredients
	public String search() throws IOException {
		List<String> ingredients = Ingredients.read();
		List<String> recipes = Recipes.read();
		List<List<String>> recipesList = Recipes.changeListStrToList(recipes);

		int i;
	    int maxNum = recipesList.size()-1;
	    boolean isRecipe = false;
	
	    String recipesFound = "";
	
	    // Iterates through recipes
	    int count = 1;
	    for (i = 0; i <= maxNum; i++) {
	        isRecipe = Recipes.check(recipesList.get(i), ingredients);
	        
	        // Prints matching recipes to console
	        if (isRecipe) {
	        	recipesFound +=  count + ". ";
	        	count += 1;
	        	for (int ingredient = 0; ingredient < recipesList.get(i).size(); ingredient++) {
		            recipesFound += (recipesList.get(i).get(ingredient).toString() + " ");
				}
	        	recipesFound += "\n";
	        }
	    }
	    System.out.println("\nThe matching recipes are: ");
		System.out.print(recipesFound + "\n");
		
		Menu menu = new Menu();
		menu.template();
		return recipesFound;
	    
	
	}
 
}
