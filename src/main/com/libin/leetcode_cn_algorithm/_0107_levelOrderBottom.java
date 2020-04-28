package libin.leetcode_cn_algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Copyright (c) 2020/4/28. 小彬科技 Inc. All Rights Reserved.
 * Authors: libin <小彬科技>
 * <p>
 * Purpose : 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class _0107_levelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<LinkedList<Integer>> outList = new LinkedList<LinkedList<Integer>>();
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            LinkedList inList = new LinkedList<Integer>();
            while (len-- > 0) {
                TreeNode top = queue.poll();
                if (top.left != null) queue.add(top.left);
                if (top.right != null) queue.add(top.right);
                inList.add(top.val);
            }
            outList.addFirst(inList);
        }
        for (List<Integer> li : outList) {
            res.add(li);
        }
        return res;
    }
}
