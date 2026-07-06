
public class P2_countingNoOfEvenAndOddNumberInArray {

	public static void main(String[] args) {

		int num[]= {54,5,47,89,2,44,47};

		int evenCount=0,oddCount=0;
		
		for(int i=0;i<num.length;i++) {
			
			if(i%2==0) {
				
				evenCount++;
			}else {
				
				oddCount++;
			}
			
			
			
		}
		System.out.print("Even count-->"+evenCount+"\nOdd count-->"+oddCount);
	}

}
