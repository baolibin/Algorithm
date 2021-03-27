package libin.leetcode_cn_algorithm._1_array;

/**
 * Copyright (c) 2021/3/27. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 将该问题转换为0-1背包问题。
 * 有一堆石头，每块石头的重量都是正整数。
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头最小的可能重量。如果没有石头剩下，就返回 0。
 * 示例：
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 */
public class _1049_lastStoneWeightII {
	// dp[j] = max(dp[j], dp[j - stones[i]] + stones[i])
	public int lastStoneWeightII(int[] stones) {
		// dp[i]表示容量为i的背包，能装下的最大重量（价值）。
		int[] dp = new int[30 * 1000 / 2];
		int sum = 0;
		for (int i = 0; i < stones.length; i++) {
			sum += stones[i];
		}
		int target = sum / 2;
		// 遍历物品，装i个物品
		for (int i = 0; i < stones.length; i++) {
			// 遍历背包容量，容量j的背包的最大重量（价值）。
			for (int j = target; j >= stones[i]; j--) {
				// 背包装进物品i的价值：背包减去容量，加上价值，dp[j - stones[i]] + stones[i]
				dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
			}
		}
		// sum - dp[target] > dp[target]
		return sum - dp[target] - dp[target];
	}
}
