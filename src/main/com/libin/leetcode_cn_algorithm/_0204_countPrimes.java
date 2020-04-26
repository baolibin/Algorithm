package libin.leetcode_cn_algorithm;

import java.util.BitSet;

/**
 * Copyright (c) 2020/4/26. libin Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class _0204_countPrimes {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        BitSet res = new BitSet(n);
        for (int i = 2; i * i < n; i++) {  // 外循环
            if (!res.get(i)) {
                for (int j = i * i; j < n; j += i) {  // 内循环
                    res.set(j);
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {  // 统计质数的个数
            if (!res.get(i)) count++;
        }
        return count;
    }
}
