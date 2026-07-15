// Problem Statement:
// WAP to move all the zero elements to the end of the array
// without maintaining the order of non-zero elements
// using the Two Pointer Approach.
//
// Logic:
// 1. Use two pointers:
//    - L (Left Pointer): Starts from the beginning of the array.
//    - R (Right Pointer): Starts from the end of the array.
// 2. If arr[L] is non-zero, move L forward.
// 3. If arr[R] is zero, move R backward.
// 4. If arr[L] is zero and arr[R] is non-zero, swap both elements.
// 5. Repeat the process until L >= R.
// 6. After completion, all zeros are moved to the end of the array.
//    (The order of non-zero elements is not preserved.)
//
// Time Complexity : O(n)
// Space Complexity: O(1)

public class P3a_MoveAllZeroToEndOfArraywithoutMaintainingElemntsOrder {

	public static void moveZeroToEnd(int arr[]) {

		int n = arr.length;

		// Left Pointer
		int L = 0;

		// Right Pointer
		int R = n - 1;

		while (L < R) {

			if (arr[L] != 0) {

				L++;
			} else if (arr[R] == 0) {

				R--;

			} else {

				int temp = arr[R];
				arr[R] = arr[L];
				arr[L] = temp;
				L++;
				R--;

			}

		}
		for (int i = 0; i < n; i++) {

			System.out.print(arr[i] + " ");
		}

	}

	public static void main(String[] args) {
		int arr[] = { 1, 0, 0, 3, 0, 5, 0, 6, 7 };

		moveZeroToEnd(arr);
	}

}
