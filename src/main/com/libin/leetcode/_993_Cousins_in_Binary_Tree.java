package libin.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Copyright (c) 2019/03/13. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 求堂兄弟节点,两个节点深度一样,且父节点不一样
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

    private int xLevel = 0;
    private int yLevel = 0;
    private TreeNode_993 xParent = null;
    private TreeNode_993 yParent = null;

    public boolean isCousins(TreeNode_993 root, int x, int y) {
        searchCousins(root, x, y, 0, null);
        return xLevel == yLevel && xParent != yParent;
    }

    private void searchCousins(TreeNode_993 root, int x, int y, int level, TreeNode_993 parent) {
        if (root == null) return;
        if (root.val == x) {
            xLevel = level;
            xParent = parent;
        }
        if (root.val == y) {
            yLevel = level;
            yParent = parent;
        }
        searchCousins(root.left, x, y, level + 1, root);
        searchCousins(root.right, x, y, level + 1, root);
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