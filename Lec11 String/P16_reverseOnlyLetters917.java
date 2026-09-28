// WAP to reverse only the English letters of a String
//
// Problem:
// Given a String, reverse only the English letters.
//
// Rules:
// 1) Lowercase and uppercase English letters ko reverse karna hai.
// 2) Non-letter characters apni original position par hi rahenge.
//
// Example:
// Input  : "ab-cd"
// Output : "dc-ba"
//
// Explanation:
//
// Original:
// a b - c d
// ^       ^
// L       R
//
// 'a' aur 'd' letters hain, isliye swap honge.
//
// After first swap:
// d b - c a
//
// Ab left aur right andar move honge.
//
// 'b' aur 'c' letters hain, isliye swap honge.
//
// Final:
// d c - b a
//
// Output:
// "dc-ba"


public class P16_reverseOnlyLetters917 {

	public static void main(String[] args) {

		// Input String
		String s = "ab-cd";

		// String immutable hoti hai.
		// Isliye String ke characters ko directly change nahi kar sakte.
		// String ko character array mein convert kar rahe hain.
		//
		// s = "ab-cd"
		// chArray = ['a', 'b', '-', 'c', 'd']

		char[] chArray = s.toCharArray();


		// left pointer String ke first index par rahega.
		//
		// a b - c d
		// ^
		// left = 0

		int left = 0;


		// right pointer String ke last index par rahega.
		//
		// a b - c d
		//         ^
		// right = 4

		int right = s.length() - 1;


		// Jab tak left pointer right pointer se pehle hai,
		// tab tak letters ko find karke swap karenge.
		//
		// left < right isliye use kiya hai kyunki:
		// - Jab left aur right same position par aa jaye,
		//   toh swap karne ki zarurat nahi hai.
		// - Jab left > right ho jaye,
		//   toh pointers cross kar chuke hain.
		//
		// Isliye loop sirf left < right tak chalega.

		while (left < right) {


			// left pointer ko right ki taraf move karenge
			// jab tak koi English letter nahi milta.
			//
			// Character.isLetter() check karta hai:
			// current character letter hai ya nahi.
			//
			// !Character.isLetter()
			// ka matlab:
			// current character letter nahi hai.
			//
			// Agar '-' ya koi non-letter mila,
			// toh left++ karke usko skip kar denge.

			while (left < right && !Character.isLetter(chArray[left])) {

				left++;
			}


			// right pointer ko left ki taraf move karenge
			// jab tak koi English letter nahi milta.
			//
			// Agar right side par non-letter mila,
			// toh right-- karke us character ko skip kar denge.

			while (left < right && !Character.isLetter(chArray[right])) {

				right--;
			}


			// Ab left aur right dono positions par letters hain.
			//
			// Example:
			//
			// a b - c d
			// ^       ^
			// L       R
			//
			// 'a' aur 'd' ko swap karna hai.


			// Left character ko temporary variable mein store kar rahe hain.
			//
			// temp = 'a'

			char temp = chArray[left];


			// Right wala character left position par aa jayega.
			//
			// chArray[left] = 'd'

			chArray[left] = chArray[right];


			// Original left character jo temp mein store tha,
			// use right position par rakh rahe hain.
			//
			// chArray[right] = 'a'

			chArray[right] = temp;


			// Current letters ka swap complete ho gaya.
			//
			// Isliye dono pointers ko andar move karenge.
			//
			// left++  -> next position
			// right-- -> previous position

			left++;
			right--;
		}


		// Character array ko dobara String mein convert kar rahe hain.
		//
		// Example:
		// chArray = ['d', 'c', '-', 'b', 'a']
		//
		// new String(chArray)
		//        ↓
		// "dc-ba"

		String result = new String(chArray);


		// Final reversed String print karenge.

		System.out.println(result);
	}
}

