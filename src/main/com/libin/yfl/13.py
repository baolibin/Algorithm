'''
2. 两数相加
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
示例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
            list1 = []
            list2 = []
            l1_ = l1
            l2_ = l2
            while l1_:
                list1.append(l1_.val)
                l1_ = l1_.next
            while l2_:
                list2.append(l2_.val)
                l2_ = l2_.next
            int1 = 0
            for i in range(len(list1)-1,-1,-1):
                int1 += list1[i] *10**i
            int2 = 0
            for i in range(len(list2)-1,-1,-1):
                int2 += list2[i] *10**i
            c = int1 + int2
            c_list = list(str(c))
            cur_ = ListNode(0)
            cur = cur_
            for i in range(len(c_list) - 1, -1, -1):
                linshi = ListNode(0)
                linshi.val = int(c_list[i])
                cur.next = linshi
                cur = cur.next

            return cur_.next