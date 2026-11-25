
package Lec19_Tree_And_BinaryTree_intro_And_its_Impltn;

/*
============================================================
              BINARY TREE IMPLEMENTATION
                  USING QUEUE
============================================================


PROBLEM STATEMENT:

Implement a Binary Tree using Linked Nodes.

1. Insert elements into Binary Tree using Queue.
2. Display elements using Inorder Traversal.


============================================================
INPUT
============================================================

bt.add(10);
bt.add(20);
bt.add(30);
bt.add(40);
bt.add(50);
bt.add(60);
bt.add(70);


============================================================
PART 1: ADD METHOD IMPLEMENTATION
============================================================

ADD METHOD:

public void add(int element)
{
    Node newNode = new Node(element);

    if(root == null)
    {
        root = newNode;
        return;
    }

    Queue<Node> queue = new LinkedList<>();

    queue.add(root);

    while(!queue.isEmpty())
    {
        Node currentElement = queue.poll();

        if(currentElement.left == null)
        {
            currentElement.left = newNode;
            return;
        }

        queue.add(currentElement.left);

        if(currentElement.right == null)
        {
            currentElement.right = newNode;
            return;
        }

        queue.add(currentElement.right);
    }
}


============================================================
ADD METHOD: MAIN LOGIC
============================================================

1. Create a new node for the given element.

2. Check whether root is null.

3. If root is null:
   - Assign newNode to root.
   - Return from the method.

4. If root is not null:
   - Create a Queue.
   - Add root into the Queue.

5. Remove the first node from Queue using poll().

6. Check whether its left child is null.

7. If left child is null:
   - Insert newNode at the left.
   - Return.

8. If left child is not null:
   - Add the left child into Queue.

9. Check whether its right child is null.

10. If right child is null:
    - Insert newNode at the right.
    - Return.

11. If right child is not null:
    - Add the right child into Queue.

12. Repeat until an empty position is found.


IMPORTANT CONCEPTS:

Queue follows FIFO.

FIFO = First In First Out

queue.add()  --> Adds an element at the end.
queue.poll() --> Removes and returns the first element.

Insertion takes place level by level,
from left to right.


============================================================
STEP 1: bt.add(10)
============================================================

newNode = 10

Initially:

root = null

Condition:

if(root == null)

TRUE

Execute:

root = newNode;

return;

TREE:

       10

EXPLANATION:

10 becomes the root node because the tree is empty.


============================================================
STEP 2: bt.add(20)
============================================================

newNode = 20

root is not null.

Create Queue:

Queue<Node> queue = new LinkedList<>();

Add root:

queue.add(root);

QUEUE:

[10]


WHILE LOOP:

currentElement = queue.poll();

currentElement = 10

QUEUE = []


Check:

currentElement.left == null

TRUE

Execute:

currentElement.left = newNode;

return;


TREE:

       10
      /
     20

EXPLANATION:

The left child of 10 was empty.
Therefore, 20 is inserted at the left side of 10.


============================================================
STEP 3: bt.add(30)
============================================================

newNode = 30

QUEUE:

[10]


ITERATION 1:

currentElement = queue.poll();

currentElement = 10

QUEUE = []


Check:

10.left == null

FALSE

Because 10.left contains 20.

Execute:

queue.add(currentElement.left);

QUEUE:

[20]


Now check:

10.right == null

TRUE

Execute:

10.right = newNode;

return;


TREE:

       10
      /  \
     20   30

EXPLANATION:

The left child is already occupied.
The right child is empty.

Therefore, 30 is inserted at the right side of 10.


============================================================
STEP 4: bt.add(40)
============================================================

newNode = 40

QUEUE:

[10]


ITERATION 1:

currentElement = queue.poll();

currentElement = 10

QUEUE = []


Check:

10.left == null

FALSE

Add left child:

queue.add(10.left);

QUEUE:

[20]


Check:

10.right == null

FALSE

Add right child:

queue.add(10.right);

QUEUE:

[20, 30]


ITERATION 2:

currentElement = queue.poll();

currentElement = 20

QUEUE:

[30]


Check:

20.left == null

TRUE

Execute:

20.left = newNode;

return;


TREE:

       10
      /  \
     20   30
    /
   40

EXPLANATION:

The left and right children of 10 are occupied.

Therefore, Queue contains 20 and 30.

Now 20 is removed first.

Its left child is empty.
So, 40 is inserted at the left of 20.


============================================================
STEP 5: bt.add(50)
============================================================

newNode = 50

QUEUE:

[10]


ITERATION 1:

currentElement = queue.poll();

currentElement = 10

QUEUE = []


10.left is occupied.

Add left child:

queue.add(10.left);


10.right is occupied.

Add right child:

queue.add(10.right);


QUEUE:

[20, 30]


ITERATION 2:

currentElement = queue.poll();

currentElement = 20

QUEUE:

[30]


Check:

20.left == null

FALSE

Because 20.left contains 40.

Add left child:

queue.add(20.left);

QUEUE:

[30, 40]


Check:

20.right == null

TRUE

Execute:

20.right = newNode;

return;


TREE:

       10
      /  \
     20   30
    /  \
   40  50

EXPLANATION:

Node 20 has its left child occupied.

Its right child is empty.

Therefore, 50 is inserted at the right of 20.


============================================================
STEP 6: bt.add(60)
============================================================

newNode = 60

QUEUE:

[10]


ITERATION 1:

poll() --> 10

10.left and 10.right are occupied.

QUEUE:

[20, 30]


ITERATION 2:

poll() --> 20

20.left and 20.right are occupied.

Add both children.

QUEUE:

[30, 40, 50]


ITERATION 3:

poll() --> 30

QUEUE:

[40, 50]


Check:

30.left == null

TRUE

Execute:

30.left = newNode;

return;


TREE:

       10
      /  \
     20   30
    / \   /
   40 50 60

EXPLANATION:

10 and 20 have both children occupied.

Now 30 is removed from Queue.

Its left child is empty.

Therefore, 60 is inserted at the left of 30.


============================================================
STEP 7: bt.add(70)
============================================================

newNode = 70

QUEUE:

[10]


ITERATION 1:

poll() --> 10

QUEUE:

[20, 30]


ITERATION 2:

poll() --> 20

QUEUE:

[30, 40, 50]


ITERATION 3:

poll() --> 30

QUEUE:

[40, 50]


Check:

30.left == null

FALSE

Because 30.left contains 60.

Add left child:

queue.add(30.left);

QUEUE:

[40, 50, 60]


Check:

30.right == null

TRUE

Execute:

30.right = newNode;

return;


FINAL TREE:

                 10
               /    \
             20      30
            /  \    /  \
           40  50  60  70


============================================================
PART 2: INORDER TRAVERSAL
============================================================

METHOD:

public void displayInorder(Node currentNode)
{
    if(currentNode == null)
    {
        return;
    }

    displayInorder(currentNode.left);

    System.out.println(currentNode.data);

    displayInorder(currentNode.right);
}


INORDER RULE:

LEFT --> ROOT --> RIGHT


MAIN LOGIC:

1. First, call the left child recursively.

2. Wait until the complete left subtree is processed.

3. Print the current node.

4. Call the right child recursively.

5. If currentNode is null, return.

6. Continue until all nodes are visited.


============================================================
FINAL TREE FOR INORDER TRAVERSAL
============================================================

                 10
               /    \
             20      30
            /  \    /  \
           40  50  60  70


============================================================
CALLING STARTS FROM DISPLAY METHOD
============================================================

DISPLAY METHOD:

public void display()
{
    displayInorder(root);
}


root = 10

CALL:

displayInorder(root);

Therefore:

displayInorder(10);


============================================================
PART 3: RECURSIVE CALLING TREE
============================================================

                    displayInorder(10)
                    /               \
                   / LEFT            \ RIGHT
                  v                   v
          displayInorder(20)     displayInorder(30)
             /          \           /          \
          LEFT          RIGHT     LEFT          RIGHT
           v              v        v              v
  displayInorder(40) displayInorder(50)
                                  displayInorder(60)
                                  displayInorder(70)


IMPORTANT:

The diagram shows which recursive calls belong
to each node.

But Java does not execute both sides simultaneously.

It completely executes the LEFT call first,
then prints the ROOT,
and then executes the RIGHT call.


============================================================
PART 4: DETAILED CALLING AND RETURNING
============================================================

------------------------------------------------------------
CALL 1: displayInorder(10)
------------------------------------------------------------

currentNode = 10

First statement:

displayInorder(currentNode.left);

10.left = 20

CALL:

displayInorder(20)


------------------------------------------------------------
CALL 2: displayInorder(20)
------------------------------------------------------------

currentNode = 20

First statement:

displayInorder(currentNode.left);

20.left = 40

CALL:

displayInorder(40)


------------------------------------------------------------
CALL 3: displayInorder(40)
------------------------------------------------------------

currentNode = 40

First statement:

displayInorder(currentNode.left);

40.left = null

CALL:

displayInorder(null)


------------------------------------------------------------
CALL 4: displayInorder(null)
------------------------------------------------------------

Condition:

if(currentNode == null)

TRUE

Execute:

return;

RETURN TO:

displayInorder(40)


------------------------------------------------------------
NOW NODE 40 EXECUTION CONTINUES
------------------------------------------------------------

Left recursive call is completed.

Now execute:

System.out.println(currentNode.data);

OUTPUT:

40


Next statement:

displayInorder(currentNode.right);

40.right = null

CALL:

displayInorder(null)


------------------------------------------------------------
CALL 5: displayInorder(null)
------------------------------------------------------------

Condition:

currentNode == null

TRUE

Execute:

return;

RETURN TO:

displayInorder(40)


No more statements are left.

displayInorder(40) COMPLETED.


RETURN TO:

displayInorder(20)


============================================================
NODE 20 EXECUTION CONTINUES
============================================================

Left subtree of 20 is completed.

Now execute:

System.out.println(currentNode.data);

OUTPUT:

20


Next statement:

displayInorder(currentNode.right);

20.right = 50

CALL:

displayInorder(50)


------------------------------------------------------------
CALL 6: displayInorder(50)
------------------------------------------------------------

currentNode = 50

First statement:

displayInorder(currentNode.left);

50.left = null

CALL:

displayInorder(null)

Condition:

currentNode == null

TRUE

return;


RETURN TO:

displayInorder(50)


Now execute:

System.out.println(currentNode.data);

OUTPUT:

50


Next statement:

displayInorder(currentNode.right);

50.right = null

CALL:

displayInorder(null)

Condition:

currentNode == null

TRUE

return;


displayInorder(50) COMPLETED.


RETURN TO:

displayInorder(20)


No more statements are left.

displayInorder(20) COMPLETED.


RETURN TO:

displayInorder(10)


============================================================
NODE 10 EXECUTION CONTINUES
============================================================

Left subtree of 10 is completely completed.

Now execute:

System.out.println(currentNode.data);

OUTPUT:

10


Next statement:

displayInorder(currentNode.right);

10.right = 30

CALL:

displayInorder(30)


============================================================
NODE 30 EXECUTION
============================================================

currentNode = 30

First statement:

displayInorder(currentNode.left);

30.left = 60

CALL:

displayInorder(60)


------------------------------------------------------------
NODE 60 EXECUTION
------------------------------------------------------------

currentNode = 60

Left call:

displayInorder(null)

Condition:

currentNode == null

TRUE

return;


RETURN TO:

displayInorder(60)


Now print:

System.out.println(currentNode.data);

OUTPUT:

60


Right call:

displayInorder(null)

Condition:

currentNode == null

TRUE

return;


displayInorder(60) COMPLETED.


RETURN TO:

displayInorder(30)


------------------------------------------------------------
NODE 30 EXECUTION CONTINUES
------------------------------------------------------------

Left subtree is completed.

Now print:

System.out.println(currentNode.data);

OUTPUT:

30


Next statement:

displayInorder(currentNode.right);

30.right = 70

CALL:

displayInorder(70)


------------------------------------------------------------
NODE 70 EXECUTION
------------------------------------------------------------

currentNode = 70

Left call:

displayInorder(null)

Condition:

currentNode == null

TRUE

return;


RETURN TO:

displayInorder(70)


Now print:

System.out.println(currentNode.data);

OUTPUT:

70


Right call:

displayInorder(null)

Condition:

currentNode == null

TRUE

return;


displayInorder(70) COMPLETED.


RETURN TO:

displayInorder(30)


No more statements are left.

displayInorder(30) COMPLETED.


RETURN TO:

displayInorder(10)


No more statements are left.

displayInorder(10) COMPLETED.


============================================================
PART 5: COMPLETE CALLING AND RETURNING FLOW
============================================================

CALLING FLOW:

displayInorder(10)
        |
        v
displayInorder(20)
        |
        v
displayInorder(40)
        |
        v
displayInorder(null)
        |
        v
      RETURN
        |
        v
     PRINT 40
        |
        v
displayInorder(null)
        |
        v
      RETURN
        |
        v
     RETURN TO 20
        |
        v
     PRINT 20
        |
        v
displayInorder(50)
        |
        v
displayInorder(null)
        |
        v
      RETURN
        |
        v
     PRINT 50
        |
        v
displayInorder(null)
        |
        v
      RETURN
        |
        v
     RETURN TO 10
        |
        v
     PRINT 10
        |
        v
displayInorder(30)
        |
        v
displayInorder(60)
        |
        v
displayInorder(null)
        |
        v
      RETURN
        |
        v
     PRINT 60
        |
        v
displayInorder(null)
        |
        v
      RETURN
        |
        v
     RETURN TO 30
        |
        v
     PRINT 30
        |
        v
displayInorder(70)
        |
        v
displayInorder(null)
        |
        v
      RETURN
        |
        v
     PRINT 70
        |
        v
displayInorder(null)
        |
        v
      RETURN
        |
        v
     RETURN TO 30
        |
        v
     RETURN TO 10


============================================================
PART 6: FINAL OUTPUT
============================================================

Inorder Traversal:

40
20
50
10
60
30
70


============================================================
IMPORTANT CONCEPTS
============================================================

ADD METHOD:

1. Queue is used for insertion.
2. Queue follows FIFO.
3. Elements are inserted level by level.
4. Left position is checked first.
5. If left is occupied, right position is checked.
6. return stops the add() method after insertion.

INORDER TRAVERSAL:

1. Recursion is used for traversal.
2. Order is LEFT -> ROOT -> RIGHT.
3. Complete left subtree executes first.
4. Current node is printed after left subtree.
5. Right subtree executes after printing.
6. When currentNode is null, return is executed.

IMPORTANT ABOUT RETURN:

Suppose:

displayInorder(40)
        |
        v
displayInorder(null)
        |
        v
      return

This return does not stop the complete program.

It completes only the current call:

displayInorder(null)

Control returns to:

displayInorder(40)

Then execution continues from the next statement.


============================================================
TIME AND SPACE COMPLEXITY
============================================================

ADD METHOD:

Time Complexity:
O(n) in the worst case.

Space Complexity:
O(n) for Queue.

INORDER TRAVERSAL:

Time Complexity:
O(n)

Space Complexity:
O(h) for recursion stack.

n = Total number of nodes.
h = Height of the tree.

============================================================
*/


