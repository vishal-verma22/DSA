package Lec12_ArrayList_And_its_implementation_and_Vectors;

public class ArrayListImplementation {

	int capacity;
	int size;
	int arr[];

// constructor to initilize the array
	public ArrayListImplementation() {
		capacity = 10;
		arr = new int[capacity];
		size = 0;
	}

// Add methods --> To add elemnts in arraylist

	public void add(int element) {

		// resing the array if array is full
		if (size == capacity) {
			grow();
		}
		arr[size] = element;
		size++;
	}

	void grow() {
		capacity = capacity + capacity / 2;
		int newArray[] = new int[capacity];

		// for inserting all the old array elemnt in new array
		for (int i = 0; i < size; i++) {

			newArray[i] = arr[i];
		}

		// old array point to new array
		arr = newArray;

	}

	// Add methods --> To add elements in arraylist based on index

	public void add(int index, int element) {

		if (index > size) {
			throw new IndexOutOfBoundsException(" you cannot insert value directly at higher index " + index);
		}

		if (index < 0) {
			throw new IndexOutOfBoundsException("index cannot be negative: " + index);
		}

		// resing the array if array is full

		if (size == capacity) {
			grow();
		}

		// adding elemnts in middle or start of array

		for (int i = size; i > index; i--) {
			arr[i] = arr[i - 1];
		}
		arr[index] = element;
		size++;


	}

	// Display method to display all elemnts of arrayList
	void display() {
		for (int i = 0; i < size; i++) {

			System.out.print(arr[i] + " ");
		}
	}

	// getting array capacity

	public int getCapacity() {

		return capacity;
	}

	// getting array size

	public int getSize() {

		return size;
	}

	// removing elements from array list based on index
	public int remove(int index) {

		if (index >= size) {
			throw new IndexOutOfBoundsException("index out of bound " + index);
		}

		if (index < 0) {
			throw new IndexOutOfBoundsException("index out of bound: " + index);
		}

		int removedElement=arr[index];
		// shifting elements
		for(int i=index;i<size-1;i++) {
			
			arr[i]=arr[i+1];
		}
		// reducing the size of array by 1
		size--;
		return removedElement;
	}
	
	
	// getting array elements by index

	public int get(int index) {

		if (index >= size) {
			throw new IndexOutOfBoundsException(" you cannot insert value directly at higher index " + index);
		}

		if (index < 0) {
			throw new IndexOutOfBoundsException("index cannot be negative: " + index);
		}

		return arr[index];
	}

	// set array elements by index(updating)

	public void set(int index, int element) {

		if (index >= size) {
			throw new IndexOutOfBoundsException(" you cannot insert value directly at higher index " + index);
		}

		if (index < 0) {
			throw new IndexOutOfBoundsException("index cannot be negative: " + index);
		}

		arr[index] = element;
	}

}
