
package Lec13A_LinkedList_And_its_Implementions;

public class DoublyLinkedListMainApp {

	public static void main(String[] args) {

		DoublyLinkedList Dll = new DoublyLinkedList();

		// Add elements
		Dll.add(12);
		Dll.add(8);
		Dll.add(108);
		Dll.add(1555);

		// Add First
		Dll.addFirst(10);
		Dll.addFirst(999);

		Dll.displayForward();

		System.out.println();

		Dll.displayBackward();

		System.out.println();

		System.out.println("Size of DLL => " + Dll.size());

		System.out.println();

		// Add at index position
		Dll.addAtIndexPosition(2, 22);
		Dll.addAtIndexPosition(0, 33);
		Dll.addAtIndexPosition(Dll.size(), 44);

		Dll.displayForward();

		System.out.println();

		System.out.println("Get element => " + Dll.get(5));

		System.out.println("Contains 108 => " + Dll.contains(108));

		System.out.println("Contains 500 => " + Dll.contains(500));

		System.out.println("Is DLL empty => " + Dll.isEmpty());

		System.out.println();

		// Set element
		Dll.set(2, 1000);

		Dll.displayForward();

		System.out.println();

		// Remove First
		System.out.println("Removed First => " + Dll.removeFirst());

		Dll.displayForward();

		System.out.println();

		// Remove Last
		System.out.println("Removed Last => " + Dll.removeLast());

		Dll.displayForward();

		System.out.println();

		// Remove at index position
		System.out.println("Removed at index => " + Dll.removeAtIndexPosition(2));

		Dll.displayForward();

		System.out.println();

		System.out.println("Size of DLL => " + Dll.size());

		System.out.println();

		// Single node testing
		Dll.removeFirst();
		Dll.removeFirst();
		Dll.removeFirst();
		Dll.removeFirst();
		Dll.removeFirst();

		System.out.println("Is DLL empty => " + Dll.isEmpty());

		// Add and remove single node
		Dll.add(100);

		System.out.println("Removed => " + Dll.removeLast());

		System.out.println("Is DLL empty => " + Dll.isEmpty());

	}

}
