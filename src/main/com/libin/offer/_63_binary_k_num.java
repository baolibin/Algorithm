package libin.offer;

/**
 * 面试题63：二叉搜索树的第k个结点
 * 给定一颗二叉搜索树，请找出其中的第k大的结点
 * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 */
public class _63_binary_k_num {
    public static void main(String[] args) {
        int[] a={8,6,10,5,7,9,11};
        TreeNode63 treeNode63 = new TreeNode63(8);
        treeNode63.left= new TreeNode63(6);
        treeNode63.right= new TreeNode63(10);
        treeNode63.left.left= new TreeNode63(5);
        treeNode63.left.right= new TreeNode63(7);
        treeNode63.right.left= new TreeNode63(9);
        treeNode63.right.right= new TreeNode63(11);

        Solution63 solution63 = new Solution63();
        TreeNode63 treeNode631 = solution63.KthNode(treeNode63, 3);
        System.out.println(treeNode631.val);
    }
}
class Solution63 {
    int k;
    TreeNode63 KthNode(TreeNode63 pRoot, int k) {
        if(pRoot==null||k==0){
            return null;
        }
        this.k=k;
        return getKNum(pRoot);
    }
    public TreeNode63 getKNum(TreeNode63 pRoot){
        TreeNode63 result=null;
        if(pRoot!=null){
            if((result=getKNum(pRoot.left))!=null){
                System.out.println("上"+result.val);
                return result;
            }
            if((k--)==1){
                System.out.println("z"+pRoot.val);
                return pRoot;
            }
            if((result=getKNum(pRoot.right))!=null){
                System.out.println("x"+result.val);
                return result;
            }
        }
        return null;
    }
}
class TreeNode63 {
    int val = 0;
    TreeNode63 left = null;
    TreeNode63 right = null;
    public TreeNode63(int val) {
        this.val = val;
    }
}