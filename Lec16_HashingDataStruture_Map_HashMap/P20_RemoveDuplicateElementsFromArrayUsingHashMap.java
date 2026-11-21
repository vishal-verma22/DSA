
package Lec16_HashingDataStruture_Map_HashMap;

//===========================================================
// Problem Statement:
//
// => Write a Java program to remove duplicate elements
//    from an array using HashMap.
//
// => Each element should appear only once in the final output.
//
// => Maintain the original order of array elements.
//
// Example:
//
// Input:
// 10 20 30 10 40 20 50 30 60
//
// Output:
// 10 20 30 40 50 60
//
// Time Complexity: O(n)
// Space Complexity: O(k)
//

import java.util.HashMap;
import java.util.Map;

public class P20_RemoveDuplicateElementsFromArrayUsingHashMap
{
	public static void main(String[] args)
	{
		int arr[] = {10, 20, 30, 10, 40, 20, 50, 30, 60};

		Map<Integer, Integer> map = new HashMap<>();

		StringBuilder sb = new StringBuilder();


		//===========================================================
		// Step 1: Duplicate elements remove karna
		//===========================================================

		for (int i = 0; i < arr.length; i++)
		{
			// Current index ka element retrieve karenge
			int element = arr[i];

			if (!map.containsKey(element))
			{
				// Agar element Map mein present nahi hai,
				// toh usko Map mein add karenge
				map.put(element, 1);

				// Elements ke beech space add karenge
				if (sb.length() > 0)
				{
					sb.append(" ");
				}

				// Unique element ko StringBuilder mein append karenge
				sb.append(element);
			}
		}

		//===========================================================
		// Step 2: Duplicate-free elements print karna
		//===========================================================

		System.out.println(sb);
	}
}

//===========================================================
// Example Output:
//
// 10 20 30 40 50 60
//
//===========================================================
