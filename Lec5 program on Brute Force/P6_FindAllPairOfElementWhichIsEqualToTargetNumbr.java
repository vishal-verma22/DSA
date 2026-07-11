// WAP to find all pairs of elements whose sum is equal to the target value.
// Brute Force Approach
// Time Complexity: O(n²)
// Space Complexity: O(1)

public class P6_FindAllPairOfElementWhichIsEqualToTargetNumbr {

	public static void main(String[] args) {

		int arr1[] = { 5, 4, 5, 6, 4, 4, 7, 6, 9 };

		int n = arr1.length;
		int target = 10;
		for (int i = 0; i < n; i++) {

			for (int j = i + 1; j < n; j++) {

				if (arr1[i] + arr1[j] == target) {
					System.out.println("Pair: (" + arr1[i] + ", " + arr1[j] + ")");
				}
			}
		}

	}

}
