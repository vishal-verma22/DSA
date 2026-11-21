package Lec16_HashingDataStruture_Map_HashMap;

public class Item {
	
	private int itemId;
	private String itemName;
	private double price;
	
	Item(int itemId,String itemName,double price){
		
		this.itemId=itemId;
		this.itemName=itemName;
		this.price=price;
		
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
public String toString() {
	return "[" +itemId+" "+itemName+" "+price+"]";
	
}	

}
