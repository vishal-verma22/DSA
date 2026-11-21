
package Lec16_HashingDataStruture_Map_HashMap;

import java.util.HashMap;
import java.util.Map;

//===========================================================

// Problem Statement:
//
// Find the first non-repeating word in a given string
// using HashMap.

//===========================================================

// Time Complexity: O(n)
// Space Complexity: O(k)
//
// n = String mein total words ki count
// k = String mein total unique words ki count
//
// Explanation:
//
// 1. String ko split() method se individual words mein convert karte hai.
// 2. First loop mein har word ki frequency count karte hai.
// 3. Second loop mein original word array ko traverse karte hai.
// 4. Agar kisi word ki frequency 1 hai,
//    toh woh first non-repeating word hai.
// 5. Word milte hi break statement loop terminate kar deta hai.
// 6. Agar koi non-repeating word nahi milta,
//    toh appropriate message print karte hai.
//
//===========================================================

public class P16_FindFirstNonRepeatingWordInStringUsingHashMap

{
	public static void main(String[] args)

	{

		String s = "deepak is good boy and boy is good";

		// String ko individual words mein convert karenge

		String arr[] = s.split(" ");

		Map<String, Integer> map = new HashMap<>();

		//===========================================================

		// Step 1: Har word ki frequency count karna

		//===========================================================

		for (int i = 0; i < arr.length; i++)

		{

			// Current index ka word retrieve karenge

			String word = arr[i];

			if (map.containsKey(word))

			{

				// Agar word already Map mein present hai,

				// toh uski current frequency retrieve karenge

				int freq = map.get(word);

				// Existing frequency ko 1 se increase karenge

				freq++;

				// Updated frequency ko Map mein wapas store karenge

				map.put(word, freq);

			}

			else

			{

				// Agar word pehli baar mila hai,

				// toh uski initial frequency 1 set karenge

				map.put(word, 1);

			}

		}

		//===========================================================

		// Step 2: First non-repeating word find karna

		//===========================================================

		boolean flag = false;

		for (int i = 0; i < arr.length; i++)

		{

			// Original word array ka current word retrieve karenge

			String word = arr[i];

			if (map.get(word) == 1)

			{

				// Agar word ki frequency 1 hai,

				// toh woh first non-repeating word hai

				System.out.println("First Non repeating word is : " + word);

				// Word milne par flag true karenge

				flag = true;

				// First word mil gaya, ab loop stop karenge

				break;

			}

		}

		if (!flag)

		{

			// Agar koi non-repeating word nahi mila,

			// toh message print karenge

			System.out.println("First Non repeating word not found");

		}

	}

}

//===========================================================

// Example Output:
//
// First Non repeating word is : deepak
//
//===========================================================
