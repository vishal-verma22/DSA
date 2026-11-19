
package Lec16_HashingDataStruture_Map_HashMap_Set_HashSet;

import java.util.HashMap;
import java.util.Map;

//===========================================================

// Problem Statement:
//
// Remove duplicate characters from a given string
// using HashMap.

//===========================================================

// Time Complexity: O(n)
// Space Complexity: O(k)
//
// n = String ki total length
// k = String mein total unique characters ki count
//
// Explanation:
//
// 1. First loop mein original String ko traverse karte hai.
// 2. Har character check karte hai ki woh Map mein present hai ya nahi.
// 3. Agar character Map mein present nahi hai,
//    toh usko Map mein add karte hai.
// 4. Saath hi us character ko StringBuilder mein append karte hai.
// 5. Agar character already Map mein present hai,
//    toh usko ignore karte hai.
// 6. Finally StringBuilder mein duplicate-free String milti hai.
//
//===========================================================

public class P18_RemoveDuplicateCharactersFromStringUsingHashMap

{
	public static void main(String[] args)

	{

		String s = "aaabbcddddekkl";

		Map<Character, Integer> map = new HashMap<>();

		StringBuilder sb = new StringBuilder();

		//===========================================================

		// Step 1: Duplicate characters remove karna

		//===========================================================

		for (int i = 0; i < s.length(); i++)

		{

			// Current index ka character retrieve karenge

			char ch = s.charAt(i);

			if (!map.containsKey(ch))

			{

				// Agar character Map mein present nahi hai,

				// toh usko Map mein add karenge

				map.put(ch, 1);

				// Unique character ko StringBuilder mein append karenge

				sb.append(ch);

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
// abcdekl
//
//===========================================================
