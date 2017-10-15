package libin.offer;
/**
 * 面试题56：链表中环的入口结点
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class _56_hoop_start {
	public static void main(String[] args) {
		
	}
}
class Solution56 {
    public ListNode56 EntryNodeOfLoop(ListNode56 pHead){
    	if(pHead==null||pHead.next==null){
    		return null;
    	}
    	ListNode56 p1=pHead;
    	ListNode56 p2=pHead;
    	while (p2.next!=null) {
    		p1=p1.next;
    		p2=p2.next.next;
    		if(p1==p2){
    			p1=pHead;
    			while (p1!=p2) {
    				p1=p1.next;
    				p2=p2.next;
				}
    			return p1;
    		}
		}
		return null;
    }
}
class ListNode56 {
    int val;
	ListNode56 next = null;
	ListNode56(int val) {
        this.val = val;
    }
}