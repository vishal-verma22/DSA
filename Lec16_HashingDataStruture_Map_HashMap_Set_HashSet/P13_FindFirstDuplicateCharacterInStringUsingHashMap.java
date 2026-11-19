
package Lec16_HashingDataStruture_Map_HashMap_Set_HashSet;

import java.util.HashMap;
import java.util.Map;

//===========================================================

// Problem Statement:
//
// Find the first duplicate character in a given string
// using HashMap.

//===========================================================

// Time Complexity: O(n)
// Space Complexity: O(k)
//
// n = String ki total length
// k = String mein total unique characters ki count
//
// Explanation:
//
// 1. First loop mein String ko traverse karte hai.
// 2. Har character ki frequency Map mein count karte hai.
// 3. Agar character already Map mein present hai,
//    toh uski frequency increase karte hai.
// 4. Agar updated frequency 1 se greater hai,
//    toh woh first duplicate character hai.
// 5. Character milte hi break statement loop terminate kar deta hai.
//
//===========================================================

public class P13_FindFirstDuplicateCharacterInStringUsingHashMap

{
	public static void main(String[] args)

	{

		String s = "vishal verma";

		Map<Character, Integer> map = new HashMap<>();

		//===========================================================

		// Step 1: First duplicate character find karna

		//===========================================================

		for (int i = 0; i < s.length(); i++)

		{

			// Current index ka character retrieve karenge

			char ch = s.charAt(i);

			if (map.containsKey(ch))

			{

				// Agar character already Map mein present hai,

				// toh uski current frequency retrieve karenge

				int freq = map.get(ch);

				// Existing frequency ko 1 se increase karenge

				freq++;

				// Updated frequency ko Map mein wapas store karenge

				map.put(ch, freq);

				if (map.get(ch) > 1)

				{

					// Agar frequency 1 se greater hai,

					// toh woh first duplicate character hai

					System.out.println("First Duplicate Character is : " + ch);

					// First duplicate mil gaya, ab loop stop karenge

					break;

				}

			}

			else

			{

				// Agar character pehli baar mila hai,

				// toh uski initial frequency 1 set karenge

				map.put(ch, 1);

			}

		}

	}

}

//===========================================================

// Example Output:
//
// First Duplicate Character is : v
//
//===========================================================
