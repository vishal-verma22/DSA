package Lec16A_HashingDataStruture_Set_HashSet;

import java.util.HashSet;
import java.util.Set;

/*
=========================================================
Problem Statement:

    => Given a string containing multiple words, remove
       all duplicate words from the string.
    => Maintain the original order of words.
    => Each word should appear only once in the result.

=========================================================
Example:

    Input:
        String s = "vishal is good boy and vishal is better";

    Output:
        vishal is good boy and better

=========================================================
Main Logic:

    => Hum yaha duplicate words remove karne ke liye
       HashSet aur StringBuilder ka use karenge.

    1) String[] words:
       => split(" ") ka use karke String ko individual
          words mein divide karenge.

    2) Set<String> set:
       => Already visited words ko store karega.
       => HashSet duplicate words ko allow nahi karta.

    3) StringBuilder result:
       => Unique words ko original order mein store karega.

    4) Loop:
       => Har word ko ek-ek karke traverse karenge.

    5) Condition:
       => set.contains(word) check karega ki word pehle
          se Set mein present hai ya nahi.

       => Agar word present nahi hai:
          a) set.add(word) se Set mein add karenge.
          b) result.length() > 0 check karenge.
          c) Agar result empty nahi hai toh space add karenge.
          d) result.append(word) se word add karenge.

       => Agar word already present hai:
          a) Duplicate word ko skip kar denge.

    6) Finally:
       => result.toString() se StringBuilder ko String
          mein convert karke return kar denge.

=========================================================
Working (Dry Run):

    Input:
        "vishal is good boy and vishal is better"

    After split(" "):

        words = [vishal, is, good, boy, and, vishal, is, better]

    Initially:

        set = []
        result = ""

    Iteration 1:
        word = "vishal"

        set.contains("vishal") = false

        => Word Set mein present nahi hai.
        => set.add("vishal")
        => result.append("vishal")

        set = [vishal]
        result = "vishal"

    Iteration 2:
        word = "is"

        set.contains("is") = false

        => Word Set mein present nahi hai.
        => set.add("is")
        => Pehle space add karenge.
        => result.append("is")

        set = [vishal, is]
        result = "vishal is"

    Iteration 3:
        word = "good"

        set.contains("good") = false

        => Word Set mein present nahi hai.
        => set.add("good")
        => Space add karke word append karenge.

        result = "vishal is good"

    Iteration 4:
        word = "boy"

        set.contains("boy") = false

        => Word Set mein present nahi hai.
        => set.add("boy")
        => Space add karke word append karenge.

        result = "vishal is good boy"

    Iteration 5:
        word = "and"

        set.contains("and") = false

        => Word Set mein present nahi hai.
        => set.add("and")
        => Space add karke word append karenge.

        result = "vishal is good boy and"

    Iteration 6:
        word = "vishal"

        set.contains("vishal") = true

        => "vishal" already Set mein present hai.
        => Duplicate word skip kar denge.

        result = "vishal is good boy and"

    Iteration 7:
        word = "is"

        set.contains("is") = true

        => "is" already Set mein present hai.
        => Duplicate word skip kar denge.

        result = "vishal is good boy and"

    Iteration 8:
        word = "better"

        set.contains("better") = false

        => Word Set mein present nahi hai.
        => set.add("better")
        => Space add karke word append karenge.

        result = "vishal is good boy and better"

    Finally:

        return result.toString();

        Output = "vishal is good boy and better"

=========================================================
Time Complexity:

    => O(n) Average Case

    => String ko words mein split karne mein O(n) time.
    => Har word par HashSet ka contains() aur add()
       operation average O(1) hota hai.
    => Overall complexity O(n) hai, jahan n string ki
       total length hai.

=========================================================
Space Complexity:

    => O(n)

    => String array, HashSet aur StringBuilder mein
       words store ho sakte hain.

=========================================================
*/

public class P8_RemoveDuplicateWordsFromGivenString
{
    public static void main(String[] args)
    {
        String s = "vishal is good boy and vishal is better";

        String withoutDuplicateWords =
                P8_RemoveDuplicateWordsFromGivenString.removeDuplicateWords(s);

        System.out.println(withoutDuplicateWords);
    }

    //=========================================================
    // Remove Duplicate Words Method:
    // To remove duplicate words from a given string
    //=========================================================

    public static String removeDuplicateWords(String s)
    {
        // String ko individual words mein divide karenge
        String[] words = s.split(" ");

        // Already visited words ko store karne ke liye
        Set<String> set = new HashSet<>();

        // Unique words ko store karne ke liye
        StringBuilder result = new StringBuilder();

        // Har word ko traverse karenge
        for(int i = 0; i < words.length; i++)
        {
            // Current word nikalenge
            String word = words[i];

            if(!set.contains(word))
            {
                // Word ko Set mein add karenge
                set.add(word);

                // Agar result empty nahi hai toh space add karenge
                if(result.length() > 0)
                {
                    result.append(" ");
                }

                // Unique word ko result mein add karenge
                result.append(word);
            }
        }

        // StringBuilder ko String mein convert karke return karenge
        return result.toString();
    }
}