package libin.leetcode_cn_algorithm;

/**
 * Copyright (c) 2020/5/26. 小彬科技 Inc. All Rights Reserved.
 * Authors: libin <小彬科技>
 * <p>
 * Purpose :    203. 移除链表元素
 */
public class _0203_removeElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }
}
