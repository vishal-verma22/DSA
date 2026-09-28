// Wap to find the minimum and maximum occuring  character
public class P10_findMinMaxOccuringCharacter {

	public static void main(String[] args) {

		String str1 = "vishal is good booy";
		int n = str1.length();
		int minFrequencyCharacter = Integer.MAX_VALUE;
		int maxFrequencyCharacter = Integer.MIN_VALUE;
		
		char minCharacter = ' ';
		char maxCharacter = ' ';

		for (int i = 0; i < n; i++) {
			int count = 0;
			boolean isFound = false;

			for (int k = i - 1; k >= 0; k--) {
				if (str1.charAt(i) == str1.charAt(k)) {
					isFound = true;
				}

			}
			if(str1.charAt(i)==' ') {
				continue;
			}
			if(isFound!=true) {
			for (int j = 0; j < n; j++) {
				char ch = str1.charAt(i);

				if (ch == str1.charAt(j)) {
					count++;
					
					
				}
            
              
			}

			 if(maxFrequencyCharacter<count) {
	     	     maxFrequencyCharacter=count;
	     	    maxCharacter=str1.charAt(i);
	     	  
	     	  
	       }
	    
	       
	       if(minFrequencyCharacter>count) {
	  	     minFrequencyCharacter=count;
	     	    minCharacter=str1.charAt(i);

	  	  
	  	  
	    }
			System.out.println(str1.charAt(i) + "==>" + count);

			}

		}
		

		System.out.println("Maximum occurring character: "+maxCharacter+" ==> "+maxFrequencyCharacter);
		System.out.println("Minimum occurring character: "+ minCharacter+" ==> "+minFrequencyCharacter);


	}

}
