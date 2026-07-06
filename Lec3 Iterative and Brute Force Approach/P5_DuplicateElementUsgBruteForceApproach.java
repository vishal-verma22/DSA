// wap to find duplicate elements in an array if duplicate number occur maximum 2 time


public class P5_DuplicateElementUsgBruteForceApproach {
	
	public static void main(String args[]) {
		
		
		int arr[]= {10,40,60,20,10,50,20,40,80};
		
		//int arr[]= {10,60,20,50,80};
		

		boolean duplicate=false;
		
		for(int i=0;i<arr.length;i++) {
			

			for(int j=i+1;j<arr.length;j++) {
				
				if(arr[i]==arr[j]) {     
					
					System.out.println(arr[i]);
					duplicate=true;
					break;
				}
				
				
			}
			

				
			}
		if(duplicate==false) {
			
			System.out.println("Duplicate elemnt not found");
		}
	}

}
