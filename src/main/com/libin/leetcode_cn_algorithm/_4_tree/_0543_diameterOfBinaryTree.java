package libin.leetcode_cn_algorithm._4_tree;

/**
 * Copyright (c) 2021/4/18. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class _0543_diameterOfBinaryTree {
	int res = 1;

	/**
	 * 时间复杂度：O(N)，其中 NN 为二叉树的节点数，即遍历一棵二叉树的时间复杂度，每个结点只被访问一次。
	 * 空间复杂度：O(Height)，其中 Height 为二叉树的高度。由于递归函数在递归过程中需要为每一层递归函数分配栈空间，
	 * 所以这里需要额外的空间且该空间取决于递归的深度，而递归的深度显然为二叉树的高度，并且每次递归调用的函数里又只用了常数个变量，
	 * 所以所需空间复杂度为O(Height) 。
	 */
	public int diameterOfBinaryTree(TreeNode root) {
		depth(root);
		return res - 1;
	}

	int depth(TreeNode node) {
		if (node == null) {
			return 0; // 访问到空节点了，返回0
		}
		int left = depth(node.left); // 左儿子为根的子树的深度
		int right = depth(node.right);// 右儿子为根的子树的深度
		res = Math.max(res, left + right + 1); // 计算d_node即L+R+1 并更新res
		return Math.max(left, right) + 1;// 返回该节点为根的子树的深度
	}
}
