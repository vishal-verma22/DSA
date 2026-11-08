package Lec12_ArrayList_And_its_implementation_and_Vectors;

public class MyOwnArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayListImplementation arr=new ArrayListImplementation();
		arr.add(5);
		arr.add(9);
		//arr.display();
		arr.add(1, 6);
		arr.add(88);
		arr.add(88);
	//	arr.set(2,33);
		arr.add(3, 69);
		System.out.println("removed Elements is "+arr.remove(3));





System.out.println("ArrayList Size=> "+arr.getSize());
System.out.println("ArrayList Capacity "+arr.getCapacity());
		arr.display();

	
	}
	

}
