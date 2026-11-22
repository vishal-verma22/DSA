package Lec17_Recursion;

public class P12_FindSumOfAllDigitOfGivenPositiveInteger {
	
	public static int sum(int no)
	{
		// Base Condition
		if(no == 0)
		{
			return 0;
		}

		// Recursive Call
		return no%10+ sum(no/10);
	}

	//==============================================================
	// Main Method
	//==============================================================
	public static void main(String[] args)
	
	{int no=4821;
		System.out.println(sum(no));
	}

}
