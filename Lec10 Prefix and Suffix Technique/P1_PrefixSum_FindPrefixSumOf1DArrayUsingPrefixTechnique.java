// Find the sum of array using prefix technique

// Prefix Technique:
// Prefix Technique ka use starting index se current index tak ka result
// pehle calculate karke store karne ke liye hota hai.
//Right to left
// Prefix Sum mein har index par 0 se current index tak ka sum store hota hai.
//
// Iska main purpose repeated calculations ko avoid karke
// range queries ko fast banana hai.
//
// Prefix array banane ka time: O(N)
// Har range query ka time: O(1)
//
// Example:
// arr    = [2, 4, 1, 5, 3]
// prefix = [2, 6, 7, 12, 15]
//
// Range L to R ka sum:
// sum = prefix[R] - prefix[L - 1]
//
// Prefix Technique ka use Prefix Sum, Prefix Count,
// Prefix XOR, Prefix Maximum/Minimum etc. mein bhi hota hai.
public class P1_PrefixSum_FindPrefixSumOf1DArrayUsingPrefixTechnique {

	public static void main(String[] args) {

		int arr[]= {2, 4, 1, 5, 3};
		int n=arr.length;
		int prefix[]=new int[n];
		prefix[0]=arr[0];
		for(int i=1;i<n;i++) {
			prefix[i]=arr[i]+prefix[i-1];


		}
		
		for(int no:prefix) {
			
			System.out.print(no+" ");

		}



	}

}

