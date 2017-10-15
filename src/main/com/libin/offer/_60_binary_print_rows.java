package libin.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题60：把二叉树打印成多行 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class _60_binary_print_rows {
	public static void main(String[] args) {
		TreeNode60 treeNode60 = new TreeNode60(1);
		treeNode60.left= new TreeNode60(2);
		treeNode60.right= new TreeNode60(3);
		treeNode60.left.left= new TreeNode60(4);
		
		Solution60 solution60 = new Solution60();
		ArrayList<ArrayList<Integer>> print = solution60.Print(treeNode60);
		for(ArrayList<Integer> a:print){
			for(Integer b:a){
				System.out.print(b+"、");
			}
			System.out.println();
		}
	}
}

class Solution60 {
	ArrayList<ArrayList<Integer>> Print(TreeNode60 pRoot) {
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
		if(pRoot==null){
			return arrayList;
		}
		Queue<TreeNode60> queue=new LinkedList<TreeNode60>();
		ArrayList<Integer> row=new ArrayList<Integer>();
		queue.add(pRoot);
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
			arrayList.add(row);
		}
		return arrayList;
	}
}

class TreeNode60 {
	int val = 0;
	TreeNode60 left = null;
	TreeNode60 right = null;

	public TreeNode60(int val) {
		this.val = val;
	}
}