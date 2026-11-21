
package Lec16_HashingDataStruture_Map_HashMap;

import java.util.HashMap;
import java.util.Map;

//===========================================================
// Problem Statement:
	// Find the frequency of each character in a given string  using HashMap.
//===========================================================

// Time Complexity: O(n)
// Space Complexity: O(k)
//
// n = String ki total length
// k = String mein total unique characters
//===========================================================

public class P4_FindTheFrequencyOfEachCharacterInStringUsgHashMap
{
	public static void main(String[] args)
	{
		String s = "deepak is good boy";

		Map<Character, Integer> map = new HashMap<>();

		//===========================================================
		// Logic: Har character ki frequency count karna
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

		// Finally Map mein har character ki frequency print karenge
		System.out.println(map);
	}
}
