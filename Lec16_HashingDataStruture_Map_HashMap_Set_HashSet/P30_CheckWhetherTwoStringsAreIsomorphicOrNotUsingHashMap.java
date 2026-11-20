
/*
 *===========================================================
 * P30: Check Whether Two Strings Are Isomorphic or Not Using HashMap
 *===========================================================
 *
 * Problem Statement:
 *
 * Write a Java program to check whether two Strings are
 * Isomorphic or not using HashMap.
 *
 *===========================================================
 *
 * Isomorphic Strings Kya Hoti Hain?
 *
 * Do Strings Isomorphic tab hoti hain jab first String ka
 * har unique character second String ke ek unique character
 * se map hota hai.
 *
 * Har character ki mapping fixed honi chahiye.
 *
 * Ek character hamesha same character se map hona chahiye.
 *
 * Do different characters same character se map nahi hone chahiye.
 *
 * Dono Strings ki length bhi same honi chahiye.
 *
 * Example:
 *
 * s1 = "paper"
 * s2 = "title"
 *
 * Mapping:
 *
 * p -> t
 * a -> i
 * e -> l
 * r -> e
 *
 * Isliye dono Strings Isomorphic hain.
 *
 *===========================================================
 *
 * Main Logic:
 *
 * Step 1:
 * Sabse pehle dono Strings ki length check karenge.
 *
 * Agar length different hai toh Strings Isomorphic nahi ho sakti.
 *
 * Step 2:
 * Do HashMaps create karenge.
 *
 * map1 first String ke characters ko second String ke
 * characters ke saath map karega.
 *
 * map2 second String ke characters ko first String ke
 * characters ke saath map karega.
 *
 * Step 3:
 * Dono Strings ko ek saath traverse karenge.
 *
 * s1 se current character ch1 aur s2 se current character
 * ch2 retrieve karenge.
 *
 * Step 4:
 * Check karenge ki ch1 already map1 mein present hai ya nahi.
 *
 * Agar present hai toh uski existing mapped value retrieve karenge.
 *
 * Agar existing value current ch2 ke equal nahi hai,
 * toh Strings Isomorphic nahi hain.
 *
 * Step 5:
 * Check karenge ki ch2 already map2 mein present hai ya nahi.
 *
 * Agar present hai toh uski existing mapped value retrieve karenge.
 *
 * Agar existing value current ch1 ke equal nahi hai,
 * toh Strings Isomorphic nahi hain.
 *
 * Step 6:
 * Agar dono mappings valid hain toh:
 *
 * map1 mein ch1 -> ch2 store karenge.
 * map2 mein ch2 -> ch1 store karenge.
 *
 * Step 7:
 * Agar loop successfully complete ho gaya aur koi mismatch
 * nahi mila toh Strings Isomorphic hain.
 *
 *===========================================================
 *
 * Diagram:
 *
 *              s1 = "paper"
 *                   |
 *                   v
 *             ch1 = 'p'
 *
 *              s2 = "title"
 *                   |
 *                   v
 *             ch2 = 't'
 *
 *                   |
 *                   v
 *
 *          map1: p -> t
 *          map2: t -> p
 *
 *                   |
 *                   v
 *
 *          Next Characters: a and i
 *                   |
 *                   v
 *
 *          map1: p -> t, a -> i
 *          map2: t -> p, i -> a
 *
 *                   |
 *                   v
 *
 *          Check Both Mappings
 *                   |
 *                   v
 *
 *           Mapping Valid?
 *                   |
 *                   v
 *
 *          Loop Successfully Completed
 *                   |
 *                   v
 *
 *              Isomorphic
 *
 *===========================================================
 *
 * Why Two HashMaps?
 *
 * map1:
 * First String ke character ko second String ke character
 * ke saath map karega.
 *
 * map2:
 * Second String ke character ko first String ke character
 * ke saath map karega.
 *
 * Agar sirf ek HashMap use karenge toh reverse mapping
 * check nahi kar payenge.
 *
 * Example:
 *
 * s1 = "ab"
 * s2 = "cc"
 *
 * Mapping:
 * a -> c
 * b -> c
 *
 * Yahan two different characters same character se map ho rahe hain.
 *
 * Isliye second HashMap se reverse mapping check karna zaroori hai.
 *
 *===========================================================
 *
 * Time Complexity: O(n)
 *
 * Space Complexity: O(k)
 *
 * n = Length of the String
 * k = Number of unique characters
 *
 *===========================================================
 */

