// wap to check if two array are same or not

public class P10_CheckTwoArrayAreSameOrNot {
	public static void main(String args[]) {

		// int arr1[] = { 5, 57, 5, 3 };

		int arr1[] = { 5, 6, 7, 8 };

		int arr2[] = { 5, 6, 7, 8 };

		int n1 = arr1.length;
		int n2 = arr2.length;

		if (n1 != n2) {

			System.out.println("Array is not same");

		}

		boolean isSame = true;

		for (int i = 0; i < n1; i++) {

			if (arr1[i] != arr2[i]) {
				isSame = false;
				break;
			}
		}
		if (isSame) {

			System.out.println("both Array elements is same");

		} else {

			System.out.println("both Array elements is not same");
		}
	}

}
