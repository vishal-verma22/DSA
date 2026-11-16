package Lec15_Queue_And_its_Implementions;

public class P8_DequeUsgDoublyLinkedListMainApp {

	public static void main(String args[]) {

		P8_DequeImplementationUsgDoublyLinkedList dq = new P8_DequeImplementationUsgDoublyLinkedList();
		

		dq.addRear(10);
		dq.addRear(20);
		dq.addRear(30);

		dq.addFront(5);
		dq.addFront(1);

		System.out.println("Deque Elements:");
		dq.display();

		System.out.println("Front Peek: " + dq.getFrontPeek());
		System.out.println("Rear Peek: " + dq.getRearPeek());

		System.out.println("Deleted Front: " + dq.deleteFront());
		System.out.println("Deleted Rear: " + dq.deleteRear());

		System.out.println("After Deletion:");
		dq.display();
	}

}
