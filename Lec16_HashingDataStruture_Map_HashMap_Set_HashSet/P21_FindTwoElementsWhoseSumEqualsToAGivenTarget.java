package Lec16_HashingDataStruture_Map_HashMap_Set_HashSet;

//===========================================================
// Problem Statement:
//
// => Write a Java program to find all pairs of elements
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
// 1,5
// 0,6
// 2,4
//
// Time Complexity: O(n)
// Space Complexity: O(n)
//
//===========================================================

import java.util.HashMap;
import java.util.Map;

public class P21_FindTwoElementsWhoseSumEqualsToAGivenTarget
{
	public static void main(String[] args)
	{
		int arr[] = {5, 1, 6, 0, 4, 2, 3};

		int target = 6;

		Map<Integer, Integer> map = new HashMap<>();

		System.out.println("Pairs of elements whose sum is equal to target value are:");

		//===========================================================
		// Step 1: Array traverse karke pairs find karna
		//===========================================================

		for (int i = 0; i < arr.length; i++)
		{
			// Current element ke saath sum banane ke liye
			// kaunsa element chahiye, wo calculate karenge
			int neededElement = target - arr[i];

			// Agar needed element Map mein pehle se present hai,
			// matlab pair mil gaya
			if (map.containsKey(neededElement))
			{
				System.out.println(arr[i] + "," + neededElement);
			}

			//===========================================================
			// Step 2: Current element ko Map mein store karna
			//===========================================================

			// Yahan value (i) kuch bhi ho sakti hai (0, 1, ...),
			// kyunki hum sirf key check kar rahe hain.
			// Index store karne se aage index chahiye ho toh kaam aata hai.
			map.put(arr[i], i);
		}
	}
}

//===========================================================
// Example Output:
//
// Pairs of elements whose sum is equal to target value are:
// 1,5
// 0,6
// 2,4
//
//===========================================================