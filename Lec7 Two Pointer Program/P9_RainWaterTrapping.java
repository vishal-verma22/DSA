// Problem Statement:
// WAP to find the total amount of rain water trapped
// between the bars using the Two Pointer Approach.
//
// Logic:
//
// 1. Initialize two pointers:
//    - L (Left Pointer) at the beginning of the array.
//    - R (Right Pointer) at the end of the array.
//
//    => Hum array ko left aur right dono sides se process karenge.
//
// 2. Maintain two variables:
//    - maxLeftHeight
//    - maxRightHeight
//
//    => Sabse pehle hume Left aur Right side ki maximum wall find karni
//       padti hai, kyunki water store hone ke liye hamesha do walls chahiye.
//       Ek wall left side par aur ek wall right side par honi chahiye.
//
// 3. In every iteration, update maxLeftHeight and maxRightHeight.
//
//    maxLeftHeight  = Math.max(maxLeftHeight, height[L])
//    maxRightHeight = Math.max(maxRightHeight, height[R])
//
//    => Agar current height pehle se badi hai to wahi new maximum wall
//       ban jayegi.
//
// 4. Compare maxLeftHeight and maxRightHeight.
//
//    => Water kitna store hoga ye hamesha chhoti wall decide karti hai,
//       kyunki paani kabhi bhi chhoti wall ke upar store nahi ho sakta.
//
//    => Agar maxLeftHeight < maxRightHeight:
//
//       Iska matlab Left side ki wall chhoti hai.
//       Aur Right side par already usse badi wall available hai.
//
//       Isliye current Left position par kitna water trap hoga,
//       wo safely calculate kiya ja sakta hai.
//
//       Trapped Water = maxLeftHeight - height[L]
//
//       Water calculate karne ke baad Left Pointer ko aage move karo.
//
//    => Otherwise:
//
//       Right side ki wall chhoti ya equal hai.
//       Aur Left side par already usse badi wall available hai.
//
//       Isliye current Right position par trapped water calculate karo.
//
//       Trapped Water = maxRightHeight - height[R]
//
//       Water calculate karne ke baad Right Pointer ko piche move karo.
//
// 5. Repeat the same process until L < R.
//
// 6. Jab loop complete ho jayega,
//    tab 'water' variable me total trapped rain water store hoga.
//
// Time Complexity : O(n)
// Space Complexity : O(1)

public class P9_RainWaterTrapping {

		public static int trapWater(int[] height) {

			int L = 0;
			int R = height.length - 1;

			int maxLeftHeight = 0;
			int maxRightHeight = 0;

			int water = 0;

			while (L < R) {

				// Update maximum height from left
				maxLeftHeight = Math.max(maxLeftHeight, height[L]);

				// Update maximum height from right
				maxRightHeight = Math.max(maxRightHeight, height[R]);

				// Process the side having smaller maximum height
				if (maxLeftHeight < maxRightHeight) {

					water += maxLeftHeight - height[L];
					L++;

				} else {

					water += maxRightHeight - height[R];
					R--;
				}
			}

			return water;
		}

		public static void main(String[] args) {

			int[] height = {4, 2, 0, 3, 2, 5};

			int ans = trapWater(height);

			System.out.println("Total Trapped Water = " + ans);
		}
	}