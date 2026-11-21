package Lec16_HashingDataStruture_Map_HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P33_GroupTheAnagramTogether
{
    public static void main(String[] args)
    {
        String arr[] = {"eat", "tea", "ate", "tab", "xyz", "bat"};

        ArrayList<ArrayList<String>> angramList=   groupAnagram(arr);
        System.out.println(angramList);
    }

    public static ArrayList<ArrayList<String>> groupAnagram(String arr[])
    {
        Map<String, ArrayList<String>> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++)
        {
            String word = arr[i];

            // Word ko character array mein convert karenge
            char char_Array[] = word.toCharArray();

            // Character array ko sort karenge
            Arrays.sort(char_Array);

            // Sorted character array ko String mein convert karenge
            String SortedWord = new String(char_Array);

            if(map.containsKey(SortedWord))
            {
                // Agar key already present hai toh existing ArrayList nikalenge
                ArrayList<String> value = map.get(SortedWord);

                // Current word ko existing ArrayList mein add karenge
                value.add(word);
            }
            else
            {
                // Agar key present nahi hai toh new ArrayList banayenge
                ArrayList<String> value = new ArrayList<>();

                // Current word ko ArrayList mein add karenge
                value.add(word);

                // SortedWord ko key aur ArrayList ko value banayenge
                map.put(SortedWord, value);
            }
        }
return new ArrayList<>(map.values());
    }
}