//  Given an integer array nums, find the subarray with the largest sum, and return its sum
//and also finding the subarrays index position(i.e start aur end kaha se ho rha hai subarray).



public class P2_FindTheLargestSubarraySumsAndTheirIndexKadanesAlgo {

	public static void main(String[] args) {
		int[] nums= {-2,1,-3,4,-1,2,1,-5,4};

		int currentSum=0;
		int maxSum=0;
		int start=0,end=0;

		for(int i=0;i<nums.length;i++){

		    currentSum=currentSum+nums[i];
		    if(currentSum>maxSum){

		        maxSum=currentSum;
		        end=i;
		    }
		    if(currentSum<0){

		        currentSum=0;
		        start = i + 1;  // Current sum negative ho gaya, isliye current element ko discard karke
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
