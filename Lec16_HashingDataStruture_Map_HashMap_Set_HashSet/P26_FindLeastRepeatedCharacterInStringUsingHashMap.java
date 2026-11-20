package Lec16_HashingDataStruture_Map_HashMap_Set_HashSet;

import java.util.HashMap;
import java.util.Map;

public class P26_FindLeastRepeatedCharacterInStringUsingHashMap {

	public static void main(String[] args) {

		String s = "deeeepakisgoodboy";

		Map<Character, Integer> map = new HashMap<>();

		//===========================================================
		// Step 1: Har character ki frequency count karna
		//===========================================================

		for (int i = 0; i < s.length(); i++)
		{
			// Current index ka character retrieve karenge
			char ch = s.charAt(i);

			if (map.containsKey(ch))
			{
				// Agar character already Map mein present hai,
				// toh uski current frequency retrieve karenge
				int freq = map.get(ch);

				// Existing frequency ko 1 se increase karenge
				freq++;

				// Updated frequency ko Map mein wapas store karenge
				map.put(ch, freq);
			}
			else
			{
				// Agar character pehli baar mila hai,
				// toh uski initial frequency 1 set karenge
				map.put(ch, 1);
			}
		}

		//===========================================================
		// Step 2: Maximum occurring character find karna
		//===========================================================

		int min =Integer.MAX_VALUE;
		char minCh = ' ';

		for (Map.Entry<Character, Integer> entry : map.entrySet())
		{
			// Current entry ki frequency retrieve karenge
			int currentCount = entry.getValue();

			if (currentCount < min)
			{
				// Agar current frequency max se greater hai,
				// toh max ko update karenge
				min = currentCount;

				// Maximum frequency wala character store karenge
				minCh = entry.getKey();
			}
		}

		// Finally maximum occurring character aur uski frequency print karenge
		System.out.println("minimum repeated character is:"+minCh + " => " + min);
	}

}
