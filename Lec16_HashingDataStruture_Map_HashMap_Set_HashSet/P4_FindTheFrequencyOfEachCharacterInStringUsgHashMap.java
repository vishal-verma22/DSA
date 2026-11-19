
package Lec16_HashingDataStruture_Map_HashMap_Set_HashSet;

import java.util.HashMap;
import java.util.Map;

//===========================================================
// Problem Statement:
//
// Ek given String mein har character ki frequency find karni hai
// using HashMap.
//===========================================================

// Time Complexity: O(n)
// Space Complexity: O(k)
//
// n = String ki total length
// k = String mein total unique characters
//
// Explanation:
//
// 1. Hum for loop ki help se String ko sirf ek baar traverse karte hai.
//
// 2. HashMap ke containsKey(), get() aur put() methods ki
//    average time complexity O(1) hoti hai.
//
// 3. For loop n times execute hota hai, isliye Time Complexity O(n) hai.
//
// 4. HashMap mein sirf unique characters store hote hai,
//    isliye Space Complexity O(k) hai.
//
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
