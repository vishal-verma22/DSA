
/*
======================================================================
              MAX PRIORITY QUEUE USING BINARY HEAP
                         ARRAY BASED
======================================================================

1. WHAT IS MAX HEAP?

- Max Heap ek Complete Binary Tree hota hai.
- Ismein parent node ki value apne children se badi ya equal hoti hai.
- Root node par hamesha maximum element hota hai.

Example:

                              100
                       /             \
                     90               95
                  /     \          /      \
                80       85       88       92
               /  \     /  \     /  \     /  \
              70  75   76  78   79  82   84  86


Array Representation:

[100, 90, 95, 80, 85, 88, 92, 70, 75, 76, 78, 79, 82, 84, 86]


2. MAX HEAP PROPERTY

- Parent >= Left Child
- Parent >= Right Child
- Root par maximum element hota hai.


3. ARRAY FORMULAS (0-BASED INDEXING)

Parent Index:

(index - 1) / 2

Left Child Index:

(2 * index) + 1

Right Child Index:

(2 * index) + 2


4. INSERTION IN MAX HEAP (OFFER)

- New element ko next available position par insert karte hain.
- Current element ko parent ke saath compare karte hain.
- Agar current element parent se bada hai toh swap karte hain.
- Current index ko parent index par move karte hain.
- Ye process tab tak chalta hai jab tak Max Heap property maintain na ho.

Is process ko HEAPIFY UP kehte hain.

Direction: BOTTOM TO TOP.


INSERTION EXAMPLE:

Initially:

                 50
               /    \
             40      30
            /  \
           20  10

Array = [50, 40, 30, 20, 10]


STEP 1: Insert 80 at next available position.

                 50
               /    \
             40      30
            /  \
           20  10
          /
         80


STEP 2: Compare 80 with parent 30.

80 > 30, so swap.

                 50
               /    \
             40      80
            /  \    /
           20  10  30


STEP 3: Compare 80 with parent 50.

80 > 50, so swap.

                 80
               /    \
             40      50
            /  \    /
           20  10  30

Final Array:

[80, 40, 50, 20, 10, 30]


5. HEAPIFY UP

- Current node ko parent ke saath compare karte hain.
- Agar current node parent se bada hai toh swap karte hain.
- Current index ko parent index par move karte hain.

Conditions:

currentIndex > 0

- Check karta hai ki current node root nahi hai.

heap[currentIndex] > heap[parentNode(currentIndex)]

- Check karta hai ki current node parent se bada hai ya nahi.
- Agar bada hai toh swap karte hain.

Time Complexity = O(log n)


6. DELETION IN MAX HEAP (POLL)

- Max Heap mein deletion root se hota hai.
- Root par maximum element hota hai.
- Last element ko root position par place karte hain.
- Size decrease karte hain.
- Root ko dono children ke saath compare karte hain.
- Largest child ke saath swap karte hain.
- Current index ko largest child ke index par move karte hain.

Is process ko HEAPIFY DOWN kehte hain.

Direction: TOP TO BOTTOM.


DELETION EXAMPLE:

Initially:

                  80
               /      \
             50        60
            /  \      /  \
           40  30    20  10

Array = [80, 50, 60, 40, 30, 20, 10]


STEP 1: Remove root element 80.

removedElement = 80


STEP 2: Last element 10 ko root par place karo.

                  10
               /      \
             50        60
            /  \      /
           40  30    20


STEP 3: Compare 10 with its children.

Left Child  = 50
Right Child = 60

Largest = 60

60 > 10, so swap.

                  60
               /      \
             50        10
            /  \      /
           40  30    20


STEP 4: Compare 10 with its children.

Left Child = 20
Right Child does not exist.

20 > 10, so swap.

                  60
               /      \
             50        20
            /  \      /
           40  30    10


FINAL RESULT:

Array = [60, 50, 20, 40, 30, 10]

Removed Element = 80


7. HEAPIFY DOWN

- Current index initially root index 0 hota hai.
- Largest ko currentIndex assume karte hain.
- Left aur right child ke indexes calculate karte hain.
- Left child exist karta hai aur bada hai toh largest update.
- Right child exist karta hai aur bada hai toh largest update.
- Agar largest == currentIndex hai toh loop break.
- Otherwise current node aur largest child ko swap karte hain.
- Current index ko largest par move karte hain.

IMPORTANT CONDITIONS:

left < size

- Check karta hai ki left child exist karta hai ya nahi.

heap[left] > heap[largest]

- Check karta hai ki left child ki value largest se badi hai ya nahi.

right < size

- Check karta hai ki right child exist karta hai ya nahi.

heap[right] > heap[largest]

- Check karta hai ki right child ki value largest se badi hai ya nahi.

largest == currentIndex

- Agar current node hi largest hai toh swap ki zarurat nahi.
- Isliye loop break kar dete hain.

Time Complexity = O(log n)


8. PEEK METHOD

- Root element return karta hai.
- Max Heap mein root par maximum element hota hai.
- Element remove nahi hota.

Time Complexity = O(1)


9. TIME AND SPACE COMPLEXITY

Offer / Insert     = O(log n)
Heapify Up         = O(log n)
Poll / Delete      = O(log n)
Heapify Down       = O(log n)
Peek               = O(1)
isEmpty            = O(1)
isFull             = O(1)
Size               = O(1)
Search             = O(n)
Display            = O(n)

Space Complexity   = O(n)


======================================================================
*/


