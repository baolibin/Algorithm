package libin.offer;
/**
 * 面试题46：求1+2+...+n
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class _46_n_sum {
	public static void main(String[] args) {
		Solution46 solution46 = new Solution46();
		int sum=solution46.Sum_Solution(100);
		System.out.println(sum);
	}
}
class Solution46 {
    public int Sum_Solution(int n) {
    	if(n<1){
    		return 0;
    	}
        return n+Sum_Solution(n-1);
    }
}