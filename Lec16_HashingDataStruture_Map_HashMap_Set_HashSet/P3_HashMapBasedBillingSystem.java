package Lec16_HashingDataStruture_Map_HashMap_Set_HashSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class P3_HashMapBasedBillingSystem {

	public static void main(String args[]) {

		System.out.println("===Welcome to our shopping Website====");

		System.out.println("Our Product");
		Database db = new Database();

		Map<Integer, Item> mapObj = db.getItem();

		for (Map.Entry<Integer, Item> entry : mapObj.entrySet()) {
			System.out.println(entry.getValue());
		}

		Map<Item, Integer> userCart = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		String choice;

		while (true) {
			System.out.println("Enter the Product id which you want to buy ");
			int productId = Integer.parseInt(sc.next());

			if (!mapObj.containsKey(productId)) {
				System.out.println("Invalid product id");
				continue;
			}
			
			Item productName = mapObj.get(productId);

			
			int Quantity=0;
			if(userCart.containsKey(productName)) {
				
				Quantity=userCart.get(productName);
			}

			System.out.println("Enter  Quantity of prodct");
			int productQuantity = Integer.parseInt(sc.next());
			productQuantity=Quantity+productQuantity;
			userCart.put(productName, productQuantity);

			System.out.println("Do you want to continue the shopping:yes or no");
			choice = sc.next();

			if (choice.equals("no")) {

				System.out.println("Pid " + "PName " + "PPrice " + "PQuantity" +"TotalPrice");

				for (Entry<Item, Integer> purchasedItem : userCart.entrySet()) {
					double totalPrice=0.0;

					Item item =purchasedItem.getKey();
					int quanty =purchasedItem.getValue();
					double price=item.getPrice();
					totalPrice=price*quanty;

					System.out.println(purchasedItem.getKey() + " " + purchasedItem.getValue()+" "+ totalPrice);
				}

				System.out.println("Thank you for visiting");

				break;
			}
		}
		

		

	}

}
