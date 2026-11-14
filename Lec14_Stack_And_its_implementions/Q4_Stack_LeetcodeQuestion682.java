// PS: LeetCode 682 - Baseball Game
// Implement a Stack to perform different operations:
// C - Remove the previous score.
// D - Double the previous score.
// + - Add the previous two scores.
// Finally, calculate and return the total score.



/*
 * Main Logic:
 *
 * 1. Stack<Integer> use karenge scores store karne ke liye.
 *
 * 2. Agar operation "C" hai:
 *    Toh previous score ko POP kar denge.
 *
 * 3. Agar operation "D" hai:
 *    Toh previous score ko double karke PUSH karenge.
 *
 * 4. Agar operation "+" hai:
 *    Toh previous 2 scores ka sum calculate karke PUSH karenge.
 *
 * 5. Agar operation koi number hai:
 *    Toh String number ko Integer mein convert karke PUSH karenge.
 *
 * 6. Finally Stack ke saare scores ka sum return karenge.
 */


/*
 * Working Logic:
 *
 * 1. Sabse pehle Stack<Integer> banayenge scores store karne ke liye.
 *
 * 2. For loop ki help se operations array ke har element ko traverse karenge.
 *
 * 3. Current operation ko String ch variable mein store karenge.
 *
 * 4. IF ch.equals("C"):
 *    Toh Stack ke top element ko POP kar denge,
 *    kyunki previous score cancel karna hai.
 *
 * 5. ELSE IF ch.equals("D"):
 *    Toh Stack ke top element ko PEEK karenge,
 *    usko 2 se multiply karenge aur new score PUSH kar denge.
 *
 * 6. ELSE IF ch.equals("+"):
 *    Toh Stack ke top element ko temporarily POP karenge.
 *    Ab next top element ko PEEK karenge.
 *    Dono elements ka sum calculate karenge.
 *    Original top element ko wapas PUSH karenge.
 *    Finally calculated sum ko PUSH kar denge.
 *
 * 7. ELSE:
 *    Agar operation C, D ya + nahi hai,
 *    toh current String number ko Integer mein convert karke
 *    Stack mein PUSH kar denge.
 *
 * 8. For loop complete hone ke baad Stack ke saare elements
 *    ko POP karke sum calculate karenge.
 *
 * 9. Finally total sum return kar denge.
 */
package Lec14_Stack_And_its_implementions;

import java.util.Stack;

public class Q4_Stack_LeetcodeQuestion682 {

    public static void main(String[] args) {

        //============================================================

        String[] operations = {"5", "2", "C", "D", "+"};

        Q4_Stack_LeetcodeQuestion682 obj =
                new Q4_Stack_LeetcodeQuestion682();

        int result = obj.calPoints(operations);

        System.out.println("Final Score: " + result);

        //============================================================
    }

    /*
     * Main Method: To calculate the total score
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public int calPoints(String[] operations) {

        // Integer Stack banayenge scores store karne ke liye
        Stack<Integer> stk = new Stack<>();

        // Operations Array ke har element ko traverse karenge
        for (int i = 0; i < operations.length; i++) {

            String ch = operations[i];

            //============================================================
            // Operation 1: "C"
            // Previous score ko cancel karna hai
            // Toh Stack ke top element ko POP kar denge
            //============================================================

            if (ch.equals("C")) {

                stk.pop();

            }

            //============================================================
            // Operation 2: "D"
            // Previous score ka double calculate karenge
            // Aur new score ko Stack mein PUSH kar denge
            //============================================================

            else if (ch.equals("D")) {

                stk.push(stk.peek() * 2);

            }

            //============================================================
            // Operation 3: "+"
            // Previous 2 scores ka sum calculate karenge
            //============================================================

            else if (ch.equals("+")) {

                // Top element ko temporarily POP karenge
                int topElement = stk.pop();

                // Ab next top element ko PEEK karenge
                int nextTopElement = stk.peek();

                // Dono scores ka sum calculate karenge
                int sum = topElement + nextTopElement;

                // Original top element ko wapas PUSH karenge
                stk.push(topElement);

                // Dono scores ka sum PUSH karenge
                stk.push(sum);

            }

            //============================================================
            // Operation 4: Number
            // String number ko Integer mein convert karke PUSH karenge
            //============================================================

            else {

                stk.push(Integer.parseInt(ch));

            }
        }

        //============================================================
        // Final Sum:
        // Stack ke saare scores ka total calculate karenge
        //============================================================

        int sum = 0;

        while (!stk.isEmpty()) {

            // Top element ko POP karke sum mein add karenge
            sum = sum + stk.pop();

        }

        return sum;
    }
}
