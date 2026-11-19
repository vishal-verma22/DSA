
package Lec16_HashingDataStruture_Map_HashMap_Set_HashSet;

import java.util.HashMap;
import java.util.Map;

//===========================================================

// Problem Statement:
//
// Find the maximum occurring character in a given string
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
// 2. Second loop mein HashMap ke entrySet() ko traverse karte hai.
// 3. Har character ki frequency ko max ke saath compare karte hai.
// 4. Agar current frequency max se greater hai,
//    toh max aur character dono update karte hai.
//
//===========================================================

public class P8_FindTheMaximumOccuringCharacterUsgHashMap
{
	public static void main(String[] args)
	{
		String s = "deeeepakisgoodboy";

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
		// Step 2: Maximum occurring character find karna
		//===========================================================

		int max = 0;
		char maxCh = ' ';

		for (Map.Entry<Character, Integer> entry : map.entrySet())
		{
			// Current entry ki frequency retrieve karenge
			int currentCount = entry.getValue();

			if (currentCount > max)
			{
				// Agar current frequency max se greater hai,
				// toh max ko update karenge
				max = currentCount;

				// Maximum frequency wala character store karenge
				maxCh = entry.getKey();
			}
		}

		// Finally maximum occurring character aur uski frequency print karenge
		System.out.println("maximum repeated character is:"+maxCh + " => " + max);
	}
}

//===========================================================
// Example Output:
//
//maximum repeated character is:e => 4
//
//===========================================================
