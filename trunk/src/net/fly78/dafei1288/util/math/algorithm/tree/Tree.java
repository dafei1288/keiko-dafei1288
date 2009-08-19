package net.fly78.dafei1288.util.math.algorithm.tree;

class Tree {
	private Node root; // the only data field in Tree

	public Node find(int key) // find Node with given key
	{ // (assumes non-empty tree)
		Node current = root; // start at root
		while (current.iData != key) // while no match,
		{
			if (key < current.iData) // go left?
				current = current.leftChild;
			else
				current = current.rightChild; // or go right?
			if (current == null) // if no child,
				return null; // didn't find it
		}
		return current; // found it
	}

	public Node minimum() // returns Node with minimum key value
	{
		Node current, last = null;
		current = root; // start at root
		while (current != null) // until the bottom,
		{
			last = current; // remember Node
			current = current.leftChild; // go to left child
		}
		return last;
	}

	public void insert(int id, double dd) {
		Node newNode = new Node(); // make new Node
		newNode.iData = id; // insert data
		newNode.dData = dd;
		if (root == null) // no Node in root
		{
			root = newNode;
			root.isRoot = true;
		}
		else // root occupied
		{
			Node current = root; // start at root
			Node parent;
			while (true) // (exits internally)
			{
				parent = current;
				if (id < current.iData) // go left?
				{
					current = current.leftChild;
					if (current == null) // if end of the line,
					{ // insert on left
						parent.leftChild = newNode;
						return;
					}
				} // end if go left
				else // or go right?
				{
					current = current.rightChild;
					if (current == null) // if end of the line
					{ // insert on right
						parent.rightChild = newNode;
						return;
					}
				} // end else go right
			} // end while
		} // end else not root
	} // end insert()

	public boolean delete(int key) // delete Node with given key
	{ // (assumes non-empty list)
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		while (current.iData != key) // search for Node
		{
			parent = current;
			if (key < current.iData) // go left?
			{
				isLeftChild = true;
				current = current.leftChild;
			} else // or go right?
			{
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null) // end of the line,
				return false; // didn't find it
		} // end while
		// found Node to delete
		// continues...

		// delete() continued...
		// if no children, simply delete it
		if (current.leftChild == null && current.rightChild == null) {
			if (current == root) // if root,
				root = null; // tree is empty
			else if (isLeftChild)
				parent.leftChild = null; // disconnect
			else
				// from parent
				parent.rightChild = null;
		}
		// continues...

		// delete() continued...
		// if no right child, replace with left subtree
		else if (current.rightChild == null)
			if (current == root)
				root = current.leftChild;
			else if (isLeftChild) // left child of parent
				parent.leftChild = current.leftChild;
			else
				// right child of parent
				parent.rightChild = current.leftChild;
		// if no left child, replace with right subtree
		else if (current.leftChild == null)
			if (current == root)
				root = current.rightChild;
			else if (isLeftChild) // left child of parent
				parent.leftChild = current.rightChild;
			else
				// right child of parent
				parent.rightChild = current.rightChild;
		// continued...

		// delete() continued
		else // two children, so replace with inorder successor
		{
			// get successor of Node to delete (current)
			Node successor = getSuccessor(current);
			// connect parent of current to successor instead
			if (current == root)
				root = successor;
			else if (isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;
			// connect successor to current's left child
			successor.leftChild = current.leftChild;
		} // end else two children
		// (successor cannot have a left child)
		return true;
	} // end delete()

	public void printTree() {
		System.out.print("前序遍历：");
		preOrder(root);
		System.out.println();
		System.out.print("中序遍历：");
		inOrder(root);
		System.out.println();
		System.out.print("后序遍历：");
		postOrder(root);
		System.out.println();
	}

	// returns Node with next-highest value after delNode
	// goes to right child, then right child's left descendants
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild; // go to right child
		while (current != null) // until no more
		{ // left children,
			successorParent = successor;
			successor = current;
			current = current.leftChild; // go to left child
		}
		// if successor not
		if (successor != delNode.rightChild) // right child,
		{ // make connections
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;// ?
		}
		return successor;
	}

	private void preOrder(Node localRoot) {
		if (localRoot != null) {
			localRoot.displayNode();
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	private void inOrder(Node localRoot) {
		if (localRoot != null) {
			inOrder(localRoot.leftChild);
			localRoot.displayNode();
			inOrder(localRoot.rightChild);
		}
	}

	private void postOrder(Node localRoot) {
		if (localRoot != null) {
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			localRoot.displayNode();
		}
	}
} // end class Tree

