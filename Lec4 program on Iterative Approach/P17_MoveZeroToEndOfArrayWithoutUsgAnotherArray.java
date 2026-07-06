// wap to move all zero to the end of array without using temporary array

public class P17_MoveZeroToEndOfArrayWithoutUsgAnotherArray {

	public static void main(String[] args) {

		int arr1[] = { 0, 5, 0, 0, 6, 7, 0, 45 };

		int n = arr1.length;

		int index = 0;
		for (int i = 0; i < n; i++) {

			if (arr1[i] != 0) {

				arr1[index] = arr1[i];
				index++;
			}
		}

		for (int i = index; i < n; i++) {

			arr1[i] = 0;

		}

		for (int no : arr1) {

			System.out.print(no + " ");
		}
	}

}
