
package Lec16_HashingDataStruture_Map_HashMap_Set_HashSet;

import java.util.HashMap;
import java.util.Map;

//===========================================================
// P28: Find the Least Repeated Element in an Array Using HashMap
//===========================================================

public class P28_FindLeastRepeatedElementInArrayUsingHashMap
{
    public static void main(String[] args)
    {
        /*
         * Problem Statement:
         * 
         * Write a Java program to find the least repeated element
         * in an array using HashMap.
         *
         * If multiple elements have the same minimum frequency,
         * print the element that occurs first in the original array.
         *
         * Example:
         * Input:  {10, 20, 30, 10, 40, 20, 50, 30, 10, 60, 20, 10}
         * Output: 40 ==> 1
         */

        int arr[] = {10, 20, 30, 10, 40, 20, 50, 30, 10, 60, 20, 10};

        Map<Integer, Integer> map = new HashMap<>();

        //===========================================================
        // Step 1: Count the frequency of each element
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
        // Step 2: Find the least repeated element
        // If multiple elements have the same frequency,
        // the first occurring element will be selected.
        //===========================================================

        int min = Integer.MAX_VALUE;
        int minElement = 0;

        for (int i = 0; i < arr.length; i++)
        {
            int currentCount = map.get(arr[i]);

            if (currentCount < min)
            {
                min = currentCount;
                minElement = arr[i];
            }
        }

        //===========================================================
        // Step 3: Print the least repeated element
        //===========================================================

        System.out.println("Least Repeated Element: " + minElement);
        System.out.println("Frequency: " + min);

        System.out.println(minElement + " ==> " + min);
    }
}

/*
 * Output:
 *
 * Least Repeated Element: 40
 * Frequency: 1
 * 40 ==> 1
 *
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 *
 * n = Total number of elements in the array
 * k = Number of unique elements in the array
 */
