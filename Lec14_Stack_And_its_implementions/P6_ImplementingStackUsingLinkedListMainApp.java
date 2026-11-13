
package Lec14_Stack_And_its_implementions;

public class P6_ImplementingStackUsingLinkedListMainApp {

    public static void main(String[] args) {

        //============================================================
        // Creating Stack Object
        //============================================================

        // Creating an object of our manually implemented Stack
        // using LinkedList.

        P6_ImplementingStackUsingLinkedList stack = new P6_ImplementingStackUsingLinkedList();


        //============================================================
        // Push Operation: Adding Elements into Stack
        //============================================================

        // Insert elements one by one at the TOP of Stack.
        // Every new node becomes the first node of LinkedList.

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        // Stack: TOP -> 50 -> 40 -> 30 -> 20 -> 10 -> null


        //============================================================
        // Display Operation: Traversing the Stack
        //============================================================

        // Display all elements from TOP to BOTTOM.
        // Output: 50 40 30 20 10

        System.out.println("Stack Elements: ");
        stack.display();


        //============================================================
        // Peek Operation: Getting the Top Element
        //============================================================

        // peek() returns the TOP element without removing it.
        // TOP remains unchanged.
        // Output: 50

        System.out.println("Top Element: " + stack.peek());


        //============================================================
        // Size Operation: Counting Stack Elements
        //============================================================

        // size() returns the total number of elements present in Stack.
        // Output: 5

        System.out.println("Stack Size: " + stack.size());


        //============================================================
        // Pop Operation: Removing the Top Element
        //============================================================

        // pop() removes and returns the TOP element.
        // After removing 50, TOP points to 40.
        // Output: 50

        System.out.println("Removed Element: " + stack.pop());


        //============================================================
        // Display Operation After Pop
        //============================================================

        // Stack: TOP -> 40 -> 30 -> 20 -> 10 -> null
        // Output: 40 30 20 10

        System.out.println("Stack Elements After Pop: ");
        stack.display();


        //============================================================
        // isEmpty() Operation: Checking Whether Stack Is Empty
        //============================================================

        // isEmpty() returns true if Stack contains no elements.
        // Otherwise, it returns false.
        // Output: false

        System.out.println("Is Stack Empty: " + stack.isEmpty());


        //============================================================
        // Multiple Pop Operations
        //============================================================

        // Removing elements one by one from TOP.

        System.out.println("Removed Element: " + stack.pop());  // 40
        System.out.println("Removed Element: " + stack.pop());  // 30


        //============================================================
        // Display Operation After Multiple Pops
        //============================================================

        // Stack: TOP -> 20 -> 10 -> null
        // Output: 20 10

        System.out.println("Stack Elements: ");
        stack.display();


        //============================================================
        // Clear Operation: Removing All Elements
        //============================================================

        // clear() sets top = null and size = 0.
        // All elements are removed from the Stack.

        stack.clear();


        //============================================================
        // Checking Stack After Clear
        //============================================================

        // Stack is now empty.
        // Output: true

        System.out.println("Is Stack Empty After Clear: " + stack.isEmpty());

        // Output: 0
        System.out.println("Stack Size After Clear: " + stack.size());

        // Display empty Stack
        System.out.println("Stack Elements After Clear: ");
        stack.display();

    }
}
