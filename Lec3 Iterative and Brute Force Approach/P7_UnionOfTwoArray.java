
public class P7_UnionOfTwoArray {

	public static void main(String[] args) {
		
		int[] arr1= {15,14,16,20,42,100};
		int[] arr2= {20,16,40};
		
		int n1=arr1.length;
		int n2=arr2.length;

		int[] arr3=new int[n1+n2];
		
		for(int i=0;i<n1;i++) {
			arr3[i]=arr1[i];
			
			
		}
	
		int index=n1;
		for(int i=0;i<n2;i++) {
			boolean isAlreadyExists=false;

			for(int k=0;k<arr3.length;k++) {
				if(arr2[i]==arr3[k]) {
					
					isAlreadyExists=true;
				}
				
			}
			if(isAlreadyExists==false) {
				
				arr3[index]=arr2[i];
				index++;
			}
		}
		
		
		
		
		
		
		
		
		for(int no:arr3){
			
			System.out.print(no+" ");
		}

		
	}

}
