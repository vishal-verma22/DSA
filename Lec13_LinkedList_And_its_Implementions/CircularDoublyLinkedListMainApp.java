package Lec13_LinkedList_And_its_Implementions;

public class CircularDoublyLinkedListMainApp {

	public static void main(String args[]) {

		CircularDoublyLinkedList Cdll = new CircularDoublyLinkedList();
		Cdll.add(32);
		Cdll.add(33);
		Cdll.add(34);
		Cdll.add(35);
		Cdll.add(36);
		Cdll.add(37);
		Cdll.addFirst(30);
		Cdll.display();

		//Cdll.addAtIndexPosition(2, 9);

//Cdll.clear();
		
		//Cdll.removeAtIndexPosition(2);
	System.out.println(Cdll.contains(3));
		System.out.println( Cdll.indexOf(34));
		 Cdll.display();
	}

}
