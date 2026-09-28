// Wap to find the longest continuous days where the total profit remain positive


// CORRECT SOLUTION IS NOT POSSBILE BY SLIDNGIG WINDOW
public class P6_FindTheLongestContinuousDaysWhereTheTotalProfitRemainPositive {

	public static void main(String[] args) {
		
		
		
	/*	
Array ka har ek element = 1 day ka profit/loss represent karta hai.
				
Example:

			-5 → Day 1: ₹5 loss
			10 → Day 2: ₹10 profit
			-2 → Day 3: ₹2 loss
			15 → Day 4: ₹15 profit
			-3 → Day 5: ₹3 loss
So hume sabse lamba continuous days ka sequence find karna hai jiska total sum positive ho.
					
					*/
		int[] profit = {-5, 10, -2, 15, -3, 8, 12, -20, 5, 10};
        int length = profit.length;

        int longestMaximumDay = Integer.MAX_VALUE;
        int currentDay;

        int Left = 0;
        int Right;

        int totalProfit  = 0;

        for (Right = 0; Right < length; Right++) {

        	totalProfit  = totalProfit  + profit[Right];

            while (totalProfit  >= 50) {

            	currentDay = Right - Left + 1;

                longestMaximumDay = Math.min(currentDay, longestMaximumDay);

                totalProfit  = totalProfit  - profit[Left];
            }
        }

        System.out.println(longestMaximumDay);

	}

}
