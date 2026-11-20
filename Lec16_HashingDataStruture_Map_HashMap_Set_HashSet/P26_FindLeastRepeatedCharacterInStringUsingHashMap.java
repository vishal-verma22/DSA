
/*
 *===========================================================
 * P26: Find the Least Repeated Character in a String Using HashMap
 *===========================================================
 *
 * Problem Statement:
 *
 * Write a Java program to find the least repeated character
 * in a String using HashMap.
 *
 * If multiple characters have the same minimum frequency,
 * print the character that occurs first in the original String.
 *
 * Example:
 * Input: "deeeepakisgoodboy"
 * Output: p ==> 1
 *
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 *
 * n = Total number of characters
 * k = Number of unique characters
 *===========================================================
 */

package Lec16_HashingDataStruture_Map_HashMap_Set_HashSet;

import java.util.HashMap;
import java.util.Map;

public class P26_FindLeastRepeatedCharacterInStringUsingHashMap
{
    public static void main(String[] args)
    {
        String s = "deeeepakisgoodboy";

        Map<Character, Integer> map = new HashMap<>();

        //===========================================================
        // Step 1: Count the frequency of each character
        //===========================================================

        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            if (map.containsKey(ch))
            {
                int freq = map.get(ch);
                freq++;
                map.put(ch, freq);
            }
            else
            {
                map.put(ch, 1);
            }
        }

        //===========================================================
        // Step 2: Find the least repeated character
        //===========================================================

        int min = Integer.MAX_VALUE;
        char minCh = ' ';

        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            int currentCount = map.get(ch);

            if (currentCount < min)
            {
                min = currentCount;
                minCh = ch;
            }
        }

        //===========================================================
        // Step 3: Print the least repeated character
        //===========================================================

        System.out.println(minCh + " ==> " + min);
    }
}

/*
 * Output:
 *
 * p ==> 1
 */
