# coding:utf-8
'''
543. 二叉树的直径
给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。

示例 :
给定二叉树

          1
         / \
        2   3
       / \
      4   5
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。


'''


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        if not root:
            return 0
        self.result = 0

        def shendu(root):
            if not root:
                return 0
            res_left = shendu(root.left)
            res_right = shendu(root.right)
            self.result = max(self.result, res_left + res_right + 1)
            return max(res_left, res_right) + 1

        shendu(root)
        return self.result - 1
