package Lec13A_LinkedList_And_its_Implementions;

public class CircularSinglyLinkedListMainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		CircularSinglyLinkedList Csll=new CircularSinglyLinkedList();
		
		Csll.add(1);
		Csll.add(2);
		Csll.add(3);
		Csll.add(4);
		Csll.add(3);

	//	Csll.addFirst(29);
		Csll.display();
		//System.out.println(Csll.isEmpty());	
		//System.out.println(Csll.size());

	//	Csll.addAtIndexPosition(3, 33);
		//System.out.println(Csll.getAtIndexPositionData(0));
		//System.out.println(Csll.removeFirst());
	//	System.out.println(Csll.removeLast());
		System.out.println(Csll.removeAtIndexPosition(2));
		Csll.display();
		
		System.out.println(Csll.indexOf(60));
		System.out.println(Csll.contains(2));


	}
	
	
	

    }
	
	
	
	
	
	
	
	
	
	
	
	
	


