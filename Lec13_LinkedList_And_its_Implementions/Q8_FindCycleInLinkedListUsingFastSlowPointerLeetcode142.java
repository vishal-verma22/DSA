package Lec13_LinkedList_And_its_Implementions;

/*
Given a Linked List, check karo ki usme cycle present hai ya nahi.
	- Agar last node kisi previous node ko point karta hai, toh true return karo.
	- Agar last node ka next = null hai, toh false return karo.
	-Leetcode 142

1./*

================================================================================
                         Working Concept:
================================================================================

    - Cycle detect karne ke liye Fast and Slow Pointer technique use karte hain.

    - Dono pointers initially head node se start hote hain.

    - Slow Pointer har iteration mein 1 node move karta hai.

    - Fast Pointer har iteration mein 2 nodes move karta hai.

    - Agar Linked List mein cycle present hai,
      toh Fast Pointer baar-baar cycle ke andar traverse karega.

    - Agar Fast Pointer aur Slow Pointer same node par mil jayenge.
      Iska matlab Linked List mein cycle present hai.

    - Agar Linked List mein cycle present nahi hai,
      toh Fast Pointer Linked List ke end tak pahunch jayega.

    - Kyunki last node ka next null hota hai,
      isliye Fast Pointer eventually null ho jayega
      aur dono pointers same node par nahi milenge 
      so agar dono pointer nhi mile same node pe toh cycle present nhi hai.


--------------------------------------------------------------------------------

2. Why Do We Use This Condition?

    while (fastPointer != null && fastPointer.next != null)

    - fastPointer != null:
      Check karta hai ki Fast Pointer kisi valid node par hai.

    - fastPointer.next != null:
      Check karta hai ki Fast Pointer ke aage bhi ek node available hai.

    - Kyunki Fast Pointer ko 2 steps move karna hai,
      isliye fastPointer.next ka null nahi hona zaroori hai.

    - Agar Fast Pointer null ho gaya ya uska next null ho gaya,
      toh loop stop ho jayega.

--------------------------------------------------------------------------------

3. How Cycle Is Created?

    Normal Linked List:

    1 -> 2 -> 3 -> 4 -> 5 -> null

    Cycle Present:

    1 -> 2 -> 3 -> 4 -> 5
              ^         |
              |_________|

    - Normal Linked List mein last node ka next null hota hai.

    - Cycle present hone par last node ka next null nahi hota.
      Woh kisi previous node ko point karta hai.

--------------------------------------------------------------------------------

4. Important Condition:

    if (fastPointer == slowPointer)

    - Har iteration ke baad dono pointers ko compare karte hain.

    - Agar dono same node par mil gaye,
      toh return true karte hain.

    - Agar loop terminate ho gaya aur dono pointers nahi mile,
      toh return false karte hain.

--------------------------------------------------------------------------------

5. Time and Space Complexity:

    Time Complexity  : O(n)
    Space Complexity : O(1)

================================================================================
*/



public class Q8_FindCycleInLinkedListUsingFastSlowPointerLeetcode142 {

    //========================================================
    // Node Class
    //========================================================

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }


    
    
    //========================================================
    // Has Cycle Method: To detect cycle in Linked List
    //========================================================

    public boolean hasCycle(ListNode head) {

        // Initialize both pointers at the head node
        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while (fastPointer != null && fastPointer.next != null) {

            fastPointer = fastPointer.next.next; // Fast Pointer moves 2 nodes.
            slowPointer = slowPointer.next;      // Slow Pointer moves 1 node.

            // Check karo ki dono pointers same node par hain ya nahi.
            // Agar dono same node par mil gaye,
            // toh Linked List mein cycle present hai.

            if (fastPointer == slowPointer) {
                return true;
            }
        }

        // Agar loop terminate ho gaya aur dono pointers nahi mile,
        // toh Linked List mein cycle present nahi hai.

        return false;
    }


    
    
    
    
    
    
    
    
    //========================================================
    // Main Method
    //========================================================

    public static void main(String[] args) {

    	Q8_FindCycleInLinkedListUsingFastSlowPointerLeetcode142 obj =
                new Q8_FindCycleInLinkedListUsingFastSlowPointerLeetcode142();


        // Test Case 1: Linked List Without Cycle
        // 1 -> 2 -> 3 -> null

        ListNode head1 = new ListNode(1);

        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);

        System.out.println("Cycle Present: " + obj.hasCycle(head1));


        // Test Case 2: Linked List With Cycle
        // 1 -> 2 -> 3 -> 4 -> 5
        //           ^         |
        //           |_________|

        ListNode head2 = new ListNode(1);

        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head2.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Last node ko node3 se connect karke cycle create ki.
        node5.next = node3;

        System.out.println("Cycle Present: " + obj.hasCycle(head2));

    }

}
