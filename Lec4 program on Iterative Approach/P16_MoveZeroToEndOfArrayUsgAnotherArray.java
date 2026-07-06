// wap to move all zero to the end of array using temporary array
public class P16_MoveZeroToEndOfArrayUsgAnotherArray {

	public static void main(String[] args) {

		int arr1[] = { 0, 5, 0, 0, 6, 7, 0, 45 };

		int n = arr1.length;

		int[] tempArray = new int[n];

		int index = 0;

		for (int i = 0; i < n; i++) {

			if (arr1[i] != 0) {

				tempArray[index] = arr1[i];
				index++;
			}
		}

		for (int no : tempArray) {

			System.out.print(no + " ");
		}

	}

}
