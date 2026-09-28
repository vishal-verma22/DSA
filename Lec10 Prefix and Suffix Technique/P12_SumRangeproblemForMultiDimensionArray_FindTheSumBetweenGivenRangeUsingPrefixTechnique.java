// Find array element sum between the given multi range sum query  for multi-dimension array 
// with multiple range are given

public class P12_SumRangeproblemForMultiDimensionArray_FindTheSumBetweenGivenRangeUsingPrefixTechnique {

	public static void main(String[] args) {

		// Array
		int[] arr = { 5, 2, 5, 7, 3, 4, 7, 5, 6 };

		// Range for calcuating sum of array for particulat interval
		int[][] queryRange = { { 1, 3 }, { 2, 5 }, { 5, 8 }, { 4, 7 } };

		// int left = 0, right = 4;
		int n = arr.length;
		int[] prefix = new int[n];
		prefix[0] = arr[0];

		// find the sum of the element in array using prefix technique
		for (int i = 1; i < n; i++) {

			prefix[i] = arr[i] + prefix[i - 1];
		}

		int sum;

		for (int i = 0; i < queryRange.length; i++) {

			// accessing the range form array
			int left = queryRange[i][0];
			int right = queryRange[i][1];

			if (left == 0) {

				sum = prefix[right];
				System.out.println("Sum " + sum);

			} else {
				sum = prefix[right] - prefix[left - 1];
				System.out.println("Sum " + sum);
			}

		}

		
	}
	

}
