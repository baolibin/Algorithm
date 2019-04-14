package libin.leetcode;

/**
 * Copyright (c) 2019/04/02. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 经过一定次数的翻转操作后，能使X变成Y，则X翻转等价于二叉树Y
 */
public class _951 {
    // lalala
    public boolean flipEquiv(TreeNode_951 root1, TreeNode_951 root2) {
        if (root1 == null || root2 == null)
            return root1 == root2;
        if (root1.val != root2.val)
            return false;
        // 分别比较左左和右右，左右和右左
        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)
                || flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
    }
}
class TreeNode_951 {
    int val;
    TreeNode_951 left;
    TreeNode_951 right;

    TreeNode_951(int x) {
        val = x;
    }
}
