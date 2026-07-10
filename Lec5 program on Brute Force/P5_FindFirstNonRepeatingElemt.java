// wap to find the First non-repeating Element in given array

public class P5_FindFirstNonRepeatingElemt {

	public static void main(String[] args) {

		// int arr1[] = { 2, 14, 2, 5, 14, 2, 12,14,25 };
		int arr1[] = { 2, 3, 2, 3 };

		int n = arr1.length;
		boolean temp[] = new boolean[n];
		boolean found = false;

		for (int i = 0; i < n; i++) {
			int count = 1;
			if (temp[i] == true) {

				continue;
			}
			for (int j = i + 1; j < n; j++) {

				if (arr1[i] == arr1[j]) {
					count++;
					temp[j] = true;

				}
			}

			if (count == 1) {
				found = true;  
				System.out.println("First Non Repeating Elemnt " + arr1[i] + " frequency ==> " + count);
				break; // Stop after finding the first non-repeating element. }
			}

		}
		if (found == false) {     // if non repeating element not exist

			System.out.println(" Non Repeating Elemnt not found");

		}

	}

}
