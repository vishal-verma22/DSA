
package Lec19_Tree_And_BinaryTree_intro_And_its_Impltn;

/*
====================================================================
              PREORDER TRAVERSAL USING STACK AND RECURSION
====================================================================

PROBLEM STATEMENT:
	Implement Preorder Traversal of a Binary Tree using:
		1. Recursion	
		2. Stack

We are using the existing Binary Tree implementation from P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion class.

The add() method is already implemented in P1 class.
Therefore, we do not need to write add() method again in P2.
//====================================================================
//              PREORDER TRAVERSAL RULE
//====================================================================

Preorder Traversal follows:

ROOT -> LEFT -> RIGHT

1. First, visit and print the ROOT node.

2. Then, traverse the complete LEFT subtree.

3. Finally, traverse the complete RIGHT subtree.


EXAMPLE:

                         10
                       /    \
                     20      30
                    /  \    /  \
                   40  50  60  70


STEP-BY-STEP:

Step 1: Visit ROOT = 10
        Output: 10

Step 2: Visit LEFT child of 10 = 20
        Output: 10, 20

Step 3: Visit LEFT child of 20 = 40
        Output: 10, 20, 40

Step 4: Visit RIGHT child of 20 = 50
        Output: 10, 20, 40, 50

Step 5: LEFT subtree of 10 is complete.
        Now visit RIGHT child of 10 = 30
        Output: 10, 20, 40, 50, 30

Step 6: Visit LEFT child of 30 = 60
        Output: 10, 20, 40, 50, 30, 60

Step 7: Visit RIGHT child of 30 = 70
        Output: 10, 20, 40, 50, 30, 60, 70


FINAL PREORDER TRAVERSAL:

10 -> 20 -> 40 -> 50 -> 30 -> 60 -> 70


IMPORTANT:

Always follow ROOT -> LEFT -> RIGHT.

First complete the ROOT, then the complete LEFT subtree,
and finally the complete RIGHT subtree.

//====================================================================

====================================================================
              TREE CREATION USING P1 CLASS
====================================================================

In main():

P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion binaryTree = new P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion();

binaryTree.add(10);
binaryTree.add(20);
binaryTree.add(30);
binaryTree.add(40);
binaryTree.add(50);
binaryTree.add(60);
binaryTree.add(70);

The add() method of P1 creates the following Binary Tree:

                         10
                       /    \
                     20      30
                    /  \    /  \
                   40  50  60  70


IMPORTANT:

P1 class is responsible for creating the Binary Tree.

P2 class is responsible for traversing the same Binary Tree.

We pass the P1 object to the P2 constructor.

P2 constructor:

P2_BinarytreePreOrderTraversalUsgStackAndRecursion preOrder =
    new P2_BinarytreePreOrderTraversalUsgStackAndRecursion(binaryTree);

Here, P2 receives the same P1 object.

Therefore, P2 can access the same root and its left and right nodes.

====================================================================
              PART 1: PREORDER USING RECURSION
====================================================================

MAIN LOGIC IN HINGLISH:

1. Sabse pehle displayUsgRecursion() method call hoga.

2. Is method ke andar:

   displayPreorderUsgRecursion(binaryTree.root);

   Hum P1 ke tree ka root P2 ke recursive method ko pass karenge.

3. Recursive method mein sabse pehle check karenge:

   if(currentNode == null)

   Agar currentNode null hai, toh current recursive call return ho jayegi.

4. Agar currentNode null nahi hai, toh sabse pehle uska data print hoga.

5. Uske baad LEFT child par recursive call lagegi.

6. LEFT subtree ka complete traversal hone ke baad hi
   execution next statement par aayega.

7. Uske baad RIGHT child par recursive call lagegi.

8. RIGHT subtree complete hone ke baad method return hoga.

IMPORTANT:

Recursion mein method apne aap ko call karta hai.

Lekin LEFT call complete hone ke baad hi RIGHT call execute hoti hai.

====================================================================
              RECURSION WORKING WITH TREE
====================================================================

TREE:

                         10
                       /    \
                     20      30
                    /  \    /  \
                   40  50  60  70


PREORDER RULE:

ROOT -> LEFT -> RIGHT


STEP 1:

displayPreorderUsgRecursion(10)

Current Node = 10

First print ROOT:

OUTPUT: 10

Now call LEFT:

displayPreorderUsgRecursion(20)


STEP 2:

displayPreorderUsgRecursion(20)

Current Node = 20

First print ROOT:

OUTPUT: 20

Now call LEFT:

displayPreorderUsgRecursion(40)


STEP 3:

displayPreorderUsgRecursion(40)

Current Node = 40

First print ROOT:

OUTPUT: 40

Now call LEFT:

displayPreorderUsgRecursion(null)

currentNode == null

Therefore, return to Node 40.

Now call RIGHT:

displayPreorderUsgRecursion(null)

currentNode == null

Therefore, return to Node 40.

Node 40 ka LEFT aur RIGHT dono complete ho gaye.

Now return to Node 20.


STEP 4:

Node 20 ki LEFT call complete ho gayi.

Now Node 20 ki RIGHT call execute hogi:

displayPreorderUsgRecursion(50)

Current Node = 50

First print:

OUTPUT: 50

LEFT = null  -> return

RIGHT = null -> return

Now return to Node 20.

Node 20 ka complete subtree finish ho gaya.

Now return to Node 10.


STEP 5:

Node 10 ki LEFT call complete ho gayi.

Now Node 10 ki RIGHT call execute hogi:

displayPreorderUsgRecursion(30)

Current Node = 30

First print:

OUTPUT: 30

Now call LEFT:

displayPreorderUsgRecursion(60)

Print:

OUTPUT: 60

LEFT = null  -> return

RIGHT = null -> return

Now return to Node 30.


STEP 6:

Node 30 ki RIGHT call execute hogi:

displayPreorderUsgRecursion(70)

Print:

OUTPUT: 70

LEFT = null  -> return

RIGHT = null -> return

Now return to Node 30.

Node 30 complete.

Now return to Node 10.

Complete tree traversal finished.


====================================================================
              RECURSION CALLING AND RETURNING TREE
====================================================================

                       10
                      /  \
                    20    30
                   / \    / \
                  40 50  60 70

CALLING ORDER:

10
|
|---- LEFT  -> 20
|               |
|               |---- LEFT  -> 40
|               |               |
|               |               |---- LEFT  -> null
|               |               |
|               |               |---- RIGHT -> null
|               |
|               |---- RIGHT -> 50
|                               |
|                               |---- LEFT  -> null
|                               |
|                               |---- RIGHT -> null
|
|---- RIGHT -> 30
                |
                |---- LEFT  -> 60
                |               |
                |               |---- LEFT  -> null
                |               |
                |               |---- RIGHT -> null
                |
                |---- RIGHT -> 70
                                |
                                |---- LEFT  -> null
                                |
                                |---- RIGHT -> null


PRINTING ORDER:

10 -> 20 -> 40 -> 50 -> 30 -> 60 -> 70


IMPORTANT:

Jab LEFT call lagti hai, toh Java uska result complete hone ka
wait karta hai.

Uske baad hi RIGHT call execute hoti hai.

====================================================================
              PART 2: PREORDER USING STACK
====================================================================

MAIN LOGIC IN HINGLISH:

1. Sabse pehle displayUsgStack() method call hoga.

2. Is method ke andar:

   displayPreorderUsgStack(binaryTree.root);

   Hum P1 ke root ko Stack wale method mein pass karenge.

3. Stack create karenge:

   Stack<P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion.Node> stack = new Stack<>();

4. Starting root node ko Stack mein push karenge.

   stack.push(currentNode);

5. Jab tak Stack empty nahi hota, tab tak while loop chalega.

   while(!stack.isEmpty())

6. Stack se top element remove karenge:

   currentRemovedElement = stack.pop();

7. Jo node remove hua hai, uska data print karenge.

8. Ab us node ka RIGHT child check karenge.

   Agar RIGHT child available hai, toh Stack mein push karenge.

9. Ab us node ka LEFT child check karenge.

   Agar LEFT child available hai, toh Stack mein push karenge.

10. LEFT ko RIGHT ke baad push karne ka reason:

    Stack LIFO follow karta hai.

    LIFO = Last In First Out.

    Jo element last mein push hoga, wahi sabse pehle pop hoga.

    Isliye RIGHT pehle push karenge aur LEFT baad mein.

    Result: LEFT pehle pop hoga.

11. Jab Stack empty ho jayega, traversal complete ho jayega.

====================================================================
              STACK WORKING WITH TREE
====================================================================

TREE:

                         10
                       /    \
                     20      30
                    /  \    /  \
                   40  50  60  70


STEP 1:

Initially Stack is empty.

Stack: []

Push ROOT 10:

stack.push(10);

Stack:

[10]


STEP 2:

Pop 10:

currentRemovedElement = 10

Print:

OUTPUT: 10

Now check children of 10:

RIGHT = 30
LEFT  = 20

First push RIGHT:

stack.push(30);

Then push LEFT:

stack.push(20);

Stack (Bottom -> Top):

[30, 20]

20 is on top.


STEP 3:

Pop 20:

currentRemovedElement = 20

Print:

OUTPUT: 20

Children:

RIGHT = 50
LEFT  = 40

First push RIGHT 50.

Then push LEFT 40.

Stack (Bottom -> Top):

[30, 50, 40]

40 is on top.


STEP 4:

Pop 40:

currentRemovedElement = 40

Print:

OUTPUT: 40

Children:

LEFT = null
RIGHT = null

Nothing will be pushed.

Stack:

[30, 50]


STEP 5:

Pop 50:

currentRemovedElement = 50

Print:

OUTPUT: 50

Children:

LEFT = null
RIGHT = null

Nothing will be pushed.

Stack:

[30]


STEP 6:

Pop 30:

currentRemovedElement = 30

Print:

OUTPUT: 30

Children:

RIGHT = 70
LEFT  = 60

First push RIGHT 70.

Then push LEFT 60.

Stack (Bottom -> Top):

[70, 60]

60 is on top.


STEP 7:

Pop 60:

currentRemovedElement = 60

Print:

OUTPUT: 60

Children:

LEFT = null
RIGHT = null

Nothing will be pushed.

Stack:

[70]


STEP 8:

Pop 70:

currentRemovedElement = 70

Print:

OUTPUT: 70

Children:

LEFT = null
RIGHT = null

Nothing will be pushed.

Stack:

[]

Stack is now empty.

Therefore, while loop terminates.


====================================================================
              STACK DRY RUN TABLE
====================================================================

STEP    POPPED NODE    PUSHED NODES    STACK (BOTTOM -> TOP)

1       10             30, 20          [30, 20]
2       20             50, 40          [30, 50, 40]
3       40             None            [30, 50]
4       50             None            [30]
5       30             70, 60          [70, 60]
6       60             None            [70]
7       70             None            []


PRINTING ORDER:

10 -> 20 -> 40 -> 50 -> 30 -> 60 -> 70


====================================================================
              IMPORTANT DIFFERENCE
====================================================================

RECURSION:

Java automatically manages method calls using the Call Stack.

We do not manually push and pop nodes.

STACK:

We manually create a Stack object.

We manually push and pop nodes.

Both methods produce the same Preorder traversal.

====================================================================
              TIME AND SPACE COMPLEXITY
====================================================================

1. PREORDER USING RECURSION:

Time Complexity  : O(n)
Space Complexity : O(h)

2. PREORDER USING STACK:

Time Complexity  : O(n)
Space Complexity : O(h)

Where:

n = Total number of nodes in the Binary Tree.

h = Height of the Binary Tree.

====================================================================
              FINAL OUTPUT
====================================================================

Traversing Element in PreOrder using Recursion:

10
20
40
50
30
60
70

Traversing Element in PreOrder using Stack:

10
20
40
50
30
60
70

====================================================================
*/


