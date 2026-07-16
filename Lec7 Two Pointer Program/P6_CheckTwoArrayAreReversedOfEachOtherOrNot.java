// wap to check two array are reversed of each other

public class P6_CheckTwoArrayAreReversedOfEachOtherOrNot {

	public static void checkArrayIsReversed(int arr1[], int arr2[]) {

		int n1 = arr1.length;
		int n2 = arr2.length;

		int L = 0;
		int R = n1 - 1;
		boolean isReversed = true;

		if (n1 != n2) {

			System.out.println("Array are not reversed of each other");
			return;
		}

		for (; L < n1; L++) {

			if (arr1[L] != arr2[R]) {
				System.out.println("Array are not reversed of each other");
				return;
			}
			R--;

		}
		
		System.out.println("Array are  reversed of each other");



	}

	public static void main(String[] args) {

		int[] arr1 = { 5, 2, 8, 74 };
		int[] arr2 = { 74, 8, 2, 5 };

		checkArrayIsReversed(arr1, arr2);

	}

}
