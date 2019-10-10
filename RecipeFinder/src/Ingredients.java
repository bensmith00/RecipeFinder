import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ingredients {
	public void add() throws IOException {
		System.out.println("Enter the ingredients one at a time without a space at the end. Press Enter to submit ingredient. Type 'DONE' when the ingredients	are complete");

		boolean done = false;
		while (done == false) {
		Scanner input = new Scanner(System.in);
		String ingredient = input.nextLine();
		String ingredients = "";

			if (ingredient.equals("done")) {
				done = true;
			    FileWriter fileWriter = new FileWriter("c:/java/ingredients.txt", true);
			    PrintWriter printWriter = new PrintWriter(fileWriter);
			    printWriter.println();
			    printWriter.close();
			} else {
				ingredients += ingredient + ",";
			    FileWriter fileWriter = new FileWriter("c:/java/ingredients.txt", true);
			    PrintWriter printWriter = new PrintWriter(fileWriter);
			    printWriter.print(ingredients);  //New line
			    printWriter.close();
			}
		}

		ingredList();
		Menu menu = new Menu();
		menu.template();
	}
	
	
    public static List<String> read() throws FileNotFoundException{
    	Scanner s = new Scanner(new File("c:/java/ingredients.txt"));
    	String list = "";
    	while (s.hasNextLine()){
    	    list += s.nextLine();
    	}
		List<String> myList = new ArrayList<String>(Arrays.asList(list.split(",")));
    	s.close();
		return myList;

    }
    
    public static void ingredList() throws FileNotFoundException {
		System.out.println("\nIngredients List: ");
		System.out.println(Ingredients.read());
	}
    
    
}

