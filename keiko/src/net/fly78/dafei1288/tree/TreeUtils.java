/**
 * net.fly78.dafei1288.tree
 * 
 * @author dafei1288
 *
 * @version 2009/Apr 2, 2009/3:59:59 PM
 */
package net.fly78.dafei1288.tree;

public class TreeUtils {
	 public static GenericTreeNode<UserObject> buildTree() {
	        GenericTreeNode<UserObject> root = new GenericTreeNode<UserObject>();
	        root.setUserObject(new UserObject("ROOT", Integer.valueOf(0)));

	        GenericTreeNode<UserObject> node1 = new GenericTreeNode<UserObject>();
	        node1.setUserObject(new UserObject("1", Integer.valueOf(0)));
	        GenericTreeNode<UserObject> node2 = new GenericTreeNode<UserObject>();
	        node2.setUserObject(new UserObject("2", Integer.valueOf(0)));
	        GenericTreeNode<UserObject> node3 = new GenericTreeNode<UserObject>();
	        node3.setUserObject(new UserObject("3", Integer.valueOf(5)));

	        root.addChild(node1);
	        root.addChild(node2);
	        root.addChild(node3);

	        GenericTreeNode<UserObject> node11 = new GenericTreeNode<UserObject>();
	        node11.setUserObject(new UserObject("11", Integer.valueOf(0)));
	        GenericTreeNode<UserObject> node21 = new GenericTreeNode<UserObject>();
	        node21.setUserObject(new UserObject("21", Integer.valueOf(0)));

	        node1.addChild(node11);
	        node2.addChild(node21);

	        GenericTreeNode<UserObject> node111 = new GenericTreeNode<UserObject>();
	        node111.setUserObject(new UserObject("111", Integer.valueOf(3)));
	        GenericTreeNode<UserObject> node112 = new GenericTreeNode<UserObject>();
	        node112.setUserObject(new UserObject("112", Integer.valueOf(9)));
	        GenericTreeNode<UserObject> node211 = new GenericTreeNode<UserObject>();
	        node211.setUserObject(new UserObject("211", Integer.valueOf(6)));
	        GenericTreeNode<UserObject> node212 = new GenericTreeNode<UserObject>();
	        node212.setUserObject(new UserObject("212", Integer.valueOf(3)));

	        node11.addChild(node111);
	        node11.addChild(node112);
	        node21.addChild(node211);
	        node21.addChild(node212);

	        return root;
	    }

}
