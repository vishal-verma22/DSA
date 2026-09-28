/*
 CIRCULAR ARRAY - START FROM ANY INDEX
=====================================

Concept:
	Starting the array from any index and traversing it in circular manner.
	For this, use the formula:
			index = (start_index + i) % array.length

Example:

    int[] arr = {10, 20, 30, 40, 50};
	start_index = 3

	Circular traversal:
		3 → 4 → 0 → 1 → 2

Formula:
	index = (start_index + i) % array.length


Loop:
 	for(i = 0; i < n; i++)

Here:
    i = 0 means start from start_index
    i = 1 means move to next index
    i = 2 means move to next index
    ...
    % array.length makes the index circular.


Example:

    i = 0 → (3 + 0) % 5 = 3
    i = 1 → (3 + 1) % 5 = 4
    i = 2 → (3 + 2) % 5 = 0
    i = 3 → (3 + 3) % 5 = 1
    i = 4 → (3 + 4) % 5 = 2

Output:

    40  50  10  20  30


IMPORTANT:

    i < n       → traverse n elements
    i <= n      → traverse n + 1 elements
 */
public class P8_CircularArray_TraversingArrayFromAnyIndexTilLastInCircularManner {

	public static void main(String[] args) {
		
		int[] arr = {10, 20, 30, 40, 50};
		int n=arr.length;
		int start=3;
		
		for(int i=0;i<=n;i++) {
			
			System.out.print((start+i)%n+" ");
		}

	}

	
}
