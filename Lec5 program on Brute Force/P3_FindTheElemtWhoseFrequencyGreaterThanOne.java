// wap to find the elements whose frequency is greater than 1

public class P3_FindTheElemtWhoseFrequencyGreaterThanOne {

	public static void main(String[] args) {
		
		int arr1[] = { 52, 23, 14, 12,12,15,12,14,8,3,14};
		int n=arr1.length;
		
		boolean temp[]=new boolean[n];


		for (int i = 0; i < n; i++) {
			int count=1; //because current element khud ek baar to present hai hi.
			
		if(temp[i]==true) {
				continue;
		}
		
			for(int j=i+1;j<n;j++) {
				
				if(arr1[i]==arr1[j]) {
				
				count++;
				temp[j]=true;
				}
			}
			if(count>1) {
				System.out.println("Element==> "+ arr1[i]+" Frequency==> "+count);
			}
		}
	}
}
