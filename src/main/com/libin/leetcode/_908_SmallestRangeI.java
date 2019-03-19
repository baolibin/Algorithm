package libin.leetcode;

/**
 * Copyright (c) 2019/03/18. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 给定一个数组和一个K值，数组元素加上任一一个X，X值满足-K<=X<=K
 *           得到一个新数组，求数组最大值减去最小值 最小的差值
 */
public class _908_SmallestRangeI {
    public int smallestRangeI(int[] A, int K) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int aA : A) {
            if (aA > max) max = aA;
            if (aA < min) min = aA;
        }
        return max - min - 2 * K > 0 ? max - min - 2 * K : 0;
    }
}
