// Aim:
// To find the subarray with the largest sum using Kadane's Algorithm
// and display its starting and ending index positions. its better version of 2nd problem
public class P3_FindTheLargestSubarraySumsAndTheirIndexKadanesAlgo {

	public static void main(String[] args) {
		int[] nums = {-5, -2, -8};
		int currentSum=0;
        int maxSum = Integer.MIN_VALUE;
		int start=0,end=0;
		int tempStart = 0;


		for(int i=0;i<nums.length;i++){

		    currentSum=currentSum+nums[i];
		    if(currentSum>maxSum){

		        maxSum=currentSum;
		        start = tempStart;

		        end=i;
		    }
		    if(currentSum<0){

		        currentSum=0;
		        tempStart = i + 1;  // Current sum negative ho gaya, isliye current element ko discard karke
		        					// next element se new subarray start karenge.
		    }
		}
		System.out.println("Maximum sum from the given array =>"+maxSum);

		System.out.println("Subarray index(start-end)=> "+start+" - "+end);

		System.out.print("Subarray positions: ");

		for(int i = start; i <= end; i++) {
		    System.out.print((i + 1) + " ");
		}

	}


}
