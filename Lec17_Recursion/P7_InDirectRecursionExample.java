
package Lec17_Recursion;

/*
 *============================================================
 * PS: Example of Indirect Recursion using two methods.
 *
 *Indirect Recursion: 
 *	When one method calls another method, and that method calls the first method again. like loop
 * Main Logic:
 *
 * 1. First, methodA(1) is called from main().
 * 2. methodA() prints the current number.
 * 3. Then methodA() calls methodB() with no + 1.
 * 4. methodB() prints the current number.
 * 5. Then methodB() calls methodA() with no + 1.
 * 6. Both methods keep calling each other.
 * 7. When no becomes 11, the condition becomes false
 *    and recursion stops.
 *
 * Base Condition:
 * if(no <= 10)
 *
 * Recursive Calls:
 * methodA() calls methodB().
 * methodB() calls methodA().
 *
 *============================================================
 *
 * STACK PUSH (CALLING PHASE):
 *
 * STEP 1:
 * methodA(1) -> PUSH
 *
 * TOP -> methodA(1)
 *        BOTTOM
 *
 * STEP 2:
 * methodB(2) -> PUSH
 *
 * TOP -> methodB(2)
 *        methodA(1)
 *
 * STEP 3:
 * methodA(3) -> PUSH
 *
 * TOP -> methodA(3)
 *        methodB(2)
 *        methodA(1)
 *
 * STEP 4:
 * methodB(4) -> PUSH
 *
 * TOP -> methodB(4)
 *        methodA(3)
 *        methodB(2)
 *        methodA(1)
 *
 * STEP 5:
 * methodA(5) -> PUSH
 *
 * TOP -> methodA(5)
 *        methodB(4)
 *        methodA(3)
 *        methodB(2)
 *        methodA(1)
 *
 * STEP 6:
 * methodB(6) -> PUSH
 *
 * STEP 7:
 * methodA(7) -> PUSH
 *
 * STEP 8:
 * methodB(8) -> PUSH
 *
 * STEP 9:
 * methodA(9) -> PUSH
 *
 * STEP 10:
 * methodB(10) -> PUSH
 *
 * STEP 11:
 * methodA(11) -> PUSH
 *
 * Condition 11 <= 10 is false.
 * So, recursion stops.
 *
 *============================================================
 *
 * STACK POP (RETURNING PHASE):
 *
 * STEP 1:
 * methodA(11) -> POP
 *
 * STEP 2:
 * methodB(10) -> POP
 *
 * STEP 3:
 * methodA(9) -> POP
 *
 * STEP 4:
 * methodB(8) -> POP
 *
 * STEP 5:
 * methodA(7) -> POP
 *
 * STEP 6:
 * methodB(6) -> POP
 *
 * STEP 7:
 * methodA(5) -> POP
 *
 * STEP 8:
 * methodB(4) -> POP
 *
 * STEP 9:
 * methodA(3) -> POP
 *
 * STEP 10:
 * methodB(2) -> POP
 *
 * STEP 11:
 * methodA(1) -> POP
 *
 * Stack becomes EMPTY.
 *
 * No printing happens while returning because there is
 * no statement after the recursive call.
 *
 *============================================================
 *
 * FINAL OUTPUT:
 *
 * Method A:1
 * Method B:2
 * Method A:3
 * Method B:4
 * Method A:5
 * Method B:6
 * Method A:7
 * Method B:8
 * Method A:9
 * Method B:10
 *
 *============================================================
 *
 * RECURSION TYPES:
 *
 * 1. Indirect Recursion:
 *    methodA() calls methodB() and methodB() calls methodA().
 *
 * 2. Linear Recursion:
 *    Each method makes only one recursive call.
 *
 * 3. Tail Recursion:
 *    Recursive call is the last statement in each method.
 *
 * 4. Non-Head Recursion:
 *    Printing happens before the recursive call.
 *
 *============================================================
 *
 * TIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: O(n)
 *
 *============================================================
 */

public class P7_InDirectRecursionExample
{
    static int no = 1;

    //====================================================
    // Method A: Calls Method B
    //====================================================
    public static void methodA(int no)
    {
        if(no <= 10)
        {
            System.out.println("Method A:" + no);

            // Increasing the number
            no++;

            // Calling Method B
            methodB(no);
        }
    }

    //====================================================
    // Method B: Calls Method A
    //====================================================
    public static void methodB(int no)
    {
        if(no <= 10)
        {
            System.out.println("Method B:" + no);

            // Increasing the number
            no++;

            // Calling Method A
            methodA(no);
        }
    }

    public static void main(String[] args)
    {
        methodA(no);
    }
}
