package libin.Cracking_the_Coding_Interview;

import java.util.HashSet;

/**
 * Copyright (c) 2020/4/18. libin Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 面试题 02.01. 移除重复节点
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * 示例2:
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 * 提示：
 * <p>
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 */
public class _0201_removeDuplicateNodes {
    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> set = new HashSet<Integer>();
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        set.add(head.val);
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            int tmp = cur.val;
            if (set.contains(tmp)) {
                pre.next = pre.next.next;
            } else {
                set.add(cur.val);
                pre = pre.next;
            }
            cur = pre.next;
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
