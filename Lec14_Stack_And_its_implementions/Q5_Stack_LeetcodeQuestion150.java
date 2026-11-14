// Leetcode 150:Evaluate Reverse Polish Notation

package Lec14_Stack_And_its_implementions;

import java.util.Stack;


public class Q5_Stack_LeetcodeQuestion150 {

    //============================================================
    // Main Logic:
    //============================================================

    /*
     * 1. Sabse pehle Integer type ka Stack create karna hai.
     *
     * 2. Tokens array ko left to right traverse karna hai.
     *
     * 3. Agar current token operator (+, -, *, /) hai,
     *    toh Stack se top ke 2 elements pop karne hain.
     *
     * 4. Dono elements par corresponding operation perform karna hai.
     *
     * 5. Operation ka result wapas Stack mein push karna hai.
     *
     * 6. Agar current token operator nahi hai,
     *    toh String number ko Integer mein convert karke
     *    Stack mein push karna hai.
     *
     * 7. Saare tokens process hone ke baad Stack ke top par
     *    final answer milega.
     */

    //============================================================
    // Working Logic:
    //============================================================

    /*
     * Example:
     * tokens = {"2", "1", "+", "3", "*"}
     *
     * Step 1: Token = "2"
     * Operator nahi hai, isliye Stack mein push karenge.
     * Stack = [2]
     *
     * Step 2: Token = "1"
     * Operator nahi hai, isliye Stack mein push karenge.
     * Stack = [2, 1]
     *
     * Step 3: Token = "+"
     * Operator hai, isliye Stack se 2 elements pop karenge.
     * no2 = 1
     * no1 = 2
     * Addition: 2 + 1 = 3
     * Result ko Stack mein push karenge.
     * Stack = [3]
     *
     * Step 4: Token = "3"
     * Operator nahi hai, isliye Stack mein push karenge.
     * Stack = [3, 3]
     *
     * Step 5: Token = "*"
     * Operator hai, isliye Stack se 2 elements pop karenge.
     * no2 = 3
     * no1 = 3
     * Multiplication: 3 * 3 = 9
     * Result ko Stack mein push karenge.
     * Stack = [9]
     *
     * Final Answer = 9
     */
	 //============================================================
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    //============================================================

    //============================================================
    // Main Logic: Evaluate Reverse Polish Notation
    //============================================================

    public static int evalRPN(String[] tokens) {

        // Integer values store karne ke liye Stack banaya
        Stack<Integer> stk = new Stack<>();

        // Tokens array ko left to right traverse karenge
        for (int i = 0; i < tokens.length; i++) {

            // Current token ko ch variable mein store kiya
            String ch = tokens[i];

            // Agar ch mein "+" operator hai, toh addition perform karega
            if (ch.equals("+")) {

                int no2 = stk.pop();
                int no1 = stk.pop();

                int sum = no1 + no2;

                // Addition ka result Stack mein push kiya
                stk.push(sum);
            }

            // Agar ch mein "-" operator hai, toh subtraction perform karega
            else if (ch.equals("-")) {

                int no2 = stk.pop();
                int no1 = stk.pop();

                int sum = no1 - no2;

                // Subtraction ka result Stack mein push kiya
                stk.push(sum);
            }

            // Agar ch mein "*" operator hai, toh multiplication perform karega
            else if (ch.equals("*")) {

                int no2 = stk.pop();
                int no1 = stk.pop();

                int sum = no1 * no2;

                // Multiplication ka result Stack mein push kiya
                stk.push(sum);
            }

            // Agar ch mein "/" operator hai, toh division perform karega
            else if (ch.equals("/")) {

                int no2 = stk.pop();
                int no1 = stk.pop();

                int sum = no1 / no2;

                // Division ka result Stack mein push kiya
                stk.push(sum);
            }

            // Agar ch mein koi operator nahi hai, toh number hai
            else {

                // String number ko Integer mein convert karke Stack mein push kiya
                stk.push(Integer.parseInt(ch));
            }
        }

        // Stack ke top par final answer hoga
        return stk.peek();
    }

    //============================================================
    // Working Logic: Main Method
    //============================================================

    public static void main(String[] args) {

        // Input array create kiya
        String[] tokens = {"2", "1", "+", "3", "*"};

        // evalRPN method call karke result receive kiya
        int result = evalRPN(tokens);

        // Final answer print kiya
        System.out.println("Final Answer: " + result);

    }
}
   
