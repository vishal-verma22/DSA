// wap to count the number of words in a given string
/*
 * Example:
 *    sentence="i love my dadi"
 *    no of word in above sentence is 3
 *
 *    sentence="hey how are you my boy"
 *    no of word in above sentence is 6

 */
public class P3_CountNumberOfwordsInGivenString {

	public static void main(String[] args) {

		String sentence = "i love my dadi";
		String[] arr = sentence.split(" ");
		System.out.println("No of words in a given String ==>" + arr.length);

	}

}