import java.util.LinkedList;
import java.util.Queue;


public class P1_BinaryTreeImplementn
{
    //==================================================
    // NODE CLASS
    //==================================================

    class Node
    {
        int data;

        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    Node root;


    //==================================================
    // ADD METHOD: To insert elements using Queue
    // Time Complexity: O(n) in worst case
    //==================================================

    public void add(int element)
    {
        Node newNode = new Node(element);

        if(root == null)
        {
            root = newNode;
            return;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty())
        {
            Node currentElement = queue.poll();

            if(currentElement.left == null)
            {
                currentElement.left = newNode;
                return;
            }

            queue.add(currentElement.left);

            if(currentElement.right == null)
            {
                currentElement.right = newNode;
                return;
            }

            queue.add(currentElement.right);
        }
    }


    //==================================================
    // INORDER TRAVERSAL: LEFT -> ROOT -> RIGHT
    // Time Complexity: O(n)
    //==================================================

    public void displayInorder(Node currentNode)
    {
        if(currentNode == null)
        {
            return;
        }

        displayInorder(currentNode.left);

        System.out.println(currentNode.data);

        displayInorder(currentNode.right);
    }


    //==================================================
    // DISPLAY METHOD
    //==================================================

    public void display()
    {
        displayInorder(root);
    }



}
