// Wap to find the average of users visited in last 3 days

public class P2_FindTheAverageOfUsersVisitedInLast3Days {

	public static void main(String[] args) {
		int[] users = { 190, 230, 450, 360, 420, 120, 240 };
		int days = 3;

		int length = users.length;
		
		int total=0;
		double average=0.0;
		for(int i=0;i<days;i++) {
			
			total=total+users[i];
		}
		
		average=total/days;
		System.out.println("Total users=> "+total+" Average of 3 days=> "+average);

		
	for(int i=1;i<=length-days;i++) {
			
			total=total-users[i-1]+users[i+days-1];
			average=total/days;
			System.out.println("Total users=> "+total+" Average of 3 days=> "+average);

		}
		
		
	}

}
