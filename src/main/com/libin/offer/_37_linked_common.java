package libin.offer;

/**
 * 面试题37：两个链表的第一个公共结点
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class _37_linked_common {
    public static void main(String[] args){

    }
}

class Solution37 {
    public ListNode37 FindFirstCommonNode(ListNode37 pHead1, ListNode37 pHead2) {
        int linkedLen1=0;
        int linkedLen2=0;
        ListNode37 l1=pHead1;
        ListNode37 l2=pHead2;
        while(l1!=null){
            linkedLen1++;
            l1=l1.next;
        }
        while(l2!=null){
            linkedLen2++;
            l2=l2.next;
        }
        int dif=0;
        if(linkedLen1<linkedLen2){
            dif=linkedLen2-linkedLen1;
            l1=pHead2;
            l2=pHead1;
        }else{
            dif=linkedLen1-linkedLen2;
            l1=pHead1;
            l2=pHead2;
        }
        while(dif>0){
            l1=l1.next;
            dif--;
        }
        ListNode37 result=null;
        while (l1!=null){
            if(l1==l2){
                result=l1;
                break;
            }
            l1=l1.next;
            l2=l2.next;
        }
        return result;
    }
}
class ListNode37 {
    int val;
    ListNode37 next = null;
    ListNode37(int val) {
        this.val = val;
    }
}