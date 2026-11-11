
package Lec13A_LinkedList_And_its_Implementions;

public class CircularSinglyLinkedList {

	//=============================================================
	// Node Class
	//=============================================================

	class Node {

		int data;
		Node next;

		public Node(int data) {

			this.data = data;
			this.next = null;

		}

	}

	Node head = null;
	Node tail = null;
	int size = 0;


	//=============================================================
	// Add method
	// Time Complexity: O(1)
	// Space Complexity: O(1)
	//=============================================================

	public void add(int element) {

		Node newNode = new Node(element);

		// If list is empty, make newNode both head and tail
		if (head == null) {

			head = tail = newNode;

			tail.next = head; // First node points to itself

			size++;

			return;

		}

		// Connect old tail to the new node
		tail.next = newNode;

		// Update tail to the new node
		tail = newNode;

		// Maintain circular connection
		tail.next = head;

		size++;

	}


	//=============================================================
	// AddFirst method
	// Time Complexity: O(1)
	// Space Complexity: O(1)
	//=============================================================

	public void addFirst(int element) {

		Node newNode = new Node(element);

		// If list is empty, make newNode both head and tail
		if (head == null) {

			head = tail = newNode;

			tail.next = head;

			size++;

			return;

		}

		// Connect new node to the current first node
		newNode.next = head;

		// Update head to the new node
		head = newNode;

		// Maintain circular connection
		tail.next = head;

		size++;

	}


	//=============================================================
	// AddLast method
	// Time Complexity: O(1)
	// Space Complexity: O(1)
	//=============================================================

	public void addLast(int element) {

		// Call add method to insert element at the end
		add(element);

		return;

	}


	//=============================================================
	// Size method
	// Time Complexity: O(1)
	// Space Complexity: O(1)
	//=============================================================

	public int size() {

		return size;

	}


	//=============================================================
	// IsEmpty method
	// Time Complexity: O(1)
	// Space Complexity: O(1)
	//=============================================================

	public Boolean isEmpty() {

		// Return true if size is 0, otherwise false
		return size == 0;

	}


	//=============================================================
	// AddAtIndexPosition method
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	//=============================================================

	public void addAtIndexPosition(int index, int element) {

		// Check whether index is within the valid insertion range
		if (index < 0 || index > size) {

			throw new RuntimeException("Invalid index position");

		}

		Node newNode = new Node(element);

		// If index is 0, insert at the beginning
		if (index == 0) {

			addFirst(element);

			return;

		}

		// If index is equal to size, insert at the end
		if (index == size) {

			addLast(element);

			return;

		}

		Node tempNode = head;

		// Traverse until the node before the given index
		for (int i = 0; i < index - 1; i++) {

			tempNode = tempNode.next;

		}

		// Connect new node to the next node
		newNode.next = tempNode.next;

		// Connect previous node to the new node
		tempNode.next = newNode;

		size++;

	}


	//=============================================================
	// Display method
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	//=============================================================

	public void display() {

		// Check whether list is empty
		if (head == null) {

			System.out.println("List is empty");

			return;

		}

		Node tempNode = head;

		// Execute at least once and traverse until head is reached again
		do {

			System.out.print(tempNode.data + " ");

			// Move tempNode to the next node
			tempNode = tempNode.next;

		} while (tempNode != head);

		System.out.println();

	}


	//=============================================================
	// GetFirst method
	// Time Complexity: O(1)
	// Space Complexity: O(1)
	//=============================================================

	public int getFirst() {

		// Check whether list is empty
		if (head == null) {

			throw new RuntimeException("List is empty");

		}

		// Return first node's data
		return head.data;

	}


	//=============================================================
	// GetLast method
	// Time Complexity: O(1)
	// Space Complexity: O(1)
	//=============================================================

	public int getLast() {

		// Check whether list is empty
		if (tail == null) {

			throw new RuntimeException("List is empty");

		}

		// Return last node's data
		return tail.data;

	}


	//=============================================================
	// GetAtIndexPositionData method
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	//=============================================================

	public int getAtIndexPositionData(int index) {

		// Check whether list is empty
		if (head == null) {

			throw new RuntimeException("List is empty");

		}

		// Check whether index is within the valid range
		if (index < 0 || index >= size) {

			throw new RuntimeException("Invalid index position");

		}

		// If index is 0, return first node's data
		if (index == 0) {

			return getFirst();

		}

		// If index is size - 1, return last node's data
		if (index == size - 1) {

			return getLast();

		}

		Node tempNode = head;

		// Traverse until the required index position
		if (index < size) {

			for (int i = 0; i < index; i++) {

				tempNode = tempNode.next;

			}

			return tempNode.data;

		} else {

			throw new RuntimeException("invalid index position");

		}

	}


	//=============================================================
	// Clear method
	// Time Complexity: O(1)
	// Space Complexity: O(1)
	//=============================================================

	public void clear() {

		// Remove references to all nodes
		head = tail = null;

		// Reset size to 0
		size = 0;

	}


