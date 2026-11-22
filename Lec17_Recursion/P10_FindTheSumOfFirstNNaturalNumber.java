package Lec17_Recursion;

public class P10_FindTheSumOfFirstNNaturalNumber {

	
	public static int sum(int no) {
		
		if(no==0){
			
			return 0;
		}
		
		return no+ sum(no-1);
	}
	public static void main(String[] args) {
		int no=5;
System.out.println(sum(no));
	}

}
