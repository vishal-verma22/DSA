// wap to check two array are reversed of each other

public class P6_CheckTwoArrayAreReversedOfEachOtherOrNot {

	public static void checkArrayIsReversed(int arr[]) {

		int n = arr.length;
		int L = 0;
		int R = n - 1;

		while (L < R) {
			int temp = arr[R];
			arr[R] = arr[L];
			arr[L] = temp;
			L++;
			R--;

		}

	}

	public static void main(String[] args) {

		int[] arr = { 5, 2, 8, 74, 3, 0 };

		checkArrayIsReversed(arr);

	}

}
