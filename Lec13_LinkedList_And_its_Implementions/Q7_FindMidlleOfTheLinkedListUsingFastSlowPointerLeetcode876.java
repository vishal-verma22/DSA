// Leetcode 846 
// Find the middle node of linkedlist
package Lec13_LinkedList_And_its_Implementions;

public class Q7_FindMidlleOfTheLinkedListUsingFastSlowPointerLeetcode876 {

	// Node Class
	static class ListNode {

		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	// Middle Node Method: To find the middle node using Fast and Slow Pointer

	public ListNode middleNode(ListNode head) {

		// Initialize both pointers at the head node
		ListNode fastPointer = head;
		ListNode slowPointer = head;

		// Check fastPointer != null to ensure ki Fast Pointer kisi valid node par hai.
		// Check fastPointer.next != null to ensure ki Fast Pointer ke aage bhi ek node
		// available hai.
		// Kyunki Fast Pointer ko 2 steps move karna hai,
		// isliye fastPointer.next ka null nahi hona zaroori hai.
		//
		// Example: Agar Linked List mein 6 nodes hain,
		// toh last iteration mein Fast Pointer 5th node par hoga.
		// Fast Pointer 2 steps move karega (5 -> 6 -> null).
		// Isliye Fast Pointer null ho jayega aur loop stop ho jayega.

		while (fastPointer != null && fastPointer.next != null) {

			fastPointer = fastPointer.next.next; // Fast Pointer moves 2 nodes.
			slowPointer = slowPointer.next; // Slow Pointer moves 1 node.
		}

		return slowPointer; // Return the middle node.
	}

	// Main Method
	public static void main(String[] args) {

		// Create Linked List: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null

		ListNode head = new ListNode(1);

		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);

		// Create object of the class
		Q7_FindMidlleOfTheLinkedListUsingFastSlowPointerLeetcode876 obj = new Q7_FindMidlleOfTheLinkedListUsingFastSlowPointerLeetcode876();

		// Find middle node
		ListNode middle = obj.middleNode(head);

		// Print middle node
		System.out.println("Middle Node: " + middle.val);

	}
}

// Time Complexity: O(n)
// Space Complexity: O(1)
