
package Lec15_Queue_And_its_Implementions;

public class P4_GenericSimpleQueueUsgLinkedListMainApp {

	public static void main(String args[]) {

		//============================================================
		// Creating Integer Queue
		//============================================================

		P4_GenericSimpleQueueImplementingUsgLinkedList<Integer> Queue =
				new P4_GenericSimpleQueueImplementingUsgLinkedList<>();

		Queue.offer(10);
		Queue.offer(20);
		Queue.offer(30);
		Queue.offer(40);

		System.out.println("Integer Queue:");
		Queue.display();

		System.out.println("Removed Element: " + Queue.poll());

		System.out.println("Front Element: " + Queue.peek());

		Queue.display();

		//============================================================
		// Creating String Queue
		//============================================================

		P4_GenericSimpleQueueImplementingUsgLinkedList<String> stringQueue =
				new P4_GenericSimpleQueueImplementingUsgLinkedList<>();

		stringQueue.offer("Java");
		stringQueue.offer("Python");
		stringQueue.offer("Django");

		System.out.println("\nString Queue:");
		stringQueue.display();

		System.out.println("Removed Element: " + stringQueue.poll());

		stringQueue.display();
	}
}
