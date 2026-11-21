
package Lec16_HashingDataStruture_Map_HashMap_Set_HashSet;

import java.util.HashMap;
import java.util.Map;

/*
Problem Statement:

=> Write a Java program to find the length of the longest substring
   without repeating characters using HashMap.

Example:
   Input:  "abcabcbb"
   Output:  3

   Longest Substring: "abc"
*/

/*
Definition:

=> Substring ka matlab String ka continuous part hota hai.

=> Humein String mein aisi longest substring find karni hai
   jisme koi bhi character repeat nahi hona chahiye.

Main Logic: Sliding Window + HashMap

=> HashMap mein Character ko Key aur uske latest index ko Value
   ke form mein store karenge.

=> Sliding Window maintain karne ke liye left pointer use karenge.

=> For loop ka i current character ka index represent karega,
   yani right pointer ka kaam karega.

=> Agar current character HashMap mein already present hai,
   toh uska previous index retrieve karenge.

=> Check karenge ki previous index current window ke andar hai
   ya nahi using index >= left.

=> Agar condition true hai,iska matlb dupliacte character present he toh left ko previous index + 1
   par move karenge.

=> Har iteration mein current character ka latest index
   HashMap mein update karenge.

=> Current window ki length calculate karke maxLength update
   karenge.

=> Finally, maximum substring length print karenge.
*/

/*
Working Example: "abcabcbb"

Index:      0   1   2   3   4   5   6   7
Character:  a   b   c   a   b   c   b   b

At index 3:
Current character = 'a'
Previous index = 0
left = 0

Condition:
index >= left
0 >= 0 => true

Therefore:
left = index + 1
left = 0 + 1 = 1

New Window = "bca"
Window Length = 3

Why index >= left?

=> HashMap mein character present hone ka matlab ye nahi
   ki uska previous occurrence current window mein bhi hai.

=> Agar previous index left se chhota hai, toh character
   current window ke bahar hai. Isliye left move nahi karenge.

Why left = index + 1?

=> Kyunki duplicate character ko current window se remove
   karna hai, lekin uske baad ke valid characters ko
   preserve bhi karna hai.

Why map.put(ch, i)?

=> Har character ka latest index update karna zaroori hai,
   taaki future mein uska correct previous index mil sake.

Why Math.max()?

=> Current window ki length kabhi increase aur kabhi decrease
   ho sakti hai.

=> Math.max() purani maximum length aur current window length
   mein se jo greater hai, usko maxLength mein store karta hai.
*/

public class P31_FindLongestSubstringWithoutRepeatingCharactersUsingHashMap {

    public static void main(String[] args) {

        String str = "abcabcbb";

        /* Character = Key, Latest Index = Value */

        Map<Character, Integer> map = new HashMap<>();

        /* Current window ka starting index */

        int left = 0;

        /* Ab tak ki maximum substring length */

        int maxLength = 0;

        /* String ko left-to-right traverse karenge */

        for (int i = 0; i < str.length(); i++) {

            /* Current index ka character retrieve karenge */

            char ch = str.charAt(i);

            /* Check karenge ki current character pehle HashMap mein
               present hai ya nahi */

            if (map.containsKey(ch)) {

                /* Character ka previous/latest index retrieve karenge */

                int index = map.get(ch);

                /* Check karenge ki previous occurrence current
                   sliding window ke andar hai ya nahi */

                if (index >= left) {

                    /* Duplicate character ko remove karne ke liye
                       left ko previous index + 1 par move karenge */

                    left = index + 1;
                }
            }

            /* Current character ka latest index HashMap mein update karenge */

            map.put(ch, i);

            /* Current window ki length calculate karke
               maximum length update karenge */

            maxLength = Math.max(maxLength, i - left + 1);
        }

        System.out.println("Maximum Length: " + maxLength);
    }
}

/*
Output:

Maximum Length: 3

Time Complexity: O(n)

=> String ko ek hi baar traverse karte hain.
   HashMap operations average O(1) hote hain.

Space Complexity: O(k)

=> HashMap mein distinct characters store hote hain.
   k = Number of distinct characters.
*/
