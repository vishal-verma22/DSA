package Lec12_ArrayList_And_its_implementation_and_Vectors;

import java.util.ArrayList;

public class MyOwnGenericArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GenericArrayListImplementation<Integer> arr = new GenericArrayListImplementation<>();
		arr.add(5);
		arr.add(1, 6);
		arr.add(88);
		arr.add(88);
		arr.add(3, 69);
		// arr.add("vishal");
		System.out.println("ArrayList Size=> " + arr.getSize());
		System.out.println("ArrayList Capacity " + arr.getCapacity());
		arr.display();
		System.out.println("\n Get ==>" + arr.get(3));

		GenericArrayListImplementation<String> arr1 = new GenericArrayListImplementation<>();
		arr1.add("Vishal");
		arr1.add(1, "Satvik");
		arr1.add("Rahul");
		arr1.add("Rahul");
		arr1.add(3, "Aman");
		arr1.display();
		System.out.println(arr1);

		GenericArrayListImplementation<Student> arr2 = new GenericArrayListImplementation<>();

		arr2.add(new Student(11, "jony"));
		arr2.add(new Student(12, "rony"));
		arr2.display();
		//System.out.println(arr2);

	}

}
