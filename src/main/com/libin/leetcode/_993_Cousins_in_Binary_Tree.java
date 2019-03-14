package libin.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Copyright (c) 2019/03/13. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose :
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 */
public class _993_Cousins_in_Binary_Tree {
    public static void main(String[] args) {
        _993_Cousins_in_Binary_Tree cousins = new _993_Cousins_in_Binary_Tree();

        TreeNode_993 node993 = new TreeNode_993(1);
        node993.left = new TreeNode_993(2);
        node993.right = new TreeNode_993(3);
        node993.left.right = new TreeNode_993(4);
        node993.right.right = new TreeNode_993(5);
        boolean cousinsCousins = cousins.isCousins(node993, 4, 5);
        System.out.println(cousinsCousins);
    }

    public boolean isCousins(TreeNode_993 root, int x, int y) {
        Queue<TreeNode_993> queue = new LinkedList<TreeNode_993>();
        queue.add(root);


        return false;
    }
}


class TreeNode_993 {
    int val;
    TreeNode_993 left;
    TreeNode_993 right;

    TreeNode_993(int x) {
        val = x;
    }
}
