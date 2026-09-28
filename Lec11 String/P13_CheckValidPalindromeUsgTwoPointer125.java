/*
 * Problem Statement:
 *Leetcode:125 
 *using Two Pointer Approach
 * Given a string s, check whether it is a palindrome.
 *
 * While checking:
  	1) Ignore spaces and special characters.
	2) Consider only letters and digits.

Example:
 * Input: "A man, a plan, a canal: Panama"
 *
 * Output: true
 *
 *
 * Input: "race a car"
 *
 * Output: false
 *
 *
 * Approach:
 *
 * Use two pointers:
 *
 * left  -> starts from beginning
 * right -> starts from end
 *
 * Skip special characters from both sides.
 * Compare the characters.
 *
 * If characters are different:
 * return false.
 *
 * If characters are same:
 * left++ and right--.
 *
 * If all characters match:
 * return true.
 * 
 */public class P13_CheckValidPalindromeUsgTwoPointer125
{
    public static void main(String[] args)
    {
        String s = "A man, a plan, a canal: Panama";


        int left = 0;
        int right = s.length() - 1;


        // Jab tak left aur right ek-dusre ko cross nahi karte,
        // tab tak characters ko compare karenge.
        while(left < right)
        {
            // LEFT SIDE:
            // Agar left par space, comma, colon, special character etc. hai,
            // toh us character ko skip karenge.
            //
            // left < right:
            // Ye ensure karta hai ki left pointer right ko cross na kare.
            //
            // Agar inner while me "left < right" condition nahi lagayenge,
            // toh agar remaining string me special characters hon,
            // left++ hota rahega aur string ki boundary cross kar dega.
            //
            // Example:
            // s = "!!!!"
            //
            // left = 0 -> '!' -> left++
            // left = 1 -> '!' -> left++
            // left = 2 -> '!' -> left++
            // left = 3 -> '!' -> left++
            // left = 4 -> s.charAt(4) -> ERROR
            //
            // Isliye "left < right" boundary/safety condition hai.

            while(left < right &&
                  !Character.isLetterOrDigit(s.charAt(left)))
            {
                left++;
            }


            // RIGHT SIDE:
            // Agar right par space, comma, colon, special character etc. hai,
            // toh right-- karke us character ko skip karenge.
            //
            // left < right:
            // Ye ensure karta hai ki right pointer left ko cross na kare.
            //
            // Agar ye condition nahi lagayenge,
            // toh right valid index se bahar ja sakta hai.
            //
            // Example:
            // s = "!!!!"
            //
            // right = 3 -> '!' -> right--
            // right = 2 -> '!' -> right--
            // right = 1 -> '!' -> right--
            // right = 0 -> '!' -> right--
            // right = -1 -> s.charAt(-1) -> ERROR
            //
            // Isliye yahan bhi "left < right" boundary/safety condition hai.

            while(left < right &&
                  !Character.isLetterOrDigit(s.charAt(right)))
            {
                right--;
            }


            // Ab left aur right par valid letter/digit mil gaya hai.
            //
            // Character.toLowerCase():
            // Capital aur small letters ko same treat karne ke liye.
            //
            // Example:
            // 'A' -> 'a'
            // 'a' -> 'a'
            //
            // Agar dono characters different hain,
            // toh string palindrome nahi hai.

            if(Character.toLowerCase(s.charAt(left)) !=
               Character.toLowerCase(s.charAt(right)))
            {
                System.out.println("Not a Palindrome");
                return;
            }


            // Agar dono characters same hain,
            // toh next pair ko check karne ke liye
            // dono pointers ko andar move karo.

            left++;
            right--;
        }


        // Agar poori string check ho gayi
        // aur koi mismatch nahi mila,
        // toh string palindrome hai.

        System.out.println("Palindrome");

//========================Another way using for loop 
		
		
	
	/*  char[] splitArray=s.toCharArray();
	
	
	
		for(char sw:splitArray) {
			
			System.out.print(sw);
		}
		
		/*String reverse="" ;
		
		
		for(int i=splitArray.length-1;i>=0;i--) {
			
			if(Character.isLetterOrDigit(splitArray[i])) {
				
				reverse=reverse+Character.toLowerCase(splitArray[i]);
			}
		}
		
		System.out.print(reverse);
		
		*/
		
	}

}
