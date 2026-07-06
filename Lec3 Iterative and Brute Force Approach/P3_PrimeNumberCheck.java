// wap to check prime number 

public class P3_PrimeNumberCheck {

	public static void main(String[] args) {

		int no=1;
		boolean isPrime=true;
		
		
		if(no<=1) {
			
			System.out.println("Number " + no+" is not prime");
			return;
		
		}
		
		
		for(int i=2;i<no;i++) {    // optimized its by giving condn as i<no/2
			
			if(no%i==0) {
				
				isPrime=false;
				break;
			}
			
			
			
		}
		if(isPrime) {
			
			System.out.println("Number " + no+" is  prime");

		}else {
			
			System.out.println("Number " + no+" is not prime");

		}
		
	}

}
