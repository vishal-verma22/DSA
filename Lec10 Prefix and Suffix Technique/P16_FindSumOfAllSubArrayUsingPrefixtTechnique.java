/*
 * Problem:
 * Given an integer array, find the sum of all possible subarrays.
 *
 * A subarray is a continuous part of an array.
 *
 * Example:
 * Array: {2, 4, 1}
 *
 * Possible Subarrays:
 * {2}       -> 2
 * {4}       -> 4
 * {1}       -> 1
 * {2,4}     -> 6
 * {4,1}     -> 5
 * {2,4,1}   -> 7
 *
 * Sum of all subarrays:
 * 2 + 4 + 1 + 6 + 5 + 7 = 25
 *
 * Approach:
 * First, create a prefix sum array.
 * Then, use L and R to generate every possible subarray
 * and calculate its sum using the prefix sum array.
 */
public class P16_FindSumOfAllSubArrayUsingPrefixtTechnique {

	public static void main(String[] args) {

			int[] array= {2, 4, 1};
			
			int n=array.length;
			int[] prefix=new int[n];
			prefix[0]=array[0];
			
			
			// calculating the prefix sum of array
			for(int i=1;i<n;i++) {
			prefix[i]=prefix[i-1]+array[i];	
				
			}
			
			// prefix sub array [4,6,7,10]
			
			// for calcationg subarray and its sum	
			int totalSum=0;
				for(int L=0;L<n;L++) {

					for(int R=L;R<n;R++) {
						if(L==0) {
							totalSum+=prefix[R];

						}
						else {
							
							totalSum+=prefix[R]-prefix[L-1];

						}

					}
				}
				System.out.println("Sum of All Subarray "+totalSum);

	}

}
