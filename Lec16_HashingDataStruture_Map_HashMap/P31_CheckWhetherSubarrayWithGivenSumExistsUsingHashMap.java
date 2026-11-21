
package Lec16_HashingDataStruture_Map_HashMap;

import java.util.HashMap;
import java.util.Map;

/*
================================================================================
3. SUBARRAY WITH GIVEN SUM EXISTS
================================================================================

PROBLEM STATEMENT:

    => Write a Java program to check whether a contiguous subarray exists
       in an array whose sum is equal to a given target value using HashMap.

    => Traverse the array only once using Prefix Sum and HashMap.


DEFINITION:

    => Subarray ka matlab hota hai array ke continuous (contiguous)
       elements ka group.

    => Humein check karna hai ki array mein koi aisa continuous subarray
       exist karta hai ya nahi, jiska sum given target ke equal ho.


MAIN LOGIC:

    => Current Prefix Sum - Target = Required Previous Prefix Sum

    => Sabse pehle current prefix sum mein se target subtract karenge.

    => Subtract karne ke baad jo value milegi, us value ko HashMap mein
       search karenge.

    => Agar woh value HashMap mein present hai, toh iska matlab hai ki
       us previous prefix sum ke next index se lekar current index tak
       hamara required subarray exist karta hai.

    => Agar required prefix sum HashMap mein present nahi hai, toh
       current prefix sum aur uska index HashMap mein store karenge.

    => Ek additional condition sum == target bhi check karenge, kyunki
       agar current prefix sum hi target ke equal hai, toh subarray
       index 0 se current index tak exist karta hai.


HASHMAP:

    Key   = Prefix Sum
    Value = Index


EXAMPLE:

    arr = {2, 3, 5, 7}

    target = 8


================================================================================
WORKING LOGIC
================================================================================

    1. Sabse pehle prefix sum = 0 initialize karenge.

    2. Ek HashMap create karenge, jisme:

           Key   = Prefix Sum
           Value = Index

    3. Array ko traverse karenge aur current element ko prefix sum
       mein add karte jayenge.

    4. Sabse pehle check karenge ki current prefix sum target ke
       equal hai ya nahi.

           if(sum == target)

       Agar equal hai, toh iska matlab index 0 se current index tak
       ka subarray target ke equal hai.

    5. Agar current prefix sum target ke equal nahi hai, toh target
       ko current prefix sum se subtract karenge.

           previousSum = sum - target;

    6. Ab HashMap mein previousSum search karenge.

    7. Agar previousSum HashMap mein present hai, toh uski stored
       index retrieve karenge.

           index = map.get(previousSum);

       Stored index ko skip karke uske just next index se current
       index tak hamara required subarray hoga.

           Starting Index = Previous Index + 1
           Ending Index   = Current Index

    8. Agar previousSum HashMap mein present nahi hai, toh current
       prefix sum aur uska index HashMap mein store karenge.

           map.put(sum, i);


================================================================================
DIAGRAM AND DRY RUN
================================================================================

ARRAY:

    Index       0      1      2      3
    Element     2      3      5      7

    Target = 8


STEP 1: INITIALIZATION

    sum = 0

    HashMap = { }


STEP 2: ARRAY TRAVERSE KARENGE

    At Index 0:

        Current Element = 2

        sum = 0 + 2
            = 2

        Condition:

            sum == target
            2 == 8

        False.

        previousSum = sum - target
                    = 2 - 8
                    = -6

        HashMap mein -6 present nahi hai.

        Isliye current sum aur index store karenge:

            map.put(2, 0);

        HashMap:

            Key       Value
            2           0


    At Index 1:

        Current Element = 3

        sum = 2 + 3
            = 5

        Condition:

            sum == target
            5 == 8

        False.

        previousSum = sum - target
                    = 5 - 8
                    = -3

        HashMap mein -3 present nahi hai.

        Isliye current sum aur index store karenge:

            map.put(5, 1);

        HashMap:

            Key       Value
            2           0
            5           1


    At Index 2:

        Current Element = 5

        sum = 5 + 5
            = 10

        Condition:

            sum == target
            10 == 8

        False.

        previousSum = sum - target
                    = 10 - 8
                    = 2

        Ab HashMap mein 2 search karenge.

        HashMap mein 2 present hai.

        Isliye:

            index = map.get(2);
                  = 0

        Previous Index = 0

        Starting Index = Previous Index + 1
                       = 0 + 1
                       = 1

        Ending Index = Current Index
                    = 2


    REQUIRED SUBARRAY:

        Index       0      1      2      3
        Element     2     [3]    [5]     7
                       |      |
                       +------+

        Subarray = {3, 5}

        Sum = 3 + 5
            = 8


RESULT:

    Subarray with given target sum exists.

    Starting Index = 1
    Ending Index   = 2

    Subarray = {3, 5}

    Sum = 8


================================================================================
WHY PREFIX SUM - TARGET?
================================================================================

    => Current prefix sum mein index 0 se current index tak ke saare
       elements ka sum included hota hai.

    => Humein current prefix sum mein se pehle ke kuch elements ka sum
       remove karna hai, taaki remaining sum exactly target ke equal ho.

    Example:

        Current Prefix Sum = 10

        Target = 8

        Required Previous Prefix Sum = 10 - 8
                                     = 2

    => Ab HashMap mein 2 search karenge.

    => Agar 2 present hai, toh iska matlab hai ki previous index tak
       ka prefix sum 2 tha.

        Current Prefix Sum  = 10
        Previous Prefix Sum = 2

        Subarray Sum = 10 - 2
                     = 8

    => Previous prefix sum ko subtract karne ke baad uske next index
       se current index tak ke elements ka sum exactly target ke
       equal ho jata hai.


================================================================================
WHY CHECK sum == target?
================================================================================

    => Ye condition index 0 se start hone wale subarray ko handle
       karne ke liye hai.

    => Suppose:

        arr = {3, 5, 2}

        target = 8

    => Index 0 par:

        sum = 3

        sum == target
        3 == 8

        False.

    => Index 1 par:

        sum = 3 + 5
            = 8

        sum == target
        8 == 8

        True.

    => Iska matlab index 0 se index 1 tak ka subarray target ke
       equal hai.

        Subarray = {3, 5}

        Sum = 8

    => Isliye current prefix sum ko directly target ke saath
       compare karte hain.


================================================================================
TIME AND SPACE COMPLEXITY
================================================================================

TIME COMPLEXITY: O(n)

    => Array ko sirf ek baar traverse kar rahe hain.

    => HashMap ka containsKey() aur put() average O(1) time lete hain.

    => Isliye overall time complexity O(n) hai.


SPACE COMPLEXITY: O(n)

    => Worst case mein HashMap ke andar n different prefix sums
       store ho sakte hain.

    => Isliye space complexity O(n) hai.

================================================================================
*/


