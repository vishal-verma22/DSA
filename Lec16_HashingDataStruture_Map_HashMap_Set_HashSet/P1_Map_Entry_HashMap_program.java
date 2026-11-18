package Lec16_HashingDataStruture_Map_HashMap_Set_HashSet;

/*
Problem statement:
	=>Create a HashMap that stores student roll numbers as keys and student names as values.
	
	=>Insert these records:
		Roll 	Number	Name
		101		Vishal
		102		Rahul
		103		Amit
		104		Akash
		102		anil     // check the result 


* 
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class P1_Map_Entry_HashMap_program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, String> map = new HashMap<>();

		map.put(101, "vishal");
		map.put(102, "Rahul");
		map.put(103, "Amit");
		map.put(104, "Akash");
		map.put(102, "anil");

		System.out.println(map);

		// primting using entrySet()
		System.out.println(map.entrySet());

		System.out.println(map.containsKey(103));
		System.out.println(map.remove(101));
		System.out.println("Size of map:" + map.size());

		// Traversing the map entery using entrySet()
		// -> entrySet() is main used to traverse the map entries one by one

		// Recommended way
		System.out.println(" Way 1 to display ");

		for (Map.Entry<Integer, String> entry : map.entrySet()) {

			System.out.println("Rollno:" + entry.getKey() + "  " + "Name:" + entry.getValue());
		}

		// second way to iterate
		System.out.println(" Way 2 to display");

		Set<Map.Entry<Integer, String>> set = map.entrySet();

		for (Map.Entry<Integer, String> entry : set) {

			System.out.println("Rollno:" + entry.getKey() + "  " + "Name:" + entry.getValue());
		}

		System.out.println(" Way 3 to display");

		for (Integer i : map.keySet()) {

			System.out.println("Rollno:" + i + "  " + "Name:" + map.get(i));

		}

	}
}
