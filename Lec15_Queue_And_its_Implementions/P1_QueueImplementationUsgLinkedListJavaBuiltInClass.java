
package Lec15_Queue_And_its_Implementions;

//============================================================

//Queue Implementation using Java Built-in Classes of Java Collection Framework

//============================================================

/*

=> In Java, we can create a Queue using Java Collection Framework
  built-in classes.

=> Mainly using 3 classes:

      1. LinkedList
      2. ArrayDeque
      3. PriorityQueue

=> Queue follows FIFO (First In First Out).

=> FIFO means: Jo element sabse pehle insert hoga,
  wahi element sabse pehle remove hoga.

=> In Queue, elements are added (Enqueue) from the REAR end
  and removed (Dequeue) from the FRONT end.

=> Important Terminologies:

      1. FRONT: Starting position of Queue.
      2. REAR: Ending position of Queue.
      3. ENQUEUE: Insertion of element from REAR end.
      4. DEQUEUE: Deletion of element from FRONT end.

=> Important Queue Methods:

      1. offer(element)  : To insert an element from REAR end.
      2. poll()          : To remove and return element from FRONT end.
      3. peek()          : To return FRONT element without removing it.
      4. add(element)    : To insert an element from REAR end.
      5. remove()        : To remove and return element from FRONT end.
      6. element()       : To return FRONT element without removing it.
      7. isEmpty()       : To check whether Queue is empty or not.
      8. size()          : To return total number of elements.
      9. contains(e)     : To check whether an element is present or not.

=> Difference between offer() and add():

      offer() : Returns false if insertion is not possible.
      add()   : Throws exception if insertion is not possible.

=> Difference between poll() and remove():

      poll()   : Returns null if Queue is empty.
      remove() : Throws exception if Queue is empty.

=> Difference between peek() and element():

      peek()    : Returns null if Queue is empty.
      element() : Throws exception if Queue is empty.

=> Diagram:

      DEQUEUE (Remove)                 ENQUEUE (Add)
             <--                           -->

      FRONT                                  REAR
        |                                      |
        v                                      v
      +------+------+------+------+------+
      |  10  |  20  |  30  |  40  |  50  |
      +------+------+------+------+------+

      Element 10 will be removed first.
      New element will be added after 50.

*/


import java.util.LinkedList;

public class P1_QueueImplementationUsgLinkedListJavaBuiltInClass {

	public static void main(String[] args) {

		// ============================================================
		// 1. Creating Queue using LinkedList - Raw Type
		// ============================================================

		// Raw Type:
		// Jab hum Generic Type specify nahi karte,
		// tab hum different data types ke elements store kar sakte hai.
		//
		// Isme Integer, String, Character etc. store kar sakte hai.
		//
		// But Raw Type use karna recommended nahi hai
		// because isme compile-time type safety nahi hoti.

		LinkedList Queue = new LinkedList();

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

		// ============================================================
		// 2. Creating Queue using LinkedList - Integer Generic Type
		// ============================================================

		// Generic Type:
		// Jab hum class ke saath specific data type define karte hai,
		// tab sirf wahi particular data type store kar sakte hai.
		//
		// Yaha Integer define kiya hai,
		// isliye sirf Integer values insert kar sakte hai.
		//
		// String ya dusre data types insert karne par compile-time error aayega.

		LinkedList<Integer> Queue1 = new LinkedList<>();

		Queue1.offer(20);
		Queue1.offer(30);
		Queue1.offer(40);

		// Queue1.offer("java"); // Error: Only Integer values allowed

		System.out.println("\nInteger Queue: " + Queue1);

		System.out.println("Removed Element: " + Queue1.poll());

		System.out.println("Front Element: " + Queue1.peek());

		System.out.println("After Operations: " + Queue1);

		// ============================================================
		// 3. Creating Queue using LinkedList - String Generic Type
		// ============================================================

		// Yaha String Generic Type define kiya hai.
		// Isliye sirf String values insert kar sakte hai.

		LinkedList<String> Queue2 = new LinkedList<>();

		// Queue2.offer(20); // Error: Only String values allowed

		Queue2.offer("java");
		Queue2.offer("raw type");
		Queue2.offer("vishal");

		System.out.println("\nString Queue: " + Queue2);

		System.out.println("Removed Element: " + Queue2.poll());

		System.out.println("Front Element: " + Queue2.peek());

		System.out.println("After Operations: " + Queue2);

		// ============================================================
		// 4. Understanding FIFO Working
		// ============================================================

		LinkedList<Integer> Queue3 = new LinkedList<>();

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

	}

}
