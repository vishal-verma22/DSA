// Linear Search Algorithm
//
// Linear Search is the simplest searching algorithm.
// It searches the target element by checking each element
// of the array one by one from the beginning until the
// element is found or the array ends.
//
// Working:
// 1. Start searching from the first element of the array.
// 2. Compare the current element with the target element.
// 3. If both are equal, the element is found.
// 4. Print the index (or required result) and stop searching.
// 5. If they are not equal, move to the next element.
// 6. Repeat the process until the target is found or the
//    entire array has been traversed.
// 7. If the target is not found after checking all elements,
//    print "Element not found".
//
// Example:
// Array  : {10, 20, 30, 40, 50}
// Target : 40
//
// Comparisons:
// 10 != 40
// 20 != 40
// 30 != 40
// 40 == 40  --> Element Found at index 3
//
// Time Complexity:
// Best Case    : O(1)   -> Element found at the first position.
// Average Case : O(n)   -> Element found somewhere in the middle.
// Worst Case   : O(n)   -> Element found at the last position or not found.
//
// Space Complexity:
// O(1)
//
// Properties:
// - Simple and easy to implement.
// - Works on both sorted and unsorted arrays.
// - No preprocessing or sorting is required.
// - Sequential searching algorithm.

public class Prgm1_LinearSearchAlgorithmImplemention {

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 50 };
		int target = 40;

		int n = arr.length;
		boolean found = false;
		for (int i = 0; i < n; i++) {

			if (arr[i] == target) {

				System.out.println("Element " + target + " found at index position " + i);
				found = true;
				break;
			}

		}
		if (!found) {
			System.out.println("Element " + target + " not found ");
		}

	}

}
