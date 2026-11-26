package Lec19_Tree_And_BinaryTree_intro_And_its_Impltn;

public class P1_BinaryTreeMainApp {

	public static void main(String[] args) {
		P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion binaryTree=new P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion();
		binaryTree.add(10);
		binaryTree.add(20);
		binaryTree.add(30);
		binaryTree.add(40);
		binaryTree.add(50);
		binaryTree.add(60);
		binaryTree.add(70);

		
		binaryTree.displayUsgRecursion();
		
		binaryTree.displayUsgStack();;

		
	}

}
