package libin.offer;

/**
 * 面试题40：数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class _40_num_one_times {
    public static void main(String[] args){
        Solution40 solution40 = new Solution40();
        int[] a={2,4,3,6,3,2,5,5};
        int[] num1={0};
        int[] num2={0};
        solution40.FindNumsAppearOnce(a,num1,num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
class Solution40 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null||array.length==0){
            return;
        }
        int xorNum=0;
        //所有数异或操作和，结果为两个不一样数字的异或值，从右往左第一个不为1的位置就是两个不一样数字第一个不同位置的下标。
        for(int i=0;i<array.length;i++){
            xorNum=xorNum^array[i];
        }
        //找第一个不同的位置
        int indexEnd=0;
        while((xorNum&1)==0){
            xorNum=xorNum>>1;
            indexEnd++;
        }
        //把原始数组分两半分别进行计算
        for(int j=0;j<array.length;j++){
            if(((array[j]>>indexEnd)&1)==0){  //第一个出现一次的数字，倒数第indexEnd位  位于1  等于0。
                num1[0]^=array[j];
            }else{      //第2个出现一次的数字，倒数第indexEnd位  位于1  等于1。
                num2[0]^=array[j];
            }
        }
    }
}
