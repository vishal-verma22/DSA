package Lec15_Queue_And_its_Implementions;

public class P7A_DequeUsgCircularArrayModulasFormulaMainApp {
	
	//============================================================
		// Main Method: To test all Deque operations
		//============================================================

		public static void main(String[] args) {

			P7A_DequeImplementnUsgCircularArrayWithModulasFormula dq =
					new P7A_DequeImplementnUsgCircularArrayWithModulasFormula(5);

			dq.addRear(10);
			dq.addRear(20);
			dq.addRear(30);

			dq.addFront(5);
			dq.addFront(1);

			System.out.println("Deque Elements:");
			dq.display();

			System.out.println("Front Peek: " + dq.getFrontPeek());
			System.out.println("Rear Peek: " + dq.getRearPeek());

			System.out.println("Deleted Front: " + dq.deleteFront());
			System.out.println("Deleted Rear: " + dq.deleteRear());

			System.out.println("After Deletion:");
			dq.display();
		}
}
