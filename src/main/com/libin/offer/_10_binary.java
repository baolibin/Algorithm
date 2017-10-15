package libin.offer;

/**
 * 面试题10：二进制中1的个数
 *输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class _10_binary {
    public static void main(String[] args){
        Solution10 solution10 = new Solution10();
        System.out.println(solution10.NumberOf1(12345));
    }
}
class Solution10 {
    public int NumberOf1(int n) {
        int count=0;
        int flag=1;
        while(flag!=0){
            if((n & flag) !=0){
                count++;
            }
            flag=flag<<1;
        }
        return count;
    }
}