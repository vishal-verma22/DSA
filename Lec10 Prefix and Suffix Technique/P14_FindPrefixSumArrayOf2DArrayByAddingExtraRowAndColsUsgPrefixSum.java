// Finding the Prefix Sum Array of a 2D Array by adding an extra row and extra column.

// Finding the Prefix Sum Array of a 2D Array by adding
// one extra row and one extra column in the prefix array.
//
// In this technique, we create the prefix array with
// rows + 1 and cols + 1 size.
//
// Example:
// Original array = 4 x 4
// Prefix array   = 5 x 5
//
// The first row and first column of the prefix array
// are initialized with 0.
//
// By adding one extra row and one extra column,
// we do not need to use if conditions like:
//     if(i > 0)
//     if(j > 0)
//     if(i > 0 && j > 0)
//
// Formula:
//		Current Element + Top Prefix + Left Prefix - Diagonal Prefix

// prefix[i][j] = originalArray[i-1][j-1]  --> Adding Current Element
//              + prefix[i-1][j] 		  --> Adding Top Prefix 
//              + prefix[i][j-1] 		  --> Adding Left Prefix
//              - prefix[i-1][j-1]   	   --> Subtracting Diagonal Prefix
// Important:
// The original array index is shifted by 1 because
// the prefix array has one extra row and one extra column.
//
// Example:
//
// Original Array:        Prefix Array:
//
// 2   4   1   3         0   0   0   0   0   -->extra row
// 5   6   2   4         0   2   6   7  10
// 1   3   7   2         0   7  17  20  27
// 4   2   5   6         0   8  21  31  40
//                       0  12  27  42  57


public class P14_FindPrefixSumArrayOf2DArrayByAddingExtraRowAndColsUsgPrefixSum {

	public static void main(String[] args) {

		
		int[][] originalArray = {

				{ 2, 4, 1, 3 }, { 5, 6, 2, 4 }, { 1, 3, 7, 2 }, { 4, 2, 5, 6 }

		};

		int rows = originalArray.length;
		int cols = originalArray[0].length;
		int[][] prefix = new int[rows+1][cols+1];

		// for accesing the element and adding elements in prefix array
		System.out.println("Prefix Arrays");

		for (int i = 1; i <= rows; i++) {  		// Starting from 1 because 1st row and columns 000 hai
			for (int j = 1; j <= cols; j++) {  // for columns
				
				prefix[i][j]=originalArray[i-1][j-1]+   
						/* While accessing the current element from the original array,
						 we subtract 1 from both i and j because we added one extra
						 row and one extra column to the prefix array.
						 Therefore, the indexes of the original array and prefix array
						 are shifted by 1.	
						 Example:
						 	prefix[1][1] → originalArray[0][0]
						 	prefix[1][2] → originalArray[0][1]
						 	prefix[2][1] → originalArray[1][0]
						 */
						
						prefix[i-1][j]+      // Top prefix
						prefix[i][j-1]-     // Left prefix
						prefix[i-1][j-1];  // Remove double-counted diagonal elements
						


						
			}
				
	}

		// Seeing the prefix matrix
		for (int i = 0; i <= rows; i++) {
			for (int j = 0; j <= cols; j++) {

				System.out.print(prefix[i][j] + " ");
			}

			System.out.println();

		}

	}

}