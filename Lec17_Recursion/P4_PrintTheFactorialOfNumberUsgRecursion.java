
package Lec17_Recursion;

/*
 *============================================================
 * PS: Find the factorial of a given number using Recursion.
 *
 * Example:
 * Input: 5
 * Output: 120
 *
 * Main Logic:
 *
 * 1. factorial(5) call hoga.
 * 2. Har call mein current number ko previous number se
 *    multiply karenge.
 * 3. Recursive call mein no - 1 pass karenge.
 * 4. Jab no becomes 1, base condition true ho jayegi.
 * 5. return 1 execute hoga.
 * 6. Ab returning time multiplication hoga.
 *
 * Base Condition:
 * if(no == 1)
 * {
 *     return 1;
 * }
 *
 * Recursive Call:
 * return no * factorial(no - 1);
 *
 *============================================================
 *
 * WORKING OF RECURSION:
 *
 * factorial(5)
 * = 5 * factorial(4)
 *
 * factorial(4)
 * = 4 * factorial(3)
 *
 * factorial(3)
 * = 3 * factorial(2)
 *
 * factorial(2)
 * = 2 * factorial(1)
 *
 * factorial(1)
 * = 1  (Base Condition)
 *
 *============================================================
 *
 * STACK PUSH (CALLING PHASE):
 *
 * STEP 1:
 * factorial(5) -> PUSH
 *
 * TOP -> factorial(5)
 *        BOTTOM
 *
 * STEP 2:
 * factorial(4) -> PUSH
 *
 * TOP -> factorial(4)
 *        factorial(5)
 *
 * STEP 3:
 * factorial(3) -> PUSH
 *
 * TOP -> factorial(3)
 *        factorial(4)
 *        factorial(5)
 *
 * STEP 4:
 * factorial(2) -> PUSH
 *
 * TOP -> factorial(2)
 *        factorial(3)
 *        factorial(4)
 *        factorial(5)
 *
 * STEP 5:
 * factorial(1) -> PUSH
 *
 * TOP -> factorial(1)
 *        factorial(2)
 *        factorial(3)
 *        factorial(4)
 *        factorial(5)
 *
 *============================================================
 *
 * STACK POP (RETURNING PHASE):
 *
 * STEP 1:
 * factorial(1) returns 1 -> POP
 *
 * STEP 2:
 * factorial(2) returns 2 * 1 = 2 -> POP
 *
 * STEP 3:
 * factorial(3) returns 3 * 2 = 6 -> POP
 *
 * STEP 4:
 * factorial(4) returns 4 * 6 = 24 -> POP
 *
 * STEP 5:
 * factorial(5) returns 5 * 24 = 120 -> POP
 *
 * Stack becomes EMPTY.
 *
 *============================================================
 *
 * FINAL CALCULATION:
 *
 * 5 * 4 * 3 * 2 * 1 = 120
 *
 * OUTPUT:
 * 120
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
 *    Multiplication is pending after recursive call returns.
 *
 * 4. Head Recursion:
 *    Recursive call happens before multiplication is completed.
 *
 *============================================================
 *
 * TIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: O(n)
 *
 *============================================================
 */

public class P4_PrintTheFactorialOfNumberUsgRecursion
{
    //====================================================
    // Method: To calculate factorial using Recursion
    //====================================================
    public static int factorial(int no)
    {
        if(no == 1)
        {
            return 1;
        }

        return no * factorial(no - 1);
    }

    public static void main(String[] args)
    {
        System.out.println(factorial(5));
    }
}
