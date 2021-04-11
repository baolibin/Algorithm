package libin.leetcode_cn_algorithm._1_array;

/**
 * Copyright (c) 2021/4/11. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class _0136_singleNumber {
	public int singleNumber(int[] nums) {
		int single = 0;
		// 0⊕0=0,1⊕0=1,0⊕1=1,1⊕1=0(同为0,异为1)
		for (int num : nums) {
			single ^= num;
		}
		return single;
	}
}
