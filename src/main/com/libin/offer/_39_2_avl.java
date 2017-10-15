package libin.offer;

/**
 * 面试题39：
 * 题目2：平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class _39_2_avl {
    public static void main(String[] args){

    }
}
class Solution39_2 {
    public boolean IsBalanced_Solution(TreeNode39 root) {
        if(root==null){
            return true;
        }
        int left=TreeDepth(root.left);
        int right=TreeDepth(root.right);
        int dif=left-right;
        if(dif>1||dif<-1){
            return false;
        }
        //左右两个子树都要是avl树
        return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
    }
    public int TreeDepth(TreeNode39 root) {
        if(root==null){
            return 0;
        }
        int left=TreeDepth(root.left);
        int right=TreeDepth(root.right);
        return left>right?(left+1):(right+1);
    }
}