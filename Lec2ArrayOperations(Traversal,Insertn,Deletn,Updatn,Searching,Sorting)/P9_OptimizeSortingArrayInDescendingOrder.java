// optimized code for sorting array element in descending order


public class P9_OptimizeSortingArrayInDescendingOrder {

	public static void main(String[] args) {

		int arr[] = { 5, 6, 3, 2, 11, 9, 7 };

		for (int i = 1; i < arr.length; i++) { // loop for pass

			boolean Swapped = false;

			for (int j = 0; j < arr.length - i; j++) { // for traversing each element in array

				if (arr[j] < arr[j + 1]) {
					// swapping

					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					Swapped = true;

				}
			}
			if (Swapped == false) {

				break;

			}

		}

		// traversing

		for (int no : arr) {
			System.out.println(no);

		}

	}

}
