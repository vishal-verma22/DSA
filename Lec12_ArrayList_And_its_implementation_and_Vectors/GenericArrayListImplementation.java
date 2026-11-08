package Lec12_ArrayList_And_its_implementation_and_Vectors;

public class GenericArrayListImplementation<T> {

	int capacity;
	int size;
	Object[] arr;
// constructor to initilize the array
	public GenericArrayListImplementation() {
		capacity = 10;
		arr = new Object [capacity];
		size = 0;
	}

// Add methods --> To add elemnts in arraylist

	public void add(T element) {

		// resing the array if array is full
		if (size == capacity) {
			grow();
		}
		arr[size] = element;
		size++;
	}

	void grow() {
		capacity = capacity + capacity / 2;
		Object newArray[] = new Object[capacity];

		// for inserting all the old array elemnt in new array
		for (int i = 0; i < size; i++) {

			newArray[i] = arr[i];
		}

		// old array point to new array
		arr = newArray;

	}

	// Add methods --> To add elements in arraylist based on index

	public void add(int index, T element) {

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
	public T remove(int index) {

		if (index >= size) {
			throw new IndexOutOfBoundsException("index out of bound " + index);
		}

		if (index < 0) {
			throw new IndexOutOfBoundsException("index out of bound: " + index);
		}

		T removedElement= (T)arr[index];
		// shifting elements
		for(int i=index;i<size-1;i++) {
			
			arr[i]=arr[i+1];
		}
		// reducing the size of array by 1
		size--;
		return removedElement;
	}
	
	
	// getting array elements by index

	public T get(int index) {

		if (index >= size) {
			throw new IndexOutOfBoundsException(" you cannot insert value directly at higher index " + index);
		}

		if (index < 0) {
			throw new IndexOutOfBoundsException("index cannot be negative: " + index);
		}

		return (T)arr[index];
	}

	// set array elements by index(updating)

	public void set(int index, T element) {

		if (index >= size) {
			throw new IndexOutOfBoundsException(" you cannot insert value directly at higher index " + index);
		}

		if (index < 0) {
			throw new IndexOutOfBoundsException("index cannot be negative: " + index);
		}

		arr[index] = element;
	}
	
	
	// for proper representation of arrayList
	@Override
	public String toString() {
			StringBuilder sb=new StringBuilder("[");
			
			for(int i=0;i<size;i++) {
				sb.append(arr[i]);
				
				if(i!=size-1)
				sb.append(",");

				
			}
		
			sb.append("]");
		
		return sb.toString();
	}

}
