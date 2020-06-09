package libin.leetcode_cn_algorithm;

/**
 * Copyright (c) 2020/5/27. 小彬科技 Inc. All Rights Reserved.
 * Authors: libin <小彬科技>
 * <p>
 * Purpose :    263. 丑数
 */
public class _0263_isUgly {
    public boolean isUgly(int num) {
        int[] factor = {2, 3, 5};
        if (num == 0) return false;
        for (int i = 0; i < factor.length; i++) {
            while (num % factor[i] == 0) {
                num = num / factor[i];
            }
        }
        if (num == 1) {
            return true;
        }
        return false;
    }
}
