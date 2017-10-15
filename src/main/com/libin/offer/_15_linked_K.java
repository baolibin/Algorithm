package libin.offer;

/**
 * 面试题15：链表中倒数第K个节点
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class _15_linked_K {
    public static void main(String[] args){
        Solution15 solution15 = new Solution15();
        ListNode15 l5 = new ListNode15(1);
        l5.next=new ListNode15(2);
        l5.next.next=new ListNode15(3);
        l5.next.next.next=new ListNode15(4);
        l5.next.next.next.next=new ListNode15(5);
        System.out.println(solution15.FindKthToTail(l5,4).val);
    }
}

/**
 * 思路一：倒数第k个节点的值即为正数第n-k+1个节点，但是链表长度n未知，求n需再遍历一次链表。
 * 思路二：设置两个指针，第一个指针从链表第k-1个位置开始遍历，第二个指针从第0个位置开始遍历，当第一个指针到达链表尾部的时候，第二个指针即为倒数第k个节点。
 */
class Solution15 {
    public ListNode15 FindKthToTail(ListNode15 head,int k) {
        if(head==null||k<=0){
            return null;
        }
        ListNode15 p=head;
        for(int i=1;i<k;i++){
            p=p.next;
            if(p==null){
                return null;
            }
        }
        while(p.next!=null){
            head=head.next;
            p=p.next;
        }
        return head;
    }
}
class ListNode15 {
    int val;
    ListNode15 next = null;
    ListNode15(int val) {
        this.val = val;
    }
}