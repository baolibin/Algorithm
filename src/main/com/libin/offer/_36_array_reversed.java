package libin.offer;

/**
 * 面试题36：数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class _36_array_reversed {
    public static void main(String[] args){

    }
}
class Solution36 {
    public int InversePairs(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int[] copy=new int[array.length];
        for(int i=0;i<array.length;i++){
            copy[i]=array[i];
        }
        int count=getReversedNum(array,copy,0,array.length-1);
        return count;
    }
    public int getReversedNum(int[] data,int[] copy,int start,int end){
        if(start==end){
            copy[start]=data[start];
            return 0;
        }
        int tmpLen=(end-start)/2;
        int left=getReversedNum(copy,data,start,start+tmpLen)%1000000007;
        int right=getReversedNum(copy,data,start+tmpLen+1,end)%1000000007;

        int i=start+tmpLen; //前半段最后一个数字的下标
        int j=end;  //后半段最后一个数字的下标
        int currentTmp=end; //当前赋值的数组最后一位
        int count=0; //本次计数值
        while(i>=start&&j>=start+tmpLen+1){ //2个段都不为空
            if(data[i]>data[j]){
                copy[currentTmp--]=data[i--];
                count+=j-start-tmpLen;
                if(count>=1000000007){
                    count%=1000000007;
                }
            }else{
                copy[currentTmp--]=data[j--];
            }
        }
        while(i>=start){
            copy[currentTmp--]=data[i--];
        }
        while(j>=start+tmpLen+1){
            copy[currentTmp--]=data[j--];
        }
        return (left+right+count)%1000000007;
    }
}
