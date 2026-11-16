
    //============================================================
    // DEQUE(DOUBLE ENDED QUEUE) Implemention Using Circular Array
    //============================================================

    /*
     * Deque stands for Double Ended Queue.
     *
     * It is a linear data structure in which insertion and deletion
     * operations can be performed from both ends (Front and Rear).
     *
     * Normal Queue:
     * 1. Insertion is performed from Rear.
     * 2. Deletion is performed from Front.
     *
     * Deque:
     * 1. Insertion can be performed from Front and Rear.
     * 2. Deletion can be performed from Front and Rear.
     *
     * Important Pointers:
     * 1. Front points to the first element.
     * 2. Rear points to the last element.
     *
     * Initially:
     * front = -1;
     * rear = -1;
     *
     * First Insertion:
     * front = rear = 0;
     *
     * Last Element Deletion:
     * front = rear = -1;
     */


    //============================================================
    // TYPES OF DEQUE
    //============================================================

    /*
     * 1. Input Restricted Deque:
     *    Insertion is allowed only from Rear.
     *    Deletion is allowed from both Front and Rear.
     *
     * 2. Output Restricted Deque:
     *    Insertion is allowed from both Front and Rear.
     *    Deletion is allowed only from Front.
     */


    //============================================================
    // CIRCULAR ARRAY CONCEPT
    //============================================================

    /*
     * We use a Circular Array to implement Deque.
     *
     * In a Circular Array:
     *
     * 1. After the last index, we move back to index 0.
     * 2. Before index 0, we move to the last index.
     *
     * Example:
     * capacity = 5;
     *
     * Index:  0   1   2   3   4
     *
     * Next of index 4  = 0
     * Previous of index 0 = 4
     *
     * Full Condition:
     * (front == 0 && rear == capacity - 1) || front == rear + 1
     *
     * Empty Condition:
     * front == -1
     *
     * Note:
     * We manually handle circular movement without using modulo (%).
     */


    //============================================================
    // INSERTION FROM FRONT - addFront()
    //============================================================

    /*
     * Logic:
     *
     * 1. Check whether Deque is full or not.
     * 2. If Deque is empty, set front = rear = 0.
     * 3. If front is at index 0, move front to last index.
     * 4. Otherwise, decrement front by 1.
     * 5. Insert the element at arr[front].
     *
     * Example:
     * capacity = 5;
     *
     * addFront(10):
     * Index:  0   1   2   3   4
     *        [10] [ ] [ ] [ ] [ ]
     *         F/R
     *
     * addFront(20):
     * Index:  0   1   2   3   4
     *        [10] [ ] [ ] [ ] [20]
     *         R               F
     *
     * addFront(30):
     * Index:  0   1   2   3   4
     *        [10] [ ] [ ] [30] [20]
     *         R            F
     *
     * Logical Deque:
     * Front -> 30 -> 20 -> 10 <- Rear
     *
     * Pointer Movement:
     * If front == 0:
     *     front = capacity - 1;
     *
     * Otherwise:
     *     front--;
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */


    //============================================================
    // INSERTION FROM REAR - addRear()
    //============================================================

    /*
     * Logic:
     *
     * 1. Check whether Deque is full or not.
     * 2. If Deque is empty, set front = rear = 0.
     * 3. If rear is at the last index, move rear to index 0.
     * 4. Otherwise, increment rear by 1.
     * 5. Insert the element at arr[rear].
     *
     * Example:
     * capacity = 5;
     *
     * addRear(10):
     * Index:  0   1   2   3   4
     *        [10] [ ] [ ] [ ] [ ]
     *         F/R
     *
     * addRear(20):
     * Index:  0   1   2   3   4
     *        [10][20] [ ] [ ] [ ]
     *         F    R
     *
     * addRear(30):
     * Index:  0   1   2   3   4
     *        [10][20][30] [ ] [ ]
     *         F        R
     *
     * Logical Deque:
     * Front -> 10 -> 20 -> 30 <- Rear
     *
     * Pointer Movement:
     * If rear == capacity - 1:
     *     rear = 0;
     *
     * Otherwise:
     *     rear++;
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */


    //============================================================
    // DELETION FROM FRONT - deleteFront()
    //============================================================

    /*
     * Logic:
     *
     * 1. Check whether Deque is empty or not.
     * 2. Store arr[front] in removedElement.
     * 3. If front == rear, only one element is present.
     *    Set front = rear = -1.
     * 4. If front is at the last index, move front to index 0.
     * 5. Otherwise, increment front by 1.
     * 6. Return removedElement.
     *
     * Pointer Movement:
     *
     * If front == capacity - 1:
     *     front = 0;
     *
     * Otherwise:
     *     front++;
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */


    //============================================================
    // DELETION FROM REAR - deleteRear()
    //============================================================

    /*
     * Logic:
     *
     * 1. Check whether Deque is empty or not.
     * 2. Store arr[rear] in removedElement.
     * 3. If front == rear, only one element is present.
     *    Set front = rear = -1.
     * 4. If rear is at index 0, move rear to the last index.
     * 5. Otherwise, decrement rear by 1.
     * 6. Return removedElement.
     *
     * Pointer Movement:
     *
     * If rear == 0:
     *     rear = capacity - 1;
     *
     * Otherwise:
     *     rear--;
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */


    //============================================================
    // PEEK OPERATIONS
    //============================================================

    /*
     * getFrontPeek():
     * Returns the first element without deleting it.
     *
     * getRearPeek():
     * Returns the last element without deleting it.
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */


    //============================================================
    // DISPLAY METHOD
    //============================================================

    /*
     * Logic:
     *
     * 1. Check whether Deque is empty.
     * 2. Start traversal from front.
     * 3. Print the current element.
     * 4. Stop when rear is reached.
     * 5. If current index is the last index, move to index 0.
     * 6. Otherwise, increment the index.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */


    //============================================================
    // TIME AND SPACE COMPLEXITY SUMMARY
    //============================================================

    /*
     * Operation          Time Complexity
     *
     * addFront()         O(1)
     * addRear()          O(1)
     * deleteFront()      O(1)
     * deleteRear()       O(1)
     * getFrontPeek()     O(1)
     * getRearPeek()      O(1)
     * display()          O(n)
     *
     * Overall Space Complexity: O(n)
     * Because we use an array of capacity n.
     */

