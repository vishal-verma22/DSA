
package Lec17_Recursion;

/*
 * ==============================================================
 * Problem Statement:
 * ==============================================================
 *
 * Write a Java program to find the sum of first N natural numbers
 * using Recursion.
 *
 * Example:
 * Input:  no = 5
 *
 * Calculation:
 * 1 + 2 + 3 + 4 + 5 = 15
 *
 * Output: 15
 *
 *
 * ==============================================================
 * Theory:
 * ==============================================================
 *
 * Recursion is a process in which a method calls itself to solve
 * a problem.
 *
 * In this program, the sum() method calls itself with no - 1
 * until the number becomes 0.
 *
 * Every recursive call waits for the next recursive call to
 * return its value.
 *
 * Once the base condition is reached, the pending calls start
 * returning their calculated values.
 *
 *
 * ==============================================================
 * Main Logic:
 * ==============================================================
 *
 * 1. We pass the number to the sum() method.
 *
 * 2. Inside the sum() method, we check the Base Condition.
 *
 * 3. If no == 0, we return 0 and stop the recursion.
 *
 * 4. If no is not 0, we add the current number with the result
 *    of sum(no - 1).
 *
 * 5. The method keeps calling itself with decreasing numbers.
 *
 * 6. When the base condition is reached, all pending recursive
 *    calls return their calculated sum.
 *
 *
 * ==============================================================
 * Recursive Formula:
 * ==============================================================
 *
 * sum(no) = no + sum(no - 1)
 *
 *
 * ==============================================================
 * Base Condition:
 * ==============================================================
 *
 * if(no == 0)
 * {
 *     return 0;
 * }
 *
 * When no becomes 0, the method returns 0.
 * This stops further recursive calls.
 *
 *
 * ==============================================================
 * Working Example:
 * ==============================================================
 *
 * Input: no = 5
 *
 * Recursive Calls:
 *
 * sum(5) = 5 + sum(4)
 * sum(4) = 4 + sum(3)
 * sum(3) = 3 + sum(2)
 * sum(2) = 2 + sum(1)
 * sum(1) = 1 + sum(0)
 * sum(0) = 0
 *
 *
 * ==============================================================
 * Return Working:
 * ==============================================================
 *
 * sum(0) = 0
 *
 * sum(1) = 1 + 0  = 1
 * sum(2) = 2 + 1  = 3
 * sum(3) = 3 + 3  = 6
 * sum(4) = 4 + 6  = 10
 * sum(5) = 5 + 10 = 15
 *
 *
 * ==============================================================
 * Diagram:
 * ==============================================================
 *
 *               sum(5)
 *             5 + sum(4)
 *                   |
 *               sum(4)
 *             4 + sum(3)
 *                   |
 *               sum(3)
 *             3 + sum(2)
 *                   |
 *               sum(2)
 *             2 + sum(1)
 *                   |
 *               sum(1)
 *             1 + sum(0)
 *                   |
 *               sum(0)
 *                 return 0
 *
 *             RETURNING BACK
 *
 *               sum(1) = 1
 *               sum(2) = 3
 *               sum(3) = 6
 *               sum(4) = 10
 *               sum(5) = 15
 *
 *
 * ==============================================================
 * Time Complexity:
 * ==============================================================
 *
 * O(n)
 *
 * Because the method is called n + 1 times, from sum(n) to sum(0).
 *
 *
 * ==============================================================
 * Space Complexity:
 * ==============================================================
 *
 * O(n)
 *
 * Because recursive calls are stored in the call stack until
 * the base condition is reached.
 *
 *
 * ==============================================================
 */

public class P10_FindTheSumOfFirstNNaturalNumber
{
	//==============================================================
	// Sum Method: To find the sum of first N natural numbers using Recursion
	//==============================================================
	public static int sum(int no)
	{
		// Base Condition
		if(no == 0)
		{
			return 0;
		}

		// Recursive Call
		return no + sum(no - 1);
	}

	//==============================================================
	// Main Method
	//==============================================================
	public static void main(String[] args)
	{
		int no = 5;

		System.out.println(sum(no));
	}
}
