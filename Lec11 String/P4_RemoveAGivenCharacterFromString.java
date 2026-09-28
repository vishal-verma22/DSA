// wap to Remove a given Character from a String

public class P4_RemoveAGivenCharacterFromString {

	public static void main(String[] args) {

		String orginal = "vishal verma";
		char removeCharacter='a';
		int n = orginal.length() - 1;
		String newString = "";

		for(int i=0;i<n;i++) {


			if(orginal.charAt(i)!=removeCharacter) {
				newString=newString+orginal.charAt(i);

			}

		}

		System.out.println("New String -->"+newString);

	}

}
