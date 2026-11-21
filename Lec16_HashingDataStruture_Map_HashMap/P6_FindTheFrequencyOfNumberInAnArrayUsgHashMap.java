
package Lec16_HashingDataStruture_Map_HashMap;

import java.util.HashMap;
import java.util.Map;

//===========================================================

// Problem Statement:
//
// Find the frequency of each number in a given array using HashMap.

//===========================================================

// Time Complexity: O(n)
// Space Complexity: O(k)
//
// n = Array mein total elements ki count
// k = Array mein total unique numbers ki count

//===========================================================

public class P6_FindTheFrequencyOfNumberInAnArrayUsgHashMap
{
	public static void main(String[] args)
	{
		int arr[] = { 10, 20, 10, 30, 20, 10, 40, 30 };

		Map<Integer, Integer> map = new HashMap<>();

		//===========================================================
		// Logic: Har number ki frequency count karna
		//===========================================================

		for (int i = 0; i < arr.length; i++)
		{
			// Current index ka number retrieve karenge
			int num = arr[i];

			if (map.containsKey(num))
			{
				// Agar number already Map mein present hai,
				// toh uski current frequency retrieve karenge
				int freq = map.get(num);

				// Existing frequency ko 1 se increase karenge
				freq++;

				// Updated frequency ko Map mein wapas store karenge
				map.put(num, freq);
			}
			else
			{
				// Agar number pehli baar mila hai,
				// toh uski initial frequency 1 set karenge
				map.put(num, 1);
			}
		}

		// Finally Map mein har number ki frequency print karenge
		System.out.println(map);
	}
}

//===========================================================
// Example Output:
//
// {20=2, 40=1, 10=3, 30=2}
//
//===========================================================
