
package Lec13_LinkedList_And_its_Implementions;

public class CircularDoublyLinkedList {

    class Node {

        int data;
        Node next;
        Node Previous;

        Node(int data) {

            this.data = data;
            this.next = null;
            this.Previous = null;
        }
    }

    Node head;
    Node tail;
    int size = 0;

    // ===================================================
    // Add method: To add elements at the end of the Circular Doubly Linked List
    // Time Complexity: O(1)
    // Space Complexity: O(1) Auxiliary Space
    // ===================================================

    public void add(int element) {

        Node newNode = new Node(element);

        // Condition: Check whether the list is empty
        if (head == null) {

            // First node becomes both head and tail
            head = tail = newNode;

            // Create circular connection
            head.next = tail;
            head.Previous = tail;

            size++;
            return;
        }

        // Connect new node with previous tail
        newNode.Previous = tail;

        // Connect new node with head to maintain circular connection
        newNode.next = head;

        // Connect previous tail with new node
        tail.next = newNode;

        // Update tail to point to the new node
        tail = newNode;

        // Update head's Previous to point to new tail
        head.Previous = newNode;

        size++;
    }

    // ===================================================
    // AddFirst method: To add elements at the beginning of the Circular Doubly Linked List
    // Time Complexity: O(1)
    // Space Complexity: O(1) Auxiliary Space
    // ===================================================

    public void addFirst(int element) {

        Node newNode = new Node(element);

        // Condition: Check whether the list is empty
        if (head == null) {

            // First node becomes both head and tail
            head = tail = newNode;

            // Create circular connection
            head.next = tail;
            head.Previous = tail;

            size++;
            return;
        }

        // Connect new node with current head
        newNode.next = head;

        // Connect current head back to new node
        head.Previous = newNode;

        // Update head to point to new node
        head = newNode;

        // Connect tail with new head to maintain circular connection
        tail.next = head;

        // Connect new head's Previous with tail
        newNode.Previous = tail;

        size++;
    }

    // ===================================================
    // AddLast method: To add elements at the end of the Circular Doubly Linked List
    // Time Complexity: O(1)
    // Space Complexity: O(1) Auxiliary Space
    // ===================================================

    public void addLast(int data) {

        // Reuse add method to insert element at the end
        add(data);
    }

    // ===================================================
    // AddAtIndexPosition method: To add elements at a specific index position
    // Time Complexity: O(n)
    // Space Complexity: O(1) Auxiliary Space
    // ===================================================

    public void addAtIndexPosition(int index, int element) {

        // Condition: Check whether index is invalid
        if (index < 0 || index > size) {

            throw new RuntimeException("Invalid index position");
        }

        Node newNode = new Node(element);

        // Condition: Check whether the list is empty
        if (head == null) {

            // First node becomes both head and tail
            head = tail = newNode;

            // Create circular connection
            head.next = tail;
            head.Previous = tail;

            size++;
            return;
        }

        // Condition: If index is 0, insert at the beginning
        if (index == 0) {

            addFirst(element);
            return;
        }

        // Condition: If index is equal to size, insert at the end
        if (index == size) {

            addLast(element);
            return;
        }

        // Create temporary reference to traverse the list
        Node tempNode = head;

        // Traverse until the node just before the required index
        for (int i = 0; i < index - 1; i++) {

            tempNode = tempNode.next;
        }

        // Connect new node with previous node
        newNode.Previous = tempNode;

        // Connect new node with next node
        newNode.next = tempNode.next;

        // Connect previous node with new node
        tempNode.next = newNode;

        // Update next node's Previous reference
        newNode.next.Previous = newNode;

        size++;
    }

    // ===================================================
    // getFirst method: To return the first element of the list
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // ===================================================

    public int getFirst() {

        // Condition: Check whether the list is empty
        if (head == null) {

            throw new RuntimeException("list is empty");
        }

        // Return data of the first node
        return head.data;
    }

    // ===================================================
    // getLast method: To return the last element of the list
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // ===================================================

    public int getLast() {

        // Condition: Check whether the list is empty
        if (head == null) {

            throw new RuntimeException("list is empty");
        }

        // Return data of the last node
        return tail.data;
    }

    // ===================================================
    // getAtIndexPosition method: To return element at a specific index position
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ===================================================

    public int getAtIndexPosition(int index) {

        // Condition: Check whether index is invalid
        if (index < 0 || index >= size) {

            throw new RuntimeException("Invalid index position");
        }

        // Start traversal from head
        Node tempNode = head;

        // Traverse until the required index is reached
        for (int i = 0; i < index; i++) {

            tempNode = tempNode.next;
        }

        // Return data of the required node
        return tempNode.data;
    }

