# coding:utf-8
'''
572. 另一个树的子树
给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

示例 1:
给定的树 s:

     3
    / \
   4   5
  / \
 1   2
给定的树 t：

   4
  / \
 1   2
返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。

示例 2:
给定的树 s：

     3
    / \
   4   5
  / \
 1   2
    /
   0
给定的树 t：

   4
  / \
 1   2
返回 false。
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, s: TreeNode, t: TreeNode) -> bool:
        s_1 = "".join(self.postorder(s))
        t_1 = "".join(self.postorder(t))
        print(s_1)
        print(t_1)
        if t_1.find(s_1) != -1:
            return True
        else:
            return False
    def postorder(self, root, ans=[]):
        if root.left and root.left !='null':
            self.postorder(root.left, ans)
        if root.right and root.right !='null':
            self.postorder(root.right, ans)
        ans.append(str(root.val))
        return ans

# 别人的解法
class Solution:
    def isSubtree(self, s: TreeNode, t: TreeNode) -> bool:
        return str(s).find(str(t)) != -1