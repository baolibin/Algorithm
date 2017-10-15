package libin.offer;

import java.util.Stack;

/**
 * 面试题7：用两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class _07_twoStack {
    public static void main(String[] args){
        Solution07 solution07 = new Solution07();
    }
}
class Solution07 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(!stack2.empty()){
            return stack2.pop();
        }else if(stack2.empty()&&!stack1.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
        return stack2.pop();
    }
}
