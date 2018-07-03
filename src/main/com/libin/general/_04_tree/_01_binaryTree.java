package libin.general._04_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树
 */
public class _01_binaryTree {
	public static void main(String[] args) {
		int[] tmpNum={23,6,34,45,9,18,29,5,32,46,65,78,123,498};
		List<tree_Node> list=new ArrayList<tree_Node>();

		tree_Node tree_Node = new tree_Node(); //根节点
		tree_Node.createTree(tree_Node,tmpNum, list); //创建二叉树
		
		/**
		 * 递归遍历部分
		 */
		System.out.println("先序遍历：");
		tree_Node.preOrderTraversal(tree_Node); //先序遍历
		System.out.println("\n");
		System.out.println("中序遍历：");
		tree_Node.inOrderTraversal(tree_Node); //中序遍历
		System.out.println("\n");
		System.out.println("后序遍历：");
		tree_Node.postOrderTraversal(tree_Node); //后序遍历
		System.out.println("\n");
		
		/**
		 * 非递归遍历
		 */
		System.out.println("先序遍历：");
		tree_Node.preOrderTraversalNoR(tree_Node); //先序遍历
		System.out.println("\n");
		
		System.out.println("中序遍历：");
		tree_Node.inOrderTraversalNoR(tree_Node);
		System.out.println("\n");
		
		System.out.println("后序遍历：");
		tree_Node.postOrderTraversalNoR(tree_Node);
		System.out.println("\n");
		
		/**
		 * 二叉树的节点个数和深度
		 */
		int count=tree_Node.countTree(tree_Node);
		System.out.println("二叉树的节点个数为："+count);
		int depth=tree_Node.depthTree(tree_Node);
		System.out.println("二叉树的深度为："+depth);
		//层次遍历
		tree_Node.levelTree(list);
		System.out.println("\n");
		
		/**
		 * 判断两个二叉树是否相同
		 */
		tree_Node tree_Node2=tree_Node;
		if(tree_Node.getDifTree(tree_Node,tree_Node2)){
			System.out.println("两个二叉树相同");
		}else {
			System.out.println("两个二叉树 --不相同");
		}
		System.out.println("\n");
		
		int[] tmpNum3={23,6,34,45,9,18,29,5,32,46,65,78,123,498,25,61,80,38};
		List<tree_Node> list3=new ArrayList<tree_Node>();
		tree_Node tree_Node3 = new tree_Node(); //根节点
		tree_Node3.createTree(tree_Node3,tmpNum3, list3); //创建二叉树
		if(tree_Node.getDifTree(tree_Node,tree_Node3)){
			System.out.println("两个二叉树相同");
		}else {
			System.out.println("两个二叉树 --不相同");
		}
		
		/**
		 * 判断一个元素是否存在
		 */
		System.out.println(tree_Node.getExistTree(tree_Node, 34));
		System.out.println(tree_Node.getExistTree(tree_Node, 111));
	}
}

