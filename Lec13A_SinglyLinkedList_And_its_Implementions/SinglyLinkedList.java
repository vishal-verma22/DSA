
package Lec13A_SinglyLinkedList_And_its_Implementions;

public class SinglyLinkedList {

    // Node class: Represents an individual node
    private class Node {

        int data;       // Stores the actual value
        Node next;      // Stores the reference of the next node

        // Constructor to initialize a new node
        Node(int data) {

            this.data = data;
            this.next = null;  // Initially, next is null because no next node is connected
        }
    }

    private Node head = null;  // Stores the reference of the first node
    private Node tail = null;  // Stores the reference of the last node


    // Add method: To insert a new node at the end of the Linked List
    public void add(int element) {

        // Create a new node and initialize it with the given element
        Node newNode = new Node(element);

        // Check whether the Linked List is empty
        if (head == null) {

            head = newNode;  // Head points to the first node
            tail = newNode;  // Tail also points to the first node

            return;  // Exit the method after adding the first node
        }

        // Connect the previous last node to the new node
        tail.next = newNode;

        // Update tail to point to the new last node
        tail = newNode;
    }


    // Show method: To display all elements of the Linked List
    void show() {

        // Create a temporary reference starting from the first node
        Node temp = head;

        // Traverse the Linked List until temp becomes null
        while (temp != null) {

            System.out.print(temp.data + " ");

            // Move temp to the next node
            temp = temp.next;
        }

        System.out.println();  // Move to the next line after displaying all nodes
    }
}
