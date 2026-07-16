// Problem Statement:
// WAP to move all negative elements to the left side
// and all positive elements to the right side of the array
// using the Two Pointer Approach.
//
// Logic:
// 1. Initialize two pointers:
//    - L (Left Pointer) at the beginning of the array.
//    - R (Right Pointer) at the end of the array.
// 2. If arr[L] is negative, move L forward.
// 3. If arr[R] is positive, move R backward.
// 4. If arr[L] is positive and arr[R] is negative,
//    swap both elements.
// 5. Repeat the process until L >= R.
// 6. After completion, all negative elements will be on the left
//    and all positive elements will be on the right.
//
// Time Complexity : O(n)
// Space Complexity: O(1)

public class P5_MoveAllNegtiveToLeftAndPostiveToRightSideOfArray {

	public static void moveElement(int arr[]) {

		int n = arr.length;
		int L = 0;
		int R = n - 1;

		while (L < R) {

			if (arr[L] < 0) {
				L++;

			} else if (arr[R] > 0) {

				R--;
			} else if (arr[L] > 0 && arr[R] < 0) {

				int temp = arr[R];
				arr[R] = arr[L];
				arr[L] = temp;
				L++;
				R--;

			}

		}

		for (int no : arr) {

			System.out.print(no + " ");

		}

	}

	public static void main(String[] args) {

		int[] arr = { -5, 2, -4, 55, 8, -74, 3, 88, -3 };

		moveElement(arr);

	}

}
