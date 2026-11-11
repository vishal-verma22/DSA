
package Lec13_LinkedList_And_its_Implementions;

public class SinglyLinkedList {

	// Node class: Represents an individual node

	private class Node {

		int data;       // Stores the actual value
		Node next;      // Stores the reference of the next node

		// Constructor to initialize a new node
		Node(int data) {

			this.data = data;
			this.next = null;
		}
	}

	private Node head = null; // Stores the reference of the first node
	private Node tail = null; // Stores the reference of the last node

	private int size = 0; // Stores the total number of nodes


	// =================================================================================================
	// Add method - To insert a new node at the end of the Linked List
	// =================================================================================================

	public void add(int element) {

		Node newNode = new Node(element);

		// Check whether the Linked List is empty(koi node hai ki nhi linkedlist me)
		if(head == null) {

			head = newNode;
			tail = newNode;

			size++; // Increase size after inserting a node
			return;
		}

		// Connect the previous last node to the new node
		tail.next = newNode;

		// Update tail to point to the new last node
		tail = newNode;

		size++; // Increase size after inserting a node
	}


	// =================================================================================================
	// AddFirst method - To insert a new node at the beginning of the Linked List
	// =================================================================================================

	public void addFirst(int element) {

		Node newNode = new Node(element);

		// Check whether the Linked List is empty
		if(head == null) {

			head = newNode;
			tail = newNode;

			size++; // Increase size after inserting a node
			return;
		}

		// Connect the new node to the current first node
		newNode.next = head;

		// Update head to point to the new first node
		head = newNode;

		size++; // Increase size after inserting a node
	}


	// =================================================================================================
	// AddLast method - To insert a new node at the end of the Linked List
	// =================================================================================================

	public void addLast(int element) {

		add(element);
	}


	// =================================================================================================
	// AddAtIndexPosition method - To insert a node at a particular index position
	// of the Linked List
	// =================================================================================================

	public void addAtIndexPosition(int index, int element) {

		// Check whether index is negative or greater than size
		if(index < 0 || index > size) {

			throw new IndexOutOfBoundsException("Invalid index position");
		}

		// If index is 0, insert the node at the beginning
		if(index == 0) {

			addFirst(element);
			return;
		}

		// If index is equal to size, insert the node at the end
		if(index == size) {

			addLast(element);
			return;
		}

		Node newNode = new Node(element);
		Node tempNode = head;

		// Traverse to the node just before the required index
		for(int i = 0; i < index-1; i++) {

			tempNode = tempNode.next;
		}

		// Connect the new node to the next node
		newNode.next = tempNode.next;

		// Connect the previous node to the new node
		tempNode.next = newNode;

		size++; // Increase size after inserting a node
	}


	// =================================================================================================
	// Show method - To display all elements of the Linked List
	// =================================================================================================

	public void show() {

		// Create a temporary reference starting from the first node
		Node temp = head;

		// Traverse until temp becomes null
		while(temp != null) {

			System.out.print(temp.data + " ");

			// Move temp to the next node
			temp = temp.next;
		}

		System.out.println();
	}


	// =================================================================================================
	// RemoveLast method - To remove the last node from the Linked List
	// =================================================================================================

	public int removeLast() {

		// Check whether the Linked List is empty
		if(head == null) {

			throw new RuntimeException("List is empty");
		}

		int removedElement = tail.data;

		// Check whether only one node exists
		if(head == tail) {

			head = tail = null;

			size--; // Decrease size after removing a node
			return removedElement;
		}

		Node tempNode = head;

		// Traverse until tempNode reaches the second-last node
		while(tempNode.next != tail) {

			tempNode = tempNode.next;
		}

		// Disconnect the last node
		tempNode.next = null;

		// Update tail to the new last node
		tail = tempNode;

		size--; // Decrease size after removing a node

		return removedElement;
	}


	// =================================================================================================
	// RemoveFirst method - To remove the first node from the Linked List
	// =================================================================================================

	public int removeFirst() {

		// Check whether the Linked List is empty
		if(head == null) {

			throw new RuntimeException("List is empty");
		}

		int removedElement = head.data;

		// Check whether only one node exists
		if(head == tail) {

			head = tail = null;

			size--; // Decrease size after removing a node
			return removedElement;
		}

		// Move head to the second node
		head = head.next;

		size--; // Decrease size after removing a node

		return removedElement;
	}


	// =================================================================================================
	// Remove method - To remove the last node from the Linked List
	// =================================================================================================

	public int remove() {

		return removeLast();
	}


	// =================================================================================================
	// RemoveAtIndexPosition method - To remove a node from a particular index
	// position of the Linked List
	// =================================================================================================

	public int removeAtIndexPosition(int index) {

		// Check whether index is negative or outside the valid range
		if(index < 0 || index >= size) {

			throw new IndexOutOfBoundsException("Invalid index position");
		}

		// If index is 0, remove the first node
		if(index == 0) {

			return removeFirst();
		}

		// If index is the last position, remove the last node
		if(index == size-1) {

			return removeLast();
		}

		Node tempNode = head;

		// Traverse to the node just before the required index
		for(int i = 0; i < index-1; i++) {

			tempNode = tempNode.next;
		}

		// Store the data of the node that needs to be removed
		int removedElement = tempNode.next.data;

		// Skip the node that needs to be removed
		tempNode.next = tempNode.next.next;

		size--; // Decrease size after removing a node

		return removedElement;
	}


	// =================================================================================================
	// GetFirst method - To return the first element from the Linked List
	// =================================================================================================

	public int getFirst() {

		// Check whether the Linked List is empty
		if(head == null) {

			throw new RuntimeException("List is empty");
		}

		return head.data;
	}


	// =================================================================================================
	// GetLast method - To return the last element from the Linked List
	// =================================================================================================

	public int getLast() {

		// Check whether the Linked List is empty
		if(tail == null) {

			throw new RuntimeException("List is empty");
		}

		return tail.data;
	}


	// =================================================================================================
	// GetAtIndexPosition method - To return an element from a particular index
	// position of the Linked List
	// =================================================================================================

	public int getAtIndexPosition(int index) {

		// Check whether index is negative or outside the valid range
		if(index < 0 || index >= size) {

			throw new IndexOutOfBoundsException("Invalid index position");
		}

		Node tempNode = head;

		// Traverse to the required index
		for(int i = 0; i < index; i++) {

			tempNode = tempNode.next;
		}

		return tempNode.data;
	}


	// =================================================================================================
	// Size method - To return the total number of nodes in the Linked List
	// =================================================================================================

	public int size() {

		return size;
	}


	// =================================================================================================
	// IsEmpty method - To check whether the Linked List is empty or not
	// =================================================================================================

	public boolean isEmpty() {

		// If size is 0, the Linked List is empty
		return size == 0;
	}


	// =================================================================================================
	// Clear method - To remove all nodes from the Linked List
	// =================================================================================================

	public void clear() {

		// Remove all node references
		head = tail = null;

		// Reset size because the Linked List is now empty
		size = 0;
	}


	// =================================================================================================
	// Contains method - To check whether a particular element exists in the
	// Linked List or not
	// =================================================================================================

	public boolean contains(int element) {

		Node tempNode = head;

		// Traverse until tempNode becomes null
		while(tempNode != null) {

			// Check whether the current node contains the required element
			if(tempNode.data == element) {

				return true;
			}

			// Move to the next node
			tempNode = tempNode.next;
		}

		// Element was not found in the Linked List
		return false;
	}

}
