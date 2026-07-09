// wap to count the frequency of each elements

public class P2_CountTheFrequencyOfEachElements {

	public static void main(String[] args) {

		int arr1[] = { 2, 14, 2, 5, 14, 2, 12, 25 };

		int n = arr1.length;

		for (int i = 0; i < n; i++) {
			int count = 0;
			boolean alreadyCounted=false;
			for (int k = 0; k < i; k++) {
				if (arr1[i] == arr1[k]) {
			        alreadyCounted = true;
			        break;

				}

			}
			if(alreadyCounted) {
			continue;
			
			}
			for (int j = 0; j < n; j++) {

				if (arr1[i] == arr1[j]) {
					count++;

				}

			}

			System.out.println(arr1[i] + "==>" + count);
		}
	}

}
