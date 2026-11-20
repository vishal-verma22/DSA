package Lec16_HashingDataStruture_Map_HashMap_Set_HashSet;

//===========================================================
// Problem Statement:
//
// => Write a Java program to count the number of pairs
//    in an array whose sum is equal to a given target value
//    using HashMap.
//
// => Array ko sirf ek baar traverse karna hai (single pass).
//
// Example:
//
// Input:
// arr = {5, 1, 6, 0, 4, 2, 3}
// target = 6
//
// Output:
// No of pairs equal to the target value is: 3
//
// (Pairs: 1+5, 0+6, 2+4)
//
// Time Complexity: O(n)
// Space Complexity: O(n)
//
//===========================================================

import java.util.HashMap;
import java.util.Map;

public class P23_CountPairsWhoseSumIsEqualToGivenSumInAnArray
{
	public static void main(String[] args)
	{
		int arr[] = {5, 1, 6, 0, 4, 2, 3};

		int target = 6;

		Map<Integer, Integer> map = new HashMap<>();

		// Pairs ki count store karne ke liye variable
		int count = 0;

		//===========================================================
		// Step 1: Array traverse karke pairs count karna
		//===========================================================

		for (int i = 0; i < arr.length; i++)
		{
			// Current element ke saath sum banane ke liye
			// kaunsa element chahiye, wo calculate karenge
			int neededElement = target - arr[i];

			// Agar needed element Map mein pehle se present hai,
			// matlab pair mil gaya, toh count badha denge
			if (map.containsKey(neededElement))
			{
				count++;
			}

			//===========================================================
			// Step 2: Current element ko Map mein store karna
			//===========================================================

			// Yahan value (i) kuch bhi ho sakti hai (0, 1, ...),
			// kyunki hum sirf key check kar rahe hain.
			map.put(arr[i], i);
		}

		//===========================================================
		// Step 3: Total pairs print karna
		//===========================================================

		System.out.println("No of pairs equal to the target value is: " + count);
	}
}

//===========================================================
// Example Output:
//
// No of pairs equal to the target value is: 3
//
//===========================================================