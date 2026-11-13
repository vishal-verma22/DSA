// Implementing Stack Using Array

//============================================================
// In Java, Stack class, ArrayDeque class and LinkedList class
// provide built-in methods to perform Stack operations.
//
// But Array does not provide built-in Stack methods.
// So, we have to create our own methods and write our own logic.
//============================================================

package Lec14_Stack_And_its_implementions;

public class P4_ImplementingStackUsingArray {

	int capacity;       // Maximum number of elements Stack can store.

	int stack[];        // Array used to store Stack elements.

	int top;            // Stores the index of the top element of Stack.


	//============================================================
	// Constructor: To initialize the Stack with a given capacity.
	//============================================================
	P4_ImplementingStackUsingArray(int capacity) {

		this.capacity = capacity;

		// Initially Stack is empty, so top is -1.
		this.top = -1;

		// Create an array with the given capacity.
		stack = new int[capacity];

	}


	//============================================================
	// Push Method: To add an element at the top of Stack.
	// Time Complexity: O(1)
	//============================================================
	public void push(int element) {

		// Check whether Stack is full or not.
		// If top reaches the last valid index, Stack is full.
		// In that case, we cannot insert another element.
		if (top == capacity - 1) {

			throw new RuntimeException("Stack overflow");

		}

		// Increase top by 1 to move to the next available index.
		top++;

		// Insert the new element at the updated top position.
		stack[top] = element;

	}


	//============================================================
	// Pop Method: To remove and return the top element of Stack.
	// Time Complexity: O(1)
	//============================================================
	public int pop() {

		// Check whether Stack is empty or not.
		// If Stack is empty, there is no element to remove.
		if (isEmpty()) {

			throw new RuntimeException("Stack underflow");

		}

		// Store the top element because we have to return it.
		int removedElement = stack[top];

		// Decrease top by 1 to remove the top element logically.
		// The next element becomes the new top element.
		top--;

		// Return the removed element.
		return removedElement;

	}


	//============================================================
	// Peek Method: To get the top element without removing it.
	// Time Complexity: O(1)
	//============================================================
	public int peek() {

		// Check whether Stack is empty or not.
		// We cannot access the top element if Stack is empty.
		if (isEmpty()) {

			throw new RuntimeException("Stack is empty");

		}

		// Return the element present at the top position.
		// top is not decreased, so the element is not removed.
		return stack[top];

	}


	//============================================================
	// Size Method: To return the total number of elements in Stack.
	// Time Complexity: O(1)
	//============================================================
	public int size() {

		// Array indexing starts from 0.
		// Therefore, total elements = top + 1.
		return top + 1;

	}


	//============================================================
	// IsEmpty Method: To check whether Stack is empty or not.
	// Time Complexity: O(1)
	//============================================================
	public boolean isEmpty() {

		// If top is -1, it means Stack does not contain any element.
		// Return true if Stack is empty, otherwise return false.
		return top == -1;

	}


	//============================================================
	// Clear Method: To remove all elements from Stack.
	// Time Complexity: O(1)
	//============================================================
	public void clear() {

		// Set top to -1 to make Stack logically empty.
		// We do not need to delete array elements individually.
		top = -1;

	}


	//============================================================
	// Search Method: To search an element in Stack.
	// Returns the position from TOP (starting from 1).
	// Returns -1 if the element is not found.
	// Time Complexity: O(n)
	//============================================================
	public int search(int searchElement) {

		// Start searching from top because Stack follows LIFO.
		// Move backwards until we reach index 0.
		for (int i = top; i >= 0; i--) {

			// Check whether the current element matches the
			// element that we want to search.
			if (stack[i] == searchElement) {

				// Return the position from TOP.
				// Position starts from 1, not 0.
				return top - i + 1;

			}

		}

		// Return -1 if the element is not present in Stack.
		return -1;

	}


	//============================================================
	// Display Method: To display all elements of Stack.
	// Time Complexity: O(n)
	//============================================================
	public void display() {

		// Start from top to display the latest inserted element first.
		// Continue until we reach index 0.
		for (int i = top; i >= 0; i--) {

			// Print the current element.
			System.out.print(stack[i] + " ");

		}

		System.out.println();

	}

}
