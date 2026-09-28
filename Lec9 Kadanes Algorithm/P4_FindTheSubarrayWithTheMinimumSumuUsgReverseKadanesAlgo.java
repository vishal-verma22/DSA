// To find the subarray having the minimum sum from a given integer array
// using Reverse Kadane's Algorithm.


/*
Reverse Kadane's Algorithm — Working

1)We initialize currentSum as 0 and minSum as Integer.MAX_VALUE.
2)We traverse the array from left to right and add each element to currentSum.
3)After adding each element, we compare currentSum with minSum and update minSum if currentSum is smaller.
4)If currentSum becomes positive, we reset it to 0 because a positive sum will increase the sum of any future subarray.
5)We continue this process until all elements of the array are processed.
6)Finally, minSum contains the minimum sum of a contiguous subarray.

 */
public class P4_FindTheSubarrayWithTheMinimumSumuUsgReverseKadanesAlgo {

	public static void main(String[] args) {


		int[] nums= {-2,1,-3,4,-1,2,1,-5,4};

		int currentSum=0;
		int minSum=Integer.MAX_VALUE;

		for (int num : nums) {

		    currentSum=currentSum+num;
		    if(currentSum<minSum){

		    	minSum=currentSum;
		    }
		    if(currentSum>0){

		        currentSum=0;
		    }
		}
		System.out.println("minimum sum from the given array usg Reverae Kednes Algo"+minSum);


	}

}
