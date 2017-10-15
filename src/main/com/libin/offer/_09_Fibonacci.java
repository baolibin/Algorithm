package libin.offer;

/**
 * 面试题9：菲波那切数列
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 n<=39
 */
public class _09_Fibonacci {
    public static void main(String[] args){
        Solution09 solution09 = new Solution09();
        System.out.println(solution09.Fibonacci(39));
    }
}
class Solution09 {
    public int Fibonacci(int n) {
        int[] result={0,1};
        if(n<2){
            return result[n];
        }
        long current=0;
        long firstNum=0;
        long secondNum=1;
        for(int i=2;i<=n;i++){
            current=firstNum+secondNum;
            firstNum=secondNum;
            secondNum=current;
        }
        return Integer.parseInt(String.valueOf(current));
    }
}