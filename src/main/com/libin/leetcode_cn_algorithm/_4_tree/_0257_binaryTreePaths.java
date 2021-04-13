package libin.leetcode_cn_algorithm._4_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Copyright (c) 2021/4/13. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 输入:
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class _0257_binaryTreePaths {
	/**
	 * 深度优先搜索： DFS
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		ArrayList<String> list = new ArrayList<>();
		constructPaths(root, "", list);
		return list;
	}

	void constructPaths(TreeNode root, String path, ArrayList<String> list) {
		if (root != null) {
			StringBuilder sb = new StringBuilder(path);
			sb.append(Integer.toString(root.val));
			// 如果是叶子节点，则加到结果中
			if (root.left == null && root.right == null) {
				list.add(sb.toString());
			}
			sb.append("->");
			constructPaths(root.left, sb.toString(), list);
			constructPaths(root.right, sb.toString(), list);
		}
	}

	/**
	 * 广度优先搜索： BFS
	 */
	public List<String> binaryTreePathsBFS(TreeNode root) {
		ArrayList<String> list = new ArrayList<>();
		if (root == null) return list;
		LinkedList<TreeNode> treeNodesList = new LinkedList<>();
		LinkedList<String> pathsList = new LinkedList<>();
		treeNodesList.add(root);
		pathsList.add(Integer.toString(root.val));
		while (!treeNodesList.isEmpty()) {
			TreeNode curNode = treeNodesList.poll();
			String curPath = pathsList.poll();
			if (curNode.left == null && curNode.right == null) {
				list.add(curPath);
			} else {
				if (curNode.left != null) {
					treeNodesList.add(curNode.left);
					pathsList.add(curPath + "->" + curNode.left.val);
				}
				if (curNode.right != null) {
					treeNodesList.add(curNode.right);
					pathsList.add(curPath + "->" + curNode.right.val);
				}
			}
		}
		return list;
	}
}
