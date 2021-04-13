package libin.leetcode_cn_algorithm._2_linked;

/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 */
public class _0234_isPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;
        // 找到中间节点
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.print(slow.val + "," + fast.val);
        System.out.println();
        // 反转链表后半部分
        ListNode pre = slow.next, cur = pre.next, tail = null;
        while (cur != null) {
            tail = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tail;
        }
        slow.next.next = null;
        ListNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.val + ",");
            tmp = tmp.next;
        }

        System.out.println();
        tmp = pre;
        while (tmp != null) {
            System.out.print(tmp.val + ",");
            tmp = tmp.next;
        }
        System.out.println();

        // 进行对比比较
        while (pre != null && head != null) {
            System.out.println("pre=" + pre.val + ",head=" + head.val);
            if (head.val != pre.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        return true;
    }
}
