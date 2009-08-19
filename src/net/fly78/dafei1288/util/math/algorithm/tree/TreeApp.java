package net.fly78.dafei1288.util.math.algorithm.tree;

public class TreeApp {
	public static void main(String[] args) {
		Tree theTree = new Tree(); // make a tree
		theTree.insert(50, 1.5); // insert 3 Nodes
		theTree.insert(25, 1.7);
		theTree.insert(75, 1.9);
		theTree.insert(45, 1.4);
		theTree.insert(78, 1.3);
		theTree.insert(255, 1.2);
		theTree.insert(735, 1.1);
		
		Node found = theTree.find(25); // find Node with key 25
		if (found != null)
			System.out.println("Found the Node with key 25");
		else
			System.out.println("Could not find node with key 25");
		// theTree.minimum().displayNode();
		theTree.printTree();
		System.out.println("删除后...");
		theTree.delete(25);
		theTree.printTree();
	} // end main()
} // end class TreeApp