	//=============================================================
	// RemoveFirst method
	// Time Complexity: O(1)
	// Space Complexity: O(1)
	//=============================================================

	public int removeFirst() {

		// Check whether list is empty
		if (head == null) {

			throw new RuntimeException("List is empty");

		}

		// Store first node's data before removing it
		int removedElement = head.data;

		// If only one node exists
		if (head == tail) {

			head = tail = null;

		} else {

			// Move head to the next node
			head = head.next;

			// Maintain circular connection
			tail.next = head;

		}

		size--;

		// Return removed element
		return removedElement;

	}


	//=============================================================
	// RemoveLast method
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	//=============================================================

	public int removeLast() {

		// Check whether list is empty
		if (tail == null || head == null) {

			throw new RuntimeException("List is empty");

		}

		// Store last node's data before removing it
		int removedElement = tail.data;

		// If only one node exists
		if (head == tail) {

			head = tail = null;

			size--;

			return removedElement;

		}

		Node tempNode = head;

		// Traverse until the second-last node
		while (tempNode.next != tail) {

			tempNode = tempNode.next;

		}

		// Connect second-last node back to head
		tempNode.next = head;

		// Update tail to the second-last node
		tail = tempNode;

		size--;

		// Return removed element
		return removedElement;

	}


	/*
	 *
	 *
	 * // Way 1 : using tempNode
	 *
	 * public int removeLast()
	 * {
	 *     if(tail == null)
	 *     {
	 *         throw new RuntimeException("List is empty");
	 *     }
	 *
	 *     int removedData = tail.data;
	 *
	 *     if(head == tail)
	 *     {
	 *         head = tail = null;
	 *     }
	 *     else
	 *     {
	 *         Node tempNode = head;
	 *
	 *         for(int i=0; i<size-2; i++)
	 *         {
	 *             tempNode = tempNode.next;
	 *         }
	 *
	 *         tail = tempNode;
	 *         tail.next = head;
	 *     }
	 *
	 *     size--;
	 *
	 *     return removedData;
	 * }
	 *
	 *
	 *
	 *
	 * // Way 2 : using only tail
	 *
	 * public int removeLast()
	 * {
	 *     if(tail == null)
	 *     {
	 *         throw new RuntimeException("List is empty");
	 *     }
	 *
	 *     int removedData = tail.data;
	 *
	 *     if(head == tail)
	 *     {
	 *         return removeFirst();
	 *     }
	 *
	 *     tail = head;
	 *
	 *     for(int i=0; i<size-2; i++)
	 *     {
	 *         tail = tail.next;
	 *     }
	 *
	 *     tail.next = head;
	 *
	 *     size--;
	 *
	 *     return removedData;
	 * }
	 *
	 *
	 *
	 *
	 */


	//=============================================================
	// RemoveAtIndexPosition method
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	//=============================================================

	public int removeAtIndexPosition(int index) {

		// Check whether index is within the valid range
		if (index < 0 || index >= size) {

			throw new IndexOutOfBoundsException("Invalid index position");

		}

		// If index is 0, remove first node
		if (index == 0) {

			return removeFirst();

		}

		// If index is size - 1, remove last node
		if (index == size - 1) {

			return removeLast();

		}

		Node tempNode = head;

		// Traverse until the node before the given index
		for (int i = 0; i < index - 1; i++) {

			tempNode = tempNode.next;

		}

		// Store data of the node to be removed
		int removedData = tempNode.next.data;

		// Connect previous node to the node after the removed node
		tempNode.next = tempNode.next.next;

		size--;

		// Return removed element
		return removedData;

	}


	//=============================================================
	// Index Of Method
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	//=============================================================

	public int indexOf(int sData) {

		Node tempNode = head;

		// Traverse each node using size
		for (int i = 0; i < size; i++)

		{

			// Check whether current node's data matches given data
			if (tempNode.data == sData)

			{

				return i;

			}

			// Move tempNode to the next node
			tempNode = tempNode.next;

		}

		// Return -1 if element is not found
		return -1;

	}


	/*
	 *
	 * //=============================================================
	 * // Index Of Method
	 * //=============================================================
	 *
	 * public int indexOf(int sData) {
	 *
	 *     if (head == null) {
	 *
	 *         return -1;
	 *
	 *     }
	 *
	 *     Node tempNode = head;
	 *
	 *     int index = 0;
	 *
	 *     do {
	 *
	 *         if (tempNode.data == sData) {
	 *
	 *             return index;
	 *
	 *         }
	 *
	 *         tempNode = tempNode.next;
	 *
	 *         index++;
	 *
	 *     } while (tempNode != head);
	 *
	 *     return -1;
	 *
	 * }
	 *
	 */


	//=============================================================
	// Contains method
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	//=============================================================

	public boolean contains(int sData) {

		// If indexOf returns -1, element does not exist
		return indexOf(sData) != -1;

	}

}
