
/*
 *===========================================================
 * P29: Check Whether Two Strings Are Anagram or Not Using HashMap
 *===========================================================
 *
 * Problem Statement:
 *
 * Write a Java program to check whether two Strings are
 * Anagrams or not using HashMap.
 *
 *===========================================================
 *
 * Anagram Kya Hota Hai?
 *
 * Do Strings Anagram tab hoti hain jab dono Strings mein
 * exactly same characters aur unki frequency same ho,
 * lekin characters ka order different ho sakta hai.
 * dono strings ka  length bhi same honi chaiye
 *
 * Example:
 *
 * s1 = "silent"
 * s2 = "listen"
 *
 * Dono Strings mein same characters hain:
 * s=1, i=1, l=1, e=1, n=1, t=1
 *
 * Isliye dono Strings Anagram hain.
 *
 *===========================================================
 *
 * Main Logic:
 *
 * Step 1:
 * Sabse pehle dono Strings ki length check karenge.
 * Agar length different hai toh Anagram nahi ho sakti.
 *
 * Step 2:
 * First String ko traverse karke HashMap mein har
 * character ki frequency store karenge.
 *
 * Step 3:
 * Second String ko traverse karke HashMap mein stored string s1 ki 
 * characters ki frequency decrease karenge.
 *
 * Step 4:
 * Agar decrease krne ke bad frequency 0 ho jaati hai toh us character ko
 * HashMap se remove kar denge q ki ab freq 0 ho gaya means vo character checked ho gaya hai s2 string se.
 *
 * Step 5:
 * 
 *  Agar second String mein koi character HashMap mein
 * present nahi hai, toh iska matlab second String mein
 * extra character ya extra frequency hai.
 *  toh wahi se ham retun ho jayenge q ki vo anagram nhi hai
 * Step 6:
 * Isliye Strings Anagram nahi hain.
 * Agar HashMap empty ho gaya toh dono Strings Anagram hain.
 * Otherwise, dono Strings Anagram nahi hain.
 *
 *===========================================================
 *
 * Diagram:
 *
 *          s1 = "silent"
 *                |
 *                v
 *       Count Character Frequency
 *                |
 *                v
 *       {s=1, i=1, l=1, e=1, n=1, t=1}
 *                |
 *                v
 *          s2 = "listen"
 *                |
 *                v
 *       Decrease Character Frequency
 *                |
 *                v
 *       Frequency 0? -> Remove Character
 *                |
 *                v
 *          Is HashMap Empty?
 *             /         \
 *           Yes          No
 *            |            |
 *            v            v
 *         Anagram     Not Anagram
 *
 *===========================================================
 *
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 *
 * n = Length of the String
 * k = Number of unique characters
 *
 *===========================================================
 */

package Lec16_HashingDataStruture_Map_HashMap;

import java.util.HashMap;
import java.util.Map;

public class P29_CheckWhetherTwoStringsAreAnagramOrNotUsingHashMap
{
    public static void main(String[] args)
    {
        String s1 = "silent";
        String s2 = "listen";

        Map<Character, Integer> map = new HashMap<>();

        /*===========================================================
          Step 1: Dono Strings ki length check karenge
        ===========================================================*/

        if (s1.length() != s2.length())
        {
            /*
             * Agar dono Strings ki length different hai,
             * toh unmein same number of characters nahi ho sakte.
             *
             * Isliye dono Strings Anagram nahi ho sakti.
             *
             * return statement main method ko yahin terminate
             * kar dega aur aage ka code execute nahi hoga.
             */

            System.out.println("Strings are not Anagram");
            return;
        }

        /*===========================================================
          Step 2: First String ke characters ki frequency count karenge
        ===========================================================*/

        for (int i = 0; i < s1.length(); i++)
        {
            char ch = s1.charAt(i);

            if (map.containsKey(ch))
            {
                /*
                 * Agar current character HashMap mein already present hai,
                 * iska matlab ye character pehle bhi aa chuka hai.
                 *
                 * map.get(ch) se us character ki existing frequency
                 * retrieve karenge.
                 *
                 * freq++ se frequency 1 increase karenge.
                 *
                 * map.put(ch, freq) se updated frequency HashMap
                 * mein dobara store karenge.
                 */

                int freq = map.get(ch);
                freq++;
                map.put(ch, freq);
            }
            else
            {
                /*
                 * Agar current character HashMap mein present nahi hai,
                 * iska matlab ye character first time mila hai.
                 *
                 * Isliye is character ki initial frequency 1 set karenge.
                 */

                map.put(ch, 1);
            }
        }

        System.out.println("First String Frequency: " + map);

        /*===========================================================
          Step 3: Second String ke characters ki frequency decrease karenge
        ===========================================================*/

        for (int i = 0; i < s2.length(); i++)
        {
            char ch = s2.charAt(i);

            if (map.containsKey(ch))
            {
                /*
                 * Agar second String ka current character HashMap mein
                 * present hai, iska matlab ye character first String
                 * mein available hai aur iska match mil gaya hai.
                 *
                 * map.get(ch) se uski current frequency retrieve karenge.
                 *
                 * freq-- se ek occurrence decrease karenge.
                 *
                 * map.put(ch, freq) se updated frequency HashMap
                 * mein store karenge.
                 */

                int freq = map.get(ch);

                freq--;

                map.put(ch, freq);

                if (map.get(ch) == 0)
                {
                    /*
                     * Agar updated frequency 0 ho gayi hai,
                     * iska matlab first String ke is character ki
                     * saari occurrences second String mein match ho chuki hain.
                     *
                     * Ab is character ki koi unmatched occurrence
                     * remaining nahi hai.
                     *
                     * Isliye is character ko HashMap se remove kar denge.
                     */

                    map.remove(ch);
                }
            }
            else
            {
                /*
                 * Agar current character HashMap mein present nahi hai,
                 * iska matlab first String mein is character ki
                 * koi unmatched occurrence available nahi hai.
                 *
                 * Yaani second String mein koi extra character hai
                 * ya uski frequency first String se zyada hai.
                 *
                 * Isliye dono Strings Anagram nahi hain.
                 *
                 * return se main method terminate kar denge.
                 */

                System.out.println("Strings are not Anagram");
                return;
            }
        }

        /*===========================================================
          Step 4: Check karenge ki HashMap empty hai ya nahi
        ===========================================================*/

        if (map.size() == 0)
        {
            /*
             * Agar HashMap empty hai, iska matlab second String ke
             * saare characters successfully match ho chuke hain.
             *
             * First String ki har character frequency completely
             * consume ho chuki hai.
             *
             * Isliye dono Strings Anagram hain.
             */

            System.out.println("Strings are Anagram");
        }
        else
        {
            /*
             * Agar HashMap empty nahi hai, iska matlab kuch characters
             * ya unki unmatched frequencies abhi bhi remaining hain.
             *
             * Isliye dono Strings Anagram nahi hain.
             */

            System.out.println("Strings are not Anagram");
        }
    }
}

/*
 *===========================================================
 * Output:
 *
 * First String Frequency: {s=1, e=1, i=1, l=1, n=1, t=1}
 * Strings are Anagram
 *
 *===========================================================
 */
