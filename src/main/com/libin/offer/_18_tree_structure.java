package libin.offer;

/**
 * 面试题18：树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class _18_tree_structure {
    public static void main(String[] args) {
        TreeNode18 t1 = new TreeNode18(1);
        t1.left=new TreeNode18(2);
        t1.right=new TreeNode18(3);
        t1.left.left=new TreeNode18(4);
        t1.left.right=new TreeNode18(5);
        TreeNode18 t2 = new TreeNode18(2);
        t2.left=new TreeNode18(4);
        t2.right=new TreeNode18(65);

        Solution18 solution18 = new Solution18();
        System.out.println(solution18.HasSubtree(t1,t2));
    }
}

class TreeNode18 {
    int val = 0;
    TreeNode18 left = null;
    TreeNode18 right = null;

    public TreeNode18(int val) {
        this.val = val;
    }
}

class Solution18 {
    public boolean HasSubtree(TreeNode18 root1, TreeNode18 root2) {
        boolean result = false;
        if(root1!=null && root2!=null){
            if(root1.val==root2.val){
                result=recursionTree(root1,root2);
            }
            if(!result){
                result=recursionTree(root1.left,root2);
            }
            if(!result){
                result=recursionTree(root1.right,root2);
            }
        }
        return result;
    }
    public boolean recursionTree(TreeNode18 root1, TreeNode18 root2){
        if(root2==null){
            return true;
        }
        if(root1==null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return recursionTree(root1.left,root2.left)&&recursionTree(root1.right,root2.right);
    }
}
