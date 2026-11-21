package Lec16A_HashingDataStruture_Set_HashSet;

import java.util.HashSet;
import java.util.Set;

/*
=========================================================
Problem Statement:

    => Given a string, find the first non-duplicate character.
    => A non-duplicate character is a character that appears
       only once in the given string.
    => Return the first non-duplicate character according
       to the original string order.
    => If no non-duplicate character exists, return null.

=========================================================
Example:

    Input:
        String s = "abacdeabc";

    Output:
        d

=========================================================
Main Logic:

    => Hum yaha first non-duplicate character find karne ke
       liye two HashSet aur two loops ka use karenge.

    1) Set<Character> set:

       => Isme already visited characters ko store karenge.
       => Isse pata chalega ki koi character pehle aa chuka hai
          ya nahi.

    2) Set<Character> duplicate:

       => Isme repeated characters ko store karenge.
       => Jo character dobara milega, use duplicate Set mein
          add kar denge.

    3) First Loop:

       => String ke har character ko traverse karenge.

       => Agar character set mein already present hai:
          a) Iska matlab character repeat ho raha hai.
          b) Isliye duplicate.add(ch) karenge.

       => Agar character set mein present nahi hai:
          a) Iska matlab character pehli baar mila hai.
          b) Isliye set.add(ch) karenge.

    4) Second Loop:

       => Original String ko dobara traverse karenge.

       => duplicate.contains(ch) check karenge.

       => Agar !duplicate.contains(ch) true hai:
          a) Iska matlab current character duplicate nahi hai.
          b) Isliye current character ko return kar denge.

       => Second loop original String ke order mein chalta hai,
          isliye hume first non-duplicate character mil jayega.

    5) Finally:

       => Agar koi non-duplicate character nahi milta,
          toh null return karenge.

=========================================================
Working (Dry Run):

    Input:
        String s = "abacdeabc";

    Initially:

        set = []
        duplicate = []

=========================================================
First Loop – Finding Duplicate Characters:

    Iteration 1:

        i = 0
        ch = 'a'

        set.contains('a') = false

        => 'a' pehli baar mila hai.
        => set.add('a')

        set = [a]
        duplicate = []

    Iteration 2:

        i = 1
        ch = 'b'

        set.contains('b') = false

        => 'b' pehli baar mila hai.
        => set.add('b')

        set = [a, b]
        duplicate = []

    Iteration 3:

        i = 2
        ch = 'a'

        set.contains('a') = true

        => 'a' already Set mein present hai.
        => Isliye duplicate.add('a')

        set = [a, b]
        duplicate = [a]

    Iteration 4:

        i = 3
        ch = 'c'

        set.contains('c') = false

        => 'c' pehli baar mila hai.
        => set.add('c')

        set = [a, b, c]
        duplicate = [a]

    Iteration 5:

        i = 4
        ch = 'd'

        set.contains('d') = false

        => 'd' pehli baar mila hai.
        => set.add('d')

        set = [a, b, c, d]
        duplicate = [a]

    Iteration 6:

        i = 5
        ch = 'e'

        set.contains('e') = false

        => 'e' pehli baar mila hai.
        => set.add('e')

        set = [a, b, c, d, e]
        duplicate = [a]

    Iteration 7:

        i = 6
        ch = 'a'

        set.contains('a') = true

        => 'a' already present hai.
        => duplicate.add('a')

        set = [a, b, c, d, e]
        duplicate = [a]

    Iteration 8:

        i = 7
        ch = 'b'

        set.contains('b') = true

        => 'b' already present hai.
        => duplicate.add('b')

        set = [a, b, c, d, e]
        duplicate = [a, b]

    Iteration 9:

        i = 8
        ch = 'c'

        set.contains('c') = true

        => 'c' already present hai.
        => duplicate.add('c')

        set = [a, b, c, d, e]
        duplicate = [a, b, c]

=========================================================
After First Loop:

    set = [a, b, c, d, e]

    duplicate = [a, b, c]

    => Ab hume pata hai ki a, b aur c duplicate hain.

=========================================================
Second Loop – Finding First Non-Duplicate Character:

    Iteration 1:

        i = 0
        ch = 'a'

        duplicate.contains('a') = true

        => 'a' duplicate hai.
        => Isliye skip karenge.

    Iteration 2:

        i = 1
        ch = 'b'

        duplicate.contains('b') = true

        => 'b' duplicate hai.
        => Isliye skip karenge.

    Iteration 3:

        i = 2
        ch = 'a'

        duplicate.contains('a') = true

        => 'a' duplicate hai.
        => Isliye skip karenge.

    Iteration 4:

        i = 3
        ch = 'c'

        duplicate.contains('c') = true

        => 'c' duplicate hai.
        => Isliye skip karenge.

    Iteration 5:

        i = 4
        ch = 'd'

        duplicate.contains('d') = false

        => 'd' duplicate Set mein present nahi hai.
        => Iska matlab 'd' sirf ek baar aaya hai.
        => return 'd' kar denge.

        Method yahi terminate ho jayega.

=========================================================
Final Result:

    First Non-Duplicate Character = 'd'

    Output:
        d

=========================================================
Time Complexity:

    => O(n) Average Case

    => First loop string ke har character ko traverse karta hai.
    => Second loop bhi maximum n characters traverse karta hai.
    => HashSet ke contains() aur add() operations average O(1)
       time lete hain.

    => O(n) + O(n) = O(2n)
    => Ignore constants, so O(n).

=========================================================
Space Complexity:

    => O(n)

    => set aur duplicate dono mein characters store ho sakte hain.
    => Worst case mein dono Sets mein O(n) characters ho sakte hain.

=========================================================
*/

public class P10_FindFirstNonDuplicateCharacterFromString
{
    public static void main(String[] args)
    {
        String s = "abacdeabc";

        P10_FindFirstNonDuplicateCharacterFromString d =
                new P10_FindFirstNonDuplicateCharacterFromString();

        Character c = d.findFirstNonDupicateCharacters(s);

        System.out.println(c);
    }

    //=========================================================
    // Method: To Find First Non-Duplicate Character
    // From a Given String
    //=========================================================

    public Character findFirstNonDupicateCharacters(String s)
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

            // Check karenge ki current character pehle se Set mein hai ya nahi
            if(set.contains(ch))
            {
                // Agar character already present hai,
                // toh iska matlab ye character repeat ho raha hai.
                // Isliye ise duplicate Set mein add karenge.
                duplicate.add(ch);
            }
            else
            {
                // Agar character Set mein present nahi hai,
                // toh ye pehli baar mila hai.
                // Isliye ise Set mein store karenge.
                set.add(ch);
            }
        }

        // Original String ko dobara traverse karenge
        for(int i = 0; i < s.length(); i++)
        {
            // Current index par present character nikalenge
            char ch = s.charAt(i);

            // Check karenge ki current character duplicate Set mein hai ya nahi
            if(!duplicate.contains(ch))
            {
                // Agar character duplicate Set mein nahi hai,
                // toh ye first non-duplicate character hai.
                return ch;
            }
        }

        // Agar koi non-duplicate character nahi mila
        return null;
    }
}