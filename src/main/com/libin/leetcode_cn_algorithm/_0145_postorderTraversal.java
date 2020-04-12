package libin.leetcode_cn_algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Copyright (c) 2020/4/12. libin Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class _0145_postorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        if(root==null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.addFirst(cur.val);  // 第一次遍历的作为last
            if(cur.left!=null){
                stack.push(cur.left);
            }
            if(cur.right!=null){
                stack.push(cur.right);
            }
        }
        return res;
    }
}