package Lec15_Queue_And_its_Implementions;

public class P10_MaxPriorityQueueImplemtnUsgBinaryHeap_ArrayBased {

	int capacity;
	int heap[];
	int size;

	//============================================================
	// Constructor: To initialize Priority Queue with given capacity
	//============================================================
	P10_MaxPriorityQueueImplemtnUsgBinaryHeap_ArrayBased(int capacity) {

		this.capacity = capacity;
		heap = new int[capacity];
		size = 0;
	}

	//============================================================
	// Default Constructor: To initialize Priority Queue with default capacity 10
	//============================================================
	P10_MaxPriorityQueueImplemtnUsgBinaryHeap_ArrayBased() {

		this.capacity = 10;
		heap = new int[capacity];
		size = 0;
	}

	//============================================================
	// Parent Node Method: To find parent index of current node
	// Time Complexity: O(1)
	//============================================================
	public int parentNode(int index) {

		return (index - 1) / 2;
	}

	//============================================================
	// Left Node Method: To find left child index
	// Time Complexity: O(1)
	//============================================================
	public int leftNode(int index) {

		return (2 * index) + 1;
	}

	//============================================================
	// Right Node Method: To find right child index
	// Time Complexity: O(1)
	//============================================================
	public int rightNode(int index) {

		return (2 * index) + 2;
	}

	//============================================================
	// Offer Method: To insert an element into Max Priority Queue
	// Time Complexity: O(log n)
	//============================================================
	void offer(int element) {

		// Check karta hai ki Priority Queue full hai ya nahi.
		// Agar size == capacity hai toh array mein empty position nahi hai.
		if (size == capacity) {

			System.out.println("Queue is full");
			return;
		}

		// New element ko array ki next available position par insert karte hain.
		heap[size] = element;

		// Max Heap property maintain karne ke liye Heapify Up call karte hain.
		heapifyUp(size);

		// Insertion complete hone ke baad size increase karte hain.
		size++;
	}

	//============================================================
	// Heapify Up Method: To maintain Max Heap property after insertion
	// Time Complexity: O(log n)
	//============================================================
	public void heapifyUp(int index) {

		// Current inserted element ka index store karte hain.
		int currentIndex = index;

		// Condition 1: currentIndex > 0
		// Check karta hai ki current node root nahi hai.
		// Root ka index 0 hota hai aur uska koi parent nahi hota.

		// Condition 2: heap[currentIndex] > heap[parentNode(currentIndex)]
		// Current node ki value ko parent ki value se compare karta hai.
		// Agar current node bada hai toh dono ko swap karna padega.

		while (currentIndex > 0 &&
				heap[currentIndex] > heap[parentNode(currentIndex)]) {

			// Current node aur parent node ko swap karte hain.
			int temp = heap[parentNode(currentIndex)];

			heap[parentNode(currentIndex)] = heap[currentIndex];

			heap[currentIndex] = temp;

			// Swap ke baad currentIndex ko parent ke index par move karte hain.
			currentIndex = parentNode(currentIndex);
		}
	}

	//============================================================
	// Poll Method: To remove maximum priority element
	// Time Complexity: O(log n)
	//============================================================
	public int poll() {

		// Check karta hai ki Priority Queue empty hai ya nahi.
		if (size == 0) {

			System.out.println("Priority Queue is empty");
			return -1;
		}

		// Root par maximum element hota hai.
		// Isliye remove hone wale element ko store karte hain.
		int removedElement = heap[0];

		// Last element ko root position par place karte hain.
		heap[0] = heap[size - 1];

		// Last position ko active heap se remove karne ke liye size decrease karte hain.
		size--;

		// Check karta hai ki deletion ke baad heap mein elements bache hain ya nahi.
		if (size > 0) {

			// Root index 0 se Heapify Down start karte hain.
			heapifyDown(0);
		}

		// Jo maximum element remove kiya tha usko return karte hain.
		return removedElement;
	}

