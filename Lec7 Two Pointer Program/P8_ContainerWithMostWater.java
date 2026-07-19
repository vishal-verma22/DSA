// Problem Statement:
// WAP to find the maximum amount of water that can be stored
// between any two vertical lines.
//
// Logic:

/*
1. Initialize two pointers:
   - L (Left Pointer) at the beginning of the array.
   - R (Right Pointer) at the end of the array.

   => Initially, dono pointers ke beech ki width sabse maximum hoti hai.
      Isliye hum maximum possible width se start karte hain.
*/

// 2. Calculate the width of the container in each step.

/*
   Width = R - L

   => Width hamesha dono pointers ke indices ke difference se milti hai.
*/

// 3. Find the height of the container and calculate the area.

/*
   Height = Math.min(height[L], height[R])
   Area   = Width × Height

   => Container ki height kabhi bhi badi wall decide nahi karti.
      Water hamesha chhoti wall tak hi ruk sakta hai.
      Isliye dono heights me se minimum height ka use kiya jata hai.
*/

// 4. Agar current area, maxArea se bada hai,
//    to maxArea ko update kar do.

/*
5. Ab decide karo kis pointer ko move karna hai.

   => Hamesha chhoti height wale pointer ko move karo.

   Reason:

   - Container me kitna water store hoga vo hamesha chhoti wall hi decide kart hai..

   - Agar hum badi height wale pointer ko move karenge:
       * Width kam ho jayegi.
       * Chhoti height wahi rahegi.
       * Isliye area badhne ka koi chance nahi hoga.

   - Agar hum chhoti height wale pointer ko move karenge:
       * Ho sakta hai aage usse badi height mil jaye.
       * Agar badi height mil gayi to minimum height increase hogi.
       * Aur area badhne ka chance banega.

   => Isliye hamesha chhoti height wale pointer ko hi move karte hain.
*/

// 6. Jab tak L < R ho tab tak process repeat karo.

// 7. End me maxArea hi answer hoga.
//
// Time Complexity : O(n)
// Space Complexity : O(1)
public class P8_ContainerWithMostWater {

	public static int maxWater(int height[]) {

		int L = 0;
		int R = height.length - 1;

		int maxArea = 0;

		while (L < R) {

			// Width between two pointers
			int width = R - L;

			// Height of container is decided by the smaller wall
			int minHeight = Math.min(height[L], height[R]);

			// Current area
			int area = width * minHeight;

			// Update maximum area
			if (area > maxArea) {
				maxArea = area;
			}

			// Move the pointer having the smaller height
			if (height[L] < height[R]) {
				L++;
			} else {
				R--;
			}
		}

		return maxArea;
	}

	public static void main(String[] args) {

		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

		int ans = maxWater(height);

		System.out.println("Maximum Water = " + ans);

	}
}
