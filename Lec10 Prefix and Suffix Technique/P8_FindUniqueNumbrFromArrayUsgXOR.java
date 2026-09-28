// find the unique element in an array using XOR
//XOR method works when:
//       Har duplicate element exactly 2 times present hona chahiye array me, aur sirf 1 element unique hona chahiye.

public class P8_FindUniqueNumbrFromArrayUsgXOR {

	public static void main(String[] args) {

		int[] arr= {2,5,3,3,5};
		int unique=0;
		for(int no:arr) {
			
			unique=unique^no;
		}
		System.out.println("Unique no is "+unique);
	}

}

