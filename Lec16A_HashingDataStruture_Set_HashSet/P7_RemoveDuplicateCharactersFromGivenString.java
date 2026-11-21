package Lec16A_HashingDataStruture_Set_HashSet;

import java.util.HashSet;
import java.util.Set;

/*
=========================================================
Problem Statement:

    => Given a string, remove all duplicate characters.
    => Maintain the original order of characters.
    => Each character should appear only once in the result.

=========================================================
Example:

    Input:
        String s = "abacdeabc";

    Output:
        abcde

=========================================================
Main Logic:

    => Hum yaha duplicate characters remove karne ke liye
       HashSet aur StringBuilder ka use karenge.

    1) Set<Character> set:
       => Isme hum already visited characters ko store karenge.
       => HashSet duplicate values ko allow nahi karta.

    2) StringBuilder result:
       => Isme hum sirf unique characters ko store karenge.
       => StringBuilder original insertion order maintain karta hai.

    3) Loop:
       => String ke har character ko ek-ek karke traverse karenge.

    4) Condition:
       => set.contains(ch) check karega ki current character
          pehle se Set mein present hai ya nahi.

       => Agar character present nahi hai:
          a) set.add(ch) se character ko Set mein add karenge.
          b) result.append(ch) se character ko result mein add karenge.

       => Agar character already present hai:
          a) Us character ko skip kar denge.

    5) Finally:
       => result.toString() se StringBuilder ko String mein
          convert karke return kar denge.

=========================================================
Working (Dry Run):

    Input:
        String s = "abacdeabc";

    Initially:

        set = []
        result = ""

    Iteration 1:
        i = 0
        ch = 'a'

        set.contains('a') = false

        => 'a' Set mein present nahi hai.
        => set.add('a')
        => result.append('a')

        set = [a]
        result = "a"

    Iteration 2:
        i = 1
        ch = 'b'

        set.contains('b') = false

        => 'b' Set mein present nahi hai.
        => set.add('b')
        => result.append('b')

        set = [a, b]
        result = "ab"

    Iteration 3:
        i = 2
        ch = 'a'

        set.contains('a') = true

        => 'a' already Set mein present hai.
        => Isliye duplicate character ko skip kar denge.

        set = [a, b]
        result = "ab"

    Iteration 4:
        i = 3
        ch = 'c'

        set.contains('c') = false

        => 'c' Set mein present nahi hai.
        => set.add('c')
        => result.append('c')

        set = [a, b, c]
        result = "abc"

    Iteration 5:
        i = 4
        ch = 'd'

        set.contains('d') = false

        => 'd' Set mein present nahi hai.
        => set.add('d')
        => result.append('d')

        set = [a, b, c, d]
        result = "abcd"

    Iteration 6:
        i = 5
        ch = 'e'

        set.contains('e') = false

        => 'e' Set mein present nahi hai.
        => set.add('e')
        => result.append('e')

        set = [a, b, c, d, e]
        result = "abcde"

    Iteration 7:
        i = 6
        ch = 'a'

        set.contains('a') = true

        => 'a' already present hai.
        => Duplicate character skip ho jayega.

        result = "abcde"

    Iteration 8:
        i = 7
        ch = 'b'

        set.contains('b') = true

        => 'b' already present hai.
        => Duplicate character skip ho jayega.

        result = "abcde"

    Iteration 9:
        i = 8
        ch = 'c'

        set.contains('c') = true

        => 'c' already present hai.
        => Duplicate character skip ho jayega.

        result = "abcde"

    Finally:

        return result.toString();

        Output = "abcde"

=========================================================
Time Complexity:

    => O(n) Average Case

    => Hum string ke har character par ek baar loop chalate hain.
    => HashSet ke add() aur contains() operations average O(1)
       time lete hain.

=========================================================
Space Complexity:

    => O(n)

    => HashSet mein unique characters store hote hain.
    => StringBuilder mein bhi unique characters store hote hain.

=========================================================
*/

public class P7_RemoveDuplicateCharactersFromGivenString
{
    public static void main(String[] args)
    {
        String s = "abacdeabc";

        String withoutDuplicateCharacter =
                P7_RemoveDuplicateCharactersFromGivenString.removeDuplicateCharacters(s);

        System.out.println(withoutDuplicateCharacter);
    }

    //=========================================================
    // Remove Duplicate Characters Method:
    // To remove duplicate characters from a given string
    //=========================================================

    public static String removeDuplicateCharacters(String s)
    {
        // Already visited characters ko store karne ke liye
        Set<Character> set = new HashSet<>();

        // Unique characters ko store karne ke liye
        StringBuilder result = new StringBuilder();

        // String ke har character ko traverse karenge
        for(int i = 0; i < s.length(); i++)
        {
            // Current index par present character nikalenge
            char ch = s.charAt(i);

            if(!set.contains(ch))
            {
                // Character ko Set mein add karenge
                set.add(ch);

                // Character ko result mein add karenge
                result.append(ch);
            }
        }

        // StringBuilder ko String mein convert karke return karenge
        return result.toString();
    }
}