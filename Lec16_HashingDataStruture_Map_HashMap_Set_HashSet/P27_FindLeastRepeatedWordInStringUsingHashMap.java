
package Lec16_HashingDataStruture_Map_HashMap_Set_HashSet;

//===========================================================
// Problem Statement:
//
// => Write a Java program to find the least repeated word
//    in a String using HashMap.
//
// => Count the frequency of each word.
//
// => Find the word having the minimum frequency.
//
// => Print the least repeated word and its frequency.
//
// Example:
//
// Input:
// deepak is good boy and boy is good boy
//
// Output:
// deepak ==> 1
//
// Time Complexity: O(n)
// Space Complexity: O(k)
//
//===========================================================

import java.util.HashMap;
import java.util.Map;

public class P27_FindLeastRepeatedWordInStringUsingHashMap
{
	public static void main(String[] args)
	{
		String s = "deepak is good boy and boy is good boy";

		String arr[] = s.split(" ");

		Map<String, Integer> map = new HashMap<>();

		//===========================================================
		// Step 1: Frequency of each word count karna
		//===========================================================

		for (int i = 0; i < arr.length; i++)
		{
			// Current index ka word retrieve karenge
			String word = arr[i];

			if (map.containsKey(word))
			{
				// Agar word Map mein already present hai,
				// toh uski existing frequency retrieve karenge
				int freq = map.get(word);

				// Frequency ko increment karenge
				freq++;

				// Updated frequency Map mein store karenge
				map.put(word, freq);
			}
			else
			{
				// Agar word Map mein present nahi hai,
				// toh uski initial frequency 1 set karenge
				map.put(word, 1);
			}
		}

		//===========================================================
		// Step 2: Least repeated word find karna
		//===========================================================

		int minCount = Integer.MAX_VALUE;
		String minWord = "";

		for (Map.Entry<String, Integer> entry : map.entrySet())
		{
			// Current entry ka word aur frequency retrieve karenge
			String currentWord = entry.getKey();
			int currentCount = entry.getValue();

			// Agar current frequency minimum frequency se smaller hai,
			// toh minimum frequency aur word update karenge
			if (currentCount < minCount)
			{
				minCount = currentCount;
				minWord = currentWord;
			}
		}

		//===========================================================
		// Step 3: Least repeated word aur frequency print karna
		//===========================================================

		System.out.println(minWord + " ==> " + minCount);
	}
}

//===========================================================
// Example Output:
//
// deepak ==> 1
// (deepak or and may appear because of HashMap iteration order)
//
//===========================================================
