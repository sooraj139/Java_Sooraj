package com.two95.sooraj.BinarySearchTree;

public class BST {
	public static Node root;
	//BST
	public void insert(int data) {

		if (root == null) {
			root = new Node(data);
			return;
		} else

			insertHelper(root, data);

	}

	public void insertHelper(Node root, int data) {
		Node current = root;
		if (current.data > data) {
			if (current.right == null) {
				current.right = new Node(data);

			} else {
				insertHelper(current.right, data);
			}
		}
		if (current.data < data) {
			if (current.left == null) {
				current.left = new Node(data);
			} else {
				insertHelper(current.left, data);
			}
		}

	}

	public void display(Node root) {
		if (root != null) {
			display(root.left);
			System.out.println("" + root.data);
			display(root.right);
		}

	}

	

}
