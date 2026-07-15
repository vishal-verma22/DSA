// Problem Statement:
// WAP to remove duplicate elements from a given sorted array
// using the Two Pointer Approach without using any extra array.
//
// Logic:
// 1. Use two pointers:
//    - L (Left Pointer): Points to the last unique element.
//    - R (Right Pointer): Traverses the array.
// 2. Compare arr[L] with arr[R].
// 3. If both elements are different, increment L and copy arr[R] to arr[L].
// 4. Continue until the entire array is traversed.
// 5. After completion, the first (L + 1) elements contain all unique elements.
//
// Time Complexity : O(n)
// Space Complexity: O(1)


public class P2_RemoveDuplicateElementsFromGivenSortedArray {

	public static void  removeDuplicate(int arr[]) {

		int n = arr.length;

		// Left Pointer
		int L = 0;

		// Right Pointer
		int R = 1;

		for (; R < n; R++) {
			
			if(arr[L]!=arr[R]) {
				L++;
				arr[L]=arr[R];
				
				
			
			}
		}
		
		for(int i=0;i<=L;i++) {
			
			System.out.print(arr[i]+" ");
		}

	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 2, 3, 4, 5, 5, 6, 7 };

		 removeDuplicate(arr);


	}

}
