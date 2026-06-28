
public class P4_getArrayLengthAndLastIndex {

	public static void main(String[] args) {

		String [] arr=new String[5];
		
		arr[0]="vishal";
		arr[1]="rahul";
		arr[2]="soham";
		arr[3]="bharat";
		
		System.out.println("Array Size"+ arr.length);
		System.out.println("Array Last Index Position "+(arr.length-1));

		System.out.println();

		// Another way  to create Array
		
		String [] arr1= {"soham","roham","john"};
		
		
		System.out.println("Array Size"+ arr1.length);
		System.out.println("Array Last Index Position "+(arr1.length-1));


		
	}

}
