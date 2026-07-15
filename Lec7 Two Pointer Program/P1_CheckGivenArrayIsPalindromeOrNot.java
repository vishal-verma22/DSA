// wap to check if the given array is palindrome or not

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

		int arr[] = { 1, 2, 3, 4, 5,3, 2, 1 };
		boolean status=checkPalindrome(arr);
		
		System.out.println(status);

	}

}
