
package Lec15_Queue_And_its_Implementions;

//============================================================
// Queue Implementation using ArrayDeque Java Built-in Class
//============================================================

/*
 
 => ArrayDeque is a built-in class of Java Collection Framework.

 => ArrayDeque internally uses a resizable array to store elements.

 => We can use ArrayDeque to implement Queue.

 => ArrayDeque follows FIFO when used as a normal Queue.

 => In Queue, elements are added (Enqueue) from the REAR end
    and removed (Dequeue) from the FRONT end.

 => Important Points:

        1. ArrayDeque is a resizable array.
        2. It can grow and shrink dynamically.
        3. It does not allow NULL elements.
        4. It is generally faster than LinkedList for Queue operations.
        5. It is not thread-safe.
        6. It does not support indexing like ArrayList.

 => Important Queue Methods:

        1. offer(element) : To insert an element from REAR end.
        2. poll()         : To remove and return element from FRONT end.
        3. peek()         : To return FRONT element without removing it.
        4. add(element)   : To insert an element from REAR end.
        5. remove()       : To remove and return element from FRONT end.
        6. element()      : To return FRONT element without removing it.
        7. isEmpty()      : To check whether Queue is empty or not.
        8. size()         : To return total number of elements.
        9. contains(e)    : To check whether an element is present or not.

 => Difference between ArrayDeque and LinkedList:

        1. ArrayDeque uses a resizable array internally.
        2. LinkedList uses a doubly linked list internally.
        3. ArrayDeque does not allow NULL elements.
        4. LinkedList allows NULL elements.

 => Note:

        ArrayDeque can also work as a Deque
        (Double Ended Queue).

        It allows insertion and deletion from both ends.

        But here we are using ArrayDeque as a normal Queue.

*/

//============================================================

import java.util.ArrayDeque;

public class P2_QueueImplementationUsingArrayDequeJavaBuiltInClass {

    public static void main(String[] args) {


        //============================================================
        // 1. Creating Queue using ArrayDeque - Raw Type
        //============================================================

        // Raw Type:
        // Jab hum Generic Type specify nahi karte,
        // tab different data types ke elements store kar sakte hai.
        //
        // But Raw Type use karna recommended nahi hai
        // because isme compile-time type safety nahi hoti.

        ArrayDeque Queue = new ArrayDeque();

        // offer(): Queue ke rear (last) mein element insert karta hai.

        Queue.offer(20);
        Queue.offer(30);
        Queue.offer(40);
        Queue.offer("raw type");
        Queue.offer("java");

        // Current Queue:
        // Front -> [20, 30, 40, raw type, java] <- Rear

        System.out.println("Raw Type Queue: " + Queue);

        // poll(): Queue ke front se element remove karta hai
        // Aur removed element return bhi karta hai.

        System.out.println("Removed Element: " + Queue.poll());

        // peek(): Queue ka front element return karta hai
        // But element ko remove nahi karta.

        System.out.println("Front Element: " + Queue.peek());

        System.out.println("After Operations: " + Queue);


        //============================================================
        // 2. Creating Queue using ArrayDeque - Integer Generic Type
        //============================================================

        // Yaha Integer Generic Type define kiya hai.
        // Isliye sirf Integer values insert kar sakte hai.

        ArrayDeque<Integer> Queue1 = new ArrayDeque<>();

        Queue1.offer(20);
        Queue1.offer(30);
        Queue1.offer(40);

        // Queue1.offer("java"); // Error: Only Integer values allowed

        System.out.println("\nInteger Queue: " + Queue1);

        System.out.println("Removed Element: " + Queue1.poll());

        System.out.println("Front Element: " + Queue1.peek());

        System.out.println("After Operations: " + Queue1);


        //============================================================
        // 3. Creating Queue using ArrayDeque - String Generic Type
        //============================================================

        // Yaha String Generic Type define kiya hai.
        // Isliye sirf String values insert kar sakte hai.

        ArrayDeque<String> Queue2 = new ArrayDeque<>();

        // Queue2.offer(20); // Error: Only String values allowed

        Queue2.offer("java");
        Queue2.offer("raw type");
        Queue2.offer("vishal");

        System.out.println("\nString Queue: " + Queue2);

        System.out.println("Removed Element: " + Queue2.poll());

        System.out.println("Front Element: " + Queue2.peek());

        System.out.println("After Operations: " + Queue2);


        //============================================================
        // 4. Understanding FIFO Working
        //============================================================

        ArrayDeque<Integer> Queue3 = new ArrayDeque<>();

        Queue3.offer(10);
        Queue3.offer(20);
        Queue3.offer(30);
        Queue3.offer(40);

        // Insertion Order:
        // Front -> [10, 20, 30, 40] <- Rear
        //
        // First inserted element = 10
        // First removed element = 10

        System.out.println("\nFIFO Queue: " + Queue3);

        System.out.println("First Remove: " + Queue3.poll());

        System.out.println("Second Remove: " + Queue3.poll());

        System.out.println("Remaining Queue: " + Queue3);


        //============================================================
        // 5. Checking Queue Methods
        //============================================================

        ArrayDeque<Integer> Queue4 = new ArrayDeque<>();

        Queue4.offer(100);
        Queue4.offer(200);
        Queue4.offer(300);

        // size(): Total number of elements return karta hai.

        System.out.println("\nQueue Size: " + Queue4.size());

        // contains(): Check karta hai ki element present hai ya nahi.

        System.out.println("Contains 200: " + Queue4.contains(200));

        // isEmpty(): Check karta hai ki Queue empty hai ya nahi.

        System.out.println("Is Queue Empty: " + Queue4.isEmpty());

        // clear(): Queue ke saare elements remove karta hai.

        Queue4.clear();

        System.out.println("After Clear: " + Queue4);

        System.out.println("Is Queue Empty: " + Queue4.isEmpty());


        //============================================================
        // 6. ArrayDeque Does Not Allow NULL Elements
        //============================================================

        ArrayDeque<Integer> Queue5 = new ArrayDeque<>();

        Queue5.offer(10);
        Queue5.offer(20);

        // Queue5.offer(null);
        // NullPointerException: ArrayDeque does not allow NULL.

        System.out.println("\nNull Restriction Queue: " + Queue5);

    }

}
