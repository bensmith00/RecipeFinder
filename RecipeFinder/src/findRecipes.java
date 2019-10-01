import java.util.List;

public class findRecipes {
	
	public static String search(List<List<String>> recipes, List<String> ingredients) {
	int i;
    int maxNum = recipes.size()-1;
    boolean isRecipe = true;

    String recipesFound = "\n";

    for (i = 1; i <= maxNum; i++) {
        isRecipe = CheckRecipe(recipes.get(i), ingredients);
        if (isRecipe) {
            recipesFound = recipesFound + recipes.get(i) + "\n";
        }
    }

	return recipesFound;
    

	}
	
    public static boolean CheckRecipe(List<String> recipe, List<String> ingredients) {
        String ingredient;
        for (int i = 0; i <= recipe.size()-1; i++) {
        	ingredient = recipe.get(i);
            //If ingredient is in ingredients return false and break loop. Else continue loop
            if (!ingredients.contains(ingredient)) {
                return false;
            }
        }
        return true;
 
    }
}
