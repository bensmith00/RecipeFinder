import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class startApp {

	public static void main(String[] args) {

		List<String> ingredients = Arrays.asList("a","b","c");

		System.out.print(ingredients);


		List<List<String>> recipesList = new ArrayList<List<String>>();

		List<String> recipe1 = Arrays.asList("a","b","c");
		List<String> recipe2 = Arrays.asList("a","b");
		List<String> recipe3 = Arrays.asList("a");
		List<String> recipe4 = Arrays.asList("b","c");
		List<String> recipe5 = Arrays.asList("c");
		List<String> recipe6 = Arrays.asList("b");
		List<String> recipe7 = Arrays.asList("c","d","e");
		List<String> recipe8 = Arrays.asList("a","b","c","d");
		List<String> recipe9 = Arrays.asList("a","b","c","d","e");
		List<String> recipe10 = Arrays.asList("f","e");
		List<String> recipe11 = Arrays.asList("d");
		List<String> recipe12 = Arrays.asList("a","b","c","d","e","f");
		List<String> recipe13 = Arrays.asList("a","c");
		List<String> recipe14 = Arrays.asList("b","c","d","e");

		
		recipesList.add(recipe1);
		recipesList.add(recipe2);
		recipesList.add(recipe3);
		recipesList.add(recipe4);
		recipesList.add(recipe5);
		recipesList.add(recipe6);
		recipesList.add(recipe7);
		recipesList.add(recipe8);
		recipesList.add(recipe9);
		recipesList.add(recipe10);
		recipesList.add(recipe11);
		recipesList.add(recipe12);
		recipesList.add(recipe13);
		recipesList.add(recipe14);
		
		String result = findRecipes.search(recipesList, ingredients);
		
		System.out.println(result);
		
//		for(List<String> recipe : recipesList) {
//			Collections.sort(recipe);
//		}
//
//		
//		List<List<String>> listToSort = new ArrayList<>(recipesList);
//		listToSort.sort((l1, l2) -> l1.get(0).compareTo(l2.get(0)));
//	
//		System.out.println(listToSort);
//		
//		Collections.sort(listToSort, (string1, string2) -> Integer.compare(string1.size(), string2.size()));
//		
//		for(List<String> recipe : listToSort) {
//			System.out.print("\n");
//			System.out.print(recipe);
//		}
	}
}


	
	
	
