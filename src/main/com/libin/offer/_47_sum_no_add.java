package libin.offer;
/**
 * 面试题47：不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class _47_sum_no_add {
	public static void main(String[] args) {
		Solution47 solution47 = new Solution47();
		System.out.println(solution47.Add(12, 13));
	}
}
class Solution47 {
    public int Add(int num1,int num2) {
        do{
        	int sum=num1^num2; //异或操作，不计进位
        	int carry=(num1&num2)<<1; //进位，左移一位
        	num1=sum;
        	num2=carry;
        }while(num2!=0); //进位不为0
        return num1;
    }
}