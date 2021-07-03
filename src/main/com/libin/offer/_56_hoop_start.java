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
	/**
	 *我们使用两个指针，fast与slow。它们起始都位于链表的头部。随后，slow 指针每次向后移动一个位置，而fast 指针向后移动两个位置。如果链表中存在环，则 fast 指针最终将再次与slow 指针在环中相遇。
	 *
	 * 设链表中环外部分的长度为a。slow 指针进入环后，又走了b的距离与fast 相遇。此时，fast 指针已经走完了环的 n 圈，因此它走过的总距离为 a+n(b+c)+b=a+(n+1)b+nc。
	 *
	 * 根据题意，任意时刻，fast 指针走过的距离都为slow 指针的 2倍。因此，我们有
	 *
	 * a+(n+1)b+nc=2(a+b)⟹a=c+(n−1)(b+c)
	 *
	 * 有了 a=c+(n-1)(b+c) 的等量关系，我们会发现：从相遇点到入环点的距离加上 n−1 圈的环长，恰好等于从链表头部到入环点的距离。
	 *
	 * 因此，当发现slow 与fast 相遇时，我们再额外使用一个指针ptr。起始，它指向链表头部；随后，它和slow 每次向后移动一个位置。最终，它们会在入环点相遇。
	 *
	 */
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