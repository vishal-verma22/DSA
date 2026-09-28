/*
 * WAP to reverse each word of a String:
  Given a string, reverse each word individually. Spaces ki position same rehni chahiye.
 *
 * Example:
 * 	 Input  : "Let's take LeetCode contest"
 *	 Output : "s'teL ekat edoCteeL tsetnoc"
 *
 *
 * Approach:
 *
 * 1) String ko char[] mein convert karenge.
 * 2) start variable current word ka starting index store karega.
 * 3) Space milne par current word ko reverse karenge.
 * 4) i == chArray.length hone par last word ko reverse karenge.
 * 5) reverseWord() method two pointers ka use karke word reverse karega.
 */

public class P15_ReverseWordFromString557 {

	public static void main(String[] args) {

		// Input String
		String s = "Let's take LeetCode contest";

		// String ko character array mein convert kiya.
		// String immutable hoti hai, isliye characters ko
		// change karne ke liye char[] use kar rahe hain.
		char[] chArray = s.toCharArray();

		// Current word ka starting index.
		int start = 0;

		/*
		 * i ko 0 se start karke array ke end tak le ja rahe hain.
		 *
		 * <= isliye use kiya hai kyunki
		 * i == chArray.length par last word ko reverse karna hai.
		 */
		for(int i = 0; i <= chArray.length; i++) {

			/*
			 * Agar:
			 *
			 * 1) i == chArray.length
			 *    -> String ka end aa gaya.
			 *    -> Last word ko reverse karna hai.
			 *
			 * OR
			 *
			 * 2) chArray[i] == ' '
			 *    -> Space mila.
			 *    -> Current word complete ho gaya.
			 */
			if(i == chArray.length || chArray[i] == ' ') {

				// start se i-1 tak current word ko reverse karo.
				reverseWord(chArray, start, i - 1);

				// Space ke baad next word start hoga.
				start = i + 1;
			}
		}

		// Character array ko wapas String mein convert kiya.
		String result = new String(chArray);

		// Final output
		System.out.println(result);
	}


	/*
	 * Method: reverseWord()
	 *
	 * Ek word ko reverse karta hai using two pointers.
	 *
	 * left  -> word ke starting character par
	 * right -> word ke ending character par
	 */
	public static void reverseWord(char[] ch, int left, int right) {

		// Jab tak left aur right cross nahi karte,
		// tab tak characters ko swap karenge.
		while(left < right) {

			// Left character ko temporary variable mein store kiya.
			char temp = ch[left];

			// Right character ko left position par rakha.
			ch[left] = ch[right];

			// Temporary mein stored character ko
			// right position par rakha.
			ch[right] = temp;

			// Left ko ek position aage move karo.
			left++;

			// Right ko ek position peeche move karo.
			right--;
		}
	}

}