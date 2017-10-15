package libin.offer;

/**
 * 面试题38：数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。
 */
public class _38_sort_num_times {
    public static void main(String[] args){
        Solution38 solution38 = new Solution38();
        int[] a={1,2,3,3,3,3,4,5};
        int result=solution38.GetNumberOfK(a,3);
        System.out.println(result);
    }
}
class Solution38 {
    public int GetNumberOfK(int [] array , int k) {
        if(array.length==0){
            return 0;
        }
        int head=getHeadIndex(array,k,0,array.length-1);
        int tail=getTailIndex(array,k,0,array.length-1);
        if(head>-1&&tail>-1){
            return tail-head+1;
        }
        return 0;
    }
    public int getHeadIndex(int [] array , int k,int start,int end){
        if(start>end){
            return -1;
        }
        int midIndex=(start+end)/2;
        int midData=array[midIndex];
        if(midData==k){
            if((midIndex>0&&array[midIndex-1]!=k)||midIndex==0){
                return midIndex;
            }else{
                end=midIndex-1;
            }
        }else if(midData>k){
            end=midIndex-1;
        }else {
            start=midIndex+1;
        }
        return getHeadIndex(array,k,start,end);
    }
    public int getTailIndex(int [] array , int k,int start,int end){
        if(start>end){
            return -1;
        }
        int midIndex=(start+end)/2;
        int midData=array[midIndex];
        if(midData==k){
            if((midIndex<array.length-1&&array[midIndex+1]!=k)||midIndex==array.length-1){
                return midIndex;
            }else{
                start=midIndex+1;
            }
        }else if(midData<k){
            start=midIndex+1;
        }else {
            end=midIndex-1;
        }
        return getTailIndex(array,k,start,end);
    }
}
