package junk;
import java.util.List;

public class BinarySearch {

	public int runBinarySearchIteratively(
			  List<List<String>> sortedArray, int key, int low, int high) {
			    int index = Integer.MAX_VALUE;
			     
			    while (low <= high) {
			        int mid = (low + high) / 2;
			        if (sortedArray.get(mid).size() < key) {
			            low = mid + 1;
			        } else if (sortedArray.get(mid).size() > key) {
			            high = mid - 1;
			        } else if (sortedArray.get(mid).size() == key) {
			            index = mid;
			            break;
			        }
			    }
			    return index;
			}

}
