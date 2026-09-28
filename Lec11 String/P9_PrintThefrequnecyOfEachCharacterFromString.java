// wap to print the frequency of each character from string
public class P9_PrintThefrequnecyOfEachCharacterFromString {

	public static void main(String[] args) {

		String str1 = "vishal is good boy";
		int n = str1.length();
		int count;
		boolean found;

		for (int i = 0; i < n; i++) {
			count = 0;
			found = false;
			for (int k = i - 1; k >= 0; k--) {
				if (str1.charAt(i) == str1.charAt(k)) {
					found = true;
					break;
				}

			}
			if (!found) {
				char ch = str1.charAt(i);
				for (int j = 0; j < n; j++) {

					if (ch == str1.charAt(j)) {
						count++;
					}
				}
				System.out.println("Character " + ch + "  Frequny==>" + count);

			}

		}

	}

}
