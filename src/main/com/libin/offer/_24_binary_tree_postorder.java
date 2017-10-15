package libin.offer;

import java.util.Arrays;

/**
 * 面试题24：二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class _24_binary_tree_postorder {
    public static void main(String[] args){
        int[] a={5,7,6,9,11,10,8};
        int[] a2={7,4,6,5};
        int[] a3={4,6,7,6};
        Solution24 solution24 = new Solution24();
        System.out.println(solution24.VerifySquenceOfBST(a));
    }
}
class Solution24 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        int len=sequence.length;
        return getSequence(sequence,len);
    }
    public boolean getSequence(int [] sequence,int len){
        if(sequence==null||len<=0){
            return false;
        }
        int root=sequence[len-1];
        //在二叉搜索树中左子树的节点小于根节点
        int left=0;
        int i=0;
        for(i=left;i<len-1;i++){
            if(sequence[i]>root){
                break;
            }
        }
        left=i;
        //在二叉搜索树中右子树的节点大于根节点
        int right=left;
        for(int j=right;j<len-1;j++){
            if(sequence[j]<root){
                return false;
            }
        }
        //判断左子树是不是二叉搜索树
        boolean leftTree=true;
        if(left>0){
            leftTree=getSequence(Arrays.copyOfRange(sequence,0,left),left);
        }
        //判断左子树是不是二叉搜索树
        boolean rightTree=true;
        if(left<len-1){
            rightTree=getSequence(Arrays.copyOfRange(sequence,left,len-1),len-left-1);
        }
        return leftTree&&rightTree;
    }
}
