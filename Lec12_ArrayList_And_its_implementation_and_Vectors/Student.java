package Lec12_ArrayList_And_its_implementation_and_Vectors;

public class Student {
	
	int rollno;
	String name;
	Student(int rollno,String name){
		
		 this.rollno=rollno;
		 this.name=name;
		
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + "]";
	}
	
	

}
