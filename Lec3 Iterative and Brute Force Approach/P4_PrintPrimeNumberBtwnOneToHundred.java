// wap to print prime number between 1 to 100

public class P4_PrintPrimeNumberBtwnOneToHundred {

	public static void main(String[] args) {
		
		for(int no=2;no<=100;no++){
			
			boolean isPrime=true;

			for(int i=2;i<no;i++) {
				
				if(no%i==0) {
					
					isPrime=false;
				}
				
			}

			if(isPrime) {
				
				
				System.out.print(no+ " ");
			}
		}
		
		

	}

}
