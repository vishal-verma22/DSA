
package Lec17_Recursion;

/*
 *============================================================
 * PS: Reverse a given String using Recursion.
 *
 * Example:
 * Input:  vishal
 * Output: lahsiv
 *
 * Main Logic:
 *
 * 1. We pass the String and starting index (0) to the method.
 * 2. First, check whether index == s.length().
 * 3. If the condition is true, return and stop recursion.
 * 4. Otherwise, call the same method with index + 1.
 * 5. After the recursive call returns, print the character
 *    at the current index.
 * 6. Characters are printed in reverse order because printing
 *    happens during the returning phase.
 *
 * Base Condition:
 * if(index == s.length())
 * {
 *     return;
 * }
 *
 * Recursive Call:
 * reverse(s, index + 1);
 *
 * Character Printing:
 * System.out.print(s.charAt(index));
 *
 *============================================================
 *
 * WORKING OF RECURSION:
 *
 * String = "vishal"
 *
 * Index:
 * v -> 0
 * i -> 1
 * s -> 2
 * h -> 3
 * a -> 4
 * l -> 5
 *
 * Calling Phase:
 *
 * reverse("vishal", 0)
 * reverse("vishal", 1)
 * reverse("vishal", 2)
 * reverse("vishal", 3)
 * reverse("vishal", 4)
 * reverse("vishal", 5)
 * reverse("vishal", 6)
 *
 * At index 6:
 * index == s.length()
 * 6 == 6 -> true
 *
 * So, return and stop recursion.
 *
 *============================================================
 *
 * STACK PUSH (CALLING PHASE):
 *
 * STEP 1:
 * reverse(s, 0) -> PUSH
 *
 * TOP -> reverse(s, 0)
 *        BOTTOM
 *
 * STEP 2:
 * reverse(s, 1) -> PUSH
 *
 * TOP -> reverse(s, 1)
 *        reverse(s, 0)
 *
 * STEP 3:
 * reverse(s, 2) -> PUSH
 *
 * TOP -> reverse(s, 2)
 *        reverse(s, 1)
 *        reverse(s, 0)
 *
 * STEP 4:
 * reverse(s, 3) -> PUSH
 *
 * TOP -> reverse(s, 3)
 *        reverse(s, 2)
 *        reverse(s, 1)
 *        reverse(s, 0)
 *
 * STEP 5:
 * reverse(s, 4) -> PUSH
 *
 * TOP -> reverse(s, 4)
 *        reverse(s, 3)
 *        reverse(s, 2)
 *        reverse(s, 1)
 *        reverse(s, 0)
 *
 * STEP 6:
 * reverse(s, 5) -> PUSH
 *
 * TOP -> reverse(s, 5)
 *        reverse(s, 4)
 *        reverse(s, 3)
 *        reverse(s, 2)
 *        reverse(s, 1)
 *        reverse(s, 0)
 *
 * STEP 7:
 * reverse(s, 6) -> PUSH
 *
 * TOP -> reverse(s, 6)
 *        reverse(s, 5)
 *        reverse(s, 4)
 *        reverse(s, 3)
 *        reverse(s, 2)
 *        reverse(s, 1)
 *        reverse(s, 0)
 *
 * Condition is true, so reverse(s, 6) returns.
 *
 *============================================================
 *
 * STACK POP (RETURNING PHASE):
 *
 * STEP 1:
 * reverse(s, 6) -> POP
 * No character is printed.
 *
 * STEP 2:
 * reverse(s, 5) -> Print s.charAt(5) = 'l' -> POP
 *
 * TOP -> reverse(s, 4)
 *        reverse(s, 3)
 *        reverse(s, 2)
 *        reverse(s, 1)
 *        reverse(s, 0)
 *
 * STEP 3:
 * reverse(s, 4) -> Print s.charAt(4) = 'a' -> POP
 *
 * TOP -> reverse(s, 3)
 *        reverse(s, 2)
 *        reverse(s, 1)
 *        reverse(s, 0)
 *
 * STEP 4:
 * reverse(s, 3) -> Print s.charAt(3) = 'h' -> POP
 *
 * TOP -> reverse(s, 2)
 *        reverse(s, 1)
 *        reverse(s, 0)
 *
 * STEP 5:
 * reverse(s, 2) -> Print s.charAt(2) = 's' -> POP
 *
 * TOP -> reverse(s, 1)
 *        reverse(s, 0)
 *
 * STEP 6:
 * reverse(s, 1) -> Print s.charAt(1) = 'i' -> POP
 *
 * TOP -> reverse(s, 0)
 *
 * STEP 7:
 * reverse(s, 0) -> Print s.charAt(0) = 'v' -> POP
 *
 * Stack becomes EMPTY.
 *
 *============================================================
 *
 * FINAL OUTPUT:
 *
 * lahsiv
 *
 *============================================================
 *
 * RECURSION TYPES:
 *
 * 1. Direct Recursion:
 *    Method calls itself.
 *
 * 2. Linear Recursion:
 *    Only one recursive call is made.
 *
 * 3. Non-Tail Recursion:
 *    Character printing happens after the recursive call.
 *
 * 4. Head Recursion:
 *    Recursive call happens before character printing.
 *
 *============================================================
 *
 * TIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: O(n)
 *
 * n = Length of the String.
 *
 *============================================================
 */

public class P5_ReverseTheStringUsgRecursion
{
    //====================================================
    // Method: To reverse a String using Recursion
    //====================================================
    public static void reverse(String s, int index)
    {
        if(index == s.length())
        {
            return;
        }

        // Recursive Call
        reverse(s, index + 1);

        // Printing character while returning
        System.out.print(s.charAt(index));
    }

    public static void main(String[] args)
    {
        String s = "vishal";

        reverse(s, 0);
    }
}
