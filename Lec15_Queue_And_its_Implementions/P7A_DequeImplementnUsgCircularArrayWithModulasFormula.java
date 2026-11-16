
package Lec15_Queue_And_its_Implementions;

public class P7A_DequeImplementnUsgCircularArrayWithModulasFormula {

	/*
	 * ============================================================
	 * DEQUE USING CIRCULAR ARRAY WITH MODULUS FORMULA
	 * ============================================================
	 *
	 * CIRCULAR MOVEMENT USING TWO FORMULAS
	 *
	 * We use these formulas when a pointer needs to move
	 * circularly inside the array.
	 *
	 * ============================================================
	 *
	 * 1. PREVIOUS POSITION FORMULA
	 *
	 *    index = (index - 1 + capacity) % capacity;
	 *
	 *    WHEN TO USE:
	 *
	 *    Use this formula when you want to move the pointer
	 *    one position backward (left side).
	 *
	 *    DEQUE OPERATIONS:
	 *
	 *    addFront()  -> Front ko previous position par move karna.
	 *    deleteRear() -> Rear ko previous position par move karna.
	 *
	 *    EXAMPLE:
	 *
	 *    capacity = 5
	 *    index = 0
	 *
	 *    index = (0 - 1 + 5) % 5;
	 *    index = 4 % 5;
	 *    index = 4;
	 *
	 *    Diagram:
	 *
	 *    Index:   0    1    2    3    4
	 *             ^
	 *             |
	 *             | Previous movement
	 *             |
	 *             4 <----------------
	 *
	 *    Index 0 se previous position par jaane par
	 *    pointer last index 4 par pahunch jayega.
	 *
	 *    WHY + capacity?
	 *
	 *    Agar index 0 hai aur hum index - 1 karte hain
	 *    toh result -1 aayega.
	 *
	 *    -1 array ka valid index nahi hai.
	 *    Isliye capacity add karte hain taaki negative
	 *    index na aaye.
	 *
	 * ============================================================
	 *
	 * 2. NEXT POSITION FORMULA
	 *
	 *    index = (index + 1) % capacity;
	 *
	 *    WHEN TO USE:
	 *
	 *    Use this formula when you want to move the pointer
	 *    one position forward (right side).
	 *
	 *    DEQUE OPERATIONS:
	 *
	 *    addRear()    -> Rear ko next position par move karna.
	 *    deleteFront() -> Front ko next position par move karna.
	 *
	 *    EXAMPLE:
	 *
	 *    capacity = 5
	 *    index = 4
	 *
	 *    index = (4 + 1) % 5;
	 *    index = 5 % 5;
	 *    index = 0;
	 *
	 *    Diagram:
	 *
	 *    Index:   0    1    2    3    4
	 *                              |
	 *                              |
	 *                      Next movement
	 *                              |
	 *                              v
	 *                              0
	 *
	 *    Index 4 se next position par jaane par
	 *    pointer index 0 par pahunch jayega.
	 *
	 *    WHY % capacity?
	 *
	 *    Modulus operator remainder deta hai.
	 *    Isse pointer hamesha 0 se capacity - 1 ke
	 *    beech valid index par rahega.
	 *
	 * ============================================================
	 *
	 * QUICK REVISION:
	 *
	 * Formula                          Use
	 * ------------------------------------------------------------
	 * (index - 1 + capacity) % capacity  Previous / Backward
	 * (index + 1) % capacity             Next / Forward
	 *
	 * DEQUE OPERATIONS:
	 *
	 * addFront()    -> Previous Formula
	 * addRear()     -> Next Formula
	 * deleteFront() -> Next Formula
	 * deleteRear()  -> Previous Formula
	 *
	 * ============================================================
	 *
	 * CIRCULAR ARRAY DIAGRAM (capacity = 5)
	 *
	 *       0 ----> 1 ----> 2
	 *       ^               |
	 *       |               |
	 *       4 <---- 3 <------
	 *
	 * Next Movement:
	 * 0 -> 1 -> 2 -> 3 -> 4 -> 0
	 *
	 * Previous Movement:
	 * 4 -> 3 -> 2 -> 1 -> 0 -> 4
	 *
	 * ============================================================
	 *
	 * IMPORTANT CONDITIONS:
	 *
	 * Empty Condition:
	 * front == -1
	 *
	 * Full Condition:
	 * (front == 0 && rear == capacity - 1) || front == rear + 1
	 *
	 * Single Element Condition:
	 * front == rear
	 *
	 * When only one element is deleted:
	 * front = rear = -1
	 *
	 * ============================================================
	 */

	int capacity;
	int arr[];
	int front;
	int rear;

	P7A_DequeImplementnUsgCircularArrayWithModulasFormula(int capacity) {

		this.capacity = capacity;
		arr = new int[capacity];
		rear = front = -1;
	}

	// ============================================================
	// AddFront Method: To add an element at the front of Deque
	// Time Complexity: O(1)
	// ============================================================

	void addFront(int element) {

		// Check karo Deque full hai ya nahi
		if ((front == 0 && rear == capacity - 1) || front == rear + 1) {
			System.out.println("Deque is full");
			return;
		}

		// Agar Deque empty hai toh dono pointers index 0 par rakho
		else if (front == -1) {
			front = rear = 0;
		}

		// Otherwise front ko previous position par circularly move karo
		else {
			front = (front - 1 + capacity) % capacity;
		}

		// Front position par element insert karo
		arr[front] = element;
	}

	// ============================================================
	// AddRear Method: To add an element at the rear of Deque
	// Time Complexity: O(1)
	// ============================================================

	void addRear(int element) {

		// Check karo Deque full hai ya nahi
		if ((front == 0 && rear == capacity - 1) || front == rear + 1) {
			System.out.println("Deque is full");
			return;
		}

		// Agar Deque empty hai toh dono pointers index 0 par rakho
		else if (front == -1) {
			front = rear = 0;
		}

		// Otherwise rear ko next position par circularly move karo
		else {
			rear = (rear + 1) % capacity;
		}

		// Rear position par element insert karo
		arr[rear] = element;
	}

	// ============================================================
	// DeleteFront Method: To delete an element from the front
	// Time Complexity: O(1)
	// ============================================================

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

		// Otherwise front ko next position par circularly move karo
		else {
			front = (front + 1) % capacity;
		}

		// Deleted element return karo
		return removedElement;
	}

	// ============================================================
	// DeleteRear Method: To delete an element from the rear
	// Time Complexity: O(1)
	// ============================================================

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

		// Otherwise rear ko previous position par circularly move karo
		else {
			rear = (rear - 1 + capacity) % capacity;
		}

		// Deleted element return karo
		return removedElement;
	}

	// ============================================================
	// Display Method: To display all elements of Deque
	// Time Complexity: O(n)
	// ============================================================

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

			// Otherwise next index par circularly move karo
			i = (i + 1) % capacity;
		}

		System.out.println();
	}

	// ============================================================
	// GetFrontPeek Method: To return the front element
	// Time Complexity: O(1)
	// ============================================================

	public int getFrontPeek() {

		// Check karo Deque empty hai ya nahi
		if (front == -1) {
			System.out.println("Deque is empty");
			return -1;
		}

		// Front element return karo without deleting it
		return arr[front];
	}

	// ============================================================
	// GetRearPeek Method: To return the rear element
	// Time Complexity: O(1)
	// ============================================================

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
