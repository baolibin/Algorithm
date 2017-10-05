package libin.leetcode;

/**
 * 2、Add Two Numbers
 * 问题： 题目地址：https://leetcode.com/problems/add-two-numbers/ 
 * 题目：
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 */
public class _002_Add_Two_Numbers {
	public static void main(String[] args) {
		ListNode head1=new ListNode(-1);
		head1.next=new ListNode(9);
		head1.next.next=new ListNode(8);
		//head1.next.next.next=new ListNode(3);
		
		ListNode head2=new ListNode(-1);
		head2.next=new ListNode(1);
		//head2.next.next=new ListNode(6);
		//head2.next.next.next=new ListNode(6);
		//head2.next.next.next.next=new ListNode(1);
		
		
		ListNode res=new Solution2().addTwoNumbers(head1.next, head2.next);
		while(res!=null){
			System.out.println(res.val);
			res=res.next;
		}
	}
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}
/**
 * 长度不一样
 * 进位问题：链表反向存数，直接从做到右遍历，低位相加
 * 非负数 全部加就ok
 */
class Solution2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode current=head;
		int carry=0; //进位
		/**
		 * 不生成新的单项链表，复用L1链表节点。
		 * 只生成新产生链表的头结点，以及最后进位的节点(如果有进位的话)。
		 */
		while (l1!=null && l2!=null) {
			int num1=l1.val;
			int num2=l2.val;
			l1.val=(carry+num1+num2)%10;
			carry=(carry+num1+num2)/10;
			current.next=l1;
			current=current.next;
			l1=l1.next;
			l2=l2.next;
		}
		if(l1==null){
			current.next=l2;
		}else{
			current.next=l1;
		}
		/**
		 * L1和L2长短不一样，较短链表长度加完位置有进位
		 */
		if (carry==1) {
			while (current.next!=null&&carry==1) {
				int currVal=current.next.val; //一定要用个变量存一下，要不然下一步操作会更新这个值，下一步的下一步操作就会用更新的值而报错
				current.next.val=(carry+current.next.val)%10;
				carry=(carry+currVal)/10;
				current=current.next;
			}
			/**
			 * 若最后一位有进位的话生成一个新的节点
			 */
			if(carry==1){
				current.next= new ListNode(1);
			}
		}
		return head.next;
	}
}



