//============================================================
// Implementing Stack using Built-in Stack Class
// of Java Collection Framework
//============================================================



package Lec14_Stack_And_its_implementions;

import java.util.Stack;


public class P1_StackImplementionUsgStackClassOfJavaCollectionframework {

	public static void main(String args[]) {

		// Create Stack Object
		// Integer means stack will store Integer type elements.

		Stack<Integer> stack = new Stack<>();

		//============================================================
		// push() Method: To add elements into the Stack
		//============================================================

		// Elements are added at the top of the Stack.
		// Stack follows LIFO (Last In First Out) principle.

		stack.push(5);
		stack.push(10);
		stack.push(20);
		stack.push(30);

		// Print complete Stack
		System.out.println("Stack Elements: " + stack);

		//============================================================
		// size() Method: To get the total number of elements
		//============================================================

		System.out.println("Size of Stack: " + stack.size());

		//============================================================
		// pop() Method: To remove and return the top element
		//============================================================

		// 30 is at the top, so pop() will remove and return 30.

		System.out.println("Pop Element is: " + stack.pop());

		//============================================================
		// peek() Method: To get the top element without removing it
		//============================================================

		System.out.println("Peek Element is: " + stack.peek());

		//============================================================
		// search() Method: To search an element in the Stack
		//============================================================

		// search() counts position from the top of the Stack.
		// Top element position = 1.
		// If element is not found, it returns -1.

		System.out.println("Position of 20: " + stack.search(20));

		System.out.println("Position of 99: " + stack.search(99));

		//============================================================
		// clear() Method: To remove all elements from the Stack
		//============================================================

		stack.clear();

		// Print Stack after removing all elements
		System.out.println("Stack after clear(): " + stack);

		//============================================================
		// isEmpty() Method: To check whether Stack is empty or not
		//============================================================

		System.out.println("Is Stack Empty: " + stack.isEmpty());

		//============================================================
		// size() Method: To check total elements after clear()
		//============================================================

		System.out.println("Size after clear(): " + stack.size());

	}
}
