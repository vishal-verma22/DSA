// WAP to find the minimum number of consecutive days required to achieve the given target sum.


// Logic:
// We have to find the smallest continuous subarray whose sum
// is greater than or equal to the target.
//
// We use the Sliding Window approach because we need to find
// a continuous/consecutive part of the array.
//
// 1. Initialize two pointers:
//    -initial both Right & left Pointer is at 0
//    - Left pointer window ke starting point ko represent karega.
//    - Right pointer window ke ending point ko represent karega.
//
//    => Initially Left = 0 hota hai aur Right array ke elements
//       ko one by one window me add karta hai.
//
// 2. totalTargetSum variable me current window ka total sum store karo.
//
//    => Jab Right pointer aage move karega, current element ko
//       totalTargetSum me add karte jayenge.
//
// 3. Jab totalTargetSum target se chhota hai,
//    Right pointer aage move karega aur window me naye elements
//    add hote rahenge.
//
//    => Kyunki abhi target achieve nahi hua hai,
//       isliye hume window ko bada karna padega.
//
// 4. Jaise hi totalTargetSum >= target ho jaye,
//    iska matlab current window target achieve kar chuki hai.
//
//    => Ab hume window ko aur bada nahi karna hai pehle.
//       Hume check karna hai ki kya isi target ko
//       aur kam days me achieve kiya ja sakta hai agar kr sakte he minimum day me tab tak while loop chalega .
//
// 5. Isliye while loop ke andar current window ki length calculate karo.
//
//    currentDay = Right - Left + 1
//
//    => Left aur Right dono positions window me included hain,
//       isliye length calculate karne ke liye +1 lagaya hai.
//
// 6. Current window ki length ko minimumDay se compare karo
//    aur jo smaller value hai usko store karo.
//
//    => Kyunki hume maximum nahi, minimum number of days chahiye.
//
// 7. Ab Left pointer ko aage move karo aur Left element ko
//    totalTargetSum se remove karo.
//
//    => Window ko chhota karne ki koshish kar rahe hain,
//       taaki dekha ja sake ki target kam elements se bhi achieve
//       ho raha hai ya nahi.
//
// 8. Agar Left element remove karne ke baad bhi
//    totalTargetSum >= target hai,
//    to current window se bhi chhoti valid window mil sakti hai.
//
//    => Isliye while loop tab tak chalega jab tak
//       target achieve ho raha hai.
//
// 9. Jab totalTargetSum target se chhota ho jaye,
//    iska matlab current window ab target achieve nahi kar rahi.
//
//    => Ab window ko dobara bada karne ke liye
//       Right pointer next element add karega.
//
// 10. Ye process tab tak repeat hoga jab tak Right
//     poore array ko traverse nahi kar leta.
//
// 11. End me minimumDay me target achieve karne ke liye
//     required minimum consecutive days stored honge.
//
//
// Time Complexity : O(n)
// Space Complexity : O(1)


public class P4_FindngMinimumDaysRequiredToCompleteTheTargertUsingVariableSizeSlidingWindow {

	public static void main(String[] args) {

		int[] days = { 2, 1, 3, 1, 5, 6, 4, 1, 3, 3, 2 };

		int target = 7;

		int length = days.length;

		// Initially minimumDay ko maximum possible value diya  taaki baad me current window ke size se compare kar sake.
		int minimumDay = Integer.MAX_VALUE;

		int Left = 0;

		int Right;

		int totalTargetSum = 0;

		
		for (Right = 0; Right < length; Right++) {

			// Current element ko window ke total sum me add karo.
			totalTargetSum = totalTargetSum + days[Right];

			// Jab tak current window target achieve kar rahi hai,
			// window ko chhota karne ki koshish karo.
			while (totalTargetSum >= target) {

				// Current window ki length calculate karo.
				int currentDay = Right - Left + 1;

				// Current valid window aur previous minimum me se  jo chhota hai usko minimumDay me store karo.
				minimumDay = Math.min(minimumDay, currentDay);

				// Left element ko window ke sum se remove karo  kyunki ab window ko chhota karna hai.
				totalTargetSum = totalTargetSum - days[Left];

				// Window ka starting point ek position aage move karo.
				Left++;
			}
		}

		System.out.println(
				"Minimum day required to achieve the target => " + minimumDay);
	}
}