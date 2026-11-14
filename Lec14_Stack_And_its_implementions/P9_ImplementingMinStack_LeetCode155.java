
package Lec14_Stack_And_its_implementions;

import java.util.Stack;

//============================================================
// LeetCode Question: 155 - Min Stack
// Approach: Using Two Stacks
//============================================================
/*
 
 Design a stack that supports the following operations in O(1) time:
	push(val) – Push an element onto the stack.
	pop() – Remove the top element from the stack.
	top() – Return the top element of the stack.
	getMin() – Return the minimum element currently present in the stack.
	Approach: Using Two Stacks

stk – Stores all elements.
minStack – Stores only minimum elements to track the current minimum.

1. Working Logic

1. Constructor:
	Create two empty stacks.
	stk stores all elements.
	minStack stores minimum elements.

2. push(int value):

	First, push the value into the main stack (stk).
	Check whether minStack is empty OR the current value is smaller than or equal to the top of minStack.
	If the condition is true, push the current value into minStack.
	<= is used to handle duplicate minimum values.

3. pop():

	Remove the top element from the main stack and store it in removedElement.
	Check whether the removed element is equal to the top element of minStack.
	If both are equal, pop the top element from minStack also.

4. top():
	Return stk.peek() because it contains all elements.
	We need the last inserted element, not the minimum element.

5. getMin():
	Return minStack.peek() because it maintains the current minimum element.

 */

//============================================================
//Dry Run:
//
//Operations:
//push(5), push(3), push(7), push(3)
//
//stk      = [5, 3, 7, 3]
//minStack = [5, 3, 3]
//
//top()    = 3
//getMin() = 3
//
//After pop():
//
//stk      = [5, 3, 7]
//minStack = [5, 3]
//
//top()    = 7
//getMin() = 3
//
//Time Complexity:
//push()   = O(1)
//pop()    = O(1)
//top()    = O(1)
//getMin() = O(1)
//
//Space Complexity: O(n)
//============================================================


public class P9_ImplementingMinStack_LeetCode155 {

	Stack<Integer> stk;

	// For storing only minimum elements
	Stack<Integer> minStack;

	//============================================================
	// Constructor: To initialize both stacks
	//============================================================

	public P9_ImplementingMinStack_LeetCode155() {

		stk = new Stack<>();

		minStack = new Stack<>();
	}

	//============================================================
	// Push Method: To insert elements into the stack
	//============================================================

	public void push(int value) {

		// Har element ko main stack me push karenge
		stk.push(value);

		// Check karenge ki minStack empty hai ya current value
		// minStack ke top se chhoti ya equal hai

		if (minStack.isEmpty() || value <= minStack.peek()) {

			// Agar condition true hai toh minStack me bhi push karenge
			minStack.push(value);
		}
	}

	//============================================================
	// Pop Method: To remove the top element from the stack
	//============================================================

	public void pop() {

		// Main stack se top element remove karenge
		// Aur removed element ko variable me store karenge

		int removedElement = stk.pop();

		// Check karenge ki removed element current minimum
		// element ke equal hai ya nahi

		if (removedElement == minStack.peek()) {

			// Agar equal hai toh minStack se bhi remove karenge
			minStack.pop();
		}
	}

	//============================================================
	// Top Method: To return the top element of the stack
	//============================================================

	public int top() {

		// Main stack ke top element ko return karenge
		return stk.peek();
	}

	//============================================================
	// GetMin Method: To return the minimum element
	//============================================================

	public int getMin() {

		// minStack ke top par current minimum element hota hai
		return minStack.peek();
	}

	//============================================================
	// Main Method: To test all MinStack operations
	//============================================================

	public static void main(String[] args) {

		P9_ImplementingMinStack_LeetCode155 stack =
				new P9_ImplementingMinStack_LeetCode155();

		//============================================================
		// Push Operations
		//============================================================

		stack.push(5);
		stack.push(3);
		stack.push(7);
		stack.push(3);

		//============================================================
		// Display Stack Information
		//============================================================

		System.out.println("Top Element: " + stack.top());

		System.out.println("Minimum Element: " + stack.getMin());

		//============================================================
		// Pop Operation
		//============================================================

		stack.pop();

		System.out.println("\nAfter Pop Operation:");

		System.out.println("Top Element: " + stack.top());

		System.out.println("Minimum Element: " + stack.getMin());
	}
}
