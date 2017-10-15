package libin.offer;

/**
 * 面试题29：数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class _29_num_times {
	public static void main(String[] args) {
		int[] a={1,2,3,2,2,2,5,2,4};
		Solution29 solution29 = new Solution29();
		int result=solution29.MoreThanHalfNum_Solution(a);
		System.out.println(result);
	}
}
class Solution29 {
    public int MoreThanHalfNum_Solution(int [] array) {
    	if(array.length==0){
    		return 0;
    	}
    	int count=1;
    	int design=array[0];
    	for(int i=1;i<array.length;i++){
    		if(design==array[i]){
    			count++;
    		}else{
    			count--;
    			if(count==0){
    				count=1;
    				design=array[i];
    			}
    		}
    	}
    	count=0;
    	for(int i=0;i<array.length;i++){
    		if(design==array[i]){
    			count++;
    		}
    	}
    	if(count*2>array.length){
    		return design;
    	}
        return 0;
    }
}

