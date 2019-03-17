package libin.leetcode;

/**
 * Copyright (c) 2019/03/13. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 本题来自654的扩展
 * 一棵树，其中每个结点的值都大于其子树中的其它任何值。
 * 给定一棵树和一个结点，讲结点按中序遍历追加插入到数组中之后，再按照654的定义建造最大二叉树。
 */
public class _998_Maximum_Binary_Tree_II {
    int[] num = new int[100];
    int index = 0;

    public TreeNode_998 insertIntoMaxTree(TreeNode_998 root, int val) {
        inOrder(root);
        System.out.println(index);
        for(int i=0;i<index;i++)
            System.out.println(num[i]);
        num[index] = val;
        return Construct(num, 0, index);
    }

    TreeNode_998 Construct(int[] nums, int left, int right) {
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
        TreeNode_998 treeNode998 = new TreeNode_998(maxNum);
        treeNode998.left = Construct(nums, left, maxIndex - 1);
        treeNode998.right = Construct(nums, maxIndex + 1, right);
        return treeNode998;
    }

    void inOrder(TreeNode_998 root) {
        if (root == null)
            return;
        inOrder(root.left);
        num[index++] = root.val;
        inOrder(root.right);
    }

}

class TreeNode_998 {
    int val;
    TreeNode_998 left;
    TreeNode_998 right;

    TreeNode_998(int x) {
        val = x;
    }
}
