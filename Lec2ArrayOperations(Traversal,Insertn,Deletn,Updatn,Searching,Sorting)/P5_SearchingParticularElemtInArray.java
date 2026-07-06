// Searching Element in Array


public class P5_SearchingParticularElemtInArray {

	public static void main(String[] args) {

		int[] arr= {5,4,75,7,6};
		
		//Element to find
		
		int element=66;
		
		int flag=-1;
		for(int i=0;i<arr.length;i++){
			
			if(element==arr[i]) {
				
				flag=i;
			}
		}
		
		
		
		if(flag==-1) {
			
			System.out.println("Element "+element +" not found");

		}else {
			
			System.out.println("Element " +element +" found at "+flag+ " index Position");

		}
	}

}
