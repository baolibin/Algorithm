package libin.leetcode;

/**
 * Copyright (c) 2019/04/22. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 一个二维的二进制数组，返回只包含1的最大矩形面积
 * <p>
 * 数组 left：当前元素可以延伸到最左边元素的下标，
 * 数组 right：当前元素可以延伸到最右边元素的下标，
 * 数组height：统计当前位置以上1的个数
 * 当前值为1，则cur_left和cur_right数组都不变，当前值为0，则cur_left=i+1,cur_right=i。
 * <p>
 * dp[i][j]处最大子矩阵面积 (right[i][j]-left[i][j])*height[i][j]
 * <p>
 * left[i][j]=max(left[i-1][j],cur_left)
 * right[i][j]=min(right[i-1][j],cur_right)
 * 当前值为1  height[i][j]=height[i][j-1]+1
 * 当前值为0  height[i][j]=0
 */
public class _85_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int column = matrix.length;
        int row = matrix[0].length;

        int[] left = new int[row];
        int[] right = new int[row];
        int[] height = new int[row];
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            left[i] = 0;
            right[i] = row;
            height[i] = 0;
        }
        for (int i = 0; i < column; i++) {
            int cur_left = 0, cur_right = row;
            for (int j = 0; j < row; j++) {  // 当前一行每个元素上面1的高度
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }
            for (int j = 0; j < row; j++) { // 当前行每个元素能延伸到最左边的元素下标
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], cur_left);
                } else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            for (int j = row - 1; j >= 0; j--) { // 当前行每个元素能延伸到最右边的元素下标
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], cur_right);
                } else {
                    right[j] = row;
                    cur_right = j;
                }
            }
            for (int j = 0; j < row; j++) { // 当前行的最大覆盖1的矩阵面积
                maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
                System.out.println(maxArea);
            }
        }
        return maxArea;
    }
}
