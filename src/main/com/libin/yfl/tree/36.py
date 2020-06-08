# coding:utf-8
'''
590. N叉树的后序遍历
给定一个 N 叉树，返回其节点值的后序遍历。

例如，给定一个 3叉树 :


返回其后序遍历: [5,6,3,2,4,1].


'''


# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        if not root:
            return None
        stack = [root]
        res = []
        while stack:
            linshi_node = stack.pop()
            res.append(linshi_node.val)
            children = linshi_node.children
            for child in children:
                if child:
                    stack.append(child)
        res.reverse()
        return res


'''
递归 的实现
class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        result = []

        def postHelper(root):
            if not root:
                return None
            children = root.children
            for child in children:
                postHelper(child)
            result.append(root.val)

        postHelper(root)
        return result

'''