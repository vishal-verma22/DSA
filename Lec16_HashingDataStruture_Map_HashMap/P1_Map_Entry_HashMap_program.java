
package Lec16_HashingDataStruture_Map_HashMap;

/*
Problem Statement:

    => Create a HashMap that stores student roll numbers as keys
       and student names as values.

    => Insert these records:

       Roll Number       Name
          101           Vishal
          102           Rahul
          103           Amit
          104           Akash
          102           Anil       // Check the result

*/

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class P1_Map_Entry_HashMap_program {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();

        // Inserting key-value pairs
        map.put(101, "Vishal");
        map.put(102, "Rahul");
        map.put(103, "Amit");
        map.put(104, "Akash");

        // Inserting duplicate key
        map.put(102, "Anil");

        // Displaying complete HashMap
        System.out.println(map);

        // Printing using entrySet()
        System.out.println(map.entrySet());

        // Checking whether key 103 exists
        System.out.println(map.containsKey(103));

        // Removing entry using key
        System.out.println(map.remove(101));

        // Displaying size of map
        System.out.println("Size of map: " + map.size());

        //==============================================
        // Way 1: Traversing the map using entrySet()
        // Recommended way to display key-value pairs
        //==============================================

        System.out.println("Way 1 to display");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {

            System.out.println("Rollno: " + entry.getKey()
                    + "  Name: " + entry.getValue());
        }

        //==============================================
        // Way 2: Store entrySet() in Set and traverse
        //==============================================

        System.out.println("Way 2 to display");

        Set<Map.Entry<Integer, String>> set = map.entrySet();

        for (Map.Entry<Integer, String> entry : set) {

            System.out.println("Rollno: " + entry.getKey()
                    + "  Name: " + entry.getValue());
        }

        //===========================================
        // Way 3: Traversing using keySet()
        //===========================================

        System.out.println("Way 3 to display");

        for (Integer i : map.keySet()) {

            System.out.println("Rollno: " + i
                    + "  Name: " + map.get(i));
        }
    }
}
