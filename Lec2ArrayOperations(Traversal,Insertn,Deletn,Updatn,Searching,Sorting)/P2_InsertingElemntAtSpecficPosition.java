// Inserting Element at a specific index position by deleting one element -->traversing in backward direction

import java.util.Arrays;

public class P2_InsertingElemntAtSpecficPosition {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 40 };

		// insert element 5 at index 3

		int element = 5;
		int pos = 2;
		
		// method 1 inserting element in backward direction 
		
	/*	for (int i = arr.length-1; i > pos; i--) {

			arr[i] = arr[i - 1];

		}

		arr[pos] = element;
		System.out.println(Arrays.toString(arr));
		
		
		// Traversing Loop
		
		for(int i=0;i<arr.length;i++) {
			
			System.out.println("Element at index "+i + " +is "+arr[i]);	
				
			} 
		
		
		
		// method 2 inserting element in forward direction 

		int temp=arr[pos];
		arr[pos]=element;
		
		for(int i=pos+1;i<arr.length;i++) {
			
			int nextElement=arr[i];
			arr[i]=temp;
			temp=nextElement;
			
			
		}
		
		
		*/
		
		
		// method 3 inserting element in forward direction 

		int temp=arr[pos];
		arr[pos]=element;
		
		for(int i=pos;i<arr.length-1;i++) {
			
			
			int nextElement=arr[i+1];
			arr[i+1]=temp;
			temp=nextElement;
			
			
		}
		
		//traversing the element of array
		for(int no:arr) {
			
			System.out.println(no);
		}

	}

}




















