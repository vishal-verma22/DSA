// CircularArray

/*
 CIRCULAR ARRAY IN JAVA
======================

Definition:
		Circular Array ek normal array jaisa hi hota hai, lekin isme last
		index ke baad hum logically first index par wapas aa jaate hain.

Example:
	int[] arr = {10, 20, 30, 40, 50};

	Index:
		0    1    2    3    4
		10   20   30   40   50

Circular form:

		0 -> 1 -> 2 -> 3 -> 4
		^                   |
		|___________________|

		4 ke baad wapas 0 par aayega.

Main Concept:
		Circular array mein index ko circular banane ke liye MODULO (%) operator
		use kiya jata hai.

Formula:
		index = i % arr.length

Example:
		arr.length = 5

		i = 0  ->  0 % 5 = 0
		i = 1  ->  1 % 5 = 1
		i = 2  ->  2 % 5 = 2
		i = 3  ->  3 % 5 = 3
		i = 4  ->  4 % 5 = 4
		i = 5  ->  5 % 5 = 0  (back to first index)
		i = 6  ->  6 % 5 = 1
		i = 7  ->  7 % 5 = 2

	So:
		0 -> 1 -> 2 -> 3 -> 4 -> 0 -> 1 -> 2 -> ...

Important:
		(i + 1) % arr.length
		= current index ka next circular index.

Example:
		currentIndex = 4

		(4 + 1) % 5
		= 5 % 5
		= 0

	So index 4 ke baad index 0 aayega.

Use:
		Circular Array ka use Circular Queue, Ring Buffer aur
		circular DSA problems mein hota hai.

 Another Concept:
	Starting the array from any index and traversing it in circular manner.
	For this, use the formula:
		index = (start_index + i) % array.length

 */
public class P7_CircularArray_TraverseTheArrayElemntInCircularWay {

	public static void main(String[] args) {
		
		int[] arr = {10, 20, 30, 40, 50};
		int n=arr.length;
		
		for(int i=0;i<=n;i++) {
			
			System.out.print(i%n+" ");
		}
		
		
		

	}

}
