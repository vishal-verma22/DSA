// find Sum of every Possible Subarrays using prefix technique

//NOTE:
//	Find sum of every subarray → har subarray ka individual sum print karo.
	//Find the sum of all subarrays → har subarray ka sum nikal kar sabko add karo → 25.
/*
 * Problem:
 * Given an integer array, find the sum of every possible subarray.
 * 

 * A subarray is a continuous part of an array.
 * Example:
 * Array:{2, 4, 1, 3}
 * Possible Subarrays:
 *
 * {2}          → 2
 * {4}          → 4
 * {1}          → 1
 * {3}          → 3
 *
 * {2, 4}       → 6
 * {4, 1}       → 5
 * {1, 3}       → 4
 *
 * {2, 4, 1}    → 7
 * {4, 1, 3}    → 8
 *
 * {2, 4, 1, 3} → 10
 * 
 */

public class P15_FindTheSumOfAllPossibleSubarray {

	public static void main(String[] args) {

			int[] array= {2, 4, 1, 3};
			int n=array.length;
			int[] prefix=new int[n];
			prefix[0]=array[0];
			
			
			// calculating the prefix sum of array
			for(int i=1;i<n;i++) {
			prefix[i]=prefix[i-1]+array[i];	
				
			}
			// prefix sub array [4,6,7,10]
		
		// for calcationg subarray and its sum	
			for(int L=0;L<n;L++) {
				for(int R=L;R<n;R++) {
					int sum=0;
					if(L==0) {
						sum=prefix[R];

					}
					else {
						
						sum=prefix[R]-prefix[L-1];

					}
					System.out.println("Sum of subarray["+array[L]+","+array[R]+"]:"+sum);

				}
				}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	}
	
}
