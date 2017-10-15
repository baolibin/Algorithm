package libin.offer;

import java.util.ArrayList;

/**
 * 面试题14：调整数组顺序使奇数位于偶数的前面
 */
public class _14_adjustArray {
    public static  void main(String[] args){
        Solution14 solution14 = new Solution14();
        int[] a={1,2,3,4,5,6,7,8,9};
        solution14.reOrderArray(a);
        for(Integer aa:a){
            System.out.print(aa+"、");
        }
    }
}
class Solution14 {
    public void reOrderArray(int [] array) {
        if(array.length==0){
            return;
        }
        ArrayList<Integer> even = new ArrayList<Integer>(); //偶数
        ArrayList<Integer> odd = new ArrayList<Integer>(); //奇数
        for(int i=0;i<array.length;i++){
            if(array[i]%2==0){
                even.add(array[i]);
            }else{
                odd.add(array[i]);
            }
        }
        int index=0;
        for(Integer a:odd){
            array[index++]=a;
        }
        for(Integer a:even){
            array[index++]=a;
        }
    }
}
