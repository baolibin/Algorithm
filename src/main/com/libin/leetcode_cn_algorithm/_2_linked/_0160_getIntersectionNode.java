package libin.leetcode_cn_algorithm._2_linked;

/**
 * Copyright (c) 2021/4/11. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class _0160_getIntersectionNode {
	/**
	 * 解题思路：
	 * 指针 pA 指向 A 链表，指针 pB 指向 B 链表，依次往后遍历
	 * 如果 pA 到了末尾，则 pA = headB 继续遍历
	 * 如果 pB 到了末尾，则 pB = headA 继续遍历
	 * 比较长的链表指针指向较短链表head时，长度差就消除了
	 * 如此，只需要将最短链表遍历两次即可找到位置
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
		ListNode pA = headA, pB = headB;
		while (pA != pB) {
			pA = pA == null ? headB : pA.next;
			pB = pB == null ? headA : pB.next;
		}
		return pA;
	}
}
