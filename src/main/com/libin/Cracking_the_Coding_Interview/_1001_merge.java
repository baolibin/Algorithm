package libin.Cracking_the_Coding_Interview;

/**
 * Copyright (c) 2020/4/18. libin Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 面试题 10.01. 合并排序的数组
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * <p>
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * 说明:
 * <p>
 * A.length == n + m
 */
public class _1001_merge {
    public void merge(int[] A, int m, int[] B, int n) {
        int aLen = m - 1;
        int bLen = n - 1;
        int cur = m + n - 1;
        while (bLen >= 0) {
            if (aLen >= 0 && bLen >= 0) {
                if (A[aLen] > B[bLen]) {
                    A[cur--] = A[aLen--];
                } else {
                    A[cur--] = B[bLen--];
                }
            } else if (bLen >= 0) {
                A[cur--] = B[bLen--];
            }
        }
    }
}
