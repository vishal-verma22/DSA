public class P6_MaximumAbsoluteSumofAnySubarray1749 {

	public static void main(String[] args) {

		int[] nums = {1, -3, 2, 3, -4};

		int maxSum = findMaxSumSubArray(nums);
		int minSum = findMinSumSubArray(nums);

		// Negative minimum sum ko positive mein convert karo
		minSum = Math.abs(minSum);

		// Dono sums mein se maximum value answer hogi
		int maxSubArray = Math.max(maxSum, minSum);

		System.out.println("Maximum Sum = " + maxSum);
		System.out.println("Minimum Sum = " + (minSum * -1));
		System.out.println("Maximum Absolute Sum = " + maxSubArray);
	}


	// Finding the maximum sum subarray
	// using Kadane's Algorithm
	public static int findMaxSumSubArray(int[] nums) {

		int currentSum = 0;
		int maxSum = Integer.MIN_VALUE;

		for (int num : nums) {

			currentSum = currentSum + num;

			if (currentSum > maxSum) {
				maxSum = currentSum;
			}

			if (currentSum < 0) {
				currentSum = 0;
			}
		}

		return maxSum;
	}


	// Finding the minimum sum subarray
	// using Reverse Kadane's Algorithm
	public static int findMinSumSubArray(int[] nums) {

		int currentSum = 0;
		int minSum = Integer.MAX_VALUE;

		for (int num : nums) {

			currentSum = currentSum + num;

			if (currentSum < minSum) {
				minSum = currentSum;
			}

			if (currentSum > 0) {
				currentSum = 0;
			}
		}

		return minSum;
	}
}