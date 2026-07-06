// wap to find duplicate elements in an array if duplicate number occur more than 2 time

public class P6_DuplicateElementUsgBruteForceApproach {
	
	public static void main(String args[]) {
		int arr[]= {10,40,60,20,10,50,20,40,20,80,10};
		

		

				boolean duplicate=false;
				
				for(int i=0;i<arr.length;i++) {
					boolean alreadyExist=false;
					
					for(int k=0;k<i;k++) {
						
						if(arr[k]==arr[i]) {
							alreadyExist=true;
							
						}
						
						
					}
					
					if(alreadyExist) {
						continue;
						
					}
					

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
