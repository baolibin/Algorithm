package libin.offer;

/**
 * 面试题8：旋转数组的最小值
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class _08_rotateArray {
    public static void main(String[] args){
        Solution08 solution08 = new Solution08();
        int[] a={3,4,5,1,2};
        int[] a2={1,1,1,0,1};
        System.out.println(solution08.minNumberInRotateArray(a2));
    }
}
class Solution08 {
    public int minNumberInRotateArray(int [] array) {
        int head=0;
        int end=array.length-1;

        while(array[head]>=array[end]){
            if(head+1==end){
                head=end;
                break;
            }
            int middle=(head+end)/2;
            if(array[head]==array[middle]&&array[middle]==array[end]){ //11101
                return getOrderSearch(array,head,end);
            }
            if(array[head]<=array[middle]){
                head=middle;
            }else if(array[end]>=array[middle]){
                end=middle;
            }
        }
        return array[head];
    }
    public int getOrderSearch(int [] array,int head,int end){
        int result=0;
        for(int i=head;i<=end;i++){
            if(result>array[i]){
                result=array[i];
            }
        }
        return result;
    }
}
