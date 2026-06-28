// Creating Array by taking value from user 

import java.util.Scanner;
import java.util.Arrays;

public class P2_ArrayInputFromUser {

	public static void main(String srgs[]) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter array size");

		int size = sc.nextInt();

		int arr[] = new int[size];

		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter array element at index 4"
					+ ""+i);
			arr[i] = sc.nextInt();

		}
		
		System.out.println(Arrays.toString(arr));
	}

}
