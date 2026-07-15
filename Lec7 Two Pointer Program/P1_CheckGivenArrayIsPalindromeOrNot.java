// Problem Statement:
// WAP to check whether the given array is a palindrome or not
// using the Two Pointer Approach.
//
// Logic:
// 1. Initialize two pointers:
//    - L (Left Pointer) at the beginning of the array.
//    - R (Right Pointer) at the end of the array.
// 2. Compare arr[L] and arr[R].
// 3. If both elements are equal, move L forward and R backward.
// 4. If any pair of elements is not equal, the array is not a palindrome.
// 5. If all corresponding elements are equal, the array is a palindrome.
//
// Time Complexity : O(n)
// Space Complexity: O(1)

public class P1_CheckGivenArrayIsPalindromeOrNot {

	public static boolean checkPalindrome(int arr[]) {

		int n = arr.length;

		// Left Pointer
		int L = 0;

		// Right Pointer
		int R = n - 1;

		while (L < R) {

			if (arr[L] != arr[R]) {
				return false;
			} else {

				L++;
				R--;
			}

		}

		return true;
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 3, 2, 1 };

		// int arr[] = { 1, 2, 3, 4, 5,3, 2, 1 };

		boolean status = checkPalindrome(arr);

		System.out.println(status);

	}

}
