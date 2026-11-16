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

	void addFront(int element) {

		if ((front == 0 && rear == capacity - 1) || front == rear + 1) {
			System.out.println("Queue is full");
			return;

		}

		else if (front == -1) {

			front = rear = 0;
		} else if (front == 0) {

			front = capacity - 1;
		} else {

			front--;
		}

		arr[front] = element;
	}

	void addRear(int element) {

		if ((front == 0 && rear == capacity - 1) || front == rear + 1) {
			System.out.println("Queue is full");
			return;

		} else if (front == -1) {

			rear = front = 0;
		} else if (rear == capacity - 1) {
			rear = 0;
		} else {

			rear++;
		}
		arr[rear] = element;
	}

	
	
	//============================================
	// DeleteFront Method: To delete an element from the front
	//============================================

	public int deleteFront() {

	    if(front == -1) {
	        System.out.println("Deque is empty");
	        return -1;
	    }

	    int removedElement = arr[front];

	    if(front == rear) {
	        front = rear = -1;
	    }
	    else if(front == capacity - 1) {
	        front = 0;
	    }
	    else {
	        front++;
	    }

	    return removedElement;
	}
	
	
	
	//============================================
	// DeleteRear Method: To delete an element from the rear
	//============================================

	public int deleteRear() {

	    if(front == -1) {
	        System.out.println("Deque is empty");
	        return -1;
	    }

	    int removedElement = arr[rear];

	    if(front == rear) {
	        front = rear = -1;
	    }
	    else if(rear == 0) {
	        rear = capacity - 1;
	    }
	    else {
	        rear--;
	    }

	    return removedElement;
	}
	
	void display() {

		int i = front;
		while (true) {
			System.out.print(arr[i] + " ");

			if (i == rear) {
				break;
			}
			i = (i + 1) % capacity;

		}
	}

}
