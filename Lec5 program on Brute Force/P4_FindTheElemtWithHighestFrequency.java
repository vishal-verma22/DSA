//wap to find the elements with highest frequency

public class P4_FindTheElemtWithHighestFrequency {

	public static void main(String[] args) {

		int arr1[] = { 2, 14, 2, 5, 14, 2, 12,14,25 };
		int n = arr1.length;

		boolean temp[] = new boolean[n];

		int maxFrequency = 0;
		int maxElement = arr1[0];

		for (int i = 0; i < n; i++) {
			int count = 1; // because current element khud ek baar to present hai hi.

			if (temp[i] == true) {
				continue;
			}
			for (int j = i + 1; j < n; j++) {

				if (arr1[i] == arr1[j]) {
					count++;
					temp[j] = true;
				}
			}
			// System.out.println(arr1[i] + "==>" + count);
			if (count >= maxFrequency) {
				maxFrequency = count;
				maxElement = arr1[i];

			}
		}
		System.out.print("Element==>"+maxElement+" Frequency==> "+maxFrequency);

	}

	// TODO Auto-generated method stub

}