class tree_Node{
	private tree_Node leftNode;
	private tree_Node rightNode;
	private int data;
	public tree_Node(){
		this.leftNode = null;
		this.rightNode = null;
	}
	public tree_Node(int data){
		this.leftNode = null;
		this.rightNode = null;
		this.data = data;
	}
	/**
	 * 创建二叉树
	 * @param node 根节点
	 * @param tmpNum 数组
	 * @param list 二叉树
	 */
	public void createTree(tree_Node node,int[] tmpNum,List<tree_Node> list){
		node.data=tmpNum[0]; //设置根节点存储的数据
		list.add(node); //根节点添加到数中
		for(int i=0;i<tmpNum.length/2;i++){
			list.get(i).leftNode=new tree_Node(tmpNum[2*i+1]); //添加左孩子
			list.add(list.get(i).leftNode);
			if(i==(tmpNum.length/2-1)&&(tmpNum.length%2)==0){ //判断最后一个父节点是否有右节点
				list.get(i).rightNode=null;
				break;
			}
			list.get(i).rightNode=new tree_Node(tmpNum[2*i+2]); //添加右孩子
			list.add(list.get(i).rightNode);
		}
	}
	/**
	 *   ||||||||| 递归部分 ||||||||||
	 */
	/**
	 * 先序遍历
	 * @param node 二叉树的根节点
	 */
	public void preOrderTraversal(tree_Node node){
		if(node!=null){
			System.out.print(node.data+"、");
			preOrderTraversal(node.leftNode);
			preOrderTraversal(node.rightNode);
		}
	}
	/**
	 * 中序遍历
	 * @param node 二叉树的根节点
	 */
	public void inOrderTraversal(tree_Node node){
		if(node!=null){
			inOrderTraversal(node.leftNode);
			System.out.print(node.data+"、");
			inOrderTraversal(node.rightNode);
		}
	}
	/**
	 * 后序遍历
	 * @param node 二叉树根节点
	 */
	public void postOrderTraversal(tree_Node node){
		if(node!=null){
			postOrderTraversal(node.leftNode);
			postOrderTraversal(node.rightNode);
			System.out.print(node.data+"、");
		}
	}
	/**
	 *   ||||||||| 非递归部分 ||||||||||
	 *   先序遍历
	 */
	public void preOrderTraversalNoR(tree_Node node){
		Stack<tree_Node> stack=new Stack<tree_Node>();
		while (node!=null||stack.size()>0) {
			while (node!=null) {
				System.out.print(node.data+"、");
				stack.push(node);
				node=node.leftNode;
			}
			node=stack.pop();
			node=node.rightNode;
		}
	}
	/**
	 * 非递归 中序遍历
	 * @param node
	 */
	public void inOrderTraversalNoR(tree_Node node){
		Stack<tree_Node> stack=new Stack<tree_Node>();
		while (node!=null||stack.size()>0) {
			while (node!=null) {
				stack.push(node);
				node=node.leftNode;
			}
			while (stack.size()>0) {
				node=stack.pop();
				System.out.print(node.data+"、");
				node=node.rightNode;
				while (node!=null) {
					stack.push(node);
					node=node.leftNode;
				}
			}
		}
	}
	/**
	 * 非递归 倒叙遍历
	 */
	public void postOrderTraversalNoR(tree_Node node){
		Stack<tree_Node> stack=new Stack<tree_Node>();
		tree_Node curremtNode=node;
		while (node!=null||stack.size()>0) {
			while (node.leftNode!=null) {
				stack.push(node);
				node=node.leftNode;
			}
			while (node!=null&&(node.rightNode==curremtNode||node.rightNode==null)) {
				curremtNode=node;
				System.out.print(node.data+"、");
				if(stack.isEmpty()){
					return;
				}
				node=stack.pop();
			}
			stack.push(node);
			node=node.rightNode;
		}
	}
	/**
	 * 统计节点个数
	 */
	public int countTree(tree_Node node){
		if(node==null){
			return 0;
		}
		return 1+countTree(node.leftNode)+countTree(node.rightNode);
	}
	/**
	 * 数的深度
	 */
	public int depthTree(tree_Node node){
		if(node==null){
			return 0;
		}
		int left=depthTree(node.leftNode);
		int right=depthTree(node.rightNode);
		return left<right?(right+1):(left+1);
	}
	/**
	 * 层次遍历
	 */
	public void levelTree(List<tree_Node>list){
		for (tree_Node node : list) {
			System.out.print(node.data+"、");
		}
	}
	/**
	 * 判断两个二叉树是否相同
	 */
	public boolean getDifTree(tree_Node node1,tree_Node node2){
		if(node1==null&&node2==null){
			return true;
		}
		if(node1!=null&&node2!=null&&node1.data==node2.data){
			if(getDifTree(node1.leftNode,node2.leftNode)&&getDifTree(node1.rightNode,node2.rightNode)){
				return true;
			}
		}
		
		return false;
	}
	/**
	 * 判断一个元素是否存在
	 */
	public boolean getExistTree(tree_Node node,int index){
		if(node==null){
			return false;
		}
		if(node.data==index){
			return true;
		}
		if(getExistTree(node.leftNode,index)||getExistTree(node.rightNode,index)){
			return true;
		}
		return false;
	}
}