// WAP to remove duplicate elements from an array without using a temporary array.
// Approach:
// 1. Traverse each element of the array.
// 2. Check whether the current element has already appeared.
// 3. If it is not a duplicate, store it at the beginning of the same array.
// Time Complexity: O(n²)
// Space Complexity: O(1)

public class P9_RemoveDuplicateWithoutUsgTemporaryArray {

	public static void main(String[] args) {

		int arr1[] = { 5, 4, 5, 6, 4, 4, 7, 6, 9 };

		int n = arr1.length;

		int index = 0;

		// Traverse each element of the array.
		for (int i = 0; i < n; i++) {

			boolean found = false;

			// Check whether the current element has already appeared.
			for (int j = 0; j < i; j++) {

				if (arr1[i] == arr1[j]) {

					found = true;

					// No need to check further once a duplicate is found.
					break;
				}

			}

			// Store only unique elements at the beginning of the same array.
			if (!found) {

				arr1[index] = arr1[i];
				index++;

			}

		}

		// Print only the unique elements stored in the array.
		for (int i = 0; i < index; i++) {

			System.out.print(arr1[i] + " ");

		}

	}

}