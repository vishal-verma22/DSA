// move all the negative to left and positive to right isde of array

public class P5_MoveAllNegtiveToLeftAndPostiveToRightSideOfArray {
	
	
	
public static void moveElement(int arr[]) {
		
		int n=arr.length;
		int L=0;
		int R=n-1;
				
		
		while(L<R) {
			
			if(arr[L]<0) {
				L++;
				
				
			}else if(arr[R]>0) {
				
				R--;
			}else if(arr[L]>0 && arr[R]<0) {
				
				int temp=arr[R];
				arr[R]=arr[L];
				arr[L]=temp;
				L++;
				R--;

			}
			
			
		}
		
		for(int no:arr) {
			
System.out.print(no+" ");	

		}
		
}

	public static void main(String[] args) {
		
		
		int[] arr = { -5, 2,-4,55, 8, -74, 3, 88,-3 };

		moveElement(arr);

	}

	
}
