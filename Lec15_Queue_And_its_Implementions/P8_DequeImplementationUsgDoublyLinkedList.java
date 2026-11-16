
package Lec15_Queue_And_its_Implementions;

//============================================================
//		DEQUE Implementation USING DOUBLY LINKED LIST
//============================================================


//
//Deque stands for Double Ended Queue.
//
//In Deque, insertion and deletion can be performed
//from both ends (Front and Rear).
//
//Doubly Linked List contains three parts:
//1. Previous: Stores address of previous node.
//2. Data: Stores the actual element.
//3. Next: Stores address of next node.
//
//Front: Points to the first node.
//Rear: Points to the last node.
//
//============================================================
//1. INSERTION AT FRONT (addFront)
//============================================================
//
//Initially:
//
//     front                         rear
//       |                             |
//       v                             v
//     [10] <-----> [20] <-----> [30]
//
//We want to insert 5 at the front.
//
//Steps:
//
//1. Create a new node containing 5.
//
//2. newNode.next = front
// New node ka next, current front ko point karega.
//
//3. front.previous = newNode
// Current front ka previous, new node ko point karega.
//
//4. front = newNode
// Front pointer ko new node par move kar denge.
//
//After Insertion:
//
//     front                                  rear
//       |                                      |
//       v                                      v
//      [5] <-----> [10] <-----> [20] <-----> [30]
//
//Time Complexity: O(1)
//
//
//============================================================
//2. INSERTION AT REAR (addRear)
//============================================================
//
//Initially:
//
//     front                         rear
//       |                             |
//       v                             v
//     [10] <-----> [20] <-----> [30]
//
//We want to insert 40 at the rear.
//
//Steps:
//
//1. Create a new node containing 40.
//
//2. newNode.previous = rear
// New node ka previous, current rear ko point karega.
//
//3. rear.next = newNode
// Current rear ka next, new node ko point karega.
//
//4. rear = newNode
// Rear pointer ko new node par move kar denge.
//
//After Insertion:
//
//     front                                    rear
//       |                                        |
//       v                                        v
//     [10] <-----> [20] <-----> [30] <-----> [40]
//
//Time Complexity: O(1)
//
//
//============================================================
//3. DELETION FROM FRONT (deleteFront)
//============================================================
//
//Initially:
//
//     front                         rear
//       |                             |
//       v                             v
//     [10] <-----> [20] <-----> [30]
//
//We want to delete the front element (10).
//
//Steps:
//
//1. Store front.data in removedElement.
//
//2. Check if front == rear.
// If true, only one node is present.
// Set front = rear = null.
//
//3. Otherwise, front = front.next
// Front pointer ko next node par move kar denge.
//
//4. front.previous = null
// New front ka previous null kar denge.
//
//After Deletion:
//
//     front                rear
//       |                    |
//       v                    v
//     [20] <-----> [30]
//
//Time Complexity: O(1)
//
//
//============================================================
//4. DELETION FROM REAR (deleteRear)
//============================================================
//
//Initially:
//
//     front                         rear
//       |                             |
//       v                             v
//     [10] <-----> [20] <-----> [30]
//
//We want to delete the rear element (30).
//
//Steps:
//
//1. Store rear.data in removedElement.
//
//2. Check if front == rear.
// If true, only one node is present.
// Set front = rear = null.
//
//3. Otherwise, rear = rear.previous
// Rear pointer ko previous node par move kar denge.
//
//4. rear.next = null
// New rear ka next null kar denge.
//
//After Deletion:
//
//     front                rear
//       |                    |
//       v                    v
//     [10] <-----> [20]
//
//Time Complexity: O(1)
//
//
//============================================================
//IMPORTANT CONDITIONS
//============================================================
//
//front == null
//Means Deque is empty.
//
//front == rear
//Means only one node is present.
//
//front = rear = newNode
//Used when inserting the first node.
//
//front = front.next
//Used to move front forward.
//
//rear = rear.previous
//Used to move rear backward.
//
//============================================================
//TIME COMPLEXITY
//============================================================
//
//addFront()       : O(1)
//addRear()        : O(1)
//deleteFront()    : O(1)
//deleteRear()     : O(1)
//getFrontPeek()   : O(1)
//getRearPeek()    : O(1)
//display()        : O(n)
//
//============================================================
public class P8_DequeImplementationUsgDoublyLinkedList {

