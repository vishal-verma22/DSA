package Lec15_Queue_And_its_Implementions;

import java.util.Deque;

public class P7_DequeUsgCircularArrayWithoutModulasFormulaMainApp {

	public static void main(String args[]) {
		P7_DequeImplementnUsgCircularArrayWithoutModulasFormula deque = new P7_DequeImplementnUsgCircularArrayWithoutModulasFormula(
				5);

		deque.AddFront(6);

		deque.AddFront(61);
		deque.AddFront(62);
		deque.AddFront(63);
		deque.AddFront(66);
		deque.AddFront(69);


		
		deque.display();
	}
}
