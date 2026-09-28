// calculating the prefix array of 2d array using if conditions 
//In next program we will se how to do same program by adding 
//one extra  row and one extra  columns in in prefix array so we dont need to use if conditions  and that is also efficient.
/*NOTE
  	while calculating the prefix Array Sum of 2D Array always use these technique 
  	like adding one extra row and one extra columns s and rows dont use these technique in 1D array
 */
/*
 * Topic: 2D Prefix Sum Matrix
 *
 * Problem:
 * Given a 2D array, create a Prefix Sum Matrix where
 * prefix[i][j] stores the sum of all elements from
 * (0,0) to (i,j) in the prefix matrix.
 *
 * Example:
 *
 * Original Matrix:        Prefix Sum Matrix:
 *
 * 10  4  8                10  14  22
 *  1  6  2                11  21  31
 *
 * Formula:
		Current Element + Top Prefix + Left Prefix - Diagonal Prefix

* 1. Add the current element:
* 			 prefix[i][j] = originalArray[i][j];
* 
*2. Add the TOP prefix:
*		 if(i > 0) 
*			prefix[i][j] = prefix[i][j] + prefix[i - 1][j];
*
*3. Add the LEFT prefix:
*		if(j > 0) 
*			prefix[i][j] = prefix[i][j] + prefix[i][j - 1]; 
*
*4. Subtract the DIAGONAL prefix:
*
*if(i > 0 && j > 0) 
*		prefix[i][j] = prefix[i][j] - prefix[i - 1][j - 1]; 
*
*Why do we subtract the diagonal prefix? 
*		The diagonal prefix(element) is already included in both: 
*			1. Top prefix 
*			2. Left prefix 
*		    Therefore, the diagonal element gets counted TWO TIMES. 
*		    So, we subtract it ONCE to remove the duplicate counting. 
*
 These same 3 formula use in one extra row and one extra columns technique
 * Main Goal:
 * Create the Prefix Sum Matrix so that later we can
 * calculate the sum of any rectangular range efficiently.
 */
public class P13_FindPrefixSumArrayOf2DArrayByIfCodnUsgPrefixSum {

	public static void main(String args[]) {

		int[][] originalArray = {

				{ 2, 4, 1, 3 }, { 5, 6, 2, 4 }, { 1, 3, 7, 2 }, { 4, 2, 5, 6 }

		};

		int rows = originalArray.length;
		int cols = originalArray[0].length;
		int[][] prefix = new int[rows][cols];

		// for accesing the element and adding elements in prefix array
		System.out.println("Prefix Arrays");

		for (int i = 0; i < rows; i++) {  			// for row
			for (int j = 0; j < cols; j++) {  // for columns
				
				// Adding the value from the original array to the prefix array
				// as the current element
				prefix[i][j] = originalArray[i][j];  

				
				if (i > 0) {
					// for getting top prefix(element) of prefix array and
					//adding that top prefix in current element of prefix array 
					//of that particular position
					prefix[i][j] = prefix[i][j] + prefix[i - 1][j];
				}

				if (j > 0) {
					
					// for getting left prefix of prefix array and
					//adding that top prefix in current element of prefix array 
					//of that particular position
					prefix[i][j] = prefix[i][j] + prefix[i][j - 1];

				}

				if (i > 0 && j > 0) {
					// for getting diagonal prefix of prefix array and
					
					 /* Subtraction is necessary because the diagonal elements
				       are already included in both the top and left prefixes.
				       So, they are counted two times.
				      Therefore, we subtract the diagonal prefix once. 
				    */
					
					prefix[i][j] = prefix[i][j] - prefix[i - 1][j - 1];

				}

			}

		}

		// Seeing the prefix matrix
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {

				System.out.print(prefix[i][j] + " ");
			}

			System.out.println();

		}

	}

}
