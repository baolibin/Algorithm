'''
206. 反转链表
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
'''
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        list1 = []
        while head:
            list1.insert(0, head.val)
            head = head.next
        pre = ListNode(0)
        node_start = pre
        for i in range(len(list1)):
            node_start.val = list1[i]
            if i != len(list1)-1:
                node_start.next = ListNode(0)
            else:
                node_start.next = None

        return pre

class Solution(object):
    def reverseList(self, head):
        pre = None
        curr = head
        while curr:
            temp = curr.next
            curr.next = pre
            pre = curr
            curr = temp
        return pre
