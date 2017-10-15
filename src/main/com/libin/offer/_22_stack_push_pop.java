package libin.offer;

import java.util.Stack;

/**
 * 面试题22：栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class _22_stack_push_pop {
    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {4, 5, 3, 2, 1};
        System.out.println(solution22.IsPopOrder(a1, a2));
    }
}
class Solution22 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }
        Stack<Integer> s1 = new Stack<Integer>();
        int pushLen = pushA.length;
        int popLen = popA.length;
        int curPushIndex = 0;
        int curPopIndex = 0;
        s1.push(pushA[curPushIndex++]);
        while (!s1.empty() && curPopIndex < popLen) { //栈不空且popA数组未遍历完
            if (popA[curPopIndex] == s1.peek()) {
                s1.pop();
                curPopIndex++;
            } else if (!s1.empty()&&curPushIndex==pushLen) { //跳出循环
                break;
            } else if (curPushIndex < pushLen) { //不相等且push数组还有余值
                s1.push(pushA[curPushIndex++]);
            }
            if (s1.empty() && curPushIndex < pushLen) {
                s1.push(pushA[curPushIndex++]);
            }
        }
        if (s1.empty() && (curPopIndex == popLen)) {
            return true;
        }
        return false;
    }
}
