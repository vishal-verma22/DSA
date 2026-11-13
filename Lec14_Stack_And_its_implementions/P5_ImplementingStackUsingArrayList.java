
/*
============================================================
          IMPLEMENTING STACK USING ARRAYLIST
============================================================

Introduction:
------------------------------------------------------------

ArrayList is a class provided by Java Collection Framework
which is used to store elements dynamically.

We can implement Stack using ArrayList because it allows
us to add, remove and access elements using indexes.

In this implementation, we use ArrayList to store Stack
elements and create our own Stack methods such as
push(), pop(), peek(), isEmpty() and display().


============================================================
TYPES OF IMPLEMENTATION
============================================================

1. Using Java Collection Framework ArrayList:
------------------------------------------------------------

In this approach, we use the built-in ArrayList class
provided by Java.

We use its built-in methods such as:

add()    : To insert an element at the end.
remove() : To remove an element from a specific index.
get()    : To access an element using its index.
size()   : To get the total number of elements.

But ArrayList does not provide Stack-specific methods
like push(), pop() and peek().

Therefore, we create our own Stack methods using
the built-in ArrayList methods.


2. Using Custom ArrayList Implementation:
------------------------------------------------------------

In this approach, we do not use Java's built-in ArrayList.

Instead, we create our own ArrayList implementation using
an array and manage its size and capacity.

We create methods such as add(), removeLast() and getLast()
to perform insertion, deletion and accessing operations.

After that, we use our custom ArrayList to implement Stack
by creating our own push(), pop() and peek() methods.


============================================================
HOW STACK WORKS USING ARRAYLIST
============================================================

Stack follows LIFO (Last In First Out) principle.

The element inserted last will be removed first.

In ArrayList implementation, we consider the last index
of ArrayList as the TOP of Stack.

For example:

push(10)
push(20)
push(30)

ArrayList: [10, 20, 30]

TOP = 30

push() : Adds an element at the end of ArrayList.
pop()  : Removes the last element of ArrayList.
peek() : Returns the last element without removing it.

============================================================
IMPORTANT POINTS
============================================================

1. ArrayList provides dynamic resizing.
2. We use the last index as TOP of Stack.
3. Insertion and deletion are performed at the end.
4. Stack methods are created by us.
5. Stack follows LIFO principle.

============================================================
*/
package Lec14_Stack_And_its_implementions;

import java.util.ArrayList;

public class P5_ImplementingStackUsingArrayList {

	// ArrayList used to store Stack elements.
	// We consider the last index of ArrayList as TOP of Stack.
	ArrayList<Integer> stack;


	//============================================================
	// Constructor: To initialize the ArrayList.
	//============================================================
	P5_ImplementingStackUsingArrayList() {

		// Creating an empty ArrayList.
		stack = new ArrayList<>();

	}


	//============================================================
	// Push Method: To add an element at the top of Stack.
	// Time Complexity: O(1) Amortized
	//============================================================
	public void push(int element) {

		// add() inserts the element at the end of ArrayList.
		// Since the last index represents TOP of Stack,
		// the new element becomes the TOP element.
		stack.add(element);

	}


	//============================================================
	// Pop Method: To remove and return the top element of Stack.
	// Time Complexity: O(1)
	//============================================================
	public int pop() {

		// Check whether Stack is empty or not.
		// If Stack is empty, there is no element to remove.
		if (stack.isEmpty()) {

			throw new RuntimeException("Stack is empty");

		}

		// getLast() returns the last element of ArrayList.
		// Store that element because we have to return it.
		int removedElement = stack.getLast();

		// removeLast() removes the last element from ArrayList.
		// After removal, the previous element becomes TOP.
		stack.removeLast();

		// Return the removed element.
		return removedElement;

	}


	//============================================================
	// Peek Method: To get the top element without removing it.
	// Time Complexity: O(1)
	//============================================================
	public int peek() {

		// Check whether Stack is empty or not.
		if (stack.isEmpty()) {

			throw new RuntimeException("Stack is empty");

		}

		// getLast() returns the last element without removing it.
		return stack.getLast();

	}


	//============================================================
	// Display Method: To display all elements of Stack.
	// Time Complexity: O(n)
	//============================================================
	public void display() {

		// Check whether Stack is empty or not.
		if (stack.isEmpty()) {

			System.out.println("Stack is empty");
			return;

		}

		// Start from the last index because it represents TOP.
		// Move backwards until we reach index 0.
		for (int i = stack.size() - 1; i >= 0; i--) {

			// Print elements from TOP to BOTTOM.
			System.out.print(stack.get(i) + " ");

		}

		System.out.println();

	}


	//============================================================
	// IsEmpty Method: To check whether Stack is empty or not.
	// Time Complexity: O(1)
	//============================================================
	public boolean isEmpty() {

		// ArrayList's isEmpty() returns true if it has no elements.
		return stack.isEmpty();

	}


	//============================================================
	// Size Method: To return the total number of elements.
	// Time Complexity: O(1)
	//============================================================
	public int size() {

		// Return the total number of elements in ArrayList.
		return stack.size();

	}


	//============================================================
	// Clear Method: To remove all elements from Stack.
	// Time Complexity: O(n)
	//============================================================
	public void clear() {

		// clear() removes all elements from ArrayList.
		stack.clear();

	}

}
