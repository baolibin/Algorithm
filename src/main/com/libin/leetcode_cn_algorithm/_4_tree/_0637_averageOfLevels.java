package libin.leetcode_cn_algorithm._4_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Copyright (c) 2020/5/17. 小彬科技 Inc. All Rights Reserved.
 * Authors: libin <小彬科技>
 * <p>
 * Purpose :    637. 二叉树的层平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 * 示例 1:
 * 输入:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * 注意：
 * 节点值的范围在32位有符号整数范围内。
 */
public class _0637_averageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<Double>();
        if (root == null) return list;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int len = nodes.size();
            Long sum = 0L;
            int curLen = len;
            while (curLen-- > 0) {
                TreeNode pollFirst = nodes.pollFirst();
                sum += pollFirst.val;
                if (pollFirst.left != null) nodes.addLast(pollFirst.left);
                if (pollFirst.right != null) nodes.addLast(pollFirst.right);
            }
            list.add(sum * 1.0 / len);
        }
        return list;
    }
}
