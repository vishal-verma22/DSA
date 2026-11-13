
package Lec14_Stack_And_its_implementions;

public class P4_ImplementingStackUsingArrayMainApp {

	public static void main(String args[]) {

		//============================================================
		// Creating Stack Object
		//============================================================

		// Creating a Stack with capacity of 5 elements.
		// Constructor will initialize:
		// capacity = 5
		// top = -1 (Initially Stack is empty)
		// stack = new int[5]
		P4_ImplementingStackUsingArray stack =
				new P4_ImplementingStackUsingArray(5);


		//============================================================
		// Checking Initial Stack Details
		//============================================================

		// Print the maximum capacity of Stack.
		System.out.println("Stack Capacity: " + stack.capacity);

		// Print the current number of elements in Stack.
		// Initially it is 0 because Stack is empty.
		System.out.println("Initial Stack Size: " + stack.size());


		//============================================================
		// Push Operation: Adding Elements into Stack
		//============================================================

		// Each new element is inserted at the TOP of Stack.
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);


		//============================================================
		// Display Operation
		//============================================================

		// Display elements from TOP to BOTTOM.
		// Output: 50 40 30 20 10
		System.out.print("Stack Elements: ");
		stack.display();


		//============================================================
		// Checking Stack Size
		//============================================================

		// Print the current number of elements in Stack.
		System.out.println("Stack Size: " + stack.size());


		//============================================================
		// Peek Operation
		//============================================================

		// Returns the top element without removing it.
		System.out.println("Top Element: " + stack.peek());


		//============================================================
		// Pop Operation
		//============================================================

		// Removes and returns the top element from Stack.
		System.out.println("Removed Element: " + stack.pop());


		// Display Stack after removing the top element.
		System.out.print("Stack After Pop: ");
		stack.display();


		//============================================================
		// Search Operation
		//============================================================

		// Search for element 30 in Stack.
		// Returns its position from TOP (starting from 1).
		System.out.println("Position of 30: " + stack.search(30));


		//============================================================
		// IsEmpty Operation
		//============================================================

		// Check whether Stack is empty or not.
		System.out.println("Is Stack Empty: " + stack.isEmpty());


		//============================================================
		// Clear Operation
		//============================================================

		// Remove all elements from Stack logically.
		stack.clear();

		// Check Stack after clearing all elements.
		System.out.println("Stack Size After Clear: " + stack.size());
		System.out.println("Is Stack Empty After Clear: " + stack.isEmpty());

	}

}
