package libin.offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 面试题41：和为S的两个数
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。 
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class _41_sum_s {
	public static void main(String[] args) {
		Solution41 solution41 = new Solution41();
		int[] arr={1,2,3,4,5,6,7,8,9};
		ArrayList<Integer> arrayList =solution41.FindNumbersWithSum(arr, 7);
		System.out.println(arrayList.get(0));
		System.out.println(arrayList.get(1));
	}
}
class Solution41 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
    	ArrayList<Integer> arrayList = new ArrayList<Integer>();
    	if(array==null||array.length==0){
    		return arrayList;
    	}
        int head=0;
        int tail=array.length-1;
        int count=Integer.MAX_VALUE;
        int tmp=0;
        while(head<tail){
        	if((array[head]+array[tail])==sum){
        		tmp=array[head]*array[tail];
        		if(count>tmp){
        			arrayList.clear();
        			arrayList.add(array[head]);
        			arrayList.add(array[tail]);
        			count=tmp;
        		}
        		tail--;
        		head++;
        	}else if((array[head]+array[tail])>sum){
        		tail--;
        	}else{
        		head++;
        	}
        }
        Collections.sort(arrayList);
        return arrayList;
    }
}
