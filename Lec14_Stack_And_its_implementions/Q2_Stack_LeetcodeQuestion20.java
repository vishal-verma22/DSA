
package Lec14_Stack_And_its_implementions;

import java.util.Stack;

/*
 * Q2 - Valid Parentheses (LeetCode 20)
 *
 * Main Logic:
 *
 * PUSH:
 *     IF opening bracket mila toh Stack mein PUSH karenge.
 *
 * POP:
 *     Agar closing bracket mila toh pop karenge 1 element stack se  :
 *
 *         IF Stack empty hai:
 *             false return kar denge.
 *
 *         ELSE:
 *             Stack ke top element ko POP karenge.
 *
 * MATCH:
 *     IF closing bracket aur popped opening bracket ka pair match nahi hua:
 *         false return kar denge.
 *
 * FINALLY:
 *     IF Stack empty hai:
 *         true return karenge.
 *
 *     ELSE:
 *         false return karenge.
 *
 *
 * Working Logic:
 *
 * 1. Sabse pehle ek Stack banayenge jisme opening brackets store karenge.
 *
 * 2. String ke har character ko ek-ek karke traverse karenge.
 *
 * 3. Agar opening bracket mila toh usko Stack mein push kar denge.
 *
 * 4. Agar closing bracket mila toh check karenge ki Stack empty hai ya nahi.
 *
 * 5. Agar Stack empty hai toh matching opening bracket nahi hai,
 *    isliye false return kar denge.
 *
 * 6. Agar Stack empty nahi hai toh top element ko pop karenge.
 *
 * 7. Ab check karenge ki opening(popedEleement) aur closing(cha elememt) bracket ka pair match hua hai ya nahi.
 *
 * 8. Agar pair match nahi hua toh false return kar denge.
 *
 * 9. Finally, agar Stack empty hai toh true return karenge,
 *    otherwise false return karenge.
 *
 */

public class Q2_Stack_LeetcodeQuestion20 {

    public static void main(String[] args) {

        //============================================================

        // Original String

        String s = "{[]}";

        Q2_Stack_LeetcodeQuestion20 obj = new Q2_Stack_LeetcodeQuestion20();

        boolean result = obj.isValid(s);

        System.out.println("Original String: " + s);

        System.out.println("Is Valid Parentheses: " + result);

        //============================================================

    }

    //============================================================

    // Valid Parentheses Method
    // Time Complexity: O(n)
    // Space Complexity: O(n)

    public boolean isValid(String s) {

        // Ek Stack banayenge jisme opening brackets store karenge

        Stack<Character> stk = new Stack<>();

        // String ke har character ko ek-ek karke traverse karenge

        for (int i = 0; i < s.length(); i++) {

            // String se current character ko get karenge

            char ch = s.charAt(i);

            // Agar opening bracket mila toh Stack mein push kar denge

            if (ch == '[' || ch == '{' || ch == '(') {

                stk.push(ch);

            } else {

                // Agar closing bracket aaya aur Stack empty hai
                // Toh matching opening bracket available nahi hai
                // Isliye false return kar denge

                if (stk.isEmpty()) {

                    return false;
                }

                // Stack ke top element ko pop karke store karenge

                Character popedElement = stk.pop();

                // Check karenge ki opening aur closing bracket ka pair match hua hai ya nahi
                // Agar pair match nahi hua toh false return kar denge

                if (ch == ']' && popedElement != '[' ||
                    ch == '}' && popedElement != '{' ||
                    ch == ')' && popedElement != '(') {

                    return false;
                }

            }

        }

        // Agar Stack empty hai toh saare brackets properly match hue hain
        // Agar Stack mein opening bracket bacha hai toh false return karenge

        return stk.isEmpty();

    }

    //============================================================

}
