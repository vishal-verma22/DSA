
package Lec17_Recursion;



/*
============================================================
       PRINT NUMBERS FROM 1 TO 5 USING RECURSION
============================================================

Problem Statement:
Print numbers from 1 to 5 using recursion without using
any iterative statement (for, while).

Main Logic:
1. printNumber(1) se recursion start hoga.
2. Har method call mein current number print hoga.
3. Uske baad printNumber(no + 1) call hoga.
4. Jab no ki value 6 ho jayegi, condition no <= 5
   false ho jayegi aur recursion stop ho jayega.

Base Condition:
if(no <= 5)

Jab no = 6 hoga, condition false hogi aur method
aage execute nahi hoga. Method return ho jayega.

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
Prints: 1
Calls: printNumber(1+1)  //2

Stack after PUSH:

       |------------------|
       | printNumber(1)   | <- TOP
       |------------------|


------------------------------------------------------------
STEP 2: printNumber(2)
------------------------------------------------------------

no = 2
Condition: 2 <= 5 (TRUE)
Prints: 2
Calls: printNumber(2+1) //3

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
Prints: 3
Calls: printNumber(4)

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
Prints: 4
Calls: printNumber(5)

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
Prints: 5
Calls: printNumber(6)

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
No printing and no further recursive call.
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

STEP 1:
printNumber(6) returns.
printNumber(6) -> POP

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


STEP 2:
printNumber(5) completes.
printNumber(5) -> POP

       |------------------|
       | printNumber(4)   | <- TOP
       |------------------|
       | printNumber(3)   |
       |------------------|
       | printNumber(2)   |
       |------------------|
       | printNumber(1)   |
       |------------------|


STEP 3:
printNumber(4) completes.
printNumber(4) -> POP

       |------------------|
       | printNumber(3)   | <- TOP
       |------------------|
       | printNumber(2)   |
       |------------------|
       | printNumber(1)   |
       |------------------|


STEP 4:
printNumber(3) completes.
printNumber(3) -> POP

       |------------------|
       | printNumber(2)   | <- TOP
       |------------------|
       | printNumber(1)   |
       |------------------|


STEP 5:
printNumber(2) completes.
printNumber(2) -> POP

       |------------------|
       | printNumber(1)   | <- TOP
       |------------------|


STEP 6:
printNumber(1) completes.
printNumber(1) -> POP

       STACK IS EMPTY


============================================================
FINAL OUTPUT:
1
2
3
4
5

IMPORTANT:
1. Every method call creates a new Stack Frame.
2. PUSH means a new method call is added to the stack.
3. POP means a completed method call is removed.
4. Stack follows LIFO (Last In First Out).
5. First print happens during PUSH/calling phase.
6. No printing happens during POP/returning phase.
============================================================


Time Complexity: O(n)
Space Complexity: O(n)

Recursion Type: Tail Recursion
 	Because the recursive call is the last operation of the method.
*/
public class P1_PrintNumberFrom1To5uUsgRecursion
{
    //========================================================
    // Print Number Method: Prints numbers from 1 to 5
    //========================================================

    public static void printNumber(int no)
    {
        if(no <= 5)
        {
            System.out.println(no);

            printNumber(no + 1);
        }
    }

    public static void main(String[] args)
    {
        printNumber(1);
    }
}
