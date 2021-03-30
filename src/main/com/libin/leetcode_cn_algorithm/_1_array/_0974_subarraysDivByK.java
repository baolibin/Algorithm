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
    /**
     * 我们令 P[i] = A[0] + A[1] + ... + A[i]。
     * 那么每个连续子数组的和sum(i,j) 就可以写成P[j]−P[i−1]（其中 0 < i < j）的形式。
     * 此时，判断子数组的和能否被 K 整除就等价于判断 (P[j]−P[i−1]) mod K == 0，
     * 根据 同余定理，只要 P[j] mod K == P[i-1] mod K，就可以保证上面的等式成立。
     * <p>
     * 最后的答案即为以每一个位置为数尾的符合条件的子数组个数之和。
     * 需要注意的一个边界条件是，我们需要对哈希表初始化，记录 record[0]=1，这样就考虑了前缀和本身被 K 整除的情况。
     */
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
            // map通过sum[i] % k = sum[j] % k 就可以判断2个前缀和 相减 就可以被K整除
            int tmpCount = map.getOrDefault(mod, 0);
            count += tmpCount;
            map.put(mod, tmpCount + 1);
        }
        return count;
    }
}
