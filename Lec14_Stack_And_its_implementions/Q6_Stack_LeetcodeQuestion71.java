
package Lec14_Stack_And_its_implementions;

import java.util.Stack;

// 71. Simplify Path

public class Q6_Stack_LeetcodeQuestion71 {

    //============================================================
    // Main Logic:
    //============================================================

    /*
     * 1. Sabse pehle String type ka Stack create karna hai.
     *
     * 2. Given path ko "/" ke basis par split karke String array banana hai.
     *  // Split hone ke baad Array: ["", "home", "user", "Documents", "..", "Pictures"]
     *  
     * 3. String array ko left to right traverse karna hai.
     *
     * 4. Agar current element empty String ya "." hai,
     *    toh usko ignore karna hai.
     *
     * 5. Agar current element ".." hai,
     *    toh Stack empty nahi hone par top element pop karna hai.
     *
     * 6. Agar current element directory name hai,
     *    toh usko Stack mein push karna hai.
     *
     * 7. Finally for-each loop se Stack ke elements ko
     *    index 0 se TOP tak traverse karke StringBuilder mein
     *    "/" ke saath append karna hai.
     *
     * 8. StringBuilder ko String mein convert karke return karna hai.
     */

    //============================================================
    // Main Logic: Simplify Path
    //============================================================

    public static String simplifyPath(String path) {

        // Directory names store karne ke liye String type ka Stack banaya
        Stack<String> stk = new Stack<>();

        // Given path ko "/" ke basis par split karke String array banaya
        String ch[] = path.split("/");

        // Array ke har element ko left to right traverse karenge
        for (int i = 0; i < ch.length; i++) {

            // Agar current element empty String ya "." hai,
            // toh usko ignore karke next element par jayenge
            if (ch[i].equals("") || ch[i].equals(".")) {

                continue;
            }

            // Agar current element ".." hai,
            // toh previous directory ko Stack se remove karenge
            else if (ch[i].equals("..")) {

                // Stack empty nahi hai toh top element pop karenge
                if (!stk.isEmpty()) {

                    stk.pop();
                }
            }

            // Agar current element directory name hai,
            // toh usko Stack mein push karenge
            else {

                stk.push(ch[i]);
            }
        }

        // Agar Stack empty hai toh root directory "/" return karenge
        if (stk.isEmpty()) {

            return "/";
        }

        // Final simplified path banane ke liye StringBuilder banaya
        StringBuilder sb = new StringBuilder();

        // Stack ke saare elements ko for-each loop se traverse karenge
        // For-each loop Stack ke index 0 (bottom) se TOP tak jayega
        for (String fileName : stk) {

            // Har directory name ke aage "/" add karke
            // StringBuilder mein append karenge
            sb.append("/").append(fileName);
        }

        // Final simplified path return karenge
        return sb.toString();
    }

    //============================================================
    // Working Logic: Main Method
    //============================================================

    public static void main(String[] args) {

        // Input path diya
        String path = "/home/user/Documents/../Pictures";

        // simplifyPath method call karke result receive kiya
        String result = simplifyPath(path);

        // Final simplified path print kiya
        System.out.println("Simplified Path: " + result);
    }

    //============================================================
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    //============================================================
}
