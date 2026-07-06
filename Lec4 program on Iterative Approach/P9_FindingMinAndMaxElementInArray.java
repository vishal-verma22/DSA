// wap to find the greatest and smallest number in an array

public class P9_FindingMinAndMaxElementInArray {

	public static void main(String[] args) {

		int arr1[] = { 5, 57, 5, 3 };

		int n = arr1.length;

		int max = arr1[0];
		int min = arr1[0];

		for (int i = 0; i < n; i++) {

			if (arr1[i] > max) {
				max = arr1[i];
			}

			if (arr1[i] < min) {
				min = arr1[i];

			}
		}

		System.out.println("Greatest Element in array = " + max);
		System.out.println("Smallest Element in array = " + min);

	}

}
