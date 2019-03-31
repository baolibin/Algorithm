package libin.leetcode;

import java.util.Collections;

/**
 * Copyright (c) 2019/03/25. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 先水平翻转一个图像，再反转整个图像
 */
public class _832_Flipping_an_Image {
    public int[][] flipAndInvertImage(int[][] A) {
        int len = A[0].length;
        for (int i = 0; i < A.length; i++) {
            int start = 0;
            int end = len - 1;
            while (start <= end) {
                int tmp = A[i][start];
                A[i][start] = 1 - A[i][end];
                A[i][end] = 1 - tmp;
                start++;
                end--;
            }
        }
        return A;
    }
}
