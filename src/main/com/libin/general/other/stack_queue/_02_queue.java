package libin.general.other.stack_queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
/**
boolean	add(E e) ：添加元素
Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available.
E	element() ：取出元素不删除
Retrieves, but does not remove, the head of this queue.
boolean	offer(E e) ：插入元素
Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.
E	peek() ：取出元素不删除
Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
E	poll() ：取出元素并且删除
Retrieves and removes the head of this queue, or returns null if this queue is empty.
E	remove()
Retrieves and removes the head of this queue.
 */
public class _02_queue {
	public static void main(String[] args) {
		Queue<String> fn_queue = new ArrayBlockingQueue<String>(10);
		
		fn_queue.add("K近邻");
		fn_queue.add("朴素贝叶斯");
		fn_queue.add("决策树");
		fn_queue.add("逻辑回归");
		fn_queue.add("支持向量机");
		fn_queue.add("集成算法");
		
		System.out.println(fn_queue.element());
		System.out.println(fn_queue.element());
		System.out.println(fn_queue.offer("集成算法"));
		System.out.println(fn_queue.offer("聚类"));
		System.out.println(fn_queue.peek());
		System.out.println(fn_queue.peek());
		System.out.println(fn_queue.poll());
		System.out.println(fn_queue.poll());
		System.out.println(fn_queue.peek());
		System.out.println(fn_queue.poll());
		System.out.println(fn_queue.poll());
		System.out.println(fn_queue.poll());
		System.out.println(fn_queue.poll());
		System.out.println(fn_queue.poll());
		System.out.println(fn_queue.poll());
		System.out.println(fn_queue.poll());
		System.out.println(fn_queue.poll());
	}
}
