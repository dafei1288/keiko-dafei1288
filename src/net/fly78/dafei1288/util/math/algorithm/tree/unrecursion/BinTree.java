package net.fly78.dafei1288.util.math.algorithm.tree.unrecursion;

import java.util.Stack;

/** 二叉树遍历 */
public class BinTree {
	protected BTNode root;

	public BinTree(BTNode root) {
		this.root = root;
	}

	public BTNode getRoot() {
		return root;
	}

	/** 构造树 */
	public static BTNode init() {
		BTNode a = new BTNode('A');
		BTNode b = new BTNode('B', null, a);
		BTNode c = new BTNode('C');
		BTNode d = new BTNode('D', b, c);
		BTNode e = new BTNode('E');
		BTNode f = new BTNode('F', e, null);
		BTNode g = new BTNode('G', null, f);
		BTNode h = new BTNode('H', d, g);
		return h;// root
	}

	/** 访问节点 */
	public static void visit(BTNode p) {
		System.out.print(p.getKey() + " ");
	}

	/** 递归实现前序遍历 */
	protected static void preorder(BTNode p) {
		if (p != null) {
			visit(p);
			preorder(p.getLeft());
			preorder(p.getRight());
		}
	}

	/** 递归实现中序遍历 */
	protected static void inorder(BTNode p) {
		if (p != null) {
			inorder(p.getLeft());
			visit(p);
			inorder(p.getRight());
		}
	}

	/** 递归实现后序遍历 */
	protected static void postorder(BTNode p) {
		if (p != null) {
			postorder(p.getLeft());
			postorder(p.getRight());
			visit(p);
		}
	}

	/** 非递归实现前序遍历 */
	protected static void iterativePreorder(BTNode p) {
		Stack<BTNode> stack = new Stack<BTNode>();
		if (p != null) {
			stack.push(p);
			while (!stack.empty()) {
				p = stack.pop();
				visit(p);
				if (p.getRight() != null)
					stack.push(p.getRight());
				if (p.getLeft() != null)
					stack.push(p.getLeft());
			}
		}
	}

	/** 非递归实现后序遍历 */
	protected static void iterativePostorder(BTNode p) {
		BTNode q = p;
		Stack<BTNode> stack = new Stack<BTNode>();
		while (p != null) {
			// 左子树入栈
			for (; p.getLeft() != null; p = p.getLeft())
				stack.push(p);
			// 当前节点无右子或右子已经输出
			while (p != null && (p.getRight() == null || p.getRight() == q)) {
				visit(p);
				q = p;// 记录上一个已输出节点
				if (stack.empty())
					return;
				p = stack.pop();
			}
			// 处理右子
			stack.push(p);
			p = p.getRight();
		}
	}

	/** 非递归实现中序遍历 */
	protected static void iterativeInorder(BTNode p) {
		Stack<BTNode> stack = new Stack<BTNode>();
		while (p != null) {
			while (p != null) {
				if (p.getRight() != null)
					stack.push(p.getRight());// 当前节点右子入栈
				stack.push(p);// 当前节点入栈
				p = p.getLeft();
			}
			p = stack.pop();
			while (!stack.empty() && p.getRight() == null) {
				visit(p);
				p = stack.pop();
			}
			visit(p);
			if (!stack.empty())
				p = stack.pop();
			else
				p = null;
		}
	}

	public static void main(String[] args) {
		BinTree tree = new BinTree(init());
		System.out.print(" Pre-Order:");
		preorder(tree.getRoot());
		System.out.println();
		System.out.print("  In-Order:");
		inorder(tree.getRoot());
		System.out.println();
		System.out.print("Post-Order:");
		postorder(tree.getRoot());
		System.out.println();
		System.out.print(" Pre-Order:");
		iterativePreorder(tree.getRoot());
		System.out.println();
		System.out.print("  In-Order:");
		iterativeInorder(tree.getRoot());
		System.out.println();
		System.out.print("Post-Order:");
		iterativePostorder(tree.getRoot());
		System.out.println();
	}
}
