package libin.offer;
/**
 * 面试题17：合并两个排序的链表
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class _17_merge_Linked {
    public  static void main(String[] args){
        Solution17 solution17 = new Solution17();
        ListNode17 l7 = new ListNode17(1);
        l7.next=new ListNode17(3);
        l7.next.next=new ListNode17(5);
        ListNode17 l8 = new ListNode17(2);
        l8.next=new ListNode17(4);
        l8.next.next=new ListNode17(5);

        ListNode17 res=solution17.Merge(l7,l8);
        while(res!=null){
            System.out.print(res.val);
            res=res.next;
        }
    }
}
class Solution17 {
    public ListNode17 Merge(ListNode17 list1,ListNode17 list2) {
        ListNode17 mergeList=null;
        if(list1==null){
            return  list2;
        }
        if(list2==null){
            return list1;
        }
        if(list1.val<list2.val){
            mergeList=list1;
            mergeList.next=Merge( list1.next,list2);
        }else{
            mergeList=list2;
            mergeList.next=Merge( list1,list2.next);
        }
        return mergeList;
    }
}
class ListNode17 {
    int val;
    ListNode17 next = null;
    ListNode17(int val) {
        this.val = val;
    }
}
