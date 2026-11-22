
package Lec17_Recursion;

/*
 * ==============================================================
 * Problem Statement:
 * ==============================================================
 *
 * Write a Java program to convert a decimal number into its
 * binary representation using Recursion.
 *
 * Example:
 * Input: 8
 * Output: 1000
 *
 *
 * ==============================================================
 * Theory:
 * ==============================================================
 *
 * Decimal Number System:
 * It contains 10 digits from 0 to 9.
 *
 * Binary Number System:
 * It contains only 2 digits: 0 and 1.
 *
 * In this program, we use Recursion to convert a decimal number
 * into binary representation.
 *
 * We use two operators:
 *
 * 1. Division Operator (/ 2):
 *    It divides the number by 2.
 *
 *    Example:
 *    8 / 2 = 4
 *
 * 2. Modulus Operator (% 2):
 *    It gives the remainder after division by 2.
 *
 *    Example:
 *    8 % 2 = 0
 *
 *
 * ==============================================================
 * Main Logic:
 * ==============================================================
 *
 * 1. We pass the decimal number to decimalToBinary() method.
 *
 * 2. We check whether no == 0.
 *
 * 3. If no == 0, return and stop recursion.
 *
 * 4. Otherwise, call decimalToBinary(no / 2).
 *
 * 5. After the recursive call returns, print no % 2.
 *
 * 6. The digits are printed in correct binary order because
 *    printing happens after the recursive call.
 *
 *
 * ==============================================================
 * Recursive Formula:
 * ==============================================================
 *
 * decimalToBinary(no / 2)
 * print(no % 2)
 *
 *
 * ==============================================================
 * Base Condition:
 * ==============================================================
 *
 * if(no == 0)
 * {
 *     return;
 * }
 *
 *
 * ==============================================================
 * Working Example:
 * ==============================================================
 *
 * Input: no = 8
 *
 * Recursive Calls:
 *
 * decimalToBinary(8)
 * decimalToBinary(4)
 * decimalToBinary(2)
 * decimalToBinary(1)
 * decimalToBinary(0)
 *
 *
 * ==============================================================
 * Return Working:
 * ==============================================================
 *
 * decimalToBinary(0) = return
 *
 * decimalToBinary(1) = print 1
 * decimalToBinary(2) = print 0
 * decimalToBinary(4) = print 0
 * decimalToBinary(8) = print 0
 *
 * Final Output: 1000
 *
 *
 * ==============================================================
 * Time Complexity:
 * ==============================================================
 *
 * O(log n)
 *
 * Because the number is divided by 2 in every recursive call.
 *
 *
 * ==============================================================
 * Space Complexity:
 * ==============================================================
 *
 * O(log n)
 *
 * Because recursive calls are stored in the call stack.
 *
 *
 * ==============================================================
 */

public class P13_FindTheBinaryRerpresentionOfNumber
{
	//==============================================================
	// DecimalToBinary Method: To convert decimal number into binary using Recursion
	//==============================================================
	public static void decimalToBinary(int no)
	{
		// Base Condition
		if(no == 0)
		{
			return;
		}

		// Recursive Call
		decimalToBinary(no / 2);

		// Print Remainder
		System.out.print(no % 2);
	}

	//==============================================================
	// Main Method
	//==============================================================
	public static void main(String[] args)
	{
		int no = 8;

		decimalToBinary(no);
	}
}
