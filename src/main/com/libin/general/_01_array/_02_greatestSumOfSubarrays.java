package libin.general._01_array;

/**
 * Copyright (c) 2018/7/8. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 连续最大子数组和
 * <p>
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 你会不会被他忽悠住？(子向量的长度至少是1)
 */

public class _02_greatestSumOfSubarrays {
    public static void main(String[] args) {
        int[] ints = {2, 3, -4, 2, 6, -2, 5, 1};
        int sumOfSubArray = new _02_greatestSumOfSubarrays().FindGreatestSumOfSubArray(ints);
        System.out.println(sumOfSubArray);

        int sumOfSubArrayDp = new _02_greatestSumOfSubarrays().FindGreatestSumOfSubArrayDp(ints);
        System.out.println(sumOfSubArrayDp);
    }

    /**
     * 贪心法
     *
     * @param array 输入的数组
     * @return 返回最大连续子数组和
     */
    int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int maxNum = 0;
        int tmpNum = array[0];
        int minNum = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            if (minNum < array[i]) {
                minNum = array[i];
            }
            if (tmpNum < 0) {
                tmpNum = array[i];
            } else {
                tmpNum += array[i];
            }
            if (maxNum < tmpNum) {
                maxNum = tmpNum;
            }
        }
        if (minNum < 0) {  // 对于数组全是负数处理方法
            return minNum;
        }
        return maxNum;
    }

    /**
     *  DP算法
     * @param array  传入数组
     * @return  返回连续最大值
     */
    int FindGreatestSumOfSubArrayDp(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int[] dp = new int[array.length];
        for (int i = 0; i < array.length; i++)
            dp[i] = 0;
        dp[0] = array[0];
        int max_dp = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            if (dp[i - 1] < 0) dp[i] = array[i];
            else dp[i] = dp[i - 1] + array[i];
            if (dp[i] > max_dp) max_dp = dp[i];
        }
        return max_dp;
    }
}
