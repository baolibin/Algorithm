package libin.leetcode_cn_algorithm._4_tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Copyright (c) 2020/4/12. libin Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class _0094_inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;   // 不要进行null判断，直接赋值，避免上面第二个while进入死循环
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
