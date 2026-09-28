// Find the sum of array using suffix technique

// Suffix Technique:
// Suffix Technique ka use current index se lekar last index tak ka result
// pehle calculate karke store karne ke liye hota hai.

//Right to left  
// Suffix Sum mein har index par current element se
// last element tak ka total sum store hota hai.
//
// Suffix array ko right side se left side ki taraf
// calculate kiya jata hai.
//
// Example:
// arr    = [2, 4, 1, 5, 3]
// Suffix = [15, 13, 9, 8, 3]
//
// Formula:
// Suffix[i] = arr[i] + Suffix[i + 1]
//
// Last element ka suffix sum same element hota hai:
// Suffix[n - 1] = arr[n - 1]
//
// Iska main purpose repeated calculations ko avoid karke
// right-side range ka sum quickly find karna hai.
//
// Suffix array banane ka Time Complexity: O(N)
// Space Complexity: O(N)

public class P2_SuffixSum_FindSumUsingSuffixTechnique {

	public static void main(String[] args) {
		int arr[]= {2, 4, 1, 5, 3};
		int n=arr.length;
		int Suffix[]=new int[n];
		
		Suffix[n-1]=arr[n-1];
		for(int i=n-2;i>=0;i--) {
			Suffix[i]=arr[i]+Suffix[i+1];


		}
		
		for(int no:Suffix) {
			
			System.out.print(no+" ");

		}

	}
	

}
