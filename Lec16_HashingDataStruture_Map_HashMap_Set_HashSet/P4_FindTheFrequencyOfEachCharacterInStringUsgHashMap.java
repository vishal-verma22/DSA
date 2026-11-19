
package Lec16_HashingDataStruture_Map_HashMap_Set_HashSet;

import java.util.HashMap;
import java.util.Map;

//===========================================================

// Problem Statement:
//
// Find the frequency of each word in a given string using HashMap.

//===========================================================

// Time Complexity: O(n)
// Space Complexity: O(k)
//
// n = String mein total words ki count
// k = String mein total unique words ki count

//===========================================================

public class P5_FindTheFrequencyOfEachWordInStringUsgHashMap
{
	public static void main(String[] args)
	{
		String s = "deepak is good boy and boy is good";

		// String ko individual words mein split karenge
		String arr[] = s.split(" ");

		Map<String, Integer> map = new HashMap<>();

		//===========================================================
		// Logic: Har word ki frequency count karna
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

		// Finally Map mein har word ki frequency print karenge
		System.out.println(map);
	}
}
