// wap to reverse the array using another array[temporary array]

public class P13_ReverseTheArrayUsgAnotherArray {

	public static void main(String[] args) {

		int arr1[] = { 5, 6, 7, 45 };

		int n = arr1.length;
		int[] tempArray = new int[n];

		int index = n - 1;

		// reversing the array elemets
		for (int i = 0; i < n; i++) {
			tempArray[index] = arr1[i];
			index--;

		}

		// Again putting tempArray elements in original array

		for (int i = 0; i < n; i++) {
			arr1[i] = tempArray[i];

		}

		// printing the array

		for (int no : arr1) {

			System.out.print(no + " ");
		}
	}

}
