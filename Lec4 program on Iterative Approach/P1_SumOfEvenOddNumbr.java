// wap to calculate sum of even and odd number separately in a given array

public class P1_SumOfEvenOddNumbr {

	public static void main(String[] args) {

		int arr[] = { 5, 3, 4, 7, 6, 32, 56, 87, 45, 10, 11, 13 };

		int n = arr.length;

		int evenSum = 0, oddSum = 0;

		for (int i = 0; i < n; i++) {

			if (arr[i] % 2 == 0) {

				evenSum = evenSum + arr[i];
			} else {

				oddSum = oddSum + arr[i];
			}

		}
		System.out.println("Even sum is= " + evenSum);
		System.out.print("Odd sum is= " + oddSum);

	}

}
