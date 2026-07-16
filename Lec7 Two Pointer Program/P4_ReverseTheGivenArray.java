// wap to reverse the given array using two pointer


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
