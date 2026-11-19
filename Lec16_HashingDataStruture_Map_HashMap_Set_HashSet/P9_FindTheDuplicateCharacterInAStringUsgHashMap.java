
package Lec16_HashingDataStruture_Map_HashMap_Set_HashSet;

import java.util.HashMap;
import java.util.Map;

//===========================================================

// Problem Statement:
//
// Find all duplicate characters in a given string using HashMap.

//===========================================================

// Time Complexity: O(n)
// Space Complexity: O(k)
//
// n = String ki total length
// k = String mein total unique characters ki count
//
// Explanation:
//
// 1. First loop mein har character ki frequency count karte hai.
// 2. Second loop mein HashMap ke entrySet() ko traverse karte hai.
// 3. Agar kisi character ki frequency 1 se greater hai,
//    toh woh duplicate character hai.
// 4. Agar koi duplicate character nahi milta,
//    toh appropriate message print karte hai.
//
//===========================================================

public class P9_FindTheDuplicateCharacterInAStringUsgHashMap
{
	public static void main(String[] args)
	{
		String s = "vishal verma";

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
		// Step 2: Duplicate characters find karna
		//===========================================================

		boolean isDuplicate = false;

		for (Map.Entry<Character, Integer> entry : map.entrySet())
		{
			// Current entry ki key aur value retrieve karenge
			char ch = entry.getKey();
			int value = entry.getValue();

			if (value > 1)
			{
				// Agar frequency 1 se greater hai,
				// toh character duplicate hai
				System.out.print(ch + " ");

				// Duplicate character milne par flag true karenge
				isDuplicate = true;
			}
		}

		if (!isDuplicate)
		{
			// Agar koi duplicate character nahi mila,
			// toh message print karenge
			System.out.println("No duplicate character is found");
		}
	}
}

//===========================================================
// Example Output (Order may vary because of HashMap):
//
// a i r
//
//===========================================================
