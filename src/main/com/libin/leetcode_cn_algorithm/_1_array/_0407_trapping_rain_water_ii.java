package libin.leetcode_cn_algorithm._1_array;

import java.util.PriorityQueue;

/**
 * Copyright (c) 2022/4/9. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 * <p>
 * 输入: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
 * 输出: 4
 * 解释: 下雨后，雨水将会被上图蓝色的方块中。总的接雨水量为1+2+1=4。
 * <p>
 * https://leetcode-cn.com/problems/trapping-rain-water-ii/solution/jie-yu-shui-ii-by-leetcode-solution-vlj3/
 */
public class _0407_trapping_rain_water_ii {
	public static void main(String[] args) {
		int[][] heightMap = {{1, 4, 3, 1, 3, 2},
				{3, 2, 1, 3, 2, 4},
				{2, 3, 3, 2, 3, 1}};
		System.out.println(
				new _0407_trapping_rain_water_ii().trapRainWater(heightMap));
	}

	public int trapRainWater(int[][] heightMap) {
		if (heightMap.length <= 2 || heightMap[0].length <= 2) {
			return 0;
		}
		int rows = heightMap.length;
		int columns = heightMap[0].length;
		// 表示某个元素是否计算过
		boolean[][] visit = new boolean[rows][columns];

		// 最小堆，存储每个元素位置接完水之后的高度，从4边框中最小值开始遍历处理
		PriorityQueue<int[]> waters = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (i == 0 || i == rows - 1 || j == 0 || j == columns - 1) {
					waters.offer(new int[]{i * columns + j, heightMap[i][j]});
					visit[i][j] = true;
				}
			}
		}
		// 打印测试waters
		/*while (!waters.isEmpty()) {
			int[] poll = waters.poll();
			for (int i = 0; i < poll.length; i++) {
				// System.out.print(poll[i] + "、");
			}
			// System.out.println("");
		}*/

		// 存储结果数据，能接的所有水大小
		int res = 0;
		// 有点类似于扫雷游戏，当遍历该元素时候，把该元素“上下左右”位置的元素都计算出接完水之后的高度
		int[] dirs = {-1, 0, 1, 0, -1};
		while (!waters.isEmpty()) {
			// 取出元素，从小到大取出
			int[] curr = waters.poll();
			for (int k = 0; k < 4; k++) {
				int curRow = curr[0] / columns + dirs[k];
				int curColumn = curr[0] % columns + dirs[k + 1];
				if (curRow >= 0 && curRow < rows && curColumn >= 0 && curColumn < columns && !visit[curRow][curColumn]) {
					// 接完雨水高度 大于 实际高度
					if (curr[1] > heightMap[curRow][curColumn]) {
						res += curr[1] - heightMap[curRow][curColumn];
					}
					waters.offer(new int[]{curRow * columns + curColumn, Math.max(curr[1], heightMap[curRow][curColumn])});
					visit[curRow][curColumn] = true;
				}
			}
		}
		return res;
	}
}
