package libin.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Copyright (c) 2019/04/02. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 数组经过变换后，满足这个公式，偶数位都是奇数为的二倍
 */
public class _954_ArrayofDoubledPairs {
    public boolean canReorderDoubled(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int aA : A) {
            if (map.containsKey(aA)) {
                int count = map.get(aA);
                map.put(aA, ++count);
            } else {
                map.put(aA, 1);
            }
        }
        int sum = 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                if (map.get(A[i]) > 0) {

                    if (A[i] > 0) {
                        int tmp = A[i] * 2;
                        if (map.containsKey(tmp)) {
                            int count1 = map.get(tmp);
                            int count2 = map.get(A[i]);
                            if (count1 > 0) {
                                map.put(tmp, --count1);
                                map.put(A[i], --count2);
                                sum++;
                            }
                        }
                    } else if (A[i] == 0) {
                        int tmp = A[i] * 2;
                        if (map.containsKey(tmp)) {
                            int count1 = map.get(tmp);
                            if (count1 > 0) {
                                count1-=2;
                                map.put(tmp, count1);
                                sum++;
                            }
                        }
                    } else {
                        int tmp = A[i] / 2;
                        if (map.containsKey(tmp)) {
                            int count1 = map.get(tmp);
                            int count2 = map.get(A[i]);
                            if (count1 > 0) {
                                map.put(tmp, --count1);
                                map.put(A[i], --count2);
                                sum++;
                            }
                        }

                    }

                }
            }
        }
        if (sum == A.length / 2)
            return true;
        else
            return false;
    }
}
