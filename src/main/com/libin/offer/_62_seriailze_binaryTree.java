package libin.offer;
/**
 * 面试题62：序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
import java.lang.StringBuilder;
public class _62_seriailze_binaryTree {
    public static void main(String[] args) {
        TreeNode62 treeNode62 = new TreeNode62(1);
        treeNode62.left = new TreeNode62(2);
        treeNode62.right = new TreeNode62(3);

        Solution62 solution62 = new Solution62();
        String serialize = solution62.Serialize(treeNode62);
        System.out.println(serialize);
    }
}
class Solution62 {
    String Serialize(TreeNode62 root) {
        if(root==null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Serialize2(root,sb);
        return sb.toString();
    }
    void Serialize2(TreeNode62 root,StringBuilder sb) {
        if (root == null) {
            sb.append("$,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        Serialize2(root.left,sb);
        Serialize2(root.right,sb);
    }
    TreeNode62 Deserialize(String str) {
        if(str==null||str.length()==0){
            return null;
        }
        return Deserialize2(str.split(","));
    }
    int index=-1;
    TreeNode62 Deserialize2(String[] str) {
        index++;
        if(!"$".equals(str[index])){
            TreeNode62 result=new TreeNode62(Integer.parseInt(str[index]));
            result.left=Deserialize2(str);
            result.right=Deserialize2(str);;
            return result;
        }
        return null;
    }
}

class TreeNode62 {
    int val = 0;
    TreeNode62 left = null;
    TreeNode62 right = null;
    public TreeNode62(int val) {
        this.val = val;
    }
}