

package Lec15_Queue_And_its_Implementions;

public class P5_CircularQueueUsgLinkedListMainApp {

    public static void main(String args[]) {

        P5_CircularQueueImplementingUsgLinkedList queue =
                new P5_CircularQueueImplementingUsgLinkedList();

        //============================================================
        // Adding Elements
        //============================================================

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);

        System.out.println("Circular Queue:");
        queue.display();

        //============================================================
        // Removing Element
        //============================================================

        System.out.println("Removed Element: " + queue.poll());

        //============================================================
        // Getting FRONT Element
        //============================================================

        System.out.println("Front Element: " + queue.peek());

        //============================================================
        // Display Queue
        //============================================================

        queue.display();
    }
}
