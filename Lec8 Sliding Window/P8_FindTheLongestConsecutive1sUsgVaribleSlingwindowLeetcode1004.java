
public class P8_FindTheLongestConsecutive1sUsgVaribleSlingwindowLeetcode1004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int[] nums = {1, 1, 0, 0, 1, 1, 0, 1};
	        int k = 2;
	        
		        int left = 0;
		        int zeroCount = 0;
		        int maximumLength = 0;

		        for (int right = 0; right < nums.length; right++) {

		            if (nums[right] == 0) {
		                zeroCount++;
		            }

		            // Agar zeros k se zyada ho gaye
		            while (zeroCount > k) {

		                if (nums[left] == 0) {
		                    zeroCount--;
		                }

		                left++;
		            }

		            maximumLength = Math.max(maximumLength, right - left + 1);
		        }
		        
		        System.out.println("Maximum consecutive 1s = " + maximumLength);


		    }

	}


