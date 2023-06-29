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
	
	public Node getMaxNode(Node node) {
		if(Objects.nonNull(node)) {
			if(node.getRight() != null) {
				return getMaxNode(node.getRight());
			}
			else {
				Node parent = node.getParent();
				if(parent.getData() > node.getData()) {
					parent.setLeft(null);
				}
				else {
					parent.setRight(null);
				}
				return node;
			}
		}
		return null;
	}
	
	public String deleteNode(Node rootNode, int del) {
		
		if(Objects.nonNull(rootNode)) {
			if(Objects.nonNull(del)) {
				if(rootNode.getData() == del) {
					if(rootNode.getLeft() == null && rootNode.getRight() == null) {
						Node parent = rootNode.getParent();
						if(parent.getData() > del) {
							parent.setLeft(null);
						}
						else
							parent.setRight(null);
					}
					else if(rootNode.getLeft() != null && rootNode.getRight()==null) {
						Node parent=rootNode.getParent();
						Node leftChild = rootNode.getLeft();
						leftChild.setParent(parent);
						if(leftChild.getData() > parent.getData())
							parent.setRight(leftChild);
						else
							parent.setLeft(leftChild);
					}
					else if(rootNode.getRight() != null && rootNode.getLeft()==null) {
						Node parent=rootNode.getParent();
						Node rightChild = rootNode.getRight();
						rightChild.setParent(parent);
						if(rightChild.getData() > parent.getData())
							parent.setRight(rightChild);
						else
							parent.setLeft(rightChild);
					}
					else {
						Node maxNode=getMaxNode(rootNode.getLeft());
						rootNode.setData(maxNode.getData());
					}

					return "Node found";
				}
				else if(rootNode.getData() > del) {
					 return deleteNode(rootNode.getLeft(), del);
				}
				else if(rootNode.getData() < del) {
					 return deleteNode(rootNode.getRight(), del);
				}
				else {
					return "Node not Found";
				}
			}
			else {
				return "Empty Node cannot be deleted";
			}
		}
		
		
		
		return "";
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
		tree.addNode(tree.root, new Node(22));
		tree.addNode(tree.root, new Node(18));
		tree.addNode(tree.root, new Node(21));
		tree.addNode(tree.root, new Node(23));
		
		tree.printTree(tree.root);
		
		//tree.findNode(tree.root, 5);
		System.out.println(tree.deleteNode(tree.root, 23));
		tree.printTree(tree.root);
	}

}
