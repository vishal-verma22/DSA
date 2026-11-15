package Lec14_Stack_And_its_implementions;


//============================================================

//Implementing Stack using Built-in ArrayDeque Class
//of Java Collection Framework

//============================================================

/*

=> ArrayDeque is a built-in class of Java Collection Framework.

=> ArrayDeque implements the Deque interface.

=> Deque stands for Double Ended Queue.

=> Deque interface provides methods to perform Stack operations
  as well as Queue operations.

=> We can use ArrayDeque to implement Stack without creating
  our own Node class or managing TOP reference manually.

=> Important Stack Operations:

      1. push(element) : To insert an element at the TOP.
      2. pop()         : To remove and return the TOP element.
      3. peek()        : To return the TOP element without removing it.
      4. isEmpty()     : To check whether Stack is empty or not.
      5. size()        : To return total number of elements.

=> Important:

      1. LinkedList implements Deque interface.
      2. ArrayDeque implements Deque interface.
      3. Both classes can be used to implement Stack.
      4. Both provide push(), pop() and peek() methods.

=> Class Relationship:

      Deque (Interface)
            ^
            |
      -----------------
      |               |
   LinkedList     ArrayDeque
      Class          Class

=> Note:

      ArrayDeque is generally preferred over the legacy
      Stack class for Stack implementation in Java.

      ArrayDeque does not allow NULL elements.

*/

import java.util.ArrayDeque;

public class P2_StackImplementionUsgArrayDequeClassOfJavaCollectionframework {

	public static void main(String args[]) {

		// Create ArrayDeque Object
		ArrayDeque<Integer> stack = new ArrayDeque<>();

		// push() - To add elements
		stack.push(5);
		stack.push(10);
		stack.push(20);
		stack.push(30);

		System.out.println("Stack Elements: " + stack);

		// size() - To get total elements
		System.out.println("Size of Stack: " + stack.size());

		// pop() - To remove and return top element
		System.out.println("Pop Element is: " + stack.pop());

		// peek() - To get top element without removing it
		System.out.println("Peek Element is: " + stack.peek());

		// contains() - To check whether element exists
		System.out.println("Contains 20: " + stack.contains(20));

		System.out.println("Contains 99: " + stack.contains(99));

		// clear() - To remove all elements
		stack.clear();

		System.out.println("Stack after clear(): " + stack);

		// isEmpty() - To check whether Stack is empty
		System.out.println("Is Stack Empty: " + stack.isEmpty());

		// size() - To get size after clear()
		System.out.println("Size after clear(): " + stack.size());

	}
}