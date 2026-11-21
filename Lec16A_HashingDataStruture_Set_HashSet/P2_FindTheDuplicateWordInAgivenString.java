
package Lec16A_HashingDataStruture_Set_HashSet;

import java.util.HashSet;
import java.util.Set;

/*
Problem Statement:

    => Given a string, find all duplicate words
       present in the given string.

    => Use HashSet to store already visited words
       and another HashSet to store duplicate words.

    => Return all duplicate words without repetition.

Example:

    Input:  "vishal is good boy and vishal is better than rohan"

    Output: [vishal, is]


=========================================================

Main Logic:

    => Hum yaha 2 HashSet use karenge, dono ka kaam alag hai.

    1. set:

       Ye Set un words ko store karega jo hum already
       String mein visit kar chuke hain.

    2. duplicate:

       Ye Set sirf un words ko store karega jo String
       mein ek se zyada baar appear hue hain.

    => Sabse pehle split(" ") ka use karke String ko
       individual words mein divide karenge.

       Example:
       "vishal is good boy"

       ["vishal", "is", "good", "boy"]

    => Ab words array ke har word ko ek-ek karke traverse karenge.

    => set.contains(word) se check karenge ki current word
       pehle visit hua hai ya nahi.

       If condition true:

          Word pehle se set mein present hai.
          Matlab ye word dobara mila hai.
          Isliye ise duplicate Set mein add karenge.

       Else condition:

          Word pehli baar mila hai.
          Isliye ise set mein add karenge, taaki future mein
          agar ye word dobara aaye toh identify kar sakein.

    => Finally, duplicate Set return karenge.


=========================================================

Working (Dry Run):

    Input:

       String s = "vishal is good boy and vishal is better than rohan";

    After split(" "):

       words[] = {"vishal", "is", "good", "boy", "and",
                  "vishal", "is", "better", "than", "rohan"};

    Initially:

       set       = []
       duplicate = []

    1. word = "vishal"

       "vishal" set mein present nahi hai.
       Isliye else execute hoga aur "vishal" set mein add hoga.

       set       = [vishal]
       duplicate = []

    2. word = "is"

       "is" set mein present nahi hai.
       Isliye "is" set mein add hoga.

       set       = [vishal, is]
       duplicate = []

    3. word = "good"

       "good" set mein present nahi hai.
       Isliye "good" set mein add hoga.

       set       = [vishal, is, good]
       duplicate = []

    4. word = "boy"

       "boy" set mein present nahi hai.
       Isliye "boy" set mein add hoga.

       set       = [vishal, is, good, boy]
       duplicate = []

    5. word = "and"

       "and" set mein present nahi hai.
       Isliye "and" set mein add hoga.

       set       = [vishal, is, good, boy, and]
       duplicate = []

    6. word = "vishal"

       "vishal" already set mein present hai.
       Isliye if execute hoga aur "vishal" duplicate mein add hoga.

       set       = [vishal, is, good, boy, and]
       duplicate = [vishal]

    7. word = "is"

       "is" already set mein present hai.
       Isliye "is" duplicate mein add hoga.

       set       = [vishal, is, good, boy, and]
       duplicate = [vishal, is]

    8. word = "better"

       "better" set mein present nahi hai.
       Isliye "better" set mein add hoga.

    9. word = "than"

       "than" set mein present nahi hai.
       Isliye "than" set mein add hoga.

    10. word = "rohan"

        "rohan" set mein present nahi hai.
        Isliye "rohan" set mein add hoga.


    Final Duplicate Words: [vishal, is]


=========================================================

Time Complexity: O(n + m) approximately

    => split(" ") ke through String ko words mein divide karte hain.
    => Loop total m words traverse karta hai.
    => HashSet contains() and add() average O(1) hain.

    Where:
       n = Number of characters in the String.
       m = Number of words in the String.

Space Complexity: O(n)

    => Words array aur dono HashSets additional memory use karte hain.

=========================================================

*/

public class P2_FindTheDuplicateWordInAgivenString
{
    public static void main(String[] args)
    {
        String s = "vishal is good boy and vishal is better than rohan";

        P2_FindTheDuplicateWordInAgivenString d =
                new P2_FindTheDuplicateWordInAgivenString();

        Set<String> duplicate = d.findDupicateCharacters(s);

        System.out.println("Duplicate words: " + duplicate);
    }

    //=========================================================
    // Method: To Find Duplicate Words in a Given String
    //=========================================================
    public Set<String> findDupicateCharacters(String s)
    {
        // Already visited words ko store karne ke liye
        Set<String> set = new HashSet<>();

        // Repeated words ko store karne ke liye
        Set<String> duplicate = new HashSet<>();

        // String ko individual words mein divide karenge
        String words[] = s.split(" ");

        // String ke har word ko traverse karenge
        for(int i = 0; i < words.length; i++)
        {
            // Current index par present word nikalenge
            String word = words[i];

            // Check karenge ki current word pehle se set mein hai ya nahi
            if(set.contains(word))
            {
                // Agar word already present hai,
                // iska matlab ye word repeat ho raha hai.
                // Isliye ise duplicate Set mein add karenge.
                duplicate.add(word);
            }
            else
            {
                // Agar word set mein present nahi hai,
                // toh ye pehli baar mila hai.
                // Isliye ise set mein store karenge.
                set.add(word);
            }
        }

        // Finally saare duplicate words return karenge
        return duplicate;
    }
}
