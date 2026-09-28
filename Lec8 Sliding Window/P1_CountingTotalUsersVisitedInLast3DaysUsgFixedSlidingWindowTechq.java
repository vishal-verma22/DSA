// In this we finding the total number of users visited to our website in last 3 days
// using fixed sized sliding window technique

public class P1_CountingTotalUsersVisitedInLast3DaysUsgFixedSlidingWindowTechq {

	public static void main(String[] args) {

		int[] users = { 190, 230, 450, 360, 420, 120, 240 };
		int days = 3;

		int length = users.length;

		// for counting starting 3 days users visited to our website
		int total = 0;
		
		for (int i = 0; i < days; i++) {
			total = total + users[i];

		}
		System.out.println("starting 3 days users visited Sum=> "+total);

		
		
		// for counting remaining days users visited to our website
		
		for(int i=1;i<=length-days;i++) {
			
			total=total-users[i-1]+users[i+days-1];
			System.out.println("remaining days users visited Sum=> "+total);

		}

	}

}
