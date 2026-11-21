
package Lec16_HashingDataStruture_Map_HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Problem Statement:

    => Create a HashMap that stores department names as keys
       and a list of employee names as values.

    => Create the following departments:

       Department       Employees

       Developer        Vishal, Rahul, Amit, Akash
       HR                Karan, Rohan, Jay
       Testing           Anil, Mohit, Sagar
       Manager           Priya, Neha

*/

public class P2_Storing_Multiple_Values_In_HashMap_Using_ArrayList {

    public static void main(String[] args) {

        // Developer list

        ArrayList<String> developer = new ArrayList<>();

        developer.add("Vishal");
        developer.add("Rahul");
        developer.add("Amit");
        developer.add("Akash");

        System.out.println(developer);

        // HR list

        ArrayList<String> hr = new ArrayList<>();

        hr.add("Karan");
        hr.add("Rohan");
        hr.add("Jay");

        System.out.println(hr);

        // Testing list

        ArrayList<String> testing = new ArrayList<>();

        testing.add("Anil");
        testing.add("Mohit");
        testing.add("Sagar");

        System.out.println(testing);

        // Manager list

        ArrayList<String> manager = new ArrayList<>();

        manager.add("Priya");
        manager.add("Neha");

        System.out.println(manager);

        // Adding all these lists in a HashMap

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        map.put("Developer", developer);
        map.put("HR", hr);
        map.put("Testing", testing);
        map.put("Manager", manager);

        
        System.out.println();
        System.out.println();
        
        
        System.out.println(map);
        System.out.println(map.entrySet());


        //========================================
        // Traversing using entrySet()
        // Way 1: Display key and complete list
        //========================================
        System.out.println();
        System.out.println();

        System.out.println("Way 1 to display");

        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {

            System.out.println(entry.getKey() + " = " + entry.getValue());

        }

        //========================================
        // Way 2: Display key and each employee
        //========================================
        System.out.println();
        System.out.println();


        System.out.println("Way 2 to display");

        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {

            System.out.println(entry.getKey());

            ArrayList<String> elist = entry.getValue();

            for (String e : elist) {

                System.out.println(e);

            }

            System.out.println("-------------------");

        }

    }

}
