import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Recipes {
	
	// Adds new recipes to recipes file after input == 'done'
	public void add() throws IOException {
		System.out.println("Enter the ingredients for the recipe one at a time. Press Enter to submit ingredient. Type 'DONE' when recipe is complete");



		boolean done = false;
		while (done == false) {
			String textToAppend = "";
			Scanner recipe1 = new Scanner(System.in);
			String ingredient = recipe1.nextLine();

			if (ingredient.equals("done")) {
				done = true;
			    FileWriter fileWriter = new FileWriter("c:/java/recipes.txt", true);
			    PrintWriter printWriter = new PrintWriter(fileWriter);
			    printWriter.println();
			    printWriter.close();
				printPretty();
			} else {
				textToAppend += ingredient + "/";
			    FileWriter fileWriter = new FileWriter("c:/java/recipes.txt", true);
			    PrintWriter printWriter = new PrintWriter(fileWriter);
			    printWriter.print(textToAppend);
			    printWriter.close();
			}

		}
		

		Menu menu = new Menu();
		menu.template();
	}

    // Reads recipes file and returns List<String> of recipes
    public static List<String> read() throws IOException {
    	 
    	List<String> result;
    	
    	try (Stream<String> lines = Files.lines(Paths.get("c:/java/recipes.txt"))) {
    		result = lines.collect(Collectors.toList());
    	}            
    	return result;
    	
    }
    
    // Prints Recipes List to console
    public static void printPretty() throws IOException {
		List<String> temp = read();
		System.out.println("\nRecipes List: ");
		for (int i = 1; i <= temp.size(); i++) {
			List<String> myList = new ArrayList<String>(Arrays.asList(temp.get(i-1).split("/")));
			System.out.println( i + ". " + myList + "\n");
		}
	}
    
    // Converts List<String> to List<List<String>>
    public static List<List<String>> changeListStrToList(List<String> recipes) {
    	List<List<String>> recipeList = new ArrayList<List<String>>();
    	
    	for (String recipe : recipes) {
    		List<String> myList = new ArrayList<String>(Arrays.asList(recipe.split("/")));
    		recipeList.add(myList);
    	}
    	
    	return recipeList;
    }
    
    
    // Return true if recipe is a match to ingredients
    public static boolean check(List<String> recipe, List<String> ingredients) {
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
	
