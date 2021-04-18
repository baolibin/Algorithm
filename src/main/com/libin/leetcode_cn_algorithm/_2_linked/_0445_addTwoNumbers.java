package libin.leetcode_cn_algorithm._2_linked;

import java.util.LinkedList;

/**
 * Copyright (c) 2021/4/17. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 445. 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 进阶：
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * 示例：
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 */
public class _0445_addTwoNumbers {
	/**
	 * 本题的主要难点在于链表中数位的顺序与我们做加法的顺序是相反的，为了逆序处理所有数位，
	 * 我们可以使用栈：把所有数字压入栈中，再依次取出相加。计算过程中需要注意进位的情况。
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		LinkedList<Integer> stack1 = new LinkedList<>();
		LinkedList<Integer> stack2 = new LinkedList<>();
		while (l1 != null) {
			stack1.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			stack2.push(l2.val);
			l2 = l2.next;
		}
		int carry = 0; // 进位
		ListNode node = null;
		while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
			int x = !stack1.isEmpty() ? stack1.poll() : 0;
			int y = !stack2.isEmpty() ? stack2.poll() : 0;
			int res = x + y + carry;
			carry = res / 10;
			res %= 10;
			ListNode curNode = new ListNode(res);
			curNode.next = node;
			node = curNode;
		}
		return node;
	}
}
