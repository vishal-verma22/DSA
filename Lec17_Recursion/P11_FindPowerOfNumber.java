
package Lec17_Recursion;

/*
 * ==============================================================
 * Problem Statement:
 * ==============================================================
 *
 * Write a Java program to find the power of a number using Recursion.
 *
 * Example:
 * Input:
 * power = 3
 * number = 2
 *
 * Calculation:
 * 2 * 2 * 2 = 8
 *
 * Output: 8
 *
 *
 * ==============================================================
 * Theory:
 * ==============================================================
 *
 * Power means multiplying a number by itself a specified number
 * of times.
 *
 * In this program, we use Recursion to calculate the power.
 *
 * The findPower() method calls itself by decreasing the power
 * by 1 in every recursive call.
 *
 * When power becomes 0, the method returns 1 and stops recursion.
 *
 *
 * ==============================================================
 * Main Logic:
 * ==============================================================
 *
 * 1. We pass power and number to the findPower() method.
 *
 * 2. We check whether power == 0.
 *
 * 3. If power == 0, return 1.
 *
 * 4. Otherwise, multiply number with findPower(power - 1, number).
 *
 * 5. The recursive calls continue until power becomes 0.
 *
 * 6. After reaching the base condition, all pending calls return
 *    their calculated values.
 *
 *
 * ==============================================================
 * Recursive Formula:
 * ==============================================================
 *
 * findPower(power, number) =
 * number * findPower(power - 1, number)
 *
 *
 * ==============================================================
 * Base Condition:
 * ==============================================================
 *
 * if(power == 0)
 * {
 *     return 1;
 * }
 *
 *
 * ==============================================================
 * Working Example:
 * ==============================================================
 *
 * Input:
 * power = 3
 * number = 2
 *
 * Recursive Calls:
 *
 * findPower(3, 2) = 2 * findPower(2, 2)
 * findPower(2, 2) = 2 * findPower(1, 2)
 * findPower(1, 2) = 2 * findPower(0, 2)
 * findPower(0, 2) = 1
 *
 *
 * ==============================================================
 * Return Working:
 * ==============================================================
 *
 * findPower(0, 2) = 1
 * findPower(1, 2) = 2 * 1 = 2
 * findPower(2, 2) = 2 * 2 = 4
 * findPower(3, 2) = 2 * 4 = 8
 *
 *
 * ==============================================================
 * Time Complexity:
 * ==============================================================
 *
 * O(power)
 *
 * Because the method is called power + 1 times.
 *
 *
 * ==============================================================
 * Space Complexity:
 * ==============================================================
 *
 * O(power)
 *
 * Because recursive calls are stored in the call stack.
 *
 *
 * ==============================================================
 */

public class P11_FindPowerOfNumber
{
	//==============================================================
	// FindPower Method: To calculate the power of a number using Recursion
	//==============================================================
	public static int findPower(int power, int number)
	{
		// Base Condition
		if(power == 0)
		{
			return 1;
		}

		// Recursive Call
		return number * findPower(power - 1, number);
	}

	//==============================================================
	// Main Method
	//==============================================================
	public static void main(String[] args)
	{
		System.out.println(findPower(3, 2));
	}
}
