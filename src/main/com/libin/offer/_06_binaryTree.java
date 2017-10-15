package libin.offer;

import java.util.Arrays;

/**
 * 面试题6：重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class _06_binaryTree {
    public static void main(String[] args){
        int[] pre={1,2,4,7,3,5,6,8};
        int[] mid={4,7,2,1,5,3,8,6};
        /*int[] pre={1};
        int[] mid={1};*/

        Solution06 solution06 = new Solution06();
        TreeNode treeNode=solution06.reConstructBinaryTree(pre,mid);
        solution06.preOrderTraversal(treeNode);
        System.out.println();
        solution06.inOrderTraversal(treeNode);
    }
}
class Solution06 {
    /*public TreeNode reConstructBinaryTree(int[] pre,int[] in) {
        if(pre==null||in==null||pre.length==0||in.length==0){
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[0]);
        for(int i=0;i<in.length;i++){
            if(pre[0]==in[i]){
                treeNode.left= reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i)); //截取数组左开右毕区间[...)
                treeNode.right= reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return treeNode;
    }*/
    public TreeNode reConstructBinaryTree(int[] pre,int[] in) {
        if(pre==null||in==null){
            return null;
        }
        return createTree(pre,0,pre.length-1,in,0,in.length-1);
    }
    public TreeNode createTree(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd){
        if(preStart>preEnd||inStart>inEnd){
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[preStart]);
        for(int i=inStart;i<=inEnd;i++){
            if(pre[preStart]==in[i]){
                treeNode.left= createTree(pre,preStart+1,preStart+(i-inStart),in,inStart,i-1);
                treeNode.right= createTree(pre,preStart+1+(i-inStart),preEnd,in,i+1,inEnd);
            }
        }
        return treeNode;
    }
    /**
     * 先序遍历
     * @param node 二叉树的根节点
     */
    public void preOrderTraversal(TreeNode node){
        if(node!=null){
            System.out.print(node.value+"、");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
    /**
     * 中序遍历
     * @param node 二叉树的根节点
     */
    public void inOrderTraversal(TreeNode node){
        if(node!=null){
            inOrderTraversal(node.left);
            System.out.print(node.value+"、");
            inOrderTraversal(node.right);
        }
    }
}
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int value) {
        this.value = value;
    }
}


