package libin.leetcode_cn_algorithm._3_character;

/**
 * Copyright (c) 2020/4/12. libin Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class _0009_isPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int index = 1;
        int tmp = x;
        while (tmp >= 10) {
            index = index * 10; // 10^(x.toString.length)
            tmp = tmp / 10;
        }
        int left = 0;
        int right = 0;
        while (index > 0) {
            left = x / index; // 取x的首位
            right = x % 10;  // 去x的尾位
            System.out.println(x + "|" + left + "|" + right + "|" + index);
            if (left != right) {
                return false;
            }
            x = x % index / 10; // 掐头去尾
            index = index / 100; // 去掉2位
        }
        return true;
    }
}
