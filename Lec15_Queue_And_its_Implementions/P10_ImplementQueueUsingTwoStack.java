
package Lec15_Queue_And_its_Implementions;

import java.util.Stack;

public class P10_ImplementQueueUsingTwoStack {

    /*
    =====================================================================
    CONCEPT: IMPLEMENT QUEUE USING TWO STACKS
    =====================================================================

    Queue follows FIFO (First In First Out).
    Stack follows LIFO (Last In First Out).

    We use two stacks to implement Queue:

    1. inStack  -> Used to insert elements.
    2. outStack -> Used to remove and access elements.

    ---------------------------------------------------------------------
    WORKING:
    ---------------------------------------------------------------------

    1. PUSH OPERATION:
       Always insert elements into inStack.

    2. POP OPERATION:
       If outStack is empty, transfer all elements from inStack
       to outStack, then remove the top element.

       If outStack is not empty, directly remove its top element.

    3. PEEK OPERATION:
       If outStack is empty, transfer all elements from inStack
       to outStack, then return the top element.

       If outStack is not empty, directly return its top element.

    4. EMPTY OPERATION:
       Queue is empty only when both stacks are empty.


    =====================================================================
    DIAGRAM: IMPLEMENTATION USING TWO STACKS
    =====================================================================

    STEP 1: PUSH 10, 20, 30

             inStack              outStack
             --------             --------
                30                  Empty
                20
                10

             Top = 30


    STEP 2: CALL pop()

    Transfer all elements from inStack to outStack.

             inStack              outStack
             --------             --------
              Empty                  10
                                     20
                                     30

                                  Top = 10

    Now pop() removes 10.


    STEP 3: CALL pop() AGAIN

    outStack is not empty, so directly remove 20.

             inStack              outStack
             --------             --------
              Empty                  30

                                  Top = 30

    No transfer is required.


    STEP 4: CALL push(40)

             inStack              outStack
             --------             --------
                40                  30

             Top = 40            Top = 30


    STEP 5: CALL pop()

    outStack is not empty, so remove 30 first.

    After that, outStack becomes empty.

    STEP 6: CALL pop() AGAIN

    Now transfer 40 from inStack to outStack.

             inStack              outStack
             --------             --------
              Empty                  40

                                  Top = 40

    Now remove 40.


    =====================================================================
    IMPORTANT LOGIC:
    =====================================================================

    Transfer elements only when outStack is empty.

    WHY?

    Because outStack already contains elements in Queue removal order.

    If we transfer elements again unnecessarily, FIFO order will break.


    =====================================================================
    TIME AND SPACE COMPLEXITY:
    =====================================================================

    Push  -> O(1)
    Pop   -> O(1) Amortized, O(n) Worst Case
    Peek  -> O(1) Amortized, O(n) Worst Case
    Empty -> O(1)

    Space Complexity -> O(n)

    =====================================================================
    */


    Stack<Integer> inStack;
    Stack<Integer> outStack;


    //===========================================================
    // Constructor: Initialize both stacks
    //===========================================================

    P10_ImplementQueueUsingTwoStack() {

        inStack = new Stack<>();
        outStack = new Stack<>();
    }


    //===========================================================
    // Push Method: To insert elements into the Queue
    // Time Complexity: O(1)
    //===========================================================

    public void push(int x) {

        inStack.push(x);
    }


    //===========================================================
    // Pop Method: To remove and return the front element
    // Time Complexity: Amortized O(1), Worst Case O(n)
    //===========================================================

    public int pop() {

        // Transfer elements only when outStack is empty
        if(outStack.isEmpty()) {

            while(!inStack.isEmpty()) {

                int element = inStack.pop();

                outStack.push(element);
            }
        }

        return outStack.pop();
    }


    //===========================================================
    // Peek Method: To return the front element without removing it
    // Time Complexity: Amortized O(1), Worst Case O(n)
    //===========================================================

    public int peek() {

        // Transfer elements only when outStack is empty
        if(outStack.isEmpty()) {

            while(!inStack.isEmpty()) {

                int element = inStack.pop();

                outStack.push(element);
            }
        }

        return outStack.peek();
    }


    //===========================================================
    // Empty Method: To check whether the Queue is empty
    // Time Complexity: O(1)
    //===========================================================

    public boolean empty() {

        return inStack.isEmpty() && outStack.isEmpty();
    }


    //===========================================================
    // Main Method: To test Queue implementation
    //===========================================================

    public static void main(String[] args) {

        P10_ImplementQueueUsingTwoStack q =
                new P10_ImplementQueueUsingTwoStack();

        q.push(10);
        q.push(20);
        q.push(30);

        System.out.println("Front Element: " + q.peek());

        System.out.println("Removed Element: " + q.pop());

        System.out.println("Removed Element: " + q.pop());

        q.push(40);

        System.out.println("Front Element: " + q.peek());

        System.out.println("Removed Element: " + q.pop());

        System.out.println("Removed Element: " + q.pop());

        System.out.println("Is Queue Empty: " + q.empty());
    }
}
