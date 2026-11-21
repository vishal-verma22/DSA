
package Lec16_HashingDataStruture_Map_HashMap;
//===========================================================
//Problem Statement:
//
//=> Write a Java program to remove duplicate words from a String
// using HashMap.
//
//=> Each word should appear only once in the final String.
//
//=> Maintain the original order of words.
//
//=> Use HashMap to check whether a word is already present or not.
//
//Example:
//
//Input:
//deepak is good boy and boy is good
//
//Output:
//deepak is good boy and
//
//===========================================================
//
//Time Complexity: O(n)
//Space Complexity: O(k)
//
//===========================================================

import java.util.HashMap;
import java.util.Map;

public class P19_RemoveDuplicateWordsFromStringUsingHashMap
{
	public static void main(String[] args)
	{
		String s = "deepak is good boy and boy is good";

		String arr[] = s.split(" ");

		Map<String, Integer> map = new HashMap<>();

		StringBuilder sb = new StringBuilder();

		//===========================================================
		// Step 1: Duplicate words remove karna
		//===========================================================

		for (int i = 0; i < arr.length; i++)
		{
			// Current index ka word retrieve karenge
			String word = arr[i];

			if (!map.containsKey(word))
			{
				// Agar word Map mein present nahi hai,
				// toh usko Map mein add karenge
				map.put(word, 1);

				// Words ke beech space add karenge
				if (sb.length() > 0)
				{
					sb.append(" ");
				}

				// Unique word ko StringBuilder mein append karenge
				sb.append(word);
			}
		}

		//===========================================================
		// Step 2: Duplicate-free String print karna
		//===========================================================

		System.out.println(sb);
	}
}

//===========================================================
// Example Output:
//
// deepak is good boy and
//
//===========================================================
