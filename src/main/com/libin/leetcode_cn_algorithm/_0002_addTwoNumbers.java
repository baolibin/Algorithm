package libin.leetcode_cn_algorithm;

/**
 * Copyright (c) 2020/4/11. libin Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose :    2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
class _2_addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int spill = 0;
        ListNode head = l1;
        ListNode cur = l1;
        while (l1 != null || l2 != null) {  // 两个链表都不为空情况
            if (l1 != null && l2 != null) {
                int tmp = l1.val + l2.val + spill;
                l1.val = tmp % 10;
                spill = tmp / 10; // 存储进位
                cur = l1;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l2 != null) { // l1为空，l2不为空
                int tmp = l2.val + spill;
                l2.val = tmp % 10;
                spill = tmp / 10;
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            } else {     // l2为空，l1不为空
                int tmp = l1.val + spill;
                l1.val = tmp % 10;
                spill = tmp / 10;
                cur = l1;
                l1 = l1.next;
            }
        }
        if (spill > 0) {
            ListNode tail = new ListNode(spill);
            cur.next = tail;
            tail.next = null;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}