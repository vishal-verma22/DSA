// wap to swap two elements in a given array with specified position

import java.util.Scanner;

public class P5_SwapTwoElementInArrayAtSpecificedPosition {

	public static void main(String[] args) {

		int arr1[] = { 5, 3, 4, 7, 6, 32, 56, 87, 45, 10, 11, 13 };
		int n = arr1.length;

		System.out.print("Array before swapping\n");

		for (int no : arr1) {

			System.out.print(no + " ");
		}
		System.out.print("\n");

		Scanner sc = new Scanner(System.in);

		int index1 = sc.nextInt();
		int index2 = sc.nextInt();

		
		int temp = arr1[index1];
		arr1[index1] = arr1[index2];
		arr1[index2] = temp;

		System.out.print("Array After swapping\n");

		for (int no : arr1) {

			System.out.print(no + " ");
		}

	}

}
