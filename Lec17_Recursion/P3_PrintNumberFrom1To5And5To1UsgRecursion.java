
package Lec17_Recursion;

/*
 *============================================================
 * PS: Print numbers from 1 to 5 while calling and
 *     print numbers from 5 to 1 while returning using Recursion.
 *
 * Main Logic:
 *
 * 1. First, print the current number before the recursive call.
 * 2. Then call the same method with no + 1.
 * 3. When the recursive call returns, print the current number again.
 * 4. When no becomes 6, the condition becomes false.
 * 5. Now the returning process starts and numbers print in reverse order.
 *
 * Base Condition:
 * if(no <= 5)
 *
 * Recursive Call:
 * printNumber(no + 1);
 *
 *============================================================
 *
 * STACK PUSH (CALLING PHASE):
 *
 * First printNumber(1) is called.
 *
 * PUSH 1:
 * TOP -> printNumber(1)
 *        BOTTOM
 *
 * PUSH 2:
 * TOP -> printNumber(2)
 *        printNumber(1)
 *        BOTTOM
 *
 * PUSH 3:
 * TOP -> printNumber(3)
 *        printNumber(2)
 *        printNumber(1)
 *        BOTTOM
 *
 * PUSH 4:
 * TOP -> printNumber(4)
 *        printNumber(3)
 *        printNumber(2)
 *        printNumber(1)
 *        BOTTOM
 *
 * PUSH 5:
 * TOP -> printNumber(5)
 *        printNumber(4)
 *        printNumber(3)
 *        printNumber(2)
 *        printNumber(1)
 *        BOTTOM
 *
 * PUSH 6:
 * TOP -> printNumber(6)
 *        printNumber(5)
 *        printNumber(4)
 *        printNumber(3)
 *        printNumber(2)
 *        printNumber(1)
 *        BOTTOM
 *
 * Condition 6 <= 5 is false.
 * No printing happens for printNumber(6).
 * Now returning starts.
 *
 *============================================================
 *
 * STACK POP (RETURNING PHASE):
 *
 * STEP 1:
 * printNumber(6) -> POP (condition false)
 *
 * TOP -> printNumber(5)
 *        printNumber(4)
 *        printNumber(3)
 *        printNumber(2)
 *        printNumber(1)
 *
 * STEP 2:
 * printNumber(5) -> Print 5 -> POP
 *
 * TOP -> printNumber(4)
 *        printNumber(3)
 *        printNumber(2)
 *        printNumber(1)
 *
 * STEP 3:
 * printNumber(4) -> Print 4 -> POP
 *
 * TOP -> printNumber(3)
 *        printNumber(2)
 *        printNumber(1)
 *
 * STEP 4:
 * printNumber(3) -> Print 3 -> POP
 *
 * TOP -> printNumber(2)
 *        printNumber(1)
 *
 * STEP 5:
 * printNumber(2) -> Print 2 -> POP
 *
 * TOP -> printNumber(1)
 *
 * STEP 6:
 * printNumber(1) -> Print 1 -> POP
 *
 * Stack becomes EMPTY.
 *
 *============================================================
 *
 * FINAL OUTPUT:
 *
 * Printing While calling: 1
 * Printing While calling: 2
 * Printing While calling: 3
 * Printing While calling: 4
 * Printing While calling: 5
 * Printing While returning: 5
 * Printing While returning: 4
 * Printing While returning: 3
 * Printing While returning: 2
 * Printing While returning: 1
 *
 *============================================================
 *
 * RECURSION TYPES:
 *
 * 1. Direct Recursion:
 *    Method calls itself.
 *
 * 2. Linear Recursion:
 *    Only one recursive call is present in the method.
 *
 * 3. Non-Tail Recursion:
 *    Printing is done after the recursive call returns.
 *
 * 4. Non-Head Recursion:
 *    Printing is done before the recursive call.
 *
 *============================================================
 *
 * TIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: O(n)
 *
 *============================================================
 */

public class P3_PrintNumberFrom1To5And5To1UsgRecursion
{
    //====================================================
    // Method: Print numbers while calling and returning
    //====================================================
    public static void printNumber(int no)
    {
        if(no <= 5)
        {
            // Printing While Calling
            System.out.println("Printing While calling: " + no);

            // Recursive Call
            printNumber(no + 1);

            // Printing While Returning
            System.out.println("Printing While returning: " + no);
        }
    }

    public static void main(String[] args)
    {
        printNumber(1);
    }
}
