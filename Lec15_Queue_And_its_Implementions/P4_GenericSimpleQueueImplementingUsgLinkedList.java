
/*
 * ============================================================
 * GENERIC SIMPLE QUEUE USING SINGLY LINKEDLIST
 * ============================================================
 *
 * THEORY:
 *
 * 1. Queue follows FIFO (First In First Out) principle.
 *
 * 2. Insertion is performed from the REAR.
 *
 * 3. Deletion is performed from the FRONT.
 *
 * 4. We use a normal Singly LinkedList to implement Queue.
 *
 * 5. This is a Generic Queue, so we can store different
 *    data types like Integer, String, Double, etc.
 *
 * 6. Each Node contains:
 *    - data: Stores the element.
 *    - next: Points to the next Node.
 *
 * 7. FRONT points to the first Node.
 *
 * 8. REAR points to the last Node.
 *
 * 9. The next of the last Node always points to NULL.
 *
 * 10. FRONT and REAR do not connect to each other.
 *     Both can point to the same Node when only one
 *     element is present in the Queue.
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
 * ============================================================
 * GENERIC CONCEPT:
 * ============================================================
 *
 * <T> represents the data type.
 *
 * Integer Queue : Queue<Integer>
 * String Queue  : Queue<String>
 * Double Queue  : Queue<Double>
 *
 * The same Queue class can store different data types.
 *
 * ============================================================
 * QUEUE OPERATIONS:
 * ============================================================
 *
 * offer(T data) : Adds an element at the REAR.
 *
 * poll()        : Removes and returns the FRONT element.
 *
 * peek()        : Returns the FRONT element without removing it.
 *
 * display()     : Displays all elements of the Queue.
 *
 * ============================================================
 * TIME COMPLEXITY:
 * ============================================================
 *
 * offer()  : O(1)
 * poll()   : O(1)
 * peek()   : O(1)
 * display(): O(n)
 *
 * ============================================================
 */


package Lec15_Queue_And_its_Implementions;


public class P4_GenericSimpleQueueImplementingUsgLinkedList<T> {

    //============================================================
    // Node Class
    //============================================================

    private class Node {
        private T data;
        private Node next;

        Node(T data) {
            this.data = data;
            next = null;
        }
    }

    //============================================================
    // FRONT and REAR References
    //============================================================

    private Node front = null;
    private Node rear = null;

    //============================================================
    // Offer Method: To add an element at the REAR of Queue
    // Time Complexity: O(1)
    //============================================================

    public void offer(T data) {

        Node newNode = new Node(data);

        if (front == null) {

            front = rear = newNode;

        } else {

            rear.next = newNode;
            rear = newNode;
        }
    }

    //============================================================
    // Poll Method: To remove an element from the FRONT of Queue
    // Time Complexity: O(1)
    //============================================================

    public T poll() {

        if (front == null) {
            throw new RuntimeException("Queue is Empty");
        }

        T removedElement = front.data;

        if (front == rear) {

            front = rear = null;

        } else {

            front = front.next;
        }

        return removedElement;
    }

    //============================================================
    // Peek Method: To get the FRONT element without removing it
    // Time Complexity: O(1)
    //============================================================

    public T peek() {

        if (front == null) {
            throw new RuntimeException("Queue is Empty");
        }

        return front.data;
    }

    //============================================================
    // Display Method: To display all elements of Queue
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
