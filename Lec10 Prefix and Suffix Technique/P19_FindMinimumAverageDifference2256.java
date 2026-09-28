
// Find Minimum Average Difference
// LeetCode 2256

public class P19_FindMinimumAverageDifference2256 {

    public static void main(String[] args) {

        int[] nums = {2, 5, 3, 9, 5, 3};

        int n = nums.length;

        
        long[] prefix = new long[n];

        prefix[0] = nums[0];

        // Calculate prefix sum
        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }

        // Store minimum average difference 
        long minAverage = Integer.MAX_VALUE;

        // Store index where minimum average difference found
        int minIndex = 0;

        for (int i = 0; i < n; i++) {

            long leftSum = prefix[i];

            long rightSum = prefix[n - 1] - prefix[i];

            long leftSumAverage;
            long rightSumAverage;

         // Last element par right side me koi element nahi hota,
         // isliye right side ka sum aur average dono 0 hote hain.
            if (i == n - 1) {

                rightSumAverage = 0;

            } else {

            	// n - i se current element bhi count ho jata hai,
            	// isliye current element ko remove karne ke liye -1 kiya. 
            	rightSumAverage = rightSum / (n - i - 1);
            }

           //  indexing 0 se start hoti hai, i = 2 par 3 elements hote hain 0,1,2. but index  0 se start hota hai 
			// isliye 1 element  kam count hota hai isliye 1 add kiya
                 // Isliye left side ka total count nikalne ke liye i + 1 karte hain.
            		
                 leftSumAverage = leftSum / (i + 1);
            
            // Difference between left and right averages
            long currentAverage =
                    Math.abs(leftSumAverage - rightSumAverage);

            // Update minimum difference and its index
            if (currentAverage < minAverage) {
                minAverage = currentAverage;
                minIndex = i;
            }
        }

        // Print index having minimum average difference
        System.out.println("Minimum Average Difference Index = " + minIndex);
    }
}