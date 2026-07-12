// Bubble Sort Algorithm (Optimized)
// Bubble Sort repeatedly compares two adjacent elements and swaps them
// if they are in the wrong order.
// After every pass, the largest unsorted element moves (bubbles up)
// to its correct position at the end of the array.
//
// Approach:
// 1. Perform a maximum of (n-1) passes.
// 2. In each pass, compare adjacent elements.
// 3. Swap them if the left element is greater than the right element.
// 4. After every pass, one largest element is placed at its correct position.
// 5. If no swapping occurs in a pass, the array is already sorted,
//    so terminate the algorithm early using 'break'.
//
// Time Complexity:
// Best Case    : O(n)   -> Array is already sorted (using swapped flag)
// Average Case : O(n²)
// Worst Case   : O(n²)
//
// Space Complexity:
// O(1) -> No extra array is used (In-place sorting)
//
// Stable Sorting : Yes
// In-place Sorting : Yes


public class P1_BubbleSortAlgorithmImplemention {

	public static void main(String[] args) {

		int arr[] = { 5, 6, 3, 2, 11, 9, 7 };
		int n = arr.length;

		for (int i = 1; i < n; i++) { // Start from i= 1 because Bubble Sort requires (n-1) passes where n is number
										// of elements in array.
			
			boolean isSwapped=false;
			
			for (int j = 0; j < n - i; j++) {

				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					isSwapped=true;

				}

			}
			
			if(!isSwapped) {
				break;
			}

		}

		for (int no : arr) {
			System.out.print(no + " ");
		}
	}

}
