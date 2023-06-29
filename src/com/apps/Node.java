package com.apps;

import java.util.Objects;

public class Node {

	private int data;
	private Node parent;
	private Node left;
	private Node right;
	

	public Node() {

	}
	
	public Node(int data) {
		this.data = data;
	}


	public int getData() {
		return data;
	}


	public void setData(int data) {
		this.data = data;
	}


	public Node getParent() {
		return parent;
	}


	public void setParent(Node parent) {
		this.parent = parent;
	}


	public Node getLeft() {
		return left;
	}


	public void setLeft(Node left) {
		this.left = left;
		if(Objects.nonNull(this.left))
			this.left.setParent(this);
	}


	public Node getRight() {
		return right;
	}


	public void setRight(Node right) {
		this.right = right;
		if(Objects.nonNull(this.right))
			this.right.setParent(this);
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

}
