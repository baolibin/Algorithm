package libin.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题61：按之字形顺序打印二叉树
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class _61_font {
	public static void main(String[] args) {
		TreeNode61 treeNode61 = new TreeNode61(1);
		treeNode61.left= new TreeNode61(2);
		treeNode61.right= new TreeNode61(3);
		treeNode61.left.left= new TreeNode61(4);
		
		Solution61 solution61 = new Solution61();
		ArrayList<ArrayList<Integer>> print = solution61.Print(treeNode61);
		for(ArrayList<Integer> a:print){
			for(Integer b:a){
				System.out.print(b+"、");
			}
			System.out.println();
		}
	}
}

class Solution61 {
	public ArrayList<ArrayList<Integer>> Print(TreeNode61 pRoot) {
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null) {
			return arrayList;
		}
		Queue<TreeNode61> queue=new LinkedList<TreeNode61>();
		ArrayList<Integer> row=new ArrayList<Integer>();
		queue.add(pRoot);
		boolean flag=false;
		while(!queue.isEmpty()){
			row=new ArrayList<Integer>(); //每次重新生成一个对象
			int len=queue.size();
			row.clear();
			for(int i=0;i<len;i++){  //遍历一层节点
				if(queue.peek().left!=null){
					queue.add(queue.peek().left);
				}
				if(queue.peek().right!=null){
					queue.add(queue.peek().right);
				}
				row.add(queue.poll().val);
			}
			if(flag){
				Collections.reverse(row);
				flag=false;
			}else{
				flag=true;;
			}
			arrayList.add(row);
		}
		
		return arrayList;
	}
}
class TreeNode61 {
	int val = 0;
	TreeNode61 left = null;
	TreeNode61 right = null;
	public TreeNode61(int val) {
		this.val = val;
	}
}
