package Lec19_Tree_And_BinaryTree_intro_And_its_Impltn;

/*
============================================================
BINARY TREE IMPLEMENTATION USING QUEUE
AND INORDER TRAVERSAL USING RECURSION & STACK
============================================================

PROBLEM STATEMENT:

Implement a Binary Tree using Linked Nodes.

1. Insert elements into Binary Tree using Queue.
2. Display elements using Inorder Traversal using Recursion.
3. Display elements using Inorder Traversal using Stack.

INPUT:

bt.add(10);
bt.add(20);
bt.add(30);
bt.add(40);
bt.add(50);
bt.add(60);
bt.add(70);


============================================================
PART 1: ADD METHOD IMPLEMENTATION USING QUEUE
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
MAIN LOGIC OF ADD METHOD 
============================================================

1. Sabse pehle given element ka ek new Node create hota hai.

   Node newNode = new Node(element);

   Example:
   bt.add(20) call hua, toh newNode ke andar data = 20 hoga.

2. Check karte hain ki root null hai ya nahi.

   if(root == null)

   Agar tree empty hai, toh newNode ko root bana dete hain.

   root = newNode;

   Uske baad return kar dete hain, kyunki insertion complete ho gaya.

3. Agar root null nahi hai, iska matlab tree mein pehle se node present hai.

   Isliye ek Queue create karte hain.

   Queue<Node> queue = new LinkedList<>();

4. Root node ko Queue mein add karte hain.

   queue.add(root);

5. while loop tab tak chalega jab tak Queue empty nahi hoti.

   while(!queue.isEmpty())

6. Queue se sabse pehla node remove karte hain.

   Node currentElement = queue.poll();

   Queue FIFO follow karti hai, isliye jo node pehle add hua tha
   woh pehle remove hoga.

7. Ab current node ka LEFT child check karte hain.

   Agar left null hai, toh newNode ko left mein insert kar do
   aur return kar do.

   Agar left null nahi hai, toh left child ko Queue mein add kar do.

8. Ab current node ka RIGHT child check karte hain.

   Agar right null hai, toh newNode ko right mein insert kar do
   aur return kar do.

   Agar right null nahi hai, toh right child ko Queue mein add kar do.

9. Ye process level by level aur left to right chalta hai.
   Jahan pehli empty position milti hai, newNode insert ho jata hai.

IMPORTANT:

Queue follows FIFO = First In First Out.

queue.add()  --> Queue ke end mein element add karta hai.
queue.poll() --> Queue ke front se element remove karke return karta hai.

Insertion level by level hota hai:
Pehle root, phir uske children, phir next level ke children.

return ka matlab: add() method ka current execution complete.


============================================================
STEP-BY-STEP ADD METHOD WORKING
============================================================

STEP 1: bt.add(10)

newNode = 10
Initially root = null

if(root == null) --> TRUE

Execute:
root = newNode;
return;

TREE:

        10

Explanation:
Tree empty tha, isliye 10 root node ban gaya.


------------------------------------------------------------
STEP 2: bt.add(20)
------------------------------------------------------------

newNode = 20
root = 10

Queue = [10]

poll() --> currentElement = 10
Queue = []

Check:
10.left == null --> TRUE

Execute:
10.left = 20;
return;

TREE:

        10
       /
      20

Explanation:
10 ka left child empty tha, isliye 20 left mein insert hua.


------------------------------------------------------------
STEP 3: bt.add(30)
------------------------------------------------------------

newNode = 30
Queue = [10]

poll() --> currentElement = 10
Queue = []

Check:
10.left == null --> FALSE
Because 10.left contains 20.

queue.add(10.left);

Queue = [20]

Now check:
10.right == null --> TRUE

Execute:
10.right = 30;
return;

TREE:

        10
       /  \
      20   30

Explanation:
10 ka left already occupied tha, lekin right empty tha.
Isliye 30 right mein insert hua.


------------------------------------------------------------
STEP 4: bt.add(40)
------------------------------------------------------------

newNode = 40
Queue = [10]

ITERATION 1:

poll() --> 10
Queue = []

10.left is occupied.
Add 10.left (20).

Queue = [20]

10.right is occupied.
Add 10.right (30).

Queue = [20, 30]

ITERATION 2:

poll() --> 20
Queue = [30]

Check:
20.left == null --> TRUE

Execute:
20.left = 40;
return;

TREE:

          10
         /  \
        20   30
       /
      40

Explanation:
10 ke dono children occupied the.
Queue se 20 remove hua aur uska left empty mila.
Isliye 40, 20 ke left mein insert hua.


------------------------------------------------------------
STEP 5: bt.add(50)
------------------------------------------------------------

newNode = 50
Queue = [10]

ITERATION 1:

poll() --> 10
Queue = []

10.left occupied --> add 20
10.right occupied --> add 30

Queue = [20, 30]

ITERATION 2:

poll() --> 20
Queue = [30]

20.left occupied --> add 40

Queue = [30, 40]

Check:
20.right == null --> TRUE

Execute:
20.right = 50;
return;

TREE:

          10
         /  \
        20   30
       /  \
      40  50

Explanation:
20 ka left occupied tha, right empty tha.
Isliye 50, 20 ke right mein insert hua.


------------------------------------------------------------
STEP 6: bt.add(60)
------------------------------------------------------------

newNode = 60
Queue = [10]

ITERATION 1:

poll() --> 10
10 ke left aur right occupied hain.

Queue = [20, 30]

ITERATION 2:

poll() --> 20
20 ke left aur right occupied hain.

Queue = [30, 40, 50]

ITERATION 3:

poll() --> 30
Queue = [40, 50]

Check:
30.left == null --> TRUE

Execute:
30.left = 60;
return;

TREE:

          10
         /  \
        20   30
       /  \  /
      40  50 60

Explanation:
10 aur 20 ke dono children occupied the.
Ab 30 remove hua aur uska left empty mila.
Isliye 60, 30 ke left mein insert hua.


------------------------------------------------------------
STEP 7: bt.add(70)
------------------------------------------------------------

newNode = 70
Queue = [10]

ITERATION 1:

poll() --> 10
Queue = [20, 30]

ITERATION 2:

poll() --> 20
20 ke dono children occupied hain.

Queue = [30, 40, 50]

ITERATION 3:

poll() --> 30
Queue = [40, 50]

30.left occupied hai, isliye 60 ko Queue mein add karte hain.

Queue = [40, 50, 60]

Check:
30.right == null --> TRUE

Execute:
30.right = 70;
return;

FINAL TREE:

                  10
                /    \
              20      30
             /  \    /  \
            40  50  60  70


============================================================
PART 2: INORDER TRAVERSAL USING RECURSION
============================================================

METHOD:

public void displayInorderUsgRecursion(Node currentNode)
{
    if(currentNode == null)
    {
        return;
    }

    displayInorderUsgRecursion(currentNode.left);

    System.out.println(currentNode.data);

    displayInorderUsgRecursion(currentNode.right);
}


============================================================
MAIN LOGIC OF INORDER USING RECURSION 
============================================================

INORDER RULE:

LEFT --> ROOT --> RIGHT

1. display() method se traversal start hota hai aur root pass hota hai.

   displayInorderUsgRecursion(root);

2. Sabse pehle check hota hai ki currentNode null hai ya nahi.

   if(currentNode == null)

   Agar currentNode null hai, toh return execute hota hai.
   Iska matlab current recursive call complete hoti hai aur control
   uske calling method mein wapas chala jata hai.

3. Agar node null nahi hai, toh sabse pehle uske LEFT child par
   recursive call lagti hai.

   displayInorderUsgRecursion(currentNode.left);

4. Java left subtree ko completely process karta hai.
   Jab tak left subtree complete nahi hota, current node print nahi hota.

5. Left subtree complete hone ke baad current node ka data print hota hai.

   System.out.println(currentNode.data);

6. Uske baad current node ke RIGHT child par recursive call lagti hai.

   displayInorderUsgRecursion(currentNode.right);

7. Ye process har node ke liye repeat hota hai.

IMPORTANT:

Recursion mein LEFT aur RIGHT calls ek saath execute nahi hoti.

Pehle LEFT call complete hoti hai.
Phir current ROOT print hota hai.
Uske baad RIGHT call execute hoti hai.

Null par return hone ka matlab poora program stop hona nahi hai.
Sirf woh particular recursive call complete hoti hai.


============================================================
DISPLAY METHOD
============================================================

public void displayUsgRecursion()
{
    System.out.println("Traversing Element in InOrder using Recursion");
    displayInorderUsgRecursion(root);
}


============================================================
RECURSIVE CALLING TREE
============================================================

                  displayInorder(10)
                  /               \
                 /                 \
        displayInorder(20)     displayInorder(30)
          /          \           /          \
         /            \         /            \
displayInorder(40) displayInorder(50) displayInorder(60) displayInorder(70)


IMPORTANT:
Ye diagram parent-child recursive calls dikhata hai.
Actual execution LEFT subtree se start hota hai aur LEFT complete
hone ke baad hi ROOT print hota hai, phir RIGHT subtree execute hota hai.


============================================================
DETAILED RECURSIVE CALLING AND RETURNING
============================================================

Tree:

                  10
                /    \
              20      30
             /  \    /  \
            40  50  60  70

CALL 1:
displayInorder(10)

10.left = 20
Call displayInorder(20)

CALL 2:
displayInorder(20)

20.left = 40
Call displayInorder(40)

CALL 3:
displayInorder(40)

40.left = null
Call displayInorder(null)

CALL 4:
displayInorder(null)

currentNode == null --> TRUE
return;

Control returns to displayInorder(40).

Now node 40 continues:

Left call complete.
Print 40.

Output:
40

Now call right:
displayInorder(40.right)
displayInorder(null)

Null condition true, return.

Node 40 has no more statements.
displayInorder(40) completes.

Control returns to displayInorder(20).


NODE 20 CONTINUES:

Left subtree is completed.
Print 20.

Output:
40
20

Now call right:
displayInorder(50)

CALL:
displayInorder(50)

50.left = null --> return
Print 50.

Output:
40
20
50

50.right = null --> return

Node 50 completes.
Control returns to displayInorder(20).

Node 20 completes.
Control returns to displayInorder(10).


NODE 10 CONTINUES:

Left subtree is completely completed.
Print 10.

Output:
40
20
50
10

Now call right:
displayInorder(30)


NODE 30 EXECUTION:

30.left = 60
Call displayInorder(60).

NODE 60:

60.left = null --> return
Print 60.

Output:
40
20
50
10
60

60.right = null --> return

Node 60 completes.
Control returns to displayInorder(30).

Now print 30.

Output:
40
20
50
10
60
30

Now call right:
displayInorder(70)


NODE 70:

70.left = null --> return
Print 70.

Output:
40
20
50
10
60
30
70

70.right = null --> return

Node 70 completes.
Control returns to displayInorder(30).

Node 30 completes.
Control returns to displayInorder(10).

Node 10 completes.

RECURSION COMPLETED.


============================================================
PART 3: INORDER TRAVERSAL USING STACK
============================================================

METHOD:

public void displayInorderUsgStack(Node CurrentElement)
{
    Stack<Node> stack = new Stack<>();

    while(CurrentElement != null || !stack.isEmpty())
    {
        while(CurrentElement != null)
        {
            stack.push(CurrentElement);
            CurrentElement = CurrentElement.left;
        }

        Node CurrentRemovedElement = stack.pop();

        System.out.println(CurrentRemovedElement.data);

        CurrentElement = CurrentRemovedElement.right;
    }
}


============================================================
MAIN LOGIC OF INORDER USING STACK (HINGLISH)
============================================================

INORDER RULE:

LEFT --> ROOT --> RIGHT

1. Sabse pehle ek empty Stack create karte hain.

   Stack<Node> stack = new Stack<>();

2. Outer while loop check karta hai ki CurrentElement null nahi hai
   YA Stack empty nahi hai.

   while(CurrentElement != null || !stack.isEmpty())

   Dono mein se koi ek condition true hogi toh loop chalega.

3. Inner while loop current node ko Stack mein push karta hai
   aur baar-baar LEFT child ki taraf move karta hai.

   while(CurrentElement != null)
   {
       stack.push(CurrentElement);
       CurrentElement = CurrentElement.left;
   }

4. Jab CurrentElement null ho jata hai, iska matlab hum left side
   mein aur aage nahi ja sakte.

5. Ab Stack ke top node ko pop karte hain.

   Node CurrentRemovedElement = stack.pop();

6. Pop kiye hue node ka data print karte hain.

   System.out.println(CurrentRemovedElement.data);

7. Ab us popped node ke RIGHT child par move karte hain.

   CurrentElement = CurrentRemovedElement.right;

8. Agar right child present hai, toh inner while loop us right child
   aur uske left children ko Stack mein push karega.

9. Agar right child null hai, toh next outer iteration mein Stack
   se next pending node pop hoga.

10. Jab CurrentElement null ho aur Stack bhi empty ho jaye,
    traversal complete ho jata hai.

IMPORTANT:

Stack LIFO follow karta hai:
Last In First Out.

push() --> Node ko Stack ke top par add karta hai.
pop()  --> Stack ke top se node remove karta hai.

Recursion approach mein Java call stack manage karta hai.
Stack approach mein hum manually Stack<Node> use karke pending nodes
manage karte hain.


============================================================
STACK TRAVERSAL: DETAILED STEP-BY-STEP WORKING
============================================================

TREE:

                  10
                /    \
              20      30
             /  \    /  \
            40  50  60  70

Initial:

CurrentElement = 10
Stack = []


------------------------------------------------------------
STEP 1: MOVE TOWARDS LEFT
------------------------------------------------------------

CurrentElement = 10

push(10)
Stack = [10]

Move left:
CurrentElement = 20

push(20)
Stack = [10, 20]

Move left:
CurrentElement = 40

push(40)
Stack = [10, 20, 40]

Move left:
CurrentElement = null

Inner while stops.

Stack top = 40


------------------------------------------------------------
STEP 2: POP AND PRINT 40
------------------------------------------------------------

CurrentElement = null
Stack = [10, 20, 40]

pop() --> 40

Stack = [10, 20]

Print 40.

Output:
40

Move right:
CurrentElement = 40.right = null


------------------------------------------------------------
STEP 3: POP AND PRINT 20
------------------------------------------------------------

Outer while condition is true because Stack is not empty.

CurrentElement = null
Stack = [10, 20]

Inner while is skipped because CurrentElement is null.

pop() --> 20

Stack = [10]

Print 20.

Output:
40
20

Move right:
CurrentElement = 20.right = 50


------------------------------------------------------------
STEP 4: PUSH AND POP 50
------------------------------------------------------------

CurrentElement = 50

push(50)
Stack = [10, 50]

Move left:
CurrentElement = null

Inner while stops.

pop() --> 50

Stack = [10]

Print 50.

Output:
40
20
50

Move right:
CurrentElement = 50.right = null


------------------------------------------------------------
STEP 5: POP ROOT 10
------------------------------------------------------------

CurrentElement = null
Stack = [10]

Inner while is skipped.

pop() --> 10

Stack = []

Print 10.

Output:
40
20
50
10

Move right:
CurrentElement = 10.right = 30


------------------------------------------------------------
STEP 6: TRAVERSE LEFT SIDE OF 30
------------------------------------------------------------

CurrentElement = 30

push(30)
Stack = [30]

Move left:
CurrentElement = 60

push(60)
Stack = [30, 60]

Move left:
CurrentElement = null

Inner while stops.

pop() --> 60

Stack = [30]

Print 60.

Output:
40
20
50
10
60

Move right:
CurrentElement = 60.right = null


------------------------------------------------------------
STEP 7: POP AND PRINT 30
------------------------------------------------------------

CurrentElement = null
Stack = [30]

Inner while is skipped.

pop() --> 30

Stack = []

Print 30.

Output:
40
20
50
10
60
30

Move right:
CurrentElement = 30.right = 70


------------------------------------------------------------
STEP 8: PUSH AND POP 70
------------------------------------------------------------

CurrentElement = 70

push(70)
Stack = [70]

Move left:
CurrentElement = null

Inner while stops.

pop() --> 70

Stack = []

Print 70.

Output:
40
20
50
10
60
30
70

Move right:
CurrentElement = 70.right = null


------------------------------------------------------------
STEP 9: TERMINATION
------------------------------------------------------------

CurrentElement = null
Stack = []

Outer while condition:

CurrentElement != null || !stack.isEmpty()

FALSE || FALSE

Therefore, outer while loop stops.

STACK TRAVERSAL COMPLETED.


============================================================
COMPLETE STACK PUSH / POP SUMMARY
============================================================

1. Push 10       Stack = [10]
2. Push 20       Stack = [10, 20]
3. Push 40       Stack = [10, 20, 40]
4. Pop 40        Stack = [10, 20]       Print 40
5. Pop 20        Stack = [10]           Print 20
6. Push 50       Stack = [10, 50]
7. Pop 50        Stack = [10]           Print 50
8. Pop 10        Stack = []             Print 10
9. Push 30       Stack = [30]
10. Push 60      Stack = [30, 60]
11. Pop 60       Stack = [30]           Print 60
12. Pop 30       Stack = []             Print 30
13. Push 70      Stack = [70]
14. Pop 70       Stack = []             Print 70

FINAL INORDER OUTPUT:

40
20
50
10
60
30
70


============================================================
PART 4: COMPARISON OF ALL THREE METHODS
============================================================

1. ADD METHOD USING QUEUE

- Queue ka use insertion ke liye hota hai.
- Queue FIFO follow karti hai.
- Nodes level by level insert hote hain.
- Har node ka LEFT position pehle check hota hai.
- LEFT occupied ho toh RIGHT position check hota hai.
- Pehli empty position par new node insert hota hai.

2. INORDER USING RECURSION

- Recursion ka use traversal ke liye hota hai.
- Order LEFT -> ROOT -> RIGHT hota hai.
- Pehle complete left subtree execute hota hai.
- Uske baad current node print hota hai.
- Phir right subtree execute hota hai.
- Recursive calls ko manage karne ke liye Java call stack use karta hai.

3. INORDER USING STACK

- Explicit Stack<Node> ka use traversal ke liye hota hai.
- Order LEFT -> ROOT -> RIGHT hi rehta hai.
- Current node aur uske left nodes Stack mein push hote hain.
- Left side complete hone par top node pop aur print hota hai.
- Uske baad popped node ke right child par move karte hain.
- Stack empty aur CurrentElement null hone par traversal complete hota hai.


============================================================
IMPORTANT DIFFERENCE: RECURSION VS STACK
============================================================

RECURSION:

displayInorderUsgRecursion(currentNode.left);

Java recursive method calls ko internally call stack mein manage karta hai.

STACK:

stack.push(CurrentElement);
CurrentElement = CurrentElement.left;

Hum khud Stack<Node> create karke nodes store karte hain.

Dono methods ka traversal order same hai:
LEFT -> ROOT -> RIGHT

Dono ka output same aata hai.


============================================================
PART 5: FINAL OUTPUT
============================================================

Traversing Element in InOrder using Recursion

40
20
50
10
60
30
70

Traversing Element in InOrder using Stack

40
20
50
10
60
30
70


============================================================
TIME AND SPACE COMPLEXITY
============================================================

ADD METHOD USING QUEUE:

Time Complexity:
O(n) in the worst case.

Reason:
Worst case mein insertion ke liye multiple existing nodes visit
karne pad sakte hain.

Space Complexity:
O(n) worst case for Queue.

INORDER USING RECURSION:

Time Complexity:
O(n)

Reason:
Har node exactly once visit hota hai.

Space Complexity:
O(h)

Reason:
Recursive calls call stack mein store hoti hain.
h = height of the tree.

INORDER USING STACK:

Time Complexity:
O(n)

Reason:
Har node exactly once Stack mein push aur exactly once pop hota hai.

Space Complexity:
O(h)

Reason:
Stack mein maximum tree ki height ke proportional nodes pending
ho sakte hain.

n = Total number of nodes.
h = Height of the tree.

============================================================
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion
{
    // ==================================================
    // NODE CLASS
    // ==================================================

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

    // ==================================================
    // ADD METHOD: To insert elements using Queue
    // Time Complexity: O(n) in worst case
    // ==================================================

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

    // ==================================================
    // Way -1: Traversal Using Recursion Logic
    // INORDER TRAVERSAL: LEFT -> ROOT -> RIGHT
    // Time Complexity: O(n)
    // ==================================================

    public void displayInorderUsgRecursion(Node currentNode)
    {
        if(currentNode == null)
        {
            return;
        }

        displayInorderUsgRecursion(currentNode.left);

        System.out.println(currentNode.data);

        displayInorderUsgRecursion(currentNode.right);
    }

    // ==================================================
    // DISPLAY METHOD: Using Recursion
    // ==================================================

    public void displayUsgRecursion()
    {
        System.out.println("Traversing Element in InOrder using Recursion");

        displayInorderUsgRecursion(root);

        System.out.println();
    }

    // ==================================================
    // Way -2: Using Stack
    // INORDER TRAVERSAL: LEFT -> ROOT -> RIGHT
    // Time Complexity: O(n)
    // ==================================================

    public void displayUsgStack()
    {
        System.out.println("Traversing Element in InOrder using Stack");

        displayInorderUsgStack(root);

        System.out.println();
    }

    // ==================================================
    // INORDER TRAVERSAL USING STACK Logic
    // ==================================================

    public void displayInorderUsgStack(Node CurrentElement)
    {
        Stack<Node> stack = new Stack<>();

        while(CurrentElement != null || !stack.isEmpty())
        {
            while(CurrentElement != null)
            {
                stack.push(CurrentElement);

                CurrentElement = CurrentElement.left;
            }

            Node CurrentRemovedElement = stack.pop();

            System.out.println(CurrentRemovedElement.data);

            CurrentElement = CurrentRemovedElement.right;
        }
    }

}