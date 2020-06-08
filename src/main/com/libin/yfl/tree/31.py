# coding:utf-8
'''
107. 二叉树的层次遍历 II
给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层次遍历为：

[
  [15,7],
  [9,20],
  [3]
]

'''


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        res = []
        stack = [root]
        while stack:
            linshi = []
            linshi_node = []
            for node in stack:
                linshi.append(node.val)
                if node.left:
                    linshi_node.append(node.left)
                if node.right:
                    linshi_node.append(node.right)
            res.append(linshi)
            stack = linshi_node
        res_1 = []
        for i in range(len(res)):
            res_1.append(res[-(i + 1)])
        return res_1