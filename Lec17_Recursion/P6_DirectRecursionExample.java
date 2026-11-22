
package Lec17_Recursion;

/*
 *============================================================
 *
 * PS: Print your name 5 times using Direct Recursion.
 *
 *Direct Recursion: When a method calls itself directly, it is called Direct Recursion.
 * Main Logic:
 *
 * 1. We declare a static variable no = 1.
 * 2. We pass this variable to printName() method.
 * 3. Check whether no <= 5.
 * 4. If condition is true, print the name.
 * 5. Increase no by 1.
 * 6. Call the same method with the updated value.
 * 7. When no becomes 6, condition becomes false
 *    and recursion stops.
 *
 * Base Condition:
 * if(no <= 5)
 *
 * Recursive Call:
 * printName(no);
 *
 *============================================================
 *
 * STACK PUSH (CALLING PHASE):
 *
 * STEP 1:
 * printName(1) -> PUSH
 *
 * TOP -> printName(1)
 *        BOTTOM
 *
 * STEP 2:
 * printName(2) -> PUSH
 *
 * TOP -> printName(2)
 *        printName(1)
 *
 * STEP 3:
 * printName(3) -> PUSH
 *
 * TOP -> printName(3)
 *        printName(2)
 *        printName(1)
 *
 * STEP 4:
 * printName(4) -> PUSH
 *
 * TOP -> printName(4)
 *        printName(3)
 *        printName(2)
 *        printName(1)
 *
 * STEP 5:
 * printName(5) -> PUSH
 *
 * TOP -> printName(5)
 *        printName(4)
 *        printName(3)
 *        printName(2)
 *        printName(1)
 *
 * STEP 6:
 * printName(6) -> PUSH
 *
 * TOP -> printName(6)
 *        printName(5)
 *        printName(4)
 *        printName(3)
 *        printName(2)
 *        printName(1)
 *
 * Condition 6 <= 5 is false.
 * So, recursion stops.
 *
 *============================================================
 *
 * STACK POP (RETURNING PHASE):
 *
 * STEP 1:
 * printName(6) -> POP
 *
 * STEP 2:
 * printName(5) -> POP
 *
 * STEP 3:
 * printName(4) -> POP
 *
 * STEP 4:
 * printName(3) -> POP
 *
 * STEP 5:
 * printName(2) -> POP
 *
 * STEP 6:
 * printName(1) -> POP
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
 * vishal
 * vishal
 * vishal
 * vishal
 * vishal
 *
 *============================================================
 *
 * RECURSION TYPES:
 *
 * 1. Direct Recursion:
 *    Method calls itself directly.
 *
 * 2. Linear Recursion:
 *    Only one recursive call is made.
 *
 * 3. Tail Recursion:
 *    Recursive call is the last statement in the method.
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

public class P6_DirectRecursionExample
{
    static int no = 1;

    //====================================================
    // Method: To print name 5 times using Direct Recursion
    //====================================================
    public static void printName(int no)
    {
        if(no <= 5)
        {
            // Printing the name
            System.out.println("vishal");

            // Increasing the number
            no++;

            // Recursive Call
            printName(no);
        }
    }

    public static void main(String[] args)
    {
        printName(no);
    }
}
