package libin.offer;

import java.util.ArrayList;
import java.util.TreeSet;
/**
 * 面试题30：最小的K个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class _30_min_k_num {
	public static void main(String[] args) {
		int[] num={4,5,1,6,2,7,3,8};
		Solution30 solution30 = new Solution30();
		ArrayList<Integer> arrayList=solution30.GetLeastNumbers_Solution(num, 1);
		for(Integer out:arrayList){
			System.out.print(out+"、");
		}
	}
}
class Solution30 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    	ArrayList<Integer> arrayList = new ArrayList<Integer>();
    	if(input.length==0||k==0||k>input.length){
    		return arrayList;
    	}
    	TreeSet<Integer> treeSet = new TreeSet<Integer>();
    	for(int i=0;i<k;i++){
    		treeSet.add(input[i]);
    	}
    	for(int i=k;i<input.length;i++){
    		int tmpMax=treeSet.last();
    		if(input[i]<tmpMax){
    			treeSet.remove(treeSet.last());
    			treeSet.add(input[i]);
    		}
    	}
    	for(Integer s:treeSet){
    		arrayList.add(s);
    	}
    	return arrayList;
    }
}