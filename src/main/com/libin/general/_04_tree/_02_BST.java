package libin.general._04_tree;

/**
 * Copyright (c) 2018/8/1. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 二叉搜索树(Binary Search Tree)
 */

public class _02_BST {

    public static void main(String[] args) {
        _02_BST bstObj = new _02_BST();
        BinarySearchTreeNode bst = bstObj.init();
        int resData = bstObj.find(bst, 7);
        System.out.println(resData);
    }

    /**
     * 初始化二叉树
     */
    private BinarySearchTreeNode init() {
        BinarySearchTreeNode root = new BinarySearchTreeNode(15);
        root.left = new BinarySearchTreeNode(11);
        root.right = new BinarySearchTreeNode(17);
        root.left.left = new BinarySearchTreeNode(9);
        root.left.right = new BinarySearchTreeNode(13);
        root.right.left = new BinarySearchTreeNode(16);
        root.right.right = new BinarySearchTreeNode(21);
        return root;
    }

    /**
     * 查找元素
     */
    private int find(BinarySearchTreeNode bst, int data) {
        if (bst == null)
            return -1;
        if (bst.data == data)
            return bst.data;
        else if (bst.data < data)
            return find(bst.right, data);
        else
            return find(bst.left, data);
    }
}

/**
 * 二叉树节点类型
 */
class BinarySearchTreeNode {
    int data;
    BinarySearchTreeNode left;
    BinarySearchTreeNode right;

    BinarySearchTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
