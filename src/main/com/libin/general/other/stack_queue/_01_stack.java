package libin.general.other.stack_queue;

import java.util.Stack;
/**
Method and Description
boolean	empty():
Tests if this stack is empty.
E	peek(): 取出栈顶元素，但是没有删除
Looks at the object at the top of this stack without removing it from the stack.
E	pop(): 取出栈顶元素，并且删除
Removes the object at the top of this stack and returns that object as the value of this function.
E	push(E item): 往栈里面添加元素
Pushes an item onto the top of this stack.
int	search(Object o): 查找元素并返回元素位置,没找到的话返回-1
Returns the 1-based position where an object is on this stack.
*/
public class _01_stack {
	public static void main(String[] args) {
		Stack<String> fn_stack=new Stack<String>();
		
		fn_stack.push("hadoop");
		fn_stack.push("spark");
		fn_stack.push("hive");
		fn_stack.push("hbase");
		fn_stack.push("tachyon");
		fn_stack.push("solr");
		
		System.out.println(fn_stack.pop());
		System.out.println(fn_stack.peek());
		System.out.println(fn_stack.peek());
		System.out.println(fn_stack.search("hbase"));
	}
}
