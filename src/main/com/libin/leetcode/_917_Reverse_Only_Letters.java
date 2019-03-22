package libin.leetcode;

import java.util.Arrays;

/**
 * Copyright (c) 2019/03/18. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 反转一个字符串，仅反转字母。
 */
public class _917_Reverse_Only_Letters {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            boolean judgeCharStart = judgeChar(start, chars);
            boolean judgeCharEnd = judgeChar(end, chars);
            if (judgeCharStart && judgeCharEnd) {
                char tmp = chars[end];
                chars[end] = chars[start];
                chars[start] = tmp;
                start++;
                end--;
            } else if (judgeCharStart) end--;
            else start++;
        }
        return String.valueOf(chars);
    }

    private boolean judgeChar(int index, char[] chars) {
        return (chars[index] >= 'a' && chars[index] <= 'z') || (chars[index] >= 'A' && chars[index] <= 'Z');
    }
}
