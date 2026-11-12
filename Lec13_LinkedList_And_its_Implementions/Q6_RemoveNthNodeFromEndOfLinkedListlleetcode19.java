package Lec13_LinkedList_And_its_Implementions;



//============================================================
	// LeetCode 19: Remove Nth Node From End of List
	//
	// Problem Statement:
	// Given a linked list, remove the nth node from the end
	// of the list and return its head.
	//
	// Example:
	// Input:  head = [1, 2, 3, 4, 5], n = 2
	// Output: [1, 2, 3, 5]
	//
	//============================================================

//============================================================
// Working:
//
// Input: [1, 2, 3, 4, 5], n = 2
//
// Step 1:
// Dummy -> 1 -> 2 -> 3 -> 4 -> 5
// p1 and p2 both start from Dummy.
//
// Step 2:
// p1 ko 2 steps move karenge.
// p1 = 2, p2 = Dummy
//
// Step 3:
// Ab dono pointers ko ek-ek step move karenge.
// p1 = 5, p2 = 3
// p1.next == null, so loop stop.
//
// Step 4:
// p2.next = p2.next.next
// Node 3 ka next ab directly Node 5 ko point karega.
// Node 4 remove ho jayega.
//
// Output: [1, 2, 3, 5]
//
//============================================================

//============================================================
// GAP CONCEPT:
//
// p1 ko pehle n steps aage move karne se
// p1 aur p2 ke beech n nodes ka gap ban jata hai.
//
// Ab dono pointers same speed se move karte hain.
// Isliye jab p1 last node par pahunchta hai,
// p2 target node se just previous node par hota hai.
//
// Agar first node delete karna ho,
// toh p2 Dummy node par hi rahega.
//============================================================

// Time Complexity: O(N) - Linked list ko ek baar traverse karte hain.
// Space Complexity: O(1) - Sirf constant extra pointers use kiye hain.

//============================================================
// ListNode Class (Eclipse Practice)
// LeetCode mein ListNode class already provided hoti hai.
//============================================================



public class Q6_RemoveNthNodeFromEndOfLinkedListlleetcode19 {


		public ListNode removeNthFromEnd(ListNode head, int n) {

			// Create a dummy node and connect its next to head.
			// Dummy node first node ko delete karne mein help karta hai.
			ListNode dummyNode = new ListNode(0);
			dummyNode.next = head;

			// Dono pointers ko dummyNode se start karte hain.
			ListNode p1 = dummyNode;
			ListNode p2 = dummyNode;

			// Move p1 by n steps to maintain a gap of n nodes.
			for (int i = 0; i < n; i++) {
				p1 = p1.next;
			}

			// GAP CONCEPT:
			// p1 aur p2 ke beech n nodes ka gap maintain hai.
			// Ab dono pointers ko ek-ek step move karenge.
			// Jab p1 last node par pahunch jayega,
			// tab p2 delete hone wale node se just previous node par hoga.
			while (p1.next != null) {

				p1 = p1.next;
				p2 = p2.next;
			}

			// p2 ke next node ko skip karke target node remove kar do.
			p2.next = p2.next.next;

			// Return updated head.
			return dummyNode.next;
		}

	
		static class ListNode {

			int val;
			ListNode next;

			ListNode(int val) {
				this.val = val;
			}
		}
	}
