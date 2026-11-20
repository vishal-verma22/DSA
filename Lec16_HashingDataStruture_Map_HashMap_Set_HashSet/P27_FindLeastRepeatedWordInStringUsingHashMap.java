
/*
 *===========================================================
 * P27: Find the Least Repeated Word in a String Using HashMap
 *===========================================================
 *
 * Problem Statement:
 *
 * Write a Java program to find the least repeated word
 * in a String using HashMap.
 *
 * If multiple words have the same minimum frequency,
 * print the word that occurs first in the original String.
 *
 * Example:
 * Input: "deepak is good boy and boy is good boy"
 * Output: deepak ==> 1
 *
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 *
 * n = Total number of words
 * k = Number of unique words
 *===========================================================
 */

package Lec16_HashingDataStruture_Map_HashMap_Set_HashSet;

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
        // Step 1: Count the frequency of each word
        //===========================================================

        for (int i = 0; i < arr.length; i++)
        {
            if (map.containsKey(arr[i]))
            {
                int freq = map.get(arr[i]);
                freq++;
                map.put(arr[i], freq);
            }
            else
            {
                map.put(arr[i], 1);
            }
        }

        //===========================================================
        // Step 2: Find the least repeated word
        //===========================================================

        int min = Integer.MAX_VALUE;
        String minWord = "";

        for (int i = 0; i < arr.length; i++)
        {
            int currentCount = map.get(arr[i]);

            if (currentCount < min)
            {
                min = currentCount;
                minWord = arr[i];
            }
        }

        //===========================================================
        // Step 3: Print the least repeated word
        //===========================================================

        System.out.println(minWord + " ==> " + min);
    }
}

/*
 * Output:
 *
 * deepak ==> 1
 */
