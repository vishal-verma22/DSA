
package Lec16A_HashingDataStruture_Set_HashSet;

import java.util.HashSet;
import java.util.Set;

/*
Problem Statement:

    => Given an integer array, find all duplicate numbers
       present in the given array.

    => Use HashSet to store already visited numbers
       and another HashSet to store duplicate numbers.

    => Return all duplicate numbers without repetition.

Example:

    Input:  [10, 20, 30, 10, 40, 20, 50, 30]

    Output: [10, 20, 30]


=========================================================

Main Logic:

    => Hum yaha 2 HashSet use karenge, dono ka kaam alag hai.

    1. set:

       Ye Set un numbers ko store karega jo hum already
       array mein visit kar chuke hain.

    2. duplicate:

       Ye Set sirf un numbers ko store karega jo array
       mein ek se zyada baar appear hue hain.

    => Array ke har element ko ek-ek karke traverse karenge.

    => set.contains(num) se check karenge ki current number
       pehle visit hua hai ya nahi.

       If condition true:

          Number pehle se set mein present hai.
          Matlab ye number dobara mila hai.
          Isliye ise duplicate Set mein add karenge.

       Else condition:

          Number pehli baar mila hai.
          Isliye ise set mein add karenge, taaki future mein
          agar ye number dobara aaye toh identify kar sakein.

    => Finally, duplicate Set return karenge.


=========================================================

Working (Dry Run):

    Input:
       arr[] = {10, 20, 30, 10, 40, 20, 50, 30}

    Initially:
       set       = []
       duplicate = []

    1. num = 10

       10 set mein present nahi hai.
       Isliye else execute hoga aur 10 set mein add hoga.

       set       = [10]
       duplicate = []

    2. num = 20

       20 set mein present nahi hai.
       Isliye 20 set mein add hoga.

       set       = [10, 20]
       duplicate = []

    3. num = 30

       30 set mein present nahi hai.
       Isliye 30 set mein add hoga.

       set       = [10, 20, 30]
       duplicate = []

    4. num = 10

       10 already set mein present hai.
       Isliye if execute hoga aur 10 duplicate mein add hoga.

       set       = [10, 20, 30]
       duplicate = [10]

    5. num = 40

       40 set mein present nahi hai.
       Isliye 40 set mein add hoga.

       set       = [10, 20, 30, 40]
       duplicate = [10]

    6. num = 20

       20 already set mein present hai.
       Isliye 20 duplicate mein add hoga.

       set       = [10, 20, 30, 40]
       duplicate = [10, 20]

    7. num = 50

       50 set mein present nahi hai.
       Isliye 50 set mein add hoga.

       set       = [10, 20, 30, 40, 50]
       duplicate = [10, 20]

    8. num = 30

       30 already set mein present hai.
       Isliye 30 duplicate mein add hoga.

       set       = [10, 20, 30, 40, 50]
       duplicate = [10, 20, 30]


    Final Duplicate Numbers: [10, 20, 30]


=========================================================

Time Complexity: O(n)

    => Array ke har element ko ek baar traverse karte hain.
    => HashSet contains() and add() average O(1) hain.

Space Complexity: O(n)

    => Dono HashSets mein maximum n elements store ho sakte hain.

=========================================================

*/

public class P3_FindTheDuplicateNumberInGivenArray
{
    public static void main(String[] args)
    {
        int arr[] = {10, 20, 30, 10, 40, 20, 50, 30};

        P3_FindTheDuplicateNumberInGivenArray d =
                new P3_FindTheDuplicateNumberInGivenArray();

        Set<Integer> duplicate = d.findDuplicateNumbers(arr);

        System.out.println("Duplicate numbers: " + duplicate);
    }

    //=========================================================
    // Method: To Find Duplicate Numbers in a Given Array
    //=========================================================
    public Set<Integer> findDuplicateNumbers(int arr[])
    {
        // Already visited numbers ko store karne ke liye
        Set<Integer> set = new HashSet<>();

        // Repeated numbers ko store karne ke liye
        Set<Integer> duplicate = new HashSet<>();

        // Array ke har element ko traverse karenge
        for(int i = 0; i < arr.length; i++)
        {
            // Current index par present number nikalenge
            int num = arr[i];

            // Check karenge ki current number pehle se set mein hai ya nahi
            if(set.contains(num))
            {
                // Agar number already present hai,
                // iska matlab ye number repeat ho raha hai.
                // Isliye ise duplicate Set mein add karenge.
                duplicate.add(num);
            }
            else
            {
                // Agar number set mein present nahi hai,
                // toh ye pehli baar mila hai.
                // Isliye ise set mein store karenge.
                set.add(num);
            }
        }

        // Finally saare duplicate numbers return karenge
        return duplicate;
    }
}
