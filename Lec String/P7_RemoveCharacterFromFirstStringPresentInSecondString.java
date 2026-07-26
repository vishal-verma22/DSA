// wap to remove the character from first string present in second string

/*Example
 * str1="vishal is good boy"
 * str2="sal"
 * output:
 * 		vih i good boy
 */

public class P7_RemoveCharacterFromFirstStringPresentInSecondString {

	public static void main(String[] args) {
		String str1 = "vishal is good boy";
		String str2 = "sal";
		String str = "";
		int n = str1.length();

		for (int i = 0; i < n; i++) {

			char ch = str1.charAt(i);

			if (str2.indexOf(ch) == -1) {

				str = str + ch;
			}
		}
		System.out.println(str);

	}

}
