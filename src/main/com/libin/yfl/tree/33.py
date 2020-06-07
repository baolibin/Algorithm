# coding:utf-8
'''
面试题32 - II. 从上到下打印二叉树 II
从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。



例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
'''
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> list[list[int]]:
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
        return res