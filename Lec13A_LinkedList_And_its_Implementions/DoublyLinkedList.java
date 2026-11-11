
package Lec13A_LinkedList_And_its_Implementions;

public class DoublyLinkedList {


	// class for creating node 

	public class Node {

		int data;

		Node previous;

		Node next;

		Node(int data) {

			this.data = data;
			this.previous = null;
			this.next = null;

		}

	}


	Node head = null;

	Node tail = null;

	private int size = 0;


	//===================================================================
	// Add Method: To add elements at the end of the Doubly Linked List
	// Time Complexity: O(1)
	//===================================================================

	public void add(int element) {

		Node newNode = new Node(element);

		// when no node exists in the linked list
		if (head == null) {

			head = newNode;
			tail = newNode;

			size++;
			return;
		}

		// Connect current last node with new node
		tail.next = newNode;

		// Connect new node with current last node
		newNode.previous = tail;

		// Update tail to the new last node
		tail = newNode;

		size++;

	}


	//==================================================================================
	// AddFirst Method: To add an element at the beginning of the Doubly Linked List
	// Time Complexity: O(1)
	//==================================================================================

	public void addFirst(int element) {

		Node newNode = new Node(element);

		// when no node exists in the linked list
		if (head == null) {

			head = newNode;
			tail = newNode;

			size++;
			return;
		}

		// Connect current head's previous with new node
		head.previous = newNode;

		// Connect new node with current head
		newNode.next = head;

		// Update head to the new first node
		head = newNode;

		size++;

	}


	//==================================================================================
	// AddLast Method: To add an element at the end of the Doubly Linked List
	// Time Complexity: O(1)
	//==================================================================================

	public void addLast(int element) {

		add(element);

	}


	//==================================================================================
	// AddAtIndex Method: To add an element at a specific index position
	// Time Complexity: O(n)
	//==================================================================================

	public void addAtIndexPosition(int index, int element) {

		// Check whether index is valid or not
		if (index < 0 || index > size) {

			throw new RuntimeException("Invalid index position");

		}


		// If index is 0, add element at the beginning
		if (index == 0) {

			addFirst(element);
			return;

		}


		// If index is equal to size, add element at the end
		if (index == size) {

			addLast(element);
			return;

		}


		Node newNode = new Node(element);

		Node tempNode = head;

		// Reach the node just before the given index
		for (int i = 0; i < index - 1; i++) {

			tempNode = tempNode.next;

		}

		// Always try to fill the next and previous node value in new node first, it makes easy

		newNode.previous = tempNode;

		newNode.next = tempNode.next;

		tempNode.next.previous = newNode;

		tempNode.next = newNode;

		size++;

	}


	//==================================================================================
	// Display Method: To display all elements in forward direction
	// Time Complexity: O(n)
	//==================================================================================

	public void displayForward() {

		Node tempNode = head;

		while (tempNode != null) {

			System.out.print(tempNode.data + " ");

			// Move to the next node
			tempNode = tempNode.next;

		}

		System.out.println();

	}


	//==================================================================================
	// DisplayReverse Method: To display all elements in backward direction
	// Time Complexity: O(n)
	//==================================================================================

	public void displayBackward() {

		Node tempNode = tail;

		while (tempNode != null) {

			System.out.print(tempNode.data + " ");

			// Move to the previous node
			tempNode = tempNode.previous;

		}

		System.out.println();

	}


	//=============================================
	// Get Method: To get an element from a specific index position
	// Time Complexity: O(n)
	//=============================================

	public int get(int index) {

		// Check whether index is valid or not
		if (index < 0 || index >= size) {

			throw new RuntimeException("Invalid index position");

		}

		Node tempNode = head;

		// Reach the node at the given index
		for (int i = 0; i < index; i++) {

			tempNode = tempNode.next;

		}

		return tempNode.data;

	}


	//=============================================================================
	// RemoveFirst Method: To remove the first element from the Doubly Linked List
	// Time Complexity: O(1)
	//=============================================================================

	public int removeFirst() {

		// Check whether linked list is empty
		if (head == null) {

			throw new RuntimeException("Linked List is empty");

		}

		int removedElement = head.data;

		// Move head to the next node
		head = head.next;

		// If head becomes null, it means only one node was present
		if (head == null) {

			tail = null;

		}
		else {

			// Remove previous reference of the new head
			head.previous = null;

		}

		size--;

		return removedElement;

	}


	//=============================================================================
	// RemoveLast Method: To remove the last element from the Doubly Linked List
	// Time Complexity: O(1)
	//=============================================================================

	public int removeLast() {

		// Check whether linked list is empty
		if (tail == null) {

			throw new RuntimeException("Linked List is empty");

		}

		int removedElement = tail.data;

		// Move tail to the previous node
		tail = tail.previous;

		// If tail becomes null, it means only one node was present
		if (tail == null) {

			head = null;

		}
		else {

			// Remove next reference of the new tail
			tail.next = null;

		}

		size--;

		return removedElement;

	}


	//==================================================================================
	// RemoveAtIndex Method: To remove an element from a specific index position
	// Time Complexity: O(n)
	//==================================================================================

	public int removeAtIndexPosition(int index) {

		// Check whether index is valid
		if (index < 0 || index >= size) {

			throw new RuntimeException("Invalid index position");

		}

		// Remove first node
		if (index == 0) {

			return removeFirst();

		}

		// Remove last node
		if (index == size - 1) {

			return removeLast();

		}

		// Create temporary reference to reach the required node
		Node tempNode = head;

		// Reach the node at the given index
		for (int i = 0; i < index; i++) {

			tempNode = tempNode.next;

		}

		// Store the data of node which we want to remove
		int removedElement = tempNode.data;

		// Connect previous node with next node
		tempNode.previous.next = tempNode.next;

		// Connect next node with previous node
		tempNode.next.previous = tempNode.previous;

		// Decrease size
		size--;

		return removedElement;

	}


	//=============================================================================
	// Contains Method: To check whether a particular element is present in the Doubly Linked List
	// Time Complexity: O(n)
	//=============================================================================

	public Boolean contains(int element) {

		Node tempNode = head;

		while (tempNode != null) {

			// Check whether current node data matches the given element
			if (tempNode.data == element) {

				return true;

			}

			// Move to the next node
			tempNode = tempNode.next;

		}

		return false;

	}


	//=============================================================================
	// Size Method: To return the total number of elements in the Doubly Linked List
	// Time Complexity: O(1)
	//=============================================================================

	public int size() {

		return size;

	}


	//==================================================================================
	// IsEmpty Method: To check whether the Doubly Linked List is empty
	// Time Complexity: O(1)
	//==================================================================================

	public boolean isEmpty() {

		if (size == 0) {

			return true;

		}

		return false;

	}


	//==================================================================================
	// Set Method: To update an element at a specific index position
	// Time Complexity: O(n)
	//==================================================================================

	public void set(int index, int element) {

		// Check whether index is valid or not
		if (index < 0 || index >= size) {

			throw new RuntimeException("Invalid index position");

		}

		Node tempNode = head;

		// Reach the node at the given index
		for (int i = 0; i < index; i++) {

			tempNode = tempNode.next;

		}

		// Update the data of the node
		tempNode.data = element;

	}
	
	//=============================================================================
	// Clear Method: To remove all elements from the Doubly Linked List
	// Time Complexity: O(1)
	//=============================================================================

	public void clear() {

		head = null;
		tail = null;
		size = 0;

	}

}
