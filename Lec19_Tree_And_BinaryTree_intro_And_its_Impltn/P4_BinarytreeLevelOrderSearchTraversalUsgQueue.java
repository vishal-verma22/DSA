package Lec19_Tree_And_BinaryTree_intro_And_its_Impltn;

/*
==================================================
P4: BINARY TREE LEVEL ORDER TRAVERSAL USING QUEUE
==================================================

Problem Statement:
Given a Binary Tree, traverse all its nodes level by level
from left to right using a Queue.

==================================================
LEVEL ORDER TRAVERSAL RULE
==================================================

Level 0:          ROOT

Level 1:       LEFT -> RIGHT

Level 2:    LEFT -> RIGHT -> LEFT -> RIGHT

In Level Order Traversal, we visit nodes level by level
from left to right.

Example Binary Tree:

                 10
               /    \
             20      30
            /  \    /  \
           40  50  60  70

Expected Output:

10 20 30 40 50 60 70

==================================================
WHY DO WE USE QUEUE?
==================================================

Queue follows FIFO (First In First Out).

Matlab jo element sabse pehle Queue mein insert hoga,
wahi element sabse pehle remove hoga.

Important Queue Methods:

1. add():
   Queue ke end mein element insert karta hai.

2. poll():
   Queue ke front se element remove karke return karta hai.

Example:

Queue: [10, 20, 30]

poll() -> 10

Queue: [20, 30]

==================================================
MAIN LOGIC - HINGLISH EXPLANATION
==================================================

Step 1:
Sabse pehle root node ko Queue mein insert karenge.

queue.add(currentNode);

Step 2:
Jab tak Queue empty nahi hoti, loop execute karenge.

while(!queue.isEmpty())

Step 3:
Queue ke front se element remove karenge.

Node currentRemovedElement = queue.poll();

Step 4:
Removed element ka data print karenge.

System.out.println(currentRemovedElement.data);

Step 5:
Agar removed node ka LEFT child exist karta hai,
toh usko Queue mein insert karenge.

if(currentRemovedElement.left != null)
{
    queue.add(currentRemovedElement.left);
}

Step 6:
Agar removed node ka RIGHT child exist karta hai,
toh usko Queue mein insert karenge.

if(currentRemovedElement.right != null)
{
    queue.add(currentRemovedElement.right);
}

Ab loop dobara execute hoga.

Ye process tab tak continue hoga jab tak Queue empty
nahi ho jaati.

==================================================
IMPORTANT UNDERSTANDING
==================================================

Hum LEFT child ko pehle aur RIGHT child ko baad mein
Queue mein insert karte hain.

Queue FIFO follow karti hai.

Isliye LEFT child pehle remove hoga aur RIGHT child
uske baad remove hoga.

Isi wajah se traversal left to right hota hai.

==================================================
STEP-BY-STEP DRY RUN
==================================================

Binary Tree:

                 10
               /    \
             20      30
            /  \    /  \
           40  50  60  70

Initially:

queue.add(root);

Queue: [10]
Output: Empty


STEP 1: REMOVE 10

currentRemovedElement = queue.poll();

10 remove hoga aur print hoga.

Output: 10

10 ke children:

LEFT  = 20
RIGHT = 30

Dono Queue mein add honge.

Queue: [20, 30]
Output: 10


STEP 2: REMOVE 20

20 remove hoga aur print hoga.

Output: 10 20

20 ke children:

LEFT  = 40
RIGHT = 50

Dono Queue mein add honge.

Queue: [30, 40, 50]
Output: 10 20


STEP 3: REMOVE 30

30 remove hoga aur print hoga.

Output: 10 20 30

30 ke children:

LEFT  = 60
RIGHT = 70

Dono Queue mein add honge.

Queue: [40, 50, 60, 70]
Output: 10 20 30


STEP 4: REMOVE 40

40 remove hoga aur print hoga.

40 ka koi child nahi hai.

Queue: [50, 60, 70]
Output: 10 20 30 40


STEP 5: REMOVE 50

50 remove hoga aur print hoga.

50 ka koi child nahi hai.

Queue: [60, 70]
Output: 10 20 30 40 50


STEP 6: REMOVE 60

60 remove hoga aur print hoga.

60 ka koi child nahi hai.

Queue: [70]
Output: 10 20 30 40 50 60


STEP 7: REMOVE 70

70 remove hoga aur print hoga.

70 ka koi child nahi hai.

Queue: []

Output: 10 20 30 40 50 60 70

Ab Queue empty ho gayi.

while(!queue.isEmpty()) condition false ho jayegi
aur loop terminate ho jayega.

==================================================
COMPLETE QUEUE DRY RUN TABLE
==================================================

Step 1:
Removed Node = 10
Added Children = 20, 30
Queue = [20, 30]
Output = 10

Step 2:
Removed Node = 20
Added Children = 40, 50
Queue = [30, 40, 50]
Output = 10 20

Step 3:
Removed Node = 30
Added Children = 60, 70
Queue = [40, 50, 60, 70]
Output = 10 20 30

Step 4:
Removed Node = 40
Added Children = None
Queue = [50, 60, 70]
Output = 10 20 30 40

Step 5:
Removed Node = 50
Added Children = None
Queue = [60, 70]
Output = 10 20 30 40 50

Step 6:
Removed Node = 60
Added Children = None
Queue = [70]
Output = 10 20 30 40 50 60

Step 7:
Removed Node = 70
Added Children = None
Queue = []
Output = 10 20 30 40 50 60 70

==================================================
FINAL OUTPUT
==================================================

10
20
30
40
50
60
70

==================================================
TIME AND SPACE COMPLEXITY
==================================================

Time Complexity: O(n)

Reason:
Har node ko exactly ek baar Queue se remove karke
process kiya jaata hai.

Space Complexity: O(n)

Reason:
Worst case mein Queue mein maximum number of nodes
ek level par store ho sakte hain.

==================================================
RECURSION VS LEVEL ORDER TRAVERSAL
==================================================

Preorder, Inorder and Postorder:
These traversals can be implemented using Recursion
or Stack.

Level Order Traversal:
Isme Queue use hoti hai because we need to process
nodes level by level.

==================================================
*/


