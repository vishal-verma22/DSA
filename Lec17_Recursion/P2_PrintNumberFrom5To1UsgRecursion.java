
package Lec17_Recursion;

/*
============================================================
       PRINT NUMBERS FROM 5 TO 1 USING RECURSION
============================================================

Problem Statement:

Print numbers from 5 to 1 using recursion without using
any iterative statement (for, while).

Main Logic:

1. printNumber(1) se recursion start hoga.
2. Har method call mein printNumber(no + 1) pehle execute hoga.
3. Current number recursive call ke return hone ke baad print hoga.
4. Jab no ki value 6 ho jayegi, condition no <= 5
   false ho jayegi aur recursion stop ho jayega.
5. Ab returning phase mein numbers print honge in reverse order.

Base Condition:

if(no <= 5)

Jab no = 6 hoga, condition false ho jayegi aur method return
ho jayega.

Recursive Call:

printNumber(no + 1);

Har call mein number 1 se increment hota jayega.


============================================================
             STACK WORKING (PUSH OPERATION)
============================================================

Initial Call:

main() calls printNumber(1)

------------------------------------------------------------
STEP 1: printNumber(1)
------------------------------------------------------------

no = 1

Condition: 1 <= 5 (TRUE)

First Calls: printNumber(1+1)  // printNumber(2)

System.out.println(1) abhi execute nahi hoga.
Ye recursive call return hone ke baad execute hoga.

Stack after PUSH:

       |------------------|
       | printNumber(1)   | <- TOP
       |------------------|


------------------------------------------------------------
STEP 2: printNumber(2)
------------------------------------------------------------

no = 2

Condition: 2 <= 5 (TRUE)

First Calls: printNumber(2+1)  // printNumber(3)

System.out.println(2) abhi execute nahi hoga.

Stack after PUSH:

       |------------------|
       | printNumber(2)   | <- TOP
       |------------------|
       | printNumber(1)   |
       |------------------|


------------------------------------------------------------
STEP 3: printNumber(3)
------------------------------------------------------------

no = 3

Condition: 3 <= 5 (TRUE)

First Calls: printNumber(3+1)  // printNumber(4)

System.out.println(3) abhi execute nahi hoga.

Stack after PUSH:

       |------------------|
       | printNumber(3)   | <- TOP
       |------------------|
       | printNumber(2)   |
       |------------------|
       | printNumber(1)   |
       |------------------|


------------------------------------------------------------
STEP 4: printNumber(4)
------------------------------------------------------------

no = 4

Condition: 4 <= 5 (TRUE)

First Calls: printNumber(4+1)  // printNumber(5)

System.out.println(4) abhi execute nahi hoga.

Stack after PUSH:

       |------------------|
       | printNumber(4)   | <- TOP
       |------------------|
       | printNumber(3)   |
       |------------------|
       | printNumber(2)   |
       |------------------|
       | printNumber(1)   |
       |------------------|


------------------------------------------------------------
STEP 5: printNumber(5)
------------------------------------------------------------

no = 5

Condition: 5 <= 5 (TRUE)

First Calls: printNumber(5+1)  // printNumber(6)

System.out.println(5) abhi execute nahi hoga.

Stack after PUSH:

       |------------------|
       | printNumber(5)   | <- TOP
       |------------------|
       | printNumber(4)   |
       |------------------|
       | printNumber(3)   |
       |------------------|
       | printNumber(2)   |
       |------------------|
       | printNumber(1)   |
       |------------------|


------------------------------------------------------------
STEP 6: printNumber(6)
------------------------------------------------------------

no = 6

Condition: 6 <= 5 (FALSE)

Base Condition reached.

No recursive call.
No printing takes place.

Method returns.

Stack at this moment:

       |------------------|
       | printNumber(6)   | <- TOP (RETURN)
       |------------------|
       | printNumber(5)   |
       |------------------|
       | printNumber(4)   |
       |------------------|
       | printNumber(3)   |
       |------------------|
       | printNumber(2)   |
       |------------------|
       | printNumber(1)   |
       |------------------|


============================================================
            POP OPERATION (RETURNING PHASE)
============================================================

Now recursion starts returning from the base condition.

Important:
System.out.println(no) will execute when each recursive
method returns.

------------------------------------------------------------
STEP 1: printNumber(6) RETURNS
------------------------------------------------------------

Base condition method returns.

printNumber(6) -> POP

Stack after POP:

       |------------------|
       | printNumber(5)   | <- TOP
       |------------------|
       | printNumber(4)   |
       |------------------|
       | printNumber(3)   |
       |------------------|
       | printNumber(2)   |
       |------------------|
       | printNumber(1)   |
       |------------------|


------------------------------------------------------------
STEP 2: printNumber(5) RETURNS
------------------------------------------------------------

Now System.out.println(5) executes.

Prints: 5

printNumber(5) -> POP

Stack after POP:

       |------------------|
       | printNumber(4)   | <- TOP
       |------------------|
       | printNumber(3)   |
       |------------------|
       | printNumber(2)   |
       |------------------|
       | printNumber(1)   |
       |------------------|


------------------------------------------------------------
STEP 3: printNumber(4) RETURNS
------------------------------------------------------------

Now System.out.println(4) executes.

Prints: 4

printNumber(4) -> POP

Stack after POP:

       |------------------|
       | printNumber(3)   | <- TOP
       |------------------|
       | printNumber(2)   |
       |------------------|
       | printNumber(1)   |
       |------------------|


------------------------------------------------------------
STEP 4: printNumber(3) RETURNS
------------------------------------------------------------

Now System.out.println(3) executes.

Prints: 3

printNumber(3) -> POP

Stack after POP:

       |------------------|
       | printNumber(2)   | <- TOP
       |------------------|
       | printNumber(1)   |
       |------------------|


------------------------------------------------------------
STEP 5: printNumber(2) RETURNS
------------------------------------------------------------

Now System.out.println(2) executes.

Prints: 2

printNumber(2) -> POP

Stack after POP:

       |------------------|
       | printNumber(1)   | <- TOP
       |------------------|


------------------------------------------------------------
STEP 6: printNumber(1) RETURNS
------------------------------------------------------------

Now System.out.println(1) executes.

Prints: 1

printNumber(1) -> POP

       STACK IS EMPTY


============================================================
FINAL OUTPUT:

5
4
3
2
1


============================================================
IMPORTANT POINTS:
============================================================

1. Every method call creates a new Stack Frame.

2. PUSH means a new method call is added to the stack.

3. POP means a completed method call is removed.

4. Stack follows LIFO (Last In First Out).

5. In this program, recursive calls happen during the
   calling phase.

6. Printing happens during the returning (POP) phase.

7. This is why output comes in reverse order.


============================================================
                    COMPLEXITY
============================================================

Time Complexity: O(n)

Space Complexity: O(n)


============================================================
                    RECURSION TYPE
============================================================

Recursion Type: Head Recursion

Because the recursive call is executed before processing
(printing) the current number.

============================================================
*/

public class P2_PrintNumberFrom5To1UsgRecursion
{
    //========================================================
    // Print Number Method: Prints numbers from 5 to 1
    //========================================================

    public static void printNumber(int no)
    {
        if(no <= 5)
        {
            printNumber(no + 1);

            System.out.println(no);
        }
    }

    public static void main(String[] args)
    {
        printNumber(1);
    }
}
