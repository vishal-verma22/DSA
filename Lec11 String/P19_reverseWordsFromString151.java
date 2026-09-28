
//WAP to reverse the order of words in a String

/*
* Example:
*
* Input:
* "  hello   world   java  "
*
* Output:
* "java world hello"
*
*
* Steps:
*
* 1) trim()
*    -> Starting aur ending ke extra spaces remove karega.
*
* 2) split("\\s+")
*    -> String ko words mein divide karega.
*
* 3) Words ko last se first tak traverse karenge.
*
* 4) StringBuilder mein words append karenge.
*
* 5) toString().trim()
*    -> StringBuilder ko String mein convert karke
*       last mein extra space remove karenge.
*/

public class P19_reverseWordsFromString151  {

 public static void main(String[] args) {

     String s = "  hello   world   java  ";

     /*
      * String immutable hoti hai.
      *
      * trim() original String ko modify nahi karta.
      * trim() ek String return karta hai.
      *
      * Isliye returned String ko dobara s mein store kiya.
      */
     s = s.trim();

     /*
      * split("\\s+"):
      *
      * \\s  -> whitespace character
      * +    -> one or more
      *
      * Isliye multiple spaces bhi ek separator ki tarah
      * treat honge.
      *
      * Example:
      *
      * "hello   world   java"
      *
      * becomes:
      *
      * words[0] = "hello"
      * words[1] = "world"
      * words[2] = "java"
      */
     String[] words = s.split("\\s+");

     /*
      * StringBuilder use kar rahe hain kyunki
      * hume repeatedly words add karne hain.
      */
     StringBuilder sb = new StringBuilder();

     /*
      * Last word se start karenge.
      *
      * words.length = 3
      *
      * Last index = 3 - 1 = 2
      *
      * i = 2 -> "java"
      * i = 1 -> "world"
      * i = 0 -> "hello"
      */
     for (int i = words.length - 1; i >= 0; i--) {

         /*
          * Current word ke baad space add kar rahe hain.
          *
          * java
          * java world
          * java world hello
          */
         sb.append(words[i] + " ");
     }

     /*
      * sb.toString()
      * -> StringBuilder ko String mein convert karega.
      *
      * trim()
      * -> Last mein jo extra space add hua tha,
      *    usko remove karega.
      *
      * Final output:
      * "java world hello"
      */
     String result = sb.toString().trim();

     System.out.println("Original String : " + s);
     System.out.println("Reversed Words  : " + result);
 }
}
