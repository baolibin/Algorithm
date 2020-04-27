package libin.leetcode_cn_algorithm;

/**
 * Copyright (c) 2020/4/27. 小彬科技 Inc. All Rights Reserved.
 * Authors: libin <小彬科技>
 * <p>
 * Purpose : 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 */
public class _0141_hasCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        ListNode fast = head.next;
        ListNode low = head;
        while(fast!=low){
            if(fast==null || low==null){
                return false;
            }
            low = low.next;
            if(fast.next==null){
                return false;
            }
            fast=fast.next.next;
        }
        return true;
    }
}
