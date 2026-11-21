
package Lec16A_HashingDataStruture_Set_HashSet;

import java.util.HashSet;
import java.util.Set;

/*
Problem Statement:

    => Given a string, find all duplicate characters
       present in the given string.

    => Use HashSet to store already visited characters
       and another HashSet to store duplicate characters.

    => Return all duplicate characters without repetition.

Example:
    Input:  "abacdeabc"

    Output: [a, b, c]


=========================================================
 Main Logic:

 => Hum yaha 2 HashSet use karenge, dono ka kaam alag hai.

 1. set:
    Ye Set un characters ko store karega jo hum already
    String mein visit kar chuke hain.

 2. duplicate:
    Ye Set sirf un characters ko store karega jo String
    mein ek se zyada baar appear hue hain.

 => String ke har character ko ek-ek karke traverse karenge.

 => set.contains(ch) se check karenge ki current character
    pehle visit hua hai ya nahi.

    If condition true:
       Character pehle se set mein present hai.
       Matlab ye character dobara mila hai.
       Isliye ise duplicate Set mein add karenge.

    Else condition:
       Character pehli baar mila hai.
       Isliye ise set mein add karenge, taaki future mein
       agar ye character dobara aaye toh identify kar sakein.

 => Finally, duplicate Set return karenge.

=>Time Complexity: O(n)

=========================================================
*/


public class P1_FindTheDuplicateCharacterInAgivenString
{
    public static void main(String[] args)
    {
        String s = "abacdeabc";

        P1_FindTheDuplicateCharacterInAgivenString d =
                new P1_FindTheDuplicateCharacterInAgivenString();

        Set<Character> duplicate = d.findDupicateCharacters(s);

        System.out.println("Duplicate characters: " + duplicate);
    }

    //=========================================================
    // Method: To Find Duplicate Characters in a Given String
    //=========================================================
    public Set<Character> findDupicateCharacters(String s)
    {
        // Already visited characters ko store karne ke liye
        Set<Character> set = new HashSet<>();

        // Repeated characters ko store karne ke liye
        Set<Character> duplicate = new HashSet<>();

        // String ke har character ko traverse karenge
        for(int i = 0; i < s.length(); i++)
        {
            // Current index par present character nikalenge
            char ch = s.charAt(i);

            // Check karenge ki current character pehle se set mein hai ya nahi
            if(set.contains(ch))
            {
                // Agar character already present hai,
                // iska matlab ye character repeat ho raha hai.
                // Isliye ise duplicate Set mein add karenge.
                duplicate.add(ch);
            }
            else
            {
                // Agar character set mein present nahi hai,
                // toh ye pehli baar mila hai.
                // Isliye ise set mein store karenge.
                set.add(ch);
            }
        }

        // Finally saare duplicate characters return karenge
        return duplicate;
    }
}
