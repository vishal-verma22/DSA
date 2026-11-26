
/*
=======================================================================
                P5: BINARY SEARCH TREE IMPLEMENTATION
                         AND TRAVERSING
=======================================================================

1. PROBLEM STATEMENT:

   Implement a Binary Search Tree (BST) using Java.

   Insert the following elements into the BST:
   30, 20, 40, 50, 10

   After inserting all elements, display the BST elements
   using Inorder Traversal.

-----------------------------------------------------------------------

2. WHAT IS A BINARY SEARCH TREE (BST)?

   Binary Search Tree is a special type of Binary Tree in which
   elements are stored in a particular order.

   RULES:

   1. All smaller values than the current node are stored
      in its LEFT subtree.

   2. All greater than or equal values are stored
      in its RIGHT subtree.

   3. Each node can have maximum two children:
      LEFT and RIGHT.

   Example:

                   30
                  /  \
                20    40
               /        \
             10          50

   Here:

   20 < 30  -> Left side
   40 > 30  -> Right side
   10 < 20  -> Left side of 20
   50 > 40  -> Right side of 40

-----------------------------------------------------------------------

3. NODE CLASS:

   class Node
   {
       int data;
       Node left;
       Node right;
   }

   data  -> Stores the value of the node.
   left  -> Stores the reference of the left child.
   right -> Stores the reference of the right child.

   Initially:

       left = null;
       right = null;

   This means that the newly created node has no children.

-----------------------------------------------------------------------

4. INSERTION LOGIC (RECURSIVE APPROACH):

   Method:

       public void add(int data)
       {
           root = add(data, root);
       }

   Main Logic:

   Step 1:
       We call the recursive add() method and pass the
       value and current root.

   Step 2:
       If root == null, it means we have found an empty
       position where the new node should be inserted.

   Step 3:
       Create a new Node and return it.

   Step 4:
       If data < root.data, recursively insert the value
       into the LEFT subtree.

   Step 5:
       Otherwise, recursively insert the value into the
       RIGHT subtree.

   Step 6:
       After the recursive call returns, attach the returned
       node reference to root.left or root.right.

   Step 7:
       return root sends the current subtree's root reference
       back to the previous recursive call.

-----------------------------------------------------------------------

5. WHY DO WE USE return root?

   IMPORTANT:

   Every recursive call has its own local root reference.

   When a recursive call reaches root == null:

       Node newNode = new Node(data);
       return newNode;

   The newly created node is returned to the previous call.

   The previous call attaches that returned node using:

       root.left = add(data, root.left);

   OR

       root.right = add(data, root.right);

   After attaching the node, return root sends the current
   subtree's root reference back to its caller.

   This process continues until the first add() call returns.

   Finally:

       root = add(data, root);

   The main root reference remains connected to the original
   tree. We do not create the original root again.

-----------------------------------------------------------------------

6. INSERTION DRY RUN:

   Insert elements in this order:

       30, 20, 40, 50, 10

   INSERT 30:

       add(30, null)

       root == null

       Create Node(30)
       return Node(30)

       Main root = Node(30)

                   30

   INSERT 20:

       add(20, Node30)

       20 < 30
       Move LEFT.

       add(20, null)

       Create Node(20)
       return Node(20)

       Node30.left = Node20

                   30
                  /
                20

   INSERT 40:

       add(40, Node30)

       40 > 30
       Move RIGHT.

       add(40, null)

       Create Node(40)
       return Node(40)

       Node30.right = Node40

                   30
                  /  \
                20    40

   INSERT 50:

       add(50, Node30)

       50 > 30
       Move RIGHT.

       add(50, Node40)

       50 > 40
       Move RIGHT.

       add(50, null)

       Create Node(50)
       return Node(50)

       Node40.right = Node50

       Now Node40 is returned.
       Then Node30 is returned.

                   30
                  /  \
                20    40
                        \
                         50

   INSERT 10:

       add(10, Node30)

       10 < 30
       Move LEFT.

       add(10, Node20)

       10 < 20
       Move LEFT.

       add(10, null)

       Create Node(10)
       return Node(10)

       Node20.left = Node10

                   30
                  /  \
                20    40
               /        \
             10          50

-----------------------------------------------------------------------

7. RECURSIVE CALL AND RETURN FLOW FOR INSERTING 50:

   Suppose the tree already contains:

                   30
                     \
                      40

   Now insert 50.

   CALLING PHASE:

       add(50, Node30)
              |
              | 50 > 30
              v
       add(50, Node40)
              |
              | 50 > 40
              v
       add(50, null)
              |
              | root == null
              v
       Create Node(50)

   RETURNING PHASE:

       add(50, null)
              |
              | return Node50
              v
       Node40.right = Node50
              |
              | return Node40
              v
       Node30.right = Node40
              |
              | return Node30
              v
       Main root = Node30

   FINAL TREE:

                   30
                     \
                      40
                        \
                         50

   IMPORTANT:

   1. Recursive calls pause when another recursive call starts.
   2. When the inner call returns, the previous call resumes.
   3. The pending assignment gets completed.
   4. Then return root executes.
   5. This continues until the first call returns.

   Java automatically maintains the paused method calls
   using the CALL STACK.

-----------------------------------------------------------------------

8. INORDER TRAVERSAL:

   Inorder Traversal follows:

       LEFT -> ROOT -> RIGHT

   Method:

       public void displayBST(Node root)
       {
           if(root == null)
           {
               return;
           }

           displayBST(root.left);

           System.out.println(root.data);

           displayBST(root.right);
       }

   WORKING:

   Step 1:
       First visit the LEFT subtree.

   Step 2:
       Print the current ROOT node.

   Step 3:
       Visit the RIGHT subtree.

   Step 4:
       If root == null, return from that recursive call.

   For the BST:

                   30
                  /  \
                20    40
               /        \
             10          50

   Inorder sequence:

       LEFT -> ROOT -> RIGHT

       10 -> 20 -> 30 -> 40 -> 50

   IMPORTANT:

   Inorder Traversal of a BST gives elements in SORTED ORDER
   when duplicate handling is consistent with the BST rule.

-----------------------------------------------------------------------

9. TIME AND SPACE COMPLEXITY:

   INSERTION:

   Best/Average Case:
       O(log n) for a reasonably balanced BST.

   Worst Case:
       O(n) when the BST becomes skewed.

   INORDER TRAVERSAL:

       Time Complexity: O(n)

       Space Complexity: O(h) due to recursion stack.

       h = height of the BST.

=======================================================================
*/


