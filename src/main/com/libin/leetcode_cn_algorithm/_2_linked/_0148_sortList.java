package libin.leetcode_cn_algorithm._2_linked;

/**
 * Copyright (c) 2021/4/11. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 进阶：
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 */
public class _0148_sortList {
	public ListNode sortList(ListNode head) {
		return quickSort(head, null);
	}

	ListNode quickSort(ListNode head, ListNode end) {
		if (head == end || head.next == null) {
			return head;
		}
		// pre最前头节点，tail最结尾节点,cur当前遍历节点
		ListNode pre = head, tail = head, cur = head.next;
		while (cur != end) {
			ListNode next = cur.next;
			if (cur.val < head.val) { // 头插
				cur.next = pre;
				pre = cur;
			} else { // 尾插
				tail.next = cur;
				tail = cur;
			}
			cur = next;
		}
		tail.next = end;
		ListNode res = quickSort(pre, head);
		head.next = quickSort(head.next, end);
		return res;
	}
}
