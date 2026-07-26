// wap to remove all duplicate character from given string

public class P6_RemoveDuplicateCharacterFromString {

	public static void main(String[] args) {

		String orginal = "vishal veirmai";
		int n = orginal.length();
		String newString="";
		System.out.println(n);

		for (int i = 0; i < n; i++) {
			
			char ch =orginal.charAt(i);
			if(newString.indexOf(ch)==-1) {
				
				newString=newString+orginal.charAt(i);
			}
		}
		System.out.println(newString);

	}

}
