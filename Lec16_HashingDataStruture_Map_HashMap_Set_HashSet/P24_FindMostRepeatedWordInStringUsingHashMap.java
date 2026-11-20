
package Lec16_HashingDataStruture_Map_HashMap_Set_HashSet;

//===========================================================
// Problem Statement:
//
// => Write a Java program to find the most repeated word
//    in a String using HashMap.
//
// => Count the frequency of each word.
//
// => Find the word having the maximum frequency.
//
// => Print the most repeated word and its frequency.
//
// Example:
//
// Input:
// deepak is good boy and boy is good boy
//
// Output:
// boy ==> 3
//
// Time Complexity: O(n)
// Space Complexity: O(k)
//
//===========================================================

import java.util.HashMap;
import java.util.Map;

public class P24_FindMostRepeatedWordInStringUsingHashMap
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
		// Step 2: Most repeated word find karna
		//===========================================================

		int maxCount = 0;
		String maxWord = "";

		for (Map.Entry<String, Integer> entry : map.entrySet())
		{
			// Current entry ka word aur frequency retrieve karenge
			String currentWord = entry.getKey();
			int currentCount = entry.getValue();

			// Agar current frequency maximum frequency se greater hai,
			// toh maximum frequency aur word update karenge
			if (currentCount > maxCount)
			{
				maxCount = currentCount;
				maxWord = currentWord;
			}
		}

		//===========================================================
		// Step 3: Most repeated word aur frequency print karna
		//===========================================================

		System.out.println(maxWord + " ==> " + maxCount);
	}
}

//===========================================================
// Example Output:
//
// boy ==> 3
//
//===========================================================
