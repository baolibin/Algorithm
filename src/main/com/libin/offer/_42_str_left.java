package libin.offer;

/**
 * 面试题42-题目2：字符串左旋转
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 */
public class _42_str_left {
    public static void main(String[] args){

    }
}
class Solution42_2 {
    public String LeftRotateString(String str,int n) {
        if(str==null||str.length()<n){
            return "";
        }
        char[] chars = str.toCharArray();
        Reverse(0,n-1,chars);
        Reverse(n,chars.length-1,chars);
        Reverse(0,chars.length-1,chars);
        return String.valueOf(chars);
    }
    public void Reverse(int head,int tail,char[] chars){
        if(head>=tail){
            return;
        }
        while (head<tail){
            char tmp=chars[head];
            chars[head]=chars[tail];
            chars[tail]=tmp;
            head++;
            tail--;
        }
    }
}
