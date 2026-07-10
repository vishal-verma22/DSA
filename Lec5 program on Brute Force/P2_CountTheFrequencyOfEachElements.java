// wap to count the frequency of each elements
// method-1 

public class P2_CountTheFrequencyOfEachElements {

	public static void main(String[] args) {

		int arr1[] = { 2, 14, 2, 5, 14, 2, 12, 25 };

		int n = arr1.length;

		for (int i = 0; i < n; i++) {
			int count = 1; // because current element khud ek baar to present hai hi.
			boolean alreadyCounted = false;
			for (int k = 0; k < i; k++) {
				if (arr1[i] == arr1[k]) {
					alreadyCounted = true;
					break;

				}

			}
			if (alreadyCounted) {
				continue;

			}
			for (int j = i + 1; j < n; j++) { // if we set count =0 --> j=0 and if we set count=1 ->j=i+1

				if (arr1[i] == arr1[j]) {
					count++;

				}

			}

			System.out.println(arr1[i] + "==>" + count);
		}
	}

}
