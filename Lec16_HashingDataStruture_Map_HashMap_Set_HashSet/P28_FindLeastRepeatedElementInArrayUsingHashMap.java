
package Lec16_HashingDataStruture_Map_HashMap_Set_HashSet;

//===========================================================
// Problem Statement:
//
// => Write a Java program to find the least repeated element
//    in an array using HashMap.
//
// => Count the frequency of each element.
//
// => Find the element having the minimum frequency.
//
// => Print the least repeated element and its frequency.
//
// Example:
//
// Input:
// 10 20 30 10 40 20 50 30 10 60 20 10
//
// Output:
// 40 ==> 1
//
// Time Complexity: O(n)
// Space Complexity: O(k)
//
//===========================================================

import java.util.HashMap;
import java.util.Map;

public class P28_FindLeastRepeatedElementInArrayUsingHashMap
{
	public static void main(String[] args)
	{
		int arr[] = {10, 20, 30, 10, 40, 20, 50, 30, 10, 60, 20, 10};

		Map<Integer, Integer> map = new HashMap<>();

		//===========================================================
		// Step 1: Frequency of each element count karna
		//===========================================================

		for (int i = 0; i < arr.length; i++)
		{
			// Current index ka element retrieve karenge
			int element = arr[i];

			if (map.containsKey(element))
			{
				// Agar element Map mein already present hai,
				// toh uski existing frequency retrieve karenge
				int freq = map.get(element);

				// Frequency ko increment karenge
				freq++;

				// Updated frequency Map mein store karenge
				map.put(element, freq);
			}
			else
			{
				// Agar element Map mein present nahi hai,
				// toh uski initial frequency 1 set karenge
				map.put(element, 1);
			}
		}

		//===========================================================
		// Step 2: Least repeated element find karna
		//===========================================================

		int minCount = Integer.MAX_VALUE;
		int minElement = arr[0];

		for (Map.Entry<Integer, Integer> entry : map.entrySet())
		{
			// Current entry ka element aur frequency retrieve karenge
			int currentElement = entry.getKey();
			int currentCount = entry.getValue();

			// Agar current frequency minimum frequency se smaller hai,
			// toh minimum frequency aur element update karenge
			if (currentCount < minCount)
			{
				minCount = currentCount;
				minElement = currentElement;
			}
		}

		//===========================================================
		// Step 3: Least repeated element aur frequency print karna
		//===========================================================

		System.out.println("Least Repeated Element ==> Frequency");
		System.out.println(minElement + " ==> " + minCount);
	}
}

//===========================================================
// Example Output:
//
// Least Repeated Element ==> Frequency
// 40 ==> 1
//
// (40, 50, 60 mein se koi bhi ek element aa sakta hai)
//
//===========================================================
