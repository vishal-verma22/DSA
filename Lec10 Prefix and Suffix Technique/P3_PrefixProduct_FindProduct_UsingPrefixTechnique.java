// Find the product of array using prefix technique

public class P3_PrefixProduct_FindProduct_UsingPrefixTechnique {

	public static void main(String[] args) {

		int arr[]= {2, 4, 1, 5, 3};
		int n=arr.length;
		int prefix[]=new int[n];
		prefix[0]=arr[0];
		for(int i=1;i<n;i++) {
			prefix[i]=arr[i]*prefix[i-1];


		}
		
		for(int no:prefix) {
			
			System.out.print(no+" ");

		}

	}

}

