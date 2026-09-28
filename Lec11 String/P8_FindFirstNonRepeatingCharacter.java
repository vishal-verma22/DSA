// wap to find the First non repeating character


public class P8_FindFirstNonRepeatingCharacter {

	public static void main(String[] args) {

		String str1 = "vishal is good boy";
		int n = str1.length();
		int count;

		for(int i=0;i<n;i++) {
			count=0;
			char ch =str1.charAt(i);
			for(int j=0;j<n;j++) {

				if(ch==str1.charAt(j)) {
					count++;
				}
			}
			if(count==1) {

				System.out.println("first non repeating character ==>"+ch);
				break;
			}

		}

	}

}
