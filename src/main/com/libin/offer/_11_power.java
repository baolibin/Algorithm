package libin.offer;

/**
 * 面试题11：数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class _11_power {
    public static void main(String[] args){
        Solution11 solution11 = new Solution11();
        System.out.println(solution11.Power(-3,-4));
    }
}
class Solution11 {
    public double Power(double base, int exponent) {
        if((base-0.0)> -0.0000001 && (base-0.0) < 0.0000001){
            return 0.0;
        }
        double result=1.0;
        for(int i=0;i<Math.abs(exponent);i++){
            result=result*base;
        }
        if(exponent<0){
            return 1.0/result;
        }
        return result;
    }
}
