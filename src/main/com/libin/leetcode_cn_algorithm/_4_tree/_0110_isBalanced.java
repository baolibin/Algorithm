package libin.leetcode_cn_algorithm._4_tree;

/**
 * Copyright (c) 2020/5/14. 小彬科技 Inc. All Rights Reserved.
 * Authors: libin <小彬科技>
 * <p>
 * Purpose : 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 */
public class _0110_isBalanced {
    public boolean isBalanced(TreeNode root) {
        return deepLen(root)!=-1;
    }

    int deepLen(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = deepLen(root.left);
        if(left==-1){
            return -1;
        }
        int right = deepLen(root.right);
        if(right==-1){
            return -1;
        }
        if(Math.abs(left-right)>1){
            return -1;
        }
        return left > right ?left+1 : right+1;
    }
}
