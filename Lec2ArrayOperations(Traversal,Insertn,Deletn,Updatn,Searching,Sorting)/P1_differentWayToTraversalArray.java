// traversing the array elements  


public class P1_differentWayToTraversalArray {

	public static void main(String args[]) {

		int[] arr = { 10, 20, 30, 40, 50 };

		// Way -1 for Traversing Array using For Loop

		for (int i = 0; i < arr.length; i++) {

			System.out.println("Element At Index Position " + i + " is " + arr[i]);

		}

		System.out.println();

		// Way -2 for Traversing Array using Foreach Loop

		/*
		 * 
		 * Syntax
		 * 
		 * for(dataType of array variable : arrayName) { // code }
		 */

		for (int no : arr) {

			System.out.println(no);

		}

		System.out.println("-------------------");

		// Traversing Array in Reverse Order

		for (int i = arr.length - 1; i >= 0; i--) {

			System.out.println("Element At Index Position " + i + " is " + arr[i]);

		}

	}

}
