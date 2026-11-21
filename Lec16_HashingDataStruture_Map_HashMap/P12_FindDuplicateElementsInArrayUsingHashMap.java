
package Lec16_HashingDataStruture_Map_HashMap;

import java.util.HashMap;
import java.util.Map;

//===========================================================

// Problem Statement:
//
// Find all duplicate elements in a given array
// using HashMap.

//===========================================================

// Time Complexity: O(n)
// Space Complexity: O(k)
//
// n = Array mein total elements ki count
// k = Array mein total unique elements ki count
//
// Explanation:
//
// 1. First loop mein har element ki frequency count karte hai.
// 2. Second loop mein Map ke entrySet() ko traverse karte hai.
// 3. Agar kisi element ki frequency 1 se greater hai,
//    toh woh duplicate element hai.
// 4. Saare duplicate elements ko print karte hai.
//
//===========================================================

public class P12_FindDuplicateElementsInArrayUsingHashMap

{
	public static void main(String[] args)

	{

		int arr[] = {10, 20, 30, 10, 40, 20, 50, 30, 60};

		Map<Integer, Integer> map = new HashMap<>();

		//===========================================================

		// Step 1: Har element ki frequency count karna

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

		//===========================================================

		// Step 2: Duplicate elements find karna

		//===========================================================

		for (Map.Entry<Integer, Integer> entry : map.entrySet())

		{

			// Current entry se element retrieve karenge

			int element = entry.getKey();

			if (entry.getValue() > 1)

			{

				// Agar element ki frequency 1 se greater hai,

				// toh woh duplicate element hai

				System.out.print(element + " ");

			}

		}

	}

}

//===========================================================

// Example Output:
//
// 10 20 30
//
//===========================================================
