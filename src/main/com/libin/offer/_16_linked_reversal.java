package libin.offer;

/**
 *  面试题16：反转链表
 *  输入一个链表，反转链表后，输出链表的所有元素。
 */
public class _16_linked_reversal {
    public static void main(String[] args){
        Solution16 solution16 = new Solution16();
        ListNode16 l6 = new ListNode16(1);
        l6.next=new ListNode16(2);
        l6.next.next=new ListNode16(3);
        l6.next.next.next=new ListNode16(4);
        l6.next.next.next.next=new ListNode16(5);
        ListNode16 res=solution16.ReverseList(l6);
        while(res!=null){
            System.out.print(res.val);
            res=res.next;
        }
    }
}
class Solution16 {
    public ListNode16 ReverseList(ListNode16 head) {
        ListNode16 pre=head;
        ListNode16 current=null;
        ListNode16 tail=null;
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        current=pre.next;
        while (current!=null){
            tail=current.next;
            current.next=pre;
            pre=current;
            current=tail;
        }
        head.next=null; //头结点next赋值未空，否则指向原本的第二个节点。
        return pre;
    }
}
class ListNode16 {
    int val;
    ListNode16 next = null;
    ListNode16(int val) {
        this.val = val;
    }
}