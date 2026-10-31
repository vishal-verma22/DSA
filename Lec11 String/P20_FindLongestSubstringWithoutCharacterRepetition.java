// LeetCode Question No. 3 – Longest Substring Without Repeating Characters

/*
 * Logic Samajh – Sliding Window
Is question mein hum Sliding Window + Frequency Array use kar rahe hain.
1. left aur right dono pointers initially 0 par hain.
2. right pointer se  array ka har character read kar rahe hain.
3. Aur Frequency array mein us character ki frequency increase kar rhe hain.
4. Agar character ka frequency 1 se greater he toh , iska matlab  vo character repeat ho raha hai.
5.Duplicate character ko remove karne ke liye hum left pointer
   par present character ki frequency decrease karte hain 1 se
   aur left pointer ko increase karte hain.
6. Jab tak duplicate character remove nahi hota, left move hota rahega ,while loop ke help se .
7. Duplicate remove hone ke baad current window ki length calculate karte hain.
8. maxLength mein maximum length update karte hain.
 */
public class P20_FindLongestSubstringWithoutCharacterRepetition {

	public static void main(String[] args) {

		String s = "abcabcbb";

		int result = lengthOfLongestSubstring(s);

		System.out.println("Longest Substring Length: " + result);
	}

	public static int lengthOfLongestSubstring(String s) {

		int left = 0;

		int right = 0;

		// Har character ki frequency store karne ke liye array
		int temp[] = new int[127];

		// Maximum substring length
		int maxLength = 0;

		// Jab tak right pointer ki value  string ke length se choti hai tab tak while loop chalega  
		while (right < s.length()) {

			// Right index ka present character liya 
			char currentCharacter = s.charAt(right);

			// Character ki ASCII value nikala
			int currentCharacterAsciiValue = (int) currentCharacter;

			// Current character ki frequency increase kiya array me
			temp[currentCharacterAsciiValue]++;

			// check kiya ki Agar current character ki frequency more than 1 hai array me means character repeat ho raha hai
			while (temp[currentCharacterAsciiValue] > 1) {

				// Left index par present character liya
				char leftCharacter = s.charAt(left);

				// Left character ki ASCII value
				int leftCharacterAsciiValue = (int) leftCharacter;

				// Left character ki frequency decrease karo jo duplicate remove ho  jaye
				temp[leftCharacterAsciiValue]--;

				// Window ka starting point aage badhao
				left++;
			}

			// Current window ki length calculate karo
			int currentLength = right - left + 1;

			// Maximum length update karo
			maxLength = Math.max(currentLength, maxLength);

			// Window ka right pointer aage badhao
			right++;
		}

		return maxLength;
	}
}
