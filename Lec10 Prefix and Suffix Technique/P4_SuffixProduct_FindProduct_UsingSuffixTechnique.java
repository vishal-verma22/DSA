// Find the product of array using Suffix technique

public class P4_SuffixProduct_FindProduct_UsingSuffixTechnique {

	public static void main(String[] args) {
		int arr[]= {2, 4, 1, 5, 3};
		int n=arr.length;
		int Suffix[]=new int[n];
		
		Suffix[n-1]=arr[n-1];
		for(int i=n-2;i>=0;i--) {
			Suffix[i]=arr[i]*Suffix[i+1];


		}
		
		for(int no:Suffix) {
			
			System.out.print(no+" ");

		}

	}

}

