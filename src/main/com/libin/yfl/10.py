'''
203. 移除链表元素
删除链表中等于给定值 val 的所有节点。
示例:
输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        cur_1 = ListNode(0)
        cur = cur_1
        while head:
            if head.val == val:
                head = head.next
            else:
                cur.next = ListNode(head.val)
                cur = cur.next
                head = head.next
        return cur_1.next