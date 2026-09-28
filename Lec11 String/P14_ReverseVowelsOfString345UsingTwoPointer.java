/*
 * WAP to reverse only the vowels in a String
 *
 * Problem Statement:
 *
 * Given a string s, reverse only all the vowels in the string
 * and return the resulting string.
 *
 * The vowels are:
 *
 * 'a', 'e', 'i', 'o', 'u'
 *
 * Vowels can be in:
 * 1) Lowercase
 * 2) Uppercase
 *
 *
 * Example:
 *
 * Input  : "hello"
 * Output : "holle"
 *
 * Input  : "leetcode"
 * Output : "leotcede"
 *
 *
 * Approach:
 *
 * 1) Use two pointers: left and right.
 * 2) left starts from the beginning.
 * 3) right starts from the end.
 * 4) Find the first vowel from the left.
 * 5) Find the first vowel from the right.
 * 6) Swap both vowels.
 * 7) Move both pointers towards the center.
 */

public class P14_ReverseVowelsOfString345UsingTwoPointer {

	public static void main(String[] args) {

		// Input String
		String s = "hello";

		int left = 0;

		int right = s.length() - 1;

		/*
		 * String immutable hoti hai,
		 * isliye String ke characters ko directly change nahi kar sakte.
		 *
		 * Isliye String ko character array mein convert kar rahe hain.
		 */
		char[] chArray = s.toCharArray();

		/*
		 * Jab tak left aur right pointers
		 * ek-dusre ko cross nahi karte,
		 * tab tak vowels ko find karke swap karenge.
		 */
		while(left < right) {

			/*
			 * LEFT SIDE:
			 *
			 * Jab tak left par vowel nahi milta,
			 * left pointer ko aage move karte rahenge.
			 *
			 * left < right:
			 * Ye ensure karta hai ki left pointer
			 * right ko cross na kare.
			 *
			 * !checkVowels():
			 * Agar current character vowel nahi hai,
			 * toh left ko aage move karenge.
			 */
			while(left < right && !checkVowels(chArray[left])) {
				left++;
			}

			/*
			 * RIGHT SIDE:
			 *
			 * Jab tak right par vowel nahi milta,
			 * right pointer ko peeche move karte rahenge.
			 *
			 * left < right:
			 * Ye ensure karta hai ki right pointer
			 * left ko cross na kare.
			 */
			while(left < right && !checkVowels(chArray[right])) {
				right--;
			}

			/*
			 * Ab left aur right dono positions par vowels mil gaye hain.
			 *
			 * Dono vowels ko swap karenge.
			 */

			// Left wale vowel ko temporary variable mein store kiya.
			char temp = chArray[left];

			// Right wale vowel ko left position par rakha.
			chArray[left] = chArray[right];

			// Old left vowel ko right position par rakha.
			chArray[right] = temp;

			/*
			 * Swap ke baad:
			 *
			 * left ko next position par move karenge.
			 * right ko previous position par move karenge.
			 */
			left++;
			right--;
		}

		/*
		 * Character array ko wapas String mein convert kiya.
		 *
		 * Example:
		 * "hello" -> "holle"
		 */
		String result = new String(chArray);

		// Final output
		System.out.println(result);
	}


	/*
	 * Function: checkVowels()
	 *
	 * Ye method check karta hai ki given character
	 * vowel hai ya nahi.
	 *
	 * Vowels:
	 * a, e, i, o, u
	 *
	 * Uppercase vowels bhi check karenge.
	 */
	public static boolean checkVowels(char ch) {

		/*
		 * Agar character lowercase ya uppercase vowel hai,
		 * toh true return karo.
		 */
		if(ch == 'a' || ch == 'e' || ch == 'i' ||
		   ch == 'o' || ch == 'u' ||
		   ch == 'A' || ch == 'E' || ch == 'I' ||
		   ch == 'O' || ch == 'U') {

			return true;
		}

		/*
		 * Agar character vowel nahi hai,
		 * toh false return karo.
		 */
		return false;
	}

}