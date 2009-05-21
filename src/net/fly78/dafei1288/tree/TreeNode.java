/**
 * net.fly78.dafei1288.tree
 * 
 * @author dafei1288
 *
 * @version 2009/Apr 2, 2009/3:52:20 PM
 */
package net.fly78.dafei1288.tree;

import java.util.List;

/**
 * 树节点的定义。
 */
public interface TreeNode {

    /**
     * 获取指定下标处的子节点。
     * 
     * @param index
     *            下标。
     * @return 子节点。
     */
    public TreeNode getChildAt(int index);

    /**
     * 返回指定子节点的下标。
     * 
     * @param index
     *            下标。
     * @return 子节点。
     */
    public int getChildIndex(TreeNode index);

    /**
     * 获取子节点的数量。
     * 
     * @return 子节点的数量。
     */
    public int getChildCount();

    /**
     * 返回父节点。
     * 
     * @return 父节点。
     */
    public TreeNode getParent();

    /**
     * 设置父节点。注：此处不需要改变父节点中的子节点元素。
     * 
     * @param parent
     *            父节点。
     */
    public void setParent(TreeNode parent);

    /**
     * 获取所有的子节点。
     * 
     * @return 子节点的集合。
     */
    public List<?> getChildren();

    /**
     * 是否为叶节点。
     * 
     * @return 是叶节点，返回true；否则，返回false。
     */
    public boolean isLeaf();
}
