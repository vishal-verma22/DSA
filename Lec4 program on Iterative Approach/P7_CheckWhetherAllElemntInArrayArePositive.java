// wap to check whether all the  Elements in a array are positive

public class P7_CheckWhetherAllElemntInArrayArePositive {

	public static void main(String[] args) {
		int arr1[] = { 5, 3, 4, 7, -6, 32, -56, 87, -45, 10, -11, 13 };
		 //int arr1[]= {5,57,5,3};
		
		int n = arr1.length;
		boolean isPositive = true;
		for (int i = 0; i < n; i++) {

			if (arr1[i] < 0) {
				isPositive = false;
				break;

			}
		}
		if (isPositive) {

			System.out.println("All elements in array are positive");
		} else {

			System.out.println(" Some elements in array are Negative");

		}
	}

}
