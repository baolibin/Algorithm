package libin.leetcode_cn_algorithm._2_linked;

/**
 * Copyright (c) 2021/4/14. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
public class _0328_oddEvenList {
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode curOddNode = head; // 奇数位最后节点父节点位置
		ListNode evenNode = head.next, curEvenNode = head.next;  // 偶数位最后节点父节点位置
		ListNode cur = head.next.next; // 当前正在遍历的节点
		ListNode tail = null; //当前正在遍历节点的下一个节点
		boolean flag = true;
		while (cur != null) {
			tail = cur.next;
			if (flag) { // 奇数位节点
				curEvenNode.next = tail;
				curOddNode.next = cur; // 当前奇数位节点插入到奇数链表后面
				cur.next = evenNode;  // 插入后的新奇数位节点next变为偶数位节点的头结点
				curOddNode = curOddNode.next; // 当前奇数位节点最后一位后移
				cur = tail; // 重新赋值下一个遍历的当前节点
				flag = false;
			} else {  // 偶数位节点
				curEvenNode = curEvenNode.next; // 偶数节点直接跳过
				cur = cur.next;
				flag = true;
			}
		}
		return head;
	}
}
