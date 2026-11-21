
package Lec16_HashingDataStruture_Map_HashMap;

import java.util.HashMap;
import java.util.Map;

//===========================================================

// Problem Statement:
//
// Find the first duplicate element in a given array
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
// 1. First loop mein array ko traverse karte hai.
// 2. Har element ki frequency Map mein count karte hai.
// 3. Agar element already Map mein present hai,
//    toh uski frequency increase karte hai.
// 4. Agar updated frequency 1 se greater hai,
//    toh woh first duplicate element hai.
// 5. Element milte hi break statement loop terminate kar deta hai.
//
//===========================================================

public class P15_FindFirstDuplicateElementInArrayUsingHashMap

{
	public static void main(String args[])

	{

		int arr[] = { 10, 20, 30, 10, 40, 20, 50, 30, 60 };

		Map<Integer, Integer> map = new HashMap<>();

		//===========================================================

		// Step 1: First duplicate element find karna

		//===========================================================

		for (int i = 0; i < arr.length; i++)

		{

			// Current index ka element retrieve karenge

			int element = arr[i];

			if (map.containsKey(element))

			{

				// Agar element already Map mein present hai,

				// toh uski current frequency retrieve karenge

				int freq = map.get(element);

				// Existing frequency ko 1 se increase karenge

				freq++;

				// Updated frequency ko Map mein wapas store karenge

				map.put(element, freq);

				if (map.get(element) > 1)

				{

					// Agar element ki frequency 1 se greater hai,

					// toh woh first duplicate element hai

					System.out.println("First Duplicate Element is : " + element);

					// First duplicate mil gaya, ab loop stop karenge

					break;

				}

			}

			else

			{

				// Agar element pehli baar mila hai,

				// toh uski initial frequency 1 set karenge

				map.put(element, 1);

			}

		}

	}

}

//===========================================================

// Example Output:
//
// First Duplicate Element is : 10
//
//===========================================================
