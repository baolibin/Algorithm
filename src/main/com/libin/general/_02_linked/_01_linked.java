package libin.general._02_linked;

import java.util.Stack;

/**
 * 链表简单操作
 * @author baolibin
 * 1、Linked_01 构造方法
 * 2、addEle 头部增加节点
 * 3、addEnd 尾部增加节点
 * 4、deleteLinked 删除指定节点
 * 5、updateLinked 修改指定节点
 * 6、getLinkedText 查询指定节点
 * 7、print 有头单链表遍历、无头单链表遍历、单链表倒序遍历
 * 8、reversal 链表翻转
 * 9、sortLinked 链表排序
 * 10、getMiddle 返回中间元素
 * 11、getLoop 判断链表是否有环
 * 12、raversalR 链表翻转递归
 */
public class _01_linked {
	public static void main(String[] args) {
		//头结点
		Linked_01 head = new Linked_01(null,null);
		Linked_01 head2 = new Linked_01(null,null);
		
		//头部插入
		Linked_01 insert_1 = new Linked_01("one",null);
		Linked_01 insert_2 = new Linked_01("two",null);
		Linked_01 insert_3 = new Linked_01("three",null);
		Linked_01 insert_4 = new Linked_01("four",null);
		head.addEle(head, insert_1);
		head.addEle(head, insert_2);
		head.addEle(head, insert_3);
		head.addEle(head, insert_4);
//		head.print(head);
		head.reversal(head);
//		head.print(head);
		
		//尾部插入
		Linked_01 insert2_1 = new Linked_01("one",null);
		Linked_01 insert2_2 = new Linked_01("two",null);
		Linked_01 insert2_3 = new Linked_01("three",null);
		Linked_01 insert2_4 = new Linked_01("four",null);
		Linked_01 insert2_5 = new Linked_01("five",null);
//		Linked_01 insert2_6 = new Linked_01("six",null);
		head2.addEnd(head2, insert2_1);
		head2.addEnd(head2, insert2_2);
		head2.addEnd(head2, insert2_3);
		head2.addEnd(head2, insert2_4);
		head2.addEnd(head2, insert2_5);
//		head2.addEnd(head2, insert2_6);
		head2.print(head2);
		//反转链表
//		head2.reversal(head2);
//		head2.print(head2);
		//删除指定节点
//		head2.deleteLinked(head2,4);
//		head2.print(head2);
		//修改指定节点的值
//		head2.updateLinked(head2, 1, "update_value");
//		head2.print(head2);
		//查询指定节点的值
//		String str=head2.getLinkedText(head2, 3);
//		System.out.println(str);
//		head2.print(head2);
		//链表排序
//		head2.sortLinked(head2);
//		head2.print(head2);
		//返回中间元素
//		String getMiddle=head2.getMiddle(head2);
//		System.out.println(getMiddle);
//		head2.print(head2);
		//判断链表是否有环
//		System.out.println(head2.getLoop(head2));
		Linked_01 loop1 = new Linked_01("one",null);
		Linked_01 loop2 = new Linked_01("two",null);
		Linked_01 loop3 = new Linked_01("three",null);
		Linked_01 loop4 = new Linked_01("four",null);
		Linked_01 loop5 = new Linked_01("five",null);
		loop1.next=loop2;
		loop2.next=loop3;
		loop3.next=loop4;
		loop4.next=loop5;
		loop5.next=loop1;
//		System.out.println(loop1.getLoop(loop1));
		//递归反转
		Linked_01 newLinked=head2.next;
//		newLinked=newLinked.raversalR(newLinked);
//		newLinked.print(newLinked,true);
		//倒序输出
		newLinked.print(newLinked, 1);
	}
}

