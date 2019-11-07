package junk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HashMapSearch extends Handler {
	
	Map<String, List<String>> recipeMap = new LinkedHashMap<String, List<String>>();
	Map<String, HashSet<String>> ingredientMap = new HashMap<String, HashSet<String>>();
	
	public void recipeMap() {
		Scanner scanner = null;
		List<String> recipesNames = read(recipeNames);
		try {
			scanner = new Scanner(new File(Handler.recipeIngredientsFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scanner.hasNextLine()){
			for (String recipeName : recipesNames) {
		        if (!recipeMap.containsKey(recipeName))
		            recipeMap.put(recipeName, new LinkedList<String>());
		        List<String> myList = new ArrayList<String>(Arrays.asList(scanner.nextLine().split(" ")));
		        recipeMap.get(recipeName).addAll(myList);
			}

		}
	}
	
	public void ingredientMap() {
		for (Map.Entry<String, List<String>> entry : recipeMap.entrySet()) {
			List<String> ingredientList = entry.getValue();
			for (String ingredient : ingredientList) {
				String ingredientTrim = ingredient.trim();
		        if (!ingredientMap.containsKey(ingredientTrim))
		        	ingredientMap.put(ingredientTrim, new HashSet<String>());
		        for (Map.Entry<String, List<String>> entry2 : recipeMap.entrySet()) {
		        	if (entry2.getValue().contains(ingredientTrim)) {
		        		ingredientMap.get(ingredientTrim).add(entry2.getKey());
		        	}
		        }
		        
			}

		}
	}
	
	public HashSet<String> findRecipes() {
		List<String> ingredientList = read(ingredientsFileName);
		HashSet<String> foundRecipes = new HashSet<>();
		for (String ingredient : ingredientList) {
			HashSet<String> temp = ingredientMap.get(ingredient);
			if (temp == null) {
				continue;
			} else {
				for (String recipe : temp) {
					List<String> recipeName = recipeMap.get(recipe);
					if(ingredientList.containsAll(recipeName)) {
						foundRecipes.add(recipe);
					}
				}
			}
		}
		return(foundRecipes);
	}
}