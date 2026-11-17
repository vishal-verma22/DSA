
/*
======================================================================
              MIN PRIORITY QUEUE USING BINARY HEAP
                         ARRAY BASED
======================================================================


1. WHAT IS HEAP?

Heap ek special type ka Complete Binary Tree (CBT) hai jo
Heap Property follow karta hai.

Complete Binary Tree (CBT):

- Har level completely filled hota hai, except last level.
- Last level ke nodes left to right fill hote hain.
- Beech mein koi empty position nahi hoti.

Heap Property:

- Min Heap mein parent ki value children se chhoti ya equal hoti hai.
- Max Heap mein parent ki value children se badi ya equal hoti hai.


======================================================================
2. TYPES OF HEAP
======================================================================


A. MIN HEAP:

- Min Heap mein parent node ki value apne children ki value se
  chhoti ya equal hoti hai.

- Root node par hamesha minimum element hota hai.

- Har parent node apne left aur right child se chhota ya equal
  hona chahiye.

Example:

                              2
                       /            \
                     8                12
                  /     \          /      \
                18       22       25       30
               /  \     /  \     /  \     /  \
              35  40   45  50   55  60   65  70

Explanation:

- Root node = 2 (Minimum element)
- 2 < 8 and 12
- 8 < 18 and 22
- 12 < 25 and 30
- 18 < 35 and 40
- 22 < 45 and 50
- 25 < 55 and 60
- 30 < 65 and 70

Isliye ye ek valid Min Heap hai.


Array Representation:

Index :   0   1   2   3   4   5   6   7   8   9  10  11  12  13  14

Value :   2   8  12  18  22  25  30  35  40  45  50  55  60  65  70


B. MAX HEAP:

- Max Heap mein parent node ki value apne children ki value se
  badi ya equal hoti hai.

- Root node par hamesha maximum element hota hai.

- Har parent node apne left aur right child se bada ya equal
  hona chahiye.

Example:

                              100
                       /             \
                     90               95
                  /     \          /      \
                80       85       88       92
               /  \     /  \     /  \     /  \
              70  75   76  78   79  82   84  86


Explanation:

- Root node = 100 (Maximum element)
- 100 > 90 and 95
- 90 > 80 and 85
- 95 > 88 and 92
- 80 > 70 and 75
- 85 > 76 and 78
- 88 > 79 and 82
- 92 > 84 and 86

Isliye ye ek valid Max Heap hai.


Array Representation:

Index :  0    1   2   3   4   5   6   7   8   9  10  11  12  13  14

Value : 100  90  95  80  85  88  92  70  75  76  78  79  82  84  86


IMPORTANT:

Min Heap:
- Minimum element root par hota hai.
- Parent <= Children

Max Heap:
- Maximum element root par hota hai.
- Parent >= Children

NOTE:
Heap ka array completely sorted nahi hota.
Sirf parent-child relationship maintain hota hai.


======================================================================
3. ARRAY REPRESENTATION OF HEAP
======================================================================

Heap ko array mein store kar sakte hain because Heap ek
Complete Binary Tree hota hai.

Example:

                  10
                /    \
              20      30
             /  \    /  \
            40  50  60  70

Array = [10, 20, 30, 40, 50, 60, 70]


Index Representation:

                  0
                /   \
               1     2
              / \   / \
             3   4 5   6

Array Index = [0, 1, 2, 3, 4, 5, 6]


======================================================================
4. IMPORTANT FORMULAS (0-BASED INDEXING)
======================================================================

Parent Index:

        (index - 1) / 2

Left Child Index:

        (2 * index) + 1

Right Child Index:

        (2 * index) + 2


Example:

Suppose currentIndex = 2

Parent Index = (2 - 1) / 2
             = 0

Left Child Index = (2 * 2) + 1
                 = 5

Right Child Index = (2 * 2) + 2
                  = 6


======================================================================
5. WHAT IS PRIORITY QUEUE?
======================================================================

Priority Queue ek special type ka Queue hai jisme elements
priority ke according remove hote hain.

Normal Queue:
- FIFO follow karta hai.
- First In First Out.
- Jo element pehle insert hua, woh pehle remove hota hai.

Priority Queue:
- Elements priority ke according remove hote hain.
- Sabse high priority wala element pehle remove hota hai.

Min Priority Queue:
- Minimum value ki priority sabse high hoti hai.
- Isliye minimum element pehle remove hota hai.

Max Priority Queue:
- Maximum value ki priority sabse high hoti hai.
- Isliye maximum element pehle remove hota hai.

Binary Heap ka use karke Priority Queue implement kar sakte hain.


======================================================================
6. INSERTION IN MIN HEAP (OFFER)
======================================================================

Insertion ka main logic:

1. New element ko array ke next available position par insert karte hain.
2. Current element ko uske parent ke saath compare karte hain.
3. Agar current element parent se chhota hai toh swap karte hain.
4. Current index ko parent index par move karte hain.
5. Jab tak Min Heap property maintain nahi hoti, repeat karte hain.

Is process ko HEAPIFY UP kehte hain.

Direction: BOTTOM TO TOP.

Example:

Initially Heap:

                 10
               /    \
             20      30
            /  \
           40  50

Array = [10, 20, 30, 40, 50]


STEP 1: Insert 5 at next available position.

                 10
               /    \
             20      30
            /  \
           40  50
          /
         5

Array = [10, 20, 30, 40, 50, 5]


STEP 2: Compare 5 with its parent 30.

5 < 30, so swap.

                 10
               /    \
             20      5
            /  \    /
           40  50  30

Array = [10, 20, 5, 40, 50, 30]


STEP 3: Compare 5 with its parent 10.

5 < 10, so swap.

                  5
               /     \
             20       10
            /  \     /
           40  50   30

Array = [5, 20, 10, 40, 50, 30]


FINAL RESULT:

                 5
               /    \
             20      10
            /  \    /
           40  50  30

Min Heap property is maintained.


INSERTION IMPORTANT:

- New element hamesha next available position par insert hota hai.
- Uske baad Heapify Up hota hai.
- Parent ke saath comparison hota hai.
- Smaller element upar move karta hai.

Time Complexity = O(log n)


======================================================================
7. HEAPIFY UP
======================================================================

Heapify Up insertion ke baad use hota hai.

Flow:

1. Current element ka index store karte hain.
2. Current index > 0 check karte hain.
3. Current element ko parent ke saath compare karte hain.
4. Agar current element smaller hai toh swap karte hain.
5. Current index ko parent index par update karte hain.
6. Loop repeat hota hai.

Important Conditions:

Condition 1:

currentIndex > 0

- Check karta hai ki current node root nahi hai.
- Root ka index 0 hota hai.
- Root ka koi parent nahi hota.

Condition 2:

heap[currentIndex] < heap[parentNode(currentIndex)]

- Current node ki value parent ki value se compare hoti hai.
- Agar current node chhota hai toh swap karna padega.
- Dono conditions true hongi tabhi loop execute hoga.

Time Complexity = O(log n)


======================================================================
8. DELETION IN MIN HEAP (POLL)
======================================================================

Min Heap mein deletion hamesha root se hota hai because
root par minimum element hota hai.

Deletion ka main logic:

1. Root element ko removedElement variable mein store karte hain.
2. Last element ko root position par place karte hain.
3. Size decrease karte hain.
4. Root ko left aur right child ke saath compare karte hain.
5. Smallest child ke saath swap karte hain.
6. Current index ko swapped child ke index par move karte hain.
7. Jab tak Min Heap property restore nahi hoti, repeat karte hain.

Is process ko HEAPIFY DOWN kehte hain.

Direction: TOP TO BOTTOM.


DELETION EXAMPLE:

Initially:

                  5
               /     \
             20       10
            /  \     /  \
           40  50   30   35

Array = [5, 20, 10, 40, 50, 30, 35]


STEP 1: Remove root element 5.

removedElement = 5


STEP 2: Last element 35 ko root par place karo.

                 35
               /    \
             20      10
            /  \    /
           40  50  30

Array = [35, 20, 10, 40, 50, 30]


STEP 3: Root 35 ko uske children se compare karo.

Left Child  = 20
Right Child = 10

Smallest = 10

Because 10 < 35, swap with 10.

                  10
               /     \
             20       35
            /  \     /
           40  50   30

Array = [10, 20, 35, 40, 50, 30]


STEP 4: Ab 35 ko uske children se compare karo.

Left Child  = 30
Right Child = Does not exist

30 < 35, so swap.

                  10
               /     \
             20       30
            /  \     /
           40  50   35

Array = [10, 20, 30, 40, 50, 35]


FINAL RESULT:

                  10
               /     \
             20       30
            /  \     /
           40  50   35

Removed Element = 5

Min Heap property is restored.


DELETION IMPORTANT:

- Root element remove hota hai.
- Last element root par aata hai.
- Size decrease hota hai.
- Smallest child ke saath swap hota hai.
- Current index neeche move karta hai.

Time Complexity = O(log n)


======================================================================
9. HEAPIFY DOWN
======================================================================

Heapify Down deletion ke baad use hota hai.

Flow:

1. Current index initially root index 0 hota hai.
2. Smallest ko currentIndex assume karte hain.
3. Left child ka index calculate karte hain.
4. Right child ka index calculate karte hain.
5. Left child exist karta hai aur smaller hai toh smallest update.
6. Right child exist karta hai aur smaller hai toh smallest update.
7. Agar smallest == currentIndex hai toh loop break.
8. Otherwise current node aur smallest child ko swap.
9. Current index ko smallest par move karte hain.
10. Process repeat hota hai.

IMPORTANT CONDITIONS:

Condition 1:

left < size

- Check karta hai ki left child active heap mein exist karta hai.
- Agar left index size se chhota hai toh valid child hai.

Condition 2:

heap[left] < heap[smallest]

- Left child ki value ko currently smallest node ki value
  se compare karta hai.
- Agar left child chhota hai toh smallest = left karte hain.

Condition 3:

right < size

- Check karta hai ki right child active heap mein exist karta hai.

Condition 4:

heap[right] < heap[smallest]

- Right child ko ab tak mile smallest node se compare karta hai.
- Agar right child chhota hai toh smallest = right karte hain.

Condition 5:

smallest == currentIndex

- Agar smallest ka index currentIndex ke equal hai,
  iska matlab parent already smallest hai.
- Ab swap ki zarurat nahi hai.
- Isliye loop break kar dete hain.

Time Complexity = O(log n)


======================================================================
10. PEEK METHOD
======================================================================

- Peek method minimum element ko return karta hai.
- Element remove nahi hota.
- Min Heap mein minimum element root index 0 par hota hai.

Time Complexity = O(1)


======================================================================
11. IS EMPTY AND IS FULL
======================================================================

isEmpty():

- Check karta hai ki size 0 hai ya nahi.
- Agar size == 0 hai toh Queue empty hai.

isFull():

- Check karta hai ki size capacity ke equal hai ya nahi.
- Agar size == capacity hai toh Queue full hai.

Time Complexity = O(1)


======================================================================
12. INDEX VS VALUE
======================================================================

currentIndex:
- Current node ka index.

heap[currentIndex]:
- Current node ki value.

left:
- Left child ka index.

heap[left]:
- Left child ki value.

right:
- Right child ka index.

heap[right]:
- Right child ki value.

smallest:
- Smallest node ka index.

heap[smallest]:
- Smallest node ki value.


======================================================================
13. TIME AND SPACE COMPLEXITY
======================================================================

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
14. IMPORTANT POINTS
======================================================================

1. Heap ek Complete Binary Tree hota hai.
2. Heap ko array se efficiently implement kar sakte hain.
3. Min Heap mein minimum element root par hota hai.
4. Max Heap mein maximum element root par hota hai.
5. Insertion mein Heapify Up use hota hai.
6. Deletion mein Heapify Down use hota hai.
7. Heap ka array sorted nahi hota.
8. Min Priority Queue mein minimum value pehle remove hoti hai.
9. Max Priority Queue mein maximum value pehle remove hoti hai.
10. Search operation O(n) hota hai because array sorted nahi hota.

======================================================================
*/


