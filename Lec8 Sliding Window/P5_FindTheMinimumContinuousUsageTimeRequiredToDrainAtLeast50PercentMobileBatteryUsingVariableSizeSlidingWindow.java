// WAP to find the minimum continuous usage time required to drain at least 50% mobile battery

public class P5_FindTheMinimumContinuousUsageTimeRequiredToDrainAtLeast50PercentMobileBatteryUsingVariableSizeSlidingWindow {

    public static void main(String[] args) {

        // Array ka har ek element 1 hour ka battery usage (%) represent karta hai
    	/*
		1st hour → 5%
		2nd hour → 8%
		3rd hour → 12%
		4th hour → 10%
		5th hour → 15%
    	 */
        int[] batteryUsage = {5, 8, 12, 10, 15, 7, 6, 12, 9, 14};

        int length = batteryUsage.length;

        int minimumTime = Integer.MAX_VALUE;

        int Left = 0;
        int Right;

        int totalBatteryUsage = 0;

        // Right window ko expand karta hai aur har hour ka battery usage add karta hai
        for (Right = 0; Right < length; Right++) {

            totalBatteryUsage = totalBatteryUsage + batteryUsage[Right];

            // 50% battery y use jada drain hone par window ko chhota karke minimum time find karte hain
            while (totalBatteryUsage >= 50) {

                // Current window mein kitne continuous hours hain
                int currentTime = Right - Left + 1;

                // Sabse kam valid continuous hours ko store karta hai
                minimumTime = Math.min(currentTime, minimumTime);

                // Left wale hour ka usage remove karke window ko shrink karte hain
                totalBatteryUsage = totalBatteryUsage - batteryUsage[Left];
                Left++;
            }
        }

        System.out.println(minimumTime);
    }
}