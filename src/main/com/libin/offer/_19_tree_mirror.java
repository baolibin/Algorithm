package libin.offer;
/**
 * 面试题19：二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class _19_tree_mirror {
    public static void main(String[] args){
        TreeNode19 t1 = new TreeNode19(1);
        t1.left=new TreeNode19(2);
        t1.right=new TreeNode19(3);
        t1.left.left=new TreeNode19(4);
        t1.left.right=new TreeNode19(5);

        Solution19 solution19 = new Solution19();
        solution19.Mirror(t1);
        solution19.preOrderTraversal(t1);
    }
}

class Solution19 {
    public void Mirror(TreeNode19 root) {
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            return;
        }
        TreeNode19 tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        if(root.left!=null){
            Mirror(root.left);
        }
        if(root.right!=null){
            Mirror(root.right);
        }
    }
    /**
     * 先序遍历
     * @param node 二叉树的根节点
     */
    public void preOrderTraversal(TreeNode19 node){
        if(node!=null){
            System.out.print(node.val+"、");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

}
class TreeNode19 {
    int val = 0;
    TreeNode19 left = null;
    TreeNode19 right = null;
    public TreeNode19(int val) {
        this.val = val;
    }
}