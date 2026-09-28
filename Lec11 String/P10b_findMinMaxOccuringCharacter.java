// WAP to find the maximum and minimum occurring character

// We are using an array because it is more efficient
// to count the frequency of characters.

/*
 * Character
 *     ↓
 * ASCII value
 *     ↓
 * Array index
 *     ↓
 * Count increase
 */

public class P10b_findMinMaxOccuringCharacter {

	public static void main(String[] args) {

		// 256 size array because we are considering
		// ASCII characters from 0 to 255.
		// Array index = ASCII value of character
		int[] arr = new int[256];

		String str = "vishal is good boy";

		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		char maxCharacter = ' ';
		char minCharacter = ' ';


		// ------------------------------------------------
		// STEP 1: Count frequency of every character
		// ------------------------------------------------

		for (int i = 0; i < str.length(); i++) {

			// Get character from string
			char ch = str.charAt(i);

			// Character automatically gets converted
			// to its ASCII value.
			// Example: 'a' → 97
			// So index = 97
			int index = ch;

			// Increase the count of that character.
			//
			// Example:
			// First 'a':
			// arr[97] = 0 + 1 → 1
			//
			// Second 'a':
			// arr[97] = 1 + 1 → 2
			//
			// Third 'a':
			// arr[97] = 2 + 1 → 3
			arr[index] = arr[index] + 1;
		}


		/*
		// This loop is only for checking/printing
		// all frequency values stored in the array.

		for (int no : arr) {

			System.out.print(no + " ");
		}
		*/


		// ------------------------------------------------
		// STEP 2: Find maximum and minimum frequency
		// ------------------------------------------------

		for (int i = 0; i < str.length(); i++) {

			// Get current character
			char ch = str.charAt(i);

			// We don't want to consider space
			// as a character.
			if (ch == ' ') {
				continue;
			}


			// --------------------------------------------
			// Find maximum occurring character
			// --------------------------------------------

			// arr[ch] gives the frequency of current character.
			//
			// If current character's frequency is greater
			// than max, update max and maxCharacter.
			if (max < arr[ch]) {

				max = arr[ch];

				// ch is already a character,
				// so directly store it.
				maxCharacter = ch;
			}


			// --------------------------------------------
			// Find minimum occurring character
			// --------------------------------------------

			// If current character's frequency is smaller
			// than min, update min and minCharacter.
			if (min > arr[ch]) {

				min = arr[ch];

				minCharacter = ch;
			}
		}


		// Print maximum occurring character
		System.out.println(
				"max character: " + maxCharacter + " ==> " + max
		);

		// Print minimum occurring character
		System.out.println(
				"min character: " + minCharacter + " ==> " + min
		);
	}
}