import java.util.Stack;


public class P2_BinarytreePreOrderTraversalUsgStackAndRecursion {

    // ==================================================
    // P1 OBJECT: To access the existing Binary Tree
    // ==================================================

    P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion binaryTree;

    P2_BinarytreePreOrderTraversalUsgStackAndRecursion(P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion binaryTree) {

        this.binaryTree = binaryTree;

    }


    // ==================================================
    // Way -1: Using Recursion
    // PREORDER: ROOT -> LEFT -> RIGHT
    // ==================================================

    public void displayUsgRecursion() {

        System.out.println("Traversing Element in PreOrder using Recursion");

        displayPreorderUsgRecursion(binaryTree.root);

        System.out.println();

    }


    public void displayPreorderUsgRecursion(P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion.Node currentNode) {

        // Base Condition

        if (currentNode == null) {

            return;

        }

        // First print ROOT

        System.out.println(currentNode.data);

        // Then traverse LEFT subtree

        displayPreorderUsgRecursion(currentNode.left);

        // Finally traverse RIGHT subtree

        displayPreorderUsgRecursion(currentNode.right);

    }


    // ==================================================
    // Way -2: Using Stack
    // PREORDER: ROOT -> LEFT -> RIGHT
    // ==================================================

    public void displayUsgStack() {

        System.out.println("Traversing Element in PreOrder using Stack");

        displayPreorderUsgStack(binaryTree.root);

        System.out.println();

    }


