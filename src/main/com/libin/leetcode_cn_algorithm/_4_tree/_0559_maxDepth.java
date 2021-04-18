package libin.leetcode_cn_algorithm._4_tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Copyright (c) 2021/4/18. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 559. N 叉树的最大深度
 * 给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 * 示例 2：
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：5
 */
public class _0559_maxDepth {
	/**
	 * 解法一：递归
	 * 时间复杂度：每个节点遍历一次，所以时间复杂度是 O(N)，其中 N 为节点数。
	 * 空间复杂度：最坏情况下, 树完全非平衡，
	 * 例如 每个节点有且仅有一个孩子节点，递归调用会发生 N 次（等于树的深度），所以存储调用栈需要 O(N)。
	 * 但是在最好情况下（树完全平衡），树的高度为 log(N)。
	 * 所以在此情况下空间复杂度为O(log(N))。
	 */
	public int maxDepth(Node root) {
		if (root == null) {
			return 0;
		} else if (root.children.isEmpty()) {
			return 1;
		} else {
			LinkedList<Integer> list = new LinkedList<>();
			for (Node item : root.children) {
				list.add(maxDepth(item));
			}
			return Collections.max(list) + 1;
		}
	}
}

class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
};
