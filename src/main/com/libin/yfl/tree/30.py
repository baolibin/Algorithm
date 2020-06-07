#coding:utf-8
'''
637. 二叉树的层平均值
给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.

示例 1:

输入:
    3
   / \
  9  20
    /  \
   15   7
输出: [3, 14.5, 11]
解释:
第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
'''
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def averageOfLevels(self, root: TreeNode) -> List[float]:
        if not root:
            return []
        res = []
        stack = [root]
        while stack:
            sum_1 = 0.0
            linshi_node = []
            for node in stack:
                sum_1 += node.val
                if node.left:
                    linshi_node.append(node.left)
                if node.right:
                    linshi_node.append(node.right)
            res.append(sum_1/float(len(stack)))
            stack = linshi_node
        return res
