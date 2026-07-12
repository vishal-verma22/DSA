// Insertion Sort Algorithm
//
// Insertion Sort divides the array into two parts:
// 1. Sorted Part
// 2. Unsorted Part
//
// Initially, the first element is considered sorted.
//
// Working:
// 1. Pick the first element from the unsorted part.
// 2. Compare it with elements in the sorted part from right to left.
// 3. Shift all larger elements one position to the right.
// 4. Insert the current element at its correct position.
// 5. Repeat the process until the entire array becomes sorted.
//
// Time Complexity:
// Best Case    : O(n)
// Average Case : O(n²)
// Worst Case   : O(n²)
//
// Space Complexity:
// O(1)
//
// Stable Sorting  : Yes
// In-place Sorting: Yes

/*
public class P3_InsertionSortAlgorithmImplemention {

	public static void main(String[] args) {
		
		int arr[] = { 5, 6, 3, 2, 11, 9, 7 };
		
		// { 5, 5, 6, 2, 11, 9, 7 }
		int n = arr.length;
		
		for(int i=1;i<n;i++) {     // i=1,2
			int temp=arr[i];
			int j=i-1;
			
			for(;j>=0;j--) {   //j=1,0
				if(arr[j]>temp) {
					
					arr[j+1]=arr[j];
					
					
				}else {
					
					break;
				}
				
				
			}
			arr[j+1]=temp;
			
		}
		
		for (int no : arr) {
			System.out.print(no + " ");
		}

	}

}

*/
// method 2 using while loop

public class P3_InsertionSortAlgorithmImplemention {

	public static void main(String[] args) {

		int arr[] = { 5, 6, 3, 2, 11, 9, 7 };

		// { 5, 5, 6, 2, 11, 9, 7 }
		int n = arr.length;

		for (int i = 1; i < n; i++) {
			int temp = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;

			}
			
			arr[j+1]=temp;

		}
		

		for (int no : arr) {
			System.out.print(no + " ");
		}
	}

}
