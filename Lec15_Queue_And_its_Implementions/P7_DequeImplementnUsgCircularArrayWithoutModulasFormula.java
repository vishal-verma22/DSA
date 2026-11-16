package Lec15_Queue_And_its_Implementions;

public class P7_DequeImplementnUsgCircularArrayWithoutModulasFormula {
	
	int capacity;
	int arr[];
	int front;
	int rear;
	
	P7_DequeImplementnUsgCircularArrayWithoutModulasFormula(int capacity){
		this.capacity=capacity;
		
		arr=new int[capacity];
		rear=front=-1;
		
	}
	
	
	void AddFront(int element){
		
	    if ((front == 0 && rear == capacity - 1) || front == rear + 1) {
			System.out.println("Queue is full");
			return;
			
		}
		
		else if(front==-1) {
			
			front=rear=0;
		}else if(front==0) {
			
			front=capacity-1;
		}else {
			
			front--;
		}
		
		arr[front]=element;
	}
	
	
	
	void display() {
		
		int i=front;
		while(true) {
			System.out.print(arr[i] + " ");
			
			if(i==rear) {
				break;
			}
			i=(i+1)%capacity;
			
		}
	}

}
