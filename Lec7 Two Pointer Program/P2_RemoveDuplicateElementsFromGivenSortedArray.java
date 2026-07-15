// wap to remove duplicate elements from the given array

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