class Linked_01{
	String text;
	Linked_01 next;
	/**
	 * 构造方法
	 * @param text 节点内容
	 * @param next  当前节点所指向的节点
	 */
	public Linked_01(String text,Linked_01 next) {
		this.text=text;
		this.next=next;
	}
	/**
	 * 头部插入
	 * @param head
	 * @param insert
	 */
	public void addEle(Linked_01 head,Linked_01 insert){
		insert.next=head.next;
		head.next=insert;
	}
	/**
	 * 尾部插入
	 */
	public void addEnd(Linked_01 head,Linked_01 insert){
		Linked_01 out=head;
		while(out.next!=null){
			out=out.next;
		}
		out.next=insert;
	}
	/**
	 * 删除指定节点
	 * @param head 链表的头指针
	 * @param index 删除第几个节点
	 */
	public void deleteLinked(Linked_01 head,int index){
		Linked_01 out=head;
		while (out.next!=null) {
			--index;
			if(index==0){
				break;
			}
			out=out.next;
		}
		if(out.next!=null){
			out.next=out.next.next;
		}
	}
	/**
	 * 修改指定节点内容
	 * @param head 链表的头指针
	 * @param index 修改第几个节点
	 * @param value 修改的值
	 */
	public void updateLinked(Linked_01 head,int index,String value){
		Linked_01 out=head;
		while (out.next!=null) {
			--index;
			if(index==0){
				break;
			}
			out=out.next;
		}
		if(out.next!=null){
			out.next.text=value;
		}
	}
	/**
	 * 查询链表
	 * @param head 操作的链表头指针
	 * @param index 返回第几个节点的值
	 * @return
	 */
	public String getLinkedText(Linked_01 head,int index){
		String tmp="不存在";
		Linked_01 out=head;
		while (out.next!=null) {
			--index;
			if(index==0){
				break;
			}
			out=out.next;
		}
		if(out.next!=null){
			return out.next.text;
		}
		return tmp;
	}
	/**
	 * 遍历链表
	 * @param head 遍历链表的头指针
	 */
	public void print(Linked_01 head){
		Linked_01 out=head;
		while (out.next!=null) {
			System.out.print(out.next.text+"、");
			out=out.next;
		}
		System.out.println("\n");
	}
	/**
	 *  链表无头结点遍历
	 * @param head
	 * @param flag
	 */
	public void print(Linked_01 head,boolean flag){
		if(flag){
			while (head!=null) {
				System.out.print(head.text+"、");
				head=head.next;
			}
		}
		System.out.println("\n");
	}
	/**
	 * 链表倒序遍历
	 */
	public void print(Linked_01 head,int flag){
		Stack<String> stack = new Stack<String>();
		if(flag==1){
			while (head!=null) {
				stack.push(head.text);
				head=head.next;
			}
//			for (String str : stack) {
//				System.out.print(str+"、");
//			}
			while (!stack.isEmpty()) {
				System.out.print(stack.pop()+"、");
			}
			System.out.println("\n");
		}
	}
	/**
	 * 链表反转
	 * 1、新建节点insert指向当前节点current的下一个节点
	 * 2、当前节点current的下下节点赋值给当前节点current的下一个节点
	 * 3、头结点head的下一个节点赋值给新建节点insert的下一个节点
	 * 4、头结点head下一个节点指向insert节点
	 */
	public void reversal(Linked_01 head){
		Linked_01 current=head.next;
		Linked_01 insert=null;
		while (current.next.next!=null) {
			insert=current.next; //第一步
			current.next=current.next.next; //第二步
			insert.next=head.next; //第三步
			head.next=insert; //第四步
		}
		insert=current.next;
		current.next=null;
		insert.next=head.next;
		head.next=insert;
	}
	/**
	 * 简单选择排序
	 * 链表排序
	 */
	public void sortLinked(Linked_01 head){
		Linked_01 current=head.next; //当前值待替换的节点
		Linked_01 slip=null; //滑动节点
		Linked_01 select; //最小值节点
		String tmp;
		while(current.next!=null){
			select=null;
			tmp=current.text;
			slip=current.next;
			while (slip!=null) {
				if(slip.text.compareTo(tmp)<0){
					tmp=slip.text;
					select=slip;
				}
				slip=slip.next;
			}
			if(tmp!=null&&select!=null){
				select.text=current.text;
				current.text=tmp;
			}
			current=current.next;
		}
	}
	/**
	 * 返回链表中间元素
	 */
	@SuppressWarnings("null")
	public String getMiddle(Linked_01 head){
		if(head==null&&head.next==null){
			return "空链表";
		}
		Linked_01 first=head;
		Linked_01 second=head;
		while(first.next!=null&&second.next!=null&&second.next.next!=null){
			first=first.next;
			second=second.next.next;
		}
		if(second.next!=null){ //当链表节点个数是奇数时成立
			return first.next.text;
		}
		return first.text;
	}
	/**
	 * 判断链表是否有环
	 * @param head
	 * @return
	 */
	public int getLoop(Linked_01 head){
		Linked_01 slow=head;
		Linked_01 high=head;
		while(slow.next!=null&&high.next!=null&&high.next.next!=null){
			slow=slow.next;
			high=high.next.next;
			if(slow==high){
				return 1;
			}
		}
		return 0;
	}
	/**
	 * 链表反转递归
	 */
	public Linked_01 raversalR(Linked_01 head){
		if(head==null||head.next==null||head.next.next==null){
			return head;
		}
		Linked_01 rHead=raversalR(head.next);
		head.next.next=head;
		head.next=null;
		return rHead;
	}
}
