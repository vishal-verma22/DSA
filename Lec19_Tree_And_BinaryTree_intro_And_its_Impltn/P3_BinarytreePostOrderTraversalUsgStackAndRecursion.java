package Lec19_Tree_And_BinaryTree_intro_And_its_Impltn;

import java.util.Stack;

public class P3_BinarytreePostOrderTraversalUsgStackAndRecursion {

	P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion binaryTree;

	P3_BinarytreePostOrderTraversalUsgStackAndRecursion(
			P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion binaryTree) {

		this.binaryTree = binaryTree;

	}

	// ==================================================
	// Way -1: Using Recursion
	// PREORDER: ROOT -> LEFT -> RIGHT
	// ==================================================

	public void displayUsgRecursion() {

		System.out.println("Traversing Element in PostOrder using Recursion");

		displayPreorderUsgRecursion(binaryTree.root);

		System.out.println();

	}

	public void displayPreorderUsgRecursion(
			P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion.Node currentNode) {

		// Base Condition

		if (currentNode == null) {

			return;

		}

		// First print ROOT

		// Then traverse LEFT subtree

		displayPreorderUsgRecursion(currentNode.left);

		// Finally traverse RIGHT subtree

		displayPreorderUsgRecursion(currentNode.right);
		System.out.println(currentNode.data);

	}

	// ==================================================
	// Way -2: Using Stack
	// PREORDER: ROOT -> LEFT -> RIGHT
	// ==================================================

	public void displayUsgStack() {

		System.out.println("Traversing Element in PostOrder using Stack");

		displayPreorderUsgStack(binaryTree.root);

		System.out.println();

	}

	public void displayPreorderUsgStack(
			P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion.Node currentNode) {

		// Creating Stack

		Stack<P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion.Node> stack1 = new Stack<>();
		Stack<P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion.Node> stack2 = new Stack<>();

		stack1.push(currentNode);
		// Push ROOT into Stack

		while (!stack1.isEmpty()) {

			// Remove top element from Stack

			P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion.Node currentRemovedElement = stack1.pop();

			stack2.push(currentRemovedElement);

			// First push RIGHT child

			if (currentRemovedElement.left != null) {

				stack1.push(currentRemovedElement.left);

			}

			// Then push LEFT child

			if (currentRemovedElement.right != null) {

				stack1.push(currentRemovedElement.right);

			}

		}

		while (!stack2.isEmpty()) {

			P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion.Node currentRemovedElement = stack2.pop();
			System.out.println(currentRemovedElement.data);

		}

	}

	// ==================================================
	// MAIN METHOD
	// ==================================================

	public static void main(String[] args) {

		// Creating Binary Tree using P1 class

		P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion binaryTree = new P1_BinaryTreeImplementn_And_Travsering_Inorder_usgStackRecursion();

		binaryTree.add(10);

		binaryTree.add(20);

		binaryTree.add(30);

		binaryTree.add(40);

		binaryTree.add(50);

		binaryTree.add(60);

		binaryTree.add(70);

		// Passing P1 object to P2 constructor

		P3_BinarytreePostOrderTraversalUsgStackAndRecursion preOrder = new P3_BinarytreePostOrderTraversalUsgStackAndRecursion(
				binaryTree);

		// Preorder using Recursion

		preOrder.displayUsgRecursion();

		// Preorder using Stack

		preOrder.displayUsgStack();

	}

}
