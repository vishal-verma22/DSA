// wap to count positive,negative and zero element in a given array

public class P2_CountPositiveNegativeZeroElemtInArray {

	public static void main(String[] args) {

		int arr[] = { 5, 3, -5, 0, 8, -7, 0, 4 - 2, 0 - 69 };
		int positiveCount = 0, negativeCount = 0, zeroCount = 0;

		for (int i = 0; i <= arr.length - 1; i++) {

			if (arr[i] == 0) {

				zeroCount++;
			} else if (arr[i] < 0) {
				negativeCount++;
			} else {
				positiveCount++;
			}
		}

		System.out.println("Positive Count = " + positiveCount);
		System.out.println("Negative Count = " + negativeCount);
		System.out.println("Zero Count = " + zeroCount);

	}

}
