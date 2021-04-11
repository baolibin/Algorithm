package libin.leetcode_cn_algorithm._4_tree;

/**
 * Copyright (c) 2021/4/11. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 108. 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 */
public class _0108_sortedArrayToBST {
	public TreeNode108 sortedArrayToBST(int[] nums) {
		return sortedArrayToBSTChild(nums, 0, nums.length - 1);
	}

	TreeNode108 sortedArrayToBSTChild(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}
		// 总是选择中间位置右边的数字作为根节点
		int mid = (left + right + 1) / 2;
		TreeNode108 root = new TreeNode108(nums[mid]);
		root.left = sortedArrayToBSTChild(nums, left, mid - 1);
		root.right = sortedArrayToBSTChild(nums, mid + 1, right);
		return root;
	}

}

class TreeNode108 {
	int val;
	TreeNode108 left;
	TreeNode108 right;

	TreeNode108(int x) {
		val = x;
	}
}