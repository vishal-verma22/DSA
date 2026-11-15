
package Lec15_Queue_And_its_Implementions;

public class P3_SimpleQueueUsgLinkedListMainApp {

	public static void main(String args[]) {

		P3_ImplementingSimpleQueueUsgLinkedList Queue = new P3_ImplementingSimpleQueueUsgLinkedList();

		//===========================================================
		// Adding Elements into the Queue
		//============================================================

		Queue.offer(20);

		Queue.offer(30);

		Queue.offer(40);

		Queue.offer(60);

		Queue.offer(70);

		//============================================================
		// Displaying Queue Elements
		//============================================================

		Queue.display();

		//============================================================
		// Removing Element from the Queue
		//============================================================

		System.out.println("Removed Element: " + Queue.poll());

		//============================================================
		// Displaying Front Element
		//============================================================

		System.out.println("Front Element: " + Queue.peek());

		//============================================================
		// Displaying Queue After Removal
		//============================================================

		Queue.display();
	}
}
