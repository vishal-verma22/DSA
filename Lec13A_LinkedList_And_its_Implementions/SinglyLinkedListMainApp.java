package Lec13A_LinkedList_And_its_Implementions;

public class SinglyLinkedListMainApp {

	public static void main(String[] args) {

		SinglyLinkedList sll = new SinglyLinkedList();
		sll.add(10);
		sll.add(30);
		sll.add(40);
		sll.add(50);

		//sll.show();

		sll.addFirst(20);
		sll.addFirst(99);
		
		sll.addLast(6);
		sll.addLast(68);
		//sll.show();

		//System.out.println(sll.removeFirst());
		//System.out.println(sll.removeAtIndexPosition(1));

		sll.show();
		System.out.println(sll.contains(3));
	}

}
