//wap to reverse the array in place i.e reverse the array without using another array
// 1) for-loop   2) while loop

public class P14_ReverseTheArrayInPlaceWithoutUsgAnotherArray {

	public static void main(String[] args) {
		System.out.println("Using While Loop");

		UsgWhileLoop.main();
		System.out.println("\n");

		System.out.println("Using for Loop");

		int arr1[] = { 5, 6, 7, 45 };

		int n = arr1.length;

		// reversing the array elements
		for (int i = 0; i < n / 2; i++) {
			int temp = arr1[i];
			arr1[i] = arr1[n - 1 - i];
			arr1[n - 1 - i] = temp;

		}

		for (int no : arr1) {

			System.out.print(no + " ");
		}
	}

}

// 2) while loop

class UsgWhileLoop {

	public static void main() {

		int arr1[] = { 5, 6, 7, 45 };

		int n = arr1.length;

		int start = 0, end = n - 1;
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