package Lec16_HashingDataStruture_Map_HashMap_Set_HashSet;

import java.util.HashMap;

import java.util.Map;

public class P30_CheckWhetherTwoStringsAreIsomorphicOrNotUsingHashMap
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		String s1 = "paper";

		String s2 = "title";

		
		//String s1 = "ab";
		//String s2 = "cc";
		Map<Character, Character> map1 = new HashMap<>();

		Map<Character, Character> map2 = new HashMap<>();

		/*===========================================================
		  Step 1: Dono Strings ki length check karenge
		===========================================================*/

		if (s1.length() != s2.length())
		{
			/*
			 * Agar dono Strings ki length different hai,
			 * toh unke characters ka one-to-one mapping
			 * possible nahi hoga.
			 *
			 * Isliye dono Strings Isomorphic nahi hain.
			 *
			 * return statement main method ko yahin terminate
			 * kar dega aur aage ka code execute nahi hoga.
			 */

			System.out.println("Strings are not Isomorphic");

			return;
		}

		/*===========================================================
		  Step 2: Dono Strings ko ek saath traverse karenge
		===========================================================*/

		for (int i = 0; i < s1.length(); i++)
		{
			char ch1 = s1.charAt(i);

			char ch2 = s2.charAt(i);

			/*===========================================================
			  Step 3: First String ki mapping check karenge
			===========================================================*/

			if (map1.containsKey(ch1))
			{
				/*
				 * Agar ch1 already map1 mein present hai,
				 * iska matlab is character ki mapping pehle
				 * se store ho chuki hai.
				 *
				 * map1.get(ch1) se uski existing mapped value
				 * retrieve karenge.
				 *
				 * Check karenge ki existing value current ch2
				 * ke equal hai ya nahi.
				 *
				 * Agar equal nahi hai toh same character
				 * different characters se map ho raha hai.
				 *
				 * Isliye Strings Isomorphic nahi hain.
				 */

				char value = map1.get(ch1);

				if (value != ch2)
				{
					System.out.println("Strings are not Isomorphic");

					return;
				}
			}

			/*===========================================================
			  Step 4: Second String ki reverse mapping check karenge
			===========================================================*/

			if (map2.containsKey(ch2))
			{
				/*
				 * Agar ch2 already map2 mein present hai,
				 * iska matlab is character ki reverse mapping
				 * pehle se store ho chuki hai.
				 *
				 * map2.get(ch2) se uski existing mapped value
				 * retrieve karenge.
				 *
				 * Check karenge ki existing value current ch1
				 * ke equal hai ya nahi.
				 *
				 * Agar equal nahi hai toh different characters
				 * same character se map ho rahe hain.
				 *
				 * Isliye Strings Isomorphic nahi hain.
				 */

				char value = map2.get(ch2);

				if (value != ch1)
				{
					System.out.println("Strings are not Isomorphic");

					return;
				}
			}

			/*===========================================================
			  Step 5: Dono Characters ki mapping store karenge
			===========================================================*/

			/*
			 * Agar program yahan tak aa gaya hai,
			 * toh current characters ki mapping valid hai.
			 *
			 * map1 mein ch1 ko key aur ch2 ko value banayenge.
			 *
			 * map2 mein ch2 ko key aur ch1 ko value banayenge.
			 *
			 * Is tarah forward aur reverse dono mappings
			 * HashMaps mein store ho jayengi.
			 */

			map1.put(ch1, ch2);

			map2.put(ch2, ch1);
		}

		/*===========================================================
		  Step 6: Final Result
		===========================================================*/

		/*
		 * Agar loop successfully complete ho gaya,
		 * iska matlab kisi bhi character ki mapping mein
		 * mismatch nahi mila.
		 *
		 * Har character ka mapping consistent hai.
		 *
		 * Isliye dono Strings Isomorphic hain.
		 */

		System.out.println("Strings are Isomorphic");
	}
}

/*
 *===========================================================
 *
 * Output:
 *
 * Strings are Isomorphic
 *
 *===========================================================
 */
