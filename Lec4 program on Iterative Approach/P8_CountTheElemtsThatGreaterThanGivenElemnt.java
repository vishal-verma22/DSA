// wap to count the elements in array that is greater than given elements

import java.util.Scanner;
import java.util.ArrayList;

public class P8_CountTheElemtsThatGreaterThanGivenElemnt {

	public static void main(String[] args) {

		// int arr1[] = { 5, 3, 4, 7, -6, 32, -56, 87, -45, 10, -11, 13 };
		int arr1[] = { 5, 57, 5, 3 };

		int n = arr1.length;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Element");
		float number = sc.nextInt();

		ArrayList<Integer> arr2 = new ArrayList<>();   // for storing elemnts that is greater than given elements

		int count = 0;
		for (int i = 0; i < n; i++) {

			if (arr1[i] > number) {
				count++;
				arr2.add(arr1[i]);
			}
		}

		if(count!=0) {
			
		
		System.out.println("numner of element that is greater than " + number + " is--> " + count);
		System.out.println("Elements that are greater than " + number + " are--> ");

		for (int no : arr2) {

			System.out.print(no + " ");
		}
		
		}
		
		else {
			
			System.out.println("no element is greater than " + number );

		}

	}

}
