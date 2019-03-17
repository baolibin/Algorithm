package libin.leetcode;

/**
 * Copyright (c) 2019/03/17. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 给定一个无重复元素的数组，构建此数组最大二叉树的定义。
 * 二叉树的根是数组中的最大元素；
 * 左子树是通过数组中最大值左边的部分构造出的最大二叉树；
 * 右子树是通过数组中最大值右边的部分构造出的最大二叉树；
 */
public class _654_MaximumBinaryTree {
    public TreeNode_654 constructMaximumBinaryTree(int[] nums) {
        return Construct(nums, 0, nums.length - 1);
    }

    TreeNode_654 Construct(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int maxNum = nums[left];
        int maxIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                maxIndex = i;
            }
        }
        TreeNode_654 treeNode654 = new TreeNode_654(maxNum);
        treeNode654.left = Construct(nums, left, maxIndex - 1);
        treeNode654.right = Construct(nums, maxIndex + 1, right);
        return treeNode654;
    }
}

class TreeNode_654 {
    int val;
    TreeNode_654 left;
    TreeNode_654 right;

    TreeNode_654(int x) {
        val = x;
    }
}
