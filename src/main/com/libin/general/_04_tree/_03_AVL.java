package libin.general._04_tree;

/**
 * Copyright (c) 2018/8/1. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 平衡二叉树(Balanced Binary Tree)
 * AVL树是带有平衡条件的二叉搜索树，对任意节点，左右子树的高度差不超过1
 */

public class _03_AVL {

}

class AVLTreeNode {
    private int data;
    private int height;
    private AVLTreeNode left;
    private AVLTreeNode right;

    public AVLTreeNode(int data) {
        this.data = data;
        this.height = 1;
        this.left = null;
        this.right = null;
    }

}