    // ===================================================
    // getSize method: To return the total number of elements
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // ===================================================

    public int getSize() {

        // Return current size of the list
        return size;
    }

    // ===================================================
    // isEmpty method: To check whether the list is empty
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // ===================================================

    public Boolean isEmpty() {

        // Return true if size is 0, otherwise false
        return size == 0;
    }

    // ===================================================
    // display method: To display all elements of the list
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ===================================================

    void display() {

        // Condition: Check whether the list is empty
        if (head == null) {

            System.out.println("List is empty");
            return;
        }

        // Create temporary reference starting from head
        Node tempNode = head;

        // Traverse at least once because it is a circular list
        do {

            // Print data of current node
            System.out.print(tempNode.data + " ");

            // Move to the next node
            tempNode = tempNode.next;

        } while (tempNode != head); // Stop when traversal reaches head again

        System.out.println();
    }

    // ===================================================
    // remove method: To remove the last element of the Circular Doubly Linked List
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // ===================================================

    public int remove() {

        // Condition: Check whether the list is empty
        if (head == null) {

            throw new RuntimeException("list is empty");
        }

        // Store data of the last node before removing it
        int removedElement = tail.data;

        // Condition: Check whether the list contains only one node
        if (head == tail) {

            // Make both head and tail null
            head = tail = null;

            size = 0;

            return removedElement;
        }

        // Move tail to the previous node
        tail = tail.Previous;

        // Connect new tail with head
        tail.next = head;

        // Connect head's Previous with new tail
        head.Previous = tail;

        size--;

        return removedElement;
    }

    // ===================================================
    // removeFirst method: To remove the first element of the Circular Doubly Linked List
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // ===================================================

    public int removeFirst() {

        // Condition: Check whether the list is empty
        if (head == null) {

            throw new RuntimeException("list is empty");
        }

        // Store data of the first node before removing it
        int removedElement = head.data;

        // Condition: Check whether the list contains only one node
        if (head == tail) {

            // Make both head and tail null
            head = tail = null;

            size = 0;

            return removedElement;
        }

        // Move head to the next node
        head = head.next;

        // Connect new head's Previous with tail
        head.Previous = tail;

        // Connect tail's next with new head
        tail.next = head;

        size--;

        return removedElement;
    }

    // ===================================================
    // removeLast method: To remove the last element of the Circular Doubly Linked List
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // ===================================================

    public int removeLast() {

        // Reuse remove method to remove the last element
        return remove();
    }

    // ===================================================
    // removeAtIndexPosition method: To remove element at a specific index position
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ===================================================

    public int removeAtIndexPosition(int index) {

        // Condition: Check whether the list is empty
        if (head == null) {

            throw new RuntimeException("list is empty");
        }

        // Condition: Check whether index is invalid
        if (index < 0 || index >= size) {

            throw new RuntimeException("Invalid index position");
        }

        // Condition: If only one node exists or index is 0
        if (head == tail || index == 0) {

            return removeFirst();
        }

        // Condition: If index is the last index
        if (index == size - 1) {

            return removeLast();
        }

        // Start traversal from head
        Node tempNode = head;

        // Traverse until the required index is reached
        for (int i = 0; i < index; i++) {

            tempNode = tempNode.next;
        }

        // Store data of the node before removing it
        int removedElement = tempNode.data;

        // Connect previous node with next node
        tempNode.Previous.next = tempNode.next;

        // Connect next node's Previous with previous node
        tempNode.next.Previous = tempNode.Previous;

        size--;

        return removedElement;
    }

    // ===================================================
    // indexOf method: To find the index of a given element
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ===================================================

    public int indexOf(int searchData) {

        // Start traversal from head
        Node tempNode = head;

        // Traverse all nodes using size
        for (int i = 0; i < size; i++) {

            // Condition: Check whether current node contains searchData
            if (tempNode.data == searchData) {

                // Return index if element is found
                return i;
            }

            // Move to the next node
            tempNode = tempNode.next;
        }

        // Return -1 if element is not found
        return -1;
    }

    // ===================================================
    // contains method: To check whether an element exists in the list
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ===================================================

    public Boolean contains(int element) {

        // indexOf returns -1 if element is not present
        // Therefore, compare result with -1
        return indexOf(element) != -1;
    }

    // ===================================================
    // clear method: To remove all elements from the list
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // ===================================================

    public void clear() {

        // Remove references to all nodes
        head = tail = null;

        // Reset size because list is now empty
        size = 0;
    }

}
