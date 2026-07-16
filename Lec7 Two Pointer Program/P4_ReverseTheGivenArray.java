// Problem Statement:
// WAP to reverse the given array using the Two Pointer Approach.
//
// Logic:
// 1. Initialize two pointers:
//    - L (Left Pointer) at the beginning of the array.
//    - R (Right Pointer) at the end of the array.
// 2. Swap the elements at L and R.
// 3. Increment L and decrement R.
// 4. Repeat the process until L becomes greater than or equal to R.
// 5. After completion, the array is reversed.
//
// Example:
// Input  : {1, 2, 3, 4, 5}
// Output : {5, 4, 3, 2, 1}
//
// Time Complexity : O(n)
// Space Complexity: O(1)

public class P4_ReverseTheGivenArray {

	
	public static void reverse(int arr[]) {
		
		int n=arr.length;
		int L=0;
		int R=n-1;
				
		
		while(L<R) {
			int temp=arr[R];
			arr[R]=arr[L];
			arr[L]=temp;
			L++;
			R--;
			
			
		}
		
		for(int no:arr) {
			
System.out.print(no+" ");	

		}
		
	}
	
	
	public static void main(String[] args) {

	//	int[] arr= {1,2,3,4};
		
		int[] arr= {5,2,8,74,3,0};
		
		reverse(arr);
		
	}

}
