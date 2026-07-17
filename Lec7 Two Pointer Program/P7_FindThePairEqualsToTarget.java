

	// Problem Statement:
	// WAP to find a pair of elements whose sum is equal to the given target
	// using the Two Pointer Approach.
	//
	// Logic:
	// 1. Initialize two pointers:
//	    - L (Left Pointer) at the beginning of the array.
//	    - R (Right Pointer) at the end of the array.
	// 2. Calculate sum = arr[L] + arr[R].
	// 3. If sum == target, the pair is found.
	// 4. If sum < target, move L forward to increase the sum.
	// 5. If sum > target, move R backward to decrease the sum.
	// 6. Repeat until L < R.
	//
	// Time Complexity : O(n)
	// Space Complexity: O(1)

	public class P7_FindThePairEqualsToTarget {

	    public static void findPair(int arr[], int target) {

	        int L = 0;
	        int R = arr.length - 1;

	        boolean found = false;

	        while (L < R) {

	            int sum = arr[L] + arr[R];

	            if (sum == target) {
	                System.out.println("Pair: (" + arr[L] + ", " + arr[R] + ")");
	                found = true;
	                break;
	            }
	            else if (sum < target) {
	                L++;
	            }
	            else {
	                R--;
	            }
	        }

	        if (!found) {
	            System.out.println("Pair not found.");
	        }
	    }

	    public static void main(String[] args) {

	        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // Sorted Array
	        int target = 10;

	        findPair(arr, target);
	    }
	
}