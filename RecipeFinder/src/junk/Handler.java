package junk;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Handler {
	// "/home/beng/java/ingredients"
	// "/home/beng/java/recipes"
	// "/home/beng/java/recipeNames"
	public static String ingredientsFileName = "c:/java/ingredients.txt";
	public static String recipeIngredientsFile = "c:/java/recipes.txt";
	public static String recipeNames = "c:/java/recipeNames.txt";

	
    // Prints ingredient list to console
    public void list(List<String> list) {
		for (int i = 0; i < list.size(); i++) {				
				System.out.println( i+1 + ". " + list.get(i) + "\n");
		}
    }
    
    // Prints found recipes to console
    public void list(HashSet<String> list) {

    	System.out.println("\nFound Recipes: ");
    	for (String s : list) {
        	int i = 0;
        	i += i+1;
    	    System.out.println( i + ". " + s + "\n");
    	}
    }
    
    // Prints Recipes List to console
    public void list(List<String> recipeName, List<String> recipeIngredients){
		System.out.println("\nRecipes List: \n");
		for (int i = 0; i < recipeName.size(); i++) {
			List<String> ingredientList = new ArrayList<String>(Arrays.asList(recipeIngredients.get(i).split(" ")));
			System.out.println(recipeName.get(i) + "\n");
			list(ingredientList);
		}
	}
    
    // Reads fileName file
	public List<String> read(String fileName){
	   	 
	   	List<String> result = null;
	   	
	   	try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
	   		result = lines.collect(Collectors.toList());
	   	} catch (IOException e) {
				e.printStackTrace();
			}            
	   	return result;
		
	}
	
	// Saves new recipe to recipe list file
	public void save(String file, String recipe) {
		 FileWriter fileWriter = null;
			try {
				fileWriter = new FileWriter(file, true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		    PrintWriter printWriter = new PrintWriter(fileWriter);
		    printWriter.print("\n" + recipe);
		    printWriter.close();
		
	}
	
	// Saves ingredients to ingredients list file
	public void save(String file, List<String> ingredients) {
		 FileWriter fileWriter = null;
			try {
				fileWriter = new FileWriter(file, true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		    PrintWriter printWriter = new PrintWriter(fileWriter);
		    
			for (String ingredient : ingredients) {

			    printWriter.print(ingredient + "\n");
			}

		    printWriter.close();
		
	}
	
    // Add ingredients to recipe
	public String add(String recipeIngredients) {
		boolean done = false;
		while (done == false) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String ingredient = input.nextLine().trim();

			if (ingredient.equals("done")) {
				done = true;
			} else {
				recipeIngredients += ingredient + " ";
			}
		}
		return recipeIngredients;
	}
	
    // Add ingredients to ingredients list
	public List<String> add(List<String> ingredients) {
		
		boolean done = false;
		while (done == false) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String ingredient = input.nextLine().trim();

			if (ingredient.equals("done")) {
				done = true;
			} else {
				ingredients.add(ingredient);
			}
		}
		return ingredients;
	}
	
    // Return true if recipe is a match to ingredients
    public boolean check(List<String> recipe, List<String> ingredients) {
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
    
    // Add recipe name
	public String addName() {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String recipeName = input.nextLine();

		return recipeName;
	} 
	
	// Turns List<String> into List<List<String>> 
	public List<List<String>> split(List<String> list) {
		List<List<String>> recipesList = new ArrayList<List<String>>();

		for (String recipe : list) {
			recipesList.add(Arrays.asList(recipe.split(" ")));
		}
		return recipesList;
	}
	
	// Clears the ingredients file
	public static void clear(String fileName) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.print("");
		printWriter.close();
	}
		
	// Template for console menu
	public static void menu() {
		System.out.println("\nMENU \n1. Find Recipes \n2. Add Recipe \n3. Add Ingredients \n4. Recipes List \n5. Ingredients List \n6. Exit \n");
		
		System.out.println("Enter the name of the section: ");
	}

}



