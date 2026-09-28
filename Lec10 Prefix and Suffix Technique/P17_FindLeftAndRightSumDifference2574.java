// Find Left and Right Sum Difference
// LeetCode 2574

/*
 * ============================================================
 * QUESTION
 * ============================================================
 *
 * Given an integer array nums, for every index i:
 *
 * left[i]  = sum of all elements before index i
 * right[i] = sum of all elements after index i
 *
 * answer[i] = |left[i] - right[i]|
 *
 * Example:
 *
 * nums       = [10, 4, 8, 3]
 *
 * left       = [0, 10, 14, 22]
 * right      = [15, 11, 3, 0]
 *
 * answer     = [15, 1, 11, 22]
 *
 *
 * ============================================================
 * SOLUTION 1: PREFIX + SUFFIX SUM
 * ============================================================
 *
 * Step 1:
 * Create prefix array.
 *
 * prefix[i] = sum from index 0 to i
 *
 * Step 2:
 * Use prefix to calculate left sum.
 *
 * left[i] = prefix[i - 1]
 *
 * For i = 0, there is no element on the left,
 * so left[0] = 0.
 *
 * Step 3:
 * Create suffix array.
 *
 * suffix[i] = sum from index i to last index
 *
 * Step 4:
 * Use suffix to calculate right sum.
 *
 * right[i] = suffix[i + 1]
 *
 * For last index, there is no element on the right,
 * so right[n - 1] = 0.
 *
 * Step 5:
 * Calculate absolute difference:
 *
 * difference[i] = Math.abs(left[i] - right[i])
 *
 *
 * Time Complexity  = O(n)
 * Space Complexity = O(n)
 *
 *
 * ============================================================
 * SOLUTION 2: DIRECT LEFT + RIGHT SUM
 * ============================================================
 *
 * In this approach, we do not need prefix[] and suffix[].
 *
 * We directly calculate left[] and right[].
 *
 * LEFT:
 *
 * left[i] = left[i - 1] + nums[i - 1]
 *
 * This means:
 * previous left sum + previous element
 *
 *
 * RIGHT:
 *
 * right[i] = right[i + 1] + nums[i + 1]
 *
 * This means:
 * next right sum + next element
 *
 * Finally:
 *
 * difference[i] = Math.abs(left[i] - right[i])
 *
 *
 * Time Complexity  = O(n)
 * Space Complexity = O(n)
 *
 */

public class P17_FindLeftAndRightSumDifference2574 {

    public static void main(String[] args) {

        int[] nums = {10, 4, 8, 3};

        /*
         * ========================================================
         * SOLUTION 1
         * Prefix + Suffix Sum
         * ========================================================
         */

        int n = nums.length;

        // --------------------------------------------------------
        // 1. Calculate Prefix Sum
        // --------------------------------------------------------

        int[] prefix = new int[n];

        // First element remains same
        prefix[0] = nums[0];

        // Calculate prefix sum
        for (int i = 1; i < n; i++) {

            // Previous prefix sum + current element
            prefix[i] = prefix[i - 1] + nums[i];
        }


        // --------------------------------------------------------
        // 2. Calculate Left Sum
        // --------------------------------------------------------

        int[] left = new int[n];

        for (int i = 0; i < n; i++) {

            // No element exists on the left of index 0
            if (i == 0) {
                left[i] = 0;
            }
            else {

                // prefix[i - 1] contains
                // sum of all elements before i
                left[i] = prefix[i - 1];
            }
        }


        // --------------------------------------------------------
        // 3. Calculate Suffix Sum
        // --------------------------------------------------------

        int[] suffix = new int[n];

        // Last element remains same
        suffix[n - 1] = nums[n - 1];

        // Calculate suffix from right to left
        for (int i = n - 2; i >= 0; i--) {

            // Next suffix sum + current element
            suffix[i] = suffix[i + 1] + nums[i];
        }


        // --------------------------------------------------------
        // 4. Calculate Right Sum
        // --------------------------------------------------------

        int[] right = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            // No element exists on the right of last index
            if (i == n - 1) {
                right[i] = 0;
            }
            else {

                // suffix[i + 1] contains
                // sum of all elements after i
                right[i] = suffix[i + 1];
            }
        }


        // --------------------------------------------------------
        // 5. Calculate Difference
        // --------------------------------------------------------

        int[] difference = new int[n];

        for (int i = 0; i < n; i++) {

            // Absolute difference between
            // left sum and right sum
            difference[i] = Math.abs(left[i] - right[i]);
        }


        System.out.println("Solution 1:");
        for (int i = 0; i < n; i++) {
            System.out.print(difference[i] + " ");
        }


        /*
         * ========================================================
         * SOLUTION 2
         * Direct Left + Right Sum
         * ========================================================
         */

        // --------------------------------------------------------
        // 1. Calculate Left Sum Directly
        // --------------------------------------------------------

        int[] left2 = new int[n];

        for (int i = 1; i < n; i++) {

            // Previous left sum + previous element
            //
            // left2[i - 1] = sum before i - 1
            // nums[i - 1]  = previous element
            //
            // Together they give sum of all elements before i.
            left2[i] = left2[i - 1] + nums[i - 1];
        }


        // --------------------------------------------------------
        // 2. Calculate Right Sum Directly
        // --------------------------------------------------------

        int[] right2 = new int[n];

        for (int i = n - 2; i >= 0; i--) {

            // Next right sum + next element
            //
            // right2[i + 1] = sum after i + 1
            // nums[i + 1]   = next element
            //
            // Together they give sum of all elements after i.
            right2[i] = right2[i + 1] + nums[i + 1];
        }


        // --------------------------------------------------------
        // 3. Calculate Difference
        // --------------------------------------------------------

        int[] difference2 = new int[n];

        for (int i = 0; i < n; i++) {

            difference2[i] = Math.abs(left2[i] - right2[i]);
        }


        System.out.println("\nSolution 2:");
        for (int i = 0; i < n; i++) {
            System.out.print(difference2[i] + " ");
        }
    }
}