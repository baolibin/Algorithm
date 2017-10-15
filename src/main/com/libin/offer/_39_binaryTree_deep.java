package libin.offer;

/**
 * 面试题39：二叉树的深度
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class _39_binaryTree_deep {
    public static void main(String[] args) {

    }
}
class Solution39 {
    public int TreeDepth(TreeNode39 root) {
        if(root==null){
            return 0;
        }
        int left=TreeDepth(root.left);
        int right=TreeDepth(root.right);
        return left>right?(left+1):(right+1);
    }
}
class TreeNode39 {
    int val = 0;
    TreeNode39 left = null;
    TreeNode39 right = null;
    public TreeNode39(int val) {
        this.val = val;
    }
}
