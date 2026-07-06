//wap to check array is sorted or not
public class P11_CheckArrayAreSortedOrNot {

	public static void main(String[] args) {

		// int arr1[] = { 5, 57, 5, 3 };
		int arr1[] = { 5, 6, 7, 8 };

		int n = arr1.length;

		boolean isSorted = true;

		for (int i = 0; i < n - 1; i++) {

			if (arr1[i] > arr1[i + 1]) {
				isSorted = false;
				break;
			}
		}

		if (isSorted) {

			System.out.println("Array is sorted");

		} else {

			System.out.println("Array is not sorted");
		}

	}

}
