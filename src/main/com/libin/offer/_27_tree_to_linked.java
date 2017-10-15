package libin.offer;

/**
 * 面试题27：二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class _27_tree_to_linked {
    public static void main(String[] args) {
        TreeNode27 treeNode27 = new TreeNode27(10);
        treeNode27.left= new TreeNode27(6);
        treeNode27.right= new TreeNode27(14);
        treeNode27.left.left= new TreeNode27(4);
        treeNode27.left.right= new TreeNode27(8);
        treeNode27.right.left= new TreeNode27(12);
        treeNode27.right.right= new TreeNode27(16);
        Solution27 solution27 = new Solution27();
        TreeNode27 pResult=solution27.Convert(treeNode27);
        while(pResult!=null){
            System.out.print(pResult.val+"、");
            pResult=pResult.right;
        }
    }
}
class Solution27 {
    public TreeNode27 Convert(TreeNode27 pRootOfTree) {
        TreeNode27 pResult=convertNode(pRootOfTree,null);
        //pResult指向双向链表的尾结点，返回头结点
        while(pResult!=null&&pResult.left!=null){
            pResult=pResult.left;
        }
        return pResult;
    }
    public TreeNode27 convertNode(TreeNode27 pRootOfTree,TreeNode27 pResult){
        if(pRootOfTree==null){
            return null;
        }
        if(pRootOfTree.left!=null){
            pResult=convertNode(pRootOfTree.left,pResult);
        }
        pRootOfTree.left=pResult;
        if(pResult!=null){
            pResult.right=pRootOfTree;
        }
        pResult=pRootOfTree;
        if(pRootOfTree.right!=null){
            pResult=convertNode(pRootOfTree.right,pResult);
        }
        return pResult;
    }
}
class TreeNode27 {
    int val = 0;
    TreeNode27 left = null;
    TreeNode27 right = null;
    public TreeNode27(int val) {
        this.val = val;
    }
}
