package libin.leetcode_cn_algorithm._4_tree;

/**
 * Copyright (c) 2021/4/13. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 */
public class _0297_Codec {
	// Encodes a tree to a single string.
	public String Serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		Serialize2(root, sb);
		return sb.toString();
	}

	void Serialize2(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("$,");
			return;
		}
		sb.append(root.val);
		sb.append(",");
		Serialize2(root.left, sb);
		Serialize2(root.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode Deserialize(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		return Deserialize2(str.split(","));
	}

	int index = -1;

	TreeNode Deserialize2(String[] str) {
		index++;
		if (!"$".equals(str[index])) {
			TreeNode result = new TreeNode(Integer.parseInt(str[index]));
			result.left = Deserialize2(str);
			result.right = Deserialize2(str);
			return result;
		}
		return null;
	}
}
