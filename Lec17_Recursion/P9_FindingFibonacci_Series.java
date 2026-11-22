
package Lec17_Recursion;

/*
 * Problem Statement:
 * Write a Java program to print Fibonacci Series using Recursion.
 *
 * Main Logic:
 * 1. For Loop calls the fibonacci() method for every index.
 * 2. Recursion calculates the Fibonacci number.
 * 3. Every next number is the sum of previous two numbers.
 *
 * Base Conditions:
 * fibonacci(0) = 0
 * fibonacci(1) = 1
 *
 * Recursive Formula:
 * fibonacci(no - 1) + fibonacci(no - 2)
 *
 * Input:  n = 6
 * Output: 0 1 1 2 3 5
 *
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)
 */

public class P9_FindingFibonacci_Series
{
	//==============================================================
	// Fibonacci Method: To calculate Fibonacci number using Recursion
	//==============================================================
	public static int fibonacci(int no)
	{
		if(no == 0)
		{
			return 0;
		}

		if(no == 1)
		{
			return 1;
		}

		return fibonacci(no - 1) + fibonacci(no - 2);
	}

	//==============================================================
	// Main Method: To print Fibonacci Series using For Loop
	//==============================================================
	public static void main(String[] args)
	{
		int n = 6;

		for(int i = 0; i < n; i++)
		{
			System.out.print(fibonacci(i) + " ");
		}
	}
}
