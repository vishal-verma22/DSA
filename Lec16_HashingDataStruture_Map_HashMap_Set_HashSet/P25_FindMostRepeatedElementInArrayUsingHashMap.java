
package Lec16_HashingDataStruture_Map_HashMap_Set_HashSet;

//===========================================================
// Problem Statement:
//
// => Write a Java program to find the most repeated element
//    in an array using HashMap.
//
// => Count the frequency of each element.
//
// => Find the element having the maximum frequency.
//
// => Print the most repeated element and its frequency.
//
// Example:
//
// Input:
// 10 20 30 10 40 20 50 30 10 60 20 10
//
// Output:
// 10 ==> 4
//
// Time Complexity: O(n)
// Space Complexity: O(k)
//
//===========================================================

import java.util.HashMap;
import java.util.Map;

public class P25_FindMostRepeatedElementInArrayUsingHashMap
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
		// Step 2: Most repeated element find karna
		//===========================================================

		int maxCount = 0;
		int maxElement = arr[0];

		System.out.println("Max Element" + " ==> " + "Max Count");

		for (Map.Entry<Integer, Integer> entry : map.entrySet())
		{
			// Current entry ka element aur frequency retrieve karenge
			int currentElement = entry.getKey();
			int currentCount = entry.getValue();

			// Agar current frequency maximum frequency se greater hai,
			// toh maximum frequency aur element update karenge
			if (currentCount > maxCount)
			{
				maxCount = currentCount;
				maxElement = currentElement;
			}
		}

		//===========================================================
		// Step 3: Most repeated element aur frequency print karna
		//===========================================================

		System.out.println(maxElement + " ==> " + maxCount);
	}
}

//===========================================================
// Example Output:
//
// 10 ==> 4
//
//===========================================================
