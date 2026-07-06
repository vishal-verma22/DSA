
// Sorting Array Elements in Ascending order

// This sorting technique is called Bubble Sort.
// In Bubble Sort, we generally need n - 1 passes to sort an array, where n is the number of elements in the array.
// Outer loop for passes
// Inner loop for comparing adjacent elements

public class P7_SortingArrayInAsscendingOrder {

	public static void main(String[] args) {

		int arr[]= {5,6,3,2,11,9,7};
		
		
		for(int i=0;i<arr.length;i++) {    // loop for pass 
			
			for(int j=0;j<arr.length-1;j++) {  // for traversing each element in array
				
				if(arr[j]>arr[j+1]) {
				// swapping
					
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;

					
				}
				
			}
			
		}
		
		// traversing 
		
		for(int no:arr) {
			System.out.println(no);
			
		}
		
		
	}

}
