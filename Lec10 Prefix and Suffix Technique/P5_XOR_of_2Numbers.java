// XOR of 2 numbers
// Properties of XOR:
// 1. Same numbers cancel each other: a ^ a = 0
// 2. XOR with 0 gives the same number: a ^ 0 = a
// 3. XOR is commutative: a ^ b = b ^ a
// 4. XOR is associative: (a ^ b) ^ c = a ^ (b ^ c)
//
// These properties are useful for finding the unique element
// because duplicate elements cancel each other and the unique
// element remains.

// Uses of XOR:
// 1. XOR is used to find the unique element in an array
//    when every other element appears exactly twice.
//
// 2. XOR is used to find the missing number in an array.
//
// 3. XOR can be used to swap two numbers without using
//    a temporary variable.
//
// 4. XOR is used to check whether two numbers are different
//    at the bit level.
//
// 5. XOR is used in bit manipulation and various algorithms
//    where bits need to be toggled or compared
public class P5_XOR_of_2Numbers {

	public static void main(String[] args) {

		
		int a=5;
		int b=4;
		
		System.out.println("XOR of 2 number is " +(a^b));
	}

}

