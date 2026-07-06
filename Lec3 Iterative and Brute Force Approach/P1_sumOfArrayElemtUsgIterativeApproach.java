// sum of array element using iterative approach

public class P1_sumOfArrayElemtUsgIterativeApproach {

	public static void main(String[] args) {
		
		int num[]= {54,5,47,89,2,44,47};
		
		
		int sum=0;
		
		for(int i=0;i<num.length;i++) {
			
			sum=sum+num[i];
			
			
		}
		
		System.out.println("Sum of array elements is --> "+sum);

	}

}
