# coding:utf-8
'''
429. N叉树的层序遍历
给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
例如，给定一个 3叉树 :
返回其层序遍历:

[
     [1],
     [3,2,4],
     [5,6]
]
'''
"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""


class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root:
            return []
        res = []
        stack = [root]
        while stack:
            linshi = []
            linshi_node = []
            for node in stack:
                linshi.append(node.val)
                if node.children:
                    for child in node.children:
                        linshi_node.append(child)
            stack = linshi_node
            res.append(linshi)
        return res
