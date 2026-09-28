// wap to print the Duplicate character from given string
// This logic work when we have single -single Duplicate character occurrence
// if we have multiple duplicate character occurrence then it will print same duplicate multiple time
// NOTE


/*
 * == vs .equals()
 *
 * 1. == operator:
 *    - Primitive data types ki value compare karta hai.
 *    - Example: int, char, double, float, boolean
 *
 *    char a = 'A';
 *    char b = 'A';
 *    a == b;          // true
 *
 * 2. .equals() method:
 *    - Objects/String ka content compare karne ke liye use hota hai.
 *
 *    String a = "Hello";
 *    String b = "Hello";
 *    a.equals(b);     // true
 *
 * IMPORTANT:
 *    Primitive  -> ==
 *    String/Object -> .equals()
 *
 * 3. charAt() ke case mein:
 *
 *    original.charAt(i) == original.charAt(k)
 *
 *    charAt() ek 'char' return karta hai,
 *    isliye yaha == use karte hain, .equals() nahi.
 *
 *    charAt() -> char -> ==
 */
public class P5_PrintDuplicateCharacterFromString {

	public static void main(String[] args) {
		String orginal = "vishal veirmai";
		int n=orginal.length();

		System.out.println(n);

		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {

				if(orginal.charAt(i)==orginal.charAt(j)) {

					System.out.println("Duplicate Character "+orginal.charAt(i));
					break;
				}

			}
		}

	}

}
