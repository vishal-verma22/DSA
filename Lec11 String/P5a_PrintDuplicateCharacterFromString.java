// wap to print the Duplicate character from given string

public class P5a_PrintDuplicateCharacterFromString {

	public static void main(String[] args) {
		String orginal = "vishal veirmai";
		int n=orginal.length();

		System.out.println(n);

		for(int i=0;i<n;i++) {
			boolean found=false;
			// checking previous aa chuka hai ky word
			for(int k=i-1;k>=0;k--) {
				if(orginal.charAt(i)==orginal.charAt(k)) {
					found=true;
				}

				
			}
			
			if(found!=true)
			for(int j=i+1;j<n;j++) {
				if(orginal.charAt(i)==orginal.charAt(j)) {
					
					System.out.println("Duplicate character==> "+orginal.charAt(i));
					break;
				}
				
			}
		}
			}

	}