import java.util.LinkedList;
import java.util.Queue;


public class P4_BinarytreeLevelOrderSearchTraversalUsgQueue
{
    P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion binaryTree;


    // ==================================================
    // CONSTRUCTOR
    // ==================================================

    P4_BinarytreeLevelOrderSearchTraversalUsgQueue(
            P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion binaryTree)
    {
        this.binaryTree = binaryTree;
    }


    // ==================================================
    // LEVEL ORDER TRAVERSAL USING QUEUE
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // ==================================================

    public void displayUsgLevelOrderSearch()
    {
        System.out.println("Traversing Element in Level Order using Queue");

        displayUsgLevelOrderSearchUsgQueue(binaryTree.root);

        System.out.println();
    }


    // ==================================================
    // Method: To perform Level Order Traversal using Queue
    // ==================================================

    public void displayUsgLevelOrderSearchUsgQueue(
            P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion.Node currentNode)
    {
        Queue<P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion.Node> queue =
                new LinkedList<>();


        // Base Condition
        if(currentNode == null)
        {
            return;
        }


        // Adding Root Node into Queue
        queue.add(currentNode);


        // Traversing until Queue becomes empty
        while(!queue.isEmpty())
        {
            // Removing element from front of Queue
            P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion.Node currentRemovedElement =
                    queue.poll();


            // Printing removed element
            System.out.println(currentRemovedElement.data);


            // Checking and Adding Left Child
            if(currentRemovedElement.left != null)
            {
                queue.add(currentRemovedElement.left);
            }


            // Checking and Adding Right Child
            if(currentRemovedElement.right != null)
            {
                queue.add(currentRemovedElement.right);
            }
        }
    }


    // ==================================================
    // MAIN METHOD
    // ==================================================

    public static void main(String[] args)
    {
        // Creating Binary Tree using P1 class

        P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion binaryTree =
                new P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion();

        binaryTree.add(10);
        binaryTree.add(20);
        binaryTree.add(30);
        binaryTree.add(40);
        binaryTree.add(50);
        binaryTree.add(60);
        binaryTree.add(70);


        // Passing P1 object to P4 constructor

        P4_BinarytreeLevelOrderSearchTraversalUsgQueue levelOrder =
                new P4_BinarytreeLevelOrderSearchTraversalUsgQueue(binaryTree);


        // Level Order Traversal using Queue

        levelOrder.displayUsgLevelOrderSearch();
    }

}