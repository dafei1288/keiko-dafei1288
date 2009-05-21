/**
 * net.fly78.dafei1288.tree
 * 
 * @author dafei1288
 *
 * @version 2009/Apr 2, 2009/3:53:06 PM
 */
package net.fly78.dafei1288.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericTreeNode<T> implements TreeNode {
	private T userObject = null;

    private TreeNode parent = null;

    private List<GenericTreeNode<T>> children = new ArrayList<GenericTreeNode<T>>();

    public GenericTreeNode(T userObject) {
        this.userObject = userObject;
    }

    public GenericTreeNode() {
        this(null);
    }

    /**
     * 添加子节点。
     * 
     * @param child
     */
    public void addChild(GenericTreeNode<T> child) {
        children.add(child);
        child.setParent(this);
    }

    /**
     * 删除指定的子节点。
     * 
     * @param child
     *            子节点。
     */
    public void removeChild(TreeNode child) {
        removeChildAt(getChildIndex(child));
    }

    /**
     * 删除指定下标处的子节点。
     * 
     * @param index
     *            下标。
     */
    public void removeChildAt(int index) {
        TreeNode child = getChildAt(index);
        children.remove(index);
        child.setParent(null);
    }

    public TreeNode getChildAt(int index) {
        return children.get(index);
    }

    public int getChildCount() {
        return children.size();
    }

    public int getChildIndex(TreeNode child) {
        return children.indexOf(child);
    }

    public List<GenericTreeNode<T>> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getParent() {
        return parent;
    }

    /**
     * 是否为根节点。
     * 
     * @return 是根节点，返回true；否则，返回false。
     */
    public boolean isRoot() {
        return getParent() == null;
    }

    public boolean isLeaf() {
        return getChildCount() == 0;
    }

    /**
     * 判断指定的节点是否为当前节点的子节点。
     * 
     * @param node
     *            节点。
     * @return 是当前节点的子节点，返回true；否则，返回false。
     */
    public boolean isChild(TreeNode node) {
        boolean result;
        if (node == null) {
            result = false;
        } else {
            if (getChildCount() == 0) {
                result = false;
            } else {
                result = (node.getParent() == this);
            }
        }

        return result;
    }

    public T getUserObject() {
        return userObject;
    }

    public void setUserObject(T userObject) {
        this.userObject = userObject;
    }

    @Override
    public String toString() {
        return userObject == null ? "" : userObject.toString();
    }



}
