// wap to calculate average of elements in a given array

public class P3_CalculateAverageOfElementInArray {

	public static void main(String[] args) {

		int arr[] = { 5, 3, 4, 7, 6, 32, 56, 87, 45, 10, 11, 13 };
		int n = arr.length;
		int sum = 0;
		double average = 0;

		for (int i = 0; i <= arr.length - 1; i++) {

			// sum=sum+arr[i];

			sum += arr[i];

		}
		average = sum / n;
		System.out.println("Sum of number = " + sum);
		System.out.println("Average of number = " + average);

	}

}
