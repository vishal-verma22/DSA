/*
 *  Kadane's Algorithm - Working:
 *
 * 1) Array ko left se right traverse karte hain aur har element ko
 *    currentSum mein add karte hain.
 *
 * 2)Kadane's  Har element par decide karte hain ki current subarray ko
 *    continue karna hai ya current element se ek naya subarray
 *    start karna hai.
 *
 *	   ==>Agar currentSum + nums[i] bada hai, to previous subarray
 *        ko continue karna beneficial hai( currentSum = Math.max(currentSum, nums[i]).
 *	   ==> Agar nums[i] khud bada hai, to previous subarray ko discard
 *         karke current element se naya subarray start karna beneficial hai.
 *
 * 3) Har step par currentSum ko maxSum se compare karte hain.
 *    Agar currentSum, maxSum se bada hai, to maxSum update karte hain.
 *
 * 4) Ye process poore array ke liye repeat hota hai.
 *
 * 5) Finally, maxSum mein maximum sum wale contiguous subarray
 *    ka sum milta hai.
 *
 * Example:
 * Array = {-2, 1, -3, 4, -1, 2, 1, -5, 4}
 *
 * Maximum Sum Subarray = {4, -1, 2, 1}
 * Maximum Sum = 6
 */
public class P5_FindTheSubarrayWithTheLargestSumuUsgKadanesAlgo {

public static void main(String[] args) {


int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

int currentSum = 0;
int maxSum = Integer.MIN_VALUE;

for (int num : nums) {

    // Current element ko current subarray ke sum mein add karte hain.
    currentSum = currentSum + num;

    // Decide karte hain: existing subarray ko continue karein
    // ya current element se naya subarray start karein.
    currentSum = Math.max(currentSum, num);

    // Ab tak ka maximum subarray sum update karte hain.
    maxSum = Math.max(maxSum, currentSum);
}

System.out.println("Maximum sum: " + maxSum);

}
}



