package net.fly78.dafei1288.util.math.algorithm.tree;

class Node {
	int iData; // data used as key value
	double dData; // other data
	Node leftChild; // this Node's left child
	Node rightChild; // this Node's right child
	boolean isRoot = false;
	public void displayNode() {
		// (see Listing 8.1 for method body)
		System.out.print("{" + iData + ", " + dData + " "+(isRoot?" root ":" node ")+" } ");
	}
}
