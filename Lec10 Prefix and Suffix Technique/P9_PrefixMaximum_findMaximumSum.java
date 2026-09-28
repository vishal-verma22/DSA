// find the maxmimum element using prefix 
public class P9_PrefixMaximum_findMaximumSum {

	public static void main(String[] args) {

		int[] arr= {2,6,8,7,11};
			int n=arr.length;
		int[] prefix=new int[n];
		
		prefix[0]=arr[0];
		
		for(int i=1;i<n;i++) {
			prefix[i]=Math.max(arr[i],prefix[i-1]);
		}
		for(int no:prefix) {
		System.out.print(no +" ");
		}
	}

}

