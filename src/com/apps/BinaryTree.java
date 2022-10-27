package com.apps;

import java.util.Objects;

public class BinaryTree {
	
	public Node root = new Node(10);

	public void addNode(Node rootNode, Node newNode) {
		if (rootNode != null) {
			if (newNode.getData() > rootNode.getData()) {
				if (rootNode.getRight() != null)
					addNode(rootNode.getRight(), newNode);
				else
					rootNode.setRight(newNode);
			} else if (newNode.getData() < rootNode.getData()) {
				if (rootNode.getLeft() != null)
					addNode(rootNode.getLeft(), newNode);
				else
					rootNode.setLeft(newNode);
			}
		} else {
			rootNode = newNode;
		}
	}

	public void printTree(Node rootNode) {
		System.out.print(rootNode.getData()+"\t");
		if (Objects.nonNull(rootNode)) {
			if (Objects.nonNull(rootNode.getLeft()))
				printTree(rootNode.getLeft());
			if (Objects.nonNull(rootNode.getRight()))
				printTree(rootNode.getRight());
		}

	}
	
	private void findNode(Node root,int data) {
		
		if(Objects.nonNull(root)) {
			if(root.getData() == data)
				System.out.println("\nFound it");
			else if(data > root.getData())
				findNode(root.getRight(), data);
			else 
				findNode(root.getLeft(),data);
		}
		else
			System.out.println("\nSorry \t"+ data +"\tnot found");
		
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.addNode(tree.root, new Node(20));
		tree.addNode(tree.root, new Node(5));
		tree.addNode(tree.root, new Node(21));
		tree.addNode(tree.root, new Node(18));
		tree.printTree(tree.root);
		
		tree.findNode(tree.root, 100);
	}

}
