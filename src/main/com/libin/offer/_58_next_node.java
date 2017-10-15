package libin.offer;

/**
 * 面试题58：二叉树的下一个节点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class _58_next_node {
    public static void main(String[] args){

    }
}
class Solution58 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode==null){
            return null;
        }
        TreeLinkNode pResultNext=null;
        if(pNode.right!=null){   //当前节点的右节点不为空时
            TreeLinkNode pRight=pNode.right;
            while(pRight.left!=null){
                pRight=pRight.left;
            }
            pResultNext=pRight;
        }else if(pNode.next!=null){
            TreeLinkNode pCurrent=pNode;  //当前节点无右节点，且当下一个节点是父节点的时候
            TreeLinkNode pParent=pNode.next;
            while(pParent!=null&&pCurrent==pParent.right){     //当前节点无右节点，且是父节点的右节点
                pCurrent=pParent;
                pParent= pParent.next;
            }
            pResultNext=pParent;
        }
        return pResultNext;
    }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