package Lec15_Queue_And_its_Implementions;

public class P9_MinPriorityQueueImplemtnUsgBinaryHeap_ArrayBased {

	int capacity;
	int heap[];
	int size;

	//============================================================
	// Constructor: To initialize Priority Queue with given capacity
	//============================================================
	P9_MinPriorityQueueImplemtnUsgBinaryHeap_ArrayBased(int capacity) {

		this.capacity = capacity;
		heap = new int[capacity];
		size = 0;
	}

	//============================================================
	// Default Constructor: To initialize Priority Queue with default capacity 10
	//============================================================
	P9_MinPriorityQueueImplemtnUsgBinaryHeap_ArrayBased() {

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
	// Offer Method: To insert an element into Min Priority Queue
	// Time Complexity: O(log n)
	//============================================================
	void offer(int element) {

		// Check karta hai ki Priority Queue full hai ya nahi.
		// Agar size == capacity hai toh array mein koi empty position nahi hai.
		if (size == capacity) {

			System.out.println("Queue is full");
			return;
		}

		// New element ko array ki next available position par insert karte hain.
		heap[size] = element;

		// Heapify Up call karte hain taaki Min Heap property maintain rahe.
		// New element initially index size par insert hua hai.
		heapifyUp(size);

		// Insertion complete hone ke baad size increase karte hain.
		size++;
	}

	//============================================================
	// Heapify Up Method: To maintain Min Heap property after insertion
	// Time Complexity: O(log n)
	//============================================================
	public void heapifyUp(int index) {

		// Current inserted element ka index store karte hain.
		int currentIndex = index;

		// Condition 1: currentIndex > 0
		// Check karta hai ki current node root nahi hai.
		// Root ka index 0 hota hai aur uska koi parent nahi hota.

		// Condition 2: heap[currentIndex] < heap[parentNode(currentIndex)]
		// Current node ki value ko parent ki value se compare karta hai.
		// Agar current node chhota hai toh dono ko swap karna padega.

		// Dono conditions true hone par hi loop execute hoga.
		while (currentIndex > 0 &&
				heap[currentIndex] < heap[parentNode(currentIndex)]) {

			// Current node aur parent node ko swap karte hain.
			int temp = heap[parentNode(currentIndex)];

			heap[parentNode(currentIndex)] = heap[currentIndex];

			heap[currentIndex] = temp;

			// Swap ke baad currentIndex ko parent ke index par move karte hain.
			// Ab naye parent ke saath comparison hoga.
			currentIndex = parentNode(currentIndex);
		}
	}

	//============================================================
	// Poll Method: To remove minimum priority element
	// Time Complexity: O(log n)
	//============================================================
	public int poll() {

		// Check karta hai ki Priority Queue empty hai ya nahi.
		// Agar size == 0 hai toh remove karne ke liye element nahi hai.
		if (size == 0) {

			System.out.println("Priority Queue is empty");
			return -1;
		}

		// Root par minimum element hota hai.
		// Isliye remove hone wale element ko store karte hain.
		int removedElement = heap[0];

		// Last element ko root position par place karte hain.
		// Kyunki root remove hone ke baad root ki position empty ho gayi.
		heap[0] = heap[size - 1];

		// Size decrease karte hain.
		// Last position ab active heap ka part nahi rahegi.
		size--;

		// Check karta hai ki deletion ke baad heap mein elements bache hain ya nahi.
		// Agar size > 0 hai toh Heapify Down karna zaroori hai.
		// Agar size == 0 hai toh Heapify Down ki zarurat nahi hai.
		if (size > 0) {

			// Root index 0 se Heapify Down start karte hain.
			heapifyDown(0);
		}

		// Jo minimum element remove kiya tha usko return karte hain.
		return removedElement;
	}

	//============================================================
	// Heapify Down Method: To maintain Min Heap property after deletion
	// Time Complexity: O(log n)
	//============================================================
	public void heapifyDown(int currentIndex) {

		// Jab tak Min Heap property restore nahi hoti tab tak loop chalega.
		while (true) {

			// Initially current node ko hi smallest assume karte hain.
			// Yahan smallest mein node ka index store hota hai.
			int smallest = currentIndex;

			// Current node ke left aur right child ke index find karte hain.
			int left = leftNode(currentIndex);
			int right = rightNode(currentIndex);

			// Condition 1: left < size
			// Check karta hai ki left child active heap mein exist karta hai ya nahi.
			// Agar left index size se chhota hai toh left child valid hai.

			// Condition 2: heap[left] < heap[smallest]
			// Left child ki value ko currently smallest node ki value se compare karta hai.
			// Agar left child chhota hai toh smallest mein left ka index store karte hain.

			// Dono conditions true hone par hi smallest update hoga.
			if (left < size && heap[left] < heap[smallest]) {

				smallest = left;
			}

			// Condition 1: right < size
			// Check karta hai ki right child active heap mein exist karta hai ya nahi.

			// Condition 2: heap[right] < heap[smallest]
			// Right child ki value ko ab tak mile smallest node ki value se compare karta hai.
			// Agar right child chhota hai toh smallest mein right ka index store karte hain.

			// Yahan right child ko parent aur left child dono se compare kiya ja sakta hai.
			if (right < size && heap[right] < heap[smallest]) {

				smallest = right;
			}

			// Check karta hai ki smallest ka index abhi bhi currentIndex ke equal hai ya nahi.
			// Agar equal hai toh parent already smallest hai.
			// Iska matlab Min Heap property maintain ho chuki hai.
			// Isliye ab swap ki zarurat nahi hai aur loop stop kar dete hain.
			if (smallest == currentIndex) {

				break;
			}

			// Current node aur smallest child ko swap karte hain.
			int temp = heap[currentIndex];

			heap[currentIndex] = heap[smallest];

			heap[smallest] = temp;

			// Swap ke baad currentIndex ko smallest child ke index par move karte hain.
			// Ab us naye position par bhi Heapify Down check hoga.
			currentIndex = smallest;
		}
	}

	//============================================================
	// Peek Method: To return minimum element without removing it
	// Time Complexity: O(1)
	//============================================================
	public int peek() {

		// Check karta hai ki Priority Queue empty hai ya nahi.
		if (size == 0) {

			System.out.println("Priority Queue is empty");
			return -1;
		}

		// Min Heap mein minimum element hamesha root index 0 par hota hai.
		// Sirf return karte hain, remove nahi karte.
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
	// Main Method: To test Min Priority Queue operations
	//============================================================
	public static void main(String args[]) {

		P9_MinPriorityQueueImplemtnUsgBinaryHeap_ArrayBased heap =
				new P9_MinPriorityQueueImplemtnUsgBinaryHeap_ArrayBased();

		// Insert elements into Min Priority Queue.
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

		// Minimum element check karte hain without removing it.
		System.out.println("Minimum Element: " + heap.peek());

		// Minimum element remove karte hain.
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
