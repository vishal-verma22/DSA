

//WAP to find the index of the first occurrence of a string in another string

/*
* Example:
*
* s1 = "hello"
* s2 = "llo"
*
* Output = 2
*
* Because "llo" first occurs at index 2.
*
*
* Sliding Window:
*
* s2 ki length ko window size maanenge.
*
* s2 = "llo"
* length = 3
*
* Therefore, s1 ke andar 3 characters ka window
* ek-ek position se check karenge.
*/

public class P18_findFirstOccurrenceOfWordIn1stString28 {

 public static void main(String[] args) {

     String s1 = "hello";
     String s2 = "llo";

     int l1 = s1.length();
     int l2 = s2.length();

     /*
      * Agar s2 ki length s1 se badi hai,
      * toh s2 kabhi bhi s1 ke andar nahi aa sakta.
      *
      * Example:
      * s1 = "hi"       length = 2
      * s2 = "hello"    length = 5
      *
      * 5 > 2
      *
      * Therefore, answer = -1
      */
     if (l2 > l1) {
         System.out.println(-1);
         return;
     }

     /*
      * Sliding Window:
      *
      * Window ka size = l2
      *
      * Example:
      *
      * s1 = "hello"
      * s2 = "llo"
      *
      * Window 1:
      * "hel"
      *
      * Window 2:
      * "ell"
      *
      * Window 3:
      * "llo"  <-- match
      *
      *
      * i = window ka starting index
      *
      * Last possible starting index:
      *
      * l1 - l2
      *
      * 5 - 3 = 2
      *
      * Isliye:
      * i <= l1 - l2
      */
     for (int i = 0; i <= l1 - l2; i++) {

         /*
          * substring(i, i + l2)
          *
          * i = starting index
          *
          * i + l2 = ending boundary
          *
          * Example:
          *
          * i = 2
          * l2 = 3
          *
          * substring(2, 5)
          *
          * Result = "llo"
          */
         String window = s1.substring(i, i + l2);

         /*
          * Current window ko s2 ke saath compare karenge.
          *
          * Agar same hai,
          * toh i first occurrence ka index hai.
          */
         if (window.equals(s2)) {
             System.out.println("First occurrence index = " + i);
             return;
         }
     }

     /*
      * Agar loop ke andar koi matching window nahi mila,
      * toh s2, s1 ke andar present nahi hai.
      */
     System.out.println("First occurrence index = -1");
 }
}
