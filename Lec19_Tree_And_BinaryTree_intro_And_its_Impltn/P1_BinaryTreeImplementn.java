package Lec19_Tree_And_BinaryTree_intro_And_its_Impltn;

import java.util.LinkedList;
import java.util.Queue;

public class P1_BinaryTreeImplementn {

	class Node {

		int data;

		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	Node root;

	public void add(int element) {

		Node newNode = new Node(element);

		if (root == null) {

			root = newNode;
			return;

		}

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		while (!queue.isEmpty()) {
			Node currentElement = queue.poll();

			if (currentElement.left == null) {

				currentElement.left = newNode;
				return;
			}
			queue.add(currentElement.left);

			if (currentElement.right == null) {

				currentElement.right = newNode;
				return;
			}
			queue.add(currentElement.right);

		}

	}

}
