package Lec15_Queue_And_its_Implementions;


import java.util.LinkedList;
import java.util.Queue;

public class P13_NumberOfRecentCalls {

    /*
    ============================================================
    LEETCODE 933 - NUMBER OF RECENT CALLS
    ============================================================

    PROBLEM:
    Implement RecentCounter class.

    Har ping(t) par current timestamp t diya jayega.

    Hume pichle 3000 milliseconds ke andar aaye
    total requests ka count return karna hai.

    VALID TIME RANGE:

    [t - 3000, t]

    IMPORTANT:
    Dono boundaries inclusive hain.

    ============================================================
    APPROACH: QUEUE
    ============================================================

    WHY QUEUE?

    Requests timestamps ke increasing order mein aate hain.

    Isliye sabse purani request Queue ke FRONT par hogi
    aur sabse nayi request REAR par hogi.

    Hume sirf purani requests remove karni hain.

    Isliye Queue use karenge.

    ============================================================
    LOGIC:
    ============================================================

    STEP 1:
    Current timestamp t ko Queue mein insert karo.

    STEP 2:
    Queue ke FRONT element ko check karo.

    STEP 3:
    Agar front element < t - 3000 hai,
    toh woh valid time range ke bahar hai.

    STEP 4:
    poll() karke purani request remove karo.

    STEP 5:
    Jab tak purani requests milti hain,
    unhe remove karte raho.

    STEP 6:
    Queue ka size return karo.

    ============================================================
    DRY RUN:
    ============================================================

    ping(1)

    Valid Range = [-2999, 1]
    Queue = [1]
    Return = 1

    ------------------------------------------------------------

    ping(100)

    Valid Range = [-2900, 100]
    Queue = [1, 100]
    Return = 2

    ------------------------------------------------------------

    ping(3001)

    Valid Range = [1, 3001]
    Queue = [1, 100, 3001]

    Front = 1

    1 < 1 = false

    Isliye 1 remove nahi hoga.

    Return = 3

    ------------------------------------------------------------

    ping(3002)

    Valid Range = [2, 3002]
    Queue = [1, 100, 3001, 3002]

    Front = 1

    1 < 2 = true
    poll() -> Remove 1

    Queue = [100, 3001, 3002]

    Front = 100

    100 < 2 = false

    Stop.

    Return = 3

    ============================================================
    IMPORTANT CONDITION:
    ============================================================

    while (!queue.isEmpty() && queue.peek() < t - 3000)

    queue.isEmpty():
    Check karta hai Queue empty toh nahi hai.

    queue.peek():
    FRONT timestamp check karta hai.

    queue.peek() < t - 3000:
    Check karta hai request 3000 milliseconds se purani hai.

    WHY < NOT <= ?

    Kyunki time range inclusive hai.

    [t - 3000, t]

    Exactly t - 3000 par aane wali request bhi valid hai.

    ============================================================
    TIME COMPLEXITY:
    ============================================================

    Each ping = Amortized O(1)

    Space Complexity = O(number of valid recent requests)

    Har request maximum ek baar insert aur ek baar remove hoti hai.

    ============================================================
    */

    Queue<Integer> queue;

    //============================================================
    // Constructor: Empty Queue create karna
    //============================================================

    public P13_NumberOfRecentCalls() {

        queue = new LinkedList<>();
    }

    //============================================================
    // Ping Method: Recent requests count karna
    //============================================================

    public int ping(int t) {

        // Current timestamp Queue mein insert karo
        queue.offer(t);

        // Purani requests ko Queue se remove karo
        while (!queue.isEmpty() && queue.peek() < t - 3000) {

            queue.poll();
        }

        // Valid recent requests ka count return karo
        return queue.size();
    }

    //============================================================
    // Main Method
    //============================================================

    public static void main(String[] args) {

        P13_NumberOfRecentCalls obj =
                new P13_NumberOfRecentCalls();

        System.out.println(obj.ping(1));
        System.out.println(obj.ping(100));
        System.out.println(obj.ping(3001));
        System.out.println(obj.ping(3002));
    }
}

