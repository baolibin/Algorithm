package libin.offer;
/**
 * 面试题57：删除链表中重复的结点 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class _57_linked_remove_repeat {
	public static void main(String[] args) {
		ListNode57 listNode57 = new ListNode57(1);
		listNode57.next=new ListNode57(2);
		listNode57.next.next=new ListNode57(3);
		listNode57.next.next.next=new ListNode57(3);
		listNode57.next.next.next.next=new ListNode57(4);
		listNode57.next.next.next.next.next=new ListNode57(4);
		listNode57.next.next.next.next.next.next=new ListNode57(5);
		
		Solution57 solution57 = new Solution57();
		ListNode57 deleteDuplication = solution57.deleteDuplication(listNode57);
		while(deleteDuplication!=null){
			System.out.print(deleteDuplication.val+"、");
			deleteDuplication=deleteDuplication.next;
		}
	}
}

class Solution57 {
	public ListNode57 deleteDuplication(ListNode57 pHead) {
		if(pHead==null){
			return null;
		}
		ListNode57 pre=new ListNode57(1);
		pre.next=pHead;
		ListNode57 pCurrent=pre;
		ListNode57 pTmp=pHead;
		while (pTmp!=null) {
			System.out.println("执行了");
			boolean flag=false;
			while(pTmp.next!=null &&(pTmp.val==pTmp.next.val)){
				pTmp.next=pTmp.next.next;
				flag=true;
			}
			if(flag){  //删除重复数字的第一个节点
				pCurrent.next=pTmp.next;
				pTmp=pTmp.next;
			}else{
				pTmp=pTmp.next;
				pCurrent=pCurrent.next;
			}
		}
		return pre.next;
	}
}
class ListNode57 {
	int val;
	ListNode57 next = null;
	ListNode57(int val) {
		this.val = val;
	}
}