	//============================================================
	// Heapify Down Method: To maintain Max Heap property after deletion
	// Time Complexity: O(log n)
	//============================================================
	public void heapifyDown(int currentIndex) {

		// Jab tak Max Heap property restore nahi hoti tab tak loop chalega.
		while (true) {

			// Initially current node ko hi largest assume karte hain.
			// Yahan largest mein node ka index store hota hai.
			int largest = currentIndex;

			// Current node ke left aur right child ke index find karte hain.
			int left = leftNode(currentIndex);
			int right = rightNode(currentIndex);

			// Condition 1: left < size
			// Check karta hai ki left child active heap mein exist karta hai ya nahi.

			// Condition 2: heap[left] > heap[largest]
			// Left child ki value ko currently largest node ki value se compare karta hai.
			// Agar left child bada hai toh largest mein left ka index store karte hain.
			if (left < size && heap[left] > heap[largest]) {

				largest = left;
			}

			// Condition 1: right < size
			// Check karta hai ki right child active heap mein exist karta hai ya nahi.

			// Condition 2: heap[right] > heap[largest]
			// Right child ki value ko ab tak mile largest node ki value se compare karta hai.
			// Agar right child bada hai toh largest mein right ka index store karte hain.
			if (right < size && heap[right] > heap[largest]) {

				largest = right;
			}

			// Check karta hai ki largest ka index abhi bhi currentIndex ke equal hai ya nahi.
			// Agar equal hai toh parent already largest hai.
			// Isliye ab swap ki zarurat nahi hai aur loop stop kar dete hain.
			if (largest == currentIndex) {

				break;
			}

			// Current node aur largest child ko swap karte hain.
			int temp = heap[currentIndex];

			heap[currentIndex] = heap[largest];

			heap[largest] = temp;

			// Swap ke baad currentIndex ko largest child ke index par move karte hain.
			// Ab naye position par bhi Heapify Down check hoga.
			currentIndex = largest;
		}
	}

	//============================================================
	// Peek Method: To return maximum element without removing it
	// Time Complexity: O(1)
	//============================================================
	public int peek() {

		// Check karta hai ki Priority Queue empty hai ya nahi.
		if (size == 0) {

			System.out.println("Priority Queue is empty");
			return -1;
		}

		// Max Heap mein maximum element hamesha root index 0 par hota hai.
		return heap[0];
	}

	//============================================================
	// Is Empty Method: To check whether Priority Queue is empty
	// Time Complexity: O(1)
	//============================================================
	public boolean isEmpty() {

		// Agar size 0 hai toh Queue empty hai.
		return size == 0;
	}

	//============================================================
	// Is Full Method: To check whether Priority Queue is full
	// Time Complexity: O(1)
	//============================================================
	public boolean isFull() {

		// Agar size capacity ke equal hai toh Queue full hai.
		return size == capacity;
	}

	//============================================================
	// Size Method: To return total number of elements
	// Time Complexity: O(1)
	//============================================================
	public int getSize() {

		return size;
	}

	//============================================================
	// Display Method: To display all Heap elements
	// Time Complexity: O(n)
	//============================================================
	void display() {

		// Active heap ke saare elements print karte hain.
		for (int i = 0; i < size; i++) {

			System.out.print(heap[i] + " ");
		}

		System.out.println();
	}

	//============================================================
	// Main Method: To test Max Priority Queue operations
	//============================================================
	public static void main(String args[]) {

		P10_MaxPriorityQueueImplemtnUsgBinaryHeap_ArrayBased heap =
				new P10_MaxPriorityQueueImplemtnUsgBinaryHeap_ArrayBased();

		// Insert elements into Max Priority Queue.
		heap.offer(10);
		heap.offer(20);
		heap.offer(30);
		heap.offer(40);
		heap.offer(50);
		heap.offer(60);
		heap.offer(70);

		// Display Heap elements.
		System.out.println("Heap Elements:");
		heap.display();

		// Maximum element check karte hain without removing it.
		System.out.println("Maximum Element: " + heap.peek());

		// Maximum element remove karte hain.
		System.out.println("Removed Element: " + heap.poll());

		// Deletion ke baad Heap display karte hain.
		System.out.println("After Deletion:");
		heap.display();

		// Total elements check karte hain.
		System.out.println("Queue Size: " + heap.getSize());

		// Empty aur Full status check karte hain.
		System.out.println("Is Empty: " + heap.isEmpty());
		System.out.println("Is Full: " + heap.isFull());
	}
}
