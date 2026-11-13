
package Lec14_Stack_And_its_implementions;

/*
============================================================
       IMPLEMENTING STACK USING LINKEDLIST
============================================================

Introduction:
------------------------------------------------------------

In this implementation, we create Stack using our own
LinkedList implementation.

We do not use Java Collection Framework's built-in
LinkedList class.

Instead, we create our own Node class and manage
the connections between nodes using next references.

Stack follows LIFO (Last In First Out) principle.

We maintain a TOP reference which points to the first
node of LinkedList.

Therefore, insertion and deletion both happen at TOP.


============================================================
WHY LINKEDLIST?
============================================================

LinkedList stores elements in the form of nodes.

Each node contains two parts:

1. data : Stores the actual element.
2. next : Stores the reference of the next node.

We create a new node whenever we insert an element.

Unlike Array implementation, we do not need to define
a fixed capacity for Stack.


============================================================
HOW PUSH OPERATION WORKS
============================================================

To insert a new element, we create a new node.

1. Create a new node.
2. Connect the new node to the current TOP.
3. Update TOP to the new node.

Example:

push(10)
push(20)
push(30)

TOP(tail) -> 30 -> 20 -> 10(head) -> null


I show head and tail only to understand the concept in stack 
there is no concept of head and tail in stack only top is exists

The newly inserted node becomes the TOP.


============================================================
HOW POP OPERATION WORKS
============================================================

To remove the TOP element:

1. Check whether Stack is empty or not.
2. Store the data of the TOP node.
3. Move TOP to the next node.
4. Return the removed element.

Example:

Before pop():

TOP -> 30 -> 20 -> 10 -> null

After pop():

TOP -> 20 -> 10 -> null

WHY WE DO NOT USE WHILE LOOP IN POP()?

In a normal LinkedList, when we want to remove the last
node, we may need to traverse the list using a while loop
to reach the second-last node.

But in our Stack implementation, TOP is maintained at
the first node of LinkedList.

Therefore, we only need to move TOP to the next node.

top = top.next;

No traversal is required because we are removing the
first node, not the last node.

If we used a while loop to reach the last node,
it would be unnecessary and would increase the
time complexity from O(1) to O(n).


============================================================
HOW DISPLAY OPERATION WORKS
============================================================

To display all elements, we need to visit every node.

We use a temporary reference tempNode to traverse
the LinkedList.

1. Start tempNode from TOP.
2. Print the current node's data.
3. Move tempNode to the next node.
4. Continue until tempNode becomes null.

We use tempNode instead of TOP because we do not want
to change the original TOP reference during traversal.


============================================================
TIME COMPLEXITY
============================================================

push()       : O(1)
pop()        : O(1)
peek()       : O(1)
isEmpty()    : O(1)
size()       : O(1)
display()    : O(n)
clear()      : O(1)


============================================================
IMPLEMENTATION
============================================================
*/

public class P6_ImplementingStackUsingLinkedList {

	//============================================================
	// Node Class: To create individual nodes of LinkedList.
	//============================================================
	class Node {

		int data;

		Node next;

		Node(int data) {

			this.data = data;

			// Initially, new node does not point to any node.
			this.next = null;

		}

	}


	// TOP points to the first node of LinkedList.
	// Initially Stack is empty, so TOP is null.
	Node top = null;

	// Maintains the total number of elements in Stack.
	int size = 0;


	//============================================================
	// Push Method: To insert an element at the TOP of Stack.
	// Time Complexity: O(1)
	//============================================================
	public void push(int element) {

		// Create a new node containing the given element.
		Node newNode = new Node(element);

		// Connect the new node to the current TOP node.
		// New node will point to the previous first node.
		newNode.next = top;

		// Update TOP to the new node.
		// Now the new node becomes the first node.
		top = newNode;

		// Increase the size of Stack by 1.
		size++;

	}


	//============================================================
	// Pop Method: To remove and return the TOP element.
	// Time Complexity: O(1)
	//============================================================
	public int pop() {

		// Check whether Stack is empty or not.
		// If TOP is null, there is no element to remove.
		if (top == null) {

			throw new RuntimeException("Stack is empty");

		}

		// Store the data of the current TOP node.
		int removedElement = top.data;

		// Move TOP to the next node.
		// Previous TOP node is now removed logically.
		// No while loop is required because TOP already
		// points to the first node of LinkedList.
		top = top.next;

		// Decrease the size of Stack by 1.
		size--;

		// Return the removed element.
		return removedElement;

	}


	//============================================================
	// Peek Method: To get the TOP element without removing it.
	// Time Complexity: O(1)
	//============================================================
	public int peek() {

		// Check whether Stack is empty or not.
		if (top == null) {

			throw new RuntimeException("Stack is empty");

		}

		// Return the data of the TOP node.
		// TOP is not updated, so element is not removed.
		return top.data;

	}


	//============================================================
	// IsEmpty Method: To check whether Stack is empty or not.
	// Time Complexity: O(1)
	//============================================================
	public boolean isEmpty() {

		// If TOP is null, Stack does not contain any node.
		return top == null;

	}


	//============================================================
	// Size Method: To return the total number of elements.
	// Time Complexity: O(1)
	//============================================================
	public int size() {

		// Return the current size of Stack.
		return size;

	}


	//============================================================
	// Display Method: To display all elements of Stack.
	// Time Complexity: O(n)
	//============================================================
	public void display() {

		// Check whether Stack is empty or not.
		if (top == null) {

			System.out.println("Stack is empty");
			return;

		}

		// Create a temporary reference starting from TOP.
		// We use tempNode so that original TOP is not changed.
		Node tempNode = top;

		// Traverse the LinkedList until tempNode becomes null.
		while (tempNode != null) {

			// Print the data of the current node.
			System.out.print(tempNode.data + " ");

			// Move tempNode to the next node.
			tempNode = tempNode.next;

		}

		System.out.println();

	}


	//============================================================
	// Clear Method: To remove all elements from Stack.
	// Time Complexity: O(1)
	//============================================================
	public void clear() {

		// Set TOP to null to make Stack logically empty.
		top = null;

		// Update size because Stack is now empty.
		size = 0;

	}

}
