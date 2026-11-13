package Lec14_Stack_And_its_implementions;


//============================================================
//Implementing Stack using Built-in ArrayDeque Class
//of Java Collection Framework
//============================================================


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