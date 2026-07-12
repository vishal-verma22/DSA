// Binary Search Algorithm
//
// Binary Search is an efficient searching algorithm that works only
// on a sorted array. Instead of checking every element one by one,
// it repeatedly divides the search space into two halves.
//
// Working:
// 1. Initialize two pointers:
//    - low  = 0 (first index)
//    - high = n - 1 (last index)
//
// 2. Find the middle index using:
//    middle = (low + high) / 2
//
// 3. Compare the target element with the middle element.
//    - If arr[middle] == target, the element is found.
//    - If target > arr[middle], search in the right half
//      by setting low = middle + 1.
//    - If target < arr[middle], search in the left half
//      by setting high = middle - 1.
//
// 4. Repeat the process until:
//    - The element is found, or
//    - low becomes greater than high.
//
// 5. If low > high, the target element is not present in the array.
//
// Example:
// Array  : {10, 20, 30, 40, 50, 60, 70}
// Target : 60
//
// Iteration 1:
// low = 0, high = 6
// middle = 3
// arr[middle] = 40
// 60 > 40 → Search Right Half
//
// Iteration 2:
// low = 4, high = 6
// middle = 5
// arr[middle] = 60
// Element Found
//
// Time Complexity:
// Best Case    : O(1)    -> Target found at the middle in the first comparison.
// Average Case : O(log n)
// Worst Case   : O(log n)
//
// Space Complexity:
// O(1)
//
// Properties:
// - Works only on sorted arrays.
// - Faster than Linear Search for large datasets.
// - Uses the Divide and Conquer technique.
// - Iterative searching algorithm.
// - Reduces the search space by half in every iteration.


public class Prgm2_BinarySearchAlgorithmImplemention {

	public static void main(String[] args) {
		int arr[] = {10, 20, 30, 40, 50, 60, 70};
		int target = 7;
		int n=arr.length;
		
		int low=0;
		int high=arr.length-1;
		
		boolean found =false;
		
		while(low<=high) {
			
			int middle=(low+high)/2;

		if(arr[middle]==target) {
			
			System.out.println("Element " + target + " found at index position " + middle);
			found = true;
			break;
			
		}
		if(target>arr[middle]) {
			low=middle+1;
			
		}else {
			
			high=middle-1;

		}
		
		
	}
		if(!found) {
			
			System.out.println("Element " + target + " not found");

		}

}
}
