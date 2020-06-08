package libin.leetcode_cn_algorithm;

/**
 * Copyright (c) 2020/5/26. 小彬科技 Inc. All Rights Reserved.
 * Authors: libin <小彬科技>
 * <p>
 * Purpose :    237. 删除链表中的节点
 */
public class _0237_deleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
