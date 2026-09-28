
// WAP to check whether one String is a Subsequence of another String
//
// LeetCode 392: Is Subsequence
//
// Definition:
// A String s is called a subsequence of String t when:
//
// 1) s ke characters t ke andar same order mein present hone chahiye.
// 2) Characters ke beech ke kuch characters ko skip kar sakte hain.
// 3) Lekin characters ka relative order change nahi hona chahiye.
//
// Example:
//
// s = "ace"
// t = "abcde"
//
// t = a b c d e
//     ^   ^   ^
//
// a, c aur e same order mein mil rahe hain.
//
// Therefore:
// "ace" is a subsequence of "abcde"
//
// But:
//
// s = "aec"
// t = "abcde"
//
// a ke baad e hai, lekin e ke baad c nahi hai.
// Isliye "aec" subsequence nahi hai.
//
// Output:
// true


public class P17_isSubsequence392 {

	public static void main(String[] args) {

		// String s = jis String ko check karna hai
		String s = "ace";

		// String t = jiske andar humein s ko search karna hai
		String t = "abcde";


		// left pointer String s ke characters ko track karega.
		//
		// s = "ace"
		//
		//     a c e
		//     ^
		//   left = 0
		//
		// Matlab abhi humein s ka 'a' find karna hai.

		int left = 0;


		// right pointer String t ke characters ko check karega.
		//
		// t = "abcde"
		//
		//     a b c d e
		//     ^
		//   right = 0
		//
		// Matlab t ke starting character se checking start hogi.

		int right = 0;


		// Jab tak:
		//
		// 1) s ke characters remaining hain
		// 2) t ke characters remaining hain
		//
		// tab tak loop chalega.
		//
		// left < s.length()
		// ------------------
		// Matlab s ke saare required characters abhi match nahi hue.
		//
		// right < t.length()
		// -------------------
		// Matlab t mein abhi characters check karne ke liye available hain.

		while (left < s.length() && right < t.length()) {


			// s ka current character aur t ka current character
			// compare kar rahe hain.
			//
			// Example:
			//
			// s = "ace"
			//      ^
			//    left
			//
			// t = "abcde"
			//      ^
			//    right
			//
			// s.charAt(left) = 'a'
			// t.charAt(right) = 'a'
			//
			// Dono same hain.

			if (s.charAt(left) == t.charAt(right)) {


				// Agar characters match ho gaye,
				// toh s ka current character mil gaya.
				//
				// Isliye left ko next character par move karenge.
				//
				// Example:
				//
				// s = a c e
				//     ^
				//     left
				//
				// 'a' mil gaya.
				//
				// left++ ke baad:
				//
				// s = a c e
				//       ^
				//       left
				//
				// Ab humein 'c' find karna hai.

				left++;
			}


			// Chahe character match ho ya nahi,
			// t mein humein next character check karna hai.
			//
			// Isliye right hamesha increase hoga.
			//
			// Example:
			//
			// t = a b c d e
			//     ^
			//   right
			//
			// right++ ke baad:
			//
			// t = a b c d e
			//       ^
			//     right

			right++;
		}


		// IMPORTANT:
		//
		// Agar s ke saare characters mil gaye,
		// toh left == s.length() hoga.
		//
		// Example:
		//
		// s = "ace"
		//
		// Characters:
		// a -> left = 1
		// c -> left = 2
		// e -> left = 3
		//
		// s.length() = 3
		//
		// Therefore:
		//
		// left == s.length()
		// 3 == 3
		// true
		//
		// Iska matlab s ke saare characters t mein
		// correct order mein mil gaye.

		if (left == s.length()) {

			returnResult(true);

		} else {

			// Agar left s.length() tak nahi pahucha,
			// matlab s ka koi character t mein nahi mila.
			//
			// Therefore s is NOT a subsequence of t.

			returnResult(false);
		}
	}


	// Ye method sirf result ko print karne ke liye banaya hai.
	// LeetCode mein iski zarurat nahi hoti.

	public static void returnResult(boolean result) {

		System.out.println(result);
	}
}
