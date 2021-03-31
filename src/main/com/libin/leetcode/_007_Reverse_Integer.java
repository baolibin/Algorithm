package libin.leetcode;

/**
7. Reverse Integer
Reverse digits of an integer.
Example1: x = 123, return 321
Example2: x = -123, return -321
 */
class _7_Reverse_Integer {
	public static void main(String[] args) {
		Solution7 solution7 = new Solution7();
		System.out.println(solution7.reverse(-2143847412));
		System.out.println(solution7.reverse(1534236469));
		System.out.println(solution7.reverse(-2147483648));
		//System.out.println(Integer.MAX_VALUE);//2147483647
		//System.out.println(Integer.MIN_VALUE);//-2147483648
	}
}
class Solution7 {
    public int reverse(int x) {
    	int num=0;
        boolean k=false;
    	if(x<0){
    		x=-x;
    		k=true;
    	}
    	System.out.println("x="+x);
    	while(x!=0){
    		if (x==0) {
				break;
			}
    		//第一个约束条件1534236469  ||  -2147483648
    		if(Integer.MAX_VALUE/10<num||Integer.MIN_VALUE>=x){
    			return 0;
    		}else{
    			num=num*10+x%10;
    		}
    		x=x/10;
    	}
    	if (k) {
    		return -num;
		}
		return num;
    }
}