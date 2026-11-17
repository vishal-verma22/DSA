package Lec15_Queue_And_its_Implementions;


import java.util.Comparator;
import java.util.PriorityQueue;

public class P12_KClosestPointsToOrigin {

    /*
    ============================================================
    LEETCODE 973 - K CLOSEST POINTS TO ORIGIN
    ============================================================

    PROBLEM:
    Given an array of points where points[i] = [xi, yi],
    return the K points closest to the origin (0,0).

    DISTANCE FORMULA:
    Distance = x^2 + y^2

    Square root calculate karne ki zarurat nahi hai,
    kyunki sirf distances compare karne hain.

    ============================================================
    APPROACH: MAX HEAP USING PRIORITY QUEUE
    ============================================================

    WHY MAX HEAP?

    Hume K closest points chahiye.

    Max Heap mein sabse bada distance root par rahega.

    Agar heap ka size K se bada ho gaya,
    toh poll() karke sabse door point remove kar denge.

    Is tarah heap mein hamesha K closest points rahenge.

    ============================================================
    LOGIC:
    ============================================================

    STEP 1:
    Har point ka distance calculate karo.

    STEP 2:
    Current point ko Max Heap mein insert karo.

    STEP 3:
    Check karo heap ka size K se bada hai ya nahi.

    STEP 4:
    Agar size K se bada hai, toh poll() karke
    maximum distance wala point remove karo.

    STEP 5:
    Finally heap mein K closest points bachenge.

    STEP 6:
    Heap se K points nikal kar result array mein store karo.

    ============================================================
    DRY RUN:
    ============================================================

    Points = [[1,3], [-2,2], [5,8], [0,1]]
    K = 2

    Distance = x^2 + y^2

    [1,3]  = 1 + 9  = 10
    [-2,2] = 4 + 4  = 8
    [5,8]  = 25 + 64 = 89
    [0,1]  = 0 + 1  = 1

    STEP 1: Insert [1,3]
    Heap = [10]

    STEP 2: Insert [-2,2]
    Heap = [10, 8]

    STEP 3: Insert [5,8]
    Heap = [89, 8, 10]

    Heap Size = 3, K = 2

    3 > 2, so poll() removes distance 89.

    Heap = [10, 8]

    STEP 4: Insert [0,1]
    Heap = [10, 8, 1]

    Heap Size = 3, K = 2

    3 > 2, so poll() removes distance 10.

    Final Heap = [8, 1]

    Closest Points = [-2,2] and [0,1]

    ============================================================
    COMPARATOR:
    ============================================================

    return Integer.compare(distance2, distance1);

    Isse Max Heap order maintain hota hai.
    Sabse bada distance PriorityQueue ke top par rahega.

    ============================================================
    TIME COMPLEXITY:
    ============================================================

    Insertion = O(log K)
    Deletion  = O(log K)
    Total     = O(N log K)

    Space Complexity = O(K)

    ============================================================
    */

    public int[][] kClosest(int[][] points, int k) {

        //============================================================
        // Comparator: Max Heap banane ke liye
        //============================================================

        Comparator<int[]> distanceComparator = new Comparator<>() {

            public int compare(int[] point1, int[] point2) {

                // First point ka distance calculate karna
                int x1 = point1[0];
                int y1 = point1[1];

                int distance1 = (x1 * x1) + (y1 * y1);

                // Second point ka distance calculate karna
                int x2 = point2[0];
                int y2 = point2[1];

                int distance2 = (x2 * x2) + (y2 * y2);

                // Max Heap: Sabse bada distance top par rahega
                return Integer.compare(distance2, distance1);
            }
        };

        // Max Heap create karna
        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>(distanceComparator);

        //============================================================
        // Offer: Points ko Heap mein insert karna
        //============================================================

        for (int i = 0; i < points.length; i++) {

            int[] currentPoint = points[i];

            // Current point ko Heap mein insert karo
            maxHeap.offer(currentPoint);

            // Agar Heap ka size K se bada ho gaya
            if (maxHeap.size() > k) {

                // Sabse door wala point remove karo
                maxHeap.poll();
            }
        }

        //============================================================
        // Result Array: K closest points store karna
        //============================================================

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {

            // Heap se closest point nikalna
            int[] closestPoint = maxHeap.poll();

            result[i][0] = closestPoint[0];
            result[i][1] = closestPoint[1];
        }

        return result;
    }

    //============================================================
    // Main Method
    //============================================================

    public static void main(String[] args) {

        P12_KClosestPointsToOrigin obj =
                new P12_KClosestPointsToOrigin();

        int[][] points = {
                {1, 3},
                {-2, 2},
                {5, 8},
                {0, 1}
        };

        int k = 2;

        int[][] result = obj.kClosest(points, k);

        System.out.println("K Closest Points:");

        for (int i = 0; i < result.length; i++) {

            System.out.println(
                    "[" + result[i][0] + ", " + result[i][1] + "]"
            );
        }
    }
}

