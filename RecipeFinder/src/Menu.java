import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {
	
	// Template for console menu
	public void template() throws IOException {
		System.out.println("\nMENU \n1. Find Recipes \n2. Add Recipe \n3. Add Ingredients \n4. Recipes List \n5. Ingredients List \n6. Settings \n7. Exit \n");
		
		System.out.println("Enter the name of the section: ");
	}
	
	// While loop that takes input and redirects to menu option selected
	public void options() throws IOException {
		
		Scanner input = new Scanner(System.in);
	    FindRecipes findRecipes = new FindRecipes();
	    Recipes recipes = new Recipes();
	    Ingredients ingredients = new Ingredients();
//	    Settings settings = new Settings();
		Menu menu = new Menu();

		// Menu template
	    template();
	    
	    boolean finished = false;
	    while (finished == false) {
			String instruction = input.nextLine(); 
			if (instruction.toLowerCase().equals("find recipes")) {
				findRecipes.search();
			} else if (instruction.toLowerCase().equals("add recipe")) {
				recipes.add();
			} else if (instruction.toLowerCase().equals("add ingredients")) {
				ingredients.add();
			} else if (instruction.toLowerCase().equals("recipes list")) {
				Recipes.printPretty();
				menu.template();
			} else if (instruction.toLowerCase().equals("ingredients list")) {
				Ingredients.ingredList();
				menu.template();
			} else if (instruction.toLowerCase().equals("settings")) {
				System.out.println("This section is under construction ");
				menu.template();
//				settings;
			} else if (instruction.toLowerCase().equals("exit")) {
				
				// 49,50,51,52 Erases ingredients file when finished with program
			    FileWriter fileWriter = new FileWriter("c:/java/ingredients.txt");
			    PrintWriter printWriter = new PrintWriter(fileWriter);
			    printWriter.print("");
			    printWriter.close();
			    
			    input.close();
			    
			    // Breaks while loop
				finished = true;
			} else {
				continue;
			}
	    }	
	}

}
