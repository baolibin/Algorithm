package libin.leetcode_cn_algorithm._2_linked;

/**
 * Copyright (c) 2021/4/11. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 61. 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class _0061_rotateRight {
	public ListNode61 rotateRight(ListNode61 head, int k) {
		if (head == null || head.next == null || k == 0) {
			return head;
		}
		ListNode61 tail = head;
		int len = 1;
		while (tail.next != null) {
			tail = tail.next;
			len++;
		}
		int num = (len - k % len) % len;
		while (num-- > 0) {
			ListNode61 tmp = head;
			head = head.next;
			tmp.next = null;
			tail.next = tmp;
			tail = tail.next;
		}
		return head;
	}
}

class ListNode61 {
	int val;
	ListNode61 next;

	ListNode61() {
	}

	ListNode61(int val) {
		this.val = val;
	}

	ListNode61(int val, ListNode61 next) {
		this.val = val;
		this.next = next;
	}
}
