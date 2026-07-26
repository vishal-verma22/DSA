// wap to print the Duplicate character from given string
// This logic work when we have single -single Duplicate character occurrence 
// if we have multiple duplicate character occurrence then it will print same duplicate multiple time

public class P5_PrintDuplicateCharacterFromString {

	public static void main(String[] args) {
		String orginal = "vishal veirmai";
		int n=orginal.length();
		
		System.out.println(n);
		
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				
				if(orginal.charAt(i)==orginal.charAt(j)) {
					
					System.out.println("Duplicate Character "+orginal.charAt(i));
					break;
				}
				
			}
		}

	}

}
