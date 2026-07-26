// wap to Reverse a given String


public class P1_ReverseAGivenString {

	public static void main(String[] args) {

		String orginal="vishal";
		int n=orginal.length()-1;
		String reverse="";
		
		// using for loop
	/*	for(int i=n;i>=0;i--) {
			
			reverse=reverse+orginal.charAt(i);
		} */
		
		
		while(n>=0)   {   // or n!=0
			reverse=reverse+orginal.charAt(n);
			n--;

		}
		System.out.println("Reverse of Given String "+orginal  +" is --> "+ reverse);
	}

}
