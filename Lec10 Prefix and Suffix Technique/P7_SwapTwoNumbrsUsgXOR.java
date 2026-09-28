//  swap two numbers  using XOR.
//  swap two numbers without using a temporary variable.

public class P7_SwapTwoNumbrsUsgXOR {

	public static void main(String[] args) {
		int a = 5;

		int b = 3;
		System.out.println("Before Swapp " +"a="+a+" , b="+b);
		a=a^b;
			b=a^b;
			a=a^b;
			
			System.out.println("After Swapp " +"a="+a+" , b="+b);

			
	}
	

}
