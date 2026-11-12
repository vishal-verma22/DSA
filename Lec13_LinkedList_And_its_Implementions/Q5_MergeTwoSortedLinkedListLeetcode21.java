
package Lec13_LinkedList_And_its_Implementions;

public class Q5_MergeTwoSortedLinkedListLeetcode21 {

	//================================================================================
	// LeetCode 21: Merge Two Sorted Lists
	//================================================================================

	// Problem Statement:
	// Humein 2 sorted Singly Linked Lists (list1 aur list2) di hongi.
	// Dono lists ko merge karke ek sorted Linked List banani hai.
	//
	// - Dono Linked Lists ascending order mein sorted hongi.
	// - Dono lists ke nodes ko sorted order mein connect karna hai.
	// - Merged Linked List ka head return karna hai.
	// - Existing nodes ko reuse karna hai, naye nodes create nahi karne.
	//
	// Note:
	// - LeetCode humein 2 sorted Linked Lists pehle se create karke dega.
	// - Humein khud se Linked Lists create karne ki zarurat nahi hai.
	// - Dono lists ki length same ya different ho sakti hai.
	//
	// Method Signature:
	// public ListNode mergeTwoLists(ListNode list1, ListNode list2)
	//
	//================================================================================

	// Working:
	/*
	 * 1. Sabse pehle check karenge ki koi list null toh nahi hai.
	 *    - Agar list1 null hai, toh list2 return kar denge.
	 *    - Agar list2 null hai, toh list1 return kar denge.
	 *
	 * 2. Dono lists ke first node ki values compare karenge.
	 *    - Jis node ki value chhoti hogi, woh head banega.
	 *    - Us list ke pointer ko next node par move kar denge.
	 *
	 * 3. currentNode ko head se initialize karenge.
	 *    Ye merged Linked List mein nodes connect karne ke liye use hoga.
	 *
	 * 4. While loop tab tak chalega jab tak dono lists null nahi hoti.
	 *
	 * 5. Dono lists ke current node ki values compare karenge.
	 *    - Jis node ki value chhoti hogi, use currentNode.next se connect karenge.
	 *    - currentNode ko connected node par move karenge.
	 *    - Selected list pointer ko uske next node par move karenge.
	 *
	 * 6. Jab kisi ek list ke saare nodes traverse ho jayenge (null ho jayegi),
	 *    toh dusri list ke remaining nodes ko directly connect kar denge.
	 *
	 *    - Agar list1 null ho gayi, toh remaining list2 connect hogi.
	 *    - Otherwise, remaining list1 connect hogi.
	 *
	 * 7. Finally, merged Linked List ka head return kar denge.
	 *
	 *================================================================================
	 *
	 * Time Complexity: O(N + M)
	 *
	 * - N = List 1 mein total nodes.
	 * - M = List 2 mein total nodes.
	 * - Dono lists ke har node ko maximum ek baar traverse karte hain.
	 *
	 * Space Complexity: O(1)
	 *
	 * - Hum existing nodes ko hi reuse kar rahe hain.
	 * - Koi extra Linked List ya data structure create nahi kar rahe.
	 *
	 *================================================================================
	 */

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

		// Agar list1 null hai, toh simply list2 return kar do
		if (list1 == null) {
			return list2;
		}

		// Agar list2 null hai, toh simply list1 return kar do
		if (list2 == null) {
			return list1;
		}

		ListNode head;

		// Dono lists ke first node ki values compare karke head decide karenge.
		// Jis node ki value chhoti hogi, woh head banega.
		if (list1.val <= list2.val) {

			head = list1;
			list1 = list1.next;

		} else {

			head = list2;
			list2 = list2.next;
		}

		// currentNode ko head se initialize karenge
		// Ye merged list mein nodes connect karne ke liye use hoga
		ListNode currentNode = head;

		// Loop tab tak chalega jab tak dono lists mein nodes available hain
		while (list1 != null && list2 != null) {

			// Check karenge ki dono lists mein kis node ki value chhoti hai
			if (list1.val < list2.val) {

				// List1 ke smaller node ko currentNode ke next se connect karenge
				currentNode.next = list1;

				// currentNode ko connected node par move karenge
				currentNode = list1;

				// list1 ko uske next node par move karenge
				list1 = list1.next;

			} else {

				// List2 ke smaller ya equal node ko currentNode ke next se connect karenge
				currentNode.next = list2;

				// currentNode ko connected node par move karenge
				currentNode = list2;

				// list2 ko uske next node par move karenge
				list2 = list2.next;
			}
		}

		// Jo list abhi null nahi hui hai, uske remaining nodes connect karenge
		if (list1 == null) {

			// Agar list1 complete ho gayi hai, toh remaining list2 connect kar do
			currentNode.next = list2;

		} else {

			// Agar list2 complete ho gayi hai, toh remaining list1 connect kar do
			currentNode.next = list1;
		}

		// Merged Linked List ka starting node return karenge
		return head;
	}

	//================================================================================
	// Time Complexity: O(N + M)
	// Space Complexity: O(1)
	//================================================================================

	// ListNode class for Eclipse implementation
	static class ListNode {

		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}
}
