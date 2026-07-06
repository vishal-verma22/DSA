// wap to find the second greatest number in a given array

public class P12_FindSecondGreatestNumberInArray {

	public static void main(String[] args) {
		
		int arr1[] = { 5, 6, 7,45, 8 ,9,45,9};

		int n = arr1.length;
		
		int max=arr1[0];
		int secondMax=arr1[0];
		


		for (int i = 0; i < n; i++) {

			if (arr1[i] > max) {
				secondMax=max;
				max=arr1[i];
				
			}else if(arr1[i]>secondMax && arr1[i]!=max) {
				secondMax=arr1[i];				//  arr1[i]!=max  cond when  have duplicate element

				
			}
		}
		
		System.out.println("Maximum elements of array "+max);
		System.out.println("Second Maximum elements of array "+secondMax);	}
	
	}


