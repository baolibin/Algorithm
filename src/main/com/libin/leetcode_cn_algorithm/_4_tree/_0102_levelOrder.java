package libin.leetcode_cn_algorithm._4_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Copyright (c) 2020/5/17. 小彬科技 Inc. All Rights Reserved.
 * Authors: libin <小彬科技>
 * <p>
 * Purpose :    102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class _0102_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null) return res;
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()){
            int len = treeNodes.size();
            ArrayList<Integer> cur = new ArrayList<>();
            while(len-->0){
                TreeNode first = treeNodes.pollFirst();
                if(first.left!=null) treeNodes.addLast(first.left);
                if(first.right!=null) treeNodes.addLast(first.right);
                cur.add(first.val);
            }
            res.add(cur);
        }
        return res;
    }
}
