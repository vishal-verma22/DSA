
package Lec16_HashingDataStruture_Map_HashMap_Set_HashSet;

import java.util.HashMap;
import java.util.Map;

//===========================================================

// Problem Statement:
//
// Find all non-repeating characters in a given string using HashMap.

//===========================================================

// Time Complexity: O(n)
// Space Complexity: O(k)
//
// n = String ki total length
// k = String mein total unique characters ki count
//
// Explanation:
//
// 1. First loop mein String ke har character ki frequency count karte hai.
// 2. Second loop mein HashMap ke entrySet() ko traverse karte hai.
// 3. Agar kisi character ki frequency 1 hai,
//    toh woh non-repeating character hai.
//
//===========================================================

public class P7_FindTheNonRepeatingCharacterUsgHashMap
{
	public static void main(String args[])
	{
		String s = "deepak is good boy";

		Map<Character, Integer> map = new HashMap<>();

		//===========================================================
		// Step 1: Har character ki frequency count karna
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
			}
			else
			{
				// Agar character pehli baar mila hai,
				// toh uski initial frequency 1 set karenge
				map.put(ch, 1);
			}
		}

		//===========================================================
		// Step 2: Non-repeating characters find karna
		//===========================================================

		for (Map.Entry<Character, Integer> entry : map.entrySet())
		{
			// Current entry ki frequency retrieve karenge
			int value = entry.getValue();

			if (value == 1)
			{
				// Agar frequency 1 hai, toh character non-repeating hai
				// Key se character retrieve karke print karenge
				System.out.print(entry.getKey() + " ");
			}
		}
	}
}

//===========================================================
// Example Output (Order may vary because of HashMap):
//
// d p a k i b y
//
//===========================================================
