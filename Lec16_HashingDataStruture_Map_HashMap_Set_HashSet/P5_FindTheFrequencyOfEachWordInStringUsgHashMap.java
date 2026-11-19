package Lec16_HashingDataStruture_Map_HashMap_Set_HashSet;

import java.util.HashMap;
import java.util.Map;

public class P5_FindTheFrequencyOfEachWordInStringUsgHashMap {
	


	public static void main(String[] args)
	{
		String s = "deepak is good boy and boy is good";
		String arr[]=s.split(" ");
	//	System.out.println(arr);
		
		
		Map<String, Integer> map = new HashMap<>();

		//===========================================================
		// Logic: Har character ki frequency count karna
		//===========================================================

		for (int i = 0; i < arr.length; i++)
		{
			// Current index ka character retrieve karenge
			String word = arr[i];

			if (map.containsKey(word))
			{
				// Agar character already Map mein present hai,
				// toh uski current frequency retrieve karenge
				int freq = map.get(word);

				// Existing frequency ko 1 se increase karenge
				freq++;

				// Updated frequency ko Map mein wapas store karenge
				map.put(word, freq);
			}
			else
			{
				// Agar character pehli baar mila hai,
				// toh uski initial frequency 1 set karenge
				map.put(word, 1);
			}
		}

		// Finally Map mein har character ki frequency print karenge
		System.out.println(map);
	}


		
	}



