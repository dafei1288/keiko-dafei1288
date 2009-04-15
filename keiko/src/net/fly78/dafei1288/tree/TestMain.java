/**
 * net.fly78.dafei1288.tree
 * 
 * @author dafei1288
 *
 * @version 2009/Apr 2, 2009/4:00:30 PM
 */
package net.fly78.dafei1288.tree;

import java.util.List;
import java.util.Stack;

public class TestMain {
	public static void recursiveTravel(GenericTreeNode<UserObject> node) {
		
		//recursiveTravel(node); // 访问节点，仅仅只是打印该节点罢了。
	    List<GenericTreeNode<UserObject>> children = node.getChildren();
	    //children = (List<GenericTreeNode<UserObject>>) node.getChildAt(11).getChildren();
	    for (int i = 0; i < children.size(); i++) {
	    	System.out.println(children.get(i).getUserObject().getName());
	        recursiveTravel(children.get(i)); // 递归地访问当前节点的所有子节点。
	    }
	    
	}
	
	public static void iterativeTravel(GenericTreeNode<UserObject> node) {
		Stack<GenericTreeNode<UserObject>> nodes = new Stack<GenericTreeNode<UserObject>>();
	    nodes.push(node); // 将当前节点压入栈中。
	    while (!nodes.isEmpty()) {
	        GenericTreeNode<UserObject> bufNode = nodes.pop(); // 从栈中取出一个节点。
	       // recursiveTravel(bufNode); // 访问节点。
	        System.out.println(bufNode.getUserObject().getName());
	        if (!bufNode.isLeaf()) { // 如果该节点为分枝节点，则将它的子节点全部加入栈中。
	            nodes.addAll(bufNode.getChildren());
	        }
	    }
	}
	public static void main(String[] args) {
		Long s = System.currentTimeMillis();
		TestMain.recursiveTravel(TreeUtils.buildTree());
		System.out.println("spend time : "+(System.currentTimeMillis()-s));
		System.out.println();
		
		s = System.currentTimeMillis();
		TestMain.iterativeTravel(TreeUtils.buildTree());
		System.out.println("spend time : "+(System.currentTimeMillis()-s));
	}

}
