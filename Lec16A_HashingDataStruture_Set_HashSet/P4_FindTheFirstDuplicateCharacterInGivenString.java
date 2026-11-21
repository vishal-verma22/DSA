package Lec16A_HashingDataStruture_Set_HashSet;

import java.util.HashSet;
import java.util.Set;

/*
Problem Statement:
    => Find the first duplicate character in a given string using HashSet.
    => Agar koi character dobara encounter hota hai, toh usko print karna hai.
    => Agar koi duplicate character nahi milta, toh appropriate message print karna hai.

Example:
    Input: "abcdabe"

    Output: First duplicate character is: a

=========================================================
Main Logic:

    => Hum yaha ek HashSet banayenge jo already visited characters
       ko store karega.

    => String ke har character ko ek-ek karke traverse karenge.

    => Har character ke liye contains() method se check karenge
       ki current character pehle se Set mein present hai ya nahi.

    => Agar character already Set mein present hai:
           => Matlab current character duplicate hai.
           => Us character ko print karenge.
           => found = true karenge.
           => break use karke loop stop kar denge.

    => Agar character Set mein present nahi hai:
           => Matlab character pehli baar encounter hua hai.
           => Usko Set mein add kar denge.

    => Agar poora loop complete hone ke baad bhi duplicate nahi mila,
       toh found false rahega aur no duplicate ka message print hoga.

=========================================================
Working (Dry Run):

    Input: "abcdabe"

    Initially:
        set = {}
        found = false

    Iteration 1:
        Current character = 'a'
        set.contains('a') = false
        => Character pehli baar mila.
        => set.add('a')

        set = {a}

    Iteration 2:
        Current character = 'b'
        set.contains('b') = false
        => Character pehli baar mila.
        => set.add('b')

        set = {a, b}

    Iteration 3:
        Current character = 'c'
        set.contains('c') = false
        => Character pehli baar mila.
        => set.add('c')

        set = {a, b, c}

    Iteration 4:
        Current character = 'd'
        set.contains('d') = false
        => Character pehli baar mila.
        => set.add('d')

        set = {a, b, c, d}

    Iteration 5:
        Current character = 'a'
        set.contains('a') = true
        => Character pehle se Set mein present hai.
        => Matlab duplicate character mil gaya.
        => found = true
        => Character print hoga.
        => break ki wajah se loop stop ho jayega.

    Final Output:
        First duplicate character is: a

=========================================================
Time Complexity: O(n)

    => Hum string ke characters ko maximum ek baar traverse karte hain.
    => HashSet ka contains() aur add() average case mein O(1) hota hai.
    => Isliye total time complexity O(n) hai.

Space Complexity: O(n)

    => Worst case mein saare characters unique ho sakte hain.
    => Isliye HashSet mein maximum n characters store ho sakte hain.

=========================================================
*/

public class P4_FindTheFirstDuplicateCharacterInGivenString
{
    public static void main(String args[])
    {
        String s = "abcdabe";

        P4_FindTheFirstDuplicateCharacterInGivenString d =
                new P4_FindTheFirstDuplicateCharacterInGivenString();

        d.findFirstDuplicateCharacter(s);
    }

    //=========================================================
    // Method: To find the first duplicate character in a String
    //=========================================================
    public void findFirstDuplicateCharacter(String s)
    {
        // Already visited characters ko store karne ke liye
        Set<Character> set = new HashSet<>();

        // Duplicate character mila ya nahi usko track karne ke liye
        boolean found = false;

        // String ke har character ko traverse karenge
        for(int i = 0; i < s.length(); i++)
        {
            // Current index par present character nikalenge
            char ch = s.charAt(i);

            // Check karenge ki current character pehle se Set mein hai ya nahi
            if(set.contains(ch))
            {
                // Duplicate character mil gaya toh print karenge
                System.out.println("First duplicate character is: " + ch);

                // Duplicate milne ke baad found true kar denge
                found = true;

                // First duplicate mil gaya, ab loop stop kar denge
                break;
            }

            // Agar character pehle se present nahi hai toh Set mein add karenge
            set.add(ch);
        }

        // Agar poore loop mein koi duplicate nahi mila
        if(!found)
        {
            System.out.println("No duplicate character found");
        }
    }
}