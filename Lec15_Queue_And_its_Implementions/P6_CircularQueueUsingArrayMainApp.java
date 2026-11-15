
package Lec15_Queue_And_its_Implementions;

public class P6_CircularQueueUsingArrayMainApp {

    public static void main(String args[]) {

        //============================================================
        // Creating Circular Queue with Capacity 5
        //============================================================

        P6_CircularQueueImplementingUsingArray queue =
                new P6_CircularQueueImplementingUsingArray(5);

        //============================================================
        // Offer Method: Adding Elements
        //============================================================

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);

        System.out.println("Circular Queue:");
        queue.display();

        //============================================================
        // Poll Method: Removing Elements
        //============================================================

        System.out.println("Removed Element: " + queue.poll());

        System.out.println("Removed Element: " + queue.poll());

        //============================================================
        // Offer Method: Adding Elements Again
        //============================================================

        queue.offer(50);
        queue.offer(60);

        System.out.println("Updated Circular Queue:");
        queue.display();

        //============================================================
        // Checking Queue Full Condition
        //============================================================

        queue.offer(70);

        //============================================================
        // Removing One More Element
        //============================================================

        System.out.println("Removed Element: " + queue.poll());

        System.out.println("Final Circular Queue:");
        queue.display();
    }
}
