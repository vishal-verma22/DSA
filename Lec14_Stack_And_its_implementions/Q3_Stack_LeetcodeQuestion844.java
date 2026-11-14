
package Lec14_Stack_And_its_implementions;

import java.util.Stack;

/*
 * Q3 - Backspace String Compare (LeetCode 844)
 *
 * Main Logic:
 *
 * PUSH:
 * IF current character '#' nahi hai:
 *     Toh current character ko Stack mein PUSH karenge.
 *
 * POP:
 * Agar current character '#' hai:
 *     IF Stack empty nahi hai:
 *         Toh Stack ke top element ko POP kar denge.
 *
 * COMPARE:
 * Dono Strings ke final Stack banne ke baad:
 *
 *     stack1.equals(stack2) se dono Stack ke elements compare karenge.
 *
 *     IF dono Stack ke elements aur order same hain:
 *         true return hoga.
 *
 *     ELSE:
 *         false return hoga.
 *
 *
 * Working Logic:
 *
 * 1. Dono Strings ke liye alag-alag Stack banayenge.
 *
 * 2. Ek buildCharacter() method banayenge jo String ko Stack mein convert karega.
 *
 * 3. String ke har character ko ek-ek karke traverse karenge.
 *
 * 4. Agar current character '#' nahi hai toh Stack mein push kar denge.
 *
 * 5. Agar current character '#' hai toh check karenge ki Stack empty hai ya nahi.
 *
 * 6. Agar Stack empty nahi hai toh previous character ko pop kar denge.
 *
 * 7. Agar Stack empty hai toh kuch nahi karenge.
 *
 * 8. Dono Strings ke final Stack return karenge.
 *
 * 9. stack1.equals(stack2) se dono Stack ke elements aur unka order compare karenge.
 *
 * 10. Dono Stack same hain toh true, otherwise false return karenge.
 *
 */


//equals() Method:
//It compares the elements of two Stacks.
//Returns true if both Stacks contain the same elements in the same order;
//otherwise, returns false.

public class Q3_Stack_LeetcodeQuestion844 {

    public static void main(String[] args) {

        //============================================================

        // Original Strings

        String s = "ab#c";

        String t = "ad#c";

        Q3_Stack_LeetcodeQuestion844 obj = new Q3_Stack_LeetcodeQuestion844();

        boolean result = obj.backspaceCompare(s, t);

        System.out.println("Original String 1: " + s);

        System.out.println("Original String 2: " + t);

        System.out.println("Both Strings Equal: " + result);

        //============================================================

    }

    //============================================================

    // Backspace Compare Method
    // Time Complexity: O(n + m)
    // Space Complexity: O(n + m)

    public boolean backspaceCompare(String s, String t) {

        // Dono Strings ke liye alag-alag Stack banayenge

        Stack<Character> stack1 = buildCharacter(s);

        Stack<Character> stack2 = buildCharacter(t);

        // Dono Stack ke andar ke elements aur unka order compare karenge
        // Agar dono Stack same hain toh true return hoga
        // Otherwise false return hoga

        return stack1.equals(stack2);

    }

    //============================================================

    // Build Character Method
    // String ko Stack mein convert karne ke liye

    public Stack<Character> buildCharacter(String s) {

        // String ke characters store karne ke liye Stack banayenge

        Stack<Character> stk = new Stack<>();

        // String ke har character ko ek-ek karke traverse karenge

        for (int i = 0; i < s.length(); i++) {

            // String se current character get karenge

            char ch = s.charAt(i);

            // Agar current character '#' nahi hai
            // Toh current character ko Stack mein push kar denge

            if (ch != '#') {

                stk.push(ch);

            } else {

                // Agar current character '#' hai
                // Toh previous character ko remove karna hai
                // Lekin Stack empty nahi hona chahiye

                if (!stk.isEmpty()) {

                    // Stack ke top element ko remove kar denge

                    stk.pop();
                }

            }

        }

        // Backspace apply hone ke baad final Stack return karenge

        return stk;

    }

    //============================================================

}
