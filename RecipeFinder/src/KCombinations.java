import java.util.List;

public class KCombinations {

	public void helper(List<int[]> combinations, int data[], int start, int end, int index) {
	    if (index == data.length) {
	        int[] combination = data.clone();
	        combinations.add(combination);
	    } else {
	        int max = Math.min(end, end + 1 - data.length + index);
	        for (int i = start; i <= max; i++) {
	            data[index] = i;
	            helper(combinations, data, i + 1, end, index + 1);
	        }
	    }
	}

}
