
package Lec13_LinkedList_And_its_Implementions;

//================================================================================
// LeetCode 160: Intersection of Two Linked Lists
//================================================================================

// Problem Statement:
// Given the heads of two singly linked lists, headA and headB,
// find the node at which the two linked lists intersect.
//
// - Return the reference of the intersection node.
// - If the lists do not intersect, return null.
//
// Note:
// - LeetCode humein 2 Linked Lists pehle se create karke dega.
// - Agar dono lists intersect karti hain, toh unke beech connection
//   pehle se bana hua hoga.
// - Humein khud se lists create ya connect karne ki zarurat nahi hai.
// - Humein 2 completely separate lists nahi milengi jinhe humein
//   khud se intersect karna padega.
//
// Method Signature:
// public ListNode getIntersectionNode(ListNode headA, ListNode headB)

//================================================================================

// Working:
/*
 * 1. pointerA starts from headA and pointerB starts from headB.
 *
 * 2. Both pointers traverse their respective Linked Lists.
 *
 * 3. When a pointer reaches null, it starts traversing the other list.
 *
 *    i.e.:
 *    - Pointer A apni List A traverse karega.
 *    - Jab List A complete ho jayegi, i.e. tail ke next mein null aa jayega,
 *      toh pointerA List B ke starting point (headB) se traverse karega.
 *
 *    - Same logic pointerB ke liye opposite direction mein hai.
 *    - Pointer B pehle List B aur phir List A traverse karega.
 *
 * 4. Isse dono pointers equal distance travel karenge, chahe dono lists
 *    ki length different ho.
 *
 * 5. Agar intersection exist karta hai, toh dono pointers same
 *    intersection node par milenge.
 *
 * 6. Agar intersection exist nahi karta, toh dono pointers null par milenge.
 *
 *================================================================================
 *
 * Why do we traverse each other's list?
 *
 * Humne ek dusre ki list isliye traverse karwayi taaki dono pointers
 * equal distance (nodes) cover karein.
 *
 * Maan lo:
 * - List A ki length = 5
 * - List B ki length = 4
 * - Common part ki length = 2
 *
 * Pointer    First Traversal    Second Traversal
 * A              5 nodes             4 nodes
 * B              4 nodes             5 nodes
 *
 * Ab dono pointers total equal distance travel karenge.
 *
 * - Pointer A = 5 + 4 = 9 nodes
 * - Pointer B = 4 + 5 = 9 nodes
 *
 *================================================================================
 */
public class Q4_FindTheIntersectionNodeInLinkedListLeetCode160 {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		// Pointers to traverse both Linked Lists, just like tempNode
		ListNode pointerA = headA;
		ListNode pointerB = headB;

		// Traverse the loop until both pointers point to the same node
		while (pointerA != pointerB) {

			// If pointerA is not null, move to the next node in List A.
			// If pointerA becomes null, start traversing List B.
			if (pointerA != null) {
				pointerA = pointerA.next;

			} else {
				pointerA = headB; // Start traversing List B
			}

			// If pointerB is not null, move to the next node in List B.
			// If pointerB becomes null, start traversing List A.
			if (pointerB != null) {
				pointerB = pointerB.next;

			} else {
				pointerB = headA; // Start traversing List A
			}

		}

		return pointerB;
	}

	// ================================================================================
	// Time Complexity: O(N + M)
	// Space Complexity: O(1)
	// ================================================================================

	// ListNode class (for Eclipse implementation)
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}}

