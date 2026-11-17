package Lec15_Queue_And_its_Implementions;




import java.util.Queue;
import java.util.LinkedList;

public class P11_ImplementStackUsingOneQueue {

    /*
    =====================================================================
    CONCEPT: IMPLEMENT STACK USING ONE QUEUE
    =====================================================================

    Stack follows LIFO (Last In First Out).
    Queue follows FIFO (First In First Out).

    We use only one Queue to implement Stack operations.

    LOGIC:

    1. PUSH:
       - Insert the new element at the REAR using offer().
       - Find the current size of Queue.
       - Move all previous elements from FRONT to REAR.
       - This brings the newly inserted element to FRONT.

    2. POP:
       - Remove and return the FRONT element using poll().
       - FRONT always represents the TOP of Stack.

    3. TOP:
       - Return the FRONT element using peek().
       - Element is not removed.

    4. EMPTY:
       - Check whether Queue is empty using isEmpty().


    =====================================================================
    DIAGRAM: PUSH OPERATION
    =====================================================================

    Suppose we perform:

    push(10)
    push(20)
    push(30)


    STEP 1: push(10)

    FRONT
      |
     [10]
      |
     REAR

    Size = 1

    Loop runs 0 times.


    STEP 2: push(20)

    First insert 20 at REAR:

    FRONT
      |
     [10] -> [20]
               |
              REAR

    Size = 2

    Loop runs 1 time.

    poll() removes 10 from FRONT.
    offer(10) inserts 10 at REAR.

    FRONT
      |
     [20] -> [10]
               |
              REAR


    STEP 3: push(30)

    First insert 30 at REAR:

    FRONT
      |
     [20] -> [10] -> [30]
                       |
                      REAR

    Size = 3

    Loop runs 2 times.

    ITERATION 1:
    poll() removes 20.
    offer(20) inserts 20 at REAR.

    [10] -> [30] -> [20]

    ITERATION 2:
    poll() removes 10.
    offer(10) inserts 10 at REAR.

    FRONT
      |
     [30] -> [20] -> [10]
                       |
                      REAR


    FINAL QUEUE:

    FRONT = 30 (TOP of Stack)

    [30] -> [20] -> [10]

    =====================================================================
    IMPORTANT:
    =====================================================================

    Every time we push a new element, we move only the previous
    elements to the REAR.

    The newly inserted element comes to the FRONT.

    Therefore, Queue FRONT always represents Stack TOP.


    =====================================================================
    TIME AND SPACE COMPLEXITY:
    =====================================================================

    Push  -> O(n)
    Pop   -> O(1)
    Top   -> O(1)
    Empty -> O(1)

    Space Complexity -> O(n)

    =====================================================================
    */


    Queue<Integer> queue;


    //===========================================================
    // Constructor: Initialize the Queue
    //===========================================================

    public P11_ImplementStackUsingOneQueue() {

        queue = new LinkedList<>();
    }


    //===========================================================
    // Push Method: To insert elements into the Stack
    // Time Complexity: O(n)
    //===========================================================

    public void push(int x) {

        // Insert new element at the REAR
        queue.offer(x);

        // Get the current size of Queue
        int size = queue.size();

        // Move all previous elements from FRONT to REAR
        for(int i = 0; i < size - 1; i++) {

            int element = queue.poll();

            queue.offer(element);
        }
    }


    //===========================================================
    // Pop Method: To remove and return the TOP element
    // Time Complexity: O(1)
    //===========================================================

    public int pop() {

        return queue.poll();
    }


    //===========================================================
    // Top Method: To return the TOP element without removing it
    // Time Complexity: O(1)
    //===========================================================

    public int top() {

        return queue.peek();
    }


    //===========================================================
    // Empty Method: To check whether the Stack is empty
    // Time Complexity: O(1)
    //===========================================================

    public boolean empty() {

        return queue.isEmpty();
    }


    //===========================================================
    // Main Method: To test Stack implementation
    //===========================================================

    public static void main(String[] args) {

        P11_ImplementStackUsingOneQueue s =
                new P11_ImplementStackUsingOneQueue();

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println("Top Element: " + s.top());

        System.out.println("Removed Element: " + s.pop());

        System.out.println("Top Element: " + s.top());

        s.push(40);

        System.out.println("Top Element: " + s.top());

        System.out.println("Removed Element: " + s.pop());

        System.out.println("Removed Element: " + s.pop());

        System.out.println("Removed Element: " + s.pop());

        System.out.println("Is Stack Empty: " + s.empty());
    }
}

