package libin.offer;
/**
 * 面试题31：连续子数组的最大和
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class _31_num_series_sum {
	public static void main(String[] args) {
		Solution31 solution31 = new Solution31();
		int[] a={6,-3,-2,7,-15,1,2,2};
		int[] a1={-2,-8,-1,-5,-9};
		int result=solution31.FindGreatestSumOfSubArray(a1);
		System.out.println(result);
	}
}
class Solution31 {
    public int FindGreatestSumOfSubArray(int[] array) {
    	if(array.length==0){
    		return 0;
    	}
    	int maxNum=0;
    	int tmpNum=array[0];
    	int minNum=Integer.MIN_VALUE; //处理数组全为负数情况
    	for(int i=1;i<array.length;i++){
    		if(minNum<array[i]){
    			minNum=array[i];
    		}
    		if(tmpNum<0){
    			tmpNum=array[i];
    		}else{
    			tmpNum+=array[i];
    		}
    		if(maxNum<tmpNum){
    			maxNum=tmpNum;
    		}
    	}
    	if(minNum<0){
    		return minNum;
    	}
        return maxNum;
    }
}