package Lec19_Tree_And_BinaryTree_intro_And_its_Impltn;


public class P5_BinarySearchTreeImplementnAndTravsesing
{
    //==============================================================
    // NODE CLASS
    //==============================================================

    class Node
    {
        int data;

        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;

            left = right = null;
        }
    }

    Node root;


    //==============================================================
    // Add Method: To insert elements in Binary Search Tree
    // Time Complexity: O(log n) Average, O(n) Worst Case
    //==============================================================

    public void add(int data)
    {
        root = add(data, root);
    }


    //==============================================================
    // Recursive Add Method
    //==============================================================

    public Node add(int data, Node root)
    {
        // Base Condition: If current position is empty
        if(root == null)
        {
            Node newNode = new Node(data);

            return newNode;
        }

        // If data is smaller, insert into LEFT subtree
        if(data < root.data)
        {
            root.left = add(data, root.left);
        }
        else
        {
            // If data is greater than or equal,
            // insert into RIGHT subtree

            root.right = add(data, root.right);
        }

        // Return current subtree root
        return root;
    }


    //==============================================================
    // Display Method: To start Inorder Traversal
    //==============================================================

    public void display()
    {
        displayBST(root);
    }


    //==============================================================
    // Inorder Traversal: LEFT -> ROOT -> RIGHT
    // Time Complexity: O(n)
    // Space Complexity: O(h)
    //==============================================================

    public void displayBST(Node root)
    {
        // Base Condition
        if(root == null)
        {
            return;
        }

        // First visit LEFT subtree
        displayBST(root.left);

        // Print current ROOT
        System.out.println(root.data);

        // Finally visit RIGHT subtree
        displayBST(root.right);
    }


    //==============================================================
    // MAIN METHOD
    //==============================================================

    public static void main(String[] args)
    {
        P5_BinarySearchTreeImplementnAndTravsesing tree =
                new P5_BinarySearchTreeImplementnAndTravsesing();

        tree.add(30);
        tree.add(20);
        tree.add(40);
        tree.add(50);
        tree.add(10);

        tree.display();
    }
}
