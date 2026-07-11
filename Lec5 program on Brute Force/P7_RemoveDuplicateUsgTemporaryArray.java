// wap to remove duplicate from given array using temporary array

public class P7_RemoveDuplicateUsgTemporaryArray {

	public static void main(String[] args) {

		int arr1[] = { 5, 4, 5, 6, 4, 4, 7, 6, 9 };

		int n = arr1.length;
		int temp[] = new int[n];
		int index = 0;
		for (int i = 0; i < n; i++) {
			boolean found = false;
			for (int j = 0; j < i; j++) {

				if (arr1[i] == temp[j]) {

					found = true;
					break;
				}

			}
			/*
			 * Also do like this if we not want to use if-else both if 
			 * (!found) {
			 * temp[index] = arr1[i]; 
			 * index++;
			 * 
			 * }
			 * 
			 */
			if (found) {
				continue;
			} else {

				temp[index] = arr1[i];
				index++;
			}
		}

		for (int no : temp) {

			System.out.print(no + " ");

		}

	}

}
