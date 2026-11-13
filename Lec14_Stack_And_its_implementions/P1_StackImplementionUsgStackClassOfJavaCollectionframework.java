// implementing stack using built in stack class in java collection framework

package Lec14_Stack_And_its_implementions;

import java.util.Stack;

public class P1_StackImplementionUsgStackClassOfJavaCollectionframework {

	public static void main(String args[]) {
		Stack<Integer> stack = new Stack<>();

		// push method --to add
		stack.push(5);
		stack.push(10);
		stack.push(20);
		stack.push(30);

		System.out.println(stack);
		System.out.println("Size of stack:"+stack.size());

		System.out.println("Pop Element is: " + stack.pop());

		System.out.println("peek Element is: " + stack.peek());
		System.out.println( stack.search(20));
		System.out.println( stack.search(99));



		stack.clear();

		System.out.println(stack);

		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		
		

	}
}
