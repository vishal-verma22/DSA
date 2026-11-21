
package Lec16_HashingDataStruture_Map_HashMap;

import java.util.HashMap;
import java.util.Map;

//===========================================================

// Problem Statement:
//
// Find the first non-repeating character in a given string
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
// 1. First loop mein har character ki frequency count karte hai.
// 2. Second loop mein original String ko traverse karte hai.
// 3. Agar kisi character ki frequency 1 hai,
//    toh woh first non-repeating character hai.
// 4. Character milte hi break statement loop terminate kar deta hai.
// 5. Agar koi non-repeating character nahi milta,
//    toh appropriate message print karte hai.
//
//===========================================================

public class P10_FindTheFirstNonRepeatingCharacterUsgHashMap
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
		// Step 2: First non-repeating character find karna
		//===========================================================

		boolean flag = false;

		for (int i = 0; i < s.length(); i++)
		{
			// Original String ka current character retrieve karenge
			char ch = s.charAt(i);

			if (map.get(ch) == 1)
			{
				// Agar character ki frequency 1 hai,
				// toh woh first non-repeating character hai
				System.out.print("First Non repeating character is : " + ch);

				// Character milne par flag true karenge
				flag = true;

				// First character mil gaya, ab loop stop karenge
				break;
			}
		}

		if (!flag)
		{
			// Agar koi non-repeating character nahi mila,
			// toh message print karenge
			System.out.print("First Non repeating character not found");
		}
	}
}

//===========================================================
// Example Output:
//
// First Non repeating character is : v
//
//===========================================================
