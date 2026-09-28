// WAP to check whether two strings are Anagram or not

/*
 * Anagram:
 *
 * Two strings are called Anagram when:
 *
 * 1) Length of both strings should be same.
 * 2) Both strings should contain the same characters.
 *
 *
 * Example:
 *
 * str1 = "listen"
 * str2 = "silent"
 Both strings contain the same characters: ==> l, i, s, t, e, n
 Therefore, "listen" and "silent" are Anagram.
 * 
 *          
 *              
 *              LOGIC
 *              
 *              Two Strings
                  ↓
          Length same hai?
             /       \
           NO         YES
           ↓           ↓
      Not Anagram   Sort both array
                       ↓
                Compare arrays
                   /       \
                 SAME     DIFFERENT
                  ↓          ↓
              Anagram    Not Anagram
 
 */

import java.util.Arrays;

public class P11_CheckTwoStringAreAnagramOrNot {

    public static void main(String[] args) {

        String str1 = "listen";
        String str2 = "silent";

        /*
         * Convert String into character array.
         *
         * "listen" ==> [l, i, s, t, e, n]
         * "silent" ==> [s, i, l, e, n, t]
         */
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        /*
         * Sort both character arrays.
         *
         * Before sorting:
         * arr1 = [l, i, s, t, e, n]
         * arr2 = [s, i, l, e, n, t]
         *
         * After sorting:
         * arr1 = [e, i, l, n, s, t]
         * arr2 = [e, i, l, n, s, t]
         *
         * If both strings contain the same characters and  both length is same then its anagram 
         */
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        /*
         * First condition: Length of both strings should be equal.
         * If length is different, strings cannot be Anagram.
         */
        if (str1.length() != str2.length()) {

            System.out.println(
                "Not Anagram --> Lengths are not same"
            );

        } else {

            /*
             * Second condition:
             *
             * Compare both sorted character arrays.
             *
             * Arrays.equals() checks whether:
             * - both arrays have same elements
             * - same elements are present at same positions
             *
             * Since both arrays are sorted,
             * this effectively checks whether both strings
             * contain the same characters.
             */
            if (Arrays.equals(arr1, arr2)) {

                System.out.println("Anagram");

            } else {

                System.out.println("Not Anagram");
            }
        }
    }
}