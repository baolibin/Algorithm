'''
21. 合并两个有序链表
将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
示例：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
22
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        result_node = ListNode(0)
        node = result_node
        head1 = l1
        head2 = l2
        while (head1 and head2):
            if head1.val < head2.val:
                node.next = head1
                head1 = head1.next
                node = node.next
            else:
                node.next = head2
                head2 = head2.next
                node = node.next
        while head1:
            node.next = head1
            head1 = head1.next
            node = node.next
        while head2:
            node.next = head2
            head2 = head2.next
            node = node.next
        return result_node.next

