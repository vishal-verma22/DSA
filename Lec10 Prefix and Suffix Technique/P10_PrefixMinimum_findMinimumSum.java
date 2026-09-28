// find the minimum element using prefix 

public class P10_PrefixMinimum_findMinimumSum {
	
	public static void main(String[] args) {
		int[] arr= {2,6,1,4,-1};
		int n=arr.length;
	int[] prefix=new int[n];
	
	prefix[0]=arr[0];
	
	for(int i=1;i<n;i++) {
		prefix[i]=Math.min(arr[i],prefix[i-1]);
	}
	for(int no:prefix) {
	System.out.print(no +" ");
	}
	}

}
