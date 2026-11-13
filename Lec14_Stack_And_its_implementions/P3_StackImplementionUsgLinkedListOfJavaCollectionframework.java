
package Lec14_Stack_And_its_implementions;

import java.util.LinkedList;

//============================================================
// Implementing Stack using LinkedList Class
// of Java Collection Framework
//
// LinkedList is a built-in class of Java Collection Framework.
//LinkedList is a class that implements the Deque interface in Java Collection Framework.

// LinkedList implements Deque interface.
// Deque interface provides Stack operations like push(), pop() and peek().
//============================================================

public class P3_StackImplementionUsgLinkedListOfJavaCollectionframework {

	public static void main(String[] args) {


		//============================================================
		// Difference between LinkedList add() and push() Method
		//============================================================

		// Creating LinkedList Object using LinkedList Class.

		LinkedList<Integer> ll = new LinkedList<>();

		// add() Method: To add elements at the end of LinkedList.
		// addLast() Method: To add elements at the end of LinkedList.

		ll.add(10);
		ll.add(20);
		ll.add(30);
		ll.add(40);

		System.out.println("LinkedList using add(): " + ll);


		//============================================================
		// Implementing Stack using LinkedList Class
		//============================================================

		// Creating Stack using LinkedList Class.
		// LinkedList implements Deque interface.
		// Deque interface provides Stack methods.

		LinkedList<Integer> stack = new LinkedList<>();


		//============================================================
		// push() Method: To add elements at the top of Stack.
		// addFirst() Method: To add elements at the beginning of LinkedList.
		//============================================================

		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);

		System.out.println("Stack Elements: " + stack);


		//============================================================
		// pop() Method: To remove and return the top element of Stack.
		// removeFirst() Method: To remove and return the first element of LinkedList.
		//============================================================

		System.out.println("Pop Element: " + stack.pop());

		System.out.println("Stack after pop(): " + stack);


		//============================================================
		// peek() Method: To get the top element of Stack without removing it.
		// peekFirst() Method: To get the first element of LinkedList without removing it.
		//============================================================

		System.out.println("Peek Element: " + stack.peek());


		//============================================================
		// size() Method: To get the total number of elements.
		//============================================================

		System.out.println("Size of Stack: " + stack.size());


		//============================================================
		// contains() Method: To check whether an element exists or not.
		//============================================================

		System.out.println("Contains 20: " + stack.contains(20));


		//============================================================
		// isEmpty() Method: To check whether Stack is empty or not.
		//============================================================

		System.out.println("Is Stack Empty: " + stack.isEmpty());


		//============================================================
		// clear() Method: To remove all elements from LinkedList.
		//============================================================

		stack.clear();

		System.out.println("Stack after clear(): " + stack);

		System.out.println("Is Stack Empty: " + stack.isEmpty());

		System.out.println("Size after clear(): " + stack.size());

	}
}
