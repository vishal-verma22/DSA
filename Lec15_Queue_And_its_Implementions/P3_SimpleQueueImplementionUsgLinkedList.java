
package Lec15_Queue_And_its_Implementions;

/*
 * ============================================================
 * SIMPLE QUEUE USING LINKEDLIST
 * ============================================================
 *
 * THEORY:
 *
 * 1. Queue follows FIFO (First In First Out) principle.
 * 2. Insertion is performed from the REAR end.
 * 3. Deletion is performed from the FRONT end.
 * 4. We are using a normal Singly LinkedList to implement Queue.
 * 5. Each Node contains two things:
 *    - data: Stores the element.
 *    - next: Stores the reference of the next Node.
 * 6. FRONT points to the first Node of the Queue.
 * 7. REAR points to the last Node of the Queue.
 * 8. The next of the last Node always points to NULL.
 * 
 * ============================================================
 * SIMPLE QUEUE DIAGRAM:
 * ============================================================
 *
 *       FRONT                         REAR
 *         |                             |
 *         v                             v
 *       [10 | *] ---> [20 | *] ---> [30 | null]
 *
 *       - FRONT points to the first Node.
 *       - REAR points to the last Node.
 *       - Last Node points to NULL.
 *       - No circular connection is present in simple Queue.
 *=>FRONT aur REAR aapas mein connect nahi hote, 
 *  lekin dono same node ko point kar sakte hain jab Queue mein sirf ek element ho.
 *
 *
 * QUEUE OPERATIONS:
 *
 * offer() : Adds an element at the REAR.
 * poll()  : Removes an element from the FRONT.
 * peek()  : Returns the FRONT element without removing it.
 * display(): Displays all elements of the Queue.
 *
 * TIME COMPLEXITY:
 *
 * offer()  : O(1)
 * poll()   : O(1)
 * peek()   : O(1)
 * display(): O(n)
 *
 * ============================================================
 */

public class P3_SimpleQueueImplementionUsgLinkedList {

	private class Node {

		private int data;
		private Node next;

		Node(int data) {

			this.data = data;
			next = null;
		}
	}

	private Node front = null;
	private Node rear = null;

	//============================================================
	// Offer Method: To add an element at the REAR of the Queue
	// Time Complexity: O(1)
	//============================================================

	public void offer(int data) {

		Node newNode = new Node(data);

		// Queue is empty
		if (front == null) {

			front = rear = newNode;
		}

		else {

			rear.next = newNode;
			rear = newNode;
		}
	}

	//============================================================
	// Poll Method: To remove an element from the FRONT of Queue
	// Time Complexity: O(1)
	//============================================================

	public int poll() {

		if (front == null) {

			throw new RuntimeException("Queue is Empty");
		}

		int removedElement = front.data;

		// Only one Node is present
		if (front == rear) {

			front = rear = null;
		}

		else {

			front = front.next;
		}

		return removedElement;
	}

	//============================================================
	// Peek Method: To get the FRONT element without removing it
	// Time Complexity: O(1)
	//============================================================

	public int peek() {

		if (front == null) {

			throw new RuntimeException("Queue is Empty");
		}

		return front.data;
	}

	//============================================================
	// Display Method: To display all elements of the Queue
	// Time Complexity: O(n)
	//============================================================

	public void display() {

		if (front == null) {

			System.out.println("Queue is Empty");
			return;
		}

		Node tempNode = front;

		while (tempNode != null) {

			System.out.print(tempNode.data + " ");
			tempNode = tempNode.next;
		}

		System.out.println();
	}
}
