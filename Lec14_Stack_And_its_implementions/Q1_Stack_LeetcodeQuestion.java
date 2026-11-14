
package Lec14_Stack_And_its_implementions;

/*
 * Q1 – Remove All Adjacent Duplicates (LeetCode 1047)
 *
 *
 *  Main Logic:
 *
 * PUSH:
 * 	Agar Stack empty hai OR Stack ke top element aur current character same nahi hain,
 * 	toh current character ko Stack mein push kar denge.
 *
 * POP:
 * 	Agar Stack ke top element aur current character same hain,
 * 	toh Stack ke top element ko pop kar denge.
 *

 *
 * Working 
 *
 * 1. Sabse pehle ek Stack banayenge jisme String ke characters store karenge.
 * 2. String ke har character ko ek-ek karke check karenge.
 * 3. Agar Stack empty hai OR Stack ke top element aur current character same nahi hain,
 *    toh current character ko Stack mein push kar denge.
 * 4. Agar Stack ka top element aur current character same hain,
 *    toh Stack ke top element ko pop kar denge.
 *    Kyunki dono same characters hain, isliye adjacent duplicates remove ho jayenge.
 * 5. Loop complete hone ke baad Stack mein remaining characters bachenge,
 *    jinmein adjacent duplicates nahi honge.
 * 6. Ab Stack ke saare remaining elements ko StringBuilder mein store karenge.
 * 7. Stack se elements reverse order mein milte hain,
 *    isliye final String paane ke liye StringBuilder ko reverse kar denge.
 *
 */

import java.util.Stack;

public class Q1_Stack_LeetcodeQuestion {

    public static void main(String[] args) {

        //============================================================

        // Original String

        String s = "abbaca";

        Q1_Stack_LeetcodeQuestion obj = new Q1_Stack_LeetcodeQuestion();

        String result = obj.removeDuplicates(s);

        System.out.println("Original String: " + s);

        System.out.println("After Removing Duplicates: " + result);

        //============================================================

    }

    //============================================================

    // Remove Duplicates Method
    // Time Complexity: O(n)
    // Space Complexity: O(n)

    
    // main logic 
    public String removeDuplicates(String s) {

        // Create a Stack to store String characters

        Stack<Character> stk = new Stack<>();

        // Traverse String character by character

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Agar Stack empty hai OR top element aur current character same nahi hain
            // Toh current character ko Stack mein push kar denge

            if (stk.isEmpty() || ch != stk.peek()) {

                stk.push(ch);

            } else {

                // Agar top element aur current character same hain
                // Toh Stack ke top element ko pop kar denge

                stk.pop();
            }

        }

        //============================================================

        // Convert Stack into String

        StringBuilder sb = new StringBuilder();

        // Stack ke saare remaining elements ko StringBuilder mein store karenge

        while (!stk.isEmpty()) {

            sb.append(stk.pop());

        }

        // Stack se elements reverse order mein milte hain
        // Isliye original order paane ke liye reverse karenge

        return sb.reverse().toString();

    }


}
