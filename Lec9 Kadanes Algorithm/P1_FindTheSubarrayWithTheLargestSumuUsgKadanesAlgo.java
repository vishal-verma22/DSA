//  Given an integer array nums, find the subarray with the largest sum, and return its sum.
//Leetcode problem no 53


/*
Kadane's Algorithm — Working

1)We initialize currentSum and maxSum as 0.
2)We traverse the array from left to right and add each element to currentSum.
3)After adding each element, we compare currentSum with maxSum and update maxSum if currentSum is greater.
4)If currentSum becomes negative, we reset it to 0 because a negative sum will reduce the sum of any future subarray.
5)We continue this process until all elements are processed.
6)Finally, maxSum contains the largest sum of a contiguous subarray.
 */
public class P1_FindTheSubarrayWithTheLargestSumuUsgKadanesAlgo {

	public static void main(String[] args) {
		int[] nums= {-2,1,-3,4,-1,2,1,-5,4};

		int currentSum=0;
		int maxSum=0;

		for (int num : nums) {

		    currentSum=currentSum+num;
		    if(currentSum>maxSum){

		        maxSum=currentSum;
		    }
		    if(currentSum<0){

		        currentSum=0;
		    }
		}
		System.out.println("maximum sum from the given array "+maxSum);

//<=================================Actual working of kedan's Algorithm ================================== >



	}

}