	//============================================================
	// Node Class: To create a node of Doubly Linked List
	//============================================================

	class Node {

		int data;
		Node next;
		Node previous;

		Node(int data) {

			this.data = data;
			this.next = null;
			this.previous = null;
		}
	}

	Node front;
	Node rear;


	//============================================================
	// Deque Using Doubly Linked List:
	//
	// Deque stands for Double Ended Queue.
	// In Deque, insertion and deletion can be performed
	// from both ends (Front and Rear).
	//
	// Doubly Linked List contains three parts:
	// 1. Previous: Stores address of previous node.
	// 2. Data: Stores the actual element.
	// 3. Next: Stores address of next node.
	//
	// Front: Points to the first node.
	// Rear: Points to the last node.
	//
	// Insertion and deletion from both ends takes O(1).
	//============================================================


	//============================================================
	// Add Front Method: To insert an element at the front.
	// Time Complexity: O(1)
	//============================================================

	void addFront(int element) {

		Node newNode = new Node(element);

		// If Deque is empty, both front and rear point to new node.
		if (front == null) {

			front = rear = newNode;
		}

		// If Deque is not empty, insert new node before front.
		else {

			newNode.next = front;
			front.previous = newNode;

			front = newNode;
		}
	}


	//============================================================
	// Add Rear Method: To insert an element at the rear.
	// Time Complexity: O(1)
	//============================================================

	void addRear(int element) {

		Node newNode = new Node(element);

		// If Deque is empty, both front and rear point to new node.
		if (front == null) {

			front = rear = newNode;
		}

		// If Deque is not empty, insert new node after rear.
		else {

			newNode.previous = rear;
			rear.next = newNode;

			rear = newNode;
		}
	}


	//============================================================
	// Delete Front Method: To delete an element from the front.
	// Time Complexity: O(1)
	//============================================================

	int deleteFront() {

		// If Deque is empty, deletion is not possible.
		if (front == null) {

			System.out.println("Deque is empty");
			return -1;
		}

		int removedElement = front.data;

		// If only one node is present, make both pointers null.
		if (front == rear) {

			front = rear = null;
		}

		// If multiple nodes are present, move front to next node.
		else {

			front = front.next;
			front.previous = null;
		}

		return removedElement;
	}


	//============================================================
	// Delete Rear Method: To delete an element from the rear.
	// Time Complexity: O(1)
	//============================================================

	int deleteRear() {

		// If Deque is empty, deletion is not possible.
		if (front == null) {

			System.out.println("Deque is empty");
			return -1;
		}

		int removedElement = rear.data;

		// If only one node is present, make both pointers null.
		if (front == rear) {

			front = rear = null;
		}

		// If multiple nodes are present, move rear to previous node.
		else {

			rear = rear.previous;
			rear.next = null;
		}

		return removedElement;
	}


	//============================================================
	// Get Front Peek Method: To get the front element.
	// Time Complexity: O(1)
	//============================================================

	int getFrontPeek() {

		// If Deque is empty, no front element is available.
		if (front == null) {

			System.out.println("Deque is empty");
			return -1;
		}

		return front.data;
	}


	//============================================================
	// Get Rear Peek Method: To get the rear element.
	// Time Complexity: O(1)
	//============================================================

	int getRearPeek() {

		// If Deque is empty, no rear element is available.
		if (front == null) {

			System.out.println("Deque is empty");
			return -1;
		}

		return rear.data;
	}


	//============================================================
	// Display Method: To display all elements of Deque.
	// Time Complexity: O(n)
	//============================================================

	void display() {

		// If Deque is empty, there are no elements to display.
		if (front == null) {

			System.out.println("Deque is empty");
			return;
		}

		Node temp = front;

		// Traverse from front to rear and print every node.
		while (temp != null) {

			System.out.print(temp.data + " ");

			temp = temp.next;
		}

		System.out.println();
	}
}
