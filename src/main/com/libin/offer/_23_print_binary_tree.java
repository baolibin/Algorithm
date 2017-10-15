package libin.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题23：从上往下打印二叉树
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class _23_print_binary_tree {
    public static void main(String[] args) {
        TreeNode23 treeNode23 = new TreeNode23(1);
        treeNode23.left=new TreeNode23(2);
        treeNode23.right=new TreeNode23(3);
        treeNode23.left.left=new TreeNode23(4);
        treeNode23.left.right=new TreeNode23(5);
        Solution23 solution23 = new Solution23();
        ArrayList<Integer> al=solution23.PrintFromTopToBottom(treeNode23);
        for(Integer spl:al){
            System.out.print(spl+"、");
        }
    }
}

class Solution23 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode23 root) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        Queue<TreeNode23> queue = new LinkedList<TreeNode23>();
        if(root==null){
            return al;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode23 tmp=queue.poll();
            al.add(tmp.val);
            if(tmp.left!=null){
                queue.add(tmp.left);
            }
            if(tmp.right!=null){
                queue.add(tmp.right);
            }
        }
        return al;
    }
}
class TreeNode23 {
    int val = 0;
    TreeNode23 left = null;
    TreeNode23 right = null;
    public TreeNode23(int val) {
        this.val = val;
    }
}