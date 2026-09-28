// Find the maximum sum of a circular subarray from a given integer array. leetcode 918
public class P7_FindMaximumSumCircularSubarray918 {




	public static void main(String[] args) {

		int[] nums = {5, -3, 5};

		// Find maximum sum of normal/linear subarray
		int maxSumValue = MaxSubArraySumOFLinearArray(nums);

		// Find minimum sum of normal/linear subarray
		int minSumValue = MinxSubArraySumOFLinearArray(nums);

		// Find total sum of  normal/linear complete array
		int totalSumValues = TotalSumOfArray(nums);

		// Circular subarray sum = Total sum - Minimum subarray sum
		int maxSumOfCircularSubArray = totalSumValues - minSumValue;

		// Agar circular sum 0 aata hai,
		// iska matlab array ke saare elements negative hain.
		// Aise case mein empty subarray consider nahi karna hai,
		// isliye maximum linear subarray sum ko answer maanenge.
		if (maxSumOfCircularSubArray == 0) {

			maxSumOfCircularSubArray = maxSumValue;
		}

		// Linear maximum sum aur circular maximum sum mein se jo bada hai wahi final answer hoga.
		int maxSubArraySum = Math.max(maxSumValue, maxSumOfCircularSubArray);

		System.out.println("Maximum Circular Subarray Sum = " + maxSubArraySum);
	}


	// Calculating the total sum of the array
	public static int TotalSumOfArray(int nums[]) {

		int totalSum = 0;

		for (int num : nums) {

			totalSum += num;
		}

		return totalSum;
	}


	// Calculating the maximum subarray sum
	// using Kadane's Algorithm
	public static int MaxSubArraySumOFLinearArray(int nums[]) {

		int currentSum = 0;

		// MIN_VALUE isliye use kiya hai taaki
		// all-negative array mein bhi maximum element find ho sake.
		int maxSum = Integer.MIN_VALUE;

		for (int num : nums) {

			currentSum += num;


			if (currentSum > maxSum) {

				maxSum = currentSum;
			}


			if (currentSum < 0) {

				currentSum = 0;
			}
		}

		return maxSum;
	}


	// Find minimum sum subarray using Reverse Kadane's Algorithm
	public static int MinxSubArraySumOFLinearArray(int nums[]) {

		int currentSum = 0;

		// MAX_VALUE se start kiya hai taaki
		// minimum sum correctly find ho sake.
		int minSum = Integer.MAX_VALUE;

		for (int num : nums) {

			currentSum += num;


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
