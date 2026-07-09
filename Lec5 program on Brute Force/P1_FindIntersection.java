// Find the intersection of 2 array

public class P1_FindIntersection {

	public static void main(String[] args) {

		int arr1[] = { 52, 23, 14, 12 };
		int arr2[] = { 2, 14, 12 };

		int n1 = arr1.length;
		int n2 = arr2.length;

		for (int i = 0; i < n1; i++) {

			for (int j = 0; j < n2; j++) {

				if (arr1[i] == arr2[j]) {

					System.out.println(arr1[i]);
				}

			}

		}

	}

}
