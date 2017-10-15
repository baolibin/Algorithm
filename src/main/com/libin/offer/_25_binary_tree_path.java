package libin.offer;
import java.util.ArrayList;
/**
 * 面试题25：二叉树中和为某一个定值的路径
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class _25_binary_tree_path {
    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
        TreeNode25 treeNode25 = new TreeNode25(10);
        treeNode25.left = new TreeNode25(5);
        treeNode25.right = new TreeNode25(12);
        treeNode25.left.left = new TreeNode25(4);
        treeNode25.left.right = new TreeNode25(7);

        ArrayList<ArrayList<Integer>> al = solution25.FindPath(treeNode25, 22);
        for (ArrayList<Integer> p : al) {
            for (Integer pIn : p) {
                System.out.print(pIn + "、");
            }
            System.out.println();
        }
    }
}
class Solution25 {
    ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode25 root, int target) {
        if (root == null) {
            return al;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        getSumTree(root, target, 0, list);
        return al;
    }
    public void getSumTree(TreeNode25 root, int target, int tmpSum, ArrayList<Integer> list) {
        tmpSum += root.val;
        list.add(root.val);
        //如果是叶子结点，并且路径上结点的和等于目标值
        boolean isLeaf = root.left == null && root.right == null;
        if (tmpSum == target && isLeaf) {
            al.add(new ArrayList<Integer>(list)); //这里要注意呀
        }
        //如果不是叶子结点则遍历它的孩子结点
        if (root.left != null) {
            getSumTree(root.left, target, tmpSum, list);
        }
        if (root.right != null) {
            getSumTree(root.right, target, tmpSum, list);
        }
        //左右子树都为空，且和不等于目标值。栈弹出
        if (!list.isEmpty()) {
            list.remove(list.size() - 1);
        }
    }
}
class TreeNode25 {
    int val = 0;
    TreeNode25 left = null;
    TreeNode25 right = null;
    public TreeNode25(int val) {
        this.val = val;
    }
}