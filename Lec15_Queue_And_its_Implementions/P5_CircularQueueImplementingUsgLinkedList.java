
/*
 *============================================================
 * Circular Queue Implementation using Singly LinkedList
 *============================================================
 *
 * 1. Circular Queue follows FIFO (First In First Out).
 *
 * 2. Insertion takes place from REAR.
 *
 * 3. Deletion takes place from FRONT.
 *
 * 4. FRONT points to the first Node.
 *
 * 5. REAR points to the last Node.
 *
 * 6. In Circular Queue, the last Node points back to FRONT.
 *
 * 7. Unlike Simple Queue, the last Node next is not null.
 *
 *============================================================
 * Diagram: Circular Queue
 *============================================================
 *
 *             FRONT                  REAR
 *               |                      |
 *               v                      v
 *             [10] ---> [20] ---> [30]
 *               ^                   |
 *               |___________________|
 *
 *============================================================
 * 8. Node Structure
 *============================================================
 *
 * Each Node contains two parts:
 *
 *      [ data | next ]
 *
 * data - Stores the element.
 * next - Points to the next Node.
 *
 *============================================================
 * 9. Offer Operation (Insertion)
 *============================================================
 *
 * - Creates a new Node.
 * - If Queue is empty:
 *       FRONT = REAR = newNode
 *       REAR.next = FRONT
 *
 * - Otherwise:
 *       REAR.next = newNode
 *       REAR = newNode
 *       REAR.next = FRONT
 *
 * Example:
 *
 * Before offer(40):
 *
 *       FRONT              REAR
 *         |                  |
 *         v                  v
 *       [10] ---> [20] ---> [30]
 *         ^                   |
 *         |___________________|
 *
 * After offer(40):
 *
 *       FRONT                        REAR
 *         |                            |
 *         v                            v
 *       [10] ---> [20] ---> [30] ---> [40]
 *         ^                            |
 *         |____________________________|
 *
 *============================================================
 * 10. Poll Operation (Deletion)
 *============================================================
 *
 * - Removes the element from FRONT.
 *
 * - If only one Node is present:
 *       FRONT = REAR = null
 *
 * - Otherwise:
 *       FRONT = FRONT.next
 *       REAR.next = FRONT
 *
 * Example:
 *
 * Before poll():
 *
 *       FRONT                        REAR
 *         |                            |
 *         v                            v
 *       [10] ---> [20] ---> [30] ---> [40]
 *         ^                            |
 *         |____________________________|
 *
 * After poll():
 *
 *                 FRONT              REAR
 *                   |                  |
 *                   v                  v
 *       [20] ---> [30] ---> [40]
 *         ^                   |
 *         |___________________|
 *
 * Removed Element = 10
 *
 *============================================================
 * 11. Peek Operation
 *============================================================
 *
 * - Returns the FRONT element.
 * - Does not remove the element.
 *
 *============================================================
 * 12. Display Operation
 *============================================================
 *
 * - Starts from FRONT.
 * - Moves to the next Node.
 * - Stops when tempNode reaches FRONT again.
 *
 * - Uses do-while loop because the last Node points back
 *   to FRONT instead of null.
 *
 *============================================================
 * 13. Time Complexity
 *============================================================
 *
 * offer()  - O(1)
 * poll()   - O(1)
 * peek()   - O(1)
 * display()- O(n)
 *
 *============================================================
 */


package Lec15_Queue_And_its_Implementions;

public class P5_CircularQueueImplementingUsgLinkedList {

    //============================================================
    // Node Class
    //============================================================

    private class Node {

        private int data;
        private Node next;

        Node(int data) {
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

    public void offer(int data) {

        Node newNode = new Node(data);

        if (front == null) {

            front = rear = newNode;
            rear.next = front;

        } else {

            rear.next = newNode;
            rear = newNode;
            rear.next = front;
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

        if (front == rear) {

            front = rear = null;

        } else {

            front = front.next;
            rear.next = front;
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
    // Display Method: To display all elements of Queue
    // Time Complexity: O(n)
    //============================================================

    public void display() {

        if (front == null) {
            System.out.println("Queue is Empty");
            return;
        }

        Node tempNode = front;

        do {

            System.out.print(tempNode.data + " ");

            tempNode = tempNode.next;

        } while (tempNode != front);

        System.out.println();
    }
}
