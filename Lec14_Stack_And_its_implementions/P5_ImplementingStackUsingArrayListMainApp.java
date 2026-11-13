
package Lec14_Stack_And_its_implementions;

public class P5_ImplementingStackUsingArrayListMainApp {

	public static void main(String args[]) {

		//============================================================
		// Creating Stack Object
		//============================================================

		// Creating an object of our custom Stack class.
		// Internally, this Stack uses Java Collection Framework
		// ArrayList to store its elements.
		P5_ImplementingStackUsingArrayList stack =
				new P5_ImplementingStackUsingArrayList();


		//============================================================
		// Push Operation: Adding Elements into Stack
		//============================================================

		// Insert elements one by one at the TOP of Stack.
		stack.push(10);
		stack.push(20);
		stack.push(30);


		//============================================================
		// Display Operation
		//============================================================

		// Display all elements from TOP to BOTTOM.
		// Output: 30 20 10
		System.out.print("Stack Elements: ");
		stack.display();


		//============================================================
		// Pop Operation: Removing the Top Element
		//============================================================

		// Remove and return the top element of Stack.
		// Output: 30
		System.out.println("Removed Element: " + stack.pop());


		//============================================================
		// Display Stack After Pop Operation
		//============================================================

		// After removing 30, the new TOP element is 20.
		// Output: 20 10
		System.out.print("Stack After Pop: ");
		stack.display();


		//============================================================
		// Peek Operation
		//============================================================

		// Return the top element without removing it.
		System.out.println("Top Element: " + stack.peek());


		//============================================================
		// Checking Stack Size
		//============================================================

		// Return the total number of elements present in Stack.
		System.out.println("Stack Size: " + stack.size());


		//============================================================
		// IsEmpty Operation
		//============================================================

		// Check whether Stack is empty or not.
		System.out.println("Is Stack Empty: " + stack.isEmpty());


		//============================================================
		// Clear Operation
		//============================================================

		// Remove all elements from Stack.
		stack.clear();

		// Check Stack after clearing all elements.
		System.out.println("Stack Size After Clear: " + stack.size());
		System.out.println("Is Stack Empty After Clear: " + stack.isEmpty());

	}

}