package Lec15_Queue_And_its_Implementions;

public class P7_DequeImplementnUsgCircularArrayWithoutModulasFormula {

	int capacity;
	int arr[];
	int front;
	int rear;

	P7_DequeImplementnUsgCircularArrayWithoutModulasFormula(int capacity) {

		this.capacity = capacity;
		arr = new int[capacity];
		rear = front = -1;
	}


	//============================================================
	// AddFront Method: To add an element at the front of Deque
	// Time Complexity: O(1)
	//============================================================

	void addFront(int element) {

		// Check karo Deque full hai ya nahi
		if ((front == 0 && rear == capacity - 1) || front == rear + 1) {

			System.out.println("Deque is full");
			return;
		}

		// Agar Deque empty hai toh dono pointers ko index 0 par rakho
		else if (front == -1) {

			front = rear = 0;
		}

		// Agar front index 0 par hai toh circularly last index par move karo
		else if (front == 0) {

			front = capacity - 1;
		}

		// Otherwise front ko ek position peeche move karo
		else {

			front--;
		}

		// Front position par element insert karo
		arr[front] = element;
	}


	//============================================================
	// AddRear Method: To add an element at the rear of Deque
	// Time Complexity: O(1)
	//============================================================

	void addRear(int element) {

		// Check karo Deque full hai ya nahi
		if ((front == 0 && rear == capacity - 1) || front == rear + 1) {

			System.out.println("Deque is full");
			return;
		}

		// Agar Deque empty hai toh dono pointers ko index 0 par rakho
		else if (front == -1) {

			front = rear = 0;
		}

		// Agar rear last index par hai toh circularly index 0 par move karo
		else if (rear == capacity - 1) {

			rear = 0;
		}

		// Otherwise rear ko ek position aage move karo
		else {

			rear++;
		}

		// Rear position par element insert karo
		arr[rear] = element;
	}


	//============================================================
	// DeleteFront Method: To delete an element from the front
	// Time Complexity: O(1)
	//============================================================

	public int deleteFront() {

		// Check karo Deque empty hai ya nahi
		if (front == -1) {

			System.out.println("Deque is empty");
			return -1;
		}

		// Front element ko deletion se pehle store karo
		int removedElement = arr[front];

		// Agar front aur rear same hain toh sirf ek element present hai
		// Us element ko delete karne ke baad Deque empty ho jayega
		if (front == rear) {

			front = rear = -1;
		}

		// Agar front last index par hai toh circularly index 0 par move karo 
		//Q ki front++ krne pe index capacity se jada move ho jayega aur exception throw hoga
		else if (front == capacity - 1) {

			front = 0;
		}

		// Otherwise front ko ek position aage move karo
		else {

			front++;
		}

		// Deleted element return karo
		return removedElement;
	}


	//============================================================
	// DeleteRear Method: To delete an element from the rear
	// Time Complexity: O(1)
	//============================================================

	public int deleteRear() {

		// Check karo Deque empty hai ya nahi
		if (front == -1) {

			System.out.println("Deque is empty");
			return -1;
		}

		// Rear element ko deletion se pehle store karo
		int removedElement = arr[rear];

		// Agar front aur rear same hain toh sirf ek element present hai
		// Us element ko delete karne ke baad Deque empty ho jayega
		if (front == rear) {

			front = rear = -1;
		}

		// Agar rear index 0 par hai toh circularly last index par move karo q ki 
		//agar rear-- kiya toh -1 ho jayega aur -1 circular array me exist nhikrta hai
		else if (rear == 0) {

			rear = capacity - 1;
		}

		// Otherwise rear ko ek position peeche move karo
		else {

			rear--;
		}

		// Deleted element return karo
		return removedElement;
	}


	//============================================================
	// Display Method: To display all elements of Deque
	// Time Complexity: O(n)
	//============================================================

	void display() {

		// Check karo Deque empty hai ya nahi
		if (front == -1) {

			System.out.println("Deque is empty");
			return;
		}

		// Traversal front position se start karo
		int i = front;

		while (true) {

			// Current index ka element print karo
			System.out.print(arr[i] + " ");

			// Agar rear par pahunch gaye toh traversal stop karo
			if (i == rear) {

				break;
			}

			// Agar last index par hain toh circularly index 0 par jao
			if (i == capacity - 1) {

				i = 0;
			}

			// Otherwise next index par move karo
			else {

				i++;
			}
		}

		System.out.println();
	}


	//============================================================
	// GetFrontPeek Method: To return the front element
	// Time Complexity: O(1)
	//============================================================

	public int getFrontPeek() {

		// Check karo Deque empty hai ya nahi
		if (front == -1) {

			System.out.println("Deque is empty");
			return -1;
		}

		// Front element return karo without deleting it
		return arr[front];
	}


	//============================================================
	// GetRearPeek Method: To return the rear element
	// Time Complexity: O(1)
	//============================================================

	public int getRearPeek() {

		// Check karo Deque empty hai ya nahi
		if (front == -1) {

			System.out.println("Deque is empty");
			return -1;
		}

		// Rear element return karo without deleting it
		return arr[rear];
	}


}
