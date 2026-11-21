
package Lec16_HashingDataStruture_Map_HashMap;

import java.util.HashMap;
import java.util.Map;

//===========================================================

// Problem Statement:
//
// Find the first non-repeating element in a given array
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
// 2. Second loop mein original array ko traverse karte hai.
// 3. Agar kisi element ki frequency 1 hai,
//    toh woh first non-repeating element hai.
// 4. Element milte hi break statement loop terminate kar deta hai.
// 5. Agar koi non-repeating element nahi milta,
//    toh appropriate message print karte hai.
//
//===========================================================

public class P17_FindFirstNonRepeatingElementInArrayUsingHashMap

{
	public static void main(String[] args)

	{

		int arr[] = { 10, 20, 30, 10, 40, 20, 50, 30, 60 };

		Map<Integer, Integer> map = new HashMap<>();

		//===========================================================

		// Step 1: Har element ki frequency count karna

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

			}

			else

			{

				// Agar element pehli baar mila hai,

				// toh uski initial frequency 1 set karenge

				map.put(element, 1);

			}

		}

		//===========================================================

		// Step 2: First non-repeating element find karna

		//===========================================================

		boolean flag = false;

		for (int i = 0; i < arr.length; i++)

		{

			// Original array ka current element retrieve karenge

			int element = arr[i];

			if (map.get(element) == 1)

			{

				// Agar element ki frequency 1 hai,

				// toh woh first non-repeating element hai

				System.out.println("First Non repeating Element is : " + element);

				// Element milne par flag true karenge

				flag = true;

				// First element mil gaya, ab loop stop karenge

				break;

			}

		}

		if (!flag)

		{

			// Agar koi non-repeating element nahi mila,

			// toh message print karenge

			System.out.println("First Non repeating Element not found");

		}

	}

}

//===========================================================

// Example Output:
//
// First Non repeating Element is : 40
//
//===========================================================
