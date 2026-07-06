
// Deleting Array Element by giving Array value 
public class P6_DeletngElemtBasdOnValueNotOnIndexBased {

	public static void main(String[] args) {

		int[] arr = { 5, 7, 6, 12, 22, 55 };

		// Element to delete

		int element = 6;

		int flag = -1;

		// Checking Element Present or Not

		for (int i = 0; i < arr.length; i++) {

			if (element == arr[i]) {
				flag = i;

			}
		}

		if (flag == -1) {

			System.out.println("Element " + element + " not found");

		} else {

			System.out.println("Element " + element + " found at " + flag + " index Position");

		}

		// Deleting the element after getting Element index position
		if (flag >= 0) {
			for (int i = flag; i < arr.length - 1; i++) {
				arr[i] = arr[i + 1];
				

			}

			arr[arr.length-1]=0;
			// traversing
			for (int no : arr) {

				System.out.println(no);
			}
		}
	}

}
