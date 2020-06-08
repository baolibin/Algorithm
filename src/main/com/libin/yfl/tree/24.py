'''
101. 对称二叉树
给定一个二叉树，检查它是否是镜像对称的。
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
'''


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        right = []
        left = []
        if not root:
            return True
        count_left(root.left, left)
        count_rigth(root.right, right)
        print(left)
        print(right)
        if left == right:
            return True
        else:
            return False


def count_left(t, list1):
    if t:
        list1.append(t.val)
        count_left(t.left, list1)
        count_left(t.right, list1)
    else:
        list1.append('null')


def count_rigth(t1, list2):
    if t1:
        list2.append(t1.val)
        count_rigth(t1.right, list2)
        count_rigth(t1.left, list2)

    else:
        list2.append('null')
