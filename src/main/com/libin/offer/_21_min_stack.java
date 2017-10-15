package libin.offer;

import java.util.Stack;
/**
 * 面试题21：包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class _21_min_stack {
    public static void main(String[] args){

    }
}
/**
 * pop取出并删除
 * peek取出不删除
 */
class Solution21 {
    Stack<Integer> s1=new Stack<Integer>();//数据栈
    Stack<Integer> s2=new Stack<Integer>();//辅助栈
    public void push(int node) {
        s1.push(node);
        if(s2.empty()){
            s2.push(node);
        }else{
            int tmp=s2.peek();
            if(tmp>=node){
                s2.push(node);
            }else{
                s2.push(tmp);
            }
        }
    }
    public void pop() {
        s1.pop();
        s2.pop();
    }
    public int top() {
        return s1.peek();
    }
    public int min() {
        return s2.peek();
    }
}
