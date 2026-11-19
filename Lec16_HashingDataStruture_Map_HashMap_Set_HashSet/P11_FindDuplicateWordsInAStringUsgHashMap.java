
package Lec16_HashingDataStruture_Map_HashMap_Set_HashSet;

import java.util.HashMap;
import java.util.Map;

//===========================================================

// Problem Statement:
//
// Find all duplicate words in a given string
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
// 3. Second loop mein Map ke entrySet() ko traverse karte hai.
// 4. Agar kisi word ki frequency 1 se greater hai,
//    toh woh duplicate word hai.
// 5. Saare duplicate words ko print karte hai.
//
//===========================================================

public class P11_FindDuplicateWordsInAStringUsgHashMap

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

		// Step 2: Duplicate words find karna

		//===========================================================

		for (Map.Entry<String, Integer> entry : map.entrySet())

		{

			// Current entry se word retrieve karenge

			String word = entry.getKey();

			if (entry.getValue() > 1)

			{

				// Agar word ki frequency 1 se greater hai,

				// toh woh duplicate word hai

				System.out.print(word + " ");

			}

		}

	}

}

//===========================================================

// Example Output:
//
// good boy is
//
//===========================================================
