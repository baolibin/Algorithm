package libin.leetcode_cn_algorithm;

import java.util.HashSet;

/**
 * Copyright (c) 2021/4/1. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * Purpose : 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 * 示例 1：
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 */
public class _0202_isHappy {
    /**
     * 有以下三种可能。
     * 最终会得到 1。
     * 最终会进入循环。
     * 值会越来越大，最后接近无穷大。
     */
    public boolean isHappy(int n) {
        HashSet<Integer> integers = new HashSet<>();
        while (n != 1 && !integers.contains(n)) {
            integers.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int num = n % 10;
            sum += num * num;
            n /= 10;
        }
        return sum;
    }
}
