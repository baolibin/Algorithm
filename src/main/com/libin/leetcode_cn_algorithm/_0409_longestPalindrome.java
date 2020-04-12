package libin.leetcode_cn_algorithm;

/**
 * Copyright (c) 2020/4/12. libin Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 示例 1:
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class _0409_longestPalindrome {
    public int longestPalindrome(String s) {
        int[] count = new int[128];  // 把所有字符存储在一个int数组里面
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            count[chars[i]]++;
        }
        int res = 0;
        for (int i = 0; i < 127; i++) {
            if (count[i] % 2 == 0) {  // 当前字符出现个数为偶数时
                res += count[i];
            } else if (count[i] % 2 == 1 && res % 2 == 0) {  // 当前字符出现个数为奇数时，且目前总长度为偶数
                res += count[i];
            } else {
                res += count[i] / 2 * 2;  // 当前字符出现个数为奇数时
            }
        }
        return res;
    }
}