    public void displayPreorderUsgStack(P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion.Node currentNode) {

        // Creating Stack

        Stack<P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion.Node> stack = new Stack<>();

        // If root is null, return

        if (currentNode == null) {

            return;

        }

        // Push ROOT into Stack

        stack.push(currentNode);

        // Loop until Stack becomes empty

        while (!stack.isEmpty()) {

            // Remove top element from Stack

            P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion.Node currentRemovedElement = stack.pop();

            // Print ROOT

            System.out.println(currentRemovedElement.data);

            // First push RIGHT child

            if (currentRemovedElement.right != null) {

                stack.push(currentRemovedElement.right);

            }

            // Then push LEFT child

            if (currentRemovedElement.left != null) {

                stack.push(currentRemovedElement.left);

            }

        }

    }


    // ==================================================
    // MAIN METHOD
    // ==================================================

    public static void main(String[] args) {

        // Creating Binary Tree using P1 class

        P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion binaryTree = new P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion();

        binaryTree.add(10);

        binaryTree.add(20);

        binaryTree.add(30);

        binaryTree.add(40);

        binaryTree.add(50);

        binaryTree.add(60);

        binaryTree.add(70);


        // Passing P1 object to P2 constructor

        P2_BinarytreePreOrderTraversalUsgStackAndRecursion preOrder =
                new P2_BinarytreePreOrderTraversalUsgStackAndRecursion(binaryTree);


        // Preorder using Recursion

        preOrder.displayUsgRecursion();


        // Preorder using Stack

        preOrder.displayUsgStack();

    }

}
