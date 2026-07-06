// wap to copy the content of one array into another array

public class P4_CopyContentOfOneArrayIntoAnotherArray {

	public static void main(String[] args) {

		int arr1[] = { 5, 3, 4, 7, 6, 32, 56, 87, 45, 10, 11, 13 };
		int n = arr1.length;

		int arr2[] = new int[n];

		for (int i = 0; i < n; i++) {

			arr2[i] = arr1[i];
		}

		System.out.println("Array-1");
		;
		for (int no : arr1) {
			System.out.print(no + " ");
		}

		System.out.println("\nArray-2");

		for (int no : arr2)

		{
			System.out.print(no + " ");
		}

	}

}
