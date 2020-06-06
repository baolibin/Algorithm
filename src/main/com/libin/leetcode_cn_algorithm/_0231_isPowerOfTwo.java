package libin.leetcode_cn_algorithm;

/**
 * Copyright (c) 2020/5/26. 小彬科技 Inc. All Rights Reserved.
 * Authors: libin <小彬科技>
 * <p>
 * Purpose :    231. 2的幂
 */
public class _0231_isPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        } else {
            while (n % 2 == 0) {
                n = n / 2;
                if (n == 0) {
                    break;
                }
            }
        }
        return n == 1;
    }
}
