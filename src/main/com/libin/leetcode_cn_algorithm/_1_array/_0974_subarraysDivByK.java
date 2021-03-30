package libin.leetcode_cn_algorithm._1_array;

import java.util.HashMap;

/**
 * Copyright (c) 2021/3/29. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 和可被 K 整除的子数组
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * 示例：
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 */
public class _0974_subarraysDivByK {
    // 对于 A 中前 i 个数的和，记录为 sum[i] ，那么根据同余定理有：
    //(sum[i] - sum[j]) % k = 0 等价于 sum[i] % k = sum[j] % k
    public int subarraysDivByK(int[] A, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 对于下标为0的元素，前缀和为0，元素为1
        map.put(0, 1);
        int preSum = 0, count = 0;
        for (int num : A) {
            preSum += num;
            int mod = (preSum % K + K) % K;
            int tmpCount = map.getOrDefault(mod, 0);
            count += tmpCount;
            map.put(mod, tmpCount + 1);
        }
        return count;
    }
}
