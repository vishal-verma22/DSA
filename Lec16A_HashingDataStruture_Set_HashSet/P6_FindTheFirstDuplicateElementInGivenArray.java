package Lec16A_HashingDataStruture_Set_HashSet;

import java.util.HashSet;
import java.util.Set;

/*
Problem Statement:
    => Find the first duplicate element in a given integer array using HashSet.
    => Agar koi element dobara encounter hota hai, toh usko print karna hai.
    => Agar koi duplicate element nahi milta, toh appropriate message print karna hai.

Example:
    Input: {10, 20, 30, 10, 40, 20, 50}

    Output: First duplicate element is: 10

=========================================================
Main Logic:

    => Hum yaha ek HashSet banayenge jo already visited elements
       ko store karega.

    => Array ke har element ko ek-ek karke traverse karenge.

    => Har element ke liye contains() method se check karenge
       ki current element pehle se Set mein present hai ya nahi.

    => Agar element already Set mein present hai:
           => Matlab current element duplicate hai.
           => Us element ko print karenge.
           => found = true karenge.
           => break use karke loop stop kar denge.

    => Agar element Set mein present nahi hai:
           => Matlab element pehli baar encounter hua hai.
           => Usko Set mein add kar denge.

    => Agar poora loop complete hone ke baad bhi duplicate nahi mila,
       toh found false rahega aur no duplicate ka message print hoga.

=========================================================
Working (Dry Run):

    Input: {10, 20, 30, 10, 40, 20, 50}

    Initially:
        set = {}
        found = false

    Iteration 1:
        Current element = 10
        set.contains(10) = false
        => Pehli baar mila, Set mein add karenge.

        set = {10}

    Iteration 2:
        Current element = 20
        set.contains(20) = false
        => Pehli baar mila, Set mein add karenge.

        set = {10, 20}

    Iteration 3:
        Current element = 30
        set.contains(30) = false
        => Pehli baar mila, Set mein add karenge.

        set = {10, 20, 30}

    Iteration 4:
        Current element = 10
        set.contains(10) = true
        => Element pehle se Set mein present hai.
        => Duplicate element mil gaya.
        => found = true
        => Element print hoga.
        => break ki wajah se loop stop ho jayega.

    Final Output:
        First duplicate element is: 10

=========================================================
Time Complexity: O(n)

    => Array ke elements ko maximum ek baar traverse karte hain.
    => HashSet contains() aur add() average O(1) hote hain.
    => Isliye total complexity O(n) hai.

Space Complexity: O(n)

    => Worst case mein saare array elements unique ho sakte hain.
    => Isliye HashSet mein maximum n elements store ho sakte hain.

=========================================================
*/

public class P6_FindTheFirstDuplicateElementInGivenArray
{
    public static void main(String args[])
    {
        int arr[] = {10, 20, 30, 10, 40, 20, 50};

        P6_FindTheFirstDuplicateElementInGivenArray d =
                new P6_FindTheFirstDuplicateElementInGivenArray();

        d.findFirstDuplicateElement(arr);
    }

    //=========================================================
    // Method: To find the first duplicate element in an Array
    //=========================================================
    public void findFirstDuplicateElement(int arr[])
    {
        // Already visited elements ko store karne ke liye
        Set<Integer> set = new HashSet<>();

        // Duplicate element mila ya nahi usko track karne ke liye
        boolean found = false;

        // Array ke har element ko traverse karenge
        for(int i = 0; i < arr.length; i++)
        {
            // Current index par present element nikalenge
            int element = arr[i];

            // Check karenge ki current element pehle se Set mein hai ya nahi
            if(set.contains(element))
            {
                // Duplicate element mil gaya toh print karenge
                System.out.println("First duplicate element is: " + element);

                // Duplicate milne ke baad found true kar denge
                found = true;

                // First duplicate mil gaya, ab loop stop kar denge
                break;
            }

            // Agar element pehle se present nahi hai toh Set mein add karenge
            set.add(element);
        }

        // Agar poore loop mein koi duplicate nahi mila
        if(!found)
        {
            System.out.println("No duplicate element found");
        }
    }
}