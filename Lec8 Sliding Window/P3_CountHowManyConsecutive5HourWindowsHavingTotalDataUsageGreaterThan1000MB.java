// Wap to count how many consecutive 5 hour windows having total data usage greater than 1000 MB

public class P3_CountHowManyConsecutive5HourWindowsHavingTotalDataUsageGreaterThan1000MB {

	public static void main(String[] args) {

		int[] dataUsage = { 500, 250, 150, 50, 50, 300, 450, 10, 50, 50 };
		int days = 5;
		int length = dataUsage.length;

		int totalDataUsage = 0;
		int count = 0;

		for (int i = 0; i < days; i++) {
			totalDataUsage = totalDataUsage + dataUsage[i];

		}
		if (totalDataUsage == 1000) {
			count++;
		}
		System.out.println("Total Data Usage=>"+totalDataUsage +"Count=>"+count);

		
		
		for (int i = 1; i <=length- days; i++) {
			totalDataUsage = totalDataUsage-dataUsage[i-1] + dataUsage[i+days-1];
			if (totalDataUsage == 1000) {
				count++;
			}
			System.out.println("Total Data Usage=>"+totalDataUsage +"Count=>"+count);

			

		}
	}
	

}
