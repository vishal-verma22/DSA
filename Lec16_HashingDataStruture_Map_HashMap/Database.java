package Lec16_HashingDataStruture_Map_HashMap;

import java.util.HashMap;
import java.util.Map;

public class Database {
	
	Map<Integer,Item> getItem(){
		
		Item item=new Item(1,"Laptop",200);
		Item item1=new Item(2,"mouse",400);
		Item item2=new Item(3,"keyboard",300);
		Item item3=new Item(4,"pendrive",700);
		Item item4=new Item(5,"harddisk",1400);

	
	
	Map<Integer,Item> map=new HashMap<>();
	map.put(1,item);
	map.put(2,item1);
	map.put(3,item2);
	map.put(4,item3);
	map.put(5,item4);
	
	return map;

	
	}
}
