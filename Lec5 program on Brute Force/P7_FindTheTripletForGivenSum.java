// WAP to find all triplets whose sum is equal to the given target.
// Brute Force Approach
// Time Complexity: O(n³)
// Space Complexity: O(1)

public class P7_FindTheTripletForGivenSum {

	public static void main(String[] args) {

		 int arr1[] = { 5, 2, 3, 6, 2, 3, 1, 4, 9 };
		//int arr1[] = { 5, 6, 2, 8, 9 };

		int n = arr1.length;
		int target = 10;
		boolean found = false;
		for (int i = 0; i < n; i++) {

			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {

					if (arr1[i] + arr1[j] + arr1[k] == target) {
						System.out.println("Triplet: (" + arr1[i] + ", " + arr1[j] + ", " + arr1[k] + ")");
						found = true;
					}
				}
			}

		}
		if (!found) {

			System.out.println("triplet not exist");
		}

	}
}
