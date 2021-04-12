package libin.leetcode_cn_algorithm;

/**
 * Copyright (c) 2021/4/1. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * Purpose : 168. Excel表列名称
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * 例如，
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * 示例 1:
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 * 输入: 701
 * 输出: "ZY"
 */
public class _0168_convertToTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        if (columnNumber < 0) {
            return res.toString();
        }
        while (columnNumber > 0) {
            columnNumber--;
            res.insert(0, (char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return res.toString();

    }
}
