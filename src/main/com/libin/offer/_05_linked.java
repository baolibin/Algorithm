package libin.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 面试题5：从尾到头打印链表
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class _05_linked {
    public static void main(String[] args) {
        ListNode head = new ListNode(12);
        ListNode current=head;
        current.next=new ListNode(23);
        current.next.next=new ListNode(34);
        current.next.next.next=new ListNode(45);
        current.next.next.next.next=new ListNode(56);

        Solution05 solution05 = new Solution05();
        ArrayList<Integer> li=solution05.printListFromTailToHead(head);
        for(Integer in:li){
            System.out.println(in);
        }
    }
}
class Solution05 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> li = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        if(listNode==null){
            return li;
        }
        stack.push(listNode.value);
        while (listNode.next!=null){
            listNode=listNode.next;
            stack.push(listNode.value);
        }
        while(!stack.empty()){
            li.add(stack.pop());
        }
        return li;
    }

}
class ListNode {
    int value;
    ListNode next = null;
    ListNode(int value) {
        this.value = value;
    }
}
