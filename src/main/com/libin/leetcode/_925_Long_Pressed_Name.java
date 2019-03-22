package libin.leetcode;

/**
 * Copyright (c) 2019/03/20. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 遍历数组，先添加偶数，再添加奇数
 */
public class _925_Long_Pressed_Name {
    public static void main(String[] args) {
        int[] tmp = {3, 4};
        int[] array = new _925_Long_Pressed_Name().sortArrayByParityII(tmp);
        for (int arr : array) {
            System.out.print(arr + "\t");
        }
    }

    public int[] sortArrayByParityII(int[] A) {
        int[] ints = new int[A.length];
        int even = 0;
        int odd = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                ints[even] = A[i];
                even += 2;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 != 0) {
                ints[odd] = A[i];
                odd += 2;
            }
        }
        return ints;
    }
}
