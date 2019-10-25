package whatsForDinner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Menu extends HashMapSearch {
    
	// While loop that takes input and redirects to menu option selected
	public void options() {

		Scanner input = new Scanner(System.in);
		
		// Prints Menu Options
		menu();

	    
	    boolean finished = false;
	    while (finished == false) {
			String instruction = input.nextLine().toLowerCase(); 
			
			if (instruction.equals("find recipes")) {

				option1();
				
			} else if (instruction.equals("add recipe")) {
				
				option2();
				
			} else if (instruction.equals("add ingredients")) {
				
				option3();
				
			} else if (instruction.equals("recipes list")) {
				
				option4();
				
			} else if (instruction.equals("ingredients list")) {

				option5();		
				
			} else if (instruction.equals("exit")) {
				
				finished = option6(input);
				
			} else {
				continue;
			}
	    }	
	}
	
	// Find the recipes that can be made
	private void option1() {

		// Reads recipe and ingredient files to hash maps
		recipeMap();
		ingredientMap();
		HashSet<String> foundRecipes = findRecipes();
		list(foundRecipes);
		
		// Prints Menu Options
		menu();
	}	
	
	// Add a new recipe
	private void option2() {
		System.out.println("Enter the recipe name. Press Enter to submit. ");
		save(recipeNames , addName());
		
		System.out.println("Enter the ingredients for the recipe one at a time. Press Enter to submit ingredient. Type 'DONE' when recipe is complete");
		String recipeIngredients = "";
		String recipe = add(recipeIngredients);
		save(recipeIngredientsFile , recipe);
		
		// Prints Menu Options
		menu();
	}
		
	// Add more ingredients
	private void option3() {
		System.out.println("Enter the ingredients one at a time without a space at the end. Press Enter to submit ingredient. Type 'DONE' when the ingredients are complete");
		List<String> temp = new ArrayList<String>();
		List<String> ingredients = add(temp);
		save(ingredientsFileName , ingredients);
		
		// Prints Menu Options
		menu();
	}
		
	// Print recipes file
	private void option4() {
		
		list(read(recipeNames), read(recipeIngredientsFile));
		
		// Prints Menu Options
		menu();
	}
		
	// Print ingredients file 
	private void option5() {
		System.out.println("\nIngredients List: ");
		list(read(ingredientsFileName));
		
		// Prints Menu Options
		menu();
	}
	
	// Ends program and clears ingredient file
	private boolean option6(Scanner input) {

		// Erases ingredients file when finished with program
		clear(ingredientsFileName);
		
		input.close();
		
		// Breaks while loop
		boolean finished = true;
		return finished;
	}
}
