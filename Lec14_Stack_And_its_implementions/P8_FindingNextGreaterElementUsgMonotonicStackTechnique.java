
package Lec14_Stack_And_its_implementions;

import java.util.Arrays;
import java.util.Stack;

//============================================================
// finding  Next Greater Element (NGE) using Monotonic Stack technique
// We are solving the this question using the Monotonic Stack
// Technique with time complexity O(n) instead of O(n^2).
//============================================================
/*
 * 
 * Technique
=>Move Ponter Left to Right (0 → n-1) when we want to find:
	Previous Greater Element
	Previous Smaller Element

=>Move pointer RIGHT to LEFT (n-1 → 0) when we want to find:
	Next Greater Element
	Next Smaller Element

 
 Find the Next Greater Element (NGE) for every element
 in the given array.

 Input:
 arr[] = {4, 7, 2, 10, 8}

 Output:
 7 10 10 -1 -1

 Approach: Monotonic Stack (Decreasing Stack)

 Working Logic:

 1. Create an empty stack to store elements that can be
    the Next Greater Element.

 2. Create a result array of the same size as the original
    array and initialize all positions with -1 using Arrays.fill().

 3. Traverse the original array from right to left using
    i = n - 1.

 4. Check whether the stack is empty or not and compare
    the stack's top element with the current array element.

 5. If stk.peek() is smaller than or equal to the current
    element, pop it because it cannot be the Next Greater
    Element for the current element.

 6. If the stack is not empty, its top element is the
    Next Greater Element. Store it in result[i].

 7. Push the current array element into the stack because
    it can be the Next Greater Element for elements on its left.

 8. Repeat the process until all elements are checked.

 9. Finally, print the original array and result array.


 Dry Run:

 Input = {4, 7, 2, 10, 8}

 Traverse from Right to Left:

 Current Element = 8
 Stack = [8]
 Result = [-1, -1, -1, -1, -1]

 Current Element = 10
 Pop 8, Push 10
 Stack = [10]

 Current Element = 2
 Stack Top = 10
 Result[2] = 10
 Push 2

 Current Element = 7
 Pop 2
 Stack Top = 10
 Result[1] = 10
 Push 7

 Current Element = 4
 Stack Top = 7
 Result[0] = 7
 Push 4

 Final Result = {7, 10, 10, -1, -1}


 Important Points:

 - Traverse from right to left.
 - Pop smaller and equal elements.
 - Stack top gives the nearest greater element on the right.
 - Push every current element into the stack.
 - If stack becomes empty, -1 remains in the result array.


 Time Complexity: O(n)
 Every element is pushed once and popped at most once.

 Space Complexity: O(n)
 Extra stack and result array are used.

*/

public class P8_FindingNextGreaterElementUsgMonotonicStackTechnique {

	public static void main(String[] args) {

		int arr[] = { 4, 7, 2, 10, 8 };

		Stack<Integer> stk = new Stack<>();

		int n = arr.length;

		// For storing greater elements
		int result[] = new int[n];

		//============================================================
		// Initialize Result Array
		//============================================================

		// Result array ki sabhi positions par initially -1 store karenge
		Arrays.fill(result, -1);

		//============================================================
		// Finding Next Greater Element Using Monotonic Stack
		//============================================================

		// Array ko right to left traverse karenge
		for (int i = n - 1; i >= 0; i--) {

			// Stack ka top current element se chhota ya equal hai
			// toh usko pop karenge kyunki woh NGE nahi ho sakta

			while (!stk.isEmpty() && stk.peek() <= arr[i]) {

				stk.pop();
			}

			// Agar stack empty nahi hai toh stack ka top
			// current element ka Next Greater Element hoga

			if (!stk.isEmpty()) {

				result[i] = stk.peek();
			}

			// Current element ko stack me push karenge
			// Kyunki ye left side ke elements ka NGE ban sakta hai

			stk.push(arr[i]);
		}

		//============================================================
		// Display Original Array
		//============================================================

		for (int no : arr) {

			System.out.print(no + " ");
		}

		System.out.println();

		//============================================================
		// Display Result Array
		//============================================================

		for (int no : result) {

			System.out.print(no + " ");
		}
	}
}

//============================================================
// Expected Output:
//
// 4 7 2 10 8
// 7 10 10 -1 -1
//
// Time Complexity: O(n)
// Space Complexity: O(n)
//============================================================
