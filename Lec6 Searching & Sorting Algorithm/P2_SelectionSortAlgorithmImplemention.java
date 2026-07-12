// Selection Sort Algorithm
//
// Selection Sort divides the array into two parts:
// 1. Sorted Part   -> Elements that are already in their correct position.
// 2. Unsorted Part -> Remaining elements that are yet to be sorted.
//
// Initially:
// - The sorted part is empty.
// - The entire array is considered as the unsorted part.
//
/// Working:
// 1. Divide the array into two parts:
//    - Sorted Part
//    - Unsorted Part
//
// 2. Initially, the sorted part is empty and the entire array is the
//    unsorted part.
// 3. In each pass, assume the first element of the unsorted part is the
//    minimum element (minIndex = i).
// 4. Traverse the remaining elements of the unsorted part and compare
//    each element with the current minimum element.
// 5. If a smaller element is found, update minIndex to that element's index.
// 6. After finding the smallest element in the unsorted part, swap it
//    with the first element of the unsorted part.
// 7. Now, that smallest element becomes part of the sorted section.
// 8. Repeat the same process for the remaining unsorted part until
//    the entire array becomes sorted

// Example:
// Original Array : 5 6 3 2 11 9 7
//
// Pass 1 : 2 | 6 3 5 11 9 7
// Pass 2 : 2 3 | 6 5 11 9 7
// Pass 3 : 2 3 5 | 6 11 9 7
// Pass 4 : 2 3 5 6 | 11 9 7
// Pass 5 : 2 3 5 6 7 | 9 11
// Pass 6 : 2 3 5 6 7 9 | 11
//
// Here, '|' separates the Sorted Part and the Unsorted Part.
//
// Time Complexity:
// Best Case    : O(n²)
// Average Case : O(n²)
// Worst Case   : O(n²)
//
// Space Complexity:
// O(1) - No extra array is required.
//
// Properties:
// - Comparison-based sorting algorithm.
// - In-place sorting algorithm.
// - Not a stable sorting algorithm.
// - Requires a maximum of (n-1) passes.
// - Performs at most one swap in each pass.


public class P2_SelectionSortAlgorithmImplemention {
	public static void main(String[] args) {

		int arr[] = { 5, 6, 3, 2, 11, 9, 7 };
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			int minIndex = i;
			
			for (int j = i + 1; j < n; j++) {
				if (arr[minIndex] > arr[j]) {

					minIndex = j;
				}

			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;

		}

		for (int no : arr) {
			System.out.print(no + " ");
		}

	}
}
