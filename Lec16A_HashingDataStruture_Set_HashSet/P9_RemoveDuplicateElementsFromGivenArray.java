package Lec16A_HashingDataStruture_Set_HashSet;

import java.util.HashSet;
import java.util.Set;

/*
Problem Statement:
    => Remove duplicate elements from a given integer array using HashSet.
    => Store only unique elements in a HashSet.
    => Return the HashSet containing non-duplicate elements.

Example:
    Input: {1, 21, 1, 2, 3, 2, 4, 5}

    Output: [1, 2, 3, 4, 5, 21]

=========================================================
Main Logic:

    => Hum yaha ek HashSet banayenge jo unique elements ko store karega.

    => Array ke har element ko ek-ek karke traverse karenge.

    => Har element ko Set mein add karenge using add() method.

    => HashSet ka add() method internally check karta hai ki
       current element pehle se present hai ya nahi.

    => Agar element pehle se present nahi hai:
           => Element Set mein add ho jayega.

    => Agar element already present hai:
           => Duplicate element dobara add nahi hoga.
           => Existing element same rahega.

    => Finally poora Set return kar denge.

    => Main method mein returned Set ko nonDuplicateSet reference
       mein store karenge aur print karenge.

=========================================================
Working (Dry Run):

    Input:
        arr[] = {1, 21, 1, 2, 3, 2, 4, 5}

    Initially:
        set = {}

    Iteration 1:
        Current element = 1
        => set.add(1)
        => Element pehli baar mila, Set mein add ho jayega.

        set = {1}

    Iteration 2:
        Current element = 21
        => set.add(21)
        => Element Set mein add ho jayega.

        set = {1, 21}

    Iteration 3:
        Current element = 1
        => set.add(1)
        => Element already present hai.
        => Duplicate add nahi hoga.

        set = {1, 21}

    Iteration 4:
        Current element = 2
        => set.add(2)
        => Element Set mein add ho jayega.

        set = {1, 21, 2}

    Iteration 5:
        Current element = 3
        => set.add(3)
        => Element Set mein add ho jayega.

        set = {1, 21, 2, 3}

    Iteration 6:
        Current element = 2
        => set.add(2)
        => Element already present hai.
        => Duplicate add nahi hoga.

        set = {1, 21, 2, 3}

    Iteration 7:
        Current element = 4
        => set.add(4)
        => Element Set mein add ho jayega.

        set = {1, 21, 2, 3, 4}

    Iteration 8:
        Current element = 5
        => set.add(5)
        => Element Set mein add ho jayega.

        set = {1, 21, 2, 3, 4, 5}

    Final Step:
        => return set;
        => Set ka reference main method mein return hoga.
        => nonDuplicateSet mein store ho jayega.

    Final Output:
        [1, 2, 3, 4, 5, 21]

=========================================================
Time Complexity: O(n)

    => Hum array ke har element ko ek baar traverse karte hain.
    => HashSet ka add() method average case mein O(1) hota hai.
    => Isliye total time complexity O(n) hai.

Space Complexity: O(n)

    => Worst case mein saare array elements unique ho sakte hain.
    => Isliye HashSet mein maximum n elements store ho sakte hain.

=========================================================
*/

public class P9_RemoveDuplicateElementsFromGivenArray
{
    public static void main(String[] args)
    {
        int arr[] = {1, 21, 1, 2, 3, 2, 4, 5};

        // Method se returned Set ko reference mein store karenge
        Set<Integer> nonDuplicateSet =
                P9_RemoveDuplicateElementsFromGivenArray.removeDuplicateElements(arr);

        // Final unique elements print karenge
        System.out.println(nonDuplicateSet);
    }

    //=========================================================
    // Method: To remove duplicate elements and return unique elements
    //=========================================================
    public static Set<Integer> removeDuplicateElements(int arr[])
    {
        // Unique elements ko store karne ke liye HashSet banayenge
        Set<Integer> set = new HashSet<>();

        // Array ke har element ko traverse karenge
        for(int i = 0; i < arr.length; i++)
        {
            // Current element ko Set mein add karenge
            // Agar element already present hai toh duplicate add nahi hoga
            set.add(arr[i]);
        }

        // Unique elements wala Set return karenge
        return set;
    }
}