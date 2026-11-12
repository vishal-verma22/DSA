/*
================================================================================
                 LeetCode 142: Linked List Cycle II
================================================================================

==>
	Linked List mein agar cycle present hai, 
	toh jis node se cycle start hoti hai us node ko return karna hai. 
	Agar cycle nahi hai, toh null return karna hai.

Working Concept:
    - FastPointer 2 steps move karta hai aur SlowPointer 1 step move karta hai.
    - Agar Linked List mein cycle hai, toh dono pointers kisi same node par milenge.
    - milne  ke baad SlowPointer ko wapas head par le aayenge.
    - FastPointer wahi rahega jaha pe hai .
    - Ab dono pointers 1-1 step move karenge ..fast pointer ko bhi 1 step hi move krna meeting ke bad se.
    - Dono pointer wapas jis node par milenge, wahi Cycle ka Starting Node hoga.

Important Conditions:
    - fastPointer == null: Empty list ya list ke end tak pahunch gaye.
    - fastPointer.next == null: Cycle present nahi hai.
    - fastPointer == slowPointer: Cycle detect ho gaya.

Example:
    1 -> 2 -> 3 -> 4 -> 5
              ^         |
              |_________|

    Cycle Starting Node = 3

Time Complexity  : O(n)
Space Complexity : O(1)

================================================================================
*/

package Lec13_LinkedList_And_its_Implementions;

public class Q9_FindStartingNodeOfCycleInLinkedListLeetcode142 {

    // Node class
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    //================================================================================
    // Detect Cycle Method: To find the starting node of the cycle
    //================================================================================
    public ListNode detectCycle(ListNode head) {

        ListNode fastPointer = head;
        ListNode slowPointer = head;

        // Empty list ya single node without cycle ho toh null return karo
        if (fastPointer == null || fastPointer.next == null) {
            return null;
        }

        // FastPointer 2 steps aur SlowPointer 1 step move karega
        while (fastPointer != null && fastPointer.next != null) {

            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            // Dono pointers same node par mil gaye toh cycle present hai
            if (fastPointer == slowPointer) {
                break;
            }
        }

        // Agar cycle nahi mili toh null return karo
        if (fastPointer == null || fastPointer.next == null) {
            return null;
        }

        // SlowPointer ko wapas head par le aao
        slowPointer = head;

        // Dono pointers ko 1-1 step move karo
        while (fastPointer != slowPointer) {

            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }

        // Dono jis node par milenge, wahi cycle ka starting node hai
        return fastPointer;
    }

    //================================================================================
    // Main Method
    //================================================================================
    public static void main(String[] args) {

        Q9_FindStartingNodeOfCycleInLinkedListLeetcode142 obj =
                new Q9_FindStartingNodeOfCycleInLinkedListLeetcode142();

        // Test Case 1: Linked List with Cycle
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Last node ko node 3 se connect karke cycle create ki
        head.next.next.next.next.next = head.next.next;

        ListNode result = obj.detectCycle(head);

        if (result != null) {
            System.out.println("Cycle Starting Node: " + result.val);
        } else {
            System.out.println("Cycle Not Present");
        }

        // Test Case 2: Linked List without Cycle
        ListNode head2 = new ListNode(10);
        head2.next = new ListNode(20);
        head2.next.next = new ListNode(30);

        ListNode result2 = obj.detectCycle(head2);

        if (result2 != null) {
            System.out.println("Cycle Starting Node: " + result2.val);
        } else {
            System.out.println("Cycle Not Present");
        }
    }
}