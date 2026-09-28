// Hume maximum satisfied customers find karne hain.

// Bookstore owner ke paas ek technique hai,
// jise woh sirf ek baar kisi bhi 'minutes' consecutive window mein use kar sakta hai.
// Is technique se us window ke customers satisfied ho jaate hain.

// Hume calculate karna hai:
// 1. Jo customers already satisfied hain
// 2. Technique ki wajah se jo customers newly satisfied ho jayenge

// Final Answer = Already Satisfied + Newly Satisfied

public class P7_GrumpyBookStoreProblem1052LeetcodeProblemUsgFixedSixeSlidingWindow {

	public static void main(String[] args) {

		int[] customers = { 1, 0, 1, 2, 1, 1, 7, 5 };
		   int[] grumpy = { 0, 1, 0, 1, 0, 1, 0, 1 };
		int minutes = 3;

		// happy Customer → already satisfied customers

		int alreadyHappyCustomer = 0;
		for (int i = 0; i < customers.length; i++) {

			if (grumpy[i] == 0) {
				alreadyHappyCustomer = alreadyHappyCustomer + customers[i];
			}
		}
		System.out.println("Already happy Customer =>"+alreadyHappyCustomer);

		// calculating unhappy customer from first window
		int unhappyCustomer = 0;
		for (int i = 0; i < minutes; i++) {
			
			if (grumpy[i] == 1) {

			unhappyCustomer = unhappyCustomer + customers[i];
			}
		}
		System.out.println("unhappy Customer=> "+unhappyCustomer);

		// calculating remaining unhappy customer from window
		int maximumUnhappyCustomer = unhappyCustomer;

		for (int i = 1; i <= customers.length - minutes; i++) {

			if (grumpy[i - 1] == 1) {
				unhappyCustomer = unhappyCustomer - customers[i - 1];

			}
			if (grumpy[i + minutes - 1] == 1) {
				unhappyCustomer = unhappyCustomer + customers[i + minutes - 1];

			}
			maximumUnhappyCustomer = Math.max(maximumUnhappyCustomer, unhappyCustomer);


		}
		System.out.println("Maximum unsatisfied customers making happy with technique => " + maximumUnhappyCustomer);

		int answer = alreadyHappyCustomer + maximumUnhappyCustomer;

		System.out.println("Maximum satisfied customers => " + answer);
	}

}
