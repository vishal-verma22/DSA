// Problem Statement:
// WAP to move all the zero elements to the end of the array
// using the Two Pointer Approach.
//
// Logic:
// 1. Use two pointers:
//    - L (Left Pointer): Points to the position where the next non-zero element should be placed.
//    - R (Right Pointer): Traverses the array.
// 2. If arr[R] is non-zero, swap arr[L] and arr[R], then increment L.
// 3. If arr[R] is zero, simply move R to the next element.
// 4. After traversal, all non-zero elements remain at the beginning
//    and all zeros are moved to the end.
//
// Time Complexity : O(n)
// Space Complexity: O(1)

public class P3_MoveAllZeroToEndOfArray {

	public static void  moveZeroToEnd(int arr[]) {

		int n = arr.length;

		// Left Pointer
		int L = 0;

		// Right Pointer
		int R = 0;
		
		for(;R<n;R++) {
			
			if(arr[R]!=0) {
				int temp=arr[R];
				arr[R]=arr[L];
				arr[L]=temp;
				L++;

				
			}
			
			

			
		}
		for(int i=0;i<R;i++) {
			
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		
		
		int arr[] = { 1, 0, 0, 3, 0, 5, 0, 6, 7 };

		 moveZeroToEnd(arr);
	

	}

}
