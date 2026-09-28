// wap to check whether a given string is Palindrome or not

public class P2_CheckGivenStringIsPalindromeOrNot {

	public static void main(String[] args) {

		String orginal = "vishal";
		//String orginal = "madam";

		int n = orginal.length() - 1;
		String reverse = "";

		for (int i = n; i >= 0; i--) {

			reverse = reverse + orginal.charAt(i);
		}

		if (orginal.equals(reverse)) {

			System.out.println("Given String is palindrome");

		} else {
			System.out.println("Given String is not palindrome");

		}

	}

}
