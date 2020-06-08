'''
559. N叉树的最大深度
给定一个 N 叉树，找到其最大深度。

最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。

例如，给定一个 3叉树 :







我们应返回其最大深度，3。
'''


# """
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


# """

class Solution:
    def maxDepth(self, root: 'Node') -> int:
        if root is None:
            return 0
        if root.children == []:
            return 1
        list1 = [self.maxDepth(node) for node in root.children]
        if list1:
            return max(list1) + 1
