/*
==>Find the Next Greater Element (NGE) for every element in the given array.
==>We are solving the same question using the Monotonic Stack Technique with time complexity O(n)
   instead of O(n²).
   
Input:
	`arr[] = {4, 7, 2, 10, 8}`

Output:
	4 7 2 10 8
	7 10 10 -1 -1

Logic:
	1. Create a result array of the same size as the original array.
	2. Initialize every index of the result array with `-1`.
	3. Use an outer loop (`i`) to select each element from the original array.
	4. Use an inner loop (`j = i + 1`) to check the elements on the right side of the current element.
	5. If `arr[j] > arr[i]`, store `arr[j]` in `result[i]`.
	6. Use `break` because we need only the first greater element on the right side.
	7. If no greater element is found, `-1` remains in the result array.
	8. Finally, print the original array and result array.

Important Points:
	- Next Greater Element means the first greater element on the right side.
	- We check only elements present on the right side, not the left side.
	- j = i + 1 means checking starts from the next element.
	- break stops the inner loop after finding the first greater element.
	- -1 indicates that no greater element exists.

=>Time Complexity: O(n²) – Nested loops are used.
=>Space Complexity:** O(n) – Extra result array is used.
=>Approach: Brute Force (Nested Loop)

 * 
 */

package Lec14_Stack_And_its_implementions;

public class P7_FindingNextGreaterNumberUsgBruteForceApproach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 4, 7, 2, 10, 8 };

		int n = arr.length;
		// for storing greater element
		int result[] = new int[n];
		
		
		// for putting -1 in all place of result array
		for (int i=0;i<n;i++) {

			result[i]=-1;
		}

		for (int i = 0; i < n; i++) {

			for (int j = i + 1; j < n; j++) {

				if (arr[j] > arr[i]) {

					result[i] = arr[j];
					break;
				}
			}
		}

		for (int no : arr) {

			System.out.print(no + " ");
		}
		System.out.println();

		for (int no : result) {

			System.out.print(no + " ");
		}

	}

}
