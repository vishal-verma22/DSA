// wap to count the frequency of each elements using another boolean array

// method-2

public class P2A_CountTheFrequencyOfEachElement {

	public static void main(String[] args) {
		
		int arr1[] = { 2, 14, 2, 5, 14, 2, 12, 25 };
		int n = arr1.length;
		
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
			System.out.println(arr1[i] + "==>" + count);

		}

		
	}

}
