// Find array element sum between the given range 
public class P11_SumRangeproblem_FindTheSumBetweenGivenRangeUsingPrefixTechnique {

	public static void main(String[] args) {

		int[] arr = { 5, 2, 5, 7, 3, 4, 7 };
		int left = 0, right = 4;
		int n = arr.length;

		int[] prefix = new int[n];

		prefix[0] = arr[0];
		// find the sum of the element in array using prefix technique

		for (int i = 1; i < n; i++) {

			prefix[i] = arr[i] + prefix[i - 1];
		}

		// Travsrsing the prefix array
		for (int no : prefix) {

			System.out.print(no + " ");
		}
		System.out.println();

		int sum;

		// left==0 condn liya q ki agar kabhi left=0 value rahega left range kaaur
		// left-1 karenge toh -1 aayega
		// aur ye array index out of bound show karega
		if (left == 0) {

			sum = prefix[right];
			System.out.println("Sum " + sum);

		} else {
			sum = prefix[right] - prefix[left - 1];
			System.out.println("Sum " + sum);
		}

	}
	

}
