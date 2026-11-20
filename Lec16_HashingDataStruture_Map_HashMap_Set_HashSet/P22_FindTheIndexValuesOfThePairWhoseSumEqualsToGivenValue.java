package Lec16_HashingDataStruture_Map_HashMap_Set_HashSet;

//===========================================================
// Problem Statement:
//
// => Write a Java program to find the index values of all
//    pairs of elements in an array whose sum is equal to
//    a given target value using HashMap.
//
// => Array ko sirf ek baar traverse karna hai (single pass).
//
// Example:
//
// Input:
// arr = {5, 1, 6, 0, 4, 2, 3}
// target = 6
//
// Output (currentIndex,earlierIndex):
// 1,0
// 3,2
// 5,4
//
// Time Complexity: O(n)
// Space Complexity: O(n)
//
//===========================================================

import java.util.HashMap;
import java.util.Map;

public class P22_FindTheIndexValuesOfThePairWhoseSumEqualsToGivenValue
{
	public static void main(String[] args)
	{
		int arr[] = {5, 1, 6, 0, 4, 2, 3};

		int target = 6;

		// Key = array element, Value = us element ka index
		Map<Integer, Integer> map = new HashMap<>();

		System.out.println("Pairs of index whose sum is equal to target value are:");

		//===========================================================
		// Step 1: Array traverse karke index pairs find karna
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
				// Current index (i) aur needed element ka index
				// (map.get) print karenge
				System.out.println(i + "," + map.get(neededElement));
			}

			//===========================================================
			// Step 2: Current element aur uska index Map mein store karna
			//===========================================================

			// Yahan value mein index (i) hi store karna zaroori hai,
			// kyunki pair ka index print karne ke liye map.get()
			// se wahi index wapas chahiye.
			map.put(arr[i], i);
		}
	}
}

//===========================================================
// Example Output:
//
// Pairs of index whose sum is equal to target value are:
// 1,0
// 3,2
// 5,4
//
//===========================================================