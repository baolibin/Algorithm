package libin.leetcode_cn_algorithm;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Copyright (c) 2020/5/26. 小彬科技 Inc. All Rights Reserved.
 * Authors: libin <小彬科技>
 * <p>
 * Purpose : 219. 存在重复元素 II
 */
public class _0216_containsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                return true;
            }
            hashSet.add(nums[i]);
            if (hashSet.size() > k) {
                hashSet.remove(nums[i - k]);
            }
        }
        return false;
    }
}
