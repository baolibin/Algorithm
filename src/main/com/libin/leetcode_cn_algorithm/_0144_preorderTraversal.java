package libin.leetcode_cn_algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Copyright (c) 2020/4/12. libin Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class _0144_preorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root==null){
            return res;
        }
        while(true){
            while(root!=null){
                res.add(root.val);
                stack.push(root);
                root=root.left;
            }
            if(stack.isEmpty()){
                break;
            }
            root = stack.pop();
            root = root.right; // 直接赋值，如判断null，会引起第二个while循环死循环
        }
        return res;
    }
}
