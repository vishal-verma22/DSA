
package Lec16_HashingDataStruture_Map_HashMap;

import java.util.HashMap;
import java.util.Map;

//===========================================================

// Problem Statement:
//
// Find the first duplicate word in a given string
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
// 3. Agar word already Map mein present hai,
//    toh uski frequency increase karte hai.
// 4. Agar updated frequency 1 se greater hai,
//    toh woh first duplicate word hai.
// 5. Word milte hi break statement loop terminate kar deta hai.
//
//===========================================================

public class P14_FindFirstDuplicateWordInStringUsingHashMap

{
	public static void main(String args[])

	{

		String s = "deepak is good boy and boy is good";

		// String ko individual words mein convert karenge

		String arr[] = s.split(" ");

		Map<String, Integer> map = new HashMap<>();

		//===========================================================

		// Step 1: First duplicate word find karna

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

				if (map.get(word) > 1)

				{

					// Agar word ki frequency 1 se greater hai,

					// toh woh first duplicate word hai

					System.out.println("First Duplicate Word is : " + word);

					// First duplicate mil gaya, ab loop stop karenge

					break;

				}

			}

			else

			{

				// Agar word pehli baar mila hai,

				// toh uski initial frequency 1 set karenge

				map.put(word, 1);

			}

		}

	}

}

//===========================================================

// Example Output:
//
// First Duplicate Word is : boy
//
//===========================================================
