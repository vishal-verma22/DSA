// wap to reverse  element between two given indices

public class P15_ReverseTheElementBetwnTwoGivenIndices {

	public static void main(String[] args) {

		

		int arr1[] = { 5, 6, 7, 45 ,5,4,67};

		int n = arr1.length;

		int start = 2, end = 5;
		while (start < end) {
			int temp = arr1[start];
			arr1[start] = arr1[end];
			arr1[end] = temp;
			start++;
			end--;

		}
		for (int no : arr1) {

			System.out.print(no + " ");
		}
			
		}
	}


