
//Inserting new element in array with specific position  without deleting existing one

import java.util.Arrays;

public class P3_InsertElementInNewArrayWithoutDeletingAnyElemt {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
		int length = arr.length;

		// insert

		int pos = 4;
		int element = 55;

		// System.out.println(length);

		int[] arr2 = new int[length + 1];

		System.out.println(arr2.length);

		for (int i = 0; i < pos; i++) {

			arr2[i] = arr[i];

		}

		arr2[pos] = element;

		for (int i = pos; i < length; i++) {

			arr2[i + 1] = arr[i];

		}

		System.out.println(Arrays.toString(arr));
		for (int no : arr2) {
			System.out.print(no + " ");
		}

	}

}
