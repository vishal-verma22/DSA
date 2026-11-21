package Lec16A_HashingDataStruture_Set_HashSet;

import java.util.HashSet;
import java.util.Set;

/*
Problem Statement:
    => Find the first duplicate word in a given string using HashSet.
    => Agar koi word dobara encounter hota hai, toh usko print karna hai.
    => Agar koi duplicate word nahi milta, toh appropriate message print karna hai.

Example:
    Input: "vishal is good boy and vishal is better"

    Output: First duplicate word is: vishal

=========================================================
Main Logic:

    => Hum yaha ek HashSet banayenge jo already visited words
       ko store karega.

    => Sabse pehle split(" ") method se String ko individual words
       mein divide karenge.

    => Ab har word ko ek-ek karke traverse karenge.

    => Har word ke liye contains() method se check karenge
       ki current word pehle se Set mein present hai ya nahi.

    => Agar word already Set mein present hai:
           => Matlab current word duplicate hai.
           => Us word ko print karenge.
           => found = true karenge.
           => break use karke loop stop kar denge.

    => Agar word Set mein present nahi hai:
           => Matlab word pehli baar encounter hua hai.
           => Usko Set mein add kar denge.

    => Agar poora loop complete hone ke baad bhi duplicate nahi mila,
       toh found false rahega aur no duplicate ka message print hoga.

=========================================================
Working (Dry Run):

    Input: "vishal is good boy and vishal is better"

    After split(" "):

        words[] = {"vishal", "is", "good", "boy",
                   "and", "vishal", "is", "better"}

    Initially:
        set = {}
        found = false

    Iteration 1:
        Current word = "vishal"
        set.contains("vishal") = false
        => Pehli baar mila, Set mein add karenge.

        set = {vishal}

    Iteration 2:
        Current word = "is"
        set.contains("is") = false
        => Pehli baar mila, Set mein add karenge.

        set = {vishal, is}

    Iteration 3:
        Current word = "good"
        set.contains("good") = false
        => Set mein add karenge.

        set = {vishal, is, good}

    Iteration 4:
        Current word = "boy"
        set.contains("boy") = false
        => Set mein add karenge.

        set = {vishal, is, good, boy}

    Iteration 5:
        Current word = "and"
        set.contains("and") = false
        => Set mein add karenge.

        set = {vishal, is, good, boy, and}

    Iteration 6:
        Current word = "vishal"
        set.contains("vishal") = true
        => Word pehle se Set mein present hai.
        => Duplicate word mil gaya.
        => found = true
        => Word print hoga.
        => break ki wajah se loop stop ho jayega.

    Final Output:
        First duplicate word is: vishal

=========================================================
Time Complexity: O(n)

    => String ko split karne mein O(n) time lagta hai.
    => Har word ko maximum ek baar traverse karte hain.
    => HashSet contains() aur add() average O(1) hote hain.
    => Isliye total complexity O(n) hai.

Space Complexity: O(n)

    => Words array aur HashSet mein maximum n characters ke
       proportional space lag sakta hai.

=========================================================
*/

public class P5_FindTheFirstDuplicateWordInGivenString
{
    public static void main(String args[])
    {
        String s = "vishal is good boy and vishal is better";

        P5_FindTheFirstDuplicateWordInGivenString d =
                new P5_FindTheFirstDuplicateWordInGivenString();

        d.findFirstDuplicateWord(s);
    }

    //=========================================================
    // Method: To find the first duplicate word in a String
    //=========================================================
    public void findFirstDuplicateWord(String s)
    {
        // String ko individual words mein divide karenge
        String words[] = s.split(" ");

        // Already visited words ko store karne ke liye
        Set<String> set = new HashSet<>();

        // Duplicate word mila ya nahi usko track karne ke liye
        boolean found = false;

        // Har word ko traverse karenge
        for(int i = 0; i < words.length; i++)
        {
            // Current index par present word nikalenge
            String word = words[i];

            // Check karenge ki current word pehle se Set mein hai ya nahi
            if(set.contains(word))
            {
                // Duplicate word mil gaya toh print karenge
                System.out.println("First duplicate word is: " + word);

                // Duplicate milne ke baad found true kar denge
                found = true;

                // First duplicate mil gaya, ab loop stop kar denge
                break;
            }

            // Agar word pehle se present nahi hai toh Set mein add karenge
            set.add(word);
        }

        // Agar poore loop mein koi duplicate nahi mila
        if(!found)
        {
            System.out.println("No duplicate word found");
        }
    }
}