// Find the Pivot Index
// LeetCode 724

// Pivot index = index where left sum == right sum
// Current element is NOT included in left or right sum

public class P18_FindThePivotIndex724 {

    public static void main(String[] args) {

        int[] nums = {1, 7, 3, 6, 5, 6};
        int n = nums.length;

        // Create prefix sum array
        int[] prefix = new int[n];

        prefix[0] = nums[0];

        // Calculate prefix sum
        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }

        // Find pivot index
        for (int i = 0; i < n; i++) {

            // Remove current element from prefix
            // to get sum of elements on the left
            int leftSum = prefix[i] - nums[i];

            // Total sum - prefix[i]
            // gives sum of elements on the right
            int rightSum = prefix[n - 1] - prefix[i];

            // If both sums are equal, i is pivot index
            if (leftSum == rightSum) {
                System.out.println("Pivot Index = " + i);
                return;
            }
        }

        // No pivot index found
        System.out.println("Pivot Index = -1");
    }
}