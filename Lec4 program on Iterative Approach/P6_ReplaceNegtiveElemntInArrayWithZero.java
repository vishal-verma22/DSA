// wap to replace all negative number in array with zero

public class P6_ReplaceNegtiveElemntInArrayWithZero {

	public static void main(String[] args) {

		int arr1[] = { 5, 3, 4, 7, -6, 32, -56, 87, -45, 10, -11, 13 };
		int n = arr1.length;

		System.out.print("Array before swapping\n");

		for (int no : arr1) {

			System.out.print(no + " ");
		}
		System.out.print("\n");

		for (int i = 0; i < n; i++) {

			if (arr1[i] < 0) {

				arr1[i] = 0;
			}

		}

		System.out.print("Array After swapping\n");

		for (int no : arr1) {

			System.out.print(no + " ");
		}

	}

}