public class P31_CheckWhetherSubarrayWithGivenSumExistsUsingHashMap {

    public static void main(String[] args) {

        //int arr[] = {10, 20, -10, 0, 8};

        int arr[] = {2, 3, 5, 7};

        int target = 8;

        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {

            /* Current element ko prefix sum mein add karenge. */
            sum = sum + arr[i];

            /* Check karenge ki current prefix sum hi target ke equal hai ya nahi.
               Agar equal hai, toh index 0 se current index tak subarray exist karta hai. */
            if(sum == target) {

                System.out.println("Subarray exists from index 0 to " + i);
                return;

            }

            /* Current prefix sum mein se target subtract karke
               required previous prefix sum calculate karenge. */
            int previousSum = sum - target;

            /* Check karenge ki required previous prefix sum HashMap mein
               present nahi hai. Agar nahi hai, toh current sum aur index store karenge. */
            if(!map.containsKey(previousSum)) {

                map.put(sum, i);

            } else {

                /* Required previous prefix sum mil gaya hai,
                   isliye uska corresponding index retrieve karenge. */
                int index = map.get(previousSum);

                /* Previous index ko skip karke next index se current index
                   tak required subarray exist karta hai. */
                System.out.println("Subarray exists from index " + (index + 1) + " to " + i);
                return;

            }

        }

        /* Agar poora array traverse karne ke baad bhi subarray nahi mila,
           toh given target sum ka subarray exist nahi karta. */
        System.out.println("Subarray does not exist");

    }

}
