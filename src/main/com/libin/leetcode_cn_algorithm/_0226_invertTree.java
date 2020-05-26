package libin.leetcode_cn_algorithm;

/**
 * Copyright (c) 2020/5/25. 小彬科技 Inc. All Rights Reserved.
 * Authors: libin <小彬科技>
 * <p>
 * Purpose : 226. 翻转二叉树
 */
public class _0226_invertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        reversal(root);
        return root;
    }

    public void reversal(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        reversal(root.left);
        reversal(root.right);
    }
}
