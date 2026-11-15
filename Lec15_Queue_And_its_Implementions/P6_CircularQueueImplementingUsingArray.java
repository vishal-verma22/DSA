
/*
 *============================================================
 * Circular Queue Implementation using Array
 *============================================================
 *
 * 1. Circular Queue follows FIFO (First In First Out).
 *
 * 2. Insertion takes place from REAR.
 *
 * 3. Deletion takes place from FRONT.
 *
 * 4. FRONT stores the index of the first element.
 *
 * 5. REAR stores the index of the last element.
 *
 * 6. Circular Queue mein last index ke baad wapas index 0
 *    par move kar sakte hain using modulo (%) operator.
 *
 *============================================================
 * Diagram: Circular Queue
 *============================================================
 *
 * Capacity = 5
 *
 * Index:    0      1      2      3      4
 *         +------+------+------+------+------+
 * Array:  |  10  |  20  |  30  |  40  |  50  |
 *         +------+------+------+------+------+
 *            ^                         ^
 *          FRONT                      REAR
 *
 *============================================================
 * 7. Circular Movement
 *============================================================
 *
 * REAR = (REAR + 1) % capacity
 *
 * FRONT = (FRONT + 1) % capacity
 *
 * Example:
 *
 * capacity = 5
 * rear = 4
 *
 * rear = (4 + 1) % 5
 * rear = 5 % 5
 * rear = 0
 *
 * REAR wapas index 0 par aa jayega.
 *
 *============================================================
 * 8. Offer Operation (Insertion)
 *============================================================
 *
 * - Check karta hai Queue full hai ya nahi.
 * - Agar Queue empty hai toh FRONT = 0 karta hai.
 * - REAR ko next circular index par move karta hai.
 * - New element ko REAR index par store karta hai.
 *
 *============================================================
 * 9. Display Operation
 *============================================================
 *
 * - Traversal FRONT se start hota hai.
 * - Har index ka element print hota hai.
 * - Jab index REAR tak pahuch jata hai toh loop break hota hai.
 * - Modulo (%) ki help se circular movement hota hai.
 *
 *============================================================
 * 10. Poll Operation (Deletion)
 *============================================================
 *
 * - Check karta hai Queue empty hai ya nahi.
 * - FRONT element ko remove karta hai.
 * - Agar sirf ek element hai toh FRONT = REAR = -1.
 * - Otherwise FRONT ko next circular index par move karta hai.
 *
 *============================================================
 * 11. Time Complexity
 *============================================================
 *
 * offer()  - O(1)
 * poll()   - O(1)
 * display()- O(n)
 *
 *============================================================
 */

package Lec15_Queue_And_its_Implementions;

/*
 *============================================================
 * Circular Queue Implementation using Array
 *============================================================
 *
 * Queue follows FIFO (First In First Out).
 *
 * FRONT = First element ka index
 * REAR  = Last element ka index
 *
 * Last index ke baad wapas index 0 par move karte hain.
 *
 *============================================================
 */

public class P6_CircularQueueImplementingUsingArray {

    int capacity;

    int queue[];

    int rear;

    int front;

    P6_CircularQueueImplementingUsingArray(int capacity) {

        this.capacity = capacity;

        queue = new int[capacity];

        front = rear = -1; // Initially Queue empty hai
    }

    //============================================================
    // Offer Method: To add an element at REAR
    // Time Complexity: O(1)
    //============================================================

    void offer(int element) {

        // Check kar rahe hain ki Queue full hai ya nahi
        // Agar next REAR index FRONT ke equal hai toh Queue full hai

        if (((rear + 1) % capacity) == front) {

            System.out.println("Queue is full ");
            return;
        }

        // Agar FRONT -1 hai toh iska matlab Queue empty hai
        // First element insert karte time FRONT ko 0 kar denge

        if (front == -1) {

            front = 0;
        }

        // REAR ko next circular index par move kar rahe hain
        // Agar last index ke baad move hua toh wapas 0 par aa jayega

        rear = (rear + 1) % capacity;

        // New element ko REAR index par store kar rahe hain

        queue[rear] = element;
    }

    //============================================================
    // Display Method: To display all elements
    // Time Complexity: O(n)
    //============================================================

    void display() {

        // Agar FRONT -1 hai toh Queue empty hai
        // Isliye display karne ke liye koi element nahi hai

        if (front == -1) {

            System.out.println("Queue is empty");
            return;
        }

        int i = front;

        while (true) {

            System.out.print(queue[i] + " ");

            // Agar current index REAR tak pahuch gaya
            // Toh saare elements display ho chuke hain
            // Isliye loop ko stop kar denge

            if (i == rear) {

                break;
            }

            // Next index par move kar rahe hain
            // Modulo ki wajah se last index ke baad 0 par jayenge

            i = (i + 1) % capacity;
        }

        System.out.println();
    }

    //============================================================
    // Poll Method: To remove an element from FRONT
    // Time Complexity: O(1)
    //============================================================

    public int poll() {

        // Agar FRONT -1 hai toh Queue empty hai
        // Isliye remove karne ke liye koi element nahi hai

        if (front == -1) {

            System.out.println("Queue is Empty");
            return -1;
        }

        // FRONT par present element ko store kar rahe hain
        // Taaki remove hone ke baad return kar sakein

        int removedElememt = queue[front];

        // Check kar rahe hain ki Queue mein sirf ek element hai ya nahi
        // Agar FRONT aur REAR equal hain toh sirf ek element present hai
        // Remove karne ke baad Queue empty ho jayegi

        if (front == rear) {

            rear = front = -1;

        } else {

            // FRONT ko next circular index par move kar rahe hain
            // Modulo ki wajah se last index ke baad 0 par aa jayega

            front = (front + 1) % capacity;
        }

        return removedElememt;
    }
}
