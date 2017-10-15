package libin.offer;


/**
 * 面试题59：对称的二叉树 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class _59_symmetry {
	public static void main(String[] args) {

	}
}

class TreeNode59 {
	int val = 0;
	TreeNode59 left = null;
	TreeNode59 right = null;

	public TreeNode59(int val) {
		this.val = val;

	}
}

class Solution59 {
	boolean isSymmetrical(TreeNode59 pRoot) {
		if (pRoot == null) {
			return true;
		}
		return isSymmetrical(pRoot,Mirror(pRoot));
	}
	boolean isSymmetrical(TreeNode59 pRoot1,TreeNode59 pRoot2) {
		if(pRoot1==null&&pRoot2==null){
			return true;
		}
		if(pRoot1==null||pRoot2==null){
			return false;
		}
		if(pRoot1.val==pRoot2.val){
			return isSymmetrical(pRoot1.left,pRoot2.left)&&isSymmetrical(pRoot1.right,pRoot2.right);
		}
		return false;
	}

	public TreeNode59 Mirror(TreeNode59 root) {
		if (root == null) {
			return null;
		}
		TreeNode59 tmp =new TreeNode59(root.val); //复制出一个新的镜像树
		tmp.left = Mirror(root.right);
		tmp.right = Mirror(root.left);
		return tmp;
	}
}
