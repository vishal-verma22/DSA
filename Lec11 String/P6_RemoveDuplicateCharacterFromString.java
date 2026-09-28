// wap to remove all duplicate character from given string

public class P6_RemoveDuplicateCharacterFromString {

	public static void main(String[] args) {

		String orginal = "vishal veirmai";
		int n = orginal.length();
		String newString = "";
		System.out.println(n);

		for (int i = 0; i < n; i++) {

			char ch = orginal.charAt(i);

//checking that orginal string character are present in newString before entering character in newString
			if (newString.indexOf(ch) == -1) {

				newString = newString + ch;
			}
		}
		System.out.println(newString);

	}

}
