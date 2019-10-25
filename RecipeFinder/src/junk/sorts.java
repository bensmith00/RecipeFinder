//package junk;
//import java.util.ArrayList;
//import java.util.List;
//
//public class sorts {
//	for(List<String> recipe : recipesList) {
//		Collections.sort(recipe);
//	}
//
//	
//	List<List<String>> listToSort = new ArrayList<>(recipesList);
//	listToSort.sort((l1, l2) -> l1.get(0).compareTo(l2.get(0)));
//
//	System.out.println(listToSort);
//	
//	Collections.sort(listToSort, (string1, string2) -> Integer.compare(string1.size(), string2.size()));
//	
//	for(List<String> recipe : listToSort) {
//		System.out.print("\n");
//		System.out.print(recipe);
//	}
//}